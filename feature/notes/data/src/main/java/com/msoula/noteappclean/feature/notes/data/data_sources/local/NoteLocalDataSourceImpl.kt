package com.msoula.noteappclean.feature.notes.data.data_sources.local

import com.msoula.noteappclean.core.common.Result
import com.msoula.noteappclean.core.database.dao.NoteDAO
import com.msoula.noteappclean.feature.notes.data.data_sources.local.mappers.toNoteDomainModel
import com.msoula.noteappclean.feature.notes.data.data_sources.local.mappers.toNoteEntityModel
import com.msoula.noteappclean.feature.notes.domain.data_sources.NoteLocalDataSource
import com.msoula.noteappclean.feature.notes.domain.errors.FetchNoteByIdError
import com.msoula.noteappclean.feature.notes.domain.errors.InsertNoteError
import com.msoula.noteappclean.feature.notes.domain.models.NoteDomainModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEmpty

class NoteLocalDataSourceImpl(
    private val noteDAO: NoteDAO
) : NoteLocalDataSource {

    override fun observeNotes(): Flow<List<NoteDomainModel>> {
        return noteDAO.observeNotes()
            .map { list ->
                list.map { noteEntityModel -> noteEntityModel.toNoteDomainModel() }
            }
            .onEmpty {
                return@onEmpty
            }
    }

    override suspend fun insertNote(note: NoteDomainModel): Result<Boolean> {
        return try {
            noteDAO.upsertNote(note.toNoteEntityModel())
            Result.Success(true)
        } catch (exception: Exception) {
            exception.printStackTrace()
            Result.Failure(
                InsertNoteError(
                    exception.message ?: "Error on upserting note: $exception"
                )
            )
        }
    }

    override suspend fun fetchNoteById(id: Long): Result<NoteDomainModel> {
        return try {
            val note = noteDAO.fetchNoteByNoteId(id)
            Result.Success(note.toNoteDomainModel())
        } catch (exception: Exception) {
            exception.printStackTrace()
            Result.Failure(
                FetchNoteByIdError(
                    exception.message ?: "Error on fetching note with id $id - $exception"
                )
            )
        }
    }
}