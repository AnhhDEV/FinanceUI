package com.example.app5

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.app5.ui.theme.background

@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    val scrollState = rememberScrollState()
    Scaffold (
        topBar = {
            CustomTopAppBar()
        },
        bottomBar = {
            BottomBar()
        },
        containerColor = background
    ) { values ->
        Column (modifier = Modifier.padding(values).verticalScroll(scrollState)) {
            BudgetSection(list = listBudget)
            FinanceSection(list = listFinance)
            LowerPanel()
        }
    }
}