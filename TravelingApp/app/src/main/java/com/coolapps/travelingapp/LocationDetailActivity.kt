package com.coolapps.travelingapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*

@Preview
@Composable
fun LocationDetailPagePreview() {
    LocationDetailsPage(R.drawable.borobudur)
}

/**Why is Color.Transparent not working for Icon Background*/
@Composable
fun LocationDetailsPage(locationImage: Int) {
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    Box(modifier = Modifier.fillMaxSize()) {
        ImageCard(
            image = locationImage,
            contentDescription = "Location Image",
            modifier = Modifier
                .align(alignment = Alignment.TopCenter)
                .height(screenHeight * 0.35F)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 20.dp, start = 20.dp, end = 20.dp)
            ) {
                Card(
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(5.dp))
                        .background(color = Color(0x99FFFFFF))
                        .padding(5.dp)
                        .align(Alignment.TopStart)
                ) {
                    Icon(
                        Icons.Rounded.ArrowBack,
                        contentDescription = "Go Back",
                        tint = Color.DarkGray,
                        modifier = Modifier.background(color = Color(0x99FFFFFF))
                    )
                }
                Card(
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(5.dp))
                        .background(color = Color(0x99FFFFFF))
                        .padding(5.dp)
                        .align(Alignment.TopEnd)
                ) {
                    Icon(
                        Icons.Rounded.Share,
                        contentDescription = "Share",
                        tint = Color.DarkGray,
                        modifier = Modifier.background(color = Color(0x99FFFFFF))
                        /**Color.Transparent Not Working*/
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .height(height = screenHeight * 0.735F)
                .align(alignment = Alignment.BottomCenter)
        ) {
            Card(
                modifier = Modifier
                    .padding(end = 20.dp)
                    .shadow(elevation = 10.dp, shape = RoundedCornerShape(100))
                    .clip(shape = RoundedCornerShape(100))
                    .background(color = Color.White)
                    .padding(20.dp)
                    .align(Alignment.TopEnd)
                    .zIndex(2f)
            )
            {
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Like Location",
                    tint = Color.Blue,
                    modifier = Modifier.background(color = Color.Transparent)
                )
            }
            Card(
                modifier = Modifier
                    .align(alignment = Alignment.BottomCenter)
                    .height(screenHeight * 0.7F)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                    .background(color = Color.White)
                    .zIndex(1f)
            ) {
                Column(modifier = Modifier.padding(top = 20.dp, start = 20.dp, end = 20.dp)) {
                    Column(modifier = Modifier.padding(top = 20.dp)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(3.dp)
                        ) {
                            Icon(
                                Icons.Rounded.Star,
                                contentDescription = "Star one out of five",
                                tint = Color.Yellow
                            )
                            Icon(
                                Icons.Rounded.Star, contentDescription = "Star two out of five",
                                tint = Color.Yellow
                            )
                            Icon(
                                Icons.Rounded.Star, contentDescription = "Star three out of five",
                                tint = Color.Yellow
                            )
                            Icon(
                                Icons.Rounded.Star, contentDescription = "Star four out of five",
                                tint = Color.Yellow
                            )
                            Icon(
                                Icons.Rounded.Star, contentDescription = "Star five out of five",
                                tint = Color.Yellow
                            )
                            Text(buildAnnotatedString {
                                withStyle(style = SpanStyle(color = Color.Yellow)) {
                                    append("5")
                                }
                                withStyle(style = SpanStyle(color = Color.Gray)) {
                                    append("(127)")
                                }
                            })
                        }
                        Text(
                            text = "Heian Shrine",
                            fontWeight = FontWeight.Bold,
                            fontSize = 28.sp,
                            modifier = Modifier.padding(vertical = 15.dp)
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(5.dp)
                        ) {
                            Icon(
                                Icons.Rounded.LocationOn,
                                contentDescription = "Location Icon",
                                tint = Color.Gray
                            )
                            Text(text = "Kyoto, Japan", color = Color.Gray)
                        }
                    }
                    LazyColumn() {
                        item {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 15.dp)
                            ) {
                                Text(buildAnnotatedString {
                                    withStyle(
                                        style = SpanStyle(
                                            color = Color.Blue,
                                            fontSize = 24.sp,
                                            fontWeight = FontWeight.SemiBold
                                        )
                                    ) {
                                        append("$350")
                                    }
                                    withStyle(
                                        style = SpanStyle(
                                            color = Color.Gray,
                                            baselineShift = BaselineShift.Subscript
                                        )
                                    ) {
                                        append("/person")
                                    }
                                })
                                Button(
                                    onClick = { /*TODO*/ },
                                    modifier = Modifier
                                        .clip(shape = RoundedCornerShape(10.dp))
                                        .height(48.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        backgroundColor = Color.Blue,
                                        contentColor = Color.White
                                    )
                                ) {
                                    Icon(
                                        Icons.Rounded.AccountCircle,
                                        contentDescription = "Book For number of days",
                                    )
                                    Text(
                                        "4 days 3 nights",
                                        modifier = Modifier.padding(start = 10.dp)
                                    )
                                }
                            }
                        }
                        item {
                            Text("Description", fontSize = 22.sp, fontWeight = FontWeight.Bold)
                        }
                        item {
                            Text(
                                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
                                color = Color.Gray,
                                modifier = Modifier.padding(top = 10.dp, bottom = 20.dp),
                                fontSize = 18.sp,
                                lineHeight = 25.sp
                            )
                        }
                        item {
                            Text(
                                "Destination Photos",
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        item {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(10.dp),
                                modifier = Modifier.padding(top = 20.dp, bottom = 100.dp)
                            ) {
                                ImageCard(
                                    image = R.drawable.heian,
                                    contentDescription = "Destination Photo 1",
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(20.dp))
                                        .width((screenWidth - 60.dp) * 0.33F)
                                        .height(230.dp)
                                )
                                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                                    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                        ImageCard(
                                            image = R.drawable.borobudur,
                                            contentDescription = "Destination Photo 2",
                                            modifier = Modifier
                                                .clip(RoundedCornerShape(20.dp))
                                                .width((screenWidth - 60.dp) * 0.33F)
                                                .height(110.dp)
                                        )
                                        ImageCard(
                                            image = R.drawable.lalibela,
                                            contentDescription = "Destination Photo 3",
                                            modifier = Modifier
                                                .clip(RoundedCornerShape(20.dp))
                                                .width((screenWidth - 60.dp) * 0.33F)
                                                .height(110.dp)
                                        )
                                    }
                                    ImageCard(
                                        image = R.drawable.axum,
                                        contentDescription = "Destination Photo 4",
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(20.dp))
                                            .width(((screenWidth - 60.dp) * 0.66F) + 10.dp)
                                            .height(110.dp)
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.Center,
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .background(color = Color(0x33000000))
                                                .clickable { }
                                        ) {
                                            Text("+120 more", color = Color.White)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }
        Card(
            modifier = Modifier
                .align(alignment = Alignment.BottomCenter)
                .fillMaxWidth()
                .shadow(elevation = 20.dp)
                .background(color = Color.White)
                .padding(vertical = 10.dp, horizontal = 20.dp)
                .zIndex(3f)
        )
        {
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(15.dp))
                    .fillMaxWidth()
                    .height(70.dp)
            ) {
                Text(
                    "Choose This",
                    color = Color.White,
                    fontWeight = FontWeight.W400,
                    fontSize = 20.sp,
                )
            }
        }
    }
}

@Composable
fun ImageCard(
    image: Int,
    contentDescription: String,
    modifier: Modifier = Modifier,
    content: @Composable() (BoxScope.() -> Unit) = {}
) {
    Card(
        modifier = modifier
    ) {
        Image(
            painterResource(id = image),
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box() {
            content()
        }
    }
}