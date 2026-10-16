package com.example.uikit.composable.buttons

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.theme.Theme

/**
 * Основная кнопка
 * Дата создания: ДД-ММ-ГГГГ
 * Автор: № участника
 *
 * @param modifier модификатор кнопки
 * @param text текст кнопки
 * @param onCLick действие при нажатии
 */

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    onCLick: () -> Unit
) {
    Button(
        onClick = {
            Log.i("PrimaryButton", "PrimaryButton: Нажатие $text")
            onCLick()
        },
        modifier = modifier
            .height(58.dp)
            .widthIn(210.dp)
            .clip(RoundedCornerShape(100.dp))
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFF6480),
                        Color(0xFFF22E63)
                    )
                )
            ),
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = Color.Transparent
        )
    ) {
        Text(
            text = text,
            style = Theme.typography.title3Semibold
        )
    }
}

@Preview
@Composable
fun prevPrimaryButton() {
    PrimaryButton(
        text = "text",
        onCLick = { }
    )
}