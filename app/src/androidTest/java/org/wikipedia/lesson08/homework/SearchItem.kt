package org.wikipedia.lesson08.homework

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.textview.MaterialTextView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class SearchItem(matcher: Matcher<View>) : KRecyclerItem<SearchItem>(matcher) {
    val icon = KImageView(matcher) {
        isInstanceOf(AppCompatImageView::class.java)
    }
    val search = KTextView(matcher) {
        isInstanceOf(MaterialTextView::class.java)
        withText(R.string.search_hint)
    }
    val voiceButton = KButton(matcher) {
        withId(R.id.voice_search_button)
    }
}