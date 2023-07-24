package com.lazday.news

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.lazday.news.source.network.networkModule
import com.lazday.news.source.repository.repositoryModule
import com.lazday.news.ui.bookmark.bookmarkModule
import com.lazday.news.ui.bookmark.bookmarkViewModule
import com.lazday.news.ui.home.homeModule
import com.lazday.news.ui.home.homeViewModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class NewsApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        Timber.e("Run Base Application")
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@NewsApplication)
            modules(
                networkModule,
                repositoryModule,
                homeViewModule,
                homeModule,
                bookmarkViewModule,
                bookmarkModule
            )
        }
    }

}