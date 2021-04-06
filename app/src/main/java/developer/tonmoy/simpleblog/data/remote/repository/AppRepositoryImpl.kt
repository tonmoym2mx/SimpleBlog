package developer.tonmoy.simpleblog.data.remote.repository

import developer.tonmoy.simpleblog.data.local.db.DatabaseHelper
import developer.tonmoy.simpleblog.data.model.blog.Blog
import developer.tonmoy.simpleblog.data.model.common.isSuccess
import developer.tonmoy.simpleblog.data.remote.api.AppApiHelper
import developer.tonmoy.simpleblog.data.remote.network.safeApiCall

class AppRepositoryImpl(override val appApiHelper: AppApiHelper,
                        override val databaseHelper: DatabaseHelper
) : AppRepository {
    override suspend fun listOfBlog(): List<Blog>? {
        val response = safeApiCall { appApiHelper.fetchBlog()  }
        val listOfBlog = response?.data?.blogs
        if(response.isSuccess() && !listOfBlog.isNullOrEmpty()){
              databaseHelper.insertBlog(listOfBlog)
        }
        return databaseHelper.allBlogs()
    }

}