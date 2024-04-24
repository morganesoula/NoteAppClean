package com.msoula.noteappclean.feature.notes.domain.di

import com.msoula.noteappclean.feature.notes.domain.data_sources.NoteLocalDataSource
import com.msoula.noteappclean.feature.notes.domain.repositories.NoteRepository
import com.msoula.noteappclean.feature.notes.domain.use_cases.FetchNoteByIdUseCase
import com.msoula.noteappclean.feature.notes.domain.use_cases.InsertNoteUseCase
import com.msoula.noteappclean.feature.notes.domain.use_cases.ObserveNotesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NoteDomainModule {

    @Provides
    @Singleton
    fun provideNoteRepository(
        noteLocalDataSource: NoteLocalDataSource
    ): NoteRepository {
        return NoteRepository(noteLocalDataSource)
    }

    @Provides
    fun provideInsertNoteUseCase(noteRepository: NoteRepository): InsertNoteUseCase {
        return InsertNoteUseCase(noteRepository)
    }

    @Provides
    fun provideObserveNotesUseCase(noteRepository: NoteRepository): ObserveNotesUseCase {
        return ObserveNotesUseCase(noteRepository)
    }

    @Provides
    fun provideFetchNoteByIdUseCase(noteRepository: NoteRepository): FetchNoteByIdUseCase {
        return FetchNoteByIdUseCase(noteRepository)
    }
}