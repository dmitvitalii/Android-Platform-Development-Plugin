package me.dmitvitalii

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages

class TextBoxes : AnAction("Text BoBo_xes") {

    override fun actionPerformed(anActionEvent: AnActionEvent) {
        val project = anActionEvent.getData(PlatformDataKeys.PROJECT)
        val name = Messages.showInputDialog(project, "What is your name?", "Enter Your Name:", Messages.getQuestionIcon())
        Messages.showMessageDialog(project, String.format("Hello, %s, Glad to see you!\nWelcome.", name), "Information", Messages.getInformationIcon())
    }
}
