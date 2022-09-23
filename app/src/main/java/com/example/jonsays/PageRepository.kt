package com.example.jonsays

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class PageRepository(application: Application) : CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO

    private var pageDao: PageDao?

    init {
        val db = PageDatabase.getDatabase(application)
        pageDao = db.PageDao()
    }

    fun getPages() = pageDao?.getPages()

    fun addPage(page: Page) {
        launch {
            pageDao?.addPage(page)
        }
    }
}