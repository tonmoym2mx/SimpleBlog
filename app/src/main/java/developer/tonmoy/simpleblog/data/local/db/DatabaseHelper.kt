package developer.tonmoy.simpleblog.data.local.db

import developer.tonmoy.simpleblog.data.local.db.blog.BlogDatabaseDatabase
import developer.tonmoy.simpleblog.data.model.blog.Blog

class DatabaseHelper(
        private val blogDatabaseDatabase: BlogDatabaseDatabase
        ) {
    suspend fun insertBlog(listOfBlog: List<Blog>)  =  blogDatabaseDatabase.dao().insertList(listOfBlog)
    suspend fun allBlogs() = blogDatabaseDatabase.dao().getAll()
}