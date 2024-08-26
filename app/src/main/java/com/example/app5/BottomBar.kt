package com.example.app5

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.AutoGraph
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Wallet
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

    @Preview(showBackground = true)
@Composable
fun BottomBar() {
    var selectedIndex by remember {
        mutableIntStateOf(0)
    }
    Box {
        NavigationBar(containerColor = Color(0xFF262626)) {
            listBottomBarItem.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = selectedIndex == index,
                    onClick = {
                        selectedIndex = index
                    },
                    icon = {
                        if (selectedIndex == index) {
                            Icon(
                                imageVector = item,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(35.dp)
                            )
                        } else {
                            Icon(
                                imageVector = item,
                                contentDescription = null,
                                tint = Color(0xFF7D7D7D),
                                modifier = Modifier.size(35.dp)
                            )
                        }
                    },
                    colors = NavigationBarItemDefaults.colors(indicatorColor = Color(0xFF262626))
                )
            }
        }
        Divider(
            modifier = Modifier.align(Alignment.TopStart),
            color = Color(0xFF313333),
            thickness = 1.dp
        )
    }
}

val listBottomBarItem = listOf<ImageVector>(
    Icons.Filled.Apps,
    Icons.Filled.Wallet,
    Icons.Filled.Message,
    Icons.Filled.AutoGraph
)


