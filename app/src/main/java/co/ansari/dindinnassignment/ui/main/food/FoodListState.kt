package co.ansari.dindinnassignment.ui.main.food

import co.ansari.dindinnassignment.data.model.FoodModel
import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized

data class FoodListState(
    val foodList: Async<List<FoodModel>> = Uninitialized
) : MvRxState