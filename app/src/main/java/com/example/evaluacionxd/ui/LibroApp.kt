package com.example.evaluacionxd.ui

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.evaluacionxd.data.librosDemo
import com.example.evaluacionxd.model.Libro
import com.example.evaluacionxd.ui.screens.LibroCatalogScreen
import com.example.evaluacionxd.ui.screens.LibroDetailScreen
import com.example.evaluacionxd.ui.screens.LibroHomeScreen

private enum class PantallaLibro {
    INICIO,
    CATALOGO,
    DETALLE,
}

/**
 * Coordina la navegación y el estado de la aplicación mediante state hoisting.
 * Las pantallas reciben datos y acciones, pero no conservan el estado de selección.
 */
@Composable
fun LibroApp() {
    val libros = remember { librosDemo }
    var pantallaActual by remember { mutableStateOf(PantallaLibro.INICIO) }
    var libroSeleccionado by remember { mutableStateOf<Libro?>(null) }

    BackHandler(enabled = pantallaActual != PantallaLibro.INICIO) {
        when (pantallaActual) {
            PantallaLibro.CATALOGO -> pantallaActual = PantallaLibro.INICIO
            PantallaLibro.DETALLE -> pantallaActual = PantallaLibro.CATALOGO
            PantallaLibro.INICIO -> Unit
        }
    }

    when (pantallaActual) {
        PantallaLibro.INICIO -> {
            LibroHomeScreen(
                onVerCatalogo = { pantallaActual = PantallaLibro.CATALOGO },
            )
        }

        PantallaLibro.CATALOGO -> {
            LibroCatalogScreen(
                libros = libros,
                onLibroSeleccionado = { libro ->
                    libroSeleccionado = libro
                    pantallaActual = PantallaLibro.DETALLE
                },
                onVolverInicio = { pantallaActual = PantallaLibro.INICIO },
            )
        }

        PantallaLibro.DETALLE -> {
            libroSeleccionado?.let { libro ->
                LibroDetailScreen(
                    libro = libro,
                    onVolver = { pantallaActual = PantallaLibro.CATALOGO },
                )
            } ?: LibroCatalogScreen(
                libros = libros,
                onLibroSeleccionado = { libro ->
                    libroSeleccionado = libro
                    pantallaActual = PantallaLibro.DETALLE
                },
                onVolverInicio = { pantallaActual = PantallaLibro.INICIO },
            )
        }
    }
}
