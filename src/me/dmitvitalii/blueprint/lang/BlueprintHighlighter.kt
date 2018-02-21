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
import com.intellij.psi.tree.IElementType
import me.dmitvitalii.blueprint.lang.lexer.BlueprintLexerAdapter

class BlueprintHighlighter : SyntaxHighlighterBase() {
  override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
    throw UnsupportedOperationException("Not implemented")
  }

  override fun getHighlightingLexer() = BlueprintLexerAdapter()
}