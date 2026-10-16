package com.example.uikit.composable

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Индикатор текущей страницы
 * Дата создания: ДД-ММ-ГГГГ
 * Автор: № участника
 *
 * @param index индекс текущей страницы (1-3)
 */

@Composable
fun Pagination(
    index: Int
) {
    Log.d("Pagination", "Pagination: Отображение страницы $index из 3")

    Row(
        Modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(3) { i ->
            val isSelected = index == i + 1
            Box(
                modifier = Modifier
                    .size(10.dp)
                    .clip(CircleShape)
                    .background(if (isSelected) Color(0xFFFA5075) else Color(0xFFFA5075).copy(0.35f))
            )
        }
    }
}

@Preview
@Composable
private fun PaginationPreview() {
    Pagination(1)
}