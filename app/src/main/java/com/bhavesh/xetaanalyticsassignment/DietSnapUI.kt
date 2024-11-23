package com.bhavesh.xetaanalyticsassignment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DietSnapUI(
    paddingValues: PaddingValues,
    click: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(start = 10.dp, end = 10.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // AppBar Section

        Spacer(modifier = Modifier.height(16.dp))

        // Date Section
        Text(
            text = "Today",
            style = MaterialTheme.typography.titleMedium.copy(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = "Thursday, 22nd Oct",
            style = MaterialTheme.typography.bodySmall.copy(
                fontSize = 14.sp,
                color = Color.Gray
            )
        )
        Spacer(modifier = Modifier.height(24.dp))

        // Circular Progress Section
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(200.dp)
                .align(Alignment.CenterHorizontally)
                .background(
                    shape = CircleShape,
                    color = Color(0xFFEFEFEF)
                )
        ) {
            Text(
                text = "SET GOAL!",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            )
        }
        Spacer(modifier = Modifier.height(32.dp))

        // Metrics Section
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            MetricItem(title = "Diet Pts", value = "1500 Cal")
            MetricItem(title = "Exercise Pts", value = "3/5 Days")
            MetricItem(title = "Health Score", value = "88")
        }
        Spacer(modifier = Modifier.height(24.dp))

        // Your Goals Section
        Text(
            text = "Your Goals",
            style = MaterialTheme.typography.titleMedium.copy(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(8.dp))

        GoalItem(
            title = "Keto Weight loss plan",
            subtitle = "Current Major Goal",
            progress = "73%"
        )
        Spacer(modifier = Modifier.height(24.dp))

        // Explore Section
        Text(
            text = "Explore",
            style = MaterialTheme.typography.titleMedium.copy(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(8.dp))

        ExploreItem(
            title = "Find Diets",
            subtitle = "Find premade diets according to your cuisine"
        )
        Button(onClick = { click() }) {
            Text(text = "Meal Screen")
        }
    }
}

@Composable
fun MetricItem(title: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            ),
            textAlign = TextAlign.Center
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodySmall.copy(
                fontSize = 12.sp,
                color = Color.Gray
            ),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun GoalItem(title: String, subtitle: String, progress: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .background(color = Color(0xFFF0F0F0), shape = RoundedCornerShape(8.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(
                    shape = CircleShape,
                    color = Color(0xFFE0E0E0)
                )
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            )
        }
        Text(
            text = progress,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2196F3)
            )
        )
    }
}

@Composable
fun ExploreItem(title: String, subtitle: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(color = Color(0xFFF9F9F9), shape = RoundedCornerShape(8.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(
                    shape = CircleShape,
                    color = Color(0xFFE0E0E0)
                )
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            )
        }
    }
}