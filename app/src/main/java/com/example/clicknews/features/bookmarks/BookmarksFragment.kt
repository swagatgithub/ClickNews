package com.example.clicknews.features.bookmarks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.clicknews.R

class BookmarksFragment : Fragment(R.layout.bookmark_layout)
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("BookmarksFragment Created..")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        println("BookmarksFragment onCreateView..")
        return super.onCreateView(inflater, container, savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("BookmarksFragment onViewCreated..")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        println("BookmarksFragment onDestroyView..")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("BookmarksFragment onDestroy..")
    }
}