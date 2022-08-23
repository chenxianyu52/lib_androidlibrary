package com.xianyu.nestscroller

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.core.widget.NestedScrollView

class MyNestScrollerView: NestedScrollView {
    private val TAG: String = "MyNestScrollerView"

    /**
     * 该控件滑动的高度，高于这个高度后交给子滑动控件
     */
    private var mParentScrollHeight = 0
    private var mScrollY = 0
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet): super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int):super(context, attrs, defStyleAttr)

    fun setMyScrollHeight(scrollLength: Int) {
        mParentScrollHeight = scrollLength
    }


    /**
     * 子控件告诉父控件 开始滑动了
     * @param target
     * @param dx
     * @param dy
     * @param consumed
     * 如果有就返回true
     */

    override fun onNestedPreScroll(target: View, dx: Int, dy: Int, consumed: IntArray) {
        super.onNestedPreScroll(target, dx, dy, consumed)
        if (mScrollY < mParentScrollHeight) {
            consumed[0] = dx
            consumed[1] = dy
            scrollBy(0, dy)
        }
        Log.d(
            TAG,
            "dx " + dx + " dy " + dy + " " + consumed[0] + " " + consumed[1] + " scrollY " + mScrollY
        )
    }


    override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        super.onScrollChanged(l, t, oldl, oldt)
        mScrollY = t
    }
}