package com.example.regitrationloginroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.regitrationloginroom.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    lateinit var mBinding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        this.setTitle("Home Page")

    }
}