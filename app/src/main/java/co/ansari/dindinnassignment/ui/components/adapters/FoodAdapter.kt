package co.ansari.dindinnassignment.ui.components.adapters

import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import co.ansari.dindinnassignment.R
import co.ansari.dindinnassignment.data.model.FoodModel
import co.ansari.dindinnassignment.utils.listeners.AddToCartListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_food.view.*

class FoodAdapter(private val cartListener: AddToCartListener):
    ListAdapter<FoodModel, FoodAdapter.FoodViewHolder>(FoodDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return FoodViewHolder(inflater.inflate(R.layout.item_food, parent, false))
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(getItem(position), cartListener)
    }

    class FoodViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(foodModel: FoodModel, cartListener: AddToCartListener) {
            itemView.textFoodTitle.text = foodModel.name
            itemView.textFoodDescription.text = foodModel.description
            itemView.textFoodDetail.text = foodModel.detail

            itemView.btnAddToCart.text = "${foodModel.price} ${foodModel.currency}"
            itemView.btnAddToCart.setOnClickListener {
                showCartAddAnimation()
                cartListener.onAddedToCart(foodModel)
            }

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
        }

        fun showCartAddAnimation() {
            itemView.btnAddToCart.setBackgroundResource(R.drawable.button_focused)

            val originalText = itemView.btnAddToCart.text
            itemView.btnAddToCart.text = "added +1"
            itemView.btnAddToCart.isEnabled = false

            Handler().postDelayed(Runnable {
                itemView.btnAddToCart.text = originalText
                itemView.btnAddToCart.setBackgroundResource(R.drawable.button_unfocused)
                itemView.btnAddToCart.isEnabled = true
            }, 600)
        }

    }

    class FoodDiffUtil: DiffUtil.ItemCallback<FoodModel>() {
        override fun areItemsTheSame(oldItem: FoodModel, newItem: FoodModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: FoodModel, newItem: FoodModel): Boolean {
            return areItemsTheSame(oldItem, newItem)
        }

    }
}