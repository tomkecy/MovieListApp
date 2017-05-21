package cybulski.tomasz.tomaszcybulskilab3.Activities

import android.net.Uri
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.view.Menu
import android.view.MenuItem
import cybulski.tomasz.tomaszcybulskilab3.Activities.Fragments.CastFragment
import cybulski.tomasz.tomaszcybulskilab3.Activities.Fragments.ContainerFragment
import cybulski.tomasz.tomaszcybulskilab3.Activities.Fragments.DetailsFragment
import cybulski.tomasz.tomaszcybulskilab3.Activities.Fragments.MoviePicturesFragment

import cybulski.tomasz.tomaszcybulskilab3.R
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetailsActivity : FragmentActivity (), ContainerFragment.OnFragmentInteractionListener,
        CastFragment.OnFragmentInteractionListener, DetailsFragment.OnFragmentInteractionListener,
MoviePicturesFragment.OnFragmentInteractionListener{

    /**
     * The [android.support.v4.view.PagerAdapter] that will provide
     * fragments for each of the sections. We use a
     * [FragmentPagerAdapter] derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * [android.support.v4.app.FragmentStatePagerAdapter].
     */
    private val NUMBER_OF_PAGES = 2
    private var sectionsPagerAdapter: SectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
    /**
     * The [ViewPager] that will host the section contents.
     */


    private var movieTitle: String? = null
    private var movieDescription: String? = null
    private var moviePictureId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        movieTitle = intent.getStringExtra(getString(R.string.intent_extra_title))
        moviePictureId = intent.getIntExtra(getString(R.string.intent_extra_picture),0)
        movieDescription = intent.getStringExtra(getString(R.string.intent_extra_description))

        container.adapter = sectionsPagerAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_details, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return super.onOptionsItemSelected(item)
    }

    override fun onFragmentInteraction(uri: Uri) {

    }

    /**
     * A [FragmentPagerAdapter] that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            when (position) {
                0 -> return DetailsFragment.newInstance(movieTitle!!, movieDescription!!, moviePictureId!!)
                1 -> return ContainerFragment.newInstance()
            }
            return DetailsFragment.newInstance(movieTitle!!, movieDescription!!, moviePictureId!!)
        }

        override fun getCount(): Int {
            return NUMBER_OF_PAGES
        }

        override fun getPageTitle(position: Int): CharSequence? {
            when (position) {
                0 -> return "SECTION 1"
                1 -> return "SECTION 2"
                2 -> return "SECTION 3"
            }
            return null
        }
    }
}
