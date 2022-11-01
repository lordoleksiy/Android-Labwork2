package com.example.labwork2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.labwork2.R
import com.example.labwork2.VPController
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.util.ArrayList


class Main : Fragment() {
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private val fragmentList: ArrayList<Fragment> = ArrayList()
    private val titleList: ArrayList<String> = ArrayList()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewPager = view.findViewById(R.id.viewPager)
        tabLayout = view.findViewById(R.id.tabLayout)

        VPSettings() // settings for tabLayout and viewpager2
    }

    private fun VPSettings(){
        titleList.add("Info")
        titleList.add("Input")
        fragmentList.add(Info.newInstance())
        fragmentList.add(Input.newInstance())

        val vpController = VPController(requireActivity());
        vpController.setFragmentList(fragmentList)
        viewPager.adapter = vpController

        TabLayoutMediator(tabLayout, viewPager){
                tab, pos -> tab.text = titleList[pos]
        }.attach()
    }
}