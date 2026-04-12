package org.wikipedia.lesson19.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson18.homework.ExploreNamedScreen.CardNamedItem
import org.wikipedia.lesson18.homework.ExploreNamedScreen.ExploreNamedScreen
import org.wikipedia.lesson18.homework.OnboardingNamedScreen.OnboardingNamedScreen
import org.wikipedia.lesson18.homework.getByIndex
import org.wikipedia.lesson18.homework.invokeWithText
import org.wikipedia.main.MainActivity

private val steps = mutableMapOf<String, StepsDsl<*>>()


class ExploreTestsTestCase() : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun verifyThirdTopReadBlockImageOnExplore() {
        run {
            step("Пропустить онбординг") {
                action.click(OnboardingNamedScreen.skipButton)
            }

            step("Проверить отображение картинки в третьем блоке Top Read") {
                ExploreNamedScreen.topReadBlock {
                    cardsList {
                        val thirdCard = getByIndex<CardNamedItem>(2)
                        thirdCard {
                            image {
                                isDisplayed()
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    fun verifyLinkPreviewsDisabledInSettings() {
        run {
            step("Пропустить онбординг") {
                action.click(OnboardingNamedScreen.skipButton)
            }
            step("Открыть нижнюю панель") {
                action.click(ExploreNamedScreen.menuButton)
            }
            step("Перейти в Settings") {
                action.click(BottomSheet.settings)
            }
            step("Выключить Show link previews") {
                SettingScreen.items {
                    invokeWithText<SettingScreen.ItemWithSwitch>("Show link previews") {
                        switch {
                            click()
                        }
                    }
                }
            }
            step("Проверить, что Show link previews выключен") {
                SettingScreen.items {
                    invokeWithText<SettingScreen.ItemWithSwitch>("Show link previews") {
                        switch {
                            isNotSelected()
                        }
                    }
                }
            }
        }
    }
}