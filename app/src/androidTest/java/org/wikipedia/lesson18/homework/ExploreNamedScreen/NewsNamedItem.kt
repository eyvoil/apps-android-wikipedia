package org.wikipedia.lesson18.homework.ExploreNamedScreen

import android.view.View
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homework.name
import org.wikipedia.lesson18.homework.withParent

class NewsNamedItem(matcher: Matcher<View>) : KRecyclerItem<NewsNamedItem>(matcher) {
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

    val newsList by lazy {
        KViewPager2(
            builder = { withId(R.id.news_cardview_recycler_view) },
            itemTypeBuilder = {
                itemType(::NewsCardNamedItem)
            }
        ).name(withParent("Список новостей"))
    }
}