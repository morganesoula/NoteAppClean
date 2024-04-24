package com.msoula.noteappclean.feature.addnote.domain.di

import com.msoula.noteappclean.feature.addnote.domain.use_cases.ValidateDescriptionUseCase
import com.msoula.noteappclean.feature.addnote.domain.use_cases.ValidateTitleUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AddNoteDomainModule {

    @Provides
    fun provideValidateDescriptionUseCase(): ValidateDescriptionUseCase =
        ValidateDescriptionUseCase()

    @Provides
    fun provideValidateTitleUseCase(): ValidateTitleUseCase =
        ValidateTitleUseCase()
}