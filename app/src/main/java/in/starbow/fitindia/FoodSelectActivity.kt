package `in`.starbow.fitindia

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import food_adapter
import kotlinx.android.synthetic.main.food_select.*

class FoodSelectActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.food_select)
        var listview = findViewById<ListView>(R.id.listView)
        var list = mutableListOf<model>()
        var calorieText = findViewById<TextView>(R.id.calorieText)
        val reset = findViewById<Button>(R.id.reset)
        val value = findViewById<TextView>(R.id.valueCal)
        list.add(model("Rice", "Plain Rice : 200 cal", R.drawable.rice_bowl))
        list.add(model("Chapati", " 2 Plain chapati : 100 cal", R.drawable.roti_canai))
        list.add(model("Dal", "Plain dal : 50 cal", R.drawable.dal2))
        list.add(model("Salad", "Mix salad : 50 cal", R.drawable.salad))
        list.add(model("Noodles", "Noodles : 140 cal", R.drawable.noodles))
        list.add(model("Burger", "Burger: 200 cal", R.drawable.hamburger))
        list.add(model("Pizza", " Pizza : 250 cal", R.drawable.pizza))
        list.add(model("cold drink", "Carbonated cold drink :140 cal", R.drawable.soft_drink))
        list.add(model("eggs", "2-3 eggs : 110 cal", R.drawable.egg))
        listview.adapter = food_adapter(this, R.layout.row, list)
        listView.setOnItemClickListener { parent: AdapterView<*>, view: View, position: Int, id: Long ->
            if (position == 0) {
                value.setText((value.text.toString().toInt() + 200).toString())
            }
            if (position == 1) {
                value.setText((value.text.toString().toInt() + 100).toString())
            }
            if (position == 2) {
                value.setText((value.text.toString().toInt() + 50).toString())
            }
            if (position == 3) {
                value.setText((value.text.toString().toInt() + 50).toString())
            }
            if (position == 4) {
                value.setText((value.text.toString().toInt() + 140).toString())
            }

            if (position == 5) {
                value.setText((value.text.toString().toInt() + 200).toString())
            }
            if (position == 6) {
                value.setText((value.text.toString().toInt() + 250).toString())
            }
            if (position == 7) {
                value.setText((value.text.toString().toInt() + 140).toString())
            }
            if (position == 8) {
                value.setText((value.text.toString().toInt() + 110).toString())
            }
            if (position == 9) {
                value.setText((value.text.toString().toInt() + 200).toString())
            }
        }
        reset.setOnClickListener {
            value.setText("0")
        }
    }
}