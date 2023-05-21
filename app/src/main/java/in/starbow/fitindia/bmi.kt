package `in`.starbow.fitindia

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.Slider

class bmi : AppCompatActivity() {
    lateinit var slider: EditText
    lateinit var slider1: EditText
    lateinit var fab: FloatingActionButton
    lateinit var card: CardView
    lateinit var bmiText: TextView
    lateinit var disclaimer: TextView
    lateinit var label: TextView
    lateinit var res: TextView
    lateinit var feedback: TextView
    lateinit var maleButton: Button
    lateinit var femaleButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)
        if (supportActionBar != null) supportActionBar?.hide()
        slider = findViewById(R.id.slider1)
        slider1 = findViewById(R.id.slider2)
        fab = findViewById(R.id.floatingActionButton)
        card = findViewById(R.id.cardView)
        bmiText = findViewById(R.id.bmitext)
        disclaimer = findViewById(R.id.disclamer)
        res = findViewById(R.id.Result)
        label = findViewById(R.id.yourBmi)
        feedback = findViewById(R.id.Feedback)
        maleButton = findViewById(R.id.male)
        femaleButton = findViewById(R.id.female)
        maleButton.setOnClickListener {
            maleButton.setBackgroundColor(Color.parseColor("#FEA595"))
            femaleButton.setBackgroundColor(Color.WHITE)
        }
        femaleButton.setOnClickListener {
            femaleButton.setBackgroundColor(Color.parseColor("#FEA595"))
            maleButton.setBackgroundColor(Color.WHITE)
        }
        fab.setOnClickListener {
            cardChanger();
        }
    }

    private fun cardChanger() {
        bmiText.visibility = View.GONE
        disclaimer.visibility = View.GONE
        res.visibility = View.VISIBLE
        feedback.visibility = View.VISIBLE
        label.visibility = View.VISIBLE
        val height: Float = slider.text.toString().toFloat()
        val weight: Float = slider1.text.toString().toFloat()
        val ans: Float = (weight) / ((height / 100) * (height / 100))
        val BMI: Double = Math.round(ans * 10.0) / 10.0
        res.text = BMI.toString()
        if (BMI < 18.5) {
            feedback.text = getString(R.string.under)
            feedback.setTextColor(Color.RED)
        } else if (BMI >= 25&&BMI<35) {
            feedback.text = getString(R.string.over)
            feedback.setTextColor(Color.RED)
        } 
        else if(BMI>=35)
        {
           feedback.text = getString(R.string.obese)
            feedback.setTextColor(Color.RED) 
        } 
        else {
            feedback.text = getString(R.string.you_have_a_normal_body_weight_enjoy)
            feedback.setTextColor(Color.GREEN)
        }
    }
}
