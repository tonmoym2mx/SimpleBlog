package developer.tonmoy.simpleblog.data.model.blog


import com.google.gson.annotations.SerializedName

data class BlogsData(
    @SerializedName("blogs")
    var blogs: List<Blog>? = null
)