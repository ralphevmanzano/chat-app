package com.example.chatapplication.di

import androidx.lifecycle.ViewModel
import com.example.chatapplication.ui.chat.ChatFragment
import com.example.chatapplication.ui.chat.ChatViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class ChatModule {

  @ContributesAndroidInjector(modules = [ViewModelBuilder::class])
  internal abstract fun chatFragment(): ChatFragment

  @Binds
  @IntoMap
  @ViewModelKey(ChatViewModel::class)
  abstract fun bindsAuthViewModel(viewModel: ChatViewModel): ViewModel

}