package com.example.chatapplication.di

import androidx.lifecycle.ViewModel
import com.example.chatapplication.ui.login.LoginFragment
import com.example.chatapplication.ui.login.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class LoginModule {

  @ContributesAndroidInjector(modules = [ViewModelBuilder::class])
  internal abstract fun loginFragment(): LoginFragment

  @Binds
  @IntoMap
  @ViewModelKey(LoginViewModel::class)
  abstract fun bindsLoginViewModel(viewModel: LoginViewModel): ViewModel

}