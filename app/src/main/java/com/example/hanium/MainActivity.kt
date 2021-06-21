package com.example.hanium

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.hanium.navigation.ChattingListFragment
import com.example.hanium.navigation.FriendsListFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_people_list -> {
                var friendsListFragment = FriendsListFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_content,friendsListFragment).commit()
                return true
            }

            R.id.action_chatting -> {
                var chattingListFragment = ChattingListFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_content,chattingListFragment).commit()
                return true
            }
        }
        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation.setOnNavigationItemSelectedListener(this)
        bottom_navigation.itemIconTintList = null

        // Set default screen
        bottom_navigation.selectedItemId = R.id.action_people_list

    }

}
