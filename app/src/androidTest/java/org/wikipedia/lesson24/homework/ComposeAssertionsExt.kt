package org.wikipedia.lesson24.homework

import io.github.kakaocup.compose.node.assertion.NodeAssertions

fun NodeAssertions.assertTrimmedTextIsEquals(expected: String) {
    delegate.check(TrimmedTextAssertions(expected))
}