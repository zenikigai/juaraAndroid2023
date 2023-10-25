package com.example.basicstatecodelab.ui
import WellnessViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel



@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column(
        modifier = modifier
    ) {
        StatefullCounter()
        val list = remember {
            getWellnessTask().toMutableStateList()
        }

        WellnessTasksLists(
            list = wellnessViewModel.tasks,
            onCheckedTask = { task , checked ->
                wellnessViewModel.changeTaskChecked(task, checked)
            },
            onCloseTask = { task ->
                wellnessViewModel.remove(task)
            }
        )
    }
}

private fun getWellnessTask(): List<WellnessTasks> = List(30) { i ->
    WellnessTasks(i, "Task # $i")
}
