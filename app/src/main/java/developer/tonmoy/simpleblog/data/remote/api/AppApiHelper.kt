package developer.tonmoy.simpleblog.data.remote.api

import developer.tonmoy.simpleblog.data.model.blog.BlogsData

interface AppApiHelper {
    companion object{
        operator fun invoke(apiService: AppApiService): AppApiHelper = AppApiHelperImpl(apiService)
    }
    val apiService: AppApiService
    suspend fun fetchBlog(): BlogsData

   }