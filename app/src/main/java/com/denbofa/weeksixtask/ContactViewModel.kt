package com.denbofa.weeksixtask

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class ContactViewModel: ViewModel() {

    fun addContactListItem(contactItem: ContactListModel, database: ContactDatabase) {
        database.contactDoa().addContactItem(contactItem)
    }

    fun getAllContactItems(database: ContactDatabase): LiveData<List<ContactListModel>> {
        return database.contactDoa().getAllContactItems()
    }
}