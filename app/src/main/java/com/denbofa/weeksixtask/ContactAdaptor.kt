package com.denbofa.weeksixtask

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.denbofa.weeksixtask.databinding.ContactlistitemBinding


class ContactAdaptor(val contactItems: List<ContactListModel>): RecyclerView.Adapter<ContactAdaptor.ViewHolder>() {

    inner class ViewHolder(val binding: ContactlistitemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(contactItem: ContactListModel) {
            binding.firstLastName.text = contactItem.firstName + " " + contactItem.lastName
            binding.userNumber.text = contactItem.pNum1 + " ," + contactItem.pNum2

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ContactlistitemBinding = ContactlistitemBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun getItemCount() = contactItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(contactItems.get(position))
    }
}