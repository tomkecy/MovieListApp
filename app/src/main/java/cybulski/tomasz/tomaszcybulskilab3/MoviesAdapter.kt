package cybulski.tomasz.tomaszcybulskilab3

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import cybulski.tomasz.tomaszcybulskilab3.Entities.Movie
import kotlinx.android.synthetic.main.movie_list_row.view.*

/**
 * Created by tomcy on 18.04.2017.
 */
class MoviesAdapter(var moviesList: List<Movie>): RecyclerView.Adapter<MoviesAdapter.MyViewHolder>(){
    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var title: TextView = view.text_view_title
        var genre: TextView = view.text_view_genre
        var year: TextView = view.text_view_year
        var seen: ImageView = view.image_view_marked_seen
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent!!.context)
                .inflate(R.layout.movie_list_row, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        val movie: Movie = moviesList[position]
        holder!!.title.text = movie.title
        holder.genre.text = movie.genre
        holder.year.text = movie.year
        holder.seen.visibility = if (movie.seen) View.VISIBLE else View.INVISIBLE
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }
}