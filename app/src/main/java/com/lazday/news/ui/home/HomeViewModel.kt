package com.lazday.news.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lazday.news.source.model.CategoryModel
import com.lazday.news.source.repository.NewsRepository
import org.koin.dsl.module

val homeViewModule = module {
    factory { HomeViewModel(get()) }
}

class HomeViewModel(
    val repository: NewsRepository
): ViewModel() {

    val title = "News"
    val category by lazy { MutableLiveData<String>() }

    init {
        category.value = ""
    }

    val categories = listOf<CategoryModel>(
        CategoryModel("","Berita Utama"),
        CategoryModel("business","Bisnis"),
        CategoryModel("entertainment","Hiburan"),
        CategoryModel("general","Umum"),
        CategoryModel("health","Kesehatan"),
        CategoryModel("science","Sains"),
        CategoryModel("sports","Olahraga"),
        CategoryModel("technology","Teknologi")
    )
}