package com.michael.muticlickinterceptplugin

import com.android.build.gradle.AppExtension
import com.michael.muticlickinterceptplugin.muticlickhandle.MutiClickHandleTransform
import org.gradle.api.Plugin
import org.gradle.api.Project
import java.util.*

class MyPlugin :Plugin<Project>{

    override fun apply(project: Project) {
        println("===============================")
        println("plugin---start--kotlin way!")
        println("===============================")

        val appExtension = project.properties["android"] as AppExtension
        appExtension.registerTransform(MutiClickHandleTransform(project), Collections.EMPTY_LIST)
    }

}