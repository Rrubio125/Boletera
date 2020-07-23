package com.example.boletera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    val homeFragment = MainFragment()
    val searchFragment = SearchFragment()
    val userFragment = UserFragment()
    val calendarFragment = CalendarFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation: BottomNavigationView = findViewById(R.id.nav_view)
        makeCurrentFragment(homeFragment)
        bottomNavigation.setOnNavigationItemReselectedListener { it ->
            when (it.itemId) {
                R.id.navigation_home -> makeCurrentFragment(homeFragment)
                R.id.navigation_calendar -> makeCurrentFragment(calendarFragment)
                R.id.navigation_user -> makeCurrentFragment(userFragment)
                R.id.navigation_search -> makeCurrentFragment(searchFragment)
            }

            true
        }


    }

    private fun makeCurrentFragment (fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.rv, fragment)
            commit()
        }


}




