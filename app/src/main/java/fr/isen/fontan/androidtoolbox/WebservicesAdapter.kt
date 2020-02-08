package fr.isen.fontan.androidtoolbox

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_view_webservices.view.*

class WebservicesAdapter(val webContacts: ArrayList<ContactModel>): RecyclerView.Adapter<WebservicesAdapter.ContactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_webservices, parent, false)
        return ContactViewHolder(
            view
        )
    }
    override fun getItemCount(): Int {
        return webContacts.count()
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = webContacts[position]
        holder.bind(contact)
    }

    class ContactViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(contact: ContactModel) {
            view.webServicesTextView.text = contact.displayName
            //Picasso.get().load(person.picture).resize(200, 200).into(view.webServicesPicture)
            Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(view.webServicesPicture)
        }
    }
}