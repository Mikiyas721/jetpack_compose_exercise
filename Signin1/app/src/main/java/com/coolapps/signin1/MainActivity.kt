package com.coolapps.signin1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
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

@Preview(showBackground = true)
@Composable
fun SignUpScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(vertical = 25.dp, horizontal = 20.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Sign up", fontWeight = FontWeight.Bold, fontSize = 30.sp)
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(100))
                    .shadow(elevation = 2.dp)
                    .padding(5.dp)
                    .clickable {  }
            ) {
                Icon(
                    Icons.Rounded.Close,
                    tint = Color.Gray,
                    contentDescription = "Close page button"
                )
            }
        }
        OutlinedButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(vertical = 25.dp)
                .fillMaxWidth()
        ) {
            Icon(
                Icons.Rounded.Menu,
                contentDescription = "Sign up with google Icon",
                tint = Color.Gray
            )
            Text(text = "Sign up with Google", color = Color.Black)
        }
        Divider()
        OutlinedTextFieldWithLabel(
            label = "Name",
            placeholder = "Leslie Alexander",
            value = "",
            onValueChanged = {},
            modifier = Modifier.padding(bottom = 15.dp, top = 35.dp)
        )
        OutlinedTextFieldWithLabel(
            label = "Email",
            placeholder = "example@mail.com",
            value = "",
            onValueChanged = {},
            modifier = Modifier.padding(bottom = 15.dp)
        )
        OutlinedTextFieldWithLabel(
            label = "Password",
            placeholder = "at least 8 characters",
            value = "",
            onValueChanged = {},
            modifier = Modifier.padding(bottom = 15.dp),
            visualTransformation = PasswordVisualTransformation()
        )
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Divider(
                thickness = 4.dp, modifier = Modifier
                    .weight(1f)
                    .padding(end = 5.dp)
            )
            Divider(thickness = 4.dp, modifier = Modifier.weight(1f), startIndent = 5.dp)
            Divider(thickness = 4.dp, modifier = Modifier.weight(1f), startIndent = 10.dp)
            Divider(thickness = 4.dp, modifier = Modifier.weight(1f), startIndent = 10.dp)
        }
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(vertical = 30.dp)
                .fillMaxWidth()
        ) {
            Checkbox(
                checked = true,
                onCheckedChange = {},
                colors = CheckboxDefaults.colors(checkedColor = Color.Blue),
                modifier = Modifier.padding(end = 5.dp)
            )
            Text(buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Gray)) {
                    append("I agree with ")
                }
                pushStringAnnotation(tag = "URL", annotation = "https://google.com")
                withStyle(style = SpanStyle(color = Color.Blue)) {
                    append(" Terms ")
                }
                pop()
                withStyle(style = SpanStyle(color = Color.Gray)) {
                    append(" and ")
                }
                pushStringAnnotation(
                    tag = "URL",
                    annotation = "https://developer.android.com/jetpack/compose"
                )
                withStyle(style = SpanStyle(color = Color.Blue)) {
                    append(" Privacy")
                }
                pop()
            })
        }
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
            modifier = Modifier
                .clip(shape = RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .height(45.dp)
        ) {
            Text(text = "Sign up", color = Color.White, fontSize = 18.sp)
        }
        Text(
            text = "Already have an account?",
            color = Color.Gray,
            modifier = Modifier
                .padding(top = 60.dp)
        )
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
    onValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    Column(modifier = modifier) {
        Text(
            text = label,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 5.dp)
        )
        OutlinedTextField(
            value = value,
            onValueChange = onValueChanged,
            placeholder = { Text(text = placeholder) },
            visualTransformation = visualTransformation,
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp)
                .clip(shape = RoundedCornerShape(10.dp))

        )
    }
}

