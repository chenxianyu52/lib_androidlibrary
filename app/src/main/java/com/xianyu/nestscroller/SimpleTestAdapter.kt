package com.xianyu.nestscroller

import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class SimpleTestAdapter : RecyclerView.Adapter<SimpleTestAdapter.TextViewHolder> {
    private val TAG = "SimpleTestAdapter"
    var data: ArrayList<String>? = null

    constructor() {}
    constructor(data: ArrayList<String>?) {
        this.data = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        return TextViewHolder(TextView(parent.context))
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        val tv = holder.itemView as TextView
        tv.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100)
        val `val` = if (data == null) "TextView $position" else data!![position]
        tv.text = `val`
        Log.d(TAG, "onBindViewHolder $position")
    }

    override fun getItemCount(): Int {
        return if (data == null) 300 else data!!.size
    }

    class TextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}