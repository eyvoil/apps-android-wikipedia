package org.wikipedia.lesson19.homework

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homework.NamedScreen
import org.wikipedia.lesson18.homework.name
import org.wikipedia.lesson18.homework.withParent


object SettingScreen: NamedScreen<SettingScreen>() {
    override val screenName = "Экран Настроек"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val items by lazy {
        KRecyclerView(
            builder = { withId(R.id.recycler_view) },
            itemTypeBuilder = {
                itemType(::ItemWithSwitch)
            }
        ).name(withParent("Список настроек"))
    }

    class ItemWithSwitch(matcher: Matcher<View>) : KRecyclerItem<ItemWithSwitch>(matcher) {
        val title by lazy {
            KTextView(matcher) {
                withId(R.id.title)
            }.name(withParent("Заголовок"))
        }

        val switch by lazy {
            KTextView(matcher) {
                withId(R.id.switchWidget)
            }.name(withParent("Свитч"))
        }
    }
}

