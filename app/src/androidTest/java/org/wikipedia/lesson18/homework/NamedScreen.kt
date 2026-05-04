package org.wikipedia.lesson18.homework

import com.kaspersky.kaspresso.screens.KScreen

abstract class NamedScreen <T : NamedScreen<T>> : KScreen<T>() {

    abstract val screenName: String
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    private val nameHierarchy by lazy {
        NameHierarchy(screenName)
    }

    fun withParent(name: String): NameHierarchy {
        return NameHierarchy(name, nameHierarchy)
    }
}