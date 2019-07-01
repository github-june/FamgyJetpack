package com.famgy.famgyjetpack.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainModelFactory : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel() as T
    }
}