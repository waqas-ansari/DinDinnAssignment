package co.ansari.dindinnassignment.ui.main


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import co.ansari.dindinnassignment.R
import co.ansari.dindinnassignment.ui.cart.FoodCartActivity
import co.ansari.dindinnassignment.ui.cart.FoodCartFragment
import co.ansari.dindinnassignment.ui.components.adapters.FoodSectionPagerAdapter
import co.ansari.dindinnassignment.ui.components.adapters.ImageSliderAdapter
import co.ansari.dindinnassignment.ui.main.food.FoodListViewModel
import co.ansari.dindinnassignment.utils.AnimationUtils
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.activityViewModel
import kotlinx.android.synthetic.main.fragment_fragment_main.*

/**
 * A simple [Fragment] subclass.
 */
class FragmentMain : BaseMvRxFragment() {

    private val foodViewModel: FoodListViewModel by activityViewModel()

    override fun invalidate() {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pagerAdapter = FoodSectionPagerAdapter(requireActivity().supportFragmentManager)
        viewPagerContainer.adapter = pagerAdapter
        tabs.setupWithViewPager(viewPagerContainer, true)

        setupImageSlider()

        foodViewModel.cartItemCount.observe(requireActivity(), Observer { count ->
            addToCart(count)
        })

        showCart.setOnClickListener {
            val cartFragment = FoodCartFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.add(R.id.fragment_container, cartFragment)
            transaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

    private fun setupImageSlider() {
        coverViewPager.apply {
            adapter = ImageSliderAdapter()
        }
        indicatorLayout.setupWithViewPager(coverViewPager, true)
    }

    fun addToCart(count: Int) {
        if (count == 0) {
            cartItemCount.visibility = View.GONE
        } else {
            cartItemCount.visibility = View.VISIBLE
        }

        cartItemCount.text = "$count"
        animateCount()
    }

    fun animateCount() {
        val zoomIn = AnimationUtils.getZoomInAnimation(requireContext())
        cartItemCount.startAnimation(zoomIn)
    }

}
