package com.denbofa.weeksixtask

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ContactListModel (
        val firstName: String,
        val lastName: String,
        val work: String,
        val pNum1: String,
        val pNum2: String,
        val email: String,
        val dateOfBirth: String,
        val dateSaved: String,
        val relative: String,

        @PrimaryKey(autoGenerate = true)
        val uid: Int = 0
)