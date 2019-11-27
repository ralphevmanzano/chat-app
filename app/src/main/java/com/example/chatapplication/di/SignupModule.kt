package com.example.chatapplication.di

import androidx.lifecycle.ViewModel
import com.example.chatapplication.ui.signup.SignupFragment
import com.example.chatapplication.ui.signup.SignupViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class SignupModule {
  @ContributesAndroidInjector(modules = [ViewModelBuilder::class])
  internal abstract fun signupFragment(): SignupFragment

  @Binds
  @IntoMap
  @ViewModelKey(SignupViewModel::class)
  abstract fun bindsSignupViewModel(viewModel: SignupViewModel): ViewModel
}