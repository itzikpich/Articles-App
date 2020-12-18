package com.itzikpichhadze.zemingoapp.view_models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itzikpichhadze.zemingoapp.data.Repository
import com.itzikpichhadze.zemingoapp.model.Article
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class SharedViewModel: ViewModel() {

    var lastFeed = MutableLiveData<Article>()

}