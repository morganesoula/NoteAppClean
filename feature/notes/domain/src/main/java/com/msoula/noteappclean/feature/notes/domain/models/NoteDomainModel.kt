package com.msoula.noteappclean.feature.notes.domain.models

data class NoteDomainModel(
    val id: Long,
    val title: String,
    val description: String
) {
    companion object {
        const val DEFAULT_ID: Long = -1L
        const val DEFAULT_TITLE: String = ""
        const val DEFAULT_DESCRIPTION: String = ""
    }
}
