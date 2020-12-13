package co.ansari.dindinnassignment.ui.main.food


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import co.ansari.dindinnassignment.R
import co.ansari.dindinnassignment.data.model.FoodModel
import co.ansari.dindinnassignment.ui.components.adapters.FoodAdapter
import co.ansari.dindinnassignment.utils.AnimationUtils
import co.ansari.dindinnassignment.utils.listeners.AddToCartListener
import com.airbnb.mvrx.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_food_list.*

/**
 * A simple [Fragment] subclass.
 */
class FoodListFragment : BaseMvRxFragment(), AddToCartListener {

    // Initialize adapter to show food items list
    private lateinit var foodAdapter: FoodAdapter

    // ViewModel
    private val foodViewModel: FoodListViewModel by activityViewModel()

    companion object {
        /**
         * The fragment argument representing the category for this
         * fragment.
         */
        private const val ARG_FOOD_CATEGORY = "food_category"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(category: String): FoodListFragment {
            return FoodListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_FOOD_CATEGORY, category.toLowerCase())
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        foodViewModel.initFoodList(arguments?.getString(ARG_FOOD_CATEGORY)!!)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fabLayout.visibility = View.GONE
        foodAdapter = FoodAdapter(this)
        foodListRecyclerView.apply {
            adapter = foodAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        foodViewModel.errorMessage.observe(viewLifecycleOwner, Observer {
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
                    foodAdapter.submitList(state.foodList.invoke().filter { it.category.toLowerCase() == arguments?.getString(
                        ARG_FOOD_CATEGORY, "pizza") })
                }
                is Fail -> {
                    Toast.makeText(requireContext(), "Failed to load food items list", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onAddedToCart(foodModel: FoodModel) {
        foodViewModel.addToCart(foodModel.id)

        var cartItems = foodViewModel.cartItemCount.value
        if (cartItems == null) {
            cartItems = 0
        }
        cartItems++
        foodViewModel.cartItemCount.postValue(cartItems)
    }


}
