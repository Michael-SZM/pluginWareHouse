package com.michael.muticlickinterceptplugin.okheader_rev

import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

class OkCheckRemAdapter(methodVisitor: MethodVisitor) : MethodVisitor(Opcodes.ASM5,methodVisitor) {

    override fun visitCode() {

//        mv.visitCode()
//        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;")
//        mv.visitLdcInsn("this is the main content");
//        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false)
    }


//    override fun visitInsn(opcode: Int) {
//        super.visitInsn(opcode)
//        mv.visitInsn(Opcodes.RETURN);
//        mv.visitMaxs(0, 1);
//        mv.visitEnd();
//    }

    override fun visitMethodInsn(
        opcode: Int,
        owner: String?,
        name: String?,
        desc: String?,
        itf: Boolean
    ) {
        if (name == "checkNameAndValue" || name == "checkName" || name == "checkValue"){
            println("-----匹配到方法调用，---删除")
        }else{
            super.visitMethodInsn(opcode, owner, name, desc, itf)
        }

    }


}