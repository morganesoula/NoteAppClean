package com.msoula.noteappclean.feature.notes.domain.repositories

import com.msoula.noteappclean.core.common.Result
import com.msoula.noteappclean.feature.notes.domain.data_sources.NoteLocalDataSource
import com.msoula.noteappclean.feature.notes.domain.models.NoteDomainModel
import kotlinx.coroutines.flow.Flow

class NoteRepository(
    private val noteLocalDataSource: NoteLocalDataSource
) {

    fun observeNotes(): Flow<List<NoteDomainModel>> {
        return noteLocalDataSource.observeNotes()
    }

    suspend fun insertNote(note: NoteDomainModel): Result<Boolean> {
        return noteLocalDataSource.insertNote(note)
    }

    suspend fun fetchNoteById(id: Long): Result<NoteDomainModel> {
        return noteLocalDataSource.fetchNoteById(id)
    }
}