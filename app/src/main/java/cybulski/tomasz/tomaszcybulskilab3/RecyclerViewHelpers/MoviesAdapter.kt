package cybulski.tomasz.tomaszcybulskilab3.RecyclerViewHelpers

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import cybulski.tomasz.tomaszcybulskilab3.Entities.Movie
import cybulski.tomasz.tomaszcybulskilab3.R
import kotlinx.android.synthetic.main.movie_list_row.view.*



/**
 * Created by tomcy on 18.04.2017.
 */
class MoviesAdapter(var moviesList: MutableList<Movie>): RecyclerView.Adapter<MoviesAdapter.MyViewHolder>(){

    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var title: TextView = view.text_view_title
        var genre: TextView = view.text_view_genre
        var year: TextView = view.text_view_year
        var seen: ImageView = view.image_view_marked_seen
        var picture: ImageView = view.image_view_picture
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        val context = parent!!.context
        val itemView: View
        val itemType = getItemViewType(viewType)
        if (itemType == 0) {
            itemView = LayoutInflater.from(context)
                    .inflate(R.layout.movie_list_row, parent, false)
        } else {
            itemView = LayoutInflater.from(context)
                    .inflate(R.layout.inversed_movie_list_row, parent, false)
        }
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        val movie: Movie = moviesList[position]
        holder!!.title.text = movie.title
        holder.genre.text = movie.genre
        holder.year.text = movie.year
        holder.seen.visibility = if (movie.seen) View.VISIBLE else View.INVISIBLE
        holder.picture.setImageResource(movie.pictureId)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun getItemViewType(position: Int): Int = position%2

    fun removeItem(position: Int) {
        moviesList.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, moviesList.size)
    }
}