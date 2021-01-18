package `in`.starbow.fitindia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import food_adapter
import kotlinx.android.synthetic.main.food_select.*

class FoodSelectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.food_select)
       var listview = findViewById<ListView>(R.id.listView)
        var list = mutableListOf<model>()
        list.add(model("Rice","Plain Rice : 200 cal",R.drawable. rice_bowl))
        list.add(model("Chapati"," 2 Plain chapati : 100 cal",R.drawable.roti_canai ))
        list.add(model("Dal","Plain dal : 50 cal",R.drawable.dal2))
        list.add(model("Salad","Mix salad : 50 cal",R.drawable.salad ))
        list.add(model("Noodles","Noodles : 140 cal",R.drawable.noodles))
        list.add(model("Burger","Burger: 200 cal",R.drawable.hamburger))
        list.add(model("Pizza"," Pizza : 250 cal",R.drawable.pizza ))
        list.add(model("cold drink","Carbonated cold drink :140 cal",R.drawable.soft_drink ))
        list.add(model("eggs","2-3 eggs : 110 cal",R.drawable.egg ))
        listview.adapter = food_adapter(this,R.layout.row,list)
        listView.setOnItemClickListener{
                parent:AdapterView<*>,view:View,position:Int,id:Long->
            if(position==0)
            {
                Toast.makeText(this,"position 0",Toast.LENGTH_SHORT).show()

            }
             if(position==1)
            {
                Toast.makeText(this,"position 1",Toast.LENGTH_SHORT).show()
            }
            if(position==2)
            {
                Toast.makeText(this,"position 2",Toast.LENGTH_SHORT).show()

            }
            if(position==3)
            {
                Toast.makeText(this,"position 3",Toast.LENGTH_SHORT).show()
            }
            if(position==4)
            {
                Toast.makeText(this,"position 4",Toast.LENGTH_SHORT).show()
            }

            if(position==5)
            {
                Toast.makeText(this,"position 5",Toast.LENGTH_SHORT).show()
            }
            if(position==6)
            {
                Toast.makeText(this,"position 6",Toast.LENGTH_SHORT).show()
            }
            if(position==7)
            {
                Toast.makeText(this,"position 7",Toast.LENGTH_SHORT).show()
            }
            if(position==8)
            {
                Toast.makeText(this,"position 8",Toast.LENGTH_SHORT).show()
            }
            if(position==9)
            {
                Toast.makeText(this,"position 9",Toast.LENGTH_SHORT).show()
            }

        }
    }
}