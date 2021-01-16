package `in`.starbow.fitindia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_register_act.*
import java.util.regex.Pattern

class register_act : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_act)
        auth = FirebaseAuth.getInstance()
        signup_to_home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        register_btn.setOnClickListener {
            signupUser()
           // Toast.makeText(this,"Executing",Toast.LENGTH_SHORT).show();
        }


    }
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    private fun signupUser()
    {

        if(registerEmail.text.toString().isEmpty())
        {
            registerEmail.error="Please Enter Email"
            registerEmail.requestFocus()
            return

        }
        if(!Patterns.EMAIL_ADDRESS.matcher(registerEmail.text.toString()).matches())
        {
            registerEmail.error="Please Enter Valid Email"
            registerEmail.requestFocus()
            return

        }
        if(register_passw.text.toString().isEmpty())
        {
            register_passw.error="Please Enter Password"
            register_passw.requestFocus()
            return

        }
        auth.createUserWithEmailAndPassword(registerEmail.text.toString(),register_passw.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("Tag1", "createUserWithEmail:success")
                    Toast.makeText(this, "Authentication Done.",
                        Toast.LENGTH_SHORT).show()

                    val user : FirebaseUser? = auth.currentUser
                    user!!.sendEmailVerification()
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                Log.d("Email Tag", "Email sent.")
                                startActivity(Intent(this,loginPage::class.java))
                                finish()
                            }
                        }
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("Tag2", "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()

                }

                // ...
            }
    }
    fun updateUI(currentUser: FirebaseUser?)
    {

    }

    }

