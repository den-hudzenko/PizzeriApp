package com.example.pizzeriapp.Database

import kotlinx.coroutines.flow.Flow

class OfflineFinanceItemRepository(private val financeDao: GoodDao) : GoodItemsRepository {
    override suspend fun insert(item: GoodItem) = financeDao.insert(item)

    override suspend fun update(item: GoodItem) = financeDao.update(item)

    override suspend fun delete(id: Int) = financeDao.delete(id)


    override fun getAllItems(): Flow<List<GoodItem>> = financeDao.getAllItems()

    override fun countByTitle(title: String): Int = financeDao.countByTitle(title)

    override suspend fun deleteItemsWithDuplicateDescriptions() = financeDao.deleteItemsWithDuplicateDescriptions()

}