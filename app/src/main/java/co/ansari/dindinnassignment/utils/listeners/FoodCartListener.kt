package co.ansari.dindinnassignment.utils.listeners

import co.ansari.dindinnassignment.data.model.FoodModel

interface FoodCartListener {
    fun removeFromCart(foodModel: FoodModel)
}