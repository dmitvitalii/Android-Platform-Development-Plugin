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
package me.dmitvitalii.blueprint.lang.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.icons.AllIcons
import com.intellij.lang.Language
import com.intellij.openapi.fileTypes.FileTypeConsumer
import com.intellij.openapi.fileTypes.FileTypeFactory
import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.util.IconLoader
import com.intellij.psi.FileViewProvider
import com.intellij.psi.tree.IElementType
import com.intellij.util.PlatformIcons
import javax.swing.Icon

/**
 * TODO: Seems that it's a common way to use INSTANCE. Can singletons be replaced (e.g. with DI)?
 * @author Vitalii Dmitriev
 */
class BlueprintElementType(debugName: String) : IElementType(debugName, BlueprintLanguage.INSTANCE)

class BlueprintLanguage : Language("Blueprint") {
  companion object Holder {
    val INSTANCE = BlueprintLanguage()
  }
}

class BlueprintTokenType(debugName: String) : IElementType(debugName, BlueprintLanguage.INSTANCE) {
  override fun toString() = "${BlueprintTokenType::class}.${super.toString()}"
}

class BlueprintFileTypeFactory : FileTypeFactory() {
  override fun createFileTypes(consumer: FileTypeConsumer) {
    consumer.consume(BlueprintFileType.INSTANCE)
  }
}

class BlueprintFileType : LanguageFileType(BlueprintLanguage.INSTANCE) {
  companion object {
    val INSTANCE = BlueprintFileType()
  }

  override fun getIcon(): Icon = PlatformIcons.CUSTOM_FILE_ICON

  override fun getName() = "Android.bp file"

  override fun getDescription() = "Config files for platform projects."

  override fun getDefaultExtension() = "bp"
}

class BlueprintFile(provider: FileViewProvider) : PsiFileBase(provider, BlueprintLanguage.INSTANCE) {
  override fun getFileType() = BlueprintFileType.INSTANCE

  override fun toString() = fileType.name
}