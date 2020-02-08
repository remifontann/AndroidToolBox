package fr.isen.fontan.androidtoolbox

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_view_contact_cell.view.*

class ContactsAdapter(val contacts: ArrayList<ContactModel>): RecyclerView.Adapter<ContactsAdapter.ContactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_contact_cell, parent, false)
        return ContactViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contacts.count()
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contacts[position]
        holder.bind(contact)
    }

    class ContactViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(contact: ContactModel) {
            view.webServicesContacts.text = contact.displayName
        }
    }
}