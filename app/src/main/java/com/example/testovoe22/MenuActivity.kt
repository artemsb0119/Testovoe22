package com.example.testovoe22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.testovoe22.databinding.ActivityMenuBinding
import com.google.android.material.tabs.TabLayout

class MenuActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tabLayout = findViewById(R.id.tabLayout)

        val tab1: TabLayout.Tab = tabLayout.newTab()
        tab1.text = "Courses"
        tab1.setIcon(R.drawable.study)
        tabLayout.addTab(tab1)

        val tab2: TabLayout.Tab = tabLayout.newTab()
        tab2.text = "Results"
        tab2.setIcon(R.drawable.diagram)
        tabLayout.addTab(tab2)

        val tab3: TabLayout.Tab = tabLayout.newTab()
        tab3.text = "Glossary"
        tab3.setIcon(R.drawable.book)
        tabLayout.addTab(tab3)

        val tab4: TabLayout.Tab = tabLayout.newTab()
        tab4.text = "More"
        tab4.setIcon(R.drawable.setting)
        tabLayout.addTab(tab4)

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val position = tab.position
                val fragmentTransaction = supportFragmentManager.beginTransaction()

                when (position) {
                    1 -> {
                        val resultsFragment = ResultsFragment()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frame_layout, resultsFragment)
                            .commit()
                    }
                    0 -> {
                        val coursesFragment = CoursesFragment()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frame_layout, coursesFragment)
                            .commit()
                    }
                }

                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
            }
        })

        replaceFragment(CoursesFragment())
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.frame_layout, CoursesFragment(), "CoursesFragment")
        fragmentTransaction.commit()
    }
}