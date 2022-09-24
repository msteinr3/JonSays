package com.example.jonsays.other

import android.app.Application
import androidx.lifecycle.*
import com.example.jonsays.other.Page
import com.example.jonsays.other.PageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PageViewModel @Inject constructor(
    private val repository: PageRepository) : ViewModel() {
    private val _id = MutableLiveData<Int>()

    private val _page = _id.switchMap {
        repository.getPage(it)
    }

    val page : LiveData<Page> = _page

    fun update(page: Page) {
        viewModelScope.launch {
            repository.update(page)
        }
    }

    fun setId(id: Int) {
        _id.value = id
    }
}

/*
 fun getPages() = repository.getPages()

    fun addPage(page: Page) {
        viewModelScope.launch {
            repository.addPage(page)
        }
    }
 */