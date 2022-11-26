package com.example.Compose2022

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.Compose2022.ui.theme.Compose2022Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose2022Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   val items = IntRange(0, 1000)
                   val messages = items.map { 
                       Message(
                           name = "Sachi $it",
                           message = "Hello there Sachi $it\nHello there Sachi $it\nHello there Sachi $it\nHello there Sachi $it"
                       )
                   }
                    Conversations(messages = messages)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Compose2022Theme {
        Greeting("Android")
    }
}

@Composable
fun textViewCompose(name: String) {
    Text("Hello $name!")
}

@Preview
@Composable
fun previewTextViewCompose() {
    textViewCompose(name = "Philip Jan!")
}

data class Message(val name: String, val message: String)


@Composable
fun Conversations(messages: List<Message>) {
    LazyColumn() {
        messages.map { 
            item {
                MessageCard(msg = it)
            }
        }
    }
}

@Composable
fun MessageCard(msg: Message) {
    Compose2022Theme() {
        Row(modifier = Modifier
            .padding(3.dp)) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "launcher bg",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(2.dp, MaterialTheme.colors.background, CircleShape)
            )

            Spacer(modifier = Modifier
                .padding(4.dp))

            var isExpanded by remember { mutableStateOf(false) }

            Column(
                modifier = Modifier
                    .padding(2.dp)
                    .clickable {
                        isExpanded = !isExpanded
                    }
            ) {
                Text(
                    text = msg.name,
                    style = MaterialTheme.typography.body1
                )

                Spacer(modifier = Modifier.height(3.dp))

                Surface(
                    shape = MaterialTheme.shapes.medium,
                    elevation = 2.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "${msg.message}",
                        style = MaterialTheme.typography.subtitle2,
                        modifier = Modifier
                            .padding(16.dp),
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun MessageCardPreview() {
    MessageCard(msg = Message("PhilipJ", "Dvo 7"))
}