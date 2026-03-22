package org.wikipedia.lesson08.homework

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.feed.view.FeedView

object ExploreScreen : KScreen<ExploreScreen>() {
    override val layoutId: Int? = R.layout.fragment_feed
    override val viewClass: Class<*>? = FeedView::class.java

    val logo = KImageView {
        withId(R.id.main_toolbar_wordmark)
    }

    val searchField = KEditText {
        withText(R.string.search_hint)
    }

    val cardsList = KRecyclerView(
        builder = { withId(R.id.feed_view) },
        itemTypeBuilder = {
            itemType(::SearchItem)
            itemType(::AnnouncementItem)
            itemType(::DayItem)
            itemType(::TopReadItem)
            itemType(::NewsItem)
            itemType(::FeaturedArticlesItem)
        }
    )

    val cannotLoadText = KTextView {
        withText(R.string.view_offline_card_text)
    }

    val retryButton = KButton {
        withText(R.string.article_load_error_retry)
    }
}
