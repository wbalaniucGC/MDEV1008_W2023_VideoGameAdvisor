package com.mdev.videogameadvisor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val findGamesBtn = findViewById<Button>(R.id.find_game)

        findGamesBtn.setOnClickListener {
            // What do we do when we click on the button?
            // 1. Get a reference to the spinner
            val gameChoice = findViewById<Spinner>(R.id.game_choice)
            // 2. Get the selected item in the spinner
            val selectedGenre = gameChoice.selectedItem
            // 2b. Get the list of games based on the genre
            val gameList = getGames(selectedGenre.toString())
            // 2c. Modify my list to include new line characters
            val games = gameList.reduce { str, item -> str + '\n' + item }
            // 3. Get a reference to the TextView
            val finalGamesList = findViewById<TextView>(R.id.games)
            // 4. Update the text to reflect the item selected in the spinner
            finalGamesList.text = games
        }
    }

    fun getGames(genre: String) : List<String> {
        return when (genre) {
            "Action" -> listOf("Legend of Zelda", "Grand Theft Auto 5")
            "Adventure" -> listOf("Final Fantasy", "Elden Ring")
            "Strategy" -> listOf("Age of Empires", "StarCraft")
            "Sports" -> listOf("FIFA23", "NBA2K23")
            "RPG" -> listOf("Pokemon", "Chrono Trigger")
            else -> listOf("Super Mario", "Metroid")
        }
    }
}