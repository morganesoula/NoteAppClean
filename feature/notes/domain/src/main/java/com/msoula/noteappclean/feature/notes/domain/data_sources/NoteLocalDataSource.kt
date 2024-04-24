package com.msoula.noteappclean.feature.notes.domain.data_sources

import com.msoula.noteappclean.core.common.Result
import com.msoula.noteappclean.feature.notes.domain.models.NoteDomainModel
import kotlinx.coroutines.flow.Flow

interface NoteLocalDataSource {
    fun observeNotes(): Flow<List<NoteDomainModel>>
    suspend fun insertNote(note: NoteDomainModel): Result<Boolean>
    suspend fun fetchNoteById(id: Long): Result<NoteDomainModel>
}