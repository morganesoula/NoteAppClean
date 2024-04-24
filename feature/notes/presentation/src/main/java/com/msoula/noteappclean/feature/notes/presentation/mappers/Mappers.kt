package com.msoula.noteappclean.feature.notes.presentation.mappers

import com.msoula.noteappclean.feature.notes.domain.models.NoteDomainModel
import com.msoula.noteappclean.feature.notes.presentation.models.NoteUiModel

fun NoteDomainModel.toNoteUiModel(): NoteUiModel {
    return NoteUiModel(
        id = this.id,
        title = this.title,
        description = this.description
    )
}