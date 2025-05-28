// TextDetailScreen.kt
package com.example.tuan2th2

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tuan2th2.ui.theme.Tuan2TH2Theme
import com.example.tuan2th2.ui.theme.dancingScriptFamily

@OptIn(ExperimentalMaterial3Api::class) // Cần cho TopAppBar
@Composable
fun TextDetailScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Text Detail") },
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
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding) // Áp dụng padding từ Scaffold
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Sử dụng buildAnnotatedString để tạo văn bản đa định dạng
            Text(
                text = buildAnnotatedString {
                    append("The ")
                    // Thêm gạch ngang cho "quick"
                    withStyle(
                        style = SpanStyle(textDecoration = TextDecoration.LineThrough)
                    ) {
                        append("quick")
                    }
                    append(" ")
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xFF9E4A00),
                            fontWeight = FontWeight.Bold,
                            fontSize = 34.sp
                        )
                    ) {
                        append("Brown")
                    }
                    append("\n") // Xuống dòng
                    withStyle(
                        style = SpanStyle(
                            letterSpacing = 4.sp // Tăng khoảng cách giữa các ký tự
                        )
                    ) {
                        append("fox jumps ")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append("over")
                    }
                    append("\n") // Xuống dòng
                    withStyle(
                        style = SpanStyle(
                            textDecoration = TextDecoration.Underline // Gạch chân
                        )
                    ) {
                        append("the")
                    }
                    append(" ")
                    withStyle(
                        style = SpanStyle(
                            fontStyle = FontStyle.Italic, // In nghiêng
                            fontFamily = dancingScriptFamily,
                            fontSize = 32.sp
                        )
                    ) {
                        append("lazy")
                    }
                    append(" dog.")
                },
                // Các thuộc tính áp dụng cho toàn bộ Text Composable
                fontSize = 28.sp,
                lineHeight = 40.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun TextDetailScreenPreview() {
    Tuan2TH2Theme {
        TextDetailScreen(navController = rememberNavController())
    }
}