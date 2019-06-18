package teu.rasp.visitor;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import teu.rasp.visitorAdapter.RMIInterceptorVisitorAdapter;

public class RMIInterceptorVisitor extends ClassVisitor{
    public String className;
    public RMIInterceptorVisitor(ClassVisitor cv, String className){
        super(Opcodes.ASM5, cv);
        this.className = className;
    }
    @Override
    public MethodVisitor visitMethod(int access, String name, String desc,
                                     String signature, String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        if ("invokeRemoteMethod".equals(name)) {
            mv = new RMIInterceptorVisitorAdapter(mv, access, name, desc);
 //       System.out.println("action invoked");
        }
        return mv;
    }
//    @Override
//    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value){
//        System.out.println(access+" "+name+" "+desc+" "+signature+" "+value);
//        return cv.visitField(access, name, desc, signature, value);
//    }
//        class AlterRMIMethodAdapter extends MethodVisitor implements Opcodes {
//            public AlterRMIMethodAdapter(final MethodVisitor mv) {
//                super(ASM5, mv);
//    }
//}
}
