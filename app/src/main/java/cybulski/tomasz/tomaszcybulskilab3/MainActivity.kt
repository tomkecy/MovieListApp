package cybulski.tomasz.tomaszcybulskilab3

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import cybulski.tomasz.tomaszcybulskilab3.Entities.Movie
import android.content.Intent
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    private var moviesList: MutableList<Movie> = ArrayList()
    private var recyclerView: RecyclerView? = null
    private var moviesAdapter: MoviesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view) as RecyclerView

        moviesAdapter = MoviesAdapter(moviesList)

        setupRecyclerView()
        prepareMovieData()
    }

    private fun setupRecyclerView() {
        recyclerView!!.setHasFixedSize(true)
        val movieLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(applicationContext)
        recyclerView!!.layoutManager = movieLayoutManager
        recyclerView!!.itemAnimator = DefaultItemAnimator()
        recyclerView!!.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        recyclerView!!.adapter = moviesAdapter

        recyclerView!!.addOnItemTouchListener(RecyclerTouchListener(applicationContext,
                recyclerView!!, object : ClickListener {
            override fun onClick(view: View, position: Int) {
                var movie = moviesList[position]
                val movieDetailsIntent = Intent(this@MainActivity, MovieDetailsActivity::class.java)
            }

            override fun onLongClick(view: View, position: Int) {
                val movie = moviesList[position]
                movie.seen = movie.seen.not()
                moviesList[position] = movie
                moviesAdapter!!.notifyItemChanged(position)
            }
        }))
    }

    private fun prepareMovieData(): Unit{
        moviesList.add(Movie("Mad Max: Fury Road", "Action & Adventure", "2015"))
        moviesList.add(Movie("Inside Out", "Animation, Kids & Family", "2015"))
        moviesList.add(Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015"))
        moviesList.add(Movie("Shaun the Sheep", "Animation", "2015"))
        moviesList.add(Movie("The Martian", "Science Fiction & Fantasy", "2015"))
        moviesList.add(Movie("Mission: Impossible Rogue Nation", "Action", "2015"))
        moviesList.add(Movie("Up", "Animation", "2009"))
        moviesList.add(Movie("Star Trek", "Science Fiction", "2009"))
        moviesList.add(Movie("The LEGO Movie", "Animation", "2014"))
        moviesList.add(Movie("Iron Man", "Action & Adventure", "2008"))
        moviesList.add(Movie("Aliens", "Science Fiction", "1986"))
        moviesList.add(Movie("Chicken Run", "Animation", "2000"))
        moviesList.add(Movie("Back to the Future", "Science Fiction", "1985"))
        moviesList.add(Movie("Raiders of the Lost Ark", "Action & Adventure", "1981"))
        moviesList.add(Movie("Goldfinger", "Action & Adventure", "1965"))
        moviesList.add(Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014"))

        moviesAdapter!!.notifyDataSetChanged()
    }
}
