package com.example.regitrationloginroom

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.regitrationloginroom.databinding.ActivityMainBinding

class RegistrationActivity : AppCompatActivity() {

    lateinit var userDao: UserDao
    lateinit var mBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        this.setTitle("Registration Page")
        mBinding.loginPage.setOnClickListener(View.OnClickListener {

            val moveToLogin = Intent(this, LoginActivity::class.java)
            startActivity(moveToLogin)
        })


        userDao = Room.databaseBuilder(this, UserDataBase::class.java, "mi-database.db")
            .allowMainThreadQueries()
            .build().getUserDao()


        mBinding.registrationButton.setOnClickListener(View.OnClickListener {
            val firstName: String = mBinding.firstName.text.toString()
            val lastName: String = mBinding.lastName.text.toString()
            val emailId: String = mBinding.emailId.text.toString()
            val mobile : String = mBinding.mobile.text.toString()
            val password: String = mBinding.password.text.toString()
            val confirmPassword: String = mBinding.confirmPassword.text.toString()




            if (firstName.isEmpty()) {
                mBinding.firstName.setError("Field cannot be empty")
                return@OnClickListener

            }
            else if (lastName.isEmpty())
            {
                mBinding.lastName.setError("Field cannot be empty")
                return@OnClickListener

            }
            else if (emailId.isEmpty())
            {
                mBinding.emailId.setError("Field cannot be empty")

                return@OnClickListener

            }
            else if(mobile.isEmpty()){
                mBinding.mobile.setError("Field cannot be empty")
            }
            else if (password.isEmpty())
            {
                mBinding.password.setError("Field cannot be empty")
                return@OnClickListener

            }
            else if (confirmPassword.isEmpty())
            {
                mBinding.confirmPassword.setError("Field cannot be empty")
                return@OnClickListener

            }


            if (password.equals(confirmPassword)){

                var user = User( 0,firstName,lastName,emailId,password)
                 userDao.insert(user)


                val moveToLogin = Intent(this, LoginActivity::class.java)
                 startActivity(moveToLogin)

            }

            else{
                Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()

            } })
    }
}