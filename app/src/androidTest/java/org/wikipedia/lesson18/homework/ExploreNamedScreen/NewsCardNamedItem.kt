package org.wikipedia.lesson18.homework.ExploreNamedScreen

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homework.name
import org.wikipedia.lesson18.homework.withParent

class NewsCardNamedItem(matcher: Matcher<View>) : KViewPagerItem<NewsCardNamedItem>(matcher) {
    val image by lazy {
        KImageView(matcher) {
            withId(R.id.horizontal_scroll_list_item_image)
        }.name(withParent("Изображение"))
    }

    val text by lazy {
        KTextView(matcher) {
            withId(R.id.horizontal_scroll_list_item_text)
        }.name(withParent("Текст"))
    }
}