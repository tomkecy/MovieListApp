package cybulski.tomasz.tomaszcybulskilab3.Entities

import android.widget.ImageView

/**
 * Created by tomcy on 18.04.2017.
 */

class Movie {
    var title: String? = null
    var genre: String? = null
    var year: String? = null
    var picture: ImageView? = null
    var seen: Boolean = false

    constructor()
    constructor(title: String, genre: String, year: String) {
        this.title = title
        this.genre = genre
        this.year = year
    }
    constructor(title: String, genre: String, year: String, picture: ImageView) {
        this.title = title
        this.genre = genre
        this.year = year
        this.picture = picture
    }
}