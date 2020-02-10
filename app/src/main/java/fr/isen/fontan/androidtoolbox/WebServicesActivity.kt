package fr.isen.fontan.androidtoolbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import fr.isen.fontan.androidtoolbox.Models.RandomUserResult
import fr.isen.fontan.androidtoolbox.Models.UserModelAdaptater
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_permission.*
import kotlinx.android.synthetic.main.activity_web_services.*
import kotlinx.android.synthetic.main.recycler_view_webservices.*

class WebServicesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_services)

        val userApiUrl = "https://randomuser.me/api/?results=20"
        val queue = Volley.newRequestQueue(this)

        val req = StringRequest(Request.Method.GET, userApiUrl, Response.Listener {

            val gson = Gson()
            val sortie = gson.fromJson(it, RandomUserResult::class.java)
            Log.d("volley", "salut")
            WebServicesRecycleView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

            sortie.results?.let {
                WebServicesRecycleView.adapter = UserModelAdaptater(it)
            }
        }, Response.ErrorListener {
            Log.d("volley", it.toString())
        })
        queue.add(req)

    }
}