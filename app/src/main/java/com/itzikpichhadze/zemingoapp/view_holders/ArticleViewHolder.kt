package com.itzikpichhadze.zemingoapp.view_holders

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.itzikpichhadze.zemingoapp.adapters.GenericAdapter
import com.itzikpichhadze.zemingoapp.model.Article
import kotlinx.android.synthetic.main.item_article.view.*

class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), GenericAdapter.Binder<Article> {

    private var title: TextView = itemView.article_title
    private var description: TextView = itemView.article_desc
    private var time: TextView = itemView.article_time_posted
    private var url: TextView = itemView.article_url

    override fun bind(data: Article) {
        title.text = data.title
        description.text = data.description
        time.text = data.pubDate//?.githubJobTimeFormatter()
        url.text = data.link
//        imageView.loadFromUrlToGlide(data.companyLogo)
    }

}