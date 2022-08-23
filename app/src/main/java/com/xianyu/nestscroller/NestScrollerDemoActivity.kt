package com.xianyu.nestscroller

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.xianyu.androidlibrary.databinding.ActivityNestScrollerBinding
import com.xianyu.androidlibrary.utils.DisplayUtil
import com.xianyu.androidlibrary.view.viewBinding


class NestScrollerDemoActivity:Activity() {
    private val binding by viewBinding(ActivityNestScrollerBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val rootView: NestedStickerHeaderView = binding.root
        rootView.setMaxScrollTop(DisplayUtil.dip2px(100F))
        binding.recycle.layoutManager = LinearLayoutManager(this)
        binding.recycle.adapter = SimpleTestAdapter()
    }
}