package com.michael.muticlickinterceptplugin.muticlickhandle

import com.android.build.api.transform.TransformInvocation
import com.michael.basetransform.HunterTransform
import org.gradle.api.Project

class MutiClickHandleTransform(project: Project) : HunterTransform(project) {

    init {
        this.bytecodeWeaver = MutiClickHandleWeaver()
    }

    override fun transform(transformInvocation: TransformInvocation?) {
        super.transform(transformInvocation)
    }

}