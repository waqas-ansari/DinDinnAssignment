package co.ansari.dindinnassignment.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import co.ansari.dindinnassignment.data.model.FoodModel
import io.reactivex.Observable

@Dao
interface FoodDao {

    /**
     * Inserts food item list in DB with
     * replace on conflict strategy
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFoodItems(foodList: List<FoodModel>)


    /**
     * Gets all the food item present in DB
     */
    @Query("SELECT * FROM FoodItem")
    fun getAllFoodItems(): Observable<List<FoodModel>>

    /**
     * Gets food item by category
     */
    @Query("SELECT * FROM FoodItem WHERE category =:category")
    fun getFoodItemByCategory(category: String): Observable<List<FoodModel>>

    /**
     * Get all the food items which are added
     * in cart
     */
    @Query("SELECT * FROM FoodItem WHERE addedToCart = 1")
    fun getCartFoodItems(): Observable<List<FoodModel>>


    /**
     * Adds the item in the cart by setting it to True
     * and increasing the count of items
     */
    @Query("UPDATE FoodItem SET addedToCart = 1 AND itemCount = itemCount + 1 WHERE id =:id")
    fun addToCart(id: Long)


    /**
     * Removes the item from the cart
     */
    @Query("UPDATE FoodItem SET addedToCart = 0 AND itemCount = 0 WHERE id =:id")
    fun removeFromCart(id: Long)

}