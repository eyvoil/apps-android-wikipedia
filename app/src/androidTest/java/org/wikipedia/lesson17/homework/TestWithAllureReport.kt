package org.wikipedia.lesson17.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.R
import org.wikipedia.feed.announcement.AnnouncementCardView
import org.wikipedia.lesson08.homework.AnnouncementItem
import org.wikipedia.lesson08.homework.ExploreScreen
import org.wikipedia.lesson08.homework.FeaturedArticlesItem
import org.wikipedia.lesson09.homework.CustomizeFeedScreen
import org.wikipedia.lesson09.homework.OnboardingScreen
import org.wikipedia.main.MainActivity

class TestWithAllureReport : TestCase(Kaspresso.Builder.withForcedAllureSupport()) {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testWithAllure() {
        run {
            step("Нажимает Skip на экране онбординга") {
                OnboardingScreen {
                    skipButton {
                        isDisplayed()
                        click()
                    }
                }
            }
            step("Проверяет, что блок Featured Article экрана Explore НЕ отображается(степ с ошибкой)") {
                ExploreScreen {
                    cardsList.childWith<FeaturedArticlesItem> {
                        withDescendant { withText(R.string.view_featured_article_card_title) }
                    } perform {
                        isNotDisplayed()
                    }
                }
            }
            step("Нажимает на кнопку Customize в блоке Customize your Explore feed экрана Explore") {
                ExploreScreen {
                    cardsList.childWith<AnnouncementItem> {
                        isInstanceOf(AnnouncementCardView::class.java)
                    } perform {
                        isDisplayed()
                        positiveButton.isDisplayed()
                        positiveButton.click()
                    }
                }
            }
            step("Отключает Featured Article") {
                CustomizeFeedScreen {
                    settingList.childWith<CustomizeFeedScreen.SettingItem> {
                        withDescendant { withText(R.string.view_featured_article_card_title) }
                    } perform {
                        switch.isDisplayed()
                        switch.click()
                    }
                }
            }
            step("Нажимает стрелку назад в верхнем тулбаре") {
                CustomizeFeedScreen {
                    backButton.isDisplayed()
                    backButton.click()
                }
            }
            step("Проверяет, что блок Featured Article не отображается на экране Explore") {
                ExploreScreen {
                    cardsList.childWith<FeaturedArticlesItem> {
                        withDescendant { withText(R.string.view_featured_article_card_title) }
                    } perform {
                        title.doesNotExist()
                    }
                }
            }
        }
    }
}