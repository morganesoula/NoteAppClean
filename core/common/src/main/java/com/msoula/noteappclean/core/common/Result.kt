package com.msoula.noteappclean.core.common

sealed interface Result<out R> {
    data class Success<out R>(val data: R) : Result<R>
    data class Failure(val error: AppError) : Result<Nothing>
}

interface AppError {
    val message: String
}