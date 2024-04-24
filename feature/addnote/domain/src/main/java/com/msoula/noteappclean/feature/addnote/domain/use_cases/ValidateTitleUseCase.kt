package com.msoula.noteappclean.feature.addnote.domain.use_cases

import com.msoula.noteappclean.core.common.ValidationResult

class ValidateTitleUseCase {
    fun execute(title: String, errorMessage: String): ValidationResult {
        if (title.isEmpty()) {
            return ValidationResult(false, errorMessage)
        }

        return ValidationResult(true)
    }
}