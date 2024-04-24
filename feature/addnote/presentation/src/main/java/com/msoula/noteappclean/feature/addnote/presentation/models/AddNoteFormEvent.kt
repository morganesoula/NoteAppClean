package com.msoula.noteappclean.feature.addnote.presentation.models

sealed interface AddNoteFormEvent {
    data class OnTitleChanged(val title: String) : AddNoteFormEvent
    data class OnDescriptionChanged(val description: String) : AddNoteFormEvent
    data object OnSubmitNote : AddNoteFormEvent
}