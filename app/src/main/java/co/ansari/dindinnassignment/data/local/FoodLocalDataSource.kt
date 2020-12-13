package co.ansari.dindinnassignment.data.local

import co.ansari.dindinnassignment.data.local.room.FoodDao
import co.ansari.dindinnassignment.data.model.FoodModel

class FoodLocalDataSource constructor(private val foodDao: FoodDao) {

    fun insertFoodItems(foodItems: List<FoodModel>) {
        foodDao.insertFoodItems(foodItems)
    }

    fun getAllFoodItems() = foodDao.getAllFoodItems()

    fun getFoodItemByCategory(category: String) = foodDao.getFoodItemByCategory(category)

    fun getCartFoodItems() = foodDao.getCartFoodItems()

    fun addToCart(id: Long) = foodDao.addToCart(id)

    fun removeFromCart(id: Long) = foodDao.removeFromCart(id)

}