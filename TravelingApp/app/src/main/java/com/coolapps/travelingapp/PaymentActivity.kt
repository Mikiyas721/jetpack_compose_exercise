package com.coolapps.travelingapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex

@Preview
@Composable
fun PaymentPage() {
    Scaffold(
        topBar = {
            Row(modifier = Modifier.padding(vertical = 20.dp, horizontal = 20.dp)) {
                Box(
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(15.dp))
                        .background(color = Color(0x550055FF))
                        .clickable { }
                        .padding(15.dp)
                ) {
                    Icon(
                        Icons.Rounded.ArrowBack,
                        contentDescription = "Go Back",
                        tint = Color.White,
                        modifier = Modifier.align(alignment = Alignment.Center)
                    )
                }
            }
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(elevation = 20.dp)
                    .background(color = Color.White)
                    .padding(vertical = 10.dp, horizontal = 20.dp)
            ) {
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(12.dp))
                        .fillMaxWidth()
                        .height(70.dp)
                ) {
                    Text(
                        "Pay Now",
                        color = Color.White,
                        fontWeight = FontWeight.W400,
                        fontSize = 20.sp,
                    )
                }
            }
        }
    ) {
        Column(modifier = Modifier.padding(horizontal = 20.dp)) {
            Text(
                "Pay Your Order",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 10.dp)
            )
            Text(
                "Choose the provider and make a payment",
                fontSize = 18.sp,
                color = Color.LightGray,
                modifier = Modifier.padding(top = 10.dp, bottom = 30.dp)
            )
            Text(
                "Payment Method",
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Gray,
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, bottom = 25.dp)
            ) {
                PaymentButton(
                    icon = Icons.Rounded.Home,
                    label = "Bank",
                    onClick = {}
                )
                PaymentButton(
                    icon = Icons.Rounded.Share,
                    label = "Payout",
                    onClick = {}
                )
                PaymentButton(
                    icon = Icons.Rounded.Phone,
                    label = "Google",
                    onClick = {}
                )
            }
            Text(
                "Payment Details",
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Gray,
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(15.dp),
                modifier = Modifier.padding(top = 20.dp, bottom = 30.dp)
            ) {
                OutlinedTextField(
                    value = "", onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth()
                )
                OutlinedTextField(
                    value = "", onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Row(horizontalArrangement = Arrangement.spacedBy(15.dp)) {
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                    )
                }
            }
            Text("You have to pay", color = Color.Gray)
            Text(
                "$700.00",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Yellow,
                modifier = Modifier.padding(top = 10.dp)
            )
        }
    }

}

@Composable
fun PaymentButton(icon: ImageVector, label: String, onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Color.Blue,
            backgroundColor = Color.Transparent,
        ),
        modifier = Modifier
            .height(50.dp)
            .clip(shape = RoundedCornerShape(15.dp))
    ) {
        Icon(icon, contentDescription = "Pay With Bank")
        Text(label, modifier = Modifier.padding(start = 10.dp))
    }
}