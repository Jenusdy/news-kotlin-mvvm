package com.lazday.news.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lazday.news.source.model.CategoryModel
import com.lazday.news.source.model.NewsModel
import com.lazday.news.source.repository.NewsRepository
import kotlinx.coroutines.launch
import org.koin.dsl.module

val homeViewModule = module {
    factory { HomeViewModel(get()) }
}

class HomeViewModel(
    val repository: NewsRepository
): ViewModel() {

    val title = "News"
    val category by lazy { MutableLiveData<String>() }
    val message by lazy { MutableLiveData<String>() }
    val loading by lazy { MutableLiveData<Boolean>() }
    val news by lazy { MutableLiveData<NewsModel>() }

    init {
        category.value = ""
        message.value = null
    }

    fun fetch () {
        loading.value = true
        viewModelScope.launch {
            try {
                val response = repository.fetch(
                    category.value!!,
                    "",
                    1
                )
                news.value = response
                loading.value = false
            } catch (e: Exception) {
                message.value = "Terjadi kesalahan!"
            }

        }
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