package `in`.starbow.fitindia

import `in`.starbow.fitindia.service.StepDetectorService
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_dashboard.*


import kotlinx.android.synthetic.main.activity_main.*


class dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        bmi.setOnClickListener {
            Toast.makeText(applicationContext, "BMI", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, `in`.starbow.fitindia.bmi::class.java)
            startActivity(intent);
        }

        activity_dietician.setOnClickListener {
            Toast.makeText(applicationContext, "Pedometer", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, peodmeter::class.java)
            startActivity(intent);
        }
      image_selector.setOnClickListener{
          val intent = Intent(this,FoodSelectActivity::class.java)
          startActivity(intent)
      }

    }
}
