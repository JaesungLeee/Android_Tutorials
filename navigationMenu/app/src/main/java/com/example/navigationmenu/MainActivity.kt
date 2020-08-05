package com.example.navigationmenu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navi_btn.setOnClickListener {
            layout_drawer.openDrawer(GravityCompat.START)   // Start == Left, End == Right
        }

        naviView.setNavigationItemSelectedListener(this)    // Navigation Menu Item의 클릭 속성 부여
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {    // Navigation Menu Item 클릭 시 수행할 것들
        when (item.itemId) {
            R.id.account -> {
                Toast.makeText(applicationContext, "사용자 계정 입니다.", Toast.LENGTH_SHORT).show()
            }
            R.id.photo -> {
                Toast.makeText(applicationContext, "사용자 사진 입니다.", Toast.LENGTH_SHORT).show()
            }
            R.id.send -> {
                Toast.makeText(applicationContext, "전송합니다.", Toast.LENGTH_SHORT).show()
            }
        }

        layout_drawer.closeDrawers()    // Navigation View 닫기

        return false
    }

    override fun onBackPressed() {
        if (layout_drawer.isDrawerOpen(GravityCompat.START)) {
            layout_drawer.closeDrawers()    // 열려있으면 Navigation 닫기
        }
        else {
            super.onBackPressed()   // Back 기능 실행 (App Finish 역할)
        }
    }
}