package com.example.uikit.composable

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.theme.Theme

/**
 * Текстовое поле с плейсхолдером и опциональным переключением видимости
 * Дата создания: ДД-ММ-ГГГГ
 * Автор: № участника
 *
 * @param modifier модификатор поля
 * @param value введенный текст
 * @param onValueChange обработчик изменения текста
 * @param placeholder плейсхолдер
 * @param withTrailingIcon отображение иконки видимости
 */

@Composable
fun Input(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    withTrailingIcon: Boolean = false
) {
    val visualTransformation = remember { mutableStateOf(true) }

    BasicTextField(
        value = value,
        onValueChange = {
            Log.d("Input", "Input: Ввод текста - изменение длины на ${it.length}")
            onValueChange(it)
        },
        modifier = modifier,
        textStyle = TextStyle(
            color = Color.Black
        ),
        visualTransformation = if (withTrailingIcon && visualTransformation.value) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        },
        decorationBox = { innerTextField ->
            Column {
                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier.weight(1f)
                    ) {
                        if (value.isEmpty()) {
                            Text(
                                text = placeholder,
                                style = Theme.typography.caption2Regular,
                                color = Color.Black
                            )
                        }
                        innerTextField()
                    }

                    if (withTrailingIcon) {
                        Icon(
                            painter = painterResource(R.drawable.invisible),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .clickable {
                                    visualTransformation.value = !visualTransformation.value
                                    Log.i("Input", "Input: Видимость текста - ${if (visualTransformation.value) "скрыт" else "показан"}")
                                }
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(color = Color(0xFFFA5075))
                )
            }
        }
    )
}

@Preview
@Composable
fun InputPreview() {
    val value = remember { mutableStateOf("") }

    Input(
        value = value.value,
        onValueChange = { value.value = it },
        placeholder = "Full Name",
        modifier = Modifier.padding(horizontal = 20.dp),
        withTrailingIcon = false
    )
}

@Preview
@Composable
fun InputPasswordPreview() {
    val value = remember { mutableStateOf("") }

    Input(
        value = value.value,
        onValueChange = { value.value = it },
        placeholder = "Password",
        modifier = Modifier.padding(horizontal = 20.dp),
        withTrailingIcon = true
    )
}