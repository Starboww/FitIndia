package `in`.starbow.fitindia

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import food_adapter
import kotlinx.android.synthetic.main.food_select.*

class FoodSelectActivity : AppCompatActivity() {
    private val cartList = mutableListOf<model>()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.food_select)
        val listview = findViewById<RecyclerView>(R.id.listView)
        val list = mutableListOf<model>()
        val calorieText = findViewById<TextView>(R.id.calorieText)
        val reset = findViewById<Button>(R.id.reset)
        val value = findViewById<TextView>(R.id.valueCal)

        list.add(model("Rice", "Plain Rice : 200 cal", R.drawable.rice_bowl))
        list.add(model("Chapati", "2 Plain chapati : 100 cal", R.drawable.roti_canai))
        list.add(model("Dal", "Plain dal : 50 cal", R.drawable.dal2))
        list.add(model("Salad", "Mix salad : 50 cal", R.drawable.salad))
        list.add(model("Noodles", "Noodles : 140 cal", R.drawable.noodles))
        list.add(model("Burger", "Burger: 200 cal", R.drawable.hamburger))
        list.add(model("Pizza", "Pizza : 250 cal", R.drawable.pizza))
        list.add(model("Cold drink", "Carbonated cold drink :140 cal", R.drawable.soft_drink))
        list.add(model("Apple", "Apple : 114 cal", R.drawable.apple))
        list.add(model("Bread", "4-bread Slice :65 cal", R.drawable.baguette))
        list.add(model("Cake", "1- Cake Slice : 132 cal", R.drawable.cake))
        list.add(model("Muffin", "Muffin : 47 cal", R.drawable.cupcake))
        list.add(model("Carrot", "Carrot: 30 cal", R.drawable.carrot))
        list.add(model("Chicken", "Chicken : 220 cal", R.drawable.chicken_leg))
        list.add(model("Chocolate", "Chocolate bar : 200 cal", R.drawable.chocolate))
        list.add(model("Donut", "Donut : 110 cal", R.drawable.donut))
        list.add(model("Laddu", "Laddu : 170  cal", R.drawable.fazuelos))
        list.add(model("French fries", "French Fries medium : 110 cal", R.drawable.french_fries))
        list.add(model("Orange", "Orange : 52 cal", R.drawable.fruit))
        list.add(model("Hot dog", "Hot Dog: 95  cal", R.drawable.hot_dog))
        list.add(model("Rolls", "Roll : 68 cal", R.drawable.kebab))
        list.add(model("Potato Chips", "Potato chips : 155 cal", R.drawable.potato_chips))
        list.add(model("Sundae", "Sundae : 110 cal", R.drawable.sundae))
        list.add(model("Ice Cream", "Ice Cream : 100 cal", R.drawable.parfait))
        list.add(model("Strawberry", "Strawberry : 110 cal", R.drawable.strawberry))
        list.add(model("Meat", "250 g red meat : 300 cal", R.drawable.meat))
        list.add(model("Khichidi", "Khichidi : 70 cal", R.drawable.vegan_food))

        val cartRecyclerView = findViewById<RecyclerView>(R.id.cartRecyclerView)
        val cartAdapter = food_adapter(this, R.layout.row, cartList, list)
        cartRecyclerView.adapter = cartAdapter

        listview.adapter = food_adapter(this, R.layout.row, list, cartList)
        listView.setOnItemClickListener { parent: AdapterView<*>, view: View, position: Int, id: Long ->
            val selectedItem = list[position]
            cartList.add(selectedItem)
            cartAdapter.notifyDataSetChanged()

            val calorieValue = selectedItem.calorie.split(" ")[0].toInt()
            value.text = (value.text.toString().toInt() + calorieValue).toString()
        }

        reset.setOnClickListener {
            value.text = "0"
            cartList.clear()
            cartAdapter.notifyDataSetChanged()
        }
    }

    private fun removeItemFromCart(position: Int) {
        val removedItem = cartList.removeAt(position)
        val calorieValue = removedItem.calorie.split(" ")[0].toInt()
        valueCal.text = (valueCal.text.toString().toInt() - calorieValue).toString()
        cartAdapter.notifyDataSetChanged()
    }
}

class food_adapter(
    private val context: Context,
    private val resource: Int,
    private val cartList: MutableList<model>,
    private val itemList: List<model>
) : ArrayAdapter<model>(context, resource, itemList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(resource, null)

        val name = view.findViewById<TextView>(R.id.name)
        val calorie = view.findViewById<TextView>(R.id.calorie)
        val image = view.findViewById<ImageView>(R.id.image)
        val removeButton = view.findViewById<Button>(R.id.removeButton)

        val item = itemList[position]
        name.text = item.name
        calorie.text = item.calorie
        image.setImageResource(item.image)

        removeButton.setOnClickListener {
            (context as FoodSelectActivity).removeItemFromCart(position)
        }

        return view
    }
}
