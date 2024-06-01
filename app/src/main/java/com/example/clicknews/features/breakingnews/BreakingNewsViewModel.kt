package com.example.clicknews.features.breakingnews

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clicknews.data.LocalArticleInfo
import com.example.clicknews.data.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BreakingNewsViewModel @Inject constructor(private val newsRepository: NewsRepository) : ViewModel()
{
    private val _breakingNewsUiState  = MutableStateFlow<List<LocalArticleInfo>>(emptyList())

    val breakingNewsUiState : StateFlow<List<LocalArticleInfo>>  = _breakingNewsUiState

    init {
        viewModelScope.launch {
            val breakingNews = newsRepository.getBreakingNews()
            _breakingNewsUiState.value = breakingNews
        }
    }

}