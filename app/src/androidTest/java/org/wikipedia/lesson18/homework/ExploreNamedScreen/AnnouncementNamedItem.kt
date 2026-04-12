package org.wikipedia.lesson18.homework.ExploreNamedScreen

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homework.name
import org.wikipedia.lesson18.homework.withParent

class AnnouncementNamedItem(matcher: Matcher<View>) :
    KRecyclerItem<AnnouncementNamedItem>(matcher) {
    val headerImage by lazy {
        KImageView(matcher) {
            withId(R.id.view_announcement_header_image)
        }.name(withParent("Изображение заголовка"))
    }

    val text by lazy {
        KTextView(matcher) {
            withId(R.id.view_announcement_text)
        }.name(withParent("Текст"))
    }

    val positiveButton by lazy {
        KButton(matcher) {
            isDescendantOfA { withId(R.id.view_announcement_card_buttons_container) }
            withId(R.id.view_announcement_action_positive)
        }.name(withParent("Кнопка подтверждения"))
    }

    val negativeButton by lazy {
        KButton(matcher) {
            isDescendantOfA { withId(R.id.view_announcement_card_buttons_container) }
            withId(R.id.view_announcement_action_negative)
        }.name(withParent("Кнопка No thanks"))
    }

    val positiveDialogButton by lazy {
        KButton(matcher) {
            isDescendantOfA { withId(R.id.view_announcement_card_dialog_buttons_container) }
            withId(R.id.view_announcement_dialog_action_positive)
        }.name(withParent("Кнопка подтверждения диалога"))
    }

    val negativeDialogButton by lazy {
        KButton(matcher) {
            isDescendantOfA { withId(R.id.view_announcement_card_dialog_buttons_container) }
            withId(R.id.view_announcement_dialog_action_negative)
        }.name(withParent("Кнопка диалога No thanks"))
    }
}