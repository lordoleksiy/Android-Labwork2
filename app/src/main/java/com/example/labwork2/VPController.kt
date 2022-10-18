package com.example.labwork2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import java.util.*

class VPController(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    private var fragmentList: List<Fragment> = ArrayList()

    fun setFragmentList(list: ArrayList<Fragment>){
        fragmentList = list
    }
    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        if (fragmentList.isEmpty()) throw Exception("FragmentList is empty")
        return fragmentList[position]
    }
}