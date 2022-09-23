package com.example.jonsays

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PageViewModel(application: Application) : AndroidViewModel(application) {
    private var repository = PageRepository(application)

    fun getPages() = repository.getPages()

    fun addPage(page: Page) {
        viewModelScope.launch {
            repository.addPage(page)
        }
    }
}