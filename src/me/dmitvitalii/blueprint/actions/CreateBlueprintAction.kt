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
package me.dmitvitalii.blueprint.actions

import com.intellij.ide.actions.CreateFileFromTemplateAction
import com.intellij.ide.actions.CreateFileFromTemplateDialog
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory
import me.dmitvitalii.blueprint.lang.BlueprintFileType

/**
 * TODO: if we create non-default constructor with BlueprintFileType instance passed,
 * TODO: we won't be able to add it as an <action> to plugin.xml. Is there a way to do this?
 * TODO: OR find a way to use DI to avoid x.INSTANCE.x everywhere.
 *
 * @author Vitalii Dmitriev
 */
class CreateBlueprintAction : DumbAware, CreateFileFromTemplateAction(
    BlueprintFileType.INSTANCE.name, BlueprintFileType.INSTANCE.description, BlueprintFileType.INSTANCE.icon
) {

  override fun getActionName(dir: PsiDirectory, newName: String, templateName: String) = BlueprintFileType.INSTANCE.name

  override fun buildDialog(project: Project, dir: PsiDirectory, builder: CreateFileFromTemplateDialog.Builder) {
    val fileType = BlueprintFileType.INSTANCE
    builder.setTitle(fileType.name).addKind("Empty file", fileType.icon, fileType.name)
  }
}
