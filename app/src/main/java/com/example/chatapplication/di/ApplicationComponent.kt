package com.example.chatapplication.di

import android.content.Context
import com.example.chatapplication.ChatApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
  modules = [
    AndroidInjectionModule::class,
    AuthModule::class,
    LoginModule::class,
    SignupModule::class,
    ChatModule::class
  ]
)
interface ApplicationComponent : AndroidInjector<ChatApp> {

  @Component.Factory
  interface Factory {
    fun create(@BindsInstance appContext: Context): ApplicationComponent
  }
}