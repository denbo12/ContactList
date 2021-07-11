package com.denbofa.weeksixtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.denbofa.weeksixtask.databinding.ActivityMainBinding
import com.denbofa.weeksixtask.databinding.FragmentContactListBinding
import com.denbofa.weeksixtask.databinding.FragmentCreateContactBinding
import com.denbofa.weeksixtask.views.ContactListFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var bindingRecyclerView: FragmentContactListBinding
    private lateinit var bindingSaveContact: FragmentCreateContactBinding
    private lateinit var tabAdaptor: TabAdaptor
    private lateinit var myContactAdaptor: ContactAdaptor
    private lateinit var myContactList: MutableList<ContactListModel>
    private lateinit var viewModel: ContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        tabAdaptor = TabAdaptor(supportFragmentManager)
        binding.pager.adapter = tabAdaptor
        binding.tabLayout.setupWithViewPager(binding.pager)

        viewModel =  ViewModelProvider(this)[ContactViewModel::class.java]

        myContactList = mutableListOf()

        myContactAdaptor = ContactAdaptor(myContactList)
        bindingRecyclerView.recyclerView.adapter = myContactAdaptor

        val db = Room.databaseBuilder(applicationContext, ContactDatabase::class.java, "contact-database").allowMainThreadQueries().build()

        viewModel.getAllContactItems(db).observe(this, {
            myContactAdaptor = ContactAdaptor(it)
            bindingRecyclerView.recyclerView.adapter = myContactAdaptor
            myContactAdaptor.notifyDataSetChanged()
        })

        bindingSaveContact.save.setOnClickListener {
            val fName: String = bindingSaveContact.firstName.text.toString()
            val lName: String = bindingSaveContact.lastName.text.toString()
            val cWork: String = bindingSaveContact.workPlace.text.toString()
            val fNum: String = bindingSaveContact.phoneNum1.text.toString()
            val sNum: String = bindingSaveContact.phoneNum2.text.toString()
            val cEmail: String = bindingSaveContact.userEmail.text.toString()
            val cDateOfBirth: String = bindingSaveContact.birthDate.text.toString()
            val cSavedDate: String = bindingSaveContact.dateSaved.text.toString()
            val cRelative: String = bindingSaveContact.contactRelative.text.toString()

            val contactItem = ContactListModel(fName, lName, cWork, fNum, sNum, cEmail, cDateOfBirth, cSavedDate, cRelative)
            viewModel.addContactListItem(contactItem, db)
            myContactAdaptor.notifyDataSetChanged()
        }
    }
}

