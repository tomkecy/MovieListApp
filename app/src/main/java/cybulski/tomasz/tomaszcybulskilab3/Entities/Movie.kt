package cybulski.tomasz.tomaszcybulskilab3.Entities

import android.widget.ImageView

/**
 * Created by tomcy on 18.04.2017.
 */

class Movie {
    var title: String? = null
    var genre: String? = null
    var year: String? = null
    var pictureId: Int = 0
    var seen: Boolean = false

    constructor(title: String, genre: String, year: String, pictureId: Int) {
        this.title = title
        this.genre = genre
        this.year = year
        this.pictureId = pictureId
    }
}