package com.itzikpichhadze.zemingoapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.itzikpichhadze.zemingoapp.R
import com.itzikpichhadze.zemingoapp.utilities.addFragment

class MainActivity : AppCompatActivity() {

    companion object{
        const val FRAGMENT_CONTAINER = R.id.container
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
//            this.addFragment(MainFragment())
        }
    }
}