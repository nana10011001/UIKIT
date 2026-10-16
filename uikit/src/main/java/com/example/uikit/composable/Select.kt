package com.example.uikit.composable

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.R
import com.example.uikit.theme.Theme
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

/**
 * Поле выбора даты
 * Дата создания: ДД-ММ-ГГГГ
 * Автор: № участника
 *
 * @param title заголовок поля
 * @param value состояние выбора даты
 * @param date дата по умолчанию
 * @param modifier модификатор поля
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Select(
    title: String,
    value: DatePickerState,
    date: String,
    modifier: Modifier = Modifier
) {
    val showBottomSheet = remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()

    Column(
        modifier = modifier
    ) {
        Text(
            text = title,
            fontFamily = FontFamily(
                Font(resId = R.font.poppins_regular)
            ),
            fontWeight = FontWeight(400),
            fontSize = 8.sp,
            color = Color(0xFFFA5075)
        )
        Row(
            modifier = Modifier
                .padding(top = 10.dp)
                .clickable {
                    showBottomSheet.value = !showBottomSheet.value
                    if (showBottomSheet.value) {
                        Log.i("Select", "Select: Открытие")
                    }
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = value.selectedDateMillis?.let { millis ->
                    Instant.ofEpochMilli(millis)
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate()
                        .format(
                            DateTimeFormatter.ofPattern("EEE, MMM d, yyyy")
                        )
                        .uppercase()
                } ?: date,
                style = Theme.typography.caption2Regular,
                color = Color.Black
            )
            Icon(
                painter = painterResource(R.drawable.dropdown),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier
                    .padding(start = 16.dp)
            )
        }
    }

    if(showBottomSheet.value) {
        BottomSheet(
            onDismissRequest = {
                showBottomSheet.value = false
            },
            sheetState = sheetState,
            value = value
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SelectPreview() {
    Select(
        title = "FROM",
        value = rememberDatePickerState(),
        date = "MON, NOV 4,2019"
    )
}