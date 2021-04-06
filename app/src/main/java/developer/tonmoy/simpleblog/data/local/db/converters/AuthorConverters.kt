package developer.tonmoy.simpleblog.data.local.db.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import developer.tonmoy.simpleblog.data.model.blog.Author

class AuthorConverters {
    @TypeConverter
    fun jsonStringToObject(jsonString:String): Author {
        return Gson().fromJson(jsonString,Author::class.java)
    }

    @TypeConverter
    fun objectToJsonString(objects: Author): String? {
        return  Gson().toJson(objects)
    }
}