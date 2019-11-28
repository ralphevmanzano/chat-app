package com.example.chatapplication.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import com.example.chatapplication.BR
import com.example.chatapplication.R
import com.example.todo_app.util.EventObserver

class MainActivity : AppCompatActivity() {

  private lateinit var viewModel: MainViewModel
  private lateinit var binding: ViewDataBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    binding.setVariable(BR.viewModel, viewModel)

    initObservers()
  }

  private fun initObservers() {
    viewModel.logOutEvent.observe(this, EventObserver {
      findNavController(this, R.id.nav_host_fragment).navigate(it.actionId)
    })
  }


}
