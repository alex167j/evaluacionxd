package com.example.evaluacionxd.model

/**
 * Entidad mostrada por el catálogo. Sus seis atributos incluyen texto,
 * valores numéricos y la dirección URL de la portada.
 */
data class Libro(
    val id: Int,
    val titulo: String,
    val autor: String,
    val anioPublicacion: Int,
    val precio: Double,
    val imagenUrl: String,
)
