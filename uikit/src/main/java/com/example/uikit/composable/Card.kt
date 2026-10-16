package com.example.uikit.composable

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.theme.Theme

/**
 * Карточка с текстом и изображением
 * Дата создания: ДД-ММ-ГГГГ
 * Автор: № участника
 *
 * @param title заголовок карточки
 * @param text описание карточки
 * @param onCLick действие при нажатии
 * @param image ресурс изображения
 * @param modifier модификатор карточки
 */

@Composable
fun Card(
    title: String,
    text: String,
    onCLick: () -> Unit,
    image: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(169.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFF6480),
                        Color(0xFFF22E63)
                    )
                ),
                shape = RoundedCornerShape(10.dp)
            )
            .clickable {
                Log.i("Card", "Card: Нажатие $title")
                onCLick()
            }
    ) {
        Box(
            modifier = Modifier
                .padding(
                    start = 24.dp,
                    top = 30.dp,
                    end = 22.dp,
                    bottom = 19.dp
                )
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .width(120.dp),
                contentScale = ContentScale.FillWidth
            )
            Column(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .fillMaxWidth(0.6f)
            ) {
                Text(
                    text = title,
                    style = Theme.typography.caption2Bold,
                    color = Color.White
                )
                Text(
                    text = text,
                    style = Theme.typography.caption2Regular,
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 14.dp),
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis
                )
                Icon(
                    painter = painterResource(R.drawable.forward_arrow),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .padding(top = 42.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun CardPreview() {
    Card(
        title = "Schedule",
        text = "Easily schedule event/games\n" +
                "then find like minded players for battle. You up for it?",
        onCLick = { },
        image = R.drawable.image
    )
}