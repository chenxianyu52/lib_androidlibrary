package com.xianyu.cache

import android.text.Editable
import com.xianyu.androidlibrary.AppGlobals
import com.xianyu.cache.MainRoomDatabase.Companion.getDatabase
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

object CacheManager {
    //反序列,把二进制数据转换成java object对象
    private fun toObject(data: ByteArray?): Any? {
        var bais: ByteArrayInputStream? = null
        var ois: ObjectInputStream? = null
        try {
            bais = ByteArrayInputStream(data)
            ois = ObjectInputStream(bais)
            return ois.readObject()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            try {
                bais?.close()
                ois?.close()
            } catch (ignore: Exception) {
                ignore.printStackTrace()
            }
        }
        return null
    }

    //序列化存储数据需要转换成二进制
    private fun <T> toByteArray(body: T): ByteArray {
        var baos: ByteArrayOutputStream? = null
        var oos: ObjectOutputStream? = null
        try {
            baos = ByteArrayOutputStream()
            oos = ObjectOutputStream(baos)
            oos.writeObject(body)
            oos.flush()
            return baos.toByteArray()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            try {
                baos?.close()
                oos?.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return ByteArray(0)
    }

    suspend fun <T> delete(key: String, body: T) {
        val cache = Cache()
        cache.key = key
        cache.data = toByteArray(body)
        getDatabase(AppGlobals.getApplication()).getCacheDao().delete(cache)
    }

    suspend fun <T> save(key: String, body: T) {
        val cache = Cache()
        cache.key = key
        cache.data = toByteArray(body)
        getDatabase(AppGlobals.getApplication()).getCacheDao().save(cache)

    }

    suspend fun getCache(key: String): Any? {
        val cache = getDatabase(AppGlobals.getApplication()).getCacheDao().getCache(key)
        return if (cache?.data != null) {
            toObject(cache.data)
        } else null
    }
}