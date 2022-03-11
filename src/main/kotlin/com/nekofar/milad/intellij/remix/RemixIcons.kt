package com.nekofar.milad.intellij.remix

import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

@Suppress("unused")
object RemixIcons {
    @JvmField
    val FileType = IconLoader.getIcon("/icons/type.svg", javaClass)

    @JvmField
    val ProjectGenerator: Icon = IconLoader.getIcon("/icons/remix.svg", javaClass)
}
