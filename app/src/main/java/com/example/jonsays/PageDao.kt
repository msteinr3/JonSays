package com.example.jonsays

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPage(page: Page)

    @Query("SELECT * FROM `pages` WHERE id = :id")
    fun getRecipe(id: Int): LiveData<Page>

    @Query("DELETE FROM `pages` WHERE id = :title") //???
    suspend fun deleteByTitle(title: String) //userId: Int

    @Update
    suspend fun update(vararg page: Page)
}

