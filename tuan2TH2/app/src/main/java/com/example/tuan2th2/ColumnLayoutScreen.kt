package com.example.tuan2th2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack // Import icon back arrow
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar // Import TopAppBar
import androidx.compose.material3.Scaffold // Import Scaffold
import androidx.compose.material3.IconButton // Import IconButton
import androidx.compose.material3.Icon // Import Icon
import androidx.compose.material3.ExperimentalMaterial3Api // Import cho @OptIn
import androidx.compose.material3.MaterialTheme // Import MaterialTheme cho colors
import androidx.compose.material3.TopAppBarDefaults // Import TopAppBarDefaults cho colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tuan2th2.ui.theme.Tuan2TH2Theme

@OptIn(ExperimentalMaterial3Api::class) // Cần @OptIn khi sử dụng TopAppBar
@Composable
fun ColumnLayoutScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Column Layout") }, // Tiêu đề cho TopAppBar
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) { paddingValues -> // Sử dụng paddingValues để tránh nội dung bị che khuất bởi TopAppBar
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues) // Áp dụng padding từ Scaffold
                .padding(horizontal = 16.dp) // Thêm padding ngang cho nội dung
                .background(Color.LightGray), // Để dễ nhìn giới hạn của Column
            verticalArrangement = Arrangement.SpaceAround, // Phân bổ không gian đều
            horizontalAlignment = Alignment.CenterHorizontally // Căn giữa các item theo chiều ngang
        ) {
            Text(
                text = "Column Layout Screen", // Bạn có thể xóa dòng này nếu không muốn hiển thị
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Red),
                contentAlignment = Alignment.Center
            ) {
                Text("Item 1", color = Color.White)
            }
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Green),
                contentAlignment = Alignment.Center
            ) {
                Text("Item 2", color = Color.White)
            }
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Blue),
                contentAlignment = Alignment.Center
            ) {
                Text("Item 3", color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ColumnLayoutScreenPreview() {
    Tuan2TH2Theme {
        ColumnLayoutScreen(navController = rememberNavController())
    }
}