package com.example.hanium.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hanium.R
import com.example.hanium.navigation.Model.ChatDTO
import kotlinx.android.synthetic.main.chat_detail.view.*
import kotlinx.android.synthetic.main.fragment_chatting_list.view.*

class ChattingListFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = LayoutInflater.from(activity).inflate(R.layout.fragment_chatting_list,container,false)

        view.chattinglistfragment_recyclerview.adapter = ChattingListRecyclerviewAdapter()
        view.chattinglistfragment_recyclerview.layoutManager = LinearLayoutManager(activity)
        return view
    }

    inner class ChattingListRecyclerviewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

        var chatDTOs : ArrayList<ChatDTO> = arrayListOf()
        //var chatDTOs : ArrayList<String> = arrayListOf()
        init{
            // reset
            chatDTOs.clear()

            // friends data list loading
            chatDTOs.add(ChatDTO("people1","aaa","url1"))
            chatDTOs.add(ChatDTO("people2","bbb","url2"))
            chatDTOs.add(ChatDTO("people3","ccc","url3"))
            chatDTOs.add(ChatDTO("people4","ddd","url4"))
            chatDTOs.add(ChatDTO("people5","eee","url5"))
            chatDTOs.add(ChatDTO("people6","fff","url6"))

            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            var view = LayoutInflater.from(parent.context).inflate(R.layout.chat_detail,parent,false)
            return CustomViewHolder(view)
        }

        inner class CustomViewHolder(view : View) : RecyclerView.ViewHolder(view)

        override fun getItemCount(): Int {
            return chatDTOs.size
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            var viewholder = (holder as CustomViewHolder).itemView

            // view set
            viewholder.chat_name.text = chatDTOs[position].name
            viewholder.chat_content.text = chatDTOs[position].content
        }



    }
}