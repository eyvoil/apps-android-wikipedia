package org.wikipedia.lesson10.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class OnboardingUiTest : TestCase() {

    @get:Rule
    val testContext = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun firstSlide() {
        run {
            step("Проверит текст на первом экране онбординга") {
                OnboardingUiScreen {
                    primaryText.isDisplayed()
                    primaryText.hasText("The Free Encyclopedia\n…in over 300 languages")

                    secondaryText.isDisplayed()
                    secondaryText.hasText("We’ve found the following on your device:")
                }
            }
            step("Проверит кнопки на первом слайде онбординга") {
                OnboardingUiScreen {
                    skipButton.isDisplayed()
                    skipButton.hasText("Skip")
                    continueButton.isDisplayed()
                    continueButton.hasText("Continue")
                    addLanguageButton.isDisplayed()
                    addLanguageButton.hasText("Add or edit languages")
                }
            }
        }
    }

    @Test
    fun openSecondSlide() {
        run{
            OnboardingUiScreen {
                step("Проверит отображение кнопки Continue") {
                    continueButton.isDisplayed()
                }
                step("Нажмет кнопку Continue") {
                    continueButton.click()
                }

                step("Проверит текст второго слайда онбординга") {
                    primaryText.isDisplayed()
                    primaryText.hasText("New ways to explore")
                    secondaryText.isDisplayed()
                    secondaryText.containsText("Dive down the Wikipedia")
                }
            }
        }
    }

    @Test
    fun openThirdSlide() = run {

        OnboardingUiScreen {
            step("Проверит отображение кнопки Continue") {
                continueButton.isDisplayed()
            }
            step("Нажмет кнопку Continue") {
                continueButton.click()
            }
            step("Проверит текст второго слайда онбординга") {
                primaryText.isDisplayed()
                primaryText.hasText("New ways to explore")
            }
            step("Нажмет кнопку Continue") {
                continueButton.click()
            }
            step("Проверит текст третьего слайда онбординга") {
                primaryText.isDisplayed()
                primaryText.hasText("Reading lists with sync")
                secondaryText.isDisplayed()
                secondaryText.containsText("You can make reading lists")
            }
        }
    }

    @Test
    fun openFourthSlide() = run {

        OnboardingUiScreen {
            step("Проверит отображение кнопки Continue") {
                continueButton.isDisplayed()
            }
            step("Нажмет кнопку Continue") {
                continueButton.click()
            }
            step("Проверит текст второго слайда онбординга") {
                primaryText.isDisplayed()
                primaryText.hasText("New ways to explore")
            }
            step("Нажмет кнопку Continue") {
                continueButton.click()
            }
            step("Проверит текст третьего слайда онбординга") {
                primaryText.isDisplayed()
                primaryText.hasText("Reading lists with sync")
            }
            step("Нажмет кнопку Continue") {
                continueButton.click()
            }
            step("Проверит текст четвертого слайда онбординга") {
                primaryText.isDisplayed()
                primaryText.hasText("Data & Privacy")
                secondaryText.isDisplayed()
                secondaryText.containsText("We believe that you should")
            }
        }
    }
}