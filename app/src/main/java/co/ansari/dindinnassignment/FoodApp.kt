package co.ansari.dindinnassignment

import android.app.Application
import androidx.multidex.MultiDexApplication
import co.ansari.dindinnassignment.data.repo.FoodRepo

class FoodApp: MultiDexApplication() {
    val foodRepo by lazy {
        FoodRepo(this)
    }
}