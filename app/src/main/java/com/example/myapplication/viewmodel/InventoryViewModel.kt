package com.example.myapplication.viewmodel

import androidx.lifecycle.*
import com.example.myapplication.data.Item
import com.example.myapplication.data.ItemDao
import kotlinx.coroutines.launch

class InventoryViewModel(private val itemDao: ItemDao) : ViewModel() {
    val allItems: LiveData<List<Item>> = itemDao.getItems().asLiveData()

    fun addNewItem(itemName: String, itemPrice: String, itemCount: String) {
        val newItem = getNewItemEntry(itemName, itemPrice, itemCount)
        insertItem(newItem)
    }

    private fun getNewItemEntry(itemName: String, itemPrice: String, itemCount: String): Item {
        return Item(
            itemName = itemName,
            itemPrice = itemPrice.toDouble(),
            quantityInStock = itemCount.toInt()
        )
    }

    private fun insertItem(item: Item) {
        viewModelScope.launch {
            itemDao.insert(item)
        }

    }
    /**
     * Returns true if the EditTexts are not empty
     */
    fun isEntryValid(itemName: String, itemPrice: String, itemCount: String): Boolean {
        if (itemName.isBlank() || itemPrice.isBlank() || itemCount.isBlank()) {
            return false
        }
        return true
    }

    /**
     * Factory class to instantiate the [ViewModel] instance.
     */
    class InventoryViewModelFactory(private val itemDao: ItemDao) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(InventoryViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return InventoryViewModel(itemDao) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
