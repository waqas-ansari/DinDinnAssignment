package co.ansari.dindinnassignment.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import androidx.lifecycle.Observer
import co.ansari.dindinnassignment.R
import co.ansari.dindinnassignment.ui.cart.FoodCartActivity
import co.ansari.dindinnassignment.ui.cart.FoodCartFragment
import co.ansari.dindinnassignment.ui.components.adapters.FoodSectionPagerAdapter
import co.ansari.dindinnassignment.ui.main.food.FoodListViewModel
import co.ansari.dindinnassignment.utils.AnimationUtils
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.viewModel
import kotlinx.android.synthetic.main.fragment_fragment_main.*

class MainActivity : AppCompatActivity() {

    // ViewModel
    private val foodViewModel: FoodListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentMain = FragmentMain()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragmentMain)
        transaction.commit()

    }


}
