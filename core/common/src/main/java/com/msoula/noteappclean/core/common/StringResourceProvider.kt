package com.msoula.noteappclean.core.common

import androidx.annotation.StringRes

interface StringResourceProvider {

    fun getString(@StringRes stringResId: Int): String
}