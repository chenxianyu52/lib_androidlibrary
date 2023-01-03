package com.xianyu.nativelib;

public class NativeLib {
    private static NativeLib nativeLib;
    public static NativeLib getInstance(String path){
        if(nativeLib == null){
            nativeLib = new NativeLib(path);
        }
        return nativeLib;
    }
    private NativeLib(String path){
        System.load(path);
    }
    public native String stringFromJNI();
}