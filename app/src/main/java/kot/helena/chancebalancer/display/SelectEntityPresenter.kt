package kot.helena.chancebalancer.display

import android.view.MenuItem
import kot.helena.chancebalancer.R

class SelectEntityPresenter {
    private var deleteMode = false
    var ui: SelectEntityUI? = null

    fun menuOptionSelected(item: MenuItem): Boolean {
        if (ui == null) {
            return false
        }
        when (item.itemId) {
            R.id.action_new -> ui!!.startDefineEntityActivity()
            R.id.action_delete -> ui!!.startDeleteMode()
        }
        return true
    }

    interface SelectEntityUI {
        fun startDefineEntityActivity()
        fun startDeleteMode()
    }

}