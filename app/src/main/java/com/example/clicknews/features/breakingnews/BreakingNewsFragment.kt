package com.example.clicknews.features.breakingnews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.clicknews.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BreakingNewsFragment : Fragment(R.layout.breaking_news_layout) {
    private val breakingNewsViewModel: BreakingNewsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("onCreate() Of BreakingNewsFragment..")
    }

    override fun onStart() {
        super.onStart()
        println("onStart() of BreakingNewsFragment..")
    }

    override fun onResume() {
        super.onResume()
        println("onResume() of BreakingNewsFragment..")
    }

    override fun onPause() {
        super.onPause()
        println("onPause() of BreakingNewsFragment")
    }

    override fun onStop() {
        super.onStop()
        println("onStop() of BreakingNewsFragment..")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy() of BreakingNewsFragment..")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        println("onCreateView() of BreakingNewsFragment..")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("onViewCreated() of BreakingNewsFragment..")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        println("onDestroyView() of BreakingNewsFragment..")
    }
}