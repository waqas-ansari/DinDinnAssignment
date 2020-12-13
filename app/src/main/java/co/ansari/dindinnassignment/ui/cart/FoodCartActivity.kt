package co.ansari.dindinnassignment.ui.cart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import co.ansari.dindinnassignment.R
import co.ansari.dindinnassignment.data.model.FoodModel
import co.ansari.dindinnassignment.ui.components.adapters.FoodAdapter
import co.ansari.dindinnassignment.ui.components.adapters.FoodCartAdapter
import co.ansari.dindinnassignment.ui.main.food.FoodListViewModel
import co.ansari.dindinnassignment.utils.listeners.FoodCartListener
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.viewModel
import kotlinx.android.synthetic.main.fragment_food_list.*

class FoodCartActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_cart)

        val foodCartFragment = FoodCartFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, foodCartFragment)
        transaction.commit()

    }

}
