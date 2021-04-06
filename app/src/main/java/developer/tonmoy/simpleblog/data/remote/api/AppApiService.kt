package developer.tonmoy.simpleblog.data.remote.api

import developer.tonmoy.simpleblog.data.model.blog.BlogsData
import retrofit2.http.GET

interface AppApiService {
    @GET("db")
    suspend fun fetchBlog(): BlogsData
}