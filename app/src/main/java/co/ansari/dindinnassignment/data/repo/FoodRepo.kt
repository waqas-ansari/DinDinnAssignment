package co.ansari.dindinnassignment.data.repo

import android.app.Application
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import co.ansari.dindinnassignment.R
import co.ansari.dindinnassignment.data.local.FoodLocalDataSource
import co.ansari.dindinnassignment.data.local.room.DinDinnDatabase
import co.ansari.dindinnassignment.data.model.FoodModel
import co.ansari.dindinnassignment.data.remote.ApiService
import co.ansari.dindinnassignment.data.remote.FoodRemoteDataSource
import co.ansari.dindinnassignment.ui.main.food.FoodListFragment
import co.ansari.dindinnassignment.utils.Constants
import co.ansari.dindinnassignment.utils.Constants.CONST_FOOD_LIST
import com.airbnb.mvrx.withState
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class FoodRepo constructor(application: Application) {

    private val foodList = mutableListOf<FoodModel>()

    fun getLocalFoodList() = Observable.fromCallable<List<FoodModel>> {
        Thread.sleep(1000)
        foodList.addAll(listOf(
            FoodModel(
                1234,
                "The Pizza Shop",
                "Can you imagine a pizza so good that people who have eaten it have enjoyed " +
                        "it so much that they can’t stand to be without it?\n" +
                        "When the craving hits, and believe that it will, you will go to great " +
                        "lengths to be able to enjoy a The Pizza Shop just one more time.",
                "400 grams, 40 cm",
                "pizza",
                R.drawable.pizza_1,
                122F,
                "USD",
                false,
                0
            ),
            FoodModel(
                1235,
                "The Pizza Shop",
                "Can you imagine a pizza so good that people who have eaten it have enjoyed " +
                        "it so much that they can’t stand to be without it?\n" +
                        "When the craving hits, and believe that it will, you will go to great " +
                        "lengths to be able to enjoy a The Pizza Shop just one more time.",
                "400 grams, 40 cm",
                "pizza",
                R.drawable.pizza_2,
                200F,
                "USD",
                false,
                0
            ),
            FoodModel(
                1236,
                "The Pizza Shop",
                "Can you imagine a pizza so good that people who have eaten it have enjoyed " +
                        "it so much that they can’t stand to be without it?\n" +
                        "When the craving hits, and believe that it will, you will go to great " +
                        "lengths to be able to enjoy a The Pizza Shop just one more time.",
                "400 grams, 40 cm",
                "pizza",
                R.drawable.pizza_3,
                211.99F,
                "USD",
                false,
                0
            ),
            FoodModel(
                1237,
                "The Pizza Shop",
                "Can you imagine a pizza so good that people who have eaten it have enjoyed " +
                        "it so much that they can’t stand to be without it?\n" +
                        "When the craving hits, and believe that it will, you will go to great " +
                        "lengths to be able to enjoy a The Pizza Shop just one more time.",
                "400 grams, 40 cm",
                "pizza",
                R.drawable.pizza_4,
                450F,
                "USD",
                false,
                0
            ),
            FoodModel(
                1237,
                "The Pizza Shop",
                "Can you imagine a pizza so good that people who have eaten it have enjoyed " +
                        "it so much that they can’t stand to be without it?\n" +
                        "When the craving hits, and believe that it will, you will go to great " +
                        "lengths to be able to enjoy a The Pizza Shop just one more time.",
                "400 grams, 40 cm",
                "pizza",
                R.drawable.pizza_5,
                450F,
                "USD",
                false,
                0
            ),
            FoodModel(
                1238,
                "The Sushi Shop",
                "Can you imagine a Sushi so good that people who have eaten it have enjoyed " +
                        "it so much that they can’t stand to be without it?\n" +
                        "When the craving hits, and believe that it will, you will go to great " +
                        "lengths to be able to enjoy a The Sushi Shop just one more time.",
                "10 pc, each 50 grams",
                "sushi",
                R.drawable.sushi_1,
                1000F,
                "USD",
                false,
                0
            ),
            FoodModel(
                1239,
                "The Sushi Shop",
                "Can you imagine a Sushi so good that people who have eaten it have enjoyed " +
                        "it so much that they can’t stand to be without it?\n" +
                        "When the craving hits, and believe that it will, you will go to great " +
                        "lengths to be able to enjoy a The Sushi Shop just one more time.",
                "10 pc, each 50 grams",
                "sushi",
                R.drawable.sushi_2,
                999F,
                "USD",
                false,
                0
            ),
            FoodModel(
                1210,
                "The Sushi Shop",
                "Can you imagine a Sushi so good that people who have eaten it have enjoyed " +
                        "it so much that they can’t stand to be without it?\n" +
                        "When the craving hits, and believe that it will, you will go to great " +
                        "lengths to be able to enjoy a The Sushi Shop just one more time.",
                "10 pc, each 50 grams",
                "sushi",
                R.drawable.sushi_3,
                599F,
                "USD",
                false,
                0
            ),
            FoodModel(
                1211,
                "The Sushi Shop",
                "Can you imagine a Sushi so good that people who have eaten it have enjoyed " +
                        "it so much that they can’t stand to be without it?\n" +
                        "When the craving hits, and believe that it will, you will go to great " +
                        "lengths to be able to enjoy a The Sushi Shop just one more time.",
                "10 pc, each 50 grams",
                "sushi",
                R.drawable.sushi_4,
                1000F,
                "USD",
                false,
                0
            ),
            FoodModel(
                1212,
                "The Drinks Shop",
                "Can you imagine a drink so good that people who have eaten it have enjoyed " +
                        "it so much that they can’t stand to be without it?\n" +
                        "When the craving hits, and believe that it will, you will go to great " +
                        "lengths to be able to enjoy a The Drinks Shop just one more time.",
                "400 grams, 40 cm",
                "drink",
                R.drawable.drink_1,
                22F,
                "USD",
                false,
                0
            ),
            FoodModel(
                1213,
                "The Drinks Shop",
                "Can you imagine a drink so good that people who have eaten it have enjoyed " +
                        "it so much that they can’t stand to be without it?\n" +
                        "When the craving hits, and believe that it will, you will go to great " +
                        "lengths to be able to enjoy a The Drinks Shop just one more time.",
                "400 grams, 40 cm",
                "drink",
                R.drawable.drink_2,
                22F,
                "USD",
                false,
                0
            ),
            FoodModel(
                1214,
                "The Drinks Shop",
                "Can you imagine a drink so good that people who have eaten it have enjoyed " +
                        "it so much that they can’t stand to be without it?\n" +
                        "When the craving hits, and believe that it will, you will go to great " +
                        "lengths to be able to enjoy a The Drinks Shop just one more time.",
                "400 grams, 40 cm",
                "drink",
                R.drawable.drink_3,
                22F,
                "USD",
                false,
                0
            ),
            FoodModel(
                1215,
                "The Drinks Shop",
                "Can you imagine a drink so good that people who have eaten it have enjoyed " +
                        "it so much that they can’t stand to be without it?\n" +
                        "When the craving hits, and believe that it will, you will go to great " +
                        "lengths to be able to enjoy a The Drinks Shop just one more time.",
                "400 grams, 40 cm",
                "drink",
                R.drawable.drink_4,
                22F,
                "USD",
                false,
                0
            ),
            FoodModel(
                1216,
                "The Drinks Shop",
                "Can you imagine a drink so good that people who have eaten it have enjoyed " +
                        "it so much that they can’t stand to be without it?\n" +
                        "When the craving hits, and believe that it will, you will go to great " +
                        "lengths to be able to enjoy a The Drinks Shop just one more time.",
                "400 grams, 40 cm",
                "drink",
                R.drawable.drink_5,
                22F,
                "USD",
                false,
                0
            ),
            FoodModel(
                1217,
                "The Drinks Shop",
                "Can you imagine a drink so good that people who have eaten it have enjoyed " +
                        "it so much that they can’t stand to be without it?\n" +
                        "When the craving hits, and believe that it will, you will go to great " +
                        "lengths to be able to enjoy a The Drinks Shop just one more time.",
                "400 grams, 40 cm",
                "drink",
                R.drawable.drink_6,
                22F,
                "USD",
                false,
                0
            ),
            FoodModel(
                1218,
                "The Drinks Shop",
                "Can you imagine a drink so good that people who have eaten it have enjoyed " +
                        "it so much that they can’t stand to be without it?\n" +
                        "When the craving hits, and believe that it will, you will go to great " +
                        "lengths to be able to enjoy a The Drinks Shop just one more time.",
                "400 grams, 40 cm",
                "drink",
                R.drawable.drink_7,
                22F,
                "USD",
                false,
                0
            )
        ))
        foodList
    }.subscribeOn(Schedulers.io())

    /*
    Initialize shared preferences object
     */
    private var sharedPreferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(application)

    private val apiService by lazy {
        ApiService.create()
    }

    /*
    Initialize the objects of local and remote data
    source for getting data locally or through an API call
     */
    private var foodLocalDataSource: FoodLocalDataSource

    private var foodRemoteDataSource: FoodRemoteDataSource

    init {
        val dinDinnDb = DinDinnDatabase.getInstance(application)
        foodLocalDataSource = FoodLocalDataSource(dinDinnDb.getFoodDao())

        foodRemoteDataSource = FoodRemoteDataSource(apiService)
    }


    /**
     * Get food list from the DB and/or network
     * call if specific time interval has passed
     */
    fun getFoodList(category: String): Observable<List<FoodModel>> {
        return getLocalFoodList()

        /*
        This code can be used to fetch data from local data source
        as well as remote data source
         */

        /*
        val localData = foodLocalDataSource.getFoodItemByCategory(category)
        if (updateFoodFromNetwork()) {
            /*
            Update food items after specific interval of time
            so that data remains fresh
             */
            foodRemoteDataSource.getLocalFoodList()
                .observeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .subscribe {
                    foodLocalDataSource.insertFoodItems(it)
                }.dispose()
        }
        return localData
         */
    }


    /**
     * Responsible for analyzing if an hour is passed since last
     * the food items have been fetched from server.
     * Returns true if it does.
     */
    private fun updateFoodFromNetwork(): Boolean {
        val lastUpdatedTime = sharedPreferences.getLong(Constants.PREF_KEY_LAST_UPDATED_TIME, 0L)
        if (lastUpdatedTime == 0L ||
            (System.currentTimeMillis() > (lastUpdatedTime + Constants.ONE_HRS_IN_MILLISECONDS))) {

            updateLongInPreferences(Constants.PREF_KEY_LAST_UPDATED_TIME, System.currentTimeMillis())
            return true
        }
        return false
    }


    /**
     * Updates the long in shared preferences
     */
    private fun updateLongInPreferences(key: String, value: Long) {
        val editor = sharedPreferences.edit()
        editor.putLong(key, value)
        editor.apply()
    }


    /**
     * Method to add food into the cart and increase
     * the count of added items
     */
    fun addToCart(foodId: Long): Observable<FoodModel> {
        return Observable.fromCallable {
            val food = foodList.first { food -> food.id == foodId }
            food.copy(addedToCart = true, itemCount = food.itemCount + 1)
        }
    }


    /**
     * Method to remove food from the cart
     */
    fun removeFromCart(foodId: Long): Observable<FoodModel> {
        return Observable.fromCallable {
            val food = foodList.first { food -> food.id == foodId }
            food.copy(addedToCart = false)
        }
    }

}