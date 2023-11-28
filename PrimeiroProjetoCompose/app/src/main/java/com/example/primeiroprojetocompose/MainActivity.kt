package com.example.primeiroprojetocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.primeiroprojetocompose.ui.theme.PrimeiroProjetoComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PrimeiroProjetoComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

fun DrawScope.circle(offset: (Float) -> Offset) {
    val radius = Dp(20f).value
    drawCircle(
        Color.Black,
        radius = radius,
        center = offset(radius)
    )
}

fun DrawScope.center() {
    circle {
        Offset(size.width / 2, size.height / 2)
    }
}

fun DrawScope.topRight() {
    circle {
        Offset(size.width - it, it*2)
    }
}

fun DrawScope.bottomLeft() {
    circle {
        Offset(it * 2f, size.height - (it * 2f))
    }
}

fun DrawScope.bullet(number: Int){
    when(number) {
        1 -> {
            center()
        }
        2 -> {
            topRight()
            center()
        }
        3 -> {
            topRight()
            center()
            bottomLeft()
        }

    }

}

@Composable
fun Dice(number: Int ,modifier: Modifier) {

    Canvas(modifier = Modifier.size(96.dp, 96.dp))
    {
        drawRoundRect(
            Color.Green,
            topLeft = Offset(10f, 10f), size = size,
            cornerRadius = CornerRadius(20f, 20f)
        )


        bullet(number = number)
    }
}

@Composable
fun App(){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)){

        Dice(3, Modifier.align(Alignment.Center))

            Button(onClick = { /*TODO*/ }, modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (100).dp)) {
                Text("Jogar")
            }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PrimeiroProjetoComposeTheme {
        Surface(modifier = Modifier.fillMaxSize()){
            App()
        }
    }
}