package com.example.room.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.room.dao.CityDao
import com.example.room.entities.City
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(City::class), version = 1, exportSchema = false)
abstract class Db : RoomDatabase() {

    abstract fun citydao(): CityDao

    companion object {
        @Volatile
        private var INSTANCE: Db? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): Db {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    Db::class.java,
                    "word_database"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(WordDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

    private class WordDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.citydao())
                }
            }
        }

        fun populateDatabase(cityDao: CityDao) {
            // Delete all content here.
            //cityDao.deleteAll()

            // Add sample words.
            var city = City("viana", "Portugal")
            cityDao.insert(city)
            city = City("aveiro", "Portugal")
            cityDao.insert(city)
            city = City("madrid", "Spain")
            cityDao.insert(city)
        }
    }
}
