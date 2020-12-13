package co.ansari.dindinnassignment.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import co.ansari.dindinnassignment.data.model.FoodModel
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * Standard RoomDB Class, using version and entities
 * to build the DB.
 * Notice the TypeConverters which is used to
 * convert list of Multimedia into JSON and
 * vice-versa using Gson library
 */
@Database(entities = [FoodModel::class], version = 1, exportSchema = false)
abstract class DinDinnDatabase : RoomDatabase() {

    abstract fun getFoodDao(): FoodDao

    companion object {
        private const val DB_NAME = "din_dinn_corp_db"

        /**
         * Initialize executor service to execute
         * insertion on background thread with
         * 4 threads pool
         */
        val databaseExecutorService: ExecutorService = Executors.newFixedThreadPool(4)


        @Volatile
        private var INSTANCE: DinDinnDatabase? = null

        /**
         * Method to get DB instance. It makes sure
         * that only one instance is available throughout the
         * app life cycle by applying Singleton Design Pattern.
         *
         * It can be done more beautifully by using DI but due
         * to time constraint, it couldn't be used.
         */
        fun getInstance(context: Context): DinDinnDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        DinDinnDatabase::class.java,
                        DB_NAME
                    )
                    .build()

                INSTANCE = instance
                return instance
            }
        }
    }
}