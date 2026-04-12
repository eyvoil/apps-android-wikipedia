package org.wikipedia.lesson18.homework.ExploreNamedScreen

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.textview.MaterialTextView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homework.name
import org.wikipedia.lesson18.homework.withParent

class SearchNamedItem(matcher: Matcher<View>) : KRecyclerItem<SearchNamedItem>(matcher) {
    val icon by lazy {
        KImageView(matcher) {
            isInstanceOf(AppCompatImageView::class.java)
        }.name(withParent("Иконка"))
    }
    val search by lazy {
        KTextView(matcher) {
            isInstanceOf(MaterialTextView::class.java)
            withText(R.string.search_hint)
        }.name(withParent("Текст Поиск по Википедии"))
    }
    val voiceButton by lazy {
        KButton(matcher) {
            withId(R.id.voice_search_button)
        }.name(withParent("Кнопка голосового ввода"))
    }
}