package com.msoula.noteappclean.feature.notes.domain.use_cases

import com.msoula.noteappclean.core.common.Result
import com.msoula.noteappclean.feature.notes.domain.models.NoteDomainModel
import com.msoula.noteappclean.feature.notes.domain.repositories.NoteRepository

class InsertNoteUseCase(
    private val noteRepository: NoteRepository
) {
    suspend operator fun invoke(note: NoteDomainModel): Result<Boolean> {
        return noteRepository.insertNote(note)
    }
}