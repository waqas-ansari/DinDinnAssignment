package co.ansari.dindinnassignment.ui.cart

import androidx.lifecycle.MutableLiveData
import co.ansari.dindinnassignment.FoodApp
import co.ansari.dindinnassignment.data.repo.FoodRepo
import co.ansari.dindinnassignment.ui.main.food.FoodListState
import com.airbnb.mvrx.*

class FoodCartViewModel(
    initialState: FoodListState,
    private val foodRepo: FoodRepo
) : BaseMvRxViewModel<FoodListState>(initialState, debugMode = true) {

    val errorMessage = MutableLiveData<String>()

    init {
        setState {
            copy(foodList = Loading())
        }

        foodRepo.getLocalFoodList()
            .execute {
                copy(foodList = it)
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

    companion object : MvRxViewModelFactory<FoodCartViewModel, FoodListState> {
        override fun create(
            viewModelContext: ViewModelContext,
            state: FoodListState
        ): FoodCartViewModel? {
            val foodRepo = viewModelContext.app<FoodApp>().foodRepo
            return FoodCartViewModel(state, foodRepo)
        }
    }

}