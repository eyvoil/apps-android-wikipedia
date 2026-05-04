package org.wikipedia.lesson19.homework

import io.github.kakaocup.compose.node.action.NodeActions
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.switch.SwitchableActions
import org.wikipedia.lesson18.homework.getName
import org.wikipedia.lesson24.homework.getName

// Шаги действий
class Actions(private val steps: StepDefinitions) : StepsDsl<Actions>() {

    override val self = this

    fun click(element: BaseActions) {
        steps.click("Нажимает на '${element.getName()}'", element)
    }

    fun scrollTo(element: BaseActions) {
        element.scrollTo()
    }

    fun swipeSwitchLeft(element: SwitchableActions){
        element.swipeSwitchThumb (SwitchableActions.Direction.LEFT)
    }

    fun swipeSwitchRight(element: SwitchableActions){
        element.swipeSwitchThumb (SwitchableActions.Direction.RIGHT)
    }

    fun clickIfEnable(element: NodeActions){
        steps.clickIfEnable("Нажать на элемент ${element.getName()} если он отобржается", element)
    }
}