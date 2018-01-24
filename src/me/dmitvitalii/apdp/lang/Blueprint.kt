package me.dmitvitalii.apdp.lang


import com.intellij.lang.Language

/**
 * @author Vitalii Dmitriev
 */
class Blueprint() : Language(Blueprint::class.toString()) {
    companion object Holder {
        val INSTANCE = Blueprint()
    }
}