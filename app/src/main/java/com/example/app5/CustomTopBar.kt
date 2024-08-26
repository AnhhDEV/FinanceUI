package com.example.app5

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app5.ui.theme.background
import com.example.app5.ui.theme.grayText
import com.example.app5.ui.theme.textColor

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar() {
    TopAppBar(
        title = { },
        navigationIcon = {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(start = 10.dp)
            ) {
                Text(
                    text = "Wallet",
                    style = MaterialTheme.typography.labelLarge,
                    color = grayText
                )
                Text(
                    text = "$ 24.532",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = textColor
                )
            }
        },
        actions = {
            Box(
                modifier = Modifier
                    .padding(end = 10.dp)
                    .size(35.dp)
                    .clip(CircleShape)
                    .background(grayText)
            ) {
                IconButton(onClick = { /*TODO*/ }, modifier = Modifier.align(Alignment.Center)) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "searchIcon",
                        tint = Color.White
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(background)
    )
}