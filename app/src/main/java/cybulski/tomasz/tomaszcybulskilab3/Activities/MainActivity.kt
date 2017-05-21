package cybulski.tomasz.tomaszcybulskilab3.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import cybulski.tomasz.tomaszcybulskilab3.Entities.Movie
import android.content.Intent
import cybulski.tomasz.tomaszcybulskilab3.Abstract.IClickListener
import cybulski.tomasz.tomaszcybulskilab3.RecyclerViewHelpers.DividerItemDecoration
import cybulski.tomasz.tomaszcybulskilab3.RecyclerViewHelpers.MoviesAdapter
import cybulski.tomasz.tomaszcybulskilab3.R
import cybulski.tomasz.tomaszcybulskilab3.RecyclerViewHelpers.RecyclerTouchListener
import android.support.v7.widget.helper.ItemTouchHelper
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var moviesList: MutableList<Movie> = ArrayList()
    private var recyclerView: RecyclerView? = null
    private var moviesAdapter: MoviesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = recycler_view

        moviesAdapter = MoviesAdapter(moviesList)

        setupRecyclerView()
        prepareMovieData()
        initSwipe()
    }

    private fun setupRecyclerView() {
        recyclerView!!.setHasFixedSize(true)
        val movieLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(applicationContext)
        recyclerView!!.layoutManager = movieLayoutManager
        recyclerView!!.itemAnimator = DefaultItemAnimator()
        recyclerView!!.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        recyclerView!!.adapter = moviesAdapter

        recyclerView!!.addOnItemTouchListener(RecyclerTouchListener(applicationContext,
                recyclerView!!, object : IClickListener {
            override fun onClick(view: View, position: Int) {
                val movie = moviesList[position]
                val movieDetailsIntent = Intent(this@MainActivity, MovieDetailsActivity::class.java)
                movieDetailsIntent.putExtra(getString(R.string.intent_extra_title), movie.title)
                movieDetailsIntent.putExtra(getString(R.string.intent_extra_picture), movie.pictureId)
                movieDetailsIntent.putExtra(getString(R.string.intent_extra_description), movie.description)
                
                startActivity(movieDetailsIntent)
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
        moviesList.add(Movie("Mad Max: Fury Road", "Action & Adventure", "2015",
                R.drawable.madmax, getString(R.string.mad_max_fury_road_description)))
        moviesList.add(Movie("Inside Out", "Animation, Kids & Family", "2015",
                R.drawable.insideout, getString(R.string.inside_out_description)))
        //moviesList.add(Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015",
         //       R.drawable.starwars, getString(R.string.star_wars_description)))
        //moviesList.add(Movie("Shaun the Sheep", "Animation", "2015",
        //        R.drawable.shaun, getString(R.string.shaun_the_ship_description)))
        //moviesList.add(Movie("The Martian", "Science Fiction & Fantasy", "2015",
         //       R.drawable.martian, getString(R.string.the_martian_description)))
        //moviesList.add(Movie("Mission: Impossible Rogue Nation", "Action", "2015",
        //       R.drawable.missionimpossible, getString(R.string.mission_impossible_description)))
        //moviesList.add(Movie("Up", "Animation", "2009",
        //        R.drawable.up, getString(R.string.up_description)))
        //moviesList.add(Movie("Star Trek", "Science Fiction", "2009",
        //        R.drawable.startrek, getString(R.string.star_trek_description)))
        //moviesList.add(Movie("The LEGO Movie", "Animation", "2014",
        //        R.drawable.lego, getString(R.string.the_lego_movie_description)))
       // moviesList.add(Movie("Iron Man", "Action & Adventure", "2008",
        //        R.drawable.ironman, getString(R.string.iron_man_description)))
        //moviesList.add(Movie("Aliens", "Science Fiction", "1986",
        //        R.drawable.aliens, getString(R.string.aliens_description)))
        //moviesList.add(Movie("Chicken Run", "Animation", "2000",
         //       R.drawable.chickenrun, getString(R.string.chicken_run_description)))
        //moviesList.add(Movie("Back to the Future", "Science Fiction", "1985",
        //        R.drawable.backtothefuture,  getString(R.string.back_to_the_future_description)))
        //moviesList.add(Movie("Raiders of the Lost Ark", "Action & Adventure", "1981",
         //       R.drawable.raidersoflostarc, getString(R.string.raiders_of_the_lost_ark_description)))
        //moviesList.add(Movie("Goldfinger", "Action & Adventure", "1965",
         //       R.drawable.goldfinger, getString(R.string.goldfinger_description)))
        //moviesList.add(Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014",
          //      R.drawable.guardians, getString(R.string.guardians_of_the_galaxy_description)))

        moviesAdapter!!.notifyDataSetChanged()
    }

    private fun initSwipe() {
        val simpleItemTouchCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition

                if (direction == ItemTouchHelper.LEFT) {
                    moviesAdapter!!.removeItem(position)
                }
            }
        }
        val itemTouchHelper = ItemTouchHelper(simpleItemTouchCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }
}
