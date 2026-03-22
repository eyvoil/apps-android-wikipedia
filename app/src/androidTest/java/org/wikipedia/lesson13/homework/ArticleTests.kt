package org.wikipedia.lesson13.homework

import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson08.homework.ExploreScreen
import org.wikipedia.lesson09.homework.OnboardingScreen
import org.wikipedia.lesson13.homework.ArticleScreen.webView
import org.wikipedia.main.MainActivity

class ArticleTests : TestCase() {
    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun articleNavigation() {
        run {
            val articleName = "Existential crisis"

            step("Пропустит экран онбординга") {
                OnboardingScreen {
                    skipButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Нажмет на поле поиска") {
                ExploreScreen {
                    searchField.isDisplayed()
                    searchField.click()
                }
            }

            step("Найдет статью '$articleName'") {
                SearchScreen {
                    searchField {
                        isDisplayed()
                        click()
                        replaceText(articleName)
                    }
                    val article = UiTextView {
                        withIndex(1) { containsText("Existential") }
                    }
                    article {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Проверит содержимое статьи") {
                step("Проверит элемент References в статье") {
                    Thread.sleep(5_000)
                    webView {
                        withElement(Locator.ID, "References") {
                            scroll()
                        }

                        Thread.sleep(5_000)
                        withElement(Locator.XPATH, "(//a[@class=\"reference-link\"])[5]") {
                            scroll()
                            click()
                        }

                        Thread.sleep(5_000)
                    }

                    step("Проверит нижнюю шторку") {
                        BottomSheets {
                            title {
                                isDisplayed()
                                hasText("Reference ")
                            }
                            list.childWith<BottomSheets.Item> {
                                withDescendant { withText("5.") }
                            } perform {
                                id.isDisplayed()
                                text.isDisplayed()
                                image.isDisplayed()
                            }
                        }
                    }

                    step("Нажмет назад") {
                        device.uiDevice.pressBack()
                    }

                    step("Найдет ссылку с классом mw-redirect и кликнет") {
                        webView {
                            Thread.sleep(5_000)
                            withElement(Locator.XPATH, "//a[@class=\"mw-redirect\"])[2]") {
                                scroll()
                                click()
                            }

                            Thread.sleep(5_000)
                        }
                    }

                    step("Откроет новую статью") {
                        ArticleScreen {
                            readArticleButton {
                                isDisplayed()
                                click()
                            }
                        }
                    }
                    step("Проскролит до References") {
                        ArticleScreen {
                            webView {
                                withElement(Locator.ID, "References") {
                                    scroll()
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}