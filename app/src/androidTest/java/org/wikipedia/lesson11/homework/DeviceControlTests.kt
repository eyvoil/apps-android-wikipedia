package org.wikipedia.lesson11.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import junit.framework.TestCase.assertFalse
import org.junit.Rule
import org.junit.Test
import org.wikipedia.R
import org.wikipedia.lesson08.homework.ExploreScreen
import org.wikipedia.lesson08.homework.FeaturedArticlesItem
import org.wikipedia.lesson10.homework.OnboardingUiScreen
import org.wikipedia.main.MainActivity

class DeviceControlTests : TestCase() {

    @get:Rule
    val testContext = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun rotateScreenTest() {
        before {
        }.after {
            device.uiDevice.setOrientationNatural()
        }.run {
            step("Установить ориентацию экрана landscape") {
                device.uiDevice.setOrientationLeft()
            }

            step("Проверить ориентацию экрана") {
                assertFalse(device.uiDevice.isNaturalOrientation)
            }
        }
    }

    @Test
    fun sleepWakeTest() {
        run {

            step("Выключит экран") {
                device.uiDevice.sleep()
            }

            step("Включит экран") {
                device.uiDevice.wakeUp()
            }

            step("Проверит отображение элементов экрана онбординга") {
                OnboardingUiScreen {
                    primaryText.isDisplayed()
                    secondaryText.isDisplayed()
                }
            }
        }
    }

    @Test
    fun backgroundRestoreTest() {
        run {
            step("Нажмет кнопку домой") {
                device.uiDevice.pressHome()
            }

            step("Откроет список последних открытых приложений") {
                device.uiDevice.pressRecentApps()
            }

            step("Открое приложение") {
                device.uiDevice.pressRecentApps()
            }

            step("Проверит отображение элементов экрана онбординга") {
                OnboardingUiScreen {
                    primaryText.isDisplayed()
                    secondaryText.isDisplayed()
                }
            }
        }
    }


    @Test
    fun openArticleWithoutInternetTest() {
        before {
            device.network.toggleMobileData(false)
            device.network.toggleWiFi(false)
        }.after {
            device.network.toggleMobileData(true)
            device.network.toggleWiFi(true)
        }.run {
            step("Пропустит экран онбординга") {
                OnboardingUiScreen {
                    skipButton.isDisplayed()
                    skipButton.click()
                }
            }

            step("Проверит отображение ошибки Нет сети") {
                ExploreScreen {
                    cannotLoadText.isDisplayed()
                    retryButton.isDisplayed()
                }
            }

            step("Включить сеть") {
                device.network.toggleMobileData(true)
                device.network.toggleWiFi(true)
            }

            step("Нажмет кнопку Retry") {
                ExploreScreen {
                    retryButton.click()
                }
            }

            step("Проверит, что появились статьи") {
                ExploreScreen {
                    cannotLoadText.doesNotExist()
                    cardsList.childWith<FeaturedArticlesItem> {
                        withDescendant { withText(R.string.view_featured_article_card_title) }
                    } perform {
                        isDisplayed()
                    }
                }
            }
        }
    }

    @Test
    fun changeLanguageTest() {
        before {
            device.uiDevice.executeShellCommand(
                "setprop persist.sys.locale fr-FR"
            )
            device.uiDevice.executeShellCommand("stop")
            device.uiDevice.executeShellCommand("start")
        }.after {
            device.uiDevice.executeShellCommand(
                "setprop persist.sys.locale ru-RU; stop; start"
            )
        }.run {
            step("Проверить текст кнопки") {
                OnboardingUiScreen {
                    skipButton.isDisplayed()
                    skipButton.hasText("Sauter")
                }
            }
        }
    }
}