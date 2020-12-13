package co.ansari.dindinnassignment.ui.components.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import co.ansari.dindinnassignment.ui.main.food.FoodListFragment

private val TAB_TITLES = arrayOf(
    "Pizza",
    "Sushi",
    "Drink"
)

class FoodSectionPagerAdapter(fm: FragmentManager)
    : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    override fun getItem(position: Int): Fragment {
        return FoodListFragment.newInstance(TAB_TITLES[position])
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return TAB_TITLES[position]
    }

    override fun getCount(): Int {
        return TAB_TITLES.size
    }
}