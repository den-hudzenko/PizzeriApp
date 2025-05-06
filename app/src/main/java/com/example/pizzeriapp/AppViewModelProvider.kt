package com.example.pizzeriapp

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pizzeriapp.ViewModel.DBViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            DBViewModel(inventoryApplication().container.itemsRepository)
        }
    }
}

fun CreationExtras.inventoryApplication(): GoodApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as GoodApplication)