package com.msoula.noteappclean.core.database.dao.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class NoteEntityModel(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val title: String,
    val description: String
)