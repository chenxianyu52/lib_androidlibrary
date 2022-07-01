package com.xianyu.jetpack.viewbinding

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.xianyu.androidlibrary.R
import com.xianyu.androidlibrary.databinding.ActivityViewBindingBinding
import com.xianyu.androidlibrary.view.viewBinding

class ViewBindingActivity:AppCompatActivity() {
//    private lateinit var binding: ActivityViewBindingBinding
    private val binding by viewBinding(ActivityViewBindingBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_view_binding)
//        binding = ActivityViewBindingBinding.inflate(layoutInflater)
//        val view = binding.root
//        setContentView(view)
        binding.sqlView.text = "is view binding"
    }
}