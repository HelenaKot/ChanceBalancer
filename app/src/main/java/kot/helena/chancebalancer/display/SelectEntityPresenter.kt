package kot.helena.chancebalancer.display

import android.view.MenuItem
import kot.helena.chancebalancer.R

class SelectEntityPresenter {
    var ui: SelectEntityUI? = null

    fun menuOptionSelected(item: MenuItem): Boolean {
        if (ui == null) {
            return false
        }
        when (item.itemId) {
            R.id.action_new -> ui!!.startDefineEntityActivity()
            R.id.action_wipe -> ui!!.wipeData()
        }
        return true
    }

    interface SelectEntityUI {
        fun startDefineEntityActivity()
        fun wipeData()
    }

}