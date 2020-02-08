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
import kotlinx.android.synthetic.main.activity_permission.*
import kotlinx.android.synthetic.main.activity_web_services.*
import kotlinx.android.synthetic.main.recycler_view_webservices.*

class WebServicesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val contactList = ArrayList<ContactModel>()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_services)

        val userApiUrl = "https://randomuser.me/api/?results=2"
        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(Request.Method.GET, userApiUrl,
            Response.Listener<String> { response ->
                val gson = Gson()
                val result = gson.fromJson( response, RandomUserResult::class.java)
                RequestView.text = "Response is: ${response.substring(0, 500)}"
                //let pour rendre non optionnel
                result.results?.let { users ->
                    Log.d("volley", users[0].gender)
                    WebServicesRecycleView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                    WebServicesRecycleView.adapter = WebservicesAdapter(contactList)
                }
            },
            Response.ErrorListener { RequestView.text = "That didn't work!" })
        queue.add(stringRequest)

    }
}