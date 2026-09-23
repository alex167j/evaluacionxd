package com.example.evaluacionxd.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.CalendarMonth
import androidx.compose.material.icons.rounded.Link
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Tag
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.evaluacionxd.data.librosDemo
import com.example.evaluacionxd.model.Libro
import com.example.evaluacionxd.ui.theme.EvaluacionxdTheme
import java.util.Locale

@Composable
fun LibroDetailCard(
    libro: Libro,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(26.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
    ) {
        LibroPortada(
            imagenUrl = libro.imagenUrl,
            titulo = libro.titulo,
            modifier = Modifier
                .fillMaxWidth()
                .height(270.dp)
                .clip(RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp)),
        )

        Column(modifier = Modifier.padding(24.dp)) {
            Text(
                text = libro.titulo,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Por ${libro.autor}",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )

            Spacer(modifier = Modifier.height(20.dp))
            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
            Spacer(modifier = Modifier.height(10.dp))

            LibroAtributo(
                icono = Icons.Rounded.Tag,
                etiqueta = "Identificador",
                valor = libro.id.toString(),
            )
            LibroAtributo(
                icono = Icons.Rounded.CalendarMonth,
                etiqueta = "Año de publicación",
                valor = libro.anioPublicacion.toString(),
            )
            LibroAtributo(
                icono = Icons.Rounded.Person,
                etiqueta = "Autor",
                valor = libro.autor,
            )
            LibroAtributo(
                icono = Icons.Rounded.AttachMoney,
                etiqueta = "Precio",
                valor = "USD ${String.format(Locale.US, "%,.2f", libro.precio)}",
            )
            LibroAtributo(
                icono = Icons.Rounded.Link,
                etiqueta = "URL de la imagen",
                valor = libro.imagenUrl,
            )
        }
    }
}

@Composable
private fun LibroAtributo(
    icono: ImageVector,
    etiqueta: String,
    valor: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 9.dp),
        verticalAlignment = Alignment.Top,
    ) {
        Surface(
            modifier = Modifier.size(42.dp),
            shape = CircleShape,
            color = MaterialTheme.colorScheme.secondaryContainer,
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    imageVector = icono,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSecondaryContainer,
                )
            }
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 14.dp),
        ) {
            Text(
                text = etiqueta,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            Text(
                text = valor,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Medium,
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 380, heightDp = 900)
@Composable
private fun LibroDetailCardPreview() {
    EvaluacionxdTheme(darkTheme = false, dynamicColor = false) {
        LibroDetailCard(
            libro = librosDemo.first(),
            modifier = Modifier.padding(16.dp),
        )
    }
}
