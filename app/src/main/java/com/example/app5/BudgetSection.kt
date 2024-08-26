package com.example.app5

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app5.ui.theme.lightGreen
import com.example.app5.ui.theme.lightRed
import com.example.app5.ui.theme.lightYellow

@Composable
fun BudgetSection(list: List<Budget>) {
    LazyRow(
        contentPadding = PaddingValues(10.dp),
        horizontalArrangement = Arrangement.Absolute.SpaceBetween
    ) {
        items(list) { item ->
            BudgetCard(budget = item)
        }
    }
}

@Composable
fun BudgetCard(budget: Budget) {
    Box(
        modifier = Modifier
            .padding(5.dp)
            .width(150.dp)
            .clip(RoundedCornerShape(25.dp))
            .drawWithContent {
                val gradient = Brush.horizontalGradient(
                    colors = listOf(Color.Transparent, budget.gradientColor),
                    startX = size.width * 0.5f,
                    endX = size.width
                )
                drawContent()
                drawRect(brush = gradient)
            }
            .aspectRatio(3.5f / 4f)
            .background(budget.color)
            .padding(15.dp)

    ) {
        Text(
            text = "VISA",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.align(Alignment.TopStart)
        )
        Column(modifier = Modifier.align(Alignment.CenterStart)) {
            Text(
                text = budget.title,
                style = MaterialTheme.typography.labelLarge,
                color = Color.Black
            )
            Text(
                text = "$ ${budget.budget}",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        Text(
            text = "•••• ${budget.description}",
            style = MaterialTheme.typography.labelLarge,
            color = Color.Black,
            modifier = Modifier.align(Alignment.BottomStart)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    BudgetSection(list = listBudget)
}

data class Budget(
    val color: Color,
    val gradientColor: Color,
    val title: String,
    val budget: String,
    val description: String
)

val listBudget = listOf<Budget>(
    Budget(
        color = lightGreen,
        Color(0xFF6EE7A0),
        "Business",
        "5.363",
        "6917"
    ),
    Budget(
        color = lightRed,
        Color(0xFFF1C995),
        "Savings",
        "3.235",
        "2375"
    ),
    Budget(
        color = lightYellow,
        Color(0xFFFCD067),
        "Credit",
        "11.235",
        "1234"
    )
)