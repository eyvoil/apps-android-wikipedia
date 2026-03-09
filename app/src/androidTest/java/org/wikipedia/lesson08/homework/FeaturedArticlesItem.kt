package org.wikipedia.lesson08.homework

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class FeaturedArticlesItem(matcher: Matcher<View>) : KRecyclerItem<FeaturedArticlesItem>(matcher) {
    val title = KTextView(matcher) {
        withId(R.id.view_card_header_title)
    }
}