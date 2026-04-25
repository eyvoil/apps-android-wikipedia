package org.wikipedia.lesson22.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.R
import org.wikipedia.lesson08.homework.ExploreScreen.cardsList
import org.wikipedia.lesson08.homework.FeaturedArticlesItem
import org.wikipedia.lesson18.homework.ExploreNamedScreen.ExploreNamedScreen
import org.wikipedia.lesson18.homework.ExploreNamedScreen.FeaturedArticlesNamedItem
import org.wikipedia.lesson18.homework.OnboardingNamedScreen.OnboardingNamedScreen
import org.wikipedia.lesson18.homework.invokeWithText
import org.wikipedia.lesson19.homework.action
import org.wikipedia.lesson19.homework.verify
import org.wikipedia.main.MainActivity

class WidgetTest : TestCase(Kaspresso.Builder.withForcedAllureSupport()) {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun changeFont() {
        run {

            action.click(OnboardingNamedScreen.skipButton)

            ExploreNamedScreen.cardsList {
                cardsList.childWith<FeaturedArticlesItem> {
                    withDescendant { withText(R.string.view_featured_article_card_title) }
                } perform {
                    isDisplayed()
                    title.click()
                }
            }

            ArticleScreen {
                popupCloseButton {
                    isDisplayed()
                    click()
                }

                action.click(themeButton)
            }

            BottomSheet {
                textSizeSettingWidget {
                    verify.isDisplayed(this)
                    action.click(increaseSizeButton)
                    verify.hasText(textSizePercent, "110%")
                    action.click(decreaseSizeButton)
                    action.click(decreaseSizeButton)
                    verify.hasText(textSizePercent, "90%")

                }
            }
        }
    }

    @Test
    fun changeSystemTheme() {
        run {

            action.click(OnboardingNamedScreen.skipButton)

            ExploreNamedScreen.cardsList {
                invokeWithText<FeaturedArticlesNamedItem>("Featured article") {
                    title.isDisplayed()
                    title.click()
                }
            }

            ArticleScreen {
                popupCloseButton {
                    isDisplayed()
                    click()
                }

                action.click(themeButton)
            }

            BottomSheet {
                themeWidget {
                    verify.isDisplayed(this)
                    action.swipeSwitchLeft(themeSwitch)
                    verify.isDisplayed(themeDarkButton)
                    action.swipeSwitchRight(themeSwitch)
                    verify.doesNotExist(themeDarkButton)
                }
            }
        }
    }
}