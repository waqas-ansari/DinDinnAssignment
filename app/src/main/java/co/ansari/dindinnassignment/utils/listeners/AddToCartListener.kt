package co.ansari.dindinnassignment.utils.listeners

import co.ansari.dindinnassignment.data.model.FoodModel

interface AddToCartListener {
    fun onAddedToCart(foodModel: FoodModel)
}