package com.msoula.noteappclean.core.database.di

import android.content.Context
import androidx.room.Room
import com.msoula.noteappclean.core.database.NoteAppCleanDatabase
import com.msoula.noteappclean.core.database.dao.NoteDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): NoteAppCleanDatabase =
        Room.databaseBuilder(
            context,
            NoteAppCleanDatabase::class.java,
            "database-clean"
        )
            .build()

    @Provides
    fun providesNoteDAO(database: NoteAppCleanDatabase): NoteDAO = database.noteDAO()
}