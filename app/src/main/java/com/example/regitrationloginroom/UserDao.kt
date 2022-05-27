package com.example.regitrationloginroom

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM User where emailId= :mail and password= :password")

    fun getUser(mail: String, password: String): User

    @Insert
    fun insert(user: User)

}