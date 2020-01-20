package fr.isen.fontan.androidtoolbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.carrier.CarrierIdentifier
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    //val mEdit : EditText = findViewById(R.id.usernameEditText)
    val goodIdentifier = "admin"
    var goodPassword="123"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        validateButton.setOnClickListener {
            Toast.makeText(this,"Bonjour ${usernameEditText.text}, Rentrez en mode admin svp",Toast.LENGTH_LONG).show()
        }
        validateButton.setOnClickListener {
            doLogin()
        }

    }

    //if(mEdit)
    fun doLogin(){
        if (canLog(usernameEditText.text.toString(),passwordEditText.text.toString())){
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }
    }
    fun canLog(identifier: String, password: String): Boolean{
        return identifier == goodIdentifier && password == goodPassword
    }

}
