package com.example.news.presentation

import androidx.annotation.DrawableRes
import com.example.news.R

data class Page (
    val title:String,
    val description: String,
    @DrawableRes val image: Int

)

val pages = listOf(
    Page(
        title = "Добро пожаловать!",
        description = "Мы рады видеть вас среди пользователей!" +
                " Это приложение предлагает персонализированные ленты новостей," +
                " удобный интерфейс и частое обновления" +
                "." +
                " Наслаждайтесь свежими новостями!",


        image = R.drawable.slyde1
    )
)