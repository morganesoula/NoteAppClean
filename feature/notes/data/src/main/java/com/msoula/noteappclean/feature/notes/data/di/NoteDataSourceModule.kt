package com.msoula.noteappclean.feature.notes.data.di

import com.msoula.noteappclean.core.database.dao.NoteDAO
import com.msoula.noteappclean.feature.notes.data.data_sources.local.NoteLocalDataSourceImpl
import com.msoula.noteappclean.feature.notes.domain.data_sources.NoteLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NoteDataSourceModule {

    @Provides
    @Singleton
    fun provideNoteLocalDataSource(noteDAO: NoteDAO): NoteLocalDataSource =
        NoteLocalDataSourceImpl(noteDAO)
}