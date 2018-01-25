package me.dmitvitalii.apdp.lang

import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.util.PlatformIcons
import javax.swing.Icon

/**
 * @author Vitalii Dmitriev
 */
class BlueprintFileType : LanguageFileType(BlueprintLang.INSTANCE) {
    companion object {
        val INSTANCE = BlueprintFileType()
    }

    override fun getIcon(): Icon = PlatformIcons.CUSTOM_FILE_ICON

    override fun getName() = "Config file"

    override fun getDescription() = "Config files for platform projects."

    override fun getDefaultExtension() = "bp"
}