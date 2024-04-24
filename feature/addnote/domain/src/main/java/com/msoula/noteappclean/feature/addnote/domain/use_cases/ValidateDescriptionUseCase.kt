package com.msoula.noteappclean.feature.addnote.domain.use_cases

import com.msoula.noteappclean.core.common.ValidationResult

class ValidateDescriptionUseCase {
    fun execute(description: String, errorMessage: String): ValidationResult {
        if (description.isEmpty()) {
            return ValidationResult(false, errorMessage)
        }

        return ValidationResult(true)
    }
}