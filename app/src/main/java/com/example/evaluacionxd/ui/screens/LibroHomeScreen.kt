package com.example.evaluacionxd.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material.icons.rounded.AutoStories
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.evaluacionxd.ui.theme.EvaluacionxdTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LibroHomeScreen(
    onVerCatalogo: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Biblioteca de libros") },
            )
        },
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center,
        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 28.dp, vertical = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Surface(
                    modifier = Modifier.size(148.dp),
                    shape = RoundedCornerShape(44.dp),
                    color = MaterialTheme.colorScheme.primaryContainer,
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = Icons.Rounded.AutoStories,
                            contentDescription = null,
                            modifier = Modifier.size(82.dp),
                            tint = MaterialTheme.colorScheme.primary,
                        )
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "Bienvenido al\ncatálogo de libros",
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Descubre obras clásicas, conoce sus autores y consulta toda la información de cada libro.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center,
                )

                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    onClick = onVerCatalogo,
                    shape = RoundedCornerShape(18.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                    ),
                ) {
                    Text(text = "Ver catálogo")
                    Spacer(modifier = Modifier.size(10.dp))
                    Icon(
                        imageVector = Icons.AutoMirrored.Rounded.ArrowForward,
                        contentDescription = null,
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "8 títulos disponibles",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary,
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 720)
@Composable
private fun LibroHomeScreenPreview() {
    EvaluacionxdTheme(darkTheme = false, dynamicColor = false) {
        LibroHomeScreen(onVerCatalogo = {})
    }
}
