package com.example.pizzeriapp.ViewModel

import android.widget.Toast
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pizzeriapp.Database.GoodItem
import com.example.pizzeriapp.Database.GoodItemsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DBViewModel(private val itemRepository: GoodItemsRepository) : ViewModel() {
    fun insert(item: GoodItem) = viewModelScope.launch {
        val count = withContext(Dispatchers.IO) {
            itemRepository.countByTitle(item.title)
        }
        if (count == 0) {
            withContext(Dispatchers.IO) {
                itemRepository.insert(item)
            }
        }

    }
    fun delete(id : Int) = viewModelScope.launch{
        itemRepository.delete(id)
    }
    fun getAllSpendingItems() : Flow<List<GoodItem>> {
        return itemRepository.getAllItems()
    }

    fun deleteDuplicate() = viewModelScope.launch {
        itemRepository.deleteItemsWithDuplicateDescriptions()
    }
    fun updateItem(item: GoodItem, plus : Int) = viewModelScope.launch {
        itemRepository.update(item.copy(quantity = item.quantity + plus))
    }

}
