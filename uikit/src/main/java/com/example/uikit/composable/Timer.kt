package com.example.uikit.composable

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.R
import com.example.uikit.theme.Theme
import kotlinx.coroutines.delay

/**
 * Таймер
 * Дата создания: ДД-ММ-ГГГГ
 * Автор: № участника
 *
 * @param modifier модификатор таймера
 * @param initialMinutes начальное количество минут
 * @param initialSeconds начальное количество секунд
 */

@Composable
fun Timer(
    modifier: Modifier = Modifier,
    initialMinutes: Int,
    initialSeconds: Int
) {
    var remainingSeconds by remember {
        mutableIntStateOf(initialMinutes * 60 + initialSeconds)
    }

    LaunchedEffect(Unit) {
        Log.i("Timer", "Timer: Запуск, ${initialMinutes} мин ${initialSeconds} сек")

        while (remainingSeconds > 0) {
            delay(1000)
            remainingSeconds--
        }

        Log.i("Timer", "Timer: Завершение")
    }

    TimerComponent(
        modifier = modifier,
        minutes = remainingSeconds / 60,
        seconds = remainingSeconds % 60
    )
}

@Composable
fun TimerComponent(
    modifier: Modifier = Modifier,
    minutes: Int = 0,
    seconds: Int = 0
) {
    Box(
        modifier = modifier
            .heightIn(100.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFF6480),
                        Color(0xFFF22E63)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .padding(top = 7.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Timer",
                style = Theme.typography.caption2Regular,
                color = Color.White
            )
            Row(
                modifier = Modifier
                    .padding(top = 14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (minutes<10) {
                        "0$minutes:"
                    } else {
                        "$minutes:"
                    },
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.poppins_extrabold)),
                    fontWeight = FontWeight.W700,
                    fontSize = 30.sp
                )
                Text(
                    text = if (seconds < 10) {
                        "0$seconds"
                    } else {
                        seconds.toString()
                    },
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.poppins_extrabold)),
                    fontWeight = FontWeight.W700,
                    fontSize = 30.sp
                )
            }
        }
    }
}

@Preview
@Composable
fun TimerPreview() {
    Timer(
        initialMinutes = 10,
        initialSeconds = 0
    )
}