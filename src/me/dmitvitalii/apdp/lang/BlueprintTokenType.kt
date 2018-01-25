package me.dmitvitalii.apdp.lang

import com.intellij.psi.tree.IElementType

class BlueprintTokenType(debugName: String) : IElementType(debugName, BlueprintLang.INSTANCE) {
    override fun toString() = "${BlueprintTokenType::class}.${super.toString()}"
}