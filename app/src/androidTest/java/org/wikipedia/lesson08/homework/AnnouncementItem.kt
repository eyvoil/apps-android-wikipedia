package org.wikipedia.lesson08.homework

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class AnnouncementItem(matcher: Matcher<View>) : KRecyclerItem<AnnouncementItem>(matcher) {
    val headerImage = KImageView(matcher) {
        withId(R.id.view_announcement_header_image)
    }

    val text = KTextView(matcher) {
        withId(R.id.view_announcement_text)
    }

    val positiveButton = KButton(matcher) {
        isDescendantOfA { withId(R.id.view_announcement_card_buttons_container) }
        withId(R.id.view_announcement_action_positive)
    }

    val negativeButton = KButton(matcher) {
        isDescendantOfA { withId(R.id.view_announcement_card_buttons_container) }
        withId(R.id.view_announcement_action_negative)
    }

    val positiveDialogButton = KButton(matcher) {
        isDescendantOfA { withId(R.id.view_announcement_card_dialog_buttons_container) }
        withId(R.id.view_announcement_dialog_action_positive)
    }

    val negativeDialogButton = KButton(matcher) {
        isDescendantOfA { withId(R.id.view_announcement_card_dialog_buttons_container) }
        withId(R.id.view_announcement_dialog_action_negative)
    }
}