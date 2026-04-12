package org.wikipedia.lesson18.homework.ExploreNamedScreen

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homework.name
import org.wikipedia.lesson18.homework.withParent

class DayNamedItem(matcher: Matcher<View>) : KRecyclerItem<DayNamedItem>(matcher) {
    val dayText by lazy {
        KTextView(matcher) {
            withId(R.id.day_header_text)
        }.name(withParent("Дата"))
    }
}