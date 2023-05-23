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
    private lateinit var listview: ListView
    private lateinit var cartRecyclerView: RecyclerView
    private lateinit var searchEditText: EditText
    private lateinit var cartItems: MutableList<model>
    private lateinit var cartAdapter: food_adapter

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.food_select)
        listview = findViewById<ListView>(R.id.listView)
        cartRecyclerView = findViewById<RecyclerView>(R.id.cartRecyclerView)
        searchEditText = findViewById<EditText>(R.id.searchEditText)
        
        cartItems = mutableListOf<model>()
        cartAdapter = food_adapter(this, R.layout.row, cartItems)
        cartRecyclerView.adapter = cartAdapter
        
        val list = mutableListOf<model>()
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
        list.add(model("Tomato","Average sized Tomato : 22 cal",R.drawable.tomato))
        list.add(model("Potato", "Medium sized Potato : 110 cal", R.drawable.potato))
        list.add(model("Lady Finger or Okra", "100 g : 33 cal", R.drawable.ladyfinger))
        list.add(model("Capsicum", "100 g : 40 cal", R.drawable.capsicum))
        list.add(model("Eggs", "Small egg 48 g : 54 cal", R.drawable.eggs))
        list.add(model("Grapes", "100 g : 67 cal", R.drawable.grapes))
        list.add(model("Guava", "100 g : 68 cal", R.drawable.guava))
        list.add(model("Green Leafy Vegetables", "100 g : 23", R.drawable.greenleafy))
        list.add(model("Dosa", "Medium Dosa : 168 cal", R.drawable.dosa))
        list.add(model("Idly", "1 idli : 58 cal", R.drawable.idly))
        list.add(model("WaterMelon", "100 g : 30 cal", R.drawable.watermelon))
        list.add(model("Vada", "1 medu vada : 73 cal", R.drawable.vada))
        list.add(model("Chikoo", "100 g : 83 cal", R.drawable.sapota))
        list.add(model("Poori", "1 poori : 141 cal", R.drawable.puri))
        list.add(model("Pineapple", "100 g : 50 cal", R.drawable.pineapple))
        list.add(model("Papaya", "100 g : 32 cal", R.drawable.papaya))
        list.add(model("Muskmelon", "100 g : 34 cal", R.drawable.muskmelon))
        list.add(model("Mango", "100 g : 60 cal", R.drawable.mango))
        list.add(model("Lychee", "100 g : 66 cal", R.drawable.lychee))
        list.add(model("Custard Apple", "100 g : 94 cal", R.drawable.custardapple))
        list.add(model("Cucumber", "Medium sized cucumber : 30 cal", R.drawable.cucumber))
        list.add(model("Cherries", "100 g : 50 cal", R.drawable.cherries))
        list.add(model("Berries", "100 g : 57 cal", R.drawable.berries))
        list.add(model("Banana", "100 g : 89 cal", R.drawable.banana))
        list.add(model("Broccoli", "100 g : 34 cal", R.drawable.broccoli))
        list.add(model("Cabbage", "100 g : 25 cal", R.drawable.cabbage))
        list.add(model("Cauliflower", "100 g : 25 cal", R.drawable.cauliflower))
        list.add(model("Beetroot", "50 g : 22 cal", R.drawable.beetroot))
        list.add(model("Drumsticks or Moringa", "100g : 25 cal", R.drawable.drumstick))
        list.add(model("Avocado", "100g : 160 cal", R.drawable.avacado))
        list.add(model("PaniPuri", "1 plate of panipuri : 329 cal", R.drawable.panipuri))
        list.add(model("Brinjal", "one cup of cubed raw brinjal : 24 cal", R.drawable.brinjal))
        list.add(model("Vadapav", "Single slice of vadapav : 304 cal", R.drawable.vadapav))
        
        listview.adapter = food_adapter(this, R.layout.row, list)
        listView.setOnItemClickListener { parent: AdapterView<*>, view: View, position: Int, id: Long ->
            val selectedItem = list[position]
            cartItems.add(selectedItem)
            cartAdapter.notifyDataSetChanged()
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
                value.setText((value.text.toString().toInt() + 114).toString())
            }
            if (position == 9) {
                value.setText((value.text.toString().toInt() + 65).toString())
            }
            if (position == 10) {
                value.setText((value.text.toString().toInt() + 132).toString())
            }
            if (position == 11) {
                value.setText((value.text.toString().toInt() + 47).toString())
            }
            if (position == 12) {
                value.setText((value.text.toString().toInt() + 30).toString())
            }
            if (position == 13) {
                value.setText((value.text.toString().toInt() + 220).toString())
            }
            if (position == 14) {
                value.setText((value.text.toString().toInt() + 200).toString())
            }
            if (position == 15) {
                value.setText((value.text.toString().toInt() + 110).toString())
            }
            if (position == 16) {
                value.setText((value.text.toString().toInt() + 170).toString())
            }
            if (position == 17) {
                value.setText((value.text.toString().toInt() + 110).toString())
            }
            if (position == 18) {
                value.setText((value.text.toString().toInt() + 52).toString())
            }
            if (position == 19) {
                value.setText((value.text.toString().toInt() + 95).toString())
            }
            if (position == 20) {
                value.setText((value.text.toString().toInt() + 68).toString())
            }
            if (position == 21) {
                value.setText((value.text.toString().toInt() + 155).toString())
            }
            if (position == 22) {
                value.setText((value.text.toString().toInt() + 110).toString())
            }
            if (position == 23) {
            value.setText((value.text.toString().toInt() + 100).toString())
        }
            if (position == 24) {
                value.setText((value.text.toString().toInt() + 110).toString())
            }
            if (position == 25) {
                value.setText((value.text.toString().toInt() + 300).toString())
            }
            if (position == 26) {
                value.setText((value.text.toString().toInt() + 70).toString())
            }
            if (position == 27) {
                value.setText((value.text.toString().toInt() + 22).toString())
            }
            if (position == 28) {
                value.setText((value.text.toString().toInt() + 110).toString())
            }
            if(position == 29)
            {
                value.setText((value.text.toString().toInt()+ 33).toString())
            }
            if (position == 30) {
                value.setText((value.text.toString().toInt() + 40).toString())
            }
            if (position == 31) {
                value.setText((value.text.toString().toInt() + 48).toString())
            }
            if (position == 32) {
                value.setText((value.text.toString().toInt() + 67).toString())
            }
            if (position == 33) {
                value.setText((value.text.toString().toInt() + 68).toString())
            }
            if (position == 34) {
                value.setText((value.text.toString().toInt() + 23).toString())
            }
            if (position == 35) {
                value.setText((value.text.toString().toInt() + 168).toString())
            }
            if (position == 36) {
                value.setText((value.text.toString().toInt() + 58).toString())
            }
            if (position == 37) {
                value.setText((value.text.toString().toInt() + 30).toString())
            }
            if (position == 38) {
                value.setText((value.text.toString().toInt() + 73).toString())
            }
            if (position == 39) {
                value.setText((value.text.toString().toInt() + 83).toString())
            }
            if (position == 40) {
                value.setText((value.text.toString().toInt() + 141).toString())
            }
            if (position == 41) {
                value.setText((value.text.toString().toInt() + 50).toString())
            }
            if (position == 42) {
                value.setText((value.text.toString().toInt() + 32).toString())
            }
            if (position == 43) {
                value.setText((value.text.toString().toInt() + 34).toString())
            }
            if (position == 44) {
                value.setText((value.text.toString().toInt() + 60).toString())
            }
            if (position == 45) {
                value.setText((value.text.toString().toInt() + 66).toString())
            }
            if (position == 46) {
                value.setText((value.text.toString().toInt() + 94).toString())
            }
            if (position == 47) {
                value.setText((value.text.toString().toInt() + 30).toString())
            }
            if (position == 48) {
                value.setText((value.text.toString().toInt() + 50).toString())
            }
            if (position == 49) {
                value.setText((value.text.toString().toInt() + 57).toString())
            }
            if (position == 50) {
                value.setText((value.text.toString().toInt() + 89).toString())
            }
            if (position == 51) {
                value.setText((value.text.toString().toInt() + 34).toString())
            }
            if (position == 52) {
                value.setText((value.text.toString().toInt() + 25).toString())
            }
            if (position == 53) {
                value.setText((value.text.toString().toInt() + 25).toString())
            }
            if (position == 54) {
                value.setText((value.text.toString().toInt() + 22).toString())
            }
            if (position == 55) {
                value.setText((value.text.toString().toInt() + 25).toString())
            }
            if (position == 56) {
                value.setText((value.text.toString().toInt() + 160).toString())
            }
            if (position == 57) {
                value.setText((value.text.toString().toInt() + 329).toString())
            }
            if (position == 58) {
                value.setText((value.text.toString().toInt() + 24).toString())
            }
            if (position == 59) {
                value.setText((value.text.toString().toInt() + 304).toString())
            }
        }
        reset.setOnClickListener {
            cartItems.clear()
            cartAdapter.notifyDataSetChanged()
            value.setText("0")
        }
        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Filter the list based on the search query
                val query = s.toString().toLowerCase()
                val filteredList = list.filter { item ->
                    item.name.toLowerCase().contains(query) || item.description.toLowerCase().contains(query)
                }
                listview.adapter = food_adapter(this@FoodSelectActivity, R.layout.row, filteredList.toMutableList())
            }
        })
        
    }
}
