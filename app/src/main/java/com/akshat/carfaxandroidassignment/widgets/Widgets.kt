package com.akshat.carfaxandroidassignment.widgets

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.akshat.carfaxandroidassignment.model.Listings

@Composable
fun CarDetailsRow(car: Listings, onItemClick: (String) -> Unit = { }) {

    Card(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .height(350.dp)
            .wrapContentHeight()
            .clickable {
                onItemClick(car.id)
            },
        shape = RoundedCornerShape(corner = CornerSize(6.dp)),
        colors = CardColors(
            Color.White,
            Color.Black,
            Color.White,
            Color.White
        ),
        elevation = CardDefaults.cardElevation(6.dp)

    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            CarImage(imageUrl = car.images.firstPhoto.medium)
            YearMakeModelTrimRow(car = car)
        }

        PriceMileageRow(car = car)
        AddressRow(car = car)
        HorizontalDivider()
        CallDealerRow(car = car)


    }


}

@Composable
fun CallDealerRow(car: Listings) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        ) {

            Button(
                onClick = {
                    try {
                        val number = Uri.parse("tel : " + car.dealer.phone.toString())
                        val intent = Intent(Intent.ACTION_CALL, number)
                        context.startActivity(intent)
                    } catch (s: SecurityException) {
                        Toast.makeText(context, "An error occurred", Toast.LENGTH_LONG)
                            .show()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(1.dp),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, Color.White)
            ) {
                Text(
                    text = "CALL DEALER", modifier = Modifier.padding(4.dp),
                    color = Color(0xFFEEF1EF),
                    fontSize = 17.sp
                )
            }
        }

    }
}

@Composable
fun YearMakeModelTrimRow(car: Listings) {
    Row(
        modifier = Modifier
            .padding(start = 12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(modifier = Modifier.padding(4.dp)) {

            Text(
                text = car.year.toString() + " " + car.make + " " + car.model + " " + car.trim,
                modifier = Modifier.padding(top = 10.dp),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold,
            )
        }

    }
}

@Composable
fun AddressRow(car: Listings) {

    Row(
        modifier = Modifier
            .padding(start = 12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(modifier = Modifier.padding(4.dp)) {

            Text(
                text = car.ownerHistory.history[0].city + " , " + car.ownerHistory.history[0].state,
                modifier = Modifier.padding(end = 10.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }

    }
}

@Composable
fun PriceMileageRow(car: Listings) {

    Row(
        modifier = Modifier
            .height(IntrinsicSize.Min)
            .padding(start = 12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Row(modifier = Modifier.padding(4.dp)) {
            Text(
                text = "$ " + car.currentPrice,
                modifier = Modifier.padding(end = 10.dp),
                style = MaterialTheme.typography.bodyLarge
            )

            VerticalDivider()

            Text(
                text = car.mileage.toDouble().toString() + " mi",
                modifier = Modifier.padding(start = 10.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }

}

@Composable
fun CarImage(imageUrl: String) {
    Image(
        painter = rememberImagePainter(imageUrl),
        contentDescription = "icon image",
        modifier = Modifier.size(width = 450.dp, height = 200.dp),
        contentScale = ContentScale.FillWidth
    )

}