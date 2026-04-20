package org.wikipedia.lesson21.homework

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.lesson18.homework.getName
import org.wikipedia.lesson18.homework.name

inline fun <reified T : KRecyclerItem<*>> KRecyclerView.invokeAtIndexAndClass(
    index: Int,
    clazz: Class<out View>,
    limit: Int = 10,
    skipItems: Int = 0,
    name: String = "$index",
    function: T.() -> Unit
) {
    val recycler = this
    var currentIndex = 0
    var isElementFoundByIndex = false
    val lastIndex = (limit + skipItems).coerceAtMost(getSize()) - 1
    val firstIndex = skipItems.coerceAtMost(lastIndex)
    for (i in firstIndex..lastIndex) {
        childAt<T>(i) {
            val isElementContainsView = this.hasClassOrChildWithClass(clazz)
            if (isElementContainsView && index == currentIndex++) {
                isElementFoundByIndex = true
                name(recycler.getName().withParent(name))
                function()
            }
        }
        if (isElementFoundByIndex) break
    }
    if (!isElementFoundByIndex) {
        throw IllegalStateException("Элемент с индексом $index в пределах ${lastIndex + 1} элементов не найден")
    }
}

inline fun <reified T : KRecyclerItem<*>> KRecyclerView.invokeAtIndexAndResId(
    index: Int,
    resourceIdContains: Int,
    limit: Int = 10,
    skipItems: Int,
    name: String = "$index",
    function: T.() -> Unit
) {
    val recycler = this
    var currentIndex = 0
    var isElementFoundByIndex = false
    val lastIndex = (limit + skipItems).coerceAtMost(getSize()) - 1
    val firstIndex = skipItems.coerceAtMost(lastIndex)
    for (i in firstIndex..lastIndex) {
        childAt<T>(i) {
            val isElementContainsView = this.hasIdOrChildWithId(resourceIdContains)
            if (isElementContainsView && index == currentIndex++) {
                isElementFoundByIndex = true
                name(recycler.getName().withParent(name))
                function()
            }
        }
        if (isElementFoundByIndex) break
    }
    if (!isElementFoundByIndex) {
        throw IllegalStateException("Элемент с индексом $index в пределах ${lastIndex + 1} элементов не найден")
    }
}