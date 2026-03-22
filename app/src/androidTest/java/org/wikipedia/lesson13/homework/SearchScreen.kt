package org.wikipedia.lesson13.homework

import com.kaspersky.components.kautomator.component.edit.UiEditText
import com.kaspersky.components.kautomator.screen.UiScreen

object SearchScreen : UiScreen<SearchScreen>() {
    override val packageName = "org.wikipedia.alpha"

    val searchField = UiEditText {
        withId(this@SearchScreen.packageName, "search_src_text")
    }
}