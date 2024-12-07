package com.kotlinexample.task1

import RvAdapter
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.kotlinexample.task1.databinding.ActivitySecondaryBinding

class SecondaryActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondaryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySecondaryBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        enableEdgeToEdge()

        val username = intent.getStringExtra("username")
        binding.welcome.text = "Welcome $username"

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val  adapter = RvAdapter()

        binding.rvmovies.adapter = adapter
        binding.rvmovies.layoutManager = LinearLayoutManager(this)

        val movieList = listOf(
            Movie("Inception", "A skilled thief is given a chance at redemption if he can successfully perform an inception, planting an idea into the mind of a CEO.", "https://m.media-amazon.com/images/I/81p+xb8s5iL._SY679_.jpg", "8.8/10"),
            Movie("The Dark Knight", "Batman faces his greatest challenge yet in the form of the Joker, a villain who seeks to bring chaos and destruction to Gotham City.", "https://m.media-amazon.com/images/I/71p2n2k6usL._SY679_.jpg", "9.0/10"),
            Movie("The Godfather", "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.", "https://m.media-amazon.com/images/I/51PjH6dP4eL._SY679_.jpg", "9.2/10"),
            Movie("Titanic", "A seventeen-year-old aristocrat falls in love with a kind but poor artist aboard the luxurious but ill-fated R.M.S. Titanic.", "https://m.media-amazon.com/images/I/71bL0BEX6XL._SY679_.jpg", "7.8/10"),
            Movie("The Shawshank Redemption", "Two imprisoned men form a friendship, finding solace and eventual redemption through acts of common decency.", "https://m.media-amazon.com/images/I/51NiGlapXlL._SY679_.jpg", "9.3/10"),
            Movie("The Avengers", "Earth's mightiest heroes must come together to stop Loki and his alien army from enslaving humanity.", "https://m.media-amazon.com/images/I/91FuKnkPz2L._SY679_.jpg", "8.0/10"),
            Movie("Forrest Gump", "The presidencies of Kennedy and Johnson, the Vietnam War, the Watergate scandal and other historical events unfold from the perspective of an Alabama man with an IQ of 75, whose only desire is to be reunited with his childhood sweetheart.", "https://m.media-amazon.com/images/I/71z5MIeRGmL._SY679_.jpg", "8.8/10"),
            Movie("The Matrix", "A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.", "https://m.media-amazon.com/images/I/91vKz8PV0RL._SY679_.jpg", "8.7/10"),
            Movie("Interstellar", "A team of explorers must travel beyond our solar system in search of a new habitable planet after Earth becomes uninhabitable.", "https://m.media-amazon.com/images/I/91H-J+5u5zL._SY679_.jpg", "8.6/10"),
            Movie("The Lion King", "Lion prince Simba and his father are targeted by his bitter uncle, who wants to ascend the throne himself.", "https://m.media-amazon.com/images/I/61f1vB4-EQL._SY679_.jpg", "8.5/10")
        )

        adapter.addItems(movieList)







    }



}