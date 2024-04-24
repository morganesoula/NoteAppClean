package com.msoula.noteappclean.feature.notes.domain.use_cases

import com.msoula.noteappclean.feature.notes.domain.repositories.NoteRepository

class FetchNoteByIdUseCase(private val noteRepository: NoteRepository) {

    suspend operator fun invoke(id: Long) = noteRepository.fetchNoteById(id)
}