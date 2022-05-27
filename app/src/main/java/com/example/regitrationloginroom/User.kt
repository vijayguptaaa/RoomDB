package com.example.regitrationloginroom

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) var id : Int,
    var firstName : String,
    var lastName : String,
    var emailId : String,
    var password : String

)
/*{
    fun user(firstName: String,lastName: String,emailId: String,password: String) {
        this.firstName = firstName
        this.lastName = lastName
        this.emailId =  emailId
        this.password = password
    }
}*/



