package com.lazday.news.ui.bookmark

import androidx.lifecycle.ViewModel
import com.lazday.news.source.repository.NewsRepository
import org.koin.dsl.module

val bookmarkViewModule = module {
    factory { BookmarkViewModel(get()) }
}

class BookmarkViewModel(
    val repository: NewsRepository
): ViewModel() {

    val title = "Bookmark"
}