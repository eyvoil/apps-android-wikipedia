package org.wikipedia.lesson18.homework.ExploreNamedScreen

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homework.name
import org.wikipedia.lesson18.homework.withParent

class CardNamedItem(matcher: Matcher<View>) : KRecyclerItem<CardNamedItem>(matcher) {
    val number by lazy {
        KTextView(matcher) {
            withId(R.id.numberView)
        }.name(withParent("Номер"))
    }

    val title by lazy {
        KTextView(matcher) {
            withId(R.id.view_list_card_item_title)
        }.name(withParent("Заголовок"))
    }

    val subtitle by lazy {
        KTextView(matcher) {
            withId(R.id.view_list_card_item_subtitle)
        }.name(withParent("Подзаголовок"))
    }

    val graph by lazy {
        KView(matcher) {
            withId(R.id.view_list_card_item_graph)
        }.name(withParent("Граф"))
    }

    val pageviews by lazy {
        KTextView(matcher) {
            withId(R.id.view_list_card_item_pageviews)
        }.name(withParent("Заголовок"))
    }

    val image by lazy {
        KImageView(matcher) {
            withId(R.id.view_list_card_item_image)
        }.name(withParent("Изображение"))
    }
}