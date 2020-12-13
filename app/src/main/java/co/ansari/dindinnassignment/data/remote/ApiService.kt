package co.ansari.dindinnassignment.data.remote

import co.ansari.dindinnassignment.data.model.FoodModel
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("/fetch-food-items")
    fun fetchFoodItems(): Observable<List<FoodModel>>

    companion object {
        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(ApiConstants.BASE_URL)
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}