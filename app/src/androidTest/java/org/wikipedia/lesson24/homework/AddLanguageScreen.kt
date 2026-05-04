package org.wikipedia.lesson24.homework

import androidx.compose.ui.semantics.SemanticsNode
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import io.github.kakaocup.compose.node.element.KNode
import io.github.kakaocup.compose.node.element.lazylist.KLazyListItemNode
import org.wikipedia.compose.uitests.Tags

object AddLanguageScreen : ComposeNamedScreen<AddLanguageScreen>() {
    override val screenName: String = "Экран добавления языка"

    val items by lazy {
        createLazyList(
            { hasTestTag(Tags.LANG_LIST) },
            {
                itemType(:: LanguageItem)
            }
        )
    }
}

class LanguageItem(
    semanticNode: SemanticsNode,
    semanticsProvider: SemanticsNodeInteractionsProvider? = null
) : KLazyListItemNode<LanguageItem>(semanticNode, semanticsProvider) {
    val localName by lazy {
        child<KNode> {
            hasTestTag(Tags.LOCAL_LANG_NAME)
        }.name(withParent("Локализованное название языка"))
    }

    val canonName by lazy {
        child<KNode> {
            hasTestTag(Tags.CANON_LANG_NAME)
        }.name(withParent("Название языка"))
    }
}