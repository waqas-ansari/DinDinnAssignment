package co.ansari.dindinnassignment.ui.components.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import co.ansari.dindinnassignment.R
import kotlinx.android.synthetic.main.image_view.view.*

val COVER_IMAGE = listOf(
    R.drawable.cover_image_1,
    R.drawable.cover_image_2,
    R.drawable.cover_image_3
)

class ImageSliderAdapter : PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return COVER_IMAGE.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(container.context)
        val view = inflater.inflate(R.layout.image_view, container, false)

        view.image.setImageResource(COVER_IMAGE[position])
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}