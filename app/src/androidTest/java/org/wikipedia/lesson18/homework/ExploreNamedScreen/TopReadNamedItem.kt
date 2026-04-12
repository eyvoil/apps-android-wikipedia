package org.wikipedia.lesson18.homework.ExploreNamedScreen

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homework.name
import org.wikipedia.lesson18.homework.withParent

class TopReadNamedItem(matcher: Matcher<View>) : KRecyclerItem<TopReadNamedItem>(matcher) {
    val title by lazy {
        KTextView(matcher) {
            withId(R.id.view_card_header_title)
        }.name(withParent("Заголовок"))
    }

    val menuButton by lazy {
        KButton(matcher) {
            withId(R.id.view_list_card_header_menu)
        }.name(withParent("Кнопка меню"))
    }

    val cardsList by lazy {
        KRecyclerView(
            builder = { withId(R.id.view_list_card_list) },
            itemTypeBuilder = {
                itemType(::CardNamedItem)
            }
        ).name(withParent("Список в статей TopRead"))
    }

    val footerButton by lazy {
        KButton(matcher) {
            withId(R.id.footerActionButton)
            withText(R.string.view_top_read_card_action)
        }.name(withParent("Кнопка More top read"))
    }
}