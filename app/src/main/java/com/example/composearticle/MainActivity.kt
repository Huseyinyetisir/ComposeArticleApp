package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background)
                {
                    ArticlePagePreview()
                }
            }
        }
    }
}

@Composable
fun ComposeArticleApp(){
    ArticleImage(
        title = stringResource(R.string.article_title),
        summary = stringResource(R.string.article_summary),
        body = stringResource(R.string.article_body),
        imagePainter = painterResource(R.drawable.bg_compose_background)
    )
}

@Composable
fun ArticleImage (title: String, summary: String, body: String, imagePainter: Painter, modifier: Modifier = Modifier) {
    Column (modifier = modifier) {
        Image(
            painter = imagePainter,
            contentDescription = null,
            contentScale = ContentScale.Fit,
        )
        ArticleText(
            title = title,
            summary = summary,
            body = body,
            modifier = modifier
        )
    }
}
@Composable
fun ArticleText(title: String, summary: String, body: String, modifier: Modifier = Modifier) {
    Column (modifier = modifier) {
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp),
        )
        Text(
            text = summary,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify

        )
        Text(
            text = body,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify

        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ArticlePagePreview() {
    ComposeArticleTheme {
        ComposeArticleApp()
    }
}