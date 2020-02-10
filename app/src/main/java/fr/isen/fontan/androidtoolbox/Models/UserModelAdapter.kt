package fr.isen.fontan.androidtoolbox.Models

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.isen.fontan.androidtoolbox.R

import kotlinx.android.synthetic.main.recycler_view_webservices.view.*

class UserModelAdaptater(val contacts: ArrayList<UserModel>): RecyclerView.Adapter<UserModelAdaptater.ContactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_webservices, parent, false)
        return ContactViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contacts.count()
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contacts[position]
        holder.bind(contact)
        holder.picasso(contact)
    }

    class ContactViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(contact: UserModel) {
            view.webServicesTextView.text = contact.name?.first ?: "name"
        }

        fun picasso(contact: UserModel){
            Picasso.get().load(contact.picture?.thumbnail).resize(200, 200).into(view.webServicesPicture)
        }
    }
}