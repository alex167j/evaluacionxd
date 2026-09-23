package com.example.evaluacionxd.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.evaluacionxd.data.librosDemo
import com.example.evaluacionxd.model.Libro
import com.example.evaluacionxd.ui.components.LibroDetailCard
import com.example.evaluacionxd.ui.theme.EvaluacionxdTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LibroDetailScreen(
    libro: Libro,
    onVolver: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Detalle del libro",
                        style = MaterialTheme.typography.titleLarge,
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onVolver) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                            contentDescription = "Volver al catálogo",
                        )
                    }
                },
            )
        },
    ) { innerPadding ->
        LibroDetailCard(
            libro = libro,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 20.dp),
        )
    }
}

@Preview(showBackground = true, widthDp = 380, heightDp = 900)
@Composable
private fun LibroDetailScreenPreview() {
    EvaluacionxdTheme(darkTheme = false, dynamicColor = false) {
        LibroDetailScreen(
            libro = librosDemo.first(),
            onVolver = {},
        )
    }
}
