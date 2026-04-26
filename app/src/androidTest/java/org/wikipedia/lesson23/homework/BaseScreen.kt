package org.wikipedia.lesson23.homework

import com.kaspersky.kaspresso.screens.KScreen
import org.wikipedia.R
import org.wikipedia.lesson18.homework.NameHierarchy
import org.wikipedia.onboarding.OnboardingPageView

abstract class BaseScreen<T: BaseScreen<T>>: KScreen<T>() {
    override val layoutId = null
    override val viewClass = null

    abstract val screenName: String

    private val nameHierarchy by lazy {
        NameHierarchy(screenName)
    }

    fun withParent(name: String): NameHierarchy {
        return NameHierarchy(name, nameHierarchy)
    }
}