import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class DieticianActivity : AppCompatActivity() {
    private lateinit var weightEditText: EditText
    private lateinit var heightEditText: EditText
    private lateinit var ageEditText: EditText
    private lateinit var genderSpinner: Spinner
    private lateinit var activitySpinner: Spinner
    private lateinit var submitButton: Button
    private lateinit var resultTextView: TextView

    private val protein = arrayOf(
        "Yogurt(1 cup)",
        "Cooked meat(3 Oz)",
        "Cooked fish(4 Oz)",
        "1 whole egg + 4 egg whites",
        "Tofu(5 Oz)"
    )
    private val fruit = arrayOf(
        "Berries(80 Oz)",
        "Apple",
        "Orange",
        "Banana",
        "Dried Fruits(Handfull)",
        "Fruit Juice(125ml)"
    )
    private val vegetable = arrayOf("Any vegetable(80g)")
    private val grains = arrayOf(
        "Cooked Grain(150g)",
        "Whole Grain Bread(1 slice)",
        "Half Large Potato(75g)",
        "Oats(250g)",
        "2 corn tortillas"
    )
    private val ps = arrayOf(
        "Soy nuts(i Oz)",
        "Low fat milk(250ml)",
        "Hummus(4 Tbsp)",
        "Cottage cheese (125g)",
        "Flavored yogurt(125g)"
    )
    private val tasteEn = arrayOf(
        "2 TSP (10 ml) olive oil",
        "2 TBSP (30g) reduced-calorie salad dressing",
        "1/4 medium avocado",
        "Small handful of nuts",
        "1/2 ounce grated Parmesan cheese",
        "1 TBSP (20g) jam, jelly, honey, syrup, sugar"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dietician)

        weightEditText = findViewById(R.id.weightEditText)
        heightEditText = findViewById(R.id.heightEditText)
        ageEditText = findViewById(R.id.ageEditText)
        genderSpinner = findViewById(R.id.genderSpinner)
        activitySpinner = findViewById(R.id.activitySpinner)
        submitButton = findViewById(R.id.submitButton)
        resultTextView = findViewById(R.id.resultTextView)

        val genderAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            arrayOf("Male", "Female")
        )
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        genderSpinner.adapter = genderAdapter

        val activityAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            arrayOf(
                "Sedentary (little or no exercise)",
                "Lightly active (1-3 days/week)",
                "Moderately active (3-5 days/week)",
                "Very active (6-7 days/week)",
                "Super active (twice/day)"
            )
        )
        activityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        activitySpinner.adapter = activityAdapter

        submitButton.setOnClickListener { calculateAndDisplayMealPlan() }
    }

    private fun calculateAndDisplayMealPlan() {
        val weight = weightEditText.text.toString().toFloat()
        val height = heightEditText.text.toString().toFloat()
        val ageText = ageEditText.text.toString()

        if (ageText.isNotEmpty()) {
            val age = ageText.toInt()
            if (age >= 18) {
                val gender = genderSpinner.selectedItem.toString()
                val activityLevel = activitySpinner.selectedItem.toString()

                val basalMetabolicRate = calculateBMR(weight, height, age, gender)
                val calorieIntake = calculateCalorieIntake(basalMetabolicRate, activityLevel)

                val mealPlan = generateMealPlan()

                val result = "Calorie Intake: $calorieIntake\n\nMeal Plan:\n$mealPlan"
                resultTextView.text = result
            } else {
                resultTextView.text = "Inappropriate age. Please enter age 18 or above."
            }
        } else {
            resultTextView.text = "Please enter your age."
        }
    }

    private fun calculateBMR(weight: Float, height: Float, age: Int, gender: String): Float {
        return if (gender == "Male") {
            66 + (6.23f * weight) + (12.7f * height) - (6.8f * age)
        } else {
            655 + (4.35f * weight) + (4.7f * height) - (4.7f * age)
        }
    }

    private fun calculateCalorieIntake(basalMetabolicRate: Float, activityLevel: String): Float {
        return when (activityLevel) {
            "Sedentary (little or no exercise)" -> basalMetabolicRate * 1.2f
            "Lightly active (1-3 days/week)" -> basalMetabolicRate * 1.375f
            "Moderately active (3-5 days/week)" -> basalMetabolicRate * 1.55f
            "Very active (6-7 days/week)" -> basalMetabolicRate * 1.725f
            "Super active (twice/day)" -> basalMetabolicRate * 1.9f
            else -> basalMetabolicRate
        }
    }

    private fun generateMealPlan(): String {
        val random = Random(System.currentTimeMillis())

        val proteinIndex = random.nextInt(protein.size)
        val fruitIndex = random.nextInt(fruit.size)
        val vegetableIndex = random.nextInt(vegetable.size)
        val grainsIndex = random.nextInt(grains.size)
        val psIndex = random.nextInt(ps.size)
        val tasteEnIndex = random.nextInt(tasteEn.size)

        val mealPlan = StringBuilder()
        mealPlan.append("Protein: ${protein[proteinIndex]}\n")
        mealPlan.append("Fruit: ${fruit[fruitIndex]}\n")
        mealPlan.append("Vegetable: ${vegetable[vegetableIndex]}\n")
        mealPlan.append("Grains: ${grains[grainsIndex]}\n")
        mealPlan.append("Plant Source Protein: ${ps[psIndex]}\n")
        mealPlan.append("Taste Enhancer: ${tasteEn[tasteEnIndex]}\n")

        return mealPlan.toString()
    }
}
