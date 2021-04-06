package developer.tonmoy.simpleblog.data.remote.repository

import developer.tonmoy.simpleblog.data.local.db.DatabaseHelper
import developer.tonmoy.simpleblog.data.model.blog.Blog
import developer.tonmoy.simpleblog.data.model.blog.BlogsData

import developer.tonmoy.simpleblog.data.remote.api.AppApiHelper

interface AppRepository {
    val appApiHelper: AppApiHelper
    val databaseHelper: DatabaseHelper
    companion object{
        operator fun invoke(appApiHelper: AppApiHelper, databaseHelper: DatabaseHelper): AppRepository =
                AppRepositoryImpl(appApiHelper,databaseHelper)
    }

    suspend fun listOfBlog(): List<Blog>?
}