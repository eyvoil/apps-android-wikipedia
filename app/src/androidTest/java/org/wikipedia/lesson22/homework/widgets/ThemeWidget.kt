package org.wikipedia.lesson22.homework.widgets

import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.lesson18.homework.name
import org.wikipedia.lesson18.homework.withParent

class ThemeWidget(builder: ViewBuilder.() -> Unit) : KWidget<ThemeWidget>(builder) {
    val themeSwitch by lazy {
        KSwitch(matcher) {
            withId(R.id.theme_chooser_match_system_theme_switch)
        }.name(withParent("Свич выбора системной темы"))
    }

    val themeDarkButton by lazy {
        KButton(matcher) {
            withId(R.id.button_theme_dark)
        }.name(withParent("Кнопка включения темной темы"))
    }

    val themeBlackButton by lazy {
        KButton(matcher) {
            withId(R.id.button_theme_black)
        }.name(withParent("Кнопка включения черной темы"))
    }
}