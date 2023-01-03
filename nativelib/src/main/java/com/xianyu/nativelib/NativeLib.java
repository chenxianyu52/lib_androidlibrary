package com.xianyu.nativelib;

import android.util.Log;

public class NativeLib {

    // Used to load the 'nativelib' library on application startup.
    static {
        Log.i("cxy","NativeLib loadLibrary start");
        System.loadLibrary("nativelib");
        Log.i("cxy","NativeLib loadLibrary end");
    }

    /**
     * A native method that is implemented by the 'nativelib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}