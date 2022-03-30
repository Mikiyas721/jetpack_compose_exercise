package com.coolapps.travelingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.coolapps.travelingapp.ui.theme.TravelingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TravelingAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                }
            }
        }
    }
}

data class Location(
    val backgroundImage: Int,
    val numberOfStars: Int,
    val locationName: String,
    val location: String
)

data class Trip(
    val locationImage: Int,
    val locationName: String,
    val location: String,
    val price: Double,
    val numberOfStars: Int,
    val numberOfDays: Int
)

@Preview
@Composable
fun HomePagePreview() {
    HomePage(
        popularLocations = listOf(
            Location(R.drawable.heian, 5, "Heian Shrine", "Kyoto, Japan"),
            Location(R.drawable.lalibela, 5, "Rock-Hewn Churches", "Lalibela, Ethiopia"),
            Location(R.drawable.borobudur, 4, "Borobudur", "Magelano, Indonesia"),
            Location(R.drawable.axum, 5, "Obelisk of Axum", "Axum, Ethiopia"),
        ),
        listOf(
            Trip(R.drawable.heian, "Niagara Waterfalls", "Ontario, Canada", 670.0, 5, 7),
            Trip(R.drawable.axum, "Niagara Waterfalls", "Ontario, Canada", 720.0, 4, 2),
            Trip(R.drawable.borobudur, "Niagara Waterfalls", "Ontario, Canada", 890.0, 5, 1),
            Trip(R.drawable.lalibela, "Niagara Waterfalls", "Ontario, Canada", 220.0, 3, 5)
        )
    )
}

@Composable
fun HomePage(popularLocations: List<Location>, trips: List<Trip>) {
    Scaffold(
        topBar = {
            Column(modifier = Modifier.padding(horizontal = 15.dp)) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp)
                ) {
                    Card(
                        elevation = 0.dp,
                        modifier = Modifier
                            .width(60.dp)
                            .height(60.dp)
                            .clip(RoundedCornerShape(100))
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.girl),
                            contentDescription = "User Photo",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }
                    Row {
                        Icon(
                            Icons.Rounded.Search,
                            tint = Color.Gray,
                            contentDescription = "Search Button",
                            modifier = Modifier.padding(end = 20.dp)
                        )
                        Icon(
                            Icons.Rounded.Menu,
                            tint = Color.Gray,
                            contentDescription = "Menu Button"
                        )
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.padding(top = 25.dp, bottom = 20.dp)
                ) {
                    Text(
                        text = "Discover World",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.W500
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 15.dp)
                ) {
                    TabButton(isActiveTab = true, buttonLabel = "Popular", onClick = {})
                    TabButton(isActiveTab = false, buttonLabel = "Exclusive Tour", onClick = {})
                    TabButton(isActiveTab = false, buttonLabel = "New", onClick = {})
                }
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 15.dp)
        ) {
            item {
                LazyRow(
                    modifier = Modifier.padding(top = 5.dp, bottom = 20.dp)
                ) {
                    items(popularLocations) { item ->
                        LocationCard(item)
                    }
                }
            }
            item {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 15.dp)
                ) {
                    Text(text = "Popular Category", fontSize = 18.sp)
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "more")
                    }
                }
            }
            item {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    PopularCategory(icon = Icons.Rounded.Face, label = "Festival")
                    PopularCategory(icon = Icons.Rounded.AddCircle, label = "Concert")
                    PopularCategory(icon = Icons.Rounded.Favorite, label = "Tour")
                    PopularCategory(icon = Icons.Rounded.Lock, label = "Cruise")
                }
            }
            item {
                Text(
                    text = "More Trip For You",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 25.dp, bottom = 20.dp)
                )
            }
            items(trips) { item ->
                MoreTripCard(item)
            }
        }
    }
}

@Composable
fun TabButton(
    isActiveTab: Boolean = true,
    buttonLabel: String = "Popular",
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (isActiveTab) Color.Blue else Color.LightGray
        ),
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .height(45.dp)
    ) {
        Text(
            text = buttonLabel,
            color = if (isActiveTab) Color.White else Color.Gray,
            fontSize = 18.sp
        )
    }
}

@Composable
fun LocationCard(location: Location) {
    Card(
        modifier = Modifier
            .padding(end = 15.dp)
            .height(200.dp)
            .width(180.dp)
            .clip(RoundedCornerShape(20.dp))
            .clickable { }
    ) {
        Image(
            painter = painterResource(id = location.backgroundImage),
            contentDescription = "Tour Location ${location.locationName} found in ${location.locationName}",
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(20.dp)),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 20.dp, horizontal = 10.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(color = Color(0x88808080))
                    .align(Alignment.TopEnd)
                    .padding(vertical = 3.dp, horizontal = 7.dp)
            ) {
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Location Number of Stars",
                    tint = Color.White,
                    modifier = Modifier
                        .size(20.dp)
                )
                Text(text = location.numberOfStars.toString(), color = Color.White)
            }
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
            ) {
                Text(
                    text = location.locationName,
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Rounded.Place,
                        contentDescription = "Location of the Tourist Site",
                        tint = Color.White,
                        modifier = Modifier
                            .size(20.dp)
                            .padding(end = 2.dp)
                    )
                    Text(text = location.location, color = Color.White)
                }
            }
        }
    }
}

@Composable
fun PopularCategory(icon: ImageVector, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.clickable {}) {
        Box(
            modifier = Modifier
                .padding(bottom = 8.dp)
                .clip(shape = RoundedCornerShape(15.dp))
                .background(color = Color(0x22000088))
                .size(width = 60.dp, height = 60.dp)
        ) {
            Icon(
                icon, contentDescription = "Popular Category Icon",
                modifier = Modifier
                    .align(Alignment.Center), tint = Color.White
            )
        }
        Text(label, color = Color.Gray)
    }
}

@Composable
fun MoreTripCard(trip: Trip) {
    Row(
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .padding(bottom = 15.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(20.dp))
            .background(color = Color(0x11000055))
            .height(150.dp)
            .padding(horizontal = 5.dp, vertical = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(15.dp))
                .padding(10.dp)
                .fillMaxHeight()
                .aspectRatio(0.95F)
        ) {
            Image(
                painter = painterResource(id = trip.locationImage),
                contentDescription = "More Trip Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = RoundedCornerShape(15.dp))
            )
        }
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = 10.dp)
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.TopStart)
            ) {
                Text(text = trip.locationName, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Rounded.LocationOn,
                        contentDescription = "More Trip Location",
                        tint = Color.Gray,
                    )
                    Text(
                        text = trip.location,
                        color = Color.Gray,
                        modifier = Modifier.padding(start = 5.dp)
                    )
                }

            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.align(Alignment.BottomStart)
            ) {
                Text(
                    text = "$${trip.price}",
                    color = Color.Blue,
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(5.dp))
                        .background(color = Color(0x66000055))
                        .padding(horizontal = 5.dp, vertical = 3.dp)
                )
                Row(
                    modifier = Modifier.padding(horizontal = 15.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Rounded.Star,
                        contentDescription = "More Trip Number of Stars",
                        tint = Color.Yellow
                    )
                    Text(text = trip.numberOfStars.toString(), color = Color.Yellow)
                }
                Text(text = "${trip.numberOfDays} days")
            }
        }

    }

}