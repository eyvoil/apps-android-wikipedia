package org.wikipedia.lesson23.homework

import io.github.kakaocup.kakao.web.KWebView

fun KWebView.withXPath(xpath: String): KWebViewElement{
    return KWebViewElement(
        webView = this,
        xpath
    )
}