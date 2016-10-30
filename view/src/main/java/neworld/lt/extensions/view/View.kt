package neworld.lt.extensions.view

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * @author Andrius Semionovas
 * @since 2016-10-30
 */

/**
 * Use this carefully if you really know that you wrote [Int]
 */
fun View.gone() {
    this.visibility = View.GONE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.isVisible() = this.visibility == View.VISIBLE
fun View.isGone() = this.visibility == View.GONE
/**
 * Makes [View] visible if [clause] return [true]. Otherwise invokes [or] which is [gone] by default
 */
fun View.visibleIf(visible: Boolean, or: View.() -> Unit = { gone() }) {
    if (visible) {
        visible()
    } else {
        or()
    }
}

fun View.invisibleIf(visible: Boolean) {
    visibleIf(!visible, { invisible() })
}

fun View.goneIf(visible: Boolean) {
    visibleIf(!visible)
}

fun <T : View> View.findById(id: Int): T = findViewById(id) as T

fun ViewGroup.inflate(@LayoutRes resId: Int, addToParent: Boolean = false): View {
    return LayoutInflater.from(context).inflate(resId, this, addToParent)
}
