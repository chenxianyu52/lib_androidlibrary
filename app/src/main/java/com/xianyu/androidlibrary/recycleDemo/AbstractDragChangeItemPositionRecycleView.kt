package com.xianyu.androidlibrary.recycleDemo

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class AbstractDragChangeItemPositionRecycleView : RecyclerView {
    private val dataList: MutableList<BaseAdapter.BaseItemData> = mutableListOf()
    private var baseAdapter: BaseAdapter? = null

    constructor(context: Context) : super(context) {
        initView()
    }

    constructor(context: Context, attr: AttributeSet) : super(context, attr) {
        initView()
    }

    constructor(context: Context, attr: AttributeSet, defStyleAttr: Int) : super(
        context,
        attr,
        defStyleAttr
    ) {
        initView()
    }

    private fun initView() {
        baseAdapter = BaseAdapter(context)
        this.adapter = baseAdapter
    }

    /**
     * 设置数据
     */
    fun setData(sources: List<BaseAdapter.BaseItemData>) {
        baseAdapter?.setData(sources)
        val callback = baseAdapter?.let {
            OnlineReportListCallback(it)

        }
        val itemTouchHelper = callback?.let { ItemTouchHelper(it) }
        itemTouchHelper?.attachToRecyclerView(this)

    }
}