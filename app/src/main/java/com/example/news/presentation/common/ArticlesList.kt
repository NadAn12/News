package com.example.news.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.motion.widget.MotionScene.Transition.TransitionOnClick
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.news.domain.model.Article
import com.example.news.presentation.Dimens.MediumPadding1
import kotlin.math.E

@Composable
fun ArticlesList(
    modifier: Modifier = Modifier,
    article: LazyPagingItems<Article>,
    onClick:(Article) -> Unit
){

}

@Composable
fun handlePagingResult( articles: LazyPagingItems<Article>, ):Boolean {
    val loadState = articles.loadState
    val error = when{
        loadState is LoadState.Error -> loadState.refresh as LoadState.Error
        loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
        loadState.append is LoadState.Error -> loadState.append as LoadState.Error
        else -> null
    }

    return when{
        loadState.refresh is LoadState.Loading ->{
            ShimmerEffecrt()
            false

        }
        error != null -> {
            EmptyScreen()
            false
        }
        else -> {
            true
        }
    }
}

@Composable
private fun ShimmerEffecrt() {
    Column(verticalArrangement = Arrangement.spacedBy(MediumPadding1)) {
        repeat(10){
            ArticleCardShimmerEffect(
                modifier = Modifier.padding(horizontal = MediumPadding1)
            )
        }
    }
}