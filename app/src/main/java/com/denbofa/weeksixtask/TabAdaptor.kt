package com.denbofa.weeksixtask

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.denbofa.weeksixtask.views.ContactListFragment
import com.denbofa.weeksixtask.views.CreateContactFragment

class TabAdaptor(fm: FragmentManager): FragmentStatePagerAdapter(fm) {

    override fun getPageTitle(position: Int): CharSequence? {
        when (position){
            0 -> return "Contacts"
            1 -> return "Create New Contact"
            else -> return "Contacts"
        }
    }

    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> return ContactListFragment()
            1 -> return CreateContactFragment()
            else -> return ContactListFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }
}