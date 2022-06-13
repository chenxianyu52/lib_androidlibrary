package com.xianyu.androidlibrary

import android.app.Activity
import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xianyu.androidlibrary.utils.DisplayUtil


class MainActivity : Activity() {
    val list: MutableList<Bean> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_layout)
        initData()
        initView()
    }

    private fun initData() {
        list.add(Bean("下拉刷新Demo", "com.xianyu.androidlibrary.pullDemo.MainActivityPull"))
        list.add(
            Bean(
                "recycleView 滑动更改顺序Demo",
                "com.xianyu.androidlibrary.recycleDemo.DragChangeItemRecycleActivity"
            )
        )
    }

    private fun initView() {
        val recycleView = findViewById<RecyclerView>(R.id.recycleView)
        val adapter = Adapter(list, this)
        recycleView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycleView.adapter = adapter
        recycleView.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                outRect.top = DisplayUtil.dip2px(12F)
            }
        })
    }

    class Adapter(val list: MutableList<Bean>, val activity: MainActivity) :
        RecyclerView.Adapter<ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(
                LayoutInflater.from(activity)
                    .inflate(R.layout.item_recycleview_main_activity, parent, false)
            )
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.name.text = list[position].name
            holder.itemView.setOnClickListener {
                val intent = Intent(activity, Class.forName(list[position].link))
                activity.startActivity(intent)
            }
        }

        override fun getItemCount(): Int {
            return list.size
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById<TextView>(R.id.name)
    }

    data class Bean(val name: String, val link: String)
}