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

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.icons.AllIcons
import com.intellij.lang.Language
import com.intellij.openapi.fileTypes.FileTypeConsumer
import com.intellij.openapi.fileTypes.FileTypeFactory
import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.psi.FileViewProvider
import com.intellij.psi.tree.IElementType
import javax.swing.Icon

/**
 * TODO: Seems that it's a common way to use INSTANCE. Can singletons be replaced (e.g. with DI)?
 * @author Vitalii Dmitriev
 */
class MakefileElementType(debugName: String) : IElementType(debugName, MakefileLanguage.INSTANCE)

class MakefileLanguage : Language("Makefile") {
    companion object Holder {
        val INSTANCE = MakefileLanguage()
    }
}

class MakefileTokenType(debugName: String) : IElementType(debugName, MakefileLanguage.INSTANCE) {
    override fun toString() = "${MakefileTokenType::class.simpleName}.${super.toString()}"
}

class MakefileFileTypeFactory : FileTypeFactory() {
    override fun createFileTypes(consumer: FileTypeConsumer) {
        consumer.consume(MakefileFileType.INSTANCE)
    }
}

class MakefileFileType : LanguageFileType(MakefileLanguage.INSTANCE) {
    companion object {
        val INSTANCE = MakefileFileType()
    }

    override fun getIcon(): Icon = AllIcons.FileTypes.Config

    override fun getName() = "Android.mk file"

    override fun getDescription() = "Config files for platform projects."

    override fun getDefaultExtension() = "mk"
}

class MakefileFile(provider: FileViewProvider) : PsiFileBase(provider, MakefileLanguage.INSTANCE) {
    override fun getFileType() = MakefileFileType.INSTANCE

    override fun toString() = fileType.name
}