package com.michael.muticlickinterceptplugin.muticlickhandle

import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

class MutiClickHandleVisitor(classVisitor: ClassVisitor): ClassVisitor(Opcodes.ASM5,classVisitor) {


    private val classFullName = "android/view/View\$OnClickListener"
    private var isMatchClass = false

    override fun visit(
        version: Int,
        access: Int,
        name: String?,
        signature: String?,
        superName: String?,
        interfaces: Array<String>
    ) {
        super.visit(version, access, name, signature, superName, interfaces)
        isMatchClass = matchClass(interfaces, classFullName)
    }

    override fun visitMethod(
        access: Int,
        name: String,
        desc: String,
        signature: String?,
        exceptions: Array<out String>?
    ): MethodVisitor {
        val mv = cv.visitMethod(access, name, desc, signature, exceptions)
        if (isMatchClass && matchMethod(name, desc)){
            return MutiClickHandleMethodAdapter(mv)
        }
        return mv
    }


    private fun matchMethod(name: String, desc: String): Boolean {
        return name == "onClick" && desc == "(Landroid/view/View;)V"
    }

    private fun matchClass(
        interfaces: Array<String>,
        classFullName: String
    ): Boolean {
        var isMatch = false
        // 是否满足实现的接口
        for (anInterface in interfaces) {
            if (anInterface == classFullName) {
                isMatch = true
                break
            }
        }
        return isMatch
    }

}