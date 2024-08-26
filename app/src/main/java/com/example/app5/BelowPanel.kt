package com.example.app5

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app5.ui.theme.BadgeDollarSign
import com.example.app5.ui.theme.BadgeEuro
import com.example.app5.ui.theme.BadgeIndianRupee
import com.example.app5.ui.theme.BadgeJapaneseYen
import kotlinx.coroutines.launch

@OptIn(ExperimentalAnimationApi::class)
@Preview(showBackground = true)
@Composable
fun LowerPanel() {
    var visible by rememberSaveable {
        mutableStateOf(true)
    }
    val scrollState = rememberScrollState()
    Box(
        modifier =
        Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
            .clip(RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp))
            .background(Color(0xFF262626))
            .padding(15.dp)
    ) {
        AnimatedVisibility(
            visible = visible,
            enter = slideInVertically() + fadeIn(),
            exit = slideOutVertically() + fadeOut()
        ) {
            Box(
                modifier = Modifier
                    .height(400.dp)
                    .fillMaxWidth()
                    .background(Color(0xFF262626))
                    .clip(RoundedCornerShape(30.dp))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp, top = 60.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color(0xFF0F0F0F))
                        .align(Alignment.TopStart)
                        .padding(20.dp)
                ) {
                    Column {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(text = "Currencies", color = Color(0xFF707070))
                            Text(text = "Buy", color = Color(0xFF707070))
                            Text(text = "Sell", color = Color(0xFF707070))
                        }
                        LazyColumn(
                            contentPadding = PaddingValues(10.dp),
                            modifier = Modifier.scrollable(
                                scrollState,
                                orientation = Orientation.Vertical
                            )
                        ) {
                            items(listCurrency) { item: CurrencyItem ->
                                CurrencyItemUI(currencyItem = item)
                                Spacer(modifier = Modifier.size(10.dp))
                            }
                            items(listCurrency) { item: CurrencyItem ->
                                CurrencyItemUI(currencyItem = item)
                                Spacer(modifier = Modifier.size(10.dp))
                            }
                        }
                    }
                }
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.align(Alignment.TopStart)
        ) {
            Box(
                modifier = Modifier
                    .padding(end = 20.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF7D7D7D))
                    .size(20.dp)
                    .aspectRatio(1f)
                    .clickable {
                        visible = !visible
                    }
            ) {
                if (visible) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowDown,
                        contentDescription = "down",
                        tint = Color(0xFFEBEBEB),
                        modifier = Modifier
                            .size(20.dp)
                            .align(Alignment.Center)
                    )
                } else {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowUp,
                        contentDescription = "down",
                        tint = Color(0xFFEBEBEB),
                        modifier = Modifier
                            .size(20.dp)
                            .align(Alignment.Center)
                    )
                }
            }
            Text(
                text = "Currencies",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFBFBFB)
            )
        }
        Box(
            modifier = Modifier
                .padding(top = 10.dp)
                .size(20.dp)
                .clip(RoundedCornerShape(5.dp))
                .background(Color(0xFF7D7D7D))
                .aspectRatio(1f)
                .align(Alignment.TopEnd)
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "add",
                tint = Color(0xFFEBEBEB),
                modifier = Modifier
                    .size(20.dp)
                    .align(Alignment.Center)
            )
        }

    }
}

@Composable
fun CurrencyItemUI(currencyItem: CurrencyItem) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .aspectRatio(1f)
                    .background(Color(0xFF71D097))
            ) {
                Icon(
                    imageVector = currencyItem.icon,
                    contentDescription = currencyItem.title,
                    tint = Color.White,
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.Center)
                )
            }
            Text(
                text = currencyItem.title,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 7.dp)
            )
        }
        Text(text = "$ ${currencyItem.cost1}", color = Color.White, fontWeight = FontWeight.Bold)
        Text(text = "$ ${currencyItem.cost2}", color = Color.White, fontWeight = FontWeight.Bold)
    }
}

val listCurrency = listOf(
    CurrencyItem(
        BadgeDollarSign,
        "USD",
        "27.43",
        "27.60"
    ),
    CurrencyItem(
        BadgeEuro,
        "EUR",
        "33.34",
        "33.70"
    ),
    CurrencyItem(
        BadgeJapaneseYen,
        "YEN",
        "0.25",
        "0.27"
    ),
    CurrencyItem(
        BadgeIndianRupee,
        "RUPEE",
        "0.35",
        "1.24"
    )
)

data class CurrencyItem(
    val icon: ImageVector,
    val title: String,
    val cost1: String,
    val cost2: String
)