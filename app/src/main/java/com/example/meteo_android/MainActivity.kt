package com.example.meteo_android

import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.view.MotionEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meteo_android.ui.theme.Meteo_androidTheme
import java.net.URL
import java.util.Random


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: this is very bad - adding it as a stopgap while learning
        val gfgPolicy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(gfgPolicy)

        enableEdgeToEdge()
        setContent {
            Meteo_androidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Cheeseday")
                }
            }
        }
    }

    override fun onUserInteraction() {
        super.onUserInteraction()

        setContent {
            Meteo_androidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val greet = greet();
                    Greeting("OUE $greet")
                }
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val ote = super.onTouchEvent(event)
        var apiResponse = "NODATA"
        try {
            apiResponse = URL("http://10.0.2.2:8000/api/v1/forecast/cities").readText()
        } catch (e: Exception) {
            // https://stackoverflow.com/questions/67771324/kotlin-networkonmainthreadexception-error-when-trying-to-run-inetaddress-isreac
            println(e)
            println(e.message)
        } finally {
            // optional finally block
        }

        setContent {
            Meteo_androidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(apiResponse)
                }
            }
        }
        return ote
    }

    private fun greet(): String {
        val firstWord = if (Random().nextBoolean()) "Birthday" else "Bday"
        return firstWord
    }
}

@Composable
fun Greeting(text: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(8.dp)
            .background(Color.Red)
    ) {
        Row(
            modifier = modifier
                .padding(8.dp)
                .background(Color.Magenta)
        ) {
            Text(
                text = "19°",
                fontSize = 150.sp,
                lineHeight = 300.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth(1.0f)
                    .background(Color.Green)
            )
        }
        Row {
            Text(
                text = "24h weather graph",
                fontSize = 60.sp,
                lineHeight = 120.sp,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(1.0f)
                    .background(Color.Yellow)
            )
        }
        Column (
            modifier = modifier
                .padding(8.dp)
                .background(Color.Cyan)
        ) {
            Row {
                Text(
                    text = "1r from $text",
                    fontSize = 40.sp,
                    lineHeight = 80.sp,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(1.0f)
                        .background(Color.Yellow)
                )
            }
            Row {
                Text(
                    text = "2r from $text",
                    fontSize = 40.sp,
                    lineHeight = 80.sp,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(1.0f)
                        .background(Color.Yellow)
                )
            }
            Row {
                Text(
                    text = "3r from $text",
                    fontSize = 40.sp,
                    lineHeight = 80.sp,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(1.0f)
                        .background(Color.Yellow)
                )
            }
            Row {
                Text(
                    text = "4r from $text",
                    fontSize = 40.sp,
                    lineHeight = 80.sp,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(1.0f)
                        .background(Color.Yellow)
                )
            }
            Row {
                Text(
                    text = "5r from $text",
                    fontSize = 40.sp,
                    lineHeight = 80.sp,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(1.0f)
                        .background(Color.Yellow)
                )
            }
            Row {
                Text(
                    text = "6r from $text",
                    fontSize = 40.sp,
                    lineHeight = 80.sp,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(1.0f)
                        .background(Color.Yellow)
                )
            }
            Row {
                Text(
                    text = "7r from $text",
                    fontSize = 40.sp,
                    lineHeight = 80.sp,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(1.0f)
                        .background(Color.Yellow)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Meteo_androidTheme {
        Greeting("Birthday")
    }
}
