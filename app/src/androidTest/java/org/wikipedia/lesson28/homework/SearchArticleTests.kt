package org.wikipedia.lesson28.homework

import com.kaspersky.components.kautomator.component.text.UiTextView
import io.qameta.allure.kotlin.Description
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson13.homework.SearchScreen
import org.wikipedia.lesson18.homework.ExploreNamedScreen.ExploreNamedScreen
import org.wikipedia.lesson18.homework.OnboardingNamedScreen.OnboardingNamedScreen
import org.wikipedia.lesson19.homework.action
import org.wikipedia.lesson23.homework.BaseTest

class SearchArticleTests : BaseTest() {

    @get:Rule
    val dataValidityRule = DataValidityRule()

    private fun searchArticle() {
        run {

            action.click(OnboardingNamedScreen.skipButton)

            action.click(ExploreNamedScreen.searchField)

            SearchScreen {
                searchField {
                    isDisplayed()
                    click()
                    replaceText(dataValidityRule.testData)
                }
            }
        }
    }

    @Test
    @Description("valid")
    fun validSearchArticle() {
        run {

            searchArticle()

            val article = UiTextView {
                withIndex(1) { containsText(dataValidityRule.testData) }
            }
            article {
                isDisplayed()
            }
        }
    }

    @Test
    @Description("no result")
    fun noSearchArticle() {
        run {

            searchArticle()

            SearchScreen {
                noResultText {
                    isDisplayed()
                }
            }
        }
    }
}