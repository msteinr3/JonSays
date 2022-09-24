package com.example.jonsays.other

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllPagesViewModel @Inject constructor(

    private val pageRepository: PageRepository
) : ViewModel() {
    val pages = pageRepository.getPages()

    fun addPage(page: Page) {
        viewModelScope.launch {
            pageRepository.addPage(page)
        }
    }

    fun delete(page: Page) {
        viewModelScope.launch {
            pageRepository.delete(page)
        }
    }
}
