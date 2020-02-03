package fr.isen.fontan.androidtoolbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_web_services.*

class WebServicesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_services)

        val userApiUrl = "https://randomuser.me/api/?results=2"
        val queue = Volley.newRequestQueue(this)

        val stringRequest = StringRequest(Request.Method.GET, userApiUrl,
            Response.Listener<String> { response ->
                // Display the first 500 characters of the response string.
                RequestView.text = "Response is: ${response.substring(0, 500)}"
            },
            Response.ErrorListener { RequestView.text = "That didn't work!" })
        queue.add(stringRequest)
    }
}
