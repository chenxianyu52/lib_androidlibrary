package com.xianyu.androidlibrary.activity

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.xianyu.androidlibrary.R
import com.xianyu.androidlibrary.pullDemo.MainActivityPull
import com.xianyu.androidlibrary.recycleDemo.DragChangeItemRecycleActivity

class DemoMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // recycleview 的拖拽效果
        findViewById<TextView>(R.id.recycleView_drag).setOnClickListener {
            val intent = Intent(this, DragChangeItemRecycleActivity::class.java)
            startActivity(intent)
        }

        // 下拉刷新的效果
        findViewById<TextView>(R.id.pull_button).setOnClickListener {
            val intent = Intent(this, MainActivityPull::class.java)
            startActivity(intent)
        }
    }
}