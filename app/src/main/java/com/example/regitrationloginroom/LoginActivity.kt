package com.example.regitrationloginroom

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.regitrationloginroom.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var mBinding : ActivityLoginBinding
    lateinit var db: UserDao
    lateinit var dataBase: UserDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        this.setTitle("Login Page")

        mBinding.newAccount.setOnClickListener(View.OnClickListener {

            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        })

        dataBase = Room.databaseBuilder(this, UserDataBase::class.java, "mi-database.db")
            .allowMainThreadQueries()
            .build()

        db = dataBase.getUserDao()

        mBinding.loginButton.setOnClickListener(View.OnClickListener {

            val email: String = mBinding.email.text.toString().trim()
            val password: String = mBinding.password.text.toString().trim()

            if (email.isEmpty()) {
                mBinding.email.setError("Field cannot be empty")
                return@OnClickListener

            }
            else if (password.isEmpty())
            {
                mBinding.password.setError("Field cannot be empty")
                return@OnClickListener

            }
            var user: User
            user = db.getUser(email,password)



            if (user != null) {

                 val moveToHome = Intent(this, HomeActivity::class.java)
                 startActivity(moveToHome)
            } else {
                Toast.makeText(this, "Unregistered user, or incorrect", Toast.LENGTH_SHORT).show()
            }

        })
    }
}

