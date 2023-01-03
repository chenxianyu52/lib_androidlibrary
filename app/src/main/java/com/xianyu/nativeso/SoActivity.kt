package com.xianyu.nativeso

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.xianyu.androidlibrary.view.viewBinding
import com.xianyu.androidlibrary.databinding.ActivitySoDemoBinding
//import com.xianyu.nativelib.NativeLib

class SoActivity: AppCompatActivity() {
    private val binding by viewBinding(ActivitySoDemoBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_view_binding)
//        binding = ActivityViewBindingBinding.inflate(layoutInflater)
//        val view = binding.root
//        setContentView(view)
//        binding.resultView.text = NativeLib().stringFromJNI()
    }
}