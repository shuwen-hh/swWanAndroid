package com.shuwen.sw_home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.shuwen.sw_home.R
import com.shuwen.sw_home.bean.Article

/**
 * created by shuwen on 1/2/23
 */
class ArticlesAdapter : RecyclerView.Adapter<ArticlesAdapter.ArticlesViewHolder>() {

    class DiffCallback : DiffUtil.ItemCallback<Article.ArticleDetail>() {
        override fun areItemsTheSame(
            oldItem: Article.ArticleDetail,
            newItem: Article.ArticleDetail
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Article.ArticleDetail,
            newItem: Article.ArticleDetail
        ): Boolean {
            return oldItem.title == newItem.title && oldItem.niceDate == newItem.niceDate
        }
    }

    private val mDiffer: AsyncListDiffer<Article.ArticleDetail> = AsyncListDiffer(this, DiffCallback())
    var reloadListener: ReloadListener? = null

    class ArticlesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView
        init {
            title = itemView.findViewById(R.id.article_title)
        }

        fun bind(articleDetail: Article.ArticleDetail) {
            title.text = articleDetail.title
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
        holder.bind(getItem(position))
    }

    fun setData(data: List<Article.ArticleDetail>) {
        mDiffer.submitList(data)
    }

    override fun getItemCount(): Int {
        return mDiffer.currentList.size
    }

    private fun getItem(position: Int): Article.ArticleDetail {
        return mDiffer.currentList[position]
    }

    interface ReloadListener{
        fun onReload()
    }

}