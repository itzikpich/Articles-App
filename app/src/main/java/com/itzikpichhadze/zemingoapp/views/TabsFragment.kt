package com.itzikpichhadze.zemingoapp.views

import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.itzikpichhadze.zemingoapp.R
import com.itzikpichhadze.zemingoapp.model.TabObj
import kotlinx.android.synthetic.main.fragment_tabs.view.*

class TabsFragment: BaseFragment(R.layout.fragment_tabs) {

    // When requested, this adapter returns a Fragment,
    // representing an object in the collection.
    private lateinit var demoCollectionAdapter: CollectionAdapter
    private lateinit var viewPager: ViewPager2

    val tabsList = listOf(TabObj("car", listOf(3220)),TabObj("multiple", listOf(9010, 3266)))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        demoCollectionAdapter = CollectionAdapter(this, tabsList)
        viewPager = view.pager
        viewPager.adapter = demoCollectionAdapter

        val tabLayout = view.tab_layout
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabsList[position].title
        }.attach()
    }
}