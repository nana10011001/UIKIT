package com.example.uikit.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.uikit.R

/**
 * Текстовые стили
 * Дата создания: ДД-ММ-ГГГГ
 * Автор: № участника
 */

data class Typography(
    val title1Semibold: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(resId = R.font.poppins_semibold)),
        fontSize = 24.sp,
        fontWeight = FontWeight(600)
    ),
    val title1Extrabold : TextStyle = TextStyle(
        fontFamily = FontFamily(Font(resId = R.font.poppins_extrabold)),
        fontSize = 24.sp,
        fontWeight = FontWeight(800)
    ),
    val title2Regular: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(resId = R.font.poppins_regular)),
        fontSize = 20.sp,
        fontWeight = FontWeight(400)
    ),
    val title2Semibold : TextStyle = TextStyle(
        fontFamily = FontFamily(Font(resId = R.font.poppins_semibold)),
        fontSize = 20.sp,
        fontWeight = FontWeight(600)
    ),
    val title2Extrabold : TextStyle = TextStyle(
        fontFamily = FontFamily(Font(resId = R.font.poppins_extrabold)),
        fontSize = 20.sp,
        fontWeight = FontWeight(800)
    ),
    val title3Regular : TextStyle = TextStyle(
        fontFamily = FontFamily(Font(resId = R.font.poppins_regular)),
        fontSize = 17.sp,
        fontWeight = FontWeight(400)
    ),
    val title3Medium : TextStyle = TextStyle(
        fontFamily = FontFamily(Font(resId = R.font.poppins_medium)),
        fontSize = 17.sp,
        fontWeight = FontWeight(500)
    ),
    val title3Semibold : TextStyle = TextStyle(
        fontFamily = FontFamily(Font(resId = R.font.poppins_semibold)),
        fontSize = 17.sp,
        fontWeight = FontWeight(600)
    ),
    val headlineRegular: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(resId = R.font.poppins_regular)),
        fontSize = 16.sp,
        fontWeight = FontWeight(400)
    ),
    val headlineMedium : TextStyle = TextStyle(
        fontFamily = FontFamily(Font(resId = R.font.poppins_medium)),
        fontSize = 16.sp,
        fontWeight = FontWeight(500)
    ),
    val textRegular : TextStyle = TextStyle(
        fontFamily = FontFamily(Font(resId = R.font.poppins_regular)),
        fontSize = 15.sp,
        fontWeight = FontWeight(400)
    ),
    val textMedium : TextStyle = TextStyle(
        fontFamily = FontFamily(Font(resId = R.font.poppins_medium)),
        fontSize = 15.sp,
        fontWeight = FontWeight(400)
    ),
    val captionRegular : TextStyle = TextStyle(
        fontFamily = FontFamily(Font(resId = R.font.poppins_regular)),
        fontSize = 14.sp,
        fontWeight = FontWeight(400)
    ),
    val captionSemibold : TextStyle = TextStyle(
        fontFamily = FontFamily(Font(resId = R.font.poppins_semibold)),
        fontSize = 14.sp,
        fontWeight = FontWeight(600)
    ),
    val caption2Regular : TextStyle = TextStyle(
        fontFamily = FontFamily(Font(resId = R.font.poppins_regular)),
        fontSize = 12.sp,
        fontWeight = FontWeight(400)
    ),
    val caption2Bold : TextStyle = TextStyle(
        fontFamily = FontFamily(Font(resId = R.font.poppins_bold)),
        fontSize = 12.sp,
        fontWeight = FontWeight(700)
    )
)

// Доступ к типографике
val TypographyTheme = staticCompositionLocalOf { Typography() }

// Провайдер типографики
@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        TypographyTheme provides Typography(),
        content = content
    )
}

// Объект доступа
object Theme{
    val typography: Typography
        @Composable get() = TypographyTheme.current
}