package com.example.climblog3.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.climblog3.data.testClimbs
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel : LogbookViewModel by viewModels()

    init {
        lifecycleScope.launchWhenCreated {
            populateDb(viewModel)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainApp {
                LogbookScreen()
            }
        }
    }
}

private suspend fun populateDb(viewModel: LogbookViewModel) {
    viewModel.clear()
    testClimbs.forEach {
        viewModel.insert(it)
    }
}