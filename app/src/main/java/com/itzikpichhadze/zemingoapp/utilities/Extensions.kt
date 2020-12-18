package com.itzikpichhadze.zemingoapp.utilities

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.itzikpichhadze.zemingoapp.R
import com.itzikpichhadze.zemingoapp.views.MainActivity.Companion.FRAGMENT_CONTAINER


fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int = FRAGMENT_CONTAINER) {
    supportFragmentManager.inTransaction { add(frameId, fragment) }
}

fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int = FRAGMENT_CONTAINER) {
    if (!supportFragmentManager.fragments.isNullOrEmpty()) {
        if (!supportFragmentManager.fragments[0].toString().contains(
                fragment.toString().replaceAfter(
                    "Fragment",
                    ""
                )
            )
        ) {
            supportFragmentManager.inTransaction { replace(frameId, fragment) }
        }
    }
}

private inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction()
        .setCustomAnimations(
            R.anim.slide_in_right,
            R.anim.slide_out_left,
            R.anim.slide_in_left,
            R.anim.slide_out_right
        )
        .func()
        .addToBackStack(null).commit()
}
