package com.itzikpichhadze.zemingoapp.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.itzikpichhadze.zemingoapp.model.TabObj

class MainViewModelFactory(val listType: TabObj) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(listType) as T
    }

}