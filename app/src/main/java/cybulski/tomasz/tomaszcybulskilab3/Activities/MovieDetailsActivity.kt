package cybulski.tomasz.tomaszcybulskilab3.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cybulski.tomasz.tomaszcybulskilab3.R
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        text_view_movie_title.text = intent.getStringExtra(getString(R.string.intent_extra_title))
        image_view_movie_picture.setImageResource(intent.getIntExtra(getString(R.string.intent_extra_picture),0))
        text_view_movie_description.text = intent.getStringExtra(getString(R.string.intent_extra_description))

    }
}
