package org.wikipedia.lesson19.homework

import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.lesson18.homework.NamedScreen

object BottomSheet : NamedScreen<BottomSheet>() {
    override val screenName = "Нижняя панель"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val settings = KTextView {
        withText("Settings")
    }
}