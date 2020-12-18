package com.itzikpichhadze.zemingoapp.view_models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itzikpichhadze.zemingoapp.data.Repository
import com.itzikpichhadze.zemingoapp.model.Article
import com.itzikpichhadze.zemingoapp.model.TabObj
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

class MainViewModel(private val tabObj: TabObj): ViewModel() {

    var shouldFetch: Boolean = false
    val listToPresent = MutableLiveData<List<Article>>()
    val feedsMap = mutableMapOf<Int, MutableList<Article>>() // mutableMapOf<Int, List<Article>>()
    val loadingDataList = MutableLiveData<MutableSet<Int>>(mutableSetOf())

    fun runApiCall() {
        tabObj.urls.forEach { id ->
            viewModelScope.launch {
                handleResponse(id)
            }
        }
    }

    private suspend fun handleResponse(id: Int) {
        loadingDataList.value?.add(id)
        loadingDataList.notifyObserver()
        val response = Repository.getArticleById(id)
        if (response.isSuccessful) {
            response.body()?.channel?.articles?.let {
                feedsMap[id] = it
                setListToPreview()
            }
        }
        loadingDataList.value?.remove(id)
        loadingDataList.notifyObserver()
        delay(5000)
        if (shouldFetch) {
            handleResponse(id)
        }
    }

    private fun setListToPreview() {
        val tempList = mutableListOf<Article>()
        tabObj.urls.forEach {
            feedsMap[it]?.let { it1 -> tempList.addAll(it1) }
        }
        listToPresent.value = tempList
    }

}

fun <T> MutableLiveData<T>.notifyObserver() {
    this.value = this.value
}