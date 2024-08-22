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
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.akshat.carfaxandroidassignment.model.Listings

@Composable
fun CarDetailsRow(
    car: Listings,
    isMainScreen: Boolean = true,
    onItemClick: (Listings) -> Unit = { },
) {

    Card(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .then(if (isMainScreen) Modifier.height(350.dp) else Modifier.fillMaxHeight())
            .wrapContentHeight()
            .clickable {
                onItemClick(car)
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
        if (isMainScreen) {
            AddressRow(car = car)
            HorizontalDivider()
        } else {
            HorizontalDivider()
            VehicalInfoTextRow()
            VehicalInfoAttrubitesRow1(car = car)
            VehicalInfoAttrubitesRow2(car = car)
            VehicalInfoAttrubitesRow3(car = car)
            VehicalInfoAttrubitesRow4(car = car)
            VehicalInfoAttrubitesRow5(car = car)
            VehicalInfoAttrubitesRow6(car = car)
            VehicalInfoAttrubitesRow7(car = car)
            VehicalInfoAttrubitesRow8(car = car)
            HorizontalDivider(thickness = 4.dp)
        }
        CallDealerRow(car = car)


    }


}

@Composable
fun VehicalInfoAttrubitesRow8(car: Listings) {
    Row(
        modifier = Modifier
            .padding(start = 12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(30.dp)
    ) {

        Row(modifier = Modifier.padding(4.dp)) {
            Text(
                text = "Fuel",
                modifier = Modifier.padding(end = 10.dp),
                color = Color.DarkGray,
                style = MaterialTheme.typography.bodyLarge,
            )
        }

        Row(modifier = Modifier.padding(4.dp)) {
            Text(
                text = car.fuel,
                modifier = Modifier.padding(end = 30.dp),
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.bodyLarge,
            )
        }
    }
}

@Composable
fun VehicalInfoAttrubitesRow7(car: Listings) {
    Row(
        modifier = Modifier
            .padding(start = 12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(35.dp)
    ) {

        Row(modifier = Modifier.padding(4.dp)) {
            Text(
                text = "Engine",
                modifier = Modifier.padding(end = 10.dp),
                color = Color.DarkGray,
                style = MaterialTheme.typography.bodyLarge,
            )
        }

        Row(modifier = Modifier.padding(4.dp)) {
            Text(
                text = car.engine,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.bodyLarge,
            )
        }
    }
}

@Composable
fun VehicalInfoAttrubitesRow6(car: Listings) {
    Row(
        modifier = Modifier
            .padding(start = 12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(30.dp)
    ) {

        Row(modifier = Modifier.padding(4.dp)) {
            Text(
                text = "Body Style",
                modifier = Modifier.padding(end = 10.dp),
                color = Color.DarkGray,
                style = MaterialTheme.typography.bodyLarge,
            )
        }

        Row(modifier = Modifier.padding(4.dp)) {
            Text(
                text = car.bodytype,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.bodyLarge,
            )
        }
    }
}

@Composable
fun VehicalInfoAttrubitesRow5(car: Listings) {
    Row(
        modifier = Modifier
            .padding(start = 12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        Row(modifier = Modifier.padding(4.dp)) {
            Text(
                text = "Transmission",
                modifier = Modifier.padding(end = 10.dp),
                color = Color.DarkGray,
                style = MaterialTheme.typography.bodyLarge,
            )
        }

        Row(modifier = Modifier.padding(1.dp)) {
            Text(
                text = car.transmission,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.bodyLarge,
            )
        }
    }
}

@Composable
fun VehicalInfoAttrubitesRow4(car: Listings) {
    Row(
        modifier = Modifier
            .padding(start = 12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        Row(modifier = Modifier.padding(4.dp)) {
            Text(
                text = "Drive Type",
                modifier = Modifier.padding(end = 10.dp),
                color = Color.DarkGray,
                style = MaterialTheme.typography.bodyLarge,
            )
        }

        Row(modifier = Modifier.padding(4.dp)) {
            Text(
                text = car.drivetype,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.bodyLarge,
            )
        }
    }
}

@Composable
fun VehicalInfoAttrubitesRow3(car: Listings) {
    Row(
        modifier = Modifier
            .padding(start = 12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {

        Row(modifier = Modifier.padding(4.dp)) {
            Text(
                text = "Interior Color",
                modifier = Modifier.padding(end = 10.dp),
                color = Color.DarkGray,
                style = MaterialTheme.typography.bodyLarge,
            )
        }

        Row(modifier = Modifier.padding(2.dp)) {
            Text(
                text = car.interiorColor,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.bodyLarge,
            )
        }
    }
}

@Composable
fun VehicalInfoAttrubitesRow2(car: Listings) {
    Row(
        modifier = Modifier
            .padding(start = 12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {

        Row(modifier = Modifier.padding(4.dp)) {
            Text(
                text = "Exterior Color",
                modifier = Modifier.padding(end = 10.dp),
                color = Color.DarkGray,
                style = MaterialTheme.typography.bodyLarge,
            )
        }

        Row(modifier = Modifier.padding(2.dp)) {
            Text(
                text = car.exteriorColor,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.bodyLarge,
            )
        }
    }
}

@Composable
fun VehicalInfoAttrubitesRow1(car: Listings) {
    Row(
        modifier = Modifier
            .padding(start = 12.dp, top = 15.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(35.dp)
    ) {

        Row(modifier = Modifier.padding(4.dp)) {
            Text(
                text = "Location ",
                color = Color.DarkGray,
                style = MaterialTheme.typography.bodyLarge,
            )
        }

        Row(modifier = Modifier.padding(4.dp)) {
            Text(
                text = car.ownerHistory.history[0].city + " , " + car.ownerHistory.history[0].state,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Start,

                )
        }
    }


}

@Composable
fun VehicalInfoTextRow() {
    Row(
        modifier = Modifier
            .padding(start = 12.dp, top = 12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Row(modifier = Modifier.padding(4.dp)) {
            Text(
                text = "Vehicle Info",
                modifier = Modifier.padding(end = 10.dp),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
        }

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