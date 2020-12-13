package co.ansari.dindinnassignment.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "FoodItem")
data class FoodModel(

    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    @Expose
    val id: Long,


    @ColumnInfo(name = "name")
    @SerializedName("name")
    @Expose
    val name: String,

    @ColumnInfo(name = "description")
    @SerializedName("description")
    @Expose
    val description: String,

    @ColumnInfo(name = "detail")
    @SerializedName("detail")
    @Expose
    val detail: String,

    @ColumnInfo(name = "category")
    @SerializedName("category")
    @Expose
    val category: String,

    @ColumnInfo(name = "image")
    @SerializedName("image")
    @Expose
    val image: Int,

    @ColumnInfo(name = "price")
    @SerializedName("price")
    @Expose
    val price: Float,

    @ColumnInfo(name = "currency")
    @SerializedName("currency")
    @Expose
    val currency: String,


    @ColumnInfo(name = "addedToCart")
    @SerializedName("addedToCart")
    @Expose
    val addedToCart: Boolean,

    @ColumnInfo(name = "itemCount")
    @SerializedName("itemCount")
    @Expose
    val itemCount: Int = 0

)