package developer.tonmoy.simpleblog.data.model.blog


import com.google.gson.annotations.SerializedName

data class Author(
    @SerializedName("avatar")
    var avatar: String? = null,
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("profession")
    var profession: String? = null
)