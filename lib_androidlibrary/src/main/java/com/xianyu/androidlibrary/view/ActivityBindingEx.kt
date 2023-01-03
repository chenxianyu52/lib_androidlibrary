package com.xianyu.androidlibrary.view

import android.app.Activity
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding

fun <VB : ViewBinding> Activity.viewBinding(inflate: (LayoutInflater) -> VB) = lazy {
//    runOnUiThread {
        inflate(layoutInflater).also { binding ->
            runOnUiThread { setContentView(binding.root) }
        }
//    }

}