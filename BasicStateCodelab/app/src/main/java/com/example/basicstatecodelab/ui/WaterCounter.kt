
package com.example.basicstatecodelab.ui
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun StatefullCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable {
        mutableStateOf(0)
    }
    StatelessCounter(count, { count++ })
}

@Composable
fun StatelessCounter(
//    modifier: Modifier = Modifier,
    count: Int,
    onIncrement: () -> Unit
    ) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        if (count > 0){
            Text("You've had $count glasses")
        }
        Button(
            onClick = { onIncrement() },
            Modifier.padding(top = 8.dp),
            enabled = count < 10
            ) {
                Text("Add One")
        }
    }

    /*Column(
        modifier = modifier.padding(16.dp)
    ) {
        var count by remember {
            mutableStateOf(0)
        }
        if(count > 0){
            var showTask by remember {
                mutableStateOf(true)
            }
            if (showTask) {
                WellnessTaskItem(
                    taskName = "Have You Take a 15 minutes Walk Today?",
                    onClose = { showTask = false}
                )
            }
            Text("You've had $count glasses", modifier = modifier.padding(26.dp))
        }


        Row(Modifier.padding(top = 8.dp))
        {
            Button(
                onClick = { count++ },
                enabled = count < 10
            ) {
                Text("Add one")
            }
            Button(
                onClick = { count = 0 },
                modifier = Modifier
                    .padding(start = 8.dp)
                    .wrapContentSize()  // Tombol hanya akan memiliki ukuran yang diperlukan oleh teks
            ) {
                Text("Clear Water Count?")
            }
        }
    }*/
}
