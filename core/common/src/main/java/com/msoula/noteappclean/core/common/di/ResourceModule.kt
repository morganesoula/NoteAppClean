package com.msoula.noteappclean.core.common.di

import android.content.Context
import com.msoula.noteappclean.core.common.StringResourceProvider
import com.msoula.noteappclean.core.common.StringResourceProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ResourceModule {

    @Provides
    @Singleton
    fun provideResourceProvider(@ApplicationContext context: Context): StringResourceProvider =
        StringResourceProviderImpl(context)

}