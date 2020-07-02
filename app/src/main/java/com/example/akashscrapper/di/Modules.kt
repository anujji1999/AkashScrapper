package com.example.akashscrapper.di

import android.app.Application
import androidx.room.Room
import com.example.akashscrapper.SplashHolder.LoginSignup.LoginSignupRepository
import com.example.akashscrapper.SplashHolder.LoginSignup.LoginSignupViewModel
import com.example.akashscrapper.database.AppDatabase
import com.example.akashscrapper.utils.PreferenceHelper
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { LoginSignupViewModel(get()) }

    single { LoginSignupRepository() }
}

val preferencesModule = module {
    single { provideSettingsPreferences(androidApplication()) }
}

fun provideSettingsPreferences(app: Application): PreferenceHelper = PreferenceHelper.getPrefs(app)

val databaseModule = module {

    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java, "akash-scrapper-database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    factory {
//        val database: AppDatabase = get()
//        database.notesDao()
    }
}
