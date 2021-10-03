package com.example.climblog3.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.climblog3.data.AppRepository
import com.example.climblog3.domain.Climb
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class LogbookViewModel @Inject constructor(
    private val repository: AppRepository
): ViewModel() {
    private val allClimbs: Flow<List<Climb>> = repository.allClimbs

    val climbsByGrade: Flow<Map<String, List<Climb>>> = repository.allClimbs.map { climbs ->
        climbs.groupBy { it.grade }
            .toSortedMap()
    }

    fun addClimb() {
        // Open Bottom Sheet for input
    }

    fun insert(climb: Climb) = viewModelScope.launch {
        repository.insert(climb)
    }

    fun delete(climb: Climb) = viewModelScope.launch {
        repository.delete(climb)
    }

    suspend fun clear() { repository.clear() }
}