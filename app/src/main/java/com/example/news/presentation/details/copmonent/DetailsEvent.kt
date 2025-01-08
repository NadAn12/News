package com.example.news.presentation.details.copmonent

sealed class DetailsEvent {

    object UpsertDeleteArticle : DetailsEvent()

    object RemoveSideEffect : DetailsEvent()

}