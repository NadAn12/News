package com.example.news.domain.usecases

import com.example.news.domain.manger.LocalUserManger
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(private val localUserManger: LocalUserManger
) {
    operator fun invoke(): Flow<Boolean> {
        return localUserManger.readAppEntry()
    }
}