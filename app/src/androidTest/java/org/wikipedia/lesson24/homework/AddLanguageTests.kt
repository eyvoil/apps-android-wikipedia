package org.wikipedia.lesson24.homework

import androidx.compose.ui.test.ExperimentalTestApi
import org.junit.Test
import org.wikipedia.R
import org.wikipedia.lesson08.homework.ExploreScreen.cardsList
import org.wikipedia.lesson08.homework.FeaturedArticlesItem
import org.wikipedia.lesson18.homework.OnboardingNamedScreen.OnboardingNamedScreen
import org.wikipedia.lesson18.homework.invokeWithText
import org.wikipedia.lesson19.homework.SettingScreen
import org.wikipedia.lesson19.homework.action
import org.wikipedia.lesson19.homework.verify
import org.wikipedia.lesson23.homework.BaseTest

class AddLanguageTests: BaseTest() {

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun addLanguage(){
        run{
            OnboardingNamedScreen.addLanguageBlock{
                action.click(addLanguageButton)
                }
            WikipediaLanguagesScreen{
                items.childAt<TitledItem>(0,{
                    verify.isDisplayed(title)
                })

                items.childWith<AddLanguageItem>{
                    withDescendant { withText(R.string.wikipedia_languages_add_language_text) }
                } perform {
                    click()
                }
            }
            AddLanguageScreen.items {
                invokeWithText<LanguageItem>("немецкий") {
                    verify.assertTrimmedTextIsEquals(localName, "немецкий")
                    action.clickIfEnable(localName)
                }
            }

            device.uiDevice.pressBack()

            OnboardingNamedScreen.addLanguageBlock{
                languages.childAt<OnboardingNamedScreen.LanguageItem>(1,{
                    containsText("Deutsch")
                })
            }
        }
    }
}