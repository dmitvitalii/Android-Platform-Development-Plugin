package me.dmitvitalii.apdp.lang


import com.intellij.lang.Language

/**
 * @author Vitalii Dmitriev
 */
class BlueprintLang : Language(BlueprintLang::class.toString()) {
    companion object Holder {
        val INSTANCE = BlueprintLang()
    }
}