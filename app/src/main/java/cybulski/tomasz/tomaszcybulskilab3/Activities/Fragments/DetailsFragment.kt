package cybulski.tomasz.tomaszcybulskilab3.Activities.Fragments



import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import cybulski.tomasz.tomaszcybulskilab3.R
import kotlinx.android.synthetic.main.fragment_details.*


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [DetailsFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [DetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailsFragment : Fragment() {

  //  private var mListener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val DETAILS_VIEW = inflater!!.inflate(R.layout.fragment_details, container, false)
        
        //text_view_movie_title.text = arguments.getString(MOVIE_TITLE_KEY)
        //text_view_movie_description.text = arguments.getString(MOVIE_DESCRIPTION_KEY)
        //image_view_movie_picture.setImageResource(arguments.getInt(MOVIE_PICTURE_ID_KEY))

        return DETAILS_VIEW
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

    }

    override fun onDetach() {
        super.onDetach()
        //mListener = null
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
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val MOVIE_TITLE_KEY = "movie_title_key"
        private val MOVIE_DESCRIPTION_KEY = "movie_description_key"
        private val MOVIE_PICTURE_ID_KEY = "movie_picture_id_key"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.

         * @param movieTitle Parameter 1.
         * *
         * @param movieDescription Parameter 2.
         * *
         * @return A new instance of fragment DetailsFragment.
         */
        fun newInstance(movieTitle: String, movieDescription: String, moviePictureId: Int): DetailsFragment {
            val fragment = DetailsFragment()
            val args = Bundle()
            args.putString(MOVIE_TITLE_KEY, movieTitle)
            args.putString(MOVIE_DESCRIPTION_KEY, movieDescription)
            args.putInt(MOVIE_PICTURE_ID_KEY, moviePictureId)
            fragment.arguments = args
            return fragment
        }
    }
}// Required empty public constructor
