/*
 * Copyright (c) 2018 Vitalii Dmitriev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.dmitvitalii.blueprint.lang

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.tree.IElementType
import me.dmitvitalii.blueprint.lang.lexer.BlueprintLexerAdapter
import me.dmitvitalii.blueprint.lang.psi.BlueprintType
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors as DefaultColors
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey as createKey

class BlueprintHighlighter : SyntaxHighlighterBase() {

  override fun getTokenHighlights(token: IElementType) = when (token) {
    BlueprintType.COLON             -> token mapTo DefaultColors.COMMA
    BlueprintType.COMMA             -> token mapTo DefaultColors.COMMA
    BlueprintType.ASSIGNMENT        -> token mapTo DefaultColors.OPERATION_SIGN
    BlueprintType.NUMBER            -> token mapTo DefaultColors.NUMBER
    BlueprintType.STRING            -> token mapTo DefaultColors.STRING
    BlueprintType.LINE_COMMENT      -> token mapTo DefaultColors.LINE_COMMENT
    BlueprintType.MULTILINE_COMMENT -> token mapTo DefaultColors.BLOCK_COMMENT
    else -> arrayOf()
  }

  infix private fun IElementType.mapTo(color: TextAttributesKey) = arrayOf(createKey("BLUEPRINT_${toString()}", color))

  override fun getHighlightingLexer() = BlueprintLexerAdapter()

  companion object : SyntaxHighlighterFactory() {
    override fun getSyntaxHighlighter(project: Project?, file: VirtualFile?) = BlueprintHighlighter()
  }
}