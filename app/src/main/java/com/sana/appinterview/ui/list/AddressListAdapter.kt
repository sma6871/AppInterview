package com.sana.appinterview.ui.list

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ir.mydiet.extensions.inflate
import com.sana.appinterview.R
import com.sana.appinterview.data.models.response.AddressResponse
import kotlinx.android.synthetic.main.address_item.view.*

class AddressListAdapter : RecyclerView.Adapter<AddressListAdapter.ViewHolder>() {

    var items: MutableList<AddressResponse> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.address_item)
        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun addItems(list: List<AddressResponse>) {
        items.addAll(list)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        fun bind(addressResponse: AddressResponse) {
            itemView.txtName.text=addressResponse.firstName
            itemView.txtLastName.text=addressResponse.lastName
            itemView.txtMobile.text=addressResponse.coordinateMobile
            itemView.txtAddress.text=addressResponse.address
        }

    }
}