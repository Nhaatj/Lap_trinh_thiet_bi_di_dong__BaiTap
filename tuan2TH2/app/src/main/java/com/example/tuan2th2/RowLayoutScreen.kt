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
fun RowLayoutScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Row Layout") }, // Tiêu đề cho TopAppBar
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
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues) // Áp dụng padding từ Scaffold
                .padding(horizontal = 16.dp) // Thêm padding ngang cho nội dung
                .background(Color.LightGray), // Để dễ nhìn giới hạn của Row
            horizontalArrangement = Arrangement.SpaceAround, // Phân bổ không gian đều
            verticalAlignment = Alignment.CenterVertically // Căn giữa các item theo chiều dọc
        ) {
            Text(
                text = "Row Layout Screen", // Bạn có thể giữ hoặc xóa dòng này tùy ý
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(end = 16.dp) // Padding giữa tiêu đề và các Box
            )
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.Red),
                contentAlignment = Alignment.Center
            ) {
                Text("Item 1", color = Color.White)
            }
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.Green),
                contentAlignment = Alignment.Center
            ) {
                Text("Item 2", color = Color.White)
            }
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.Blue),
                contentAlignment = Alignment.Center
            ) {
                Text("Item 3", color = Color.White)
            }
            // Spacer và Button giờ nằm trong Column riêng biệt, không bị ảnh hưởng trực tiếp bởi Row chính
            // Nếu bạn muốn Button nằm ngay cạnh các Box, hãy xem xét lại bố cục
            // Hiện tại, Button vẫn ở cuối cùng bên phải do Column bên trong Row chính
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = { navController.popBackStack() }) {
                    Text("Back to List")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RowLayoutScreenPreview() {
    Tuan2TH2Theme {
        RowLayoutScreen(navController = rememberNavController())
    }
}