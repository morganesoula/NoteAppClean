package com.msoula.noteappclean.core.common

data class ValidationResult(
    val successful: Boolean = false,
    val errorMessage: String? = null
)
