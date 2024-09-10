package com.example.realmadridcf.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.realmadridcf.databinding.PlayerListBinding
import com.example.realmadridcf.model.Player

class PlayerAdapter(private val playerList:ArrayList<Player>):RecyclerView.Adapter<PlayerAdapter.MyViewHolder>() {

    var onClick : ((Player)->Unit) ?= null


    class MyViewHolder(val binding: PlayerListBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = PlayerListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return playerList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {
            playerName.text = playerList[position].playerName
            playerNum.text = "Number: " + playerList[position].playerNumber.toString()
            playerPrice.text = "Price: $" +playerList[position].playerprice.toString()
            playerImg.setImageResource(playerList[position].playerImg)


        }

        holder.itemView.setOnClickListener {
            AlertDialog.Builder(holder.itemView.context)
                .setTitle("Delete Player")
                .setMessage("Are you sure you want to delete this player?")
                .setPositiveButton("Yes") { _, _ ->
                    playerList.removeAt(position)
                    notifyItemRemoved(position)
                }
                .setNegativeButton("No", null)
                .show()
            true
        }


    }
}