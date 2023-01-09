package com.shuwen.sw_home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shuwen.sw_home.R
import com.shuwen.sw_home.bean.Article

/**
 * created by shuwen on 1/2/23
 */
class ArticlesAdapter : RecyclerView.Adapter<ArticlesAdapter.ArticlesViewHolder>() {

    var article= mutableListOf<Article.ArticleDetail>()
    var reloadListener: ReloadListener? = null

    class ArticlesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView
        init {
            title = itemView.findViewById(R.id.article_title)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.articleitem, parent, false)
        return ArticlesViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        if (position % 17 == 0 && position != 0) {
            reloadListener?.onReload()
        }
        holder.title.text = article[position].title
    }

    override fun getItemCount(): Int {
        return article.size
    }

    interface ReloadListener{
        fun onReload()
    }

}