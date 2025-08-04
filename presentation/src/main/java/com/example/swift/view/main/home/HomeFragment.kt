package com.example.swift.view.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.boombim.android.R
import com.boombim.android.databinding.FragmentHomeBinding
import com.example.domain.model.RegionNewsModel
import com.example.swift.view.main.home.adapter.RegionNewsAdapter

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRegionNewsViewPager()
    }

    private fun initRegionNewsViewPager() = with(binding) {
        val newsList = listOf(
            RegionNewsModel("국토교통부", "2025.10.01일 오후로 점검 예정입로 점검 예정입로 점검 예정입로 점검 예정입 2시부터 4시까지..."),
            RegionNewsModel("서울시청", "강북 지역 주요 도로로 점검 예정입로 점검 예정입로 점검 예정입로 점검 예정입로 점검 예정입 점검 예정입니다."),
            RegionNewsModel("서울시청", "강북 지역 주요 도로로 점검 예정입로 점검 예정입로 점검 예정입로 점검 예정입로 점검 예정입 점검 예정입니다."),
            RegionNewsModel("서울시청", "강북 지역 주요 도로로 점검 예정입로 점검 예정입로 점검 예정입로 점검 예정입로 점검 예정입 점검 예정입니다.")
        )

        viewPagerRegionNews.adapter = RegionNewsAdapter(newsList)

        dotsIndicator.attachTo(viewPagerRegionNews)
        dotsIndicator.setDotIndicatorColor(
            ContextCompat.getColor(requireContext(), R.color.gray_scale_9)
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}