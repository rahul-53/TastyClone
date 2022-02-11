package com.rahul.tastyclone.model.local

import androidx.room.TypeConverter
import com.rahul.tastyclone.model.remote.Measures
import com.rahul.tastyclone.model.remote.Us

class Converters {
    @TypeConverter
    fun  fromSource(source: Measures):String{
        return source.metric.toString()
    }

    /*@TypeConverter
    fun toSource(metric:String):Measures{
        return Measures(metric,null)
    }*/
}