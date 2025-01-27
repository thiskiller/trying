package com.ocean.trying.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.ocean.trying.databinding.ActivityMainBinding
import com.ocean.trying.main.fragments.FlutterMainFragment
import com.ocean.trying.main.fragments.NativeMainFragment
import com.ocean.trying.main.fragments.ReactNativeMainFragment
import com.ocean.trying.main.fragments.TestSimpleFragment
import com.ocean.trying.main.fragments.WebViewMainFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragments = listOf<Fragment>(
            TestSimpleFragment(),
            NativeMainFragment(),
            FlutterMainFragment(),
            ReactNativeMainFragment(),
            WebViewMainFragment()
        )

        val fragmentTitles = listOf("Test", "Native", "Flutter", "RN", "H5")

        // 设置 ViewPager 适配器
        binding.viewPager.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int = fragments.size
            override fun createFragment(position: Int): Fragment = fragments[position]
        }

        // 将 TabLayout 与 ViewPager 关联
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = fragmentTitles[position]
        }.attach()
    }
}