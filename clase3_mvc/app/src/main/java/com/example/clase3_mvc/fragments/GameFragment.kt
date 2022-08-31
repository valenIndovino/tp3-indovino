package com.example.clase3_mvc.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clase3_mvc.R
import com.example.clase3_mvc.adapters.GamesAdapter
import com.example.clase3_mvc.entities.Game

class GameFragment : Fragment() {

    companion object {
        fun newInstance() = GameFragment()
    }

    lateinit var v: View
    private lateinit var recGame: RecyclerView
    var gameList: MutableList<Game> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_game, container, false)
        recGame = v.findViewById(R.id.recGame)
        gameList = mutableListOf()
        gameList.add(Game("1", "Minecraft", "Juego de construccion", "https://play-lh.googleusercontent.com/VSwHQjcAttxsLE47RuS4PqpC4LT7lCoSjE7Hx5AW_yCxtDvcnsHHvm5CTuL5BPN-uRTP"))
        gameList.add(Game("2", "League of Legends", "Juego de rol", "https://www.leagueoflegends.com/static/open-graph-2e582ae9fae8b0b396ca46ff21fd47a8.jpg"))
        gameList.add(Game("3", "Valorant", "Shooter", "https://cdn.pocket-lint.com/r/s/1201x/assets/images/152432-games-feature-what-is-valorant-a-guide-to-the-free-to-play-fps-with-tips-on-how-to-win-image3-muha6tfgev.jpg"))
        gameList.add(Game("4", "Fifa 22", "Juego de futbol", "https://image.api.playstation.com/vulcan/img/rnd/202109/2115/5jeuJiXUpb1bZc0Lp1U8N5Ka.png"))

        return v
    }

    override fun onStart() {
        super.onStart()

        recGame.setHasFixedSize(true)

        recGame.layoutManager = LinearLayoutManager(context)

        recGame.adapter = GamesAdapter(gameList) { index ->
            val action =
                GameFragmentDirections.actionGameFragmentToDetailFragment(gameList[index].name, gameList[index].urlImage)
            v.findNavController().navigate(action)
        }
    }


}