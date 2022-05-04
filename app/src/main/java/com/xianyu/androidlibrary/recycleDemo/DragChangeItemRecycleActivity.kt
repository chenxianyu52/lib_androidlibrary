package com.xianyu.androidlibrary.recycleDemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xianyu.androidlibrary.R


class DragChangeItemRecycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drag_recycleview)
        initView()
    }

    private fun initView() {
        val recycleView = findViewById<RecyclerView>(R.id.parent_recycle)
        recycleView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycleView.adapter = object : RecyclerView.Adapter<ViewHolder>() {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
                return ViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_recycleview_parent, parent, false)
                )
            }

            override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                holder.recycleView.layoutManager = GridLayoutManager(holder.recycleView.context, 5)
                val list = mutableListOf<BaseAdapter.BaseItemData>()
                for (i in 0..100) {
                    list.add(BaseAdapter.BaseItemData("name $i"))
                }
                holder.recycleView.setData(list)
            }

            override fun getItemCount(): Int {
                return 2
            }

        }
//        val recycleView = findViewById<AbstractDragChangeItemPositionRecycleView>(R.id.recycleView)
//

    }

    class ViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recycleView: AbstractDragChangeItemPositionRecycleView =
            itemView.findViewById(R.id.recycleView_item)
    }
}