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
        list.add(model("Apple", "Apple : 114 cal", R.drawable.apple))
        list.add(model("Bread", "4-bread Slice :65 cal", R.drawable.baguette))
        list.add(model("Cake", "1- Cake Slice : 132 cal", R.drawable.cake))
        list.add(model("Muffin", "muffin : 47 cal", R.drawable.cupcake))
        list.add(model("Carrot", " carrot: 30 cal", R.drawable.carrot))
        list.add(model("Chicken", " chicken : 220 cal", R.drawable.chicken_leg))
        list.add(model("Chocolate", "Chocolate bar : 200 cal", R.drawable.chocolate))
        list.add(model("Donut", "donut : 110 cal", R.drawable.donut))
        list.add(model("Laddu", "Laddu : 170  cal", R.drawable.fazuelos))
        list.add(model("French fries", "French Fries medium : 110 cal", R.drawable.french_fries))
        list.add(model("Orange", " Orange : 52 cal", R.drawable.fruit))
        list.add(model("Hot dog", "Hot Dog: 95  cal", R.drawable.hot_dog))
        list.add(model("Rolls", " Roll : 68 cal", R.drawable.kebab))
        list.add(model("Potato Chips", "Potato chips : 155 cal", R.drawable.potato_chips))
        list.add(model("Sundae", "Sundae : 110 cal", R.drawable.sundae))
        list.add(model("Ice Cream", " Ice Cream : 100 cal", R.drawable.parfait))
        list.add(model("Strawberry", "Strawberry : 110 cal", R.drawable.strawberry))
        list.add(model("meat", "250 g red meat : 300 cal", R.drawable.meat))
        list.add(model("Khichidi", "Khichidi : 70 cal", R.drawable.vegan_food))


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
            if (position == 10) {
                value.setText((value.text.toString().toInt() + 114).toString())
            }
            if (position == 11) {
                value.setText((value.text.toString().toInt() + 65).toString())
            }
            if (position == 12) {
                value.setText((value.text.toString().toInt() + 132).toString())
            }
            if (position == 13) {
                value.setText((value.text.toString().toInt() + 47).toString())
            }
            if (position == 14) {
                value.setText((value.text.toString().toInt() + 30).toString())
            }
            if (position == 15) {
                value.setText((value.text.toString().toInt() + 220).toString())
            }
            if (position == 16) {
                value.setText((value.text.toString().toInt() + 200).toString())
            }
            if (position == 17) {
                value.setText((value.text.toString().toInt() + 110).toString())
            }
            if (position == 18) {
                value.setText((value.text.toString().toInt() + 170).toString())
            }
            if (position == 19) {
                value.setText((value.text.toString().toInt() + 110).toString())
            }
            if (position == 20) {
                value.setText((value.text.toString().toInt() + 52).toString())
            }
            if (position == 21) {
                value.setText((value.text.toString().toInt() + 95).toString())
            }
            if (position == 22) {
                value.setText((value.text.toString().toInt() + 68).toString())
            }
            if (position == 23) {
            value.setText((value.text.toString().toInt() + 115).toString())
        }
            if (position == 24) {
                value.setText((value.text.toString().toInt() + 110).toString())
            }
            if (position == 25) {
                value.setText((value.text.toString().toInt() + 100).toString())
            }
            if (position == 26) {
                value.setText((value.text.toString().toInt() + 110).toString())
            }
            if (position == 27) {
                value.setText((value.text.toString().toInt() + 300).toString())
            }
            if (position == 28) {
                value.setText((value.text.toString().toInt() + 70).toString())
            }
        }
        reset.setOnClickListener {
            value.setText("0")
        }
    }
}
