package com.example.clicknews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.clicknews.databinding.ActivityMainBinding
import com.example.clicknews.features.bookmarks.BookmarksFragment
import com.example.clicknews.features.breakingnews.BreakingNewsFragment
import com.example.clicknews.features.searchnews.SearchNewsFragment
import com.example.clicknews.network.NewsApiService
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity()
{
    private lateinit var bottomNavBarMainActivity: BottomNavigationView
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit  var breakingNewsFragment : Fragment
    private lateinit var searchNewsFragment : Fragment
    private lateinit var bookmarkFragment : Fragment
    private var lastFragment : Fragment ? = null
    private var idOfTheMenuToSelectOrSelected : Int ? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        idOfTheMenuToSelectOrSelected = savedInstanceState?.getInt(BOTTOM_NAV_SELECTED_MENU) ?: R.id.breakingMenu
        if(savedInstanceState == null)
        {
            breakingNewsFragment = BreakingNewsFragment()
            searchNewsFragment = SearchNewsFragment()
            bookmarkFragment = BookmarksFragment()
        }
        else
        {
            breakingNewsFragment = supportFragmentManager.findFragmentByTag(BREAKING_NEWS_TAG) ?: BreakingNewsFragment()
            searchNewsFragment = supportFragmentManager.findFragmentByTag(SEARCH_NEWS_TAG)  ?: SearchNewsFragment()
            bookmarkFragment = supportFragmentManager.findFragmentByTag(BOOKMARK_NEWS_TAG) ?: BookmarksFragment()
        }
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        startInitialization()
        activityMainBinding.bottomNavigationBarMainActivity.menu.getItem(0).icon

    }

    private fun startInitialization()
    {
        bottomNavBarMainActivity = activityMainBinding.bottomNavigationBarMainActivity

        bottomNavBarMainActivity.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.breakingMenu -> {

                    idOfTheMenuToSelectOrSelected = R.id.breakingMenu

                    val gotBreakingNewsFragment =
                        supportFragmentManager.findFragmentByTag(BREAKING_NEWS_TAG)

                    if (gotBreakingNewsFragment is BreakingNewsFragment) {
                        supportFragmentManager.commit {
                            setReorderingAllowed(true)
                            attach(breakingNewsFragment)
                        }
                    } else {
                        supportFragmentManager.commit {
                            setReorderingAllowed(true)
                            add(
                                R.id.fragmentContainerViewMainActivity,
                                breakingNewsFragment,
                                BREAKING_NEWS_TAG
                            )
                        }
                    }

                    if (lastFragment != null) {
                        supportFragmentManager.commit {
                            setReorderingAllowed(true)
                            detach(lastFragment!!)
                        }
                    }

                    lastFragment = breakingNewsFragment
                }

                R.id.searchMenu -> {
                    idOfTheMenuToSelectOrSelected = R.id.searchMenu
                    val gotSearchNewsFragment = supportFragmentManager.findFragmentByTag(SEARCH_NEWS_TAG)
                    if(gotSearchNewsFragment is SearchNewsFragment)
                    {
                        supportFragmentManager.commit {
                            setReorderingAllowed(true)
                            attach(searchNewsFragment)
                        }
                    }
                    else
                    {
                        supportFragmentManager.commit {
                            setReorderingAllowed(true)
                            add(R.id.fragmentContainerViewMainActivity , searchNewsFragment , SEARCH_NEWS_TAG)
                        }
                    }

                    if(lastFragment != null)
                    {
                        supportFragmentManager.commit {
                            setReorderingAllowed(true)
                            detach(lastFragment!!)
                        }
                    }
                    lastFragment = searchNewsFragment
                }

                R.id.bookmarksMenu -> {
                    idOfTheMenuToSelectOrSelected = R.id.bookmarksMenu
                    val gotBookmarksFragment = supportFragmentManager.findFragmentByTag(BOOKMARK_NEWS_TAG)
                    if(gotBookmarksFragment is BookmarksFragment)
                    {
                        supportFragmentManager.commit {
                            setReorderingAllowed(true)
                            attach(bookmarkFragment)
                        }
                    }
                    else
                    {
                        supportFragmentManager.commit {
                            setReorderingAllowed(true)
                            add(R.id.fragmentContainerViewMainActivity , bookmarkFragment , BOOKMARK_NEWS_TAG)
                        }
                    }

                    if(lastFragment != null)
                    {
                        supportFragmentManager.commit {
                            setReorderingAllowed(true)
                            detach(lastFragment!!)
                        }
                    }
                    lastFragment = bookmarkFragment
                }

            }

            return@setOnItemSelectedListener true

        }

        bottomNavBarMainActivity.selectedItemId = idOfTheMenuToSelectOrSelected!!
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(BOTTOM_NAV_SELECTED_MENU , idOfTheMenuToSelectOrSelected!!)
    }

}

const val BOTTOM_NAV_SELECTED_MENU = "bottomNavSelectedMenu"
const val BREAKING_NEWS_TAG = "breakingNews"
const val SEARCH_NEWS_TAG = "searchNews"
const val BOOKMARK_NEWS_TAG = "bookmark"

