package com.example.realmadridcf

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.realmadridcf.adapter.PlayerAdapter
import com.example.realmadridcf.databinding.ActivityMainBinding
import com.example.realmadridcf.databinding.AddPlayerBinding
import com.example.realmadridcf.model.Player

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var player = ArrayList<Player>()
    var playerAdapter = PlayerAdapter(player)
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.allPlayer.layoutManager = LinearLayoutManager(/* context = */ this)



        player.add(
            Player(
                "Cristiano Ronaldo",
                7,
                "€100 million",
                R.drawable.ronaldo,
                "Cristiano Ronaldo is a Portuguese professional footballer who plays as " +
                        "a forward for Premier League club Manchester United and captains the Portugal national team."
            )
        )
        player.add(
            Player(
                "K. Mbappe",
                9,
                "€100 million",
                R.drawable.mbappe9,
                "K. Mbappé is a French professional footballer who plays " +
                        "as a forward for Ligue 1 club Paris Saint-Germain"
            )
        )
        player.add(
            Player(
                "Alaba",
                4,
                "€100 million",
                R.drawable.alaba4,
                "Alaba is a German professional footballer who plays " +
                        "as a midfielder for Premier League club Liverpool"
            )
        )
        player.add(
            Player(
                "Ballingham",
                5,
                "€100 million",
                R.drawable.ballingham5,
                "Ballingham is a British professional footballer who plays " +
                        "as a midfielder for Premier League club Liverpool"
            )
        )
        player.add(
            Player(
                "camavinga",
                6,
                "€100 million",
                R.drawable.camavinga6,
                "Camavinga is a French professional footballer who plays " +
                        "as a midfielder for Ligue 1 club Paris Saint-Germain"
            )
        )
        player.add(
            Player(
                "Endrick",
                16,
                "€100 million",
                R.drawable.endrick16,
                "Endrick is a French professional footballer who plays " +
                        "as a midfielder for Ligue 1 club Paris Saint-Germain"
            )
        )
        player.add(
            Player(
                "Rodrigo",
                11,
                "€100 million",
                R.drawable.rodrigo11,
                "Rodrigo is a Spanish professional footballer who plays " +
                        "as a midfielder for Ligue 1 club Paris Saint-Germain"
            )
        )
        player.add(
            Player(
                "Vini jr",
                7,
                "€100 million",
                R.drawable.vinijr7,
                "Vini Jr is a Brazilian professional footballer who plays " +
                        "as a midfielder for Ligue 1 club Paris Saint-Germain"
            )
        )
        player.add(
            Player(
                "Arda Guler",
                15,
                "€100 million",
                R.drawable.ardaguler15,
                "Arda Guler is a Turkish professional footballer who plays " +
                        "as a midfielder for Premier League club Liverpool"
            )
        )
        player.add(
            Player(
                "Tchouamen",
                14,
                "€100 million",
                R.drawable.tchouamen14,
                "Tchouamen is a French professional footballer who plays " +
                        "as a midfielder for Ligue 1 club Paris Saint-Germain"
            )
        )
        player.add(
            Player(
                "Modric",
                10,
                "€100 million",
                R.drawable.modric10,
                "Modric is a Croatian professional footballer who plays " +
                        "as a midfielder for Premier League club Liverpool"
            )
        )
        player.add(
            Player(
                "Valvarda",
                8,
                "€100 million",
                R.drawable.valvarda8,
                "Valvarda is a Croatian professional footballer who plays " +
                        "as a midfielder for Premier League club Liverpool"
            )
        )
        player.add(
            Player(
                "Rudiger",
                22,
                "€100 million",
                R.drawable.rudiger22,
                "Rudiger is a German professional footballer who plays " +
                        "as a midfielder for Premier League club Liverpool"
            )
        )
        player.add(
            Player(
                "Lucas",
                17,
                "€100 million",
                R.drawable.lucas17,
                "Lucas is a French professional footballer who plays " +
                        "as a midfielder for Ligue 1 club Paris Saint-Germain"
            )
        )
        player.add(
            Player(
                "Militao",
                3,
                "€100 million",
                R.drawable.militao3,
                "Militao is a Brazilian professional footballer who plays " +
                        "as a midfielder for Ligue 1 club Paris Saint-Germain"
            )
        )
        player.add(
            Player(
                "carvagal",
                2,
                "€100 million",
                R.drawable.carvagal2,
                "Carvagal is a French professional footballer who plays " +
                        "as a midfielder for Ligue 1 club Paris Saint-Germain"
            )
        )
        player.add(
            Player(
                "Courtois",
                1,
                "€100 million",
                R.drawable.courtois1,
                "Courtois is a Belgian professional footballer who plays " +
                        "as a goal keeper for Ligue 1 club Paris Saint-Germain"
            )
        )
        player.add(
            Player(
                "Lunin",
                13,
                "€100 million",
                R.drawable.lunin13,
                "Lunin is a Russian professional footballer who plays " +
                        "as a midfielder for Premier League club Liverpool"
            )
        )

        binding.allPlayer.adapter = playerAdapter

        playerAdapter.onClick = {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("name", it.playerName)
            intent.putExtra("price", it.playerprice)
            intent.putExtra("quantity", it.playerNumber)
            intent.putExtra("desc", it.playerdescription)
            intent.putExtra("image", it.playerImg)
            startActivity(intent)

        }

        binding.addBtn.setOnClickListener {
            showFruitAddDialog()
        }

        val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                player.removeAt(viewHolder.adapterPosition)
                playerAdapter.notifyItemRemoved(viewHolder.adapterPosition)
            }
        })

        itemTouchHelper.attachToRecyclerView(binding.allPlayer)



    }

    private fun showFruitAddDialog() {
        var dialogView = AddPlayerBinding.inflate(layoutInflater)

        AlertDialog.Builder(this)
            .setTitle("Add Player")
            .setView(dialogView.root)
            .setPositiveButton("Add") { dialog, _ ->
                var name = dialogView.fruitNameEt.text.toString()
                val price = dialogView.playerPriceEt.text.toString().toDouble()
                val number = dialogView.playerNumberEt.text.toString().toInt()
                val desc = dialogView.playerDescEt.text.toString()
                val image = R.drawable.ronaldo
                player.add(Player(name, number, price.toString(), image, desc))
                playerAdapter.notifyItemInserted(player.size-1)

            }

            .setNegativeButton("Cancel", null)
            .show()
    }

}