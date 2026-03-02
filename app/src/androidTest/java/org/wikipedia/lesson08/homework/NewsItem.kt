package org.wikipedia.lesson08.homework

import android.view.View
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class NewsItem(matcher: Matcher<View>) : KRecyclerItem<NewsItem>(matcher) {
    val title = KTextView(matcher) {
        withId(R.id.view_card_header_title)
    }

    val menuButton = KButton(matcher) {
        withId(R.id.view_list_card_header_menu)
    }

    val newsList = KViewPager2(
        builder = { withId(R.id.news_cardview_recycler_view) },
        itemTypeBuilder = {
            itemType(::NewsCardItem)
        }
    )
}