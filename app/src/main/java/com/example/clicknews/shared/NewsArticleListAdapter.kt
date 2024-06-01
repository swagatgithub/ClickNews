package com.example.clicknews.shared

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.clicknews.data.LocalArticleInfo
import com.example.clicknews.databinding.NewsItemLayoutBinding

class NewsArticleListAdapter : ListAdapter< LocalArticleInfo , NewsArticleViewHolder>(NewsArticleDiffCallBack)
{
    object NewsArticleDiffCallBack : DiffUtil.ItemCallback<LocalArticleInfo>()
    {
        override fun areItemsTheSame(
            oldItem: LocalArticleInfo,
            newItem: LocalArticleInfo
        ): Boolean {
            return oldItem.urlToNews == newItem.urlToNews
        }

        override fun areContentsTheSame(
            oldItem: LocalArticleInfo,
            newItem: LocalArticleInfo
        ): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsArticleViewHolder {
        return NewsArticleViewHolder(NewsItemLayoutBinding.inflate(LayoutInflater.from(parent.context) , parent , false))
    }

    override fun onBindViewHolder(holder: NewsArticleViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}