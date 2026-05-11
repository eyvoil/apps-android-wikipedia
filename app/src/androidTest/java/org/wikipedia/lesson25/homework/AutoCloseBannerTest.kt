package org.wikipedia.lesson25.homework

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
import org.wikipedia.lesson22.homework.BottomSheet.invoke
import org.wikipedia.lesson22.homework.BottomSheet.textSizeSettingWidget
import org.wikipedia.lesson23.homework.ArticleScreen
import org.wikipedia.lesson23.homework.BaseTest

class AutoCloseBannerTest : BaseTest() {

    @Test
    fun autoCloseBanner() {
        run {

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

                action.click(themeButton)
            }

            BottomSheet {
                textSizeSettingWidget {
                    action.click(increaseSizeButton)
                }
            }
        }
    }
}
