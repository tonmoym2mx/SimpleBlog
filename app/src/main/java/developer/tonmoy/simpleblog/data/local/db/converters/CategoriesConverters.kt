package developer.tonmoy.simpleblog.data.local.db.converters

import androidx.room.TypeConverter
import com.google.gson.Gson

class CategoriesConverters {
    @TypeConverter
    fun jsonStringToObject(jsonString:String): List<String> {
        return Gson().fromJson(jsonString,Array<String>::class.java).toList()
    }

    @TypeConverter
    fun objectToJsonString(objects: List<String>?): String? {
        return  Gson().toJson(objects)
    }
}
