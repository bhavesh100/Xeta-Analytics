package com.bhavesh.xetaanalyticsassignment

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage( click: () -> Unit){
    Scaffold(
        topBar = {
            TopAppBar(title = {  Text(
                text = "DietSnap",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFFA000)
                )
            )
            })
        }
    ) { paddingValues ->
        DietSnapUI(paddingValues){
            click()
        }
    }
}