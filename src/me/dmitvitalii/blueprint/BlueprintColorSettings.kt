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

import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import me.dmitvitalii.blueprint.lang.BlueprintHighlighter
import me.dmitvitalii.blueprint.lang.BlueprintFileType
import me.dmitvitalii.blueprint.lang.psi.BlueprintType
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey as createKey

class BlueprintColorSettings : ColorSettingsPage {

  private val fileType = BlueprintFileType.INSTANCE

  override fun getHighlighter() = BlueprintHighlighter()

  override fun getAdditionalHighlightingTagToDescriptorMap() = null

  override fun getIcon() = fileType.icon

  override fun getColorDescriptors() = ColorDescriptor.EMPTY_ARRAY

  override fun getAttributeDescriptors() = arrayOf(
    AttributesDescriptor("Colon", BlueprintType.COLON.asKey()),
    AttributesDescriptor("Comma", BlueprintType.COMMA.asKey()),
    AttributesDescriptor("Number", BlueprintType.NUMBER.asKey()),
    AttributesDescriptor("String", BlueprintType.STRING.asKey()),
    AttributesDescriptor("Boolean", BlueprintType.BOOLEAN.asKey()),
    AttributesDescriptor("Assignment", BlueprintType.ASSIGNMENT.asKey()),
    AttributesDescriptor("Line comment", BlueprintType.LINE_COMMENT.asKey()),
    AttributesDescriptor("Multiline comment", BlueprintType.MULTILINE_COMMENT.asKey())
  )

  override fun getDisplayName() = fileType.name

  /**
   * TODO: how to work with resources and get strings in the plugin ecosystem?
   */
  override fun getDemoText(): String {
    return """
      |// Comment
      |
      |list = ["dir"]
      |
      |module {
      |    string: "superlibrary",
      |    boolean: true,
      |    super_boolean: false,
      |    numbers: 42,
      |}
      |
      |map = {
      |    key : "value",
      |    super_key : 168
      |}
    """.trimMargin()
  }
}