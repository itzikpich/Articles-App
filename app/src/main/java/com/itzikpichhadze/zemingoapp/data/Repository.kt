package com.itzikpichhadze.zemingoapp.data

import com.itzikpichhadze.zemingoapp.model.ArticleResponse
import retrofit2.Response

object Repository {

    suspend fun getCars() : Response<ArticleResponse> = ApiService.client.getCars()
    suspend fun getCareer() : Response<ArticleResponse> = ApiService.client.getCareer()
    suspend fun getTourism() : Response<ArticleResponse> = ApiService.client.getTourism()
    suspend fun getArticleById(id: Int) : Response<ArticleResponse> = ApiService.client.getDataById(id = id)

}