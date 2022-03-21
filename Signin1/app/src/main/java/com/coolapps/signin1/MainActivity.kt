package com.coolapps.signin1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.coolapps.signin1.ui.theme.SignIn1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignIn1Theme {
                Surface(color = MaterialTheme.colors.background) {
                }
            }
        }
    }
}

@Preview
@Composable
fun SignUpScreen() {
    Column {
        Text(text = "Sign up", fontWeight = FontWeight.Bold)
        OutlinedButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Rounded.Edit, contentDescription = "Sign up with google Icon")
            Text(text = "Sign up with google")
        }
        Divider()
        OutlinedTextFieldWithLabel(
            label = "Name",
            placeholder = "Leslie Alexander",
            value = "",
            onValueChanged = {}
        )
        OutlinedTextFieldWithLabel(
            label = "Email",
            placeholder = "example@mail.com",
            value = "",
            onValueChanged = {}
        )
        OutlinedTextFieldWithLabel(
            label = "Password",
            placeholder = "at least 8 characters",
            value = "",
            onValueChanged = {}
        )
        Row {
            Divider(thickness = 2.dp)
            Divider(thickness = 2.dp)
            Divider(thickness = 2.dp)
            Divider(thickness = 2.dp)
        }
        Text(buildAnnotatedString {
            append("I agree with ")
            pushStringAnnotation(tag = "URL", annotation = "https://google.com")
            withStyle(style = SpanStyle(color = Color.Blue)) {
                append(" Terms ")
            }
            pop()
            append(" and ")
            pushStringAnnotation(
                tag = "URL",
                annotation = "https://developer.android.com/jetpack/compose"
            )
            withStyle(style = SpanStyle(color = Color.Blue)) {
                append(" Privacy")
            }
            pop()
        })
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .background(color = Color.Blue)
        ) {
            Text(text = "Sign up", color = Color.White)
        }
        Text(text = "Already have an account?")
        Text(buildAnnotatedString {
            pushStringAnnotation(tag = "URL", annotation = "https://google.com")
            withStyle(style = SpanStyle(color = Color.Blue)) {
                append("Log in")
            }
            pop()
        })
    }
}

@Composable
fun OutlinedTextFieldWithLabel(
    label: String,
    value: String,
    placeholder: String,
    onValueChanged: (String) -> Unit
) {
    Column() {
        Text(text = label)
        OutlinedTextField(
            value = value,
            onValueChange = onValueChanged,
            placeholder = { Text(text = placeholder) }
        )
    }
}

