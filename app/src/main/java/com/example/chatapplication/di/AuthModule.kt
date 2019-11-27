package com.example.chatapplication.di

import androidx.lifecycle.ViewModel
import com.example.chatapplication.ui.auth.AuthFragment
import com.example.chatapplication.ui.auth.AuthViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class AuthModule {

  @ContributesAndroidInjector(modules = [ViewModelBuilder::class])
  internal abstract fun authFragment(): AuthFragment

  @Binds
  @IntoMap
  @ViewModelKey(AuthViewModel::class)
  abstract fun bindsAuthViewModel(viewModel: AuthViewModel): ViewModel

}