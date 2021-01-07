package com.itzikpichhadze.zemingoapp.views

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.itzikpichhadze.zemingoapp.R
import com.itzikpichhadze.zemingoapp.utilities.replaceFragment
import com.itzikpichhadze.zemingoapp.view_models.SharedViewModel
import java.text.SimpleDateFormat
import java.util.*
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragment: BaseFragment(R.layout.fragment_main) {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModels(view)
        view.fragment_main_navigate_button.setOnClickListener {
            MainFragmentDirections.actionMainFragmentToTabsFragment().apply {
                view.findNavController().navigate(this)
            }
//            mainActivity.replaceFragment(TabsFragment())
        }
    }

    private fun setViewModels(view: View) {
        sharedViewModel.lastFeed.observe(viewLifecycleOwner, Observer {
            it?.let { article ->
                view.fragment_main_last_feed_title.text = article.title
            }
        })
    }

    override fun onResume() {
        super.onResume()
        view?.fragment_main_current_datetime?.text = currentDateTime()
    }

}

private fun currentDateTime(): String
    = SimpleDateFormat("dd/MM/yyyy hh:mm", Locale("he")).format(Date())
