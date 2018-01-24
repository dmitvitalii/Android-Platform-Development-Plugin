package me.dmitvitalii.apdp.lang

import com.intellij.openapi.fileTypes.FileTypeConsumer
import com.intellij.openapi.fileTypes.FileTypeFactory

/**
 * @author Vitalii Dmitriev
 */
class BlueprintFileTypeFactory : FileTypeFactory() {
    override fun createFileTypes(consumer: FileTypeConsumer) {
        consumer.consume(BlueprintFileType.INSTANCE)
    }
}