package com.michael.muticlickinterceptplugin.muticlickhandle

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes


class MutiClickHandleMethodAdapter(methodVisitor: MethodVisitor) : MethodVisitor(Opcodes.ASM5,methodVisitor) {

    override fun visitCode() {
        super.visitCode()

        mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false)
        mv.visitVarInsn(Opcodes.LSTORE, 2)

        mv.visitVarInsn(Opcodes.ALOAD, 1)
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "android/view/View", "getId", "()I", false)
        mv.visitVarInsn(Opcodes.ISTORE, 4)

        mv.visitVarInsn(Opcodes.ALOAD, 1)
        mv.visitVarInsn(Opcodes.ILOAD, 4)
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "android/view/View", "getTag", "(I)Ljava/lang/Object;", false)
        mv.visitVarInsn(Opcodes.ASTORE, 5)

        mv.visitVarInsn(Opcodes.ALOAD, 1)
        mv.visitVarInsn(Opcodes.ILOAD, 4)
        mv.visitVarInsn(Opcodes.LLOAD, 2)
        mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;", false)
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "android/view/View", "setTag", "(ILjava/lang/Object;)V", false)


        mv.visitVarInsn(Opcodes.ALOAD, 5)
        val l5 = Label()
        mv.visitJumpInsn(Opcodes.IFNULL, l5)

        mv.visitVarInsn(Opcodes.ALOAD, 5)
        mv.visitTypeInsn(Opcodes.CHECKCAST, "java/lang/Long")
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Long", "longValue", "()J", false)
        mv.visitVarInsn(Opcodes.LSTORE, 6)

        mv.visitVarInsn(Opcodes.LLOAD, 2)
        mv.visitVarInsn(Opcodes.LLOAD, 6)
        mv.visitInsn(Opcodes.LSUB)
        mv.visitLdcInsn(1500L)
        mv.visitInsn(Opcodes.LCMP)
        mv.visitJumpInsn(Opcodes.IFGE, l5)

        mv.visitInsn(Opcodes.RETURN);
        mv.visitLabel(l5)
        mv.visitFrame(
            Opcodes.F_APPEND,
            3,
            arrayOf<Any>(
                Opcodes.LONG,
                Opcodes.INTEGER,
                "java/lang/Object"
            ),
            0,
            null
        )

    }

}