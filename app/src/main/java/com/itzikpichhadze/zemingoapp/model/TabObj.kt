package com.itzikpichhadze.zemingoapp.model

import java.io.Serializable

data class TabObj(
        val title: String,
        val urls: List<Int>
): Serializable
