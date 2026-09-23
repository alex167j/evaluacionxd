package com.example.evaluacionxd.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.evaluacionxd.data.librosDemo
import com.example.evaluacionxd.model.Libro
import com.example.evaluacionxd.ui.components.LibroItem
import com.example.evaluacionxd.ui.theme.EvaluacionxdTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LibroCatalogScreen(
    libros: List<Libro>,
    onLibroSeleccionado: (Libro) -> Unit,
    onVolverInicio: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Catálogo",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = "${libros.size} títulos disponibles",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onVolverInicio) {
                        Icon(
                            imageVector = Icons.Rounded.Home,
                            contentDescription = "Volver al inicio",
                        )
                    }
                },
            )
        },
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 20.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp),
        ) {
            item {
                Column(modifier = Modifier.padding(horizontal = 4.dp, vertical = 4.dp)) {
                    Text(
                        text = "Explora la colección",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = "Selecciona un libro para ver todos sus detalles.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }
            }

            items(
                items = libros,
                key = { libro -> libro.id },
            ) { libro ->
                LibroItem(
                    libro = libro,
                    onClick = { onLibroSeleccionado(libro) },
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 760)
@Composable
private fun LibroCatalogScreenPreview() {
    EvaluacionxdTheme(darkTheme = false, dynamicColor = false) {
        LibroCatalogScreen(
            libros = librosDemo.take(3),
            onLibroSeleccionado = {},
            onVolverInicio = {},
        )
    }
}
