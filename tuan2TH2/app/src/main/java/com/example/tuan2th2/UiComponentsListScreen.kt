package com.example.tuan2th2

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable // Import cho Modifier.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape // Import cho góc bo tròn
import androidx.compose.material3.Card // Sử dụng Card để có bo tròn và đổ bóng
import androidx.compose.material3.CardDefaults // Import CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api // Cho TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold // Để có TopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip // Để cắt góc của Card
import androidx.compose.ui.graphics.Color // Để dùng màu custom
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tuan2th2.ui.theme.Tuan2TH2Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UiComponentsListScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("UI Components List") },
                // Không có navigationIcon vì đây là màn hình chính của danh sách
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues) // Áp dụng padding từ Scaffold
                .padding(horizontal = 16.dp, vertical = 8.dp), // Padding tổng thể cho nội dung
            verticalArrangement = Arrangement.spacedBy(8.dp) // Khoảng cách giữa các mục
        ) {
            // Category: Display
            item {
                Text(
                    text = "Display",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                )
            }
            item {
                ComponentListItem(
                    name = "Text",
                    description = "Chữ được định dạng nhiều kiểu",
                    onClick = { navController.navigate("text_detail") }
                )
            }
            item {
                ComponentListItem(
                    name = "Image",
                    description = "Hình ảnh",
                    onClick = { navController.navigate("images_screen") }
                )
            }

            // Category: Input
            item {
                Text(
                    text = "Input",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 16.dp, bottom = 4.dp)
                )
            }
            item {
                ComponentListItem(
                    name = "TextField",
                    description = "Trường điền chữ",
                    onClick = { navController.navigate("textfield_screen") }
                )
            }
            item {
                ComponentListItem(
                    name = "PasswordField",
                    description = "Trường điền mật khẩu",
                    onClick = { navController.navigate("passwordfield_screen") }
                )
            }

            // Category: Layout
            item {
                Text(
                    text = "Layout",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 16.dp, bottom = 4.dp)
                )
            }
            item {
                ComponentListItem(
                    name = "Column",
                    description = "Sắp xếp các item theo chiều dọc",
                    onClick = { navController.navigate("column_layout") }
                )
            }
            item {
                ComponentListItem(
                    name = "Row",
                    description = "Sắp xếp các item theo chiều ngang",
                    onClick = { navController.navigate("row_layout") }
                )
            }
        }
    }
}

@Composable
fun ComponentListItem(name: String, description: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp)) // Bo tròn góc
            .clickable(onClick = onClick), // Thêm khả năng click vào Card
        colors = CardDefaults.cardColors( // Dùng CardDefaults để thiết lập màu nền
            containerColor = Color(0xFFE0F2F7) // Màu xanh nhạt
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp) // Padding bên trong Card
            // Không cần background ở đây nữa, vì Card đã có màu nền
        ) {
            Text(
                text = name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = description,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}

// Preview cho UiComponentsListScreen
@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun UiComponentsListScreenPreview() {
    Tuan2TH2Theme {
        UiComponentsListScreen(navController = rememberNavController())
    }
}