package com.example.basicstatecodelab.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.basicstatecodelab.ui.WellnessTaskItem


private fun getWellnessTasks() = List(30) {i -> WellnessTasks(i, "Task # $i")}

@Composable
fun WellnessTasksLists(
    list: List<WellnessTasks>,
    onCheckedTask: (WellnessTasks, Boolean) -> Unit,
    onCloseTask: (WellnessTasks) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(
            items = list,
            key = { task -> task.id }
        ) { task ->
            WellnessTaskItem(
                taskName = task.label,
                checked = task.checked,
                onCheckedChange = { checked -> onCheckedTask(task, checked) },
                onClose = { onCloseTask(task) }
            )
        }
    }
}













