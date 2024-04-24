package com.msoula.noteappclean.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.msoula.noteappclean.core.database.dao.NoteDAO
import com.msoula.noteappclean.core.database.dao.models.NoteEntityModel

@Database(entities = [NoteEntityModel::class], version = 1)
abstract class NoteAppCleanDatabase : RoomDatabase() {
    abstract fun noteDAO(): NoteDAO
}