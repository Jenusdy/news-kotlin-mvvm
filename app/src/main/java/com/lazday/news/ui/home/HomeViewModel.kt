package com.lazday.news.ui.home

import androidx.lifecycle.ViewModel
import com.lazday.news.source.repository.NewsRepository
import org.koin.dsl.module

val homeViewModule = module {
    factory { HomeViewModel(get()) }
}

class HomeViewModel(
    val repository: NewsRepository
): ViewModel() {

    val title = "News"
}