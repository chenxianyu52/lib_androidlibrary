package com.xianyu.sso

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.xianyu.DownLoadUtils
import com.xianyu.nativelib.NativeLib
import com.xianyu.androidlibrary.databinding.ActivitySoDemoBinding
import com.xianyu.androidlibrary.view.viewBinding
//import com.xianyu.nativelib.NativeLib


class SSODemoActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivitySoDemoBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val downloadUrl = "https://xiaogali.oss-cn-hangzhou.aliyuncs.com/libnativelib.so"
        val dir = getDir("libs", Context.MODE_PRIVATE)
        DownLoadUtils.get()
            .download(downloadUrl, dir.path, object : DownLoadUtils.OnDownloadListener {
                override fun onDownloadSuccess() {
                    //成功
                    Log.i("注意", "下载成功")
                    binding.resultView.post { binding.resultView.text = "下载成功" }

                    // 下载位置
//                    val downloadFile: File = File(externalCacheDir?.path, "cxy")
//                    Log.i("cxy","file path: " + downloadFile.path)
                    Log.i("cxy", "NativeLib loadLibrary start")
                    val currentFiles = dir.listFiles()
//                    for(i in currentFiles.indices){
//                        Log.i("cxy", "NativeLib loadLibrary start: dir : " + dir.path)
//                        System.load(currentFiles[i].absolutePath)
//                    }
                    Log.i("cxy", "NativeLib loadLibrary end")
                    binding.resultView.post { binding.resultView.text = NativeLib.getInstance(currentFiles[0].absolutePath)
                        .stringFromJNI() }
                }

                override fun onDownloading(progress: Int) {
                    Log.i("注意", "$progress%")
                    binding.resultView.post { binding.resultView.text = "$progress%" }
                }

                override fun onDownloadFailed() {
                    Log.i("注意", "下载失败")
                    binding.resultView.post { binding.resultView.text = "下载失败" }
                }
            })

    }
}