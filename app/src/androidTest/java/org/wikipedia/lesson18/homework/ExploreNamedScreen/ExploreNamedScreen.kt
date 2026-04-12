package org.wikipedia.lesson18.homework.ExploreNamedScreen

import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.feed.view.FeedView
import org.wikipedia.lesson18.homework.NamedScreen
import org.wikipedia.lesson18.homework.invokeWithText
import org.wikipedia.lesson18.homework.name

object ExploreNamedScreen: NamedScreen<ExploreNamedScreen>() {

    override val screenName = "Экран Explore"
    override val layoutId: Int? = R.layout.fragment_feed
    override val viewClass: Class<*>? = FeedView::class.java

    val logo = KImageView {
        withId(R.id.main_toolbar_wordmark)
    }.name(withParent("Изображение логотипа"))

    val searchField = KEditText {
        withText(R.string.search_hint)
    }.name(withParent("Текст Search Wikipedia"))

    val cardsList = KRecyclerView(
        builder = { withId(R.id.feed_view) },
        itemTypeBuilder = {
            itemType(::SearchNamedItem)
            itemType(::AnnouncementNamedItem)
            itemType(::DayNamedItem)
            itemType(::TopReadNamedItem)
            itemType(::NewsNamedItem)
            itemType(::FeaturedArticlesNamedItem)
        }
    ).name(withParent("Блоки экрана Explore"))

    val cannotLoadText = KTextView {
        withText(R.string.view_offline_card_text)
    }.name(withParent("Текст с информацией, что контент не был загружен"))

    val retryButton = KButton {
        withText(R.string.article_load_error_retry)
    }.name(withParent("Кнопка Retry"))

    fun topReadBlock(fnc: TopReadNamedItem.() -> Unit) {
        cardsList.invokeWithText("Top read", fnc)
    }

    val menuButton = KButton {
        withId(com.google.android.material.R.id.navigation_bar_item_small_label_view)
        withText(R.string.nav_item_more)
    }.name(withParent("Кнопка More"))
}