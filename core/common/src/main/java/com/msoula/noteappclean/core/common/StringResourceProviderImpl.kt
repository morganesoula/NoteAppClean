package com.msoula.noteappclean.core.common

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StringResourceProviderImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : StringResourceProvider {

    override fun getString(stringResId: Int): String {
        return context.getString(stringResId)
    }
}