package com.example.evaluacionxd.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowRight
import androidx.compose.material.icons.rounded.CalendarMonth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.evaluacionxd.data.librosDemo
import com.example.evaluacionxd.model.Libro
import com.example.evaluacionxd.ui.theme.EvaluacionxdTheme
import java.util.Locale

@Composable
fun LibroItem(
    libro: Libro,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.outlineVariant,
        ),
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            LibroPortada(
                imagenUrl = libro.imagenUrl,
                titulo = libro.titulo,
                modifier = Modifier
                    .size(width = 96.dp, height = 132.dp)
                    .clip(RoundedCornerShape(14.dp)),
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp, top = 4.dp, end = 4.dp, bottom = 4.dp),
            ) {
                Text(
                    text = libro.titulo,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = libro.autor,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Rounded.CalendarMonth,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = MaterialTheme.colorScheme.primary,
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = libro.anioPublicacion.toString(),
                        style = MaterialTheme.typography.labelMedium,
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = formatearPrecioLibro(libro.precio),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Ver detalle",
                        modifier = Modifier.weight(1f),
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.primary,
                    )
                    Icon(
                        imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowRight,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                    )
                }
            }
        }
    }
}

private fun formatearPrecioLibro(precio: Double): String =
    "USD ${String.format(Locale.US, "%,.2f", precio)}"

@Preview(showBackground = true, widthDp = 380)
@Composable
private fun LibroItemPreview() {
    EvaluacionxdTheme(darkTheme = false, dynamicColor = false) {
        LibroItem(
            libro = librosDemo.first(),
            onClick = {},
            modifier = Modifier.padding(16.dp),
        )
    }
}
