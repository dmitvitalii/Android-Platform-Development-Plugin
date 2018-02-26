package me.dmitvitalii.blueprint

import com.intellij.codeInsight.completion.*
import com.intellij.patterns.PlatformPatterns
import com.intellij.util.ProcessingContext
import me.dmitvitalii.blueprint.lang.BlueprintLanguage
import me.dmitvitalii.blueprint.lang.psi.BlueprintType

class BlueprintCompletion : CompletionContributor() {
  init {
    extend(
        CompletionType.BASIC,
        // TODO: remove singleton usage!
        PlatformPatterns.psiElement(BlueprintType.MODULE /* fixme Won't work that way.*/).withLanguage(BlueprintLanguage.INSTANCE),
        object : CompletionProvider<CompletionParameters>() {
          override fun addCompletions(params: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
            TODO("Implement")
          }
        }
    )
  }
}