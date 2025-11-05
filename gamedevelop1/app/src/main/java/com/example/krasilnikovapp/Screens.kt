package com.example.krasilnikovapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(viewModel: MainViewModel) {
    // Експеримент з remember vs rememberSaveable
    var rememberText by remember { mutableStateOf("Remember: зникне при повороті") }
    var saveableText by rememberSaveable { mutableStateOf("Saveable: збережеться") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Домашня сторінка",
            fontSize = 28.sp,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(32.dp))

        // ViewModel текст (зберігається при повороті)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Text(
                text = viewModel.homeText.value,
                fontSize = 18.sp,
                modifier = Modifier.padding(16.dp)
            )
        }

        Button(
            onClick = { viewModel.updateHomeText() },
            modifier = Modifier
                .width(250.dp)
                .height(60.dp)
                .padding(vertical = 8.dp)
        ) {
            Text("Оновити (ViewModel)", fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Divider()

        Spacer(modifier = Modifier.height(16.dp))

        // Remember - зникає при повороті
        Text(text = rememberText, fontSize = 14.sp)
        Button(
            onClick = { rememberText = "Remember: ${System.currentTimeMillis() % 10000}" },
            modifier = Modifier.width(200.dp)
        ) {
            Text("Remember Test")
        }

        Spacer(modifier = Modifier.height(12.dp))

        // RememberSaveable - зберігається
        Text(text = saveableText, fontSize = 14.sp)
        Button(
            onClick = { saveableText = "Saveable: ${System.currentTimeMillis() % 10000}" },
            modifier = Modifier.width(200.dp)
        ) {
            Text("Saveable Test")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Поверніть екран, щоб побачити різницю",
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun FavoritesScreen(viewModel: MainViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp, vertical = 16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "⭐ Улюблене",
            fontSize = 32.sp,
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.tertiary
        )

        Spacer(modifier = Modifier.height(40.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Text(
                text = viewModel.favoritesText.value,
                fontSize = 20.sp,
                modifier = Modifier.padding(20.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { viewModel.updateFavoritesText() },
            modifier = Modifier
                .width(280.dp)
                .height(70.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.tertiary
            )
        ) {
            Text("Додати до улюбленого", fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Тут можна зберігати ваші улюблені елементи",
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
fun ProfileScreen(viewModel: MainViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "Профіль користувача",
                fontSize = 26.sp,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(top = 16.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Персональні дані",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.secondary
            )
        }

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End
        ) {
            Card(
                modifier = Modifier
                    .width(300.dp)
                    .padding(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                )
            ) {
                Text(
                    text = viewModel.profileText.value,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(16.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { viewModel.updateProfileText() },
                modifier = Modifier
                    .width(220.dp)
                    .height(55.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary
                )
            ) {
                Text("Редагувати профіль", fontSize = 15.sp)
            }
        }

        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "Версія додатку: 1.0.0",
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.outline,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = "© 2025 Krasilnikov App",
                fontSize = 10.sp,
                color = MaterialTheme.colorScheme.outline
            )
        }
    }
}