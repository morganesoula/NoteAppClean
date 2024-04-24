package com.msoula.noteappclean.core.di.modules

import com.msoula.noteappclean.core.di.navigation.Navigator
import com.msoula.noteappclean.core.di.navigation.NavigatorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NavigationModule {

    @Provides
    @Singleton
    fun provideNavigator(): Navigator = NavigatorImpl()
}