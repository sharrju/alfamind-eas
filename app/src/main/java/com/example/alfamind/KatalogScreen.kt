package com.example.alfamind

import android.widget.GridLayout
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun KatalogScreen() {
    val katalog = listOf(
        Items(R.drawable.img, "Mouse Wireless Logitech B175 ORIGINAL"),
        Items(R.drawable.img, "Mouse Wireless Logitech B175 ORIGINAL"),
        Items(R.drawable.img, "Mouse Wireless Logitech B175 ORIGINAL"),
        Items(R.drawable.img, "Mouse Wireless Logitech B175 ORIGINAL")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Header()
        ItemList(katalog)
    }
}

@Composable
fun Header() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color(0xFFFFFFFF))

    ) {
        Image(
            painter = painterResource(R.drawable.alfa),
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
                .padding(start = 20.dp)
                .align(Alignment.CenterStart),
        )
        Image(
            painter = painterResource(R.drawable.search_icon),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .align(Alignment.TopEnd) // Align the image to the top end (right)
                .padding(end = 16.dp, top = 16.dp) // Add padding to position the image properly
        )


    }
}

@Composable
fun ItemList(katalog: List<Items>) {
    Text(text = "Lagi Diskon", fontWeight = FontWeight.Bold, fontSize = 18.sp,
        modifier = Modifier
            .padding(start = 15.dp)

    )
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // 2 columns
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        items(katalog) { katalogs ->
            ItemCard(katalogs)
        }
    }
}

@Composable
fun ItemCard(katalogs: Items) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(310.dp)
            .width(180.dp)
            .padding(6.dp),
        shape = RoundedCornerShape(5.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5))
        //elevation = 5.dp // Add elevation
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Image(
                painter = painterResource(katalogs.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 0.dp)
                    .fillMaxWidth()
                    .width(205.dp)
                    .height(205.dp)
            )
            Spacer(modifier = Modifier.height(8.dp)) // Add space between image and text
            Text(
                text = katalogs.title,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}



