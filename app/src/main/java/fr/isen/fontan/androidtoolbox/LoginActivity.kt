package fr.isen.fontan.androidtoolbox

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.carrier.CarrierIdentifier
import android.view.Display
import android.widget.EditText
import android.widget.ShareActionProvider
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import java.lang.reflect.Constructor

class LoginActivity : AppCompatActivity() {

    val goodIdentifier = "admin"
    var goodPassword="123"

    var userPref: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        userPref = getSharedPreferences(Constants.UserPreferencesName, Context.MODE_PRIVATE)
        checkPreferences()
        validateButton.setOnClickListener {
            doLogin()
        }
        /* validateButton.setOnClickListener {
        Toast.makeText(this,"Bonjour ${usernameEditText.text}, Rentrez en mode admin svp",Toast.LENGTH_LONG).show()
        }*/
    }
    fun doLogin(){
        if (canLog(usernameEditText.text.toString(),passwordEditText.text.toString())){
            saveUser(usernameEditText.text.toString(),passwordEditText.text.toString())
            val intent = Intent(this,HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }
    fun canLog(identifier: String, password: String): Boolean{
        return identifier == goodIdentifier && password == goodPassword
    }

    fun saveUser(identifier: String,password: String){
        val editor = userPref?.edit()
        editor?.putString(Constants.kIdentifier,identifier)
        editor?.putString(Constants.KPassword,password)
        editor?.commit()
    }

    fun checkPreferences(){
        //TODO field username and password
        val identifier = userPref?.getString(Constants.kIdentifier, null) ?: ""
        val password = userPref?.getString(Constants.KPassword,null) ?: ""
        usernameEditText.setText(identifier)
        passwordEditText.setText(password)
        //doLogin()
    }

}
