package com.nekofar.milad.intellij.remix.config

import com.intellij.ide.IconProvider
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.nekofar.milad.intellij.remix.RemixIcons
import javax.swing.Icon

class RemixConfigIconProvider : IconProvider(), DumbAware {
    override fun getIcon(element: PsiElement, flags: Int): Icon? {
        val fileElement = element as? PsiFile
        return if (fileElement != null) {
            when {
                fileElement.name.equals("remix.config.js", true) -> RemixIcons.FileType
                else -> null
            }
        } else null
    }
}