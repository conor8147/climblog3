package com.example.climblog3.presentation.logbook

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.climblog3.data.AppRepository
import com.example.climblog3.domain.Climb
import com.example.climblog3.domain.ClimbStyle
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LogbookViewModel @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {
    private val allClimbs: Flow<List<Climb>> = repository.allClimbs

    val nameTextState = mutableStateOf("")
    val cragTextState = mutableStateOf("")
    val gradeTextState = mutableStateOf("")
    val styleTextState = mutableStateOf("")
    val starsState = mutableStateOf(0)

    var bottomSheetOpened by mutableStateOf(false)

    val climbsByGrade: Flow<Map<String, List<Climb>>> = repository.allClimbs.map { climbs ->
        climbs.groupBy { it.grade }
            .toSortedMap()
    }

    fun addClimbClicked() {
        bottomSheetOpened = true
    }

    fun addClimb() {
        bottomSheetOpened = false
        val climb = Climb(
            name = nameTextState.value,
            crag = cragTextState.value,
            grade = gradeTextState.value,
            style = ClimbStyle.REDPOINT, // TODO: fix this
        )
        if (climb.validate()) {
            insert(climb)
        } else {
            // Throw error
        }
    }

    fun insert(climb: Climb) = viewModelScope.launch {
        repository.insert(climb)
    }

    private fun delete(climb: Climb) = viewModelScope.launch {
        repository.delete(climb)
    }

    suspend fun clear() {
        repository.clear()
    }

    private fun Climb.validate(): Boolean {
        return grade != "" && name != "" && crag != ""
    }
}