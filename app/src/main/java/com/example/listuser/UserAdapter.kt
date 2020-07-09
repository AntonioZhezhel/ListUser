package com.example.listuser

import android.annotation.SuppressLint
import android.transition.CircularPropagation
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listuser.data.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_view.view.*

class UserAdapter(dataList: MutableList<Result>): RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    companion object{
        const val ITEM_LAYOUT = R.layout.item_view
    }

    var callback: Callback? = null

    var dataName :MutableList<Result> = dataList
        set (value){
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(ITEM_LAYOUT,parent,false)
        return ViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return dataName.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataName[position])
    }

    interface Callback{
        fun onItemClicked(item: Result)
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        @SuppressLint("SetTextI18n")
        fun bind(item: Result){
            itemView.textViewUserName.text = item.name.first +" " + item.name.last
            Picasso.get().load(item.picture.medium).into(itemView.imageButtonUser)

//            itemView.imageButtonUser.setOnClickListener {
//                item.let { it -> dataName.invoke(it) }
//            }

            itemView.setOnClickListener{callback?.onItemClicked(item)}

        }

    }

}