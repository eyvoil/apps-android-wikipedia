package org.wikipedia.lesson09.homework

import android.view.View
import androidx.appcompat.widget.AppCompatImageButton
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

object CustomizeFeedScreen : Screen<CustomizeFeedScreen>() {

    val featuredArticleTitle = KTextView {
        withText(R.string.view_featured_article_card_title)
    }

    val backButton = KImageView {
        withParent {
            withId(R.id.toolbar)
        }
        isInstanceOf(AppCompatImageButton::class.java)
    }
    val settingList = KRecyclerView(
        builder = {
            withId(R.id.content_types_recycler)
        },
        itemTypeBuilder = {
            itemType(::SettingItem)
        }
    )

    class SettingItem(matcher: Matcher<View>) : KRecyclerItem<SettingItem>(matcher) {
        val title = KTextView(matcher) {
            withId(R.id.feed_content_type_title)
        }
        val switch = KSwitch(matcher) {
            withId(R.id.feed_content_type_checkbox)
        }
    }
}