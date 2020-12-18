package com.itzikpichhadze.zemingoapp.views

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.itzikpichhadze.zemingoapp.R
import com.itzikpichhadze.zemingoapp.adapters.GenericAdapter
import com.itzikpichhadze.zemingoapp.model.Article
import com.itzikpichhadze.zemingoapp.model.TabObj
import com.itzikpichhadze.zemingoapp.view_holders.ArticleViewHolder
import com.itzikpichhadze.zemingoapp.view_models.MainViewModel
import com.itzikpichhadze.zemingoapp.view_models.MainViewModelFactory
import com.itzikpichhadze.zemingoapp.view_models.SharedViewModel
import kotlinx.android.synthetic.main.fragment_collection_object.view.*

const val ARG_TAB_OBJ = "type"

// Instances of this class are fragments representing a single
// object in our collection.
class BaseSingleTabFragment : BaseFragment(R.layout.fragment_collection_object) {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    private lateinit var viewModel: MainViewModel

    private val genericAdapter = object : GenericAdapter<Any>(
        clickAction = {
            onItemClicked(it)
        }) {

        override fun getLayoutId(position: Int, obj: Any): Int = R.layout.item_article

        override fun getViewHolder(view: View, viewType: Int): RecyclerView.ViewHolder = ArticleViewHolder(view)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.takeIf { it.containsKey(ARG_TAB_OBJ) }?.apply {
            (getSerializable(ARG_TAB_OBJ) as? TabObj)?.let{ tabObj ->
                view.fragmentMainRecyclerView.adapter = genericAdapter
                viewModel = ViewModelProviders.of(this@BaseSingleTabFragment, MainViewModelFactory(tabObj)).get(MainViewModel::class.java)
                viewModel.listToPresent.observe(viewLifecycleOwner, { listOfArticles ->
                    genericAdapter.replaceList(listOfArticles)
                })
                viewModel.loadingDataList.observe(viewLifecycleOwner, { data ->
                    view.loader.visibility = if(data.isNotEmpty()) VISIBLE else GONE
                })
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.shouldFetch = true
        viewModel.runApiCall()
    }

    override fun onPause() {
        super.onPause()
        viewModel.shouldFetch = false
    }

    fun onItemClicked(item: Any){
        (item as? Article)?.let { job ->
            sharedViewModel.lastFeed.value = job
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(job.link)))
        }
    }

}