package org.wikipedia.lesson19.homework

import io.github.kakaocup.compose.node.assertion.NodeAssertions
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.image.ImageViewAssertions
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.wikipedia.lesson18.homework.getName
import org.wikipedia.lesson23.homework.KWebViewElement

// Шаги проверок
class Verify(private val steps: StepDefinitions) : StepsDsl<Verify>() {

    override val self = this

    fun isDisplayed(element: BaseAssertions) {
        steps.isDisplayed(
            "Проверяет, что отображается '${(element as BaseActions).getName()}'",
            element
        )
    }

    fun isDisplayed(element: ImageViewAssertions) {
        steps.isDisplayed(
            "Проверяет, что отображается '${(element as BaseActions).getName()}'",
            element
        )
    }

    fun hasText(element: TextViewAssertions, text: String) {
        steps.hasText(
            "Проверяет что текст в элементе '${(element as BaseActions).getName()}' эквивалентен '$text'",
            element,
            text,
            false
        )
    }

    fun containsText(element: TextViewAssertions, text: String) {
        steps.hasText(
            "Проверяет что текст в элементе '${(element as BaseActions).getName()}' содержит подстроку '$text'",
            element,
            text,
            true
        )
    }

    fun doesNotExist(element: BaseAssertions) {
        steps.doesNotExist(
            "Проверяет, что элемент '${(element as BaseActions).getName()}' отсутствует",
            element
        )
    }

    fun isDisplayed(element: KWebViewElement) {
        steps.isDisplayed(
            "Проверяет, что отображается '${element.getName()}'",
            element
        )
    }

    fun isDisabled(element: BaseAssertions) {
        steps.isDisabled(
            "Проверяет, что отключено '${(element as BaseActions).getName()}'",
            element
        )
    }

    fun assertTrimmedTextIsEquals(element: NodeAssertions, expected: String){
        steps.assertTrimmedTextIsEquals(
            "Проверяет, что текст после обрезки пробелов совпадает с ожидаемым значением",
            element,
            expected
        )

    }
}