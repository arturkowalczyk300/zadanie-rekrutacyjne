package com.arturkowalczyk300.zadanierekrutacyjne.View

import android.content.Intent
import android.telecom.Call.Details
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arturkowalczyk300.zadanierekrutacyjne.Model.EnumApiSource
import com.arturkowalczyk300.zadanierekrutacyjne.Model.Local.User
import com.arturkowalczyk300.zadanierekrutacyjne.R
import com.squareup.picasso.Picasso


class UsersAdapter(val data: List<User>) :
    RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvName: TextView = itemView.findViewById(R.id.rvUserTextName)
        private val tvSourceApi: TextView = itemView.findViewById(R.id.rvUserTextSourceApi)
        private val ivAvatar: ImageView = itemView.findViewById(R.id.rvUserImageAvatar)

        fun bind(user: User) {
            val context = itemView.context

            tvName.text = context.getString(R.string.user_name, user.name)
            val apiSourceText = when (user.source) {
                EnumApiSource.API_DAILYMOTION -> context.getString(R.string.api_dailymotion)
                else -> context.getString(R.string.api_github)
            }
            tvSourceApi.text = itemView.context.getString(R.string.user_api_source, apiSourceText)
            if (user.avatarUrl != null) {
                Picasso.get().load(user.avatarUrl).into(ivAvatar)
            } else
                ivAvatar.setImageResource(R.drawable.default_photo)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_user, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = data[position]
        holder.bind(currentItem)
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailsActivity::class.java)

            intent.putExtra(EXTRA_USER_NAME, currentItem.name)
            intent.putExtra(EXTRA_USER_API_SOURCE, currentItem.source.toString())
            intent.putExtra(EXTRA_USER_IMAGE_URL, currentItem.avatarUrl)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount() = data.size
}