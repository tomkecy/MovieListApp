package cybulski.tomasz.tomaszcybulskilab3

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by tomcy on 18.04.2017.
 */
class DividerItemDecoration(context: Context, orientation: Int) : RecyclerView.ItemDecoration(){
    companion object {
        private val ATTRS: IntArray = intArrayOf(android.R.attr.listDivider)
        val HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL
        val VERTICAL_LIST = LinearLayoutManager.VERTICAL
    }

    private var mDivider: Drawable? = null
    private var mOrientation: Int? = null

    init {
        val a: TypedArray = context.obtainStyledAttributes(ATTRS)
        mDivider = a.getDrawable(0)
        a.recycle()
        setOrientation(orientation)
    }

   fun setOrientation(orientation: Int): Unit{
        if(orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST){
            throw IllegalArgumentException("Invalid orientation")
        }
       mOrientation = orientation
    }

    override fun onDraw(c: Canvas?, parent: RecyclerView?, state: RecyclerView.State?) {
        if(mOrientation == VERTICAL_LIST){
            drawVertical(c, parent)
        } else {
            drawHorizontal(c, parent)
        }
    }

    fun drawVertical(c: Canvas?, parent: RecyclerView?): Unit{
        val left = parent!!.paddingLeft
        val right = parent.width - parent.paddingRight
        val childCount = parent.childCount
        for (i in 0..childCount-1){
            val child: View = parent.getChildAt(i)
            val params = child.layoutParams as RecyclerView.LayoutParams
            val top = child.bottom + params.bottomMargin
            val bottom = top + mDivider!!.intrinsicHeight
            mDivider!!.setBounds(left, top, right, bottom)
            mDivider!!.draw(c)
        }
    }

    fun drawHorizontal(c: Canvas?, parent: RecyclerView?): Unit{
        val top = parent!!.paddingTop
        val bottom = parent.height - parent.paddingBottom
        val childCount = parent.childCount
        for(i in 0..childCount-1){
            val child = parent.getChildAt(i)
            val params = parent.layoutParams as RecyclerView.LayoutParams
            val left = child.right + params.rightMargin
            val right = left + mDivider!!.intrinsicHeight
            mDivider!!.setBounds(left, top, right, bottom)
            mDivider!!.draw(c)
        }
    }

    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        if(mOrientation == VERTICAL_LIST) {
            outRect!!.set(0, 0, 0, mDivider!!.intrinsicHeight)
        }else{
            outRect!!.set(0, 0, mDivider!!.intrinsicWidth, 0)
        }
    }



}