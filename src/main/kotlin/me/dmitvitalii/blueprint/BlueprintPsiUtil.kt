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

import com.intellij.psi.PsiElement
import me.dmitvitalii.blueprint.lang.psi.BlueprintVariable

/**
 * TODO: need to check, can we remove @JvmStatic annotations?
 * TODO: do we really need a companion object?
 * @author Vitalii Dmitriev
 */
class BlueprintPsiUtil {

  companion object {

    @JvmStatic
    fun getKey(variable: BlueprintVariable) = ""

    @JvmStatic
    fun getValue(variable: BlueprintVariable) = ""

    @JvmStatic
    fun getName(variable: BlueprintVariable) = getKey(variable)

    @JvmStatic
    fun getNameIdentifier(variable: BlueprintVariable): PsiElement {
      TODO("not implemented")
    }

    @JvmStatic
    fun setName(variable: BlueprintVariable, newName: String): PsiElement {
      TODO("not implemented")
    }
  }
}