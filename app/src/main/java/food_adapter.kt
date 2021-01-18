import `in`.starbow.fitindia.R
import `in`.starbow.fitindia.model
import android.content.Context
import android.view.Display
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class food_adapter(var mCtx:Context,var resources:Int,var items:List<model>):ArrayAdapter<model>(mCtx,resources,items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater:LayoutInflater = LayoutInflater.from(mCtx)
       val view :View = layoutInflater.inflate(resources,null)
        val imageView:ImageView =view.findViewById(R.id.food_image)
        val titleTextView:TextView = view.findViewById(R.id.foodNameText)
        val despTextView:TextView = view.findViewById(R.id.foodDescription)

        var mItem:model = items[position]
        imageView.setImageDrawable(mCtx.resources.getDrawable(mItem.img))
        titleTextView.text=mItem.title
        despTextView.text = mItem.description

         return view
    }

}