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

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.util.ProcessingContext
import me.dmitvitalii.blueprint.lang.BlueprintLanguage
import me.dmitvitalii.blueprint.lang.psi.BlueprintType
import java.io.File

class BlueprintCompletion : CompletionContributor() {
  init {
    extend(
        CompletionType.BASIC,
        // TODO: remove singleton usage!
        PlatformPatterns.psiElement(BlueprintType.IDENTIFIER).withLanguage(BlueprintLanguage.INSTANCE),
        object : CompletionProvider<CompletionParameters>() {
          override fun addCompletions(params: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
            File(this::class.java.getResource("/module_names").toURI())
                .findLines()
                .forEach { line -> result.addElement(LookupElementBuilder.create(line)) }
          }
        }
    )
  }
}