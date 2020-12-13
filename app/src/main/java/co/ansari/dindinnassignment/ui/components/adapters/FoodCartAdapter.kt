package co.ansari.dindinnassignment.ui.components.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import co.ansari.dindinnassignment.R
import co.ansari.dindinnassignment.data.model.FoodModel
import co.ansari.dindinnassignment.utils.listeners.FoodCartListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_food.view.*
import kotlinx.android.synthetic.main.item_food_cart.view.*
import kotlinx.android.synthetic.main.item_food_cart.view.imgFood
import kotlinx.android.synthetic.main.item_food_cart.view.textFoodTitle

class FoodCartAdapter(private val listener: FoodCartListener) :
    ListAdapter<FoodModel, FoodCartAdapter.FoodCartViewHolder>(FoodCartDiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodCartViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return FoodCartViewHolder(inflater.inflate(R.layout.item_food_cart, parent, false))
    }

    override fun onBindViewHolder(holder: FoodCartViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }


    class FoodCartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(foodModel: FoodModel, listener: FoodCartListener) {
            itemView.textFoodTitle.text = foodModel.name

            // Set image from the resource
            itemView.imgFood.setImageResource(foodModel.image)

            /*
            In real scenarios, image would be
            the string against which
            Picasso fetches the image and show it.
            if (foodModel.image != "") {
                Picasso
                    .get()
                    .load(foodModel.image)
                    .into(itemView.imgFood)
            } else {
                itemView.imgFood.setImageResource(R.drawable.default_food_img)
            }
             */

            itemView.imgRemoveFromCart.setOnClickListener {
                listener.removeFromCart(foodModel)
            }
        }

    }

    class FoodCartDiffUtil : DiffUtil.ItemCallback<FoodModel>() {

        override fun areItemsTheSame(oldItem: FoodModel, newItem: FoodModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: FoodModel, newItem: FoodModel): Boolean {
            return areItemsTheSame(oldItem, newItem)
        }

    }
}