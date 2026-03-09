package org.wikipedia.lesson09.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.R
import org.wikipedia.feed.announcement.AnnouncementCardView
import org.wikipedia.lesson08.homework.AnnouncementItem
import org.wikipedia.lesson08.homework.ExploreScreen
import org.wikipedia.lesson08.homework.FeaturedArticlesItem
import org.wikipedia.main.MainActivity

class ExploreTests : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun disabledFeaturedArticle() {
        run {
            step("Нажимает Skip на экране онбординга") {
                OnboardingScreen {
                    skipButton {
                        isDisplayed()
                        click()
                    }
                }
            }
            step("Проверяет отображение блока Featured Article экрана Explore") {
                ExploreScreen {
                    cardsList.childWith<FeaturedArticlesItem> {
                        withDescendant { withText(R.string.view_featured_article_card_title) }
                    } perform {
                        isDisplayed()
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