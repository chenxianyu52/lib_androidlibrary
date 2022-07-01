package com.xianyu.jetpack.room

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.xianyu.androidlibrary.R
import com.xianyu.cache.CacheManager
import kotlinx.coroutines.*

class RoomActivity: AppCompatActivity() {
    var sqlId:EditText? = null
    var sqlInsertBody:EditText? = null
    var sqlView: TextView? = null
    var insertButton:Button? = null
    var queryButton:Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)
        sqlId = findViewById(R.id.sql_id)
        sqlInsertBody = findViewById(R.id.sql_insert_body)
        sqlView = findViewById(R.id.sql_view)
        insertButton = findViewById(R.id.insert)
        queryButton = findViewById(R.id.query)

        insertButton?.setOnClickListener {
            if(sqlId?.text != null && sqlInsertBody?.text != null) {
                GlobalScope.launch(Dispatchers.IO) {
                    CacheManager.save(sqlId?.text.toString(), sqlInsertBody?.text.toString())
                }
            }
        }
        queryButton?.setOnClickListener {
            if(sqlId?.text != null){
                GlobalScope.launch(Dispatchers.Main) {
                    val result = async(Dispatchers.IO) {
                        CacheManager.getCache(sqlId?.text.toString())
                    }
                    sqlView?.text = result.await() as CharSequence?
                }

            }
        }

    }
}