package com.example.uikit.composable.buttons

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.theme.Theme

/**
 * Кнопка выхода
 * Дата создания: ДД-ММ-ГГГГ
 * Автор: № участника
 *
 * @param modifier модификатор кнопки
 * @param onCLick действие при нажатии
 */

@Composable
fun TertiaryButton(
    onCLick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .height(24.dp)
            .clickable{
                Log.i("TertiaryButton", "TertiaryButton: Нажатие")
                onCLick()
            }
    ) {
        Icon(
            painter = painterResource(R.drawable.logout),
            contentDescription = null,
            tint = Color.Unspecified
        )
        Text(
            text = "Logout",
            color = Color.Black,
            style = Theme.typography.headlineRegular,
            modifier = Modifier
                .padding(start = 18.dp)
        )
    }
}

@Preview
@Composable
fun TertiaryButtonPreview() {
    TertiaryButton(
        onCLick = { }
    )
}