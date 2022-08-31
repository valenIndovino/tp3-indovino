package com.example.clase3_mvc.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.clase3_mvc.R
import com.example.clase3_mvc.entities.Game

class GamesAdapter(
    var gameList: MutableList<Game>,
    var onClick: (Int) -> Unit
) : RecyclerView.Adapter<GamesAdapter.GameHolder>() {

    class GameHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view: View

        init {
            this.view = v
        }

        fun setTitle(title: String) {
            var txtTitle: TextView = this.view.findViewById(R.id.gameName)
            txtTitle.text = title
        }

        fun getCardView(): CardView {
            return view.findViewById(R.id.cardGame)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        return (GameHolder(view))
    }

    override fun onBindViewHolder(holder: GameHolder, position: Int) {
        holder.setTitle(gameList[position].name)
        holder.getCardView().setOnClickListener {
            onClick(position)
        }
    }

    override fun getItemCount(): Int {
        return gameList.size
    }

}