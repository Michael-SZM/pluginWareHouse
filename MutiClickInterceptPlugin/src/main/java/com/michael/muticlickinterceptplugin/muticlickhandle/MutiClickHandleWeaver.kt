package com.michael.muticlickinterceptplugin.muticlickhandle

import com.michael.basetransform.asm.BaseWeaver
import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.ClassWriter

class MutiClickHandleWeaver : BaseWeaver() {

    override fun wrapClassWriter(classWriter: ClassWriter): ClassVisitor {
        return MutiClickHandleVisitor(classWriter)
    }

}