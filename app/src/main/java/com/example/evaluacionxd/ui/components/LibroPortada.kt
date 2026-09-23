package com.example.evaluacionxd.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.MenuBook
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest

@Composable
fun LibroPortada(
    imagenUrl: String,
    titulo: String,
    modifier: Modifier = Modifier,
) {
    SubcomposeAsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imagenUrl)
            .crossfade(true)
            .build(),
        contentDescription = "Portada de $titulo",
        modifier = modifier,
        contentScale = ContentScale.Crop,
        loading = { LibroPortadaPlaceholder() },
        error = { LibroPortadaPlaceholder() },
    )
}

@Composable
private fun LibroPortadaPlaceholder() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Rounded.MenuBook,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(48.dp),
        )
    }
}
