package org.wikipedia.lesson18.homework.OnboardingNamedScreen

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homework.NamedScreen
import org.wikipedia.lesson18.homework.name
import org.wikipedia.lesson18.homework.withParent
import org.wikipedia.onboarding.OnboardingPageView

object OnboardingNamedScreen : NamedScreen<OnboardingNamedScreen>() {

    override val screenName = "Экран онбординга"
    override val layoutId = R.layout.fragment_onboarding_pager
    override val viewClass = OnboardingPageView::class.java

    val pager = KViewPager2(
        builder = {
            withId(R.id.fragment_pager)
        },
        itemTypeBuilder = {
            itemType(::PagerItem)
        }
    ).name(withParent("Слайдер"))

    class PagerItem(matcher: Matcher<View>) : KViewPagerItem<PagerItem>(matcher) {

        val image by lazy {
            KImageView(matcher) {
                withId(R.id.imageViewCentered)
            }.name(withParent("Картинка"))
        }
        val title by lazy {
            KTextView(matcher) {
                withId(R.id.primaryTextView)
            }.name(withParent("Заголовок"))
        }

        val addLanguageButton by lazy {
            KButton {
                withId(R.id.addLanguageButton)
            }.name(withParent("Кнопка добавления языка"))
        }

        val languages by lazy {
            KRecyclerView(
                parent = matcher,
                builder = {
                    withId(R.id.languagesList)
                },
                itemTypeBuilder = {
                    itemType(::LanguageItem)
                }
            ).name(withParent("Список языков"))
        }
    }

    val skipButton = KButton {
        withId(R.id.fragment_onboarding_skip_button)
    }.name(withParent("Кнопка Skip"))

    val continueButton = KButton {
        withId(R.id.fragment_onboarding_forward_button)
    }.name(withParent("Кнопка Continue"))

    class LanguageItem(matcher: Matcher<View>) : KRecyclerItem<LanguageItem>(matcher),
        TextViewAssertions
}