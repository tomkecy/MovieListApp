package cybulski.tomasz.tomaszcybulskilab3.Abstract

/**
 * Created by tomcy on 10.05.2017.
 */
interface IItemTouchHelperAdapter {
    fun onItemMove(fromPosition: Int, toPosition: Int)
    fun onItemDismiss(position: Int)
}