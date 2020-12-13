package co.ansari.dindinnassignment.utils

import android.content.Context
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import co.ansari.dindinnassignment.R

class AnimationUtils {

    companion object {
        fun getZoomInAnimation(context: Context): Animation {
            return AnimationUtils.loadAnimation(context, R.anim.zoom_in)
        }

        fun getZoomOutAnimation(context: Context): Animation {
            return AnimationUtils.loadAnimation(context, R.anim.zoom_out)
        }
    }

}