package org.wikipedia.lesson08.homework

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class TopReadItem(matcher: Matcher<View>) : KRecyclerItem<TopReadItem>(matcher) {
    val title = KTextView(matcher) {
        withId(R.id.view_card_header_title)
    }

    val menuButton = KButton(matcher) {
        withId(R.id.view_list_card_header_menu)
    }

    val cardsList = KRecyclerView(
        builder = { withId(R.id.view_list_card_list) },
        itemTypeBuilder = {
            itemType(::CardItem)
        }
    )

    val footerButton = KButton(matcher) {
        withId(R.id.footerActionButton)
        withText(R.string.view_top_read_card_action)
    }
}