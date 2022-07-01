package com.xianyu.androidlibrary.view

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

//将函数当做参数传递
fun <VB : ViewBinding> Fragment.binding(bind: (View) -> VB) = FragmentBindingDelegate(bind)

//属性委托
class FragmentBindingDelegate<VB : ViewBinding>(private val bind: (View) -> VB) :
    ReadOnlyProperty<Fragment, VB> {

    private var binding: VB? = null

    override fun getValue(thisRef: Fragment, property: KProperty<*>): VB {
        binding = try {
            thisRef.requireView().getBinding(bind)
        } catch (e: IllegalStateException) {
            throw IllegalStateException("The property of ${property.name} has been destroyed.")
        }
        thisRef.viewLifecycleOwner.lifecycle.addObserver(object : DefaultLifecycleObserver {
            override fun onDestroy(owner: LifecycleOwner) {
                //fragment销毁时置为null,避免内存泄露
                binding = null
            }
        })
        return binding!!
    }
}

@Suppress("UNCHECKED_CAST")
fun <VB : ViewBinding> View.getBinding(bind: (View) -> VB): VB = bind(this)