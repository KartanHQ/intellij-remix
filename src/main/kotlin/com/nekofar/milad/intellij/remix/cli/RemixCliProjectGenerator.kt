package com.nekofar.milad.intellij.remix.cli

import com.intellij.execution.filters.Filter
import com.intellij.lang.javascript.boilerplate.NpmPackageProjectGenerator
import com.intellij.lang.javascript.boilerplate.NpxPackageDescriptor
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.vfs.VirtualFile
import com.nekofar.milad.intellij.remix.RemixBundle
import com.nekofar.milad.intellij.remix.RemixIcons
import javax.swing.Icon

class RemixCliProjectGenerator: NpmPackageProjectGenerator() {
    private val packageName = "create-remix"
    private val executable = "create-remix"

    override fun getName(): String {
        return RemixBundle.message("remix.project.generator.name")
    }

    override fun getDescription(): String {
        return RemixBundle.message("remix.project.generator.description")
    }

    override fun filters(project: Project, baseDir: VirtualFile): Array<Filter> {
        return emptyArray()
    }

    override fun customizeModule(p0: VirtualFile, p1: ContentEntry?) {}

    override fun packageName(): String {
        return packageName
    }

    override fun presentablePackageName(): String {
        return RemixBundle.message("remix.project.generator.presentable.package.name")
    }

    override fun getNpxCommands(): List<NpxPackageDescriptor.NpxCommand> {
        return listOf(NpxPackageDescriptor.NpxCommand(packageName, executable))
    }

    override fun generatorArgs(project: Project?, dir: VirtualFile?, settings: Settings?): Array<String> {
        return arrayOf(".")
    }

    override fun getIcon(): Icon {
        return RemixIcons.ProjectGenerator
    }
}