package org.wikipedia.lesson22.homework.widgets

import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.progress.KSeekBar
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.lesson18.homework.name
import org.wikipedia.lesson18.homework.withParent

class TextSizeSettingWidget(builder: ViewBuilder.() -> Unit) :
    KWidget<TextSizeSettingWidget>(builder) {
    val nameCategory by lazy {
        KTextView(matcher) {
            withId(R.id.textSettingsCategory)
        }.name(withParent("Название категории Чтение"))
    }

    val textSizePercent by lazy {
        KTextView(matcher) {
            withId(R.id.text_size_percent)
        }.name(withParent("Размер текста в процентах"))
    }

    val decreaseSizeButton by lazy {
        KTextView(matcher) {
            withId(R.id.buttonDecreaseTextSize)
        }.name(withParent("Кнопка уменьшения текст"))
    }

    val increaseSizeButton by lazy {
        KTextView(matcher) {
            withId(R.id.buttonIncreaseTextSize)
        }.name(withParent("Кнопка увеличения текст"))
    }

    val seekBar by lazy {
        KSeekBar(matcher) {
            withId(R.id.text_size_seek_bar)
        }.name(withParent("Слайдер"))
    }
}