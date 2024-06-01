package com.example.clicknews.features.breakingnews

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clicknews.R
import com.example.clicknews.databinding.BreakingNewsLayoutBinding
import com.example.clicknews.shared.NewsArticleListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BreakingNewsFragment : Fragment(R.layout.breaking_news_layout)
{

    private val breakingNewsViewModel: BreakingNewsViewModel by viewModels()
    private val newsArticleListAdapter = NewsArticleListAdapter()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        val breakingNewsLayoutBinding = BreakingNewsLayoutBinding.bind(view)

        breakingNewsLayoutBinding.apply {
            breakingNewsRecyclerView.apply {
                layoutManager =  LinearLayoutManager(requireContext())
                setHasFixedSize(true)
                adapter = newsArticleListAdapter
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {

            println("Inside Launch of a new coroutine..")

            repeatOnLifecycle(Lifecycle.State.STARTED) {
                println("Inside repeatOnLifecycle...")
                breakingNewsViewModel.breakingNewsUiState.collect{
                    println("Inside Collect Method Of StateFlow(Not Mutable)")
                    newsArticleListAdapter.submitList(it)
                }
            }
        }

    }

}