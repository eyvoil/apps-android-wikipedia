package org.wikipedia.lesson13.homework

import android.view.View
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

object BottomSheets : KScreen<BottomSheets>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val title = KTextView {
        withId(R.id.reference_title_text)
    }

    val list = KRecyclerView(
        builder = { withId(R.id.feed_view) },
        itemTypeBuilder = {
            ::Item
        }
    )

    class Item(matcher: Matcher<View>) : KRecyclerItem<Item>(matcher) {
        val id = KTextView {
            withId(R.id.reference_id)
        }
        val text = KTextView {
            withId(R.id.reference_text)
        }
        val image = KTextView {
            withId(R.id.reference_ext_link)
        }
    }
}