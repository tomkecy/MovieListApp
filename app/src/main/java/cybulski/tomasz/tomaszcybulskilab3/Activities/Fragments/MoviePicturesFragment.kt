package cybulski.tomasz.tomaszcybulskilab3.Activities.Fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import cybulski.tomasz.tomaszcybulskilab3.R
import kotlinx.android.synthetic.main.fragment_movie_pictures.*
import kotlinx.android.synthetic.main.fragment_movie_pictures.view.*

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [MoviePicturesFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [MoviePicturesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MoviePicturesFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val movieFragmentView = inflater!!.inflate(R.layout.fragment_movie_pictures, container, false)
        movieFragmentView.image_view_picture_1.setImageResource(R.drawable.one)
        movieFragmentView.image_view_picture_2.setImageResource(R.drawable.two)
        movieFragmentView.image_view_picture_3.setImageResource(R.drawable.three)
        movieFragmentView.image_view_picture_4.setImageResource(R.drawable.four)
        movieFragmentView.image_view_picture_5.setImageResource(R.drawable.five)
        movieFragmentView.image_view_picture_6.setImageResource(R.drawable.six)
        return movieFragmentView
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html) for more information.
     */
    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.

         * @return A new instance of fragment MoviePicturesFragment.
         */
        fun newInstance(): MoviePicturesFragment {
            val fragment = MoviePicturesFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}// Required empty public constructor
