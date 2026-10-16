package com.example.uikit.composable

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.theme.Theme

/**
 * Нижняя панель навигации приложения
 * Дата создания: ДД-ММ-ГГГГ
 * Автор: № участника
 *
 * @param currentScreen индекс текущего экрана
 * @param onStatisticsClick переход к экрану
 * @param onDiscoverClick переход к экрану
 * @param onChatClick переход к экрану
 * @param onProfileClick переход к экрану
 * @param onCalendarClick переход к экрану
 * @param modifier модификатор панели
 */

@Composable
fun BottomBar(
    currentScreen: Int,
    onStatisticsClick: () -> Unit,
    onDiscoverClick: () -> Unit,
    onChatClick: () -> Unit,
    onProfileClick: () -> Unit,
    onLandingClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.bottombar),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
                .offset(y = (-30).dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomBarItem(
                icon = R.drawable.statistics,
                label = "Statistics",
                onClick = onStatisticsClick,
                enabled = currentScreen != 1,
                modifier = Modifier.weight(1f)
            )
            BottomBarItem(
                icon = R.drawable.discover,
                label = "Discover",
                onClick = onDiscoverClick,
                enabled = currentScreen != 2,
                modifier = Modifier.weight(1f)
            )
            Box(
                modifier = Modifier.weight(1f)
            )
            BottomBarItem(
                icon = R.drawable.chat,
                label = "Chat",
                onClick = onChatClick,
                enabled = currentScreen != 3,
                modifier = Modifier.weight(1f)
            )
            BottomBarItem(
                icon = R.drawable.profile,
                label = "Profile",
                onClick = onProfileClick,
                enabled = currentScreen != 4,
                modifier = Modifier.weight(1f)
            )
        }
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 15.dp)
                .size(56.dp)
                .border(
                    width = 5.dp,
                    color = Color.White,
                    shape = CircleShape
                )
                .clickable(
                    onClick = {
                        Log.i("BottomBar", "BottomBar: Навигация к Landing")
                        onLandingClick()
                    }
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.calendar),
                contentDescription = "Calendar",
                tint = Color.Unspecified
            )
        }
    }
}

@Composable
private fun BottomBarItem(
    icon: Int,
    label: String,
    onClick: () -> Unit,
    enabled: Boolean,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clickable(
                enabled = enabled,
                onClick = {
                    Log.i("BottomBar", "BottomBar: Навигация к $label")
                    onClick()
                }
            )
            .padding(horizontal = 2.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = label,
            style = Theme.typography.caption2Regular,
            color = Color.White,
            maxLines = 1,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun BottomBarPreview() {
    BottomBar(
        1,
        onStatisticsClick = {  },
        onDiscoverClick = {  },
        onChatClick = {  },
        onProfileClick = {  },
        onLandingClick = {  }
    )
}