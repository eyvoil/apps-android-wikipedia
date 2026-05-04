package org.wikipedia.lesson24.homework

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.google.android.material.textview.MaterialTextView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homework.ExploreNamedScreen.SearchNamedItem
import org.wikipedia.lesson18.homework.NamedScreen
import org.wikipedia.lesson18.homework.OnboardingNamedScreen.OnboardingNamedScreen.PagerItem
import org.wikipedia.lesson18.homework.OnboardingNamedScreen.OnboardingNamedScreen.pager
import org.wikipedia.lesson18.homework.invokeByIndex
import org.wikipedia.lesson18.homework.name
import org.wikipedia.lesson18.homework.withParent

object WikipediaLanguagesScreen : NamedScreen<WikipediaLanguagesScreen>() {
    override val screenName: String = "Экран языки Википедии"

    val items = KRecyclerView(
        builder = { withId(R.id.wikipedia_languages_recycler) },
        itemTypeBuilder = {
            itemType(::TitledItem)
            itemType(::LanguageListItem)
            itemType(::AddLanguageItem)
        }
    )
}

class TitledItem(matcher: Matcher<View>) : KRecyclerItem<TitledItem>(matcher) {
    val title by lazy {
        KTextView(matcher) {
            withId(R.id.section_header_text)
        }.name(withParent("Текст Ваши языки"))
    }
}

class LanguageListItem(matcher: Matcher<View>) : KRecyclerItem<LanguageItem>(matcher) {
    val number by lazy {
        KTextView(matcher) {
            withId(R.id.wiki_language_order)
        }.name(withParent("Номер языка"))
    }

    val language by lazy {
        KTextView(matcher) {
            withId(R.id.wiki_language_title)
        }.name(withParent("Название языка"))
    }
}

class AddLanguageItem(matcher: Matcher<View>) : KRecyclerItem<AddLanguageItem>(matcher) {
    val addLanguage by lazy {
        KTextView(matcher) {
            withId(R.id.wiki_language_title)
        }.name(withParent("Добавить язык"))
    }
}


