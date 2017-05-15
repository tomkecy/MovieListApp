package cybulski.tomasz.tomaszcybulskilab3.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cybulski.tomasz.tomaszcybulskilab3.Activities.Fragments.DetailsFragment
import cybulski.tomasz.tomaszcybulskilab3.R

class MovieDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        val MOVIE_TITLE = intent.getStringExtra(getString(R.string.intent_extra_title))
        val MOVIE_PICTURE_ID: Int = intent.getIntExtra(getString(R.string.intent_extra_picture),0)
        val MOVIE_DESCRIPTION = intent.getStringExtra(getString(R.string.intent_extra_description))

        val DETAILS_FRAGMENT = DetailsFragment.newInstance(MOVIE_TITLE, MOVIE_DESCRIPTION, MOVIE_PICTURE_ID)
        val FRAGMENT_MANAGER = supportFragmentManager
        val FRAGMENT_TRANSACTION = FRAGMENT_MANAGER.beginTransaction()
        FRAGMENT_TRANSACTION.add(R.id.fragment_container, DETAILS_FRAGMENT)
        FRAGMENT_TRANSACTION.commit()

    }
}
