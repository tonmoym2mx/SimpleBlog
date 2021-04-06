package developer.tonmoy.simpleblog.data.remote.api

import developer.tonmoy.simpleblog.data.model.blog.BlogsData


class AppApiHelperImpl(
    override val apiService: AppApiService
) : AppApiHelper {
    override suspend fun fetchBlog(): BlogsData = apiService.fetchBlog()
}
