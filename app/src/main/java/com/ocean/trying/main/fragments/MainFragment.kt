package com.ocean.trying.main.fragments

import TestAdapter
import TestItem
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ocean.trying.databinding.FragmentTestBinding
import com.ocean.trying.touchevent.TouchEventActivity

class MainFragment : Fragment() {
    private lateinit var binding: FragmentTestBinding
    private lateinit var testAdapter: TestAdapter
    
    private val testItems = mutableListOf<TestItem>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        initTestItems()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = TestAdapter(testItems) { item ->
                startActivity(Intent(context, item.activityClass))
            }.also { testAdapter = it }
        }
    }

    private fun initTestItems() {
        testItems.clear()
        testItems.addAll(listOf(
            TestItem("事件分发", TouchEventActivity::class.java),
            // 添加更多测试项...
            // TestItem("Other Test", OtherTestActivity::class.java),
        ))
        testAdapter.notifyDataSetChanged()
    }
} 