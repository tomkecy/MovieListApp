package cybulski.tomasz.tomaszcybulskilab3.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cybulski.tomasz.tomaszcybulskilab3.Activities.Fragments.DetailsFragment
import cybulski.tomasz.tomaszcybulskilab3.R

class MovieDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        val movieTitle = intent.getStringExtra(getString(R.string.intent_extra_title))
        val moviePictureId: Int = intent.getIntExtra(getString(R.string.intent_extra_picture),0)
        val movieDescription = intent.getStringExtra(getString(R.string.intent_extra_description))

        val detailsFragment = DetailsFragment.newInstance(movieTitle, movieDescription, moviePictureId)
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, detailsFragment)
        fragmentTransaction.commit()

    }
}
