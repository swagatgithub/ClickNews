package com.example.clicknews.shared

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.clicknews.R
import com.example.clicknews.data.LocalArticleInfo
import com.example.clicknews.databinding.NewsItemLayoutBinding

class NewsArticleViewHolder(private val binding :NewsItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)
{
    fun bind(articleData : LocalArticleInfo)
    {
        binding.apply {
            newsTitle.text = articleData.newsHeadline
            Glide.with(itemView).load(articleData.newsThumbnailUrl).placeholder(R.drawable.baseline_insert_photo_24).into(newsImage)
            bookmarkIcon.setImageResource(
                when{
                    articleData.isBookMarked -> R.drawable.baseline_bookmarks_24
                    else -> R.drawable.outline_bookmarks_24
                }
            )
        }
    }
}