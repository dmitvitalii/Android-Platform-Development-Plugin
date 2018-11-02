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
package me.dmitvitalii.makefile.lang

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import me.dmitvitalii.makefile.lang.psi.MakefileType

/**
 * @author Vitalii Dmitriev
 */
class MakefileParserDefinition : ParserDefinition {

  override fun createParser(project: Project) = MakefileParser()

  override fun createFile(provider: FileViewProvider) = MakefileFile(provider)

  override fun spaceExistanceTypeBetweenTokens(left: ASTNode, right: ASTNode) = ParserDefinition.SpaceRequirements.MAY

  override fun getStringLiteralElements() = TokenSet.create(MakefileType.STRING)

  override fun getFileNodeType() = IFileElementType(MakefileLanguage.INSTANCE)

  override fun createLexer(project: Project) = MakefileLexerAdapter()

  override fun createElement(node: ASTNode) = MakefileType.Factory.createElement(node)

  override fun getCommentTokens() = TokenSet.create(MakefileType.LINE_COMMENT, MakefileType.MULTILINE_COMMENT)

  override fun getWhitespaceTokens() = TokenSet.create(TokenType.WHITE_SPACE)
}