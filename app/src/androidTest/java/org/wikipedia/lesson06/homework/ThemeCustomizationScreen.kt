package org.wikipedia.lesson06.homework

import androidx.appcompat.widget.AppCompatImageView
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.progress.KSeekBar
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object ThemeCustomizationScreen : KScreen<ThemeCustomizationScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val title = KTextView {
        withId(R.id.textSettingsCategory)
    }

    val sizeText = KTextView {
        withId(R.id.text_size_percent)
    }

    val decreaseTextButton = KButton {
        withId(R.id.buttonDecreaseTextSize)
    }

    val increaseTextButton = KButton {
        withId(R.id.buttonIncreaseTextSize)
    }

    val textSizeSeekBar = KSeekBar {
        withId(R.id.text_size_seek_bar)
    }

    val sansSerifButton = KButton {
        withId(R.id.button_font_family_sans_serif)
    }

    val serifButton = KButton {
        withId(R.id.button_font_family_serif)
    }

    val glassesImage = KImageView {
        withParent {
            withId(R.id.readingFocusModeContainer)
        }
        isInstanceOf(AppCompatImageView::class.java)
    }

    val readingModeSwitch = KSwitch {
        withId(R.id.theme_chooser_reading_focus_mode_switch)
    }

    val readingModeDescription = KTextView {
        withId(R.id.theme_chooser_reading_focus_mode_description)
    }

    val colorThemeTitle = KTextView {
        withText(R.string.color_theme_select)
    }

    val lightThemeButton = KButton {
        withId(R.id.button_theme_light)
    }

    val sepiaThemeButton = KButton {
        withId(R.id.button_theme_sepia)
    }

    val darkThemeButton = KButton {
        withId(R.id.button_theme_dark)
    }

    val blackThemeButton = KButton {
        withId(R.id.button_theme_black)
    }

    val systemThemeSwitch = KSwitch {
        withId(R.id.theme_chooser_match_system_theme_switch)
    }

    val darkModeImagesSwitch = KSwitch {
        withId(R.id.theme_chooser_dark_mode_dim_images_switch)
    }
}