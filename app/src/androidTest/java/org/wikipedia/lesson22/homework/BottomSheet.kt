package org.wikipedia.lesson22.homework

import org.wikipedia.R
import org.wikipedia.lesson18.homework.NamedScreen
import org.wikipedia.lesson18.homework.name
import org.wikipedia.lesson22.homework.widgets.ReadingFocusModeWidget
import org.wikipedia.lesson22.homework.widgets.TextSizeSettingWidget
import org.wikipedia.lesson22.homework.widgets.ThemeWidget

object BottomSheet : NamedScreen<BottomSheet>() {
    override val screenName: String = "Нижняя панель"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val textSizeSettingWidget by lazy {
        TextSizeSettingWidget {
            withId(com.google.android.material.R.id.design_bottom_sheet)
        }.name(withParent("Виджет настройки шрифта"))
    }

    val focusModeWidget by lazy {
        ReadingFocusModeWidget {
            withId(R.id.readingFocusModeContainer)
        }.name(withParent("Виджет Режим чтения"))
    }

    val themeWidget by lazy {
        ThemeWidget {
            withId(com.google.android.material.R.id.design_bottom_sheet)
        }.name(withParent("Виджет темы"))
    }
}