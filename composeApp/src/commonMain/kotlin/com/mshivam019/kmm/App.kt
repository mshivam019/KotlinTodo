package com.mshivam019.kmm

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.TextFieldValue
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.skia.impl.Stats.enabled
import org.jetbrains.skia.impl.Stats.enabled

@Composable
@Preview
fun App() {
    var showContent by remember { mutableStateOf(false) }
    var todoList by remember { mutableStateOf(listOf<String>()) }
    var taskInput by remember { mutableStateOf(TextFieldValue("")) }
    val shape = RoundedCornerShape(2.dp)
    val borderModifier =  Modifier.border(1.dp, Color.Black, shape)

    MaterialTheme {
        Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }

            AnimatedVisibility(showContent) {
                Column(
                    Modifier.fillMaxSize().padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Compose Multiplatform To-Do App", style = MaterialTheme.typography.h6)

                    Spacer(modifier = Modifier.height(16.dp))

                    // Text field for adding a new task
                    BasicTextField(
                        value = taskInput,
                        onValueChange = { taskInput = it },

                        modifier =  borderModifier.background(
                            color = TextFieldDefaults.textFieldColors().backgroundColor(enabled).value,
                            shape = shape,
                        ).padding(8.dp).fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // Button to add task
                    Button(
                        onClick = {
                            if (taskInput.text.isNotBlank()) {
                                todoList = todoList + taskInput.text
                                taskInput = TextFieldValue("") // Reset the input
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Add Task")
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Display the tasks
                    Column(Modifier.fillMaxWidth()) {
                        todoList.forEach { task ->
                            TaskItem(task = task) {
                                todoList = todoList - task // Remove task
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TaskItem(task: String, onRemove: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(task, Modifier.weight(1f))
        Button(onClick = onRemove) {
            Text("Remove")
        }
    }
}
