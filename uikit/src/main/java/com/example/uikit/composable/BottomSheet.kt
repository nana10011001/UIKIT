package com.example.uikit.composable

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

/**
 * Нижняя модальная панель
 * Дата создания: ДД-ММ-ГГГГ
 * Автор: № участника
 *
 * @param onDismissRequest действие при закрытии панели
 * @param sheetState состояние нижней панели
 * @param value состояние выбора даты
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(
    onDismissRequest: () -> Unit,
    sheetState: SheetState,
    value: DatePickerState
) {
    ModalBottomSheet(
        onDismissRequest = {
            Log.i("BottomSheet", "BottomSheet: Закрытие")
            onDismissRequest()
        },
        sheetState = sheetState,
        containerColor = Color.White
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            DatePicker(
                state = value
            )
        }
    }
}