package com.example.jonsays.other

import android.app.Application
import com.example.jonsays.other.Page
import com.example.jonsays.other.PageDao
import com.example.jonsays.other.PageDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class PageRepository @Inject constructor(
    private var pageDao: PageDao) {

    fun getPages() = pageDao.getPages()

    fun getPage(id: Int) = pageDao.getPage(id)

    suspend fun addPage(page: Page) {
        pageDao.addPage(page)
    }

    suspend fun update(page: Page) {
        pageDao.update(page)
    }

    suspend fun delete(page: Page) {
        pageDao.deletePage(page)
    }
}