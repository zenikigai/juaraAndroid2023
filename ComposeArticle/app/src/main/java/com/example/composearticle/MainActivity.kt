package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorScheme.background
                ) {
                    LearnTogetherScreenPreview()
                }
            }
        }
    }
}

@Composable
fun LearnTogetherScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Gambar untuk mengisi seluruh layar
        Image(
            painter = painterResource(id = R.drawable.bg_compose_background),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(135.dp), // Sesuaikan tinggi gambar sesuai kebutuhan
            alignment = Alignment.TopStart,
            contentScale = ContentScale.FillWidth
        )

        // Composable Text Pertama
        Text(
            text = "Jetpack Compose Tutorial",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(16.dp)
                .background(colorScheme.background)
                .wrapContentSize(Alignment.CenterStart),
            color = Color.Black
        )

        // Composable Text Kedua
        Text(
            text = stringResource(R.string.compose_tutorial_description),
            fontSize = 15.sp,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(bottom = 16.dp)
                .fillMaxWidth()
                .background(colorScheme.background),
            color = Color.Black
        )

        // Composable Text Ketiga
        Text(
            text = stringResource(R.string.compose_additional_info),
            fontSize = 15.sp,
            modifier = Modifier
                .padding(16.dp)
                .padding(bottom = 25.dp)
                .background(colorScheme.background)
                .wrapContentSize(Alignment.CenterStart)
                .fillMaxWidth(),
            color = Color.Black
        )
    }
}
@Preview(showBackground = false)
@Composable
fun LearnTogetherScreenPreview() {
    LearnTogetherScreen()
}