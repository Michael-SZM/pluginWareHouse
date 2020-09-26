package com.michael.muticlickinterceptplugin.okheader_rev

import com.michael.basetransform.asm.BaseWeaver
import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.ClassWriter

class OkHeaderRemCheckWeaver : BaseWeaver() {

    override fun wrapClassWriter(classWriter: ClassWriter): ClassVisitor {
        return OkHeaderCheckRemVisitor(classWriter)
    }

}