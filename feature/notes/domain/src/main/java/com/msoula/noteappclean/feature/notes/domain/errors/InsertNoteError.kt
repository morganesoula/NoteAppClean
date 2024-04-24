package com.msoula.noteappclean.feature.notes.domain.errors

import com.msoula.noteappclean.core.common.AppError

class InsertNoteError(override val message: String) : AppError
class FetchNoteByIdError(override val message: String) : AppError