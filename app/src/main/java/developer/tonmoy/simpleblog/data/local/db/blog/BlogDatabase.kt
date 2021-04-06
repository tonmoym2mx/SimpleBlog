package developer.tonmoy.simpleblog.data.local.db.blog
import androidx.room.*
import developer.tonmoy.simpleblog.data.local.db.converters.AuthorConverters
import developer.tonmoy.simpleblog.data.local.db.converters.CategoriesConverters
import developer.tonmoy.simpleblog.data.model.blog.Blog

@Database(entities = [Blog::class],version = 1)
@TypeConverters(CategoriesConverters::class, AuthorConverters::class)
abstract class BlogDatabaseDatabase: RoomDatabase() {
    abstract fun dao(): BlogDatabaseDao
}
