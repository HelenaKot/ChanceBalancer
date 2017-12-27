package kot.helena.chancebalancer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_define_entity.*

class DefineEntityActivity : AppCompatActivity() {
    private val container: LinearLayout by lazy { entity_container }
    private val button: Button by lazy { add_entity_button }
    private val finishButton: Button by lazy { finish_button }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_define_entity)
        addEntityView()
        button.setOnClickListener({ addEntityView() })
        finishButton.setOnClickListener({ collectEntities() })
    }

    private fun addEntityView() {
        container.addView(DefineEntityView(this))
    }

    private fun collectEntities(): List<EntityModel> {
        val outputList: ArrayList<EntityModel> = ArrayList()
        (0 until container.childCount).mapTo(outputList) { (container.getChildAt(it) as DefineEntityView).model }
        return outputList
    }

}
