package fr.isen.fontan.androidtoolbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class LifeCycleActivity : AppCompatActivity(), OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)

        val firstFragment = FirstFragment()
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, firstFragment).commit()

    }

    override fun swipeFragment() {
        val secondFragment = SecondFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, secondFragment).commit()
    }
}

