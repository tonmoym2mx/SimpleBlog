package developer.tonmoy.simpleblog.data.local.db.blog

import androidx.room.*
import developer.tonmoy.simpleblog.data.model.blog.Blog


@Dao
interface BlogDatabaseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg item: Blog?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertList(item: List<Blog>? )

    @Delete
    suspend fun delete(vararg item: Blog?)

    @Query("SELECT * FROM Blog")
    suspend fun getAll():List<Blog>
}