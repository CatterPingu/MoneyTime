package com.example.moneytime

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moneytime.data.Card
import com.example.moneytime.ui.theme.BlueEnd
import com.example.moneytime.ui.theme.BlueStart
import com.example.moneytime.ui.theme.GreenEnd
import com.example.moneytime.ui.theme.GreenStart
import com.example.moneytime.ui.theme.OrangeEnd
import com.example.moneytime.ui.theme.OrangeStart
import com.example.moneytime.ui.theme.PurpleEnd
import com.example.moneytime.ui.theme.PurpleStart

val card = listOf(
    Card(
        cardType = "VISA",
        cardNumber = "1234 5678 9012",
        cardName = "Personal",
        balance = 46.67,
        color = getGradient(PurpleStart, PurpleEnd)
    ),Card(
        cardType = "MASTER CARD",
        cardNumber = "9876 5678 9012",
        cardName = "Business",
        balance = 46.67,
        color = getGradient(BlueStart, BlueEnd)
    ),Card(
        cardType = "VISA",
        cardNumber = "1234 5678 9012",
        cardName = "MemberShip",
        balance = 46.67,
        color = getGradient(OrangeStart, OrangeEnd)
    ),Card(
        cardType = "VISA",
        cardNumber = "1234 5678 9012",
        cardName = "Personal",
        balance = 46.67,
        color = getGradient(GreenStart, GreenEnd)
    ),
)




fun getGradient(
    startColor: Color,
    endColor: Color,
): Brush {
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}

@Composable
fun CardsSection() {
    LazyRow {
        items(card.size) { index ->
            CardItem(index)
        }
    }
}

@Composable
fun CardItem(
    index: Int
) {
    val car = card[index]
    var lastItemPaddingEnd = 0.dp
    if (index == card.size - 1) {
        lastItemPaddingEnd = 16.dp
    }

    var image = painterResource(id = R.drawable.visaicon)
    if (car.cardType == "MASTER CARD") {
        image = painterResource(id = R.drawable.mastercardlogo)
    }

    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = lastItemPaddingEnd)
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(car.color)
                .width(250.dp)
                .height(160.dp)
                .clickable {}
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Image(
                painter = image,
                contentDescription = car.cardName,
                modifier = Modifier.width(60.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = car.cardName,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Rs ${car.balance}",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = car.cardNumber,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

        }
    }
}