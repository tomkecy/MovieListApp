package cybulski.tomasz.tomaszcybulskilab3

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import cybulski.tomasz.tomaszcybulskilab3.Entities.Genre
import cybulski.tomasz.tomaszcybulskilab3.Entities.Movie

class MainActivity : AppCompatActivity() {
    private var movieList: MutableList<Movie> = ArrayList()
    private var recyclerView: RecyclerView? = null
    private var moviesAdapter: MoviesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view) as RecyclerView

        moviesAdapter = MoviesAdapter(movieList)

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
                val movie = movieList[position]
                Toast.makeText(applicationContext, movie.title + " is selected", Toast.LENGTH_SHORT).show()
            }

            override fun onLongClick(view: View, position: Int) {

            }
        }))
    }

    private fun prepareMovieData(): Unit{
        var movie = Movie("Mad Max: Fury Road", Genre.Action, "2015")
        movieList.add(movie)

        movie = Movie("Inside Out", Genre.Animation, "2015")
        movieList.add(movie)

        movie = Movie("Star Wars: Episode VII - The Force Awakens", Genre.Action, "2015")
        movieList.add(movie)

        movie = Movie("Shaun the Sheep", Genre.Animation, "2015")
        movieList.add(movie)

        movie = Movie("The Martian", Genre.ScienceFiction, "2015")
        movieList.add(movie)

        movie = Movie("Mission: Impossible Rogue Nation", Genre.Action, "2015")
        movieList.add(movie)

        movie = Movie("Up", Genre.Animation, "2009")
        movieList.add(movie)

        movie = Movie("Star Trek", Genre.ScienceFiction, "2009")
        movieList.add(movie)

        movie = Movie("The LEGO Movie", Genre.Animation, "2014")
        movieList.add(movie)

        movie = Movie("Iron Man", Genre.Action, "2008")
        movieList.add(movie)

        movie = Movie("Aliens", Genre.ScienceFiction, "1986")
        movieList.add(movie)

        movie = Movie("Chicken Run", Genre.Animation, "2000")
        movieList.add(movie)

        movie = Movie("Back to the Future", Genre.ScienceFiction, "1985")
        movieList.add(movie)

        movie = Movie("Raiders of the Lost Ark", Genre.Action, "1981")
        movieList.add(movie)

        movie = Movie("Goldfinger", Genre.Action, "1965")
        movieList.add(movie)

        movie = Movie("Guardians of the Galaxy", Genre.ScienceFiction, "2014")
        movieList.add(movie)

        moviesAdapter!!.notifyDataSetChanged()
    }
}
