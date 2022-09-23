package com.example.jonsays

import android.content.Context
import androidx.room.*

@Database(entities = [Page::class], version = 1, exportSchema = false)
abstract class PageDatabase : RoomDatabase() {
    abstract fun PageDao(): PageDao

    companion object {
        @Volatile
        private var instance: PageDatabase? = null

        fun getDatabase(context: Context): PageDatabase =
            instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    PageDatabase::class.java,
                    "recipes"
                )
                    //.addTypeConverter(IngredientsConverters::class)
                    .fallbackToDestructiveMigration()
                    .build().also {
                    instance = it
                }
            }
    }
}

