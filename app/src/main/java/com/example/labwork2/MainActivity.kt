package com.example.labwork2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.labwork2.fragments.Info
import com.example.labwork2.fragments.Input
import com.example.labwork2.fragments.Result
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private val fragmentList: ArrayList<Fragment> = ArrayList()
    private val titleList: ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabLayout)

        fragmentSettings() // settings for tabLayout and viewpager2
    }

    private fun fragmentSettings(){
        titleList.add("Info")
        titleList.add("Input")
        titleList.add("Result")
        fragmentList.add(Info.newInstance())
        fragmentList.add(Input.newInstance())
        fragmentList.add(Result.newInstance())

        val vpController = VPController(this);
        vpController.setFragmentList(fragmentList)
        viewPager.adapter = vpController

        TabLayoutMediator(findViewById(R.id.tabLayout), findViewById(R.id.viewPager)){
                tab, pos -> tab.text = titleList[pos]
        }.attach()
    }
}