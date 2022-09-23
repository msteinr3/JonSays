package com.example.jonsays

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPage(page: Page)

    @Query("SELECT * FROM `pages` WHERE id = :id")
    fun getPage(id: Int): LiveData<Page>

    @Query("SELECT * FROM `pages` ORDER BY name ASC")
    fun getPages(): LiveData<List<Page>>

    @Delete
    suspend fun deletePage(vararg page: Page)

    @Update
    suspend fun update(vararg page: Page)
}

