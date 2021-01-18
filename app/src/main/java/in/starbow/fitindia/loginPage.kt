package `in`.starbow.fitindia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login_page.*
import kotlinx.android.synthetic.main.activity_register_act.*

class loginPage : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)
        auth = FirebaseAuth.getInstance()
        login_back_btn.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java) ;
            startActivity(intent);
        }

        buttonLoginfinal.setOnClickListener {
       //   Toast.makeText(this,"login btn clicked",Toast.LENGTH_SHORT).show()
        doLogin()
        }
        signup_intent_go.setOnClickListener {
            val intent = Intent(this,register_act::class.java)
            startActivity(intent);
        }

    }
    private fun doLogin()
    {
        if(login_email.text.toString().isEmpty())
        {
            login_email.error="Please Enter Email"
            login_email.requestFocus()
            return

        }
        if(!Patterns.EMAIL_ADDRESS.matcher(login_email.text.toString()).matches())
        {
            login_email.error="Please Enter Valid Email"
            login_email.requestFocus()
            return

        }
        if(login_passw.text.toString().isEmpty())
        {
            login_passw.error="Please Enter Password"
            login_passw.requestFocus()
            return

        }
        auth.signInWithEmailAndPassword(login_email.text.toString(), login_passw.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("tag3", "signInWithEmail:success")
                    Toast.makeText(baseContext, "Login Success.",
                        Toast.LENGTH_SHORT).show()
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("TAG4", "signInWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Login failed.",
                        Toast.LENGTH_SHORT).show()
                    updateUI(null)

                }


            }
    }

    public override fun onStart() {
        super.onStart()
        val currentUser: FirebaseUser?= auth.currentUser
        updateUI(currentUser)
    }
   private fun updateUI(currentUser:FirebaseUser?)
    {
        if(currentUser!=null)
        {  if(currentUser.isEmailVerified) {
            startActivity(Intent(this, dashboard::class.java))
            finish()
        }
            else
        {
            Toast.makeText(this,"Verify Your Email",Toast.LENGTH_LONG).show();
        }
        }
        else
        {
            Toast.makeText(baseContext,"Login Failed",Toast.LENGTH_SHORT).show()
        }
    }

}
