package org.wikipedia.lesson26.homework

import org.junit.Test
import org.wikipedia.R
import org.wikipedia.lesson08.homework.ExploreScreen.cardsList
import org.wikipedia.lesson08.homework.FeaturedArticlesItem
import org.wikipedia.lesson18.homework.ExploreNamedScreen.ExploreNamedScreen
import org.wikipedia.lesson18.homework.OnboardingNamedScreen.OnboardingNamedScreen
import org.wikipedia.lesson19.homework.action
import org.wikipedia.lesson19.homework.verify
import org.wikipedia.lesson22.homework.ArticleScreen.themeButton
import org.wikipedia.lesson22.homework.BottomSheet
import org.wikipedia.lesson23.homework.ArticleScreen
import org.wikipedia.lesson23.homework.BaseTest

class InterceptorTest : BaseTest() {

    @Test
    fun openArticle() {
        before{
            testLogger.i("TEST_TAG", "BEFORE SECTION")
        }.after {
            testLogger.i("TEST_TAG", "AFTER SECTION")
        }.run {
            testLogger.i("TEST_TAG", "AFTER SECTION")

            action.click(OnboardingNamedScreen.skipButton)

            ExploreNamedScreen.cardsList {
                cardsList.childWith<FeaturedArticlesItem> {
                    withDescendant { withText(R.string.view_featured_article_card_title) }
                } perform {
                    isDisplayed()
                    click()
                }
            }

            ArticleScreen {
                verify.isDisplayed(title)
            }
        }
    }
}
