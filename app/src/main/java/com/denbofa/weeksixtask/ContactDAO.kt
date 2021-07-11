package com.denbofa.weeksixtask

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface ContactDAO {
    @Insert
    fun addContactItem(contactItem: ContactListModel)

    @Query("SELECT * from contactlistmodel")
    fun getAllContactItems(): LiveData<List<ContactListModel>>

    @Delete
    fun delete(contactItem: ContactListModel)
}