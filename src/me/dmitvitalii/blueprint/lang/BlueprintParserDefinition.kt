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

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import me.dmitvitalii.blueprint.lang.lexer.BlueprintLexerAdapter
import me.dmitvitalii.blueprint.lang.psi.BlueprintFile
import me.dmitvitalii.blueprint.lang.psi.BlueprintLanguage
import me.dmitvitalii.blueprint.lang.psi.BlueprintType

/**
 * @author Vitalii Dmitriev
 */
class BlueprintParserDefinition : ParserDefinition {

  override fun createParser(project: Project) = BlueprintParser()

  override fun createFile(provider: FileViewProvider) = BlueprintFile(provider)

  override fun spaceExistanceTypeBetweenTokens(left: ASTNode, right: ASTNode) = ParserDefinition.SpaceRequirements.MAY

  override fun getStringLiteralElements() = TokenSet.EMPTY

  override fun getFileNodeType() = IFileElementType(BlueprintLanguage.INSTANCE)

  override fun createLexer(project: Project) = BlueprintLexerAdapter()

  override fun createElement(node: ASTNode) = BlueprintType.Factory.createElement(node)

  override fun getCommentTokens() = TokenSet.create(BlueprintType.COMMENT)

  override fun getWhitespaceTokens() = TokenSet.create(TokenType.WHITE_SPACE)
}