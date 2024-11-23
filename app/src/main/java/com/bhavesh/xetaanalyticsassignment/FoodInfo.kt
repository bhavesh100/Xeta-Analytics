package com.bhavesh.xetaanalyticsassignment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.bhavesh.xetaanalyticsassignment.view_model.XetaViewModel
import androidx.compose.ui.layout.ContentScale.Companion as ContentScale1

@Composable
fun FoodInfo(){
    FoodInformationScreen()
}
@Composable
fun FoodInformationScreen(
    viewModel: XetaViewModel = viewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.getFoodApiDto()

    }
    val foodApiDto by viewModel.foodApiDto

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.White)
    ) {
        // Header with Image and Overlay
        Box {
            if(foodApiDto != null){
                AsyncImage(
                    model = foodApiDto!!.data.image,
                    contentDescription = "Fried Chicken",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale1.Crop
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Back",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 16.sp,
                        color = Color.White
                    )
                )
            }
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(16.dp)
            ) {
                Text(
                    text = "foodApiDto!!.message",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontSize = 24.sp,
                        color = Color.White
                    )
                )
                Text(
                    text = "Food Information",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 16.sp,
                        color = Color.White
                    )
                )
            }
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
                    .background(
                        color = Color(0x66000000),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Text(
                    text = "71 out of 100",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 14.sp,
                        color = Color.White
                    )
                )
            }
        }

        // Description Section
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Description",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Fried chicken is a dish consisting of chicken pieces usually from broiler chickens which have been floured or battered and then pan-fried, deep-fried, or pressure-fried.",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
        }

        // Macro Nutrients Section
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Macro Nutrients",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Card(
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    TableRow("Energy", "415 J", "600 J")
                    TableRow("Protein", "2g", "6g")
                    TableRow("Trans Fat", "0.5g", "1g")
                    TableRow("Carbohydrates", "3g", "5.5g")
                    TableRow("Fibre", "4g", "7.2g")
                }
            }
        }

        // Facts Section
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Facts",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color(0xFFFFF3CD), shape = RoundedCornerShape(8.dp))
                    .padding(16.dp)
            ) {
                Column {
                    Text(
                        text = "Did you know?",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(0xFF856404),
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "There are more chickens on earth than people – 25 billion. There are also more chickens than any other bird species.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(0xFF856404)
                    )
                }
            }
        }

        // Similar Items Section
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Similar Items",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
//                items(similarItems) { item ->
//                    SimilarItemCard(item)
//                }
            }
        }
    }
}

@Composable
fun TableRow(label: String, perServe: String, per250gm: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, style = MaterialTheme.typography.bodyMedium)
        Text(text = perServe, style = MaterialTheme.typography.bodyMedium)
        Text(text = per250gm, style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun SimilarItemCard(item: String) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .size(120.dp)
            .background(Color.LightGray)
    ) {
        Text(
            text = item,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(8.dp)
        )
    }
}