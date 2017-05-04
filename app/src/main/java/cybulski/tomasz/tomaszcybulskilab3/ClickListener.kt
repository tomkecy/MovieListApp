package cybulski.tomasz.tomaszcybulskilab3
import android.view.View

/**
 * Created by tomcy on 19.04.2017.
 */
interface ClickListener {
    fun onClick(view: View, position: Int)
    fun onLongClick(view: View, position: Int)
}