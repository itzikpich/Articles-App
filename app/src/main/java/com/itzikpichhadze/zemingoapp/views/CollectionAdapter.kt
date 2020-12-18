package com.itzikpichhadze.zemingoapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.itzikpichhadze.zemingoapp.model.TabObj

class CollectionAdapter(fragment: Fragment, private val tabsList: List<TabObj>) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = tabsList.size

    override fun createFragment(position: Int): Fragment {
        // Return a NEW fragment instance in createFragment(int)
        return BaseSingleTabFragment().apply {
            arguments = Bundle().apply {
                putSerializable(ARG_TAB_OBJ, tabsList[position])
            }
        }
    }
}