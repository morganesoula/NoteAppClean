package com.msoula.noteappclean.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.msoula.noteappclean.core.database.dao.models.NoteEntityModel
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDAO {
    @Query("SELECT * FROM notes")
    fun observeNotes(): Flow<List<NoteEntityModel>>

    @Upsert
    suspend fun upsertNote(note: NoteEntityModel)

    @Query("DELETE FROM notes WHERE id = :noteId")
    suspend fun deleteNote(noteId: Long)

    @Query("SELECT * FROM notes WHERE id = :noteId")
    suspend fun fetchNoteByNoteId(noteId: Long): NoteEntityModel
}