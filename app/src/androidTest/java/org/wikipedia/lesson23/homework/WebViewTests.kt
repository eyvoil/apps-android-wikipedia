package org.wikipedia.lesson23.homework

import androidx.compose.ui.test.hasText
import org.junit.Test
import org.wikipedia.lesson18.homework.ExploreNamedScreen.CardNamedItem
import org.wikipedia.lesson18.homework.ExploreNamedScreen.ExploreNamedScreen
import org.wikipedia.lesson18.homework.OnboardingNamedScreen.OnboardingNamedScreen
import org.wikipedia.lesson19.homework.action
import org.wikipedia.lesson19.homework.verify

class WebViewTests: BaseTest() {

    @Test
    fun test(){
        run{
            OnboardingNamedScreen{
                action.click(skipButton)
            }
            ExploreNamedScreen.topReadBlock {
                cardsList.childAt<CardNamedItem>(0,{
                    action.click(this)
                })
            }
            ArticleScreen{
                verify.isDisplayed(popupCloseButton)
                popupCloseButton.click()

                verify.isDisplayed(title)
                verify.isDisplayed(references)

                references{
                    performWebViewAction {
                        click()
                    }
                }

                referenceItem(2){
                    performWebViewAction {
                        scroll()
                    }
                    hasText("[2]")
                }

                Thread.sleep(100_000)
            }
        }
    }
}