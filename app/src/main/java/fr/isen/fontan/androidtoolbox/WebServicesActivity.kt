package fr.isen.fontan.androidtoolbox
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import fr.isen.fontan.androidtoolbox.Models.RandomUserResult
import kotlinx.android.synthetic.main.activity_web_services.*

class WebServicesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_services)

        val userApiUrl = "https://randomuser.me/api/?results=2"
        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(Request.Method.GET, userApiUrl,
            Response.Listener<String> { response ->
                RequestView.text = "Response is: ${response.substring(0, 500)}"
                val gson = Gson()
                val result = gson.fromJson( response, RandomUserResult::class.java)
                //let pour rendre non optionnel
                result.results?.let { users ->
                    Log.d("volley", users[0].gender)
                }
            },
            Response.ErrorListener { RequestView.text = "That didn't work!" })
        queue.add(stringRequest)
    }
}