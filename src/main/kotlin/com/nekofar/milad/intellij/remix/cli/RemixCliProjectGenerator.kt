package com.nekofar.milad.intellij.remix.cli

import com.intellij.execution.filters.Filter
import com.intellij.lang.javascript.boilerplate.NpmPackageProjectGenerator
import com.intellij.lang.javascript.boilerplate.NpxPackageDescriptor
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.vfs.VirtualFile
import com.nekofar.milad.intellij.remix.RemixBundle
import com.nekofar.milad.intellij.remix.RemixIcons

class RemixCliProjectGenerator: NpmPackageProjectGenerator() {
    private val packageName = "create-remix"
    private val executable = "create-remix"

    override fun getIcon() = RemixIcons.ProjectGenerator

    override fun getName() = RemixBundle.message("remix.project.generator.name")

    override fun getDescription() = RemixBundle.message("remix.project.generator.description")

    override fun filters(project: Project, baseDir: VirtualFile): Array<Filter> = emptyArray()

    override fun customizeModule(baseDir: VirtualFile, entry: ContentEntry?) { /* Do nothing */
    }

    override fun packageName() = packageName

    override fun presentablePackageName() = RemixBundle.message("remix.project.generator.presentable.package.name")

    override fun getNpxCommands() = listOf(NpxPackageDescriptor.NpxCommand(packageName, executable))

    override fun generatorArgs(project: Project?, dir: VirtualFile?, settings: Settings?) =
        project?.let { arrayOf(it.name) }

    override fun generateInTemp() = true
}