package com.itzikpichhadze.zemingoapp.views

import androidx.fragment.app.Fragment
import com.itzikpichhadze.zemingoapp.views.MainActivity

open class BaseFragment(layoutRes:Int): Fragment(layoutRes) {

    val mainActivity: MainActivity
        get() = activity as MainActivity

}
