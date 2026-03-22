package org.wikipedia.lesson13

import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.screens.KScreen
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.github.kakaocup.kakao.web.KWebView
import org.junit.Rule
import org.junit.Test
import org.wikipedia.R
import org.wikipedia.main.MainActivity


object ArticleScreen : KScreen<ArticleScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val webView = KWebView() {
        withId(R.id.page_web_view)
    }
}

class WebViewTests : TestCase() {
    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun webViewTest() {
        run {
            ArticleScreen {
                webView {
                    withElement(Locator.CLASS_NAME, "mw-page-title-main") {
                        scroll()
                        hasText("Corleck Head")

                    }
                    withElement(Locator.XPATH, "(//img)[1]") {
                        scroll()
                        click()
                    }
                }
            }
        }
    }

}