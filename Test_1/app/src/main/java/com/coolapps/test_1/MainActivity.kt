package com.coolapps.test_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.*
import androidx.compose.material.icons.sharp.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.coolapps.test_1.ui.theme.Test_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test_1Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                }
            }
        }
    }
}

@Preview()
@Composable
fun Materials() {
    Button(
        onClick = { /* ... */ },
        content = {
            Icon(
                Icons.Filled.Favorite,
                contentDescription = "Favorite",
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text("Like")
        },
        // Uses ButtonDefaults.ContentPadding by default
        contentPadding = PaddingValues(
            start = 20.dp,
            top = 12.dp,
            end = 20.dp,
            bottom = 12.dp
        )
    )
}

@Preview()
@Composable
fun HomeScreen() {
    Surface(color = MaterialTheme.colors.background) {
        Scaffold(
            drawerContent = {
                Text("bla")
                Divider()
            },
            topBar = {
                TopAppBar(
                    navigationIcon = { Icon(Icons.Rounded.ArrowBack, contentDescription = "") },
                    title = {
                        Text(
                            text =
                            stringResource(id = R.string.home_screen_title)
                        )
                    },
                    actions = {
                        Icon(Icons.Sharp.Refresh, contentDescription = "")
                    }
                )
            },
            content = {
                Test_1Theme {
                    Column {
                        ItemCard(
                            R.drawable.ic_launcher_background,
                            "Jetpack",
                            "Android UI toolkit"
                        )
                        ItemCard(
                            R.drawable.ic_launcher_foreground,
                            "Android",
                            "View based app development"
                        )
                        ItemCard(
                            R.drawable.ic_launcher_background,
                            "Flutter",
                            "Cross-platform UI toolkit"
                        )
                        ItemCard(
                            R.drawable.ic_launcher_foreground,
                            "Compose",
                            "Android UI toolkit"
                        )
                    }
                }
            },
            floatingActionButton = {
                FloatingActionButton(
                    contentColor = Color.White,
                    onClick = { /*TODO*/ }
                ) {
                    Icon(Icons.Rounded.Add, contentDescription = "")
                }
            })
    }
}

@Composable
fun ItemCard(imageSource: Int, title: String, caption: String) {
    Box(modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp)) {
        Card(
            Modifier
                .fillMaxWidth()
                .shadow(elevation = 10.dp, shape = RoundedCornerShape(15.dp)),
            shape = RoundedCornerShape(15.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(5.dp)
            ) {
                StackedItems(imageSource)
                Column(Modifier.padding(10.dp)) {
                    Text(title, fontSize = 30.sp, color = Color.Blue)
                    Text(caption, fontSize = 18.sp, color = Color.Gray)
                }
            }
        }
    }
}

@Composable
fun StackedItems(imageSource: Int) {
    Box() {
        Image(
            painter = painterResource(id = imageSource),
            contentDescription = "Description Here",
            Modifier
                .size(80.dp)
                .align(alignment = Alignment.Center)
                .clip(
                    shape = CircleShape
                )
        )
        Icon(
            Icons.Rounded.Edit,
            contentDescription = "",
            modifier = Modifier
                .align(alignment = Alignment.BottomEnd)
                .clip(shape = CircleShape)
                .background(color = Color.White)
                .clickable { }
                .padding(2.dp)
        )
    }
}
