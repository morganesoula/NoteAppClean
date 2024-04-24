package com.msoula.noteappclean.feature.notes.data.data_sources.local.mappers

import com.msoula.noteappclean.core.database.dao.models.NoteEntityModel
import com.msoula.noteappclean.feature.notes.domain.models.NoteDomainModel

fun NoteDomainModel.toNoteEntityModel(): NoteEntityModel {
    return NoteEntityModel(
        id = this.id,
        title = this.title,
        description = this.description
    )
}

fun NoteEntityModel.toNoteDomainModel(): NoteDomainModel {
    return NoteDomainModel(
        id = this.id,
        title = this.title,
        description = this.description
    )
}