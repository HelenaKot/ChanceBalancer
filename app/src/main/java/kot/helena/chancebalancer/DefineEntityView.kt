package kot.helena.chancebalancer

import android.content.Context
import android.support.v7.widget.CardView
import android.util.AttributeSet
import android.view.LayoutInflater

class DefineEntityView @JvmOverloads constructor(context: Context,
                                                 attrs: AttributeSet? = null,
                                                 defStyle: Int = 0)
    : CardView(context, attrs, defStyle) {

    init {
        LayoutInflater.from(context).inflate(R.layout.define_entity_view, this, true)
    }

}