package com.example.krasilnikovapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _homeText = mutableStateOf("Натисніть кнопку на головному екрані")
    val homeText: State<String> = _homeText

    private val _favoritesText = mutableStateOf("Ваші улюблені елементи")
    val favoritesText: State<String> = _favoritesText

    private val _profileText = mutableStateOf("Інформація про профіль")
    val profileText: State<String> = _profileText

    fun updateHomeText() {
        _homeText.value = "Кнопку натиснуто о ${System.currentTimeMillis() % 100000}"
    }

    fun updateFavoritesText() {
        _favoritesText.value = "Оновлено: ${System.currentTimeMillis() % 100000}"
    }

    fun updateProfileText() {
        _profileText.value = "Профіль змінено: ${System.currentTimeMillis() % 100000}"
    }
}