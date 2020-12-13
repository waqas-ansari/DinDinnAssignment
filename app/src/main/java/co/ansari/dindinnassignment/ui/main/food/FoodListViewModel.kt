package co.ansari.dindinnassignment.ui.main.food

import android.util.Log
import androidx.lifecycle.MutableLiveData
import co.ansari.dindinnassignment.FoodApp
import co.ansari.dindinnassignment.data.repo.FoodRepo
import com.airbnb.mvrx.*
import io.reactivex.Observable

class FoodListViewModel(
    initialState: FoodListState,
    private val foodRepo: FoodRepo
) : BaseMvRxViewModel<FoodListState>(initialState, debugMode = true) {

    val errorMessage = MutableLiveData<String>()
    var cartItemCount = MutableLiveData(0)
    var currentFragment = MutableLiveData("list")

    init {
        setState {
            copy(foodList = Loading())
        }

        foodRepo.getLocalFoodList()
            .execute {
                copy(foodList = it)
            }
    }

    fun initFoodList(category: String) {

    }

    fun addToCart(foodId: Long) {
        withState { state ->
            if (state.foodList is Success) {
                val index = state.foodList.invoke().indexOfFirst {
                    it.id == foodId
                }
                foodRepo.addToCart(foodId)
                    .execute {
                        when (it) {
                            is Success -> {
                                copy(
                                    foodList = Success(
                                        state.foodList.invoke().toMutableList().apply {
                                            set(index, it.invoke())
                                        }
                                    )
                                )
                            }
                            is Fail -> {
                                errorMessage.postValue("Failed to add item to the cart")
                                copy()
                            }
                            else -> {
                                copy()
                            }
                        }
                    }
            }
        }
    }

    fun removeFromCart(foodId: Long) {
        withState { state ->
            if (state.foodList is Success) {
                val index = state.foodList.invoke().indexOfFirst {
                    it.id == foodId
                }
                foodRepo.removeFromCart(foodId)
                    .execute {
                        when (it) {
                            is Success -> {
                                copy(
                                    foodList = Success(
                                        state.foodList.invoke().toMutableList().apply {
                                            set(index, it.invoke())
                                        }
                                    )
                                )
                            }
                            is Fail -> {
                                errorMessage.postValue("Failed to remove item from the cart")
                                copy()
                            }
                            else -> {
                                copy()
                            }
                        }
                    }
            }
        }
    }

    companion object : MvRxViewModelFactory<FoodListViewModel, FoodListState> {
        override fun create(
            viewModelContext: ViewModelContext,
            state: FoodListState
        ): FoodListViewModel? {
            val foodRepo = viewModelContext.app<FoodApp>().foodRepo
            return FoodListViewModel(state, foodRepo)
        }
    }

}