package co.ansari.dindinnassignment.ui.cart


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import co.ansari.dindinnassignment.R
import co.ansari.dindinnassignment.data.model.FoodModel
import co.ansari.dindinnassignment.ui.components.adapters.FoodCartAdapter
import co.ansari.dindinnassignment.ui.main.food.FoodListViewModel
import co.ansari.dindinnassignment.utils.listeners.FoodCartListener
import com.airbnb.mvrx.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_food_list.*
import kotlinx.android.synthetic.main.fragment_food_list.view.*

/**
 * A simple [Fragment] subclass.
 */
class FoodCartFragment : BaseMvRxFragment(), FoodCartListener {

    // Initialize adapter to show food items list
    private lateinit var foodAdapter: FoodCartAdapter

    // ViewModel
    private val foodViewModel: FoodListViewModel by activityViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fabLayout.visibility = View.VISIBLE
        fabLayout.fabCheckout.setImageResource(R.drawable.ic_credit_card)


        foodAdapter = FoodCartAdapter(this)
        foodListRecyclerView.apply {
            adapter = foodAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        foodViewModel.errorMessage.observe(this, Observer {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        })
    }

    override fun invalidate() {
        withState(foodViewModel) { state ->
            when (state.foodList) {
                is Loading -> {
                    progress_bar.visibility = View.VISIBLE
                    foodListRecyclerView.visibility = View.GONE
                }
                is Success -> {
                    progress_bar.visibility = View.GONE
                    foodListRecyclerView.visibility = View.VISIBLE
                    foodAdapter.submitList(state.foodList.invoke().filter { it.addedToCart })
                }
                is Fail -> {
                    Toast.makeText(requireContext(), "Failed to load food items list", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun removeFromCart(foodModel: FoodModel) {
        foodViewModel.removeFromCart(foodModel.id)

        var currentCartCount = foodViewModel.cartItemCount.value
        if (currentCartCount == null) {
            currentCartCount = 1
        }

        currentCartCount--
        foodViewModel.cartItemCount.postValue(currentCartCount)
    }


}
