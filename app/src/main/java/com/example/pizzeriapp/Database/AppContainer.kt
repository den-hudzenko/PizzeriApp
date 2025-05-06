package com.example.pizzeriapp.Database

import android.content.Context


interface AppContainer{
    val itemsRepository : GoodItemsRepository
}

class AppDataClass(context : Context) : AppContainer{
    override val itemsRepository: GoodItemsRepository by lazy { OfflineFinanceItemRepository(GoodDatabase.getDatabase(context).goodDao())}
}