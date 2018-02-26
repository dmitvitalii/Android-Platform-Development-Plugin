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

import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.tree.IElementType
import me.dmitvitalii.blueprint.lang.psi.BlueprintType
import me.dmitvitalii.blueprint.createKeys
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors as DefaultColors

class BlueprintHighlighter : SyntaxHighlighterBase() {

  override fun getTokenHighlights(element: IElementType) = when (element) {
    BlueprintType.COLON             -> element.createKeys(DefaultColors.COMMA)
    BlueprintType.COMMA             -> element.createKeys(DefaultColors.COMMA)
    BlueprintType.NUMBER            -> element.createKeys(DefaultColors.NUMBER)
    BlueprintType.STRING            -> element.createKeys(DefaultColors.STRING)
    BlueprintType.BOOLEAN           -> element.createKeys(DefaultColors.KEYWORD)
    BlueprintType.ASSIGNMENT        -> element.createKeys(DefaultColors.OPERATION_SIGN)
    BlueprintType.LINE_COMMENT      -> element.createKeys(DefaultColors.LINE_COMMENT)
    BlueprintType.MULTILINE_COMMENT -> element.createKeys(DefaultColors.BLOCK_COMMENT)
    else -> arrayOf()
  }

  override fun getHighlightingLexer() = BlueprintLexerAdapter()

  companion object : SyntaxHighlighterFactory() {
    override fun getSyntaxHighlighter(project: Project?, file: VirtualFile?) = BlueprintHighlighter()
  }
}