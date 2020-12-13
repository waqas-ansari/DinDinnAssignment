package co.ansari.dindinnassignment.data.remote

import co.ansari.dindinnassignment.R
import co.ansari.dindinnassignment.data.model.FoodModel
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class FoodRemoteDataSource constructor(private val apiService: ApiService) {

    private val foodList = mutableListOf<FoodModel>()

    fun getFoodList() = apiService.fetchFoodItems()

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
                "drinks",
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
                "drinks",
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
                "drinks",
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
                "drinks",
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
                "drinks",
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
                "drinks",
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
                "drinks",
                R.drawable.drink_7,
                22F,
                "USD",
                false,
                0
            )
        ))
        foodList
    }.subscribeOn(Schedulers.io())

}