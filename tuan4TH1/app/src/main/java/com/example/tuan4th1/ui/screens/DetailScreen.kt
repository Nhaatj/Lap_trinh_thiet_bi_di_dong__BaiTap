package com.example.tuan4th1.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavController, itemIndex: String?) {
    // Giả sử chúng ta có một danh sách các câu trích dẫn
    val quotes = List(1_000_000) {
        "The only way to do great work is to love what you do."
    }
    val authors = List(1_000_000) {
        "Steve Jobs"
    }

    val quoteText = itemIndex?.toIntOrNull()?.let { index ->
        quotes.getOrNull(index)
    } ?: "N/A"

    val authorText = itemIndex?.toIntOrNull()?.let { index ->
        authors.getOrNull(index)
    } ?: "N/A"


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detail", color = Color.Black) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = "Back",
                            tint = Color.Black
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween // Để nút BACK TO ROOT ở dưới cùng
            ) {
                Spacer(modifier = Modifier.height(16.dp))

                // Phần câu trích dẫn ở trên cùng
                Text(
                    text = quoteText,
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 32.dp)
                )

                // Card chứa câu trích dẫn lớn
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFCDE8FF)) // Màu nền xanh nhạt
                ) {
                    Column(
                        modifier = Modifier
                            .padding(24.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "\"${quoteText}\"",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = authorText,
                            fontSize = 18.sp,
                            textAlign = TextAlign.End,
                            modifier = Modifier.fillMaxWidth(),
                            color = Color.Black
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp)) // Để đẩy nút BACK TO ROOT xuống dưới

                // Link
                Text(
                    text = "http://quotes.thegreatquotes.com/",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Spacer(modifier = Modifier.weight(1f)) // Đẩy nút BACK TO ROOT xuống dưới cùng

                // Nút BACK TO ROOT
                Button(
                    onClick = {
                        // PopUpTo destination "navigation_screen" để xóa tất cả các màn hình trên stack
                        // và inclusive = true để xóa cả "navigation_screen" khỏi stack nếu nó ở trên cùng,
                        // sau đó điều hướng lại đến "navigation_screen" để tạo mới
                        navController.popBackStack("navigation_screen", inclusive = false)
                        navController.navigate("navigation_screen") {
                            // Đảm bảo không tạo lại một instance nếu đã có trên stack
                            launchSingleTop = true
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .padding(bottom = 16.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF007AFF))
                ) {
                    Text(text = "BACK TO ROOT", color = Color.White, fontSize = 18.sp)
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewDetailScreen() {
    DetailScreen(navController = rememberNavController(), itemIndex = "0")
}