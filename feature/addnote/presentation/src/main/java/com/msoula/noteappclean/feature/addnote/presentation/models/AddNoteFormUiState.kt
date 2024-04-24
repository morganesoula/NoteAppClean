package com.msoula.noteappclean.feature.addnote.presentation.models

data class AddNoteFormUiState(
    val noteId: Long? = null,
    val noteTitle: String = "",
    val noteTitleError: Int? = null,
    val noteDescription: String = "",
    val noteDescriptionError: Int? = null,
    val enableSubmit: Boolean = false
)
