package kot.helena.chancebalancer.utils

import android.os.Build
import android.support.annotation.ColorRes
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager

object AppCompatExtension {

    fun AppCompatActivity.hideActionBar() {
        if (this.supportActionBar != null) {
            this.supportActionBar!!.hide()
        }
    }

    fun AppCompatActivity.setStatusBarColor(@ColorRes c: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = resources.getColor(c)
        }
    }
}