package org.wikipedia.lesson18.homework.ExploreNamedScreen

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homework.name
import org.wikipedia.lesson18.homework.withParent

class FeaturedArticlesNamedItem(matcher: Matcher<View>) : KRecyclerItem<FeaturedArticlesNamedItem>(matcher) {
    val title by lazy {
        KTextView(matcher) {
            withId(R.id.view_card_header_title)
        }.name(withParent("Заголовок"))
    }
}