package com.example.Compose2022

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
                   MessageCard(msg = Message(
                       name = "Philip Jan Baruis",
                       address = "Davao City"
                   ))
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

data class Message(val name: String, val address: String)

@Composable
fun MessageCard(msg: Message) {
    Row(modifier = Modifier
        .padding(3.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "launcher bg",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier
            .padding(4.dp))

        Column() {
            Text(text = "Name: ${msg.name}")
            Text(text = "Address: ${msg.address}")
        }
    }
}

@Preview
@Composable
fun MessageCardPreview() {
    MessageCard(msg = Message("PhilipJ", "Dvo 7"))
}