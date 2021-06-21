package com.example.hanium.navigation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hanium.R
import com.example.hanium.navigation.Model.FriendDTO
import kotlinx.android.synthetic.main.fragment_friends_list.view.*
import kotlinx.android.synthetic.main.friend_detail.view.*
import java.io.Console

class FriendsListFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = LayoutInflater.from(activity).inflate(R.layout.fragment_friends_list,container,false)

        view.friendslistfragment_recyclerview.adapter = FriendslistRecyclerViewAdapter()
        view.friendslistfragment_recyclerview.layoutManager = LinearLayoutManager(activity)
        return view
    }

    inner class FriendslistRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

        var friendDTOs : ArrayList<FriendDTO> = arrayListOf()
        //var friendDTOs : ArrayList<String> = arrayListOf()
        init{
            // reset
            friendDTOs.clear()

            // friends data list loading
            friendDTOs.add(FriendDTO("people1","url1"))
            friendDTOs.add(FriendDTO("people2","url2"))
            friendDTOs.add(FriendDTO("people3","url3"))
            friendDTOs.add(FriendDTO("people4","url4"))
            friendDTOs.add(FriendDTO("people5","url5"))
            friendDTOs.add(FriendDTO("people6","url6"))

            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            var view = LayoutInflater.from(parent.context).inflate(R.layout.friend_detail,parent,false)
            return CustomViewHolder(view)
        }

        inner class CustomViewHolder(view : View) : RecyclerView.ViewHolder(view)

        override fun getItemCount(): Int {
            return friendDTOs.size
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            var viewholder = (holder as CustomViewHolder).itemView

            // view set
            viewholder.frined_name.text = friendDTOs[position].name
        }



    }
}