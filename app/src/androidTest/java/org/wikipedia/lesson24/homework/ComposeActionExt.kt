package org.wikipedia.lesson24.homework

import io.github.kakaocup.compose.node.action.NodeActions


fun NodeActions.clickIfEnabled() {
    delegate.perform(ClickIfEnabledAction())
}