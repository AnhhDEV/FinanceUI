package com.example.app5

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.StarHalf
import androidx.compose.material.icons.filled.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app5.ui.theme.foreground
import com.example.app5.ui.theme.lightBlue
import com.example.app5.ui.theme.lightGreen
import com.example.app5.ui.theme.lightPurple

@Composable
fun FinanceSection(list: List<Finance>) {
    Column(verticalArrangement = Arrangement.Center) {
        Text(
            text = "Finance",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(start = 10.dp, top = 20.dp)
        )
        LazyRow {
            items(list) { item: Finance ->
                FinanceItem(finance = item)
            }
        }
    }
}

@Composable
fun FinanceItem(finance: Finance) {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .size(150.dp)
            .clip(RoundedCornerShape(40.dp))
            .aspectRatio(1f)
            .background(foreground)
            .padding(20.dp)
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(finance.color)
                .aspectRatio(1f)
                .align(Alignment.TopStart)
        ) {
            Icon(
                imageVector = finance.icon,
                contentDescription = finance.title,
                tint = Color.White,
                modifier = Modifier.size(40.dp).align(
                    Alignment.Center
                )
            )
        }
        Text(
            text = finance.title,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.BottomStart)
        )
    }
}

val listFinance = listOf(
    Finance(
        lightBlue,
        "My bonuses",
        Icons.Filled.StarHalf
    ),
    Finance(
        lightGreen,
        "My budget",
        Icons.Filled.Wallet
    ),
    Finance(
        lightPurple,
        "Finance, analysis",
        Icons.Filled.Analytics
    )
)

data class Finance(
    val color: Color,
    val title: String,
    val icon: ImageVector
)

@Preview(showBackground = true)
@Composable
fun Preview1() {
    FinanceSection(list = listFinance)
}