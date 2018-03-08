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
package me.dmitvitalii.blueprint

import com.intellij.lang.ASTNode
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*

/**
 * @author Vitalii Dmitriev
 */
class BlueprintReference(
    element: PsiElement,
    range: TextRange
) : PsiReferenceBase<PsiElement>(element, range), PsiPolyVariantReference {

  override fun resolve(): PsiElement? {
    TODO("not implemented")
  }

  override fun getVariants(): Array<Any> {
    TODO("not implemented")
  }

  override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
    TODO("not implemented")
  }

}

abstract class IdentifierElement(node: ASTNode) : ASTWrapperPsiElement(node), Nameable {

  companion object {
    // TODO here must be implemented an element factory
  }
}

interface Nameable : PsiNameIdentifierOwner
