package developer.tonmoy.simpleblog.data.local.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlin.reflect.KClass

class DatabaseBuilder< DB:RoomDatabase,DAO : Any>(
        private val databaseType:Class<DB>,
        private val daoType:KClass<DAO>,
        private val databaseName:String,
        private val context: Context
) {
    private var INSTANCE: DB? = null



    fun getInstance(): DB {
        if (INSTANCE == null) {
            synchronized(daoType) {
                INSTANCE = buildRoomDB()
            }
        }
        return INSTANCE!!
    }
    private fun buildRoomDB() =
            Room.databaseBuilder(
                    context.applicationContext,
                    databaseType,
                    databaseName
            ).fallbackToDestructiveMigration()
             .build()
    companion object{
        inline operator fun<reified DB:RoomDatabase,DAO:Any> invoke(
                databaseType:Class<DB>,
               daoType:KClass<DAO>,
               context: Context):DB{
            return DatabaseBuilder(
                    databaseType = databaseType,
                    daoType = daoType,
                    databaseName = DB::class.simpleName?:"AppDatabase",
                    context = context
            ).getInstance()
        }
    }

}