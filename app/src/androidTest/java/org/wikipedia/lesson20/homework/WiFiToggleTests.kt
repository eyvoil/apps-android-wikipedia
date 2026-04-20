package org.wikipedia.lesson20.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson08.homework.ExploreScreen
import org.wikipedia.lesson09.homework.OnboardingScreen
import org.wikipedia.lesson13.homework.SearchScreen
import org.wikipedia.lesson18.homework.ExploreNamedScreen.CardNamedItem
import org.wikipedia.lesson18.homework.ExploreNamedScreen.ExploreNamedScreen
import org.wikipedia.lesson18.homework.OnboardingNamedScreen.OnboardingNamedScreen
import org.wikipedia.lesson18.homework.getByIndex
import org.wikipedia.lesson19.homework.SettingScreen
import org.wikipedia.lesson19.homework.action
import org.wikipedia.lesson19.homework.verify
import org.wikipedia.main.MainActivity

class WiFiToggleTests : TestCase() {
    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun verifyThirdTopReadBlockImageOnExplore() {
        run {
            step("Пропустить онбординг") {
                OnboardingScreen.skipButton.multiAction("Skip")
            }

            ExploreScreen {
                verify.isDisplayed(searchField)
                action.click(searchField)
            }
        }
    }
}