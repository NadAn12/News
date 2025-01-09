package com.example.news.di

import android.app.Application
import androidx.room.Room
import com.example.news.data.dto.NewsApi
import com.example.news.data.local.NewsDao
import com.example.news.data.local.NewsDatabase
import com.example.news.data.local.NewsTypeConvertor
import com.example.news.data.manger.LocalUserMangerImpl
import com.example.news.data.repository.NewsRepositoryImpl
import com.example.news.domain.manger.LocalUserManger
import com.example.news.domain.repository.NewsRepository
import com.example.news.domain.usecases.app_entry.AppEntryUseCases
import com.example.news.domain.usecases.app_entry.ReadAppEntry
import com.example.news.domain.usecases.app_entry.SaveAppEntry
import com.example.news.domain.usecases.news.DeleteArticle
import com.example.news.domain.usecases.news.GetNews
import com.example.news.domain.usecases.news.NewsUseCases
import com.example.news.domain.usecases.news.SearchNews
import com.example.news.domain.usecases.news.SelectArticle
import com.example.news.domain.usecases.news.SelectArticles
import com.example.news.domain.usecases.news.UpsertArticle
import com.example.news.util.Constants.BASE_URL
import com.example.news.util.Constants.NEWS_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ): LocalUserManger = LocalUserMangerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManger: LocalUserManger
    ): AppEntryUseCases = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
    )

    @Provides
    @Singleton
    fun provideApiInstance(): NewsApi {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi,
        newsDao: NewsDao
    ): NewsRepository {
        return NewsRepositoryImpl(newsApi, newsDao)
    }

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository,
        newsDao: NewsDao
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository),
            upsertArticle = UpsertArticle(newsRepository),
            deleteArticle = DeleteArticle(newsRepository),
            selectArticle = SelectArticle(newsRepository),
            selectArticles = SelectArticles(newsRepository)
        )
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = NEWS_DATABASE_NAME
        ).addTypeConverter(NewsTypeConvertor())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao

}



