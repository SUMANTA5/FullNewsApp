package com.sumanta.newmvvmapp.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sumanta.newmvvmapp.util.Constants.Companion.CURRENT_USER_ID


@Entity
data class User (
    var id: Int? = null,
    var name: String? = null,
    var email: String? = null,
    var email_verified_at: String? = null,
    var created_at: String? = null,
    var updated_at: String? = null
){
    @PrimaryKey(autoGenerate = true)
    var uid: Int = CURRENT_USER_ID
}





