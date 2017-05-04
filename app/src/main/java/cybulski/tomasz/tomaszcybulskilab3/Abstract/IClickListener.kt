package cybulski.tomasz.tomaszcybulskilab3.Abstract
import android.view.View

/**
 * Created by tomcy on 19.04.2017.
 */
interface IClickListener {
    fun onClick(view: View, position: Int)
    fun onLongClick(view: View, position: Int)
}