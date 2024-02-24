package com.example.clicknews.features.breakingnews

import androidx.lifecycle.ViewModel
import com.example.clicknews.data.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BreakingNewsViewModel @Inject constructor(val newsRepository: NewsRepository) : ViewModel() {

}