package developer.tonmoy.simpleblog.data.model.blog


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
data class Blog(
    @SerializedName("id")
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @SerializedName("author")
    var author: Author? = null,
    @SerializedName("categories")
    var categories: List<String>? = null,
    @SerializedName("cover_photo")
    var coverPhoto: String? = null,
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("title")
    var title: String? = null
):Serializable