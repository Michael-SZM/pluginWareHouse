package com.michael.muticlickinterceptplugin.okheader_rev

import com.android.build.api.transform.TransformInvocation
import com.michael.basetransform.HunterTransform
import org.gradle.api.Project

class OkHeaderRemTransform(project: Project) : HunterTransform(project) {

    init {
        this.bytecodeWeaver = OkHeaderRemCheckWeaver()
    }

    override fun transform(transformInvocation: TransformInvocation?) {
        super.transform(transformInvocation)
    }

}