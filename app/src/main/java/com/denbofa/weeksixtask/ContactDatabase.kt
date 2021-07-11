package com.denbofa.weeksixtask

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = arrayOf(ContactListModel::class),
    version = 1
)

abstract class ContactDatabase: RoomDatabase() {
    abstract fun contactDoa(): ContactDAO
}