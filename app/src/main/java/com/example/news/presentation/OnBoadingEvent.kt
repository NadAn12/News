package com.example.news.presentation

sealed class OnBoadingEvent {

    object SaveAppEntry: OnBoadingEvent()
}