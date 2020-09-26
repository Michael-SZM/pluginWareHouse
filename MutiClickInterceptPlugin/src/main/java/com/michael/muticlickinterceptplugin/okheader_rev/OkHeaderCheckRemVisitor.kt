package com.michael.muticlickinterceptplugin.okheader_rev

import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

class OkHeaderCheckRemVisitor(classVisitor: ClassVisitor): ClassVisitor(Opcodes.ASM5,classVisitor) {


    private val classFullName = "okhttp3/Headers"
    private val builderClassFullName = "okhttp3/Headers\$Builder"
    var className = ""

    override fun visit(
        version: Int,
        access: Int,
        name: String,
        signature: String?,
        superName: String?,
        interfaces: Array<out String>?
    ) {
        super.visit(version, access, name, signature, superName, interfaces)
        className = name
    }

    override fun visitMethod(
        access: Int,
        name: String,
        desc: String,
        signature: String?,
        exceptions: Array<out String>?
    ): MethodVisitor {
        val mv = cv.visitMethod(access, name, desc, signature, exceptions)
        if (className == builderClassFullName){
            if (matchBuilderMethod(name, desc)){
                println("---match--builder--method----$name-------clazzzName:$classFullName")
                return OkCheckRemAdapter(mv)
            }
        }
        if (className == classFullName){
            if (name == "of"){
                println("---match--builder--method----$name-------clazzzName:$classFullName")
                return OkCheckRemAdapter(mv)
            }
        }
        return mv
    }

    private fun matchBuilderMethod(name: String, desc: String): Boolean {
        return name == "add" && desc == "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Headers\$Builder;" ||
                name == "set" && desc == "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Headers\$Builder;" ||
                name == "addUnsafeNonAscii"
    }


//    private fun matchMethod(name: String, desc: String): Boolean {
////        return name == "checkNameAndValue" && desc == "(Ljava/lang/String;Ljava/lang/String;)V"
//        return name == "add" && desc == "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Headers\$Builder;" ||
//                name == "set" && desc == "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Headers\$Builder;"
//    }

}