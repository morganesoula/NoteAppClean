package com.msoula.noteappclean.feature.notes.presentation.models

import androidx.compose.runtime.Immutable

@Immutable
data class NoteUiModel(
    val id: Long,
    val title: String,
    val description: String
)
