package org.wikipedia.lesson03.homework

import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import org.wikipedia.R
import org.wikipedia.views.AppTextView

val logoImage = listOf(
    AppCompatImageView::class.java,
    R.id.imageViewCentered
)

val primaryText = listOf(
    AppTextView::class.java,
    R.id.primaryTextView,
    R.string.onboarding_welcome_title_v2
)

val secondaryText = listOf(
    AppTextView::class.java,
    R.id.secondaryTextView,
    R.string.onboarding_multilingual_secondary_text
)

val languagesList = listOf(
    RecyclerView::class.java,
    R.id.languagesList
)

val elementText = listOf(
    AppTextView::class.java,
    R.id.option_label
)

val addLangButton = listOf(
    MaterialButton::class.java,
    R.id.addLanguageButton,
    R.string.onboarding_multilingual_add_language_text
)

val skipButton = listOf(
    MaterialButton::class.java,
    R.id.fragment_onboarding_skip_button,
    R.string.onboarding_skip
)

val continueButton = listOf(
    MaterialButton::class.java,
    R.id.fragment_onboarding_forward_button,
    R.string.onboarding_continue
)

