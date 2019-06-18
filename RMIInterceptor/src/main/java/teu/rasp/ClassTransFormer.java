package teu.rasp;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.ClassLoader;

import java.lang.instrument.ClassFileTransformer;
import java.lang.reflect.Constructor;
import java.security.ProtectionDomain;
import com.sun.jndi.rmi.registry.RegistryContext;

public class ClassTransFormer implements ClassFileTransformer{
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer){

        byte[] transformeredByteCode = classfileBuffer;

        try {
            if (className!=null&&className.equalsIgnoreCase("java/rmi/server/RemoteObjectInvocationHandler")){
                System.out.println(String.format("transform start %s",className));
                ClassReader reader = new ClassReader(classfileBuffer);
                ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS);
                Constructor<?> ctor = Class.forName("teu.rasp.visitor.RMIInterceptorVisitor").getDeclaredConstructor(new Class[]{ClassVisitor.class, String.class});
                ctor.setAccessible(true);
                ClassVisitor classVisitor = (ClassVisitor)ctor.newInstance(new Object[]{writer, "java/rmi/server/RemoteObjectInvocationHandler"});
                reader.accept(classVisitor, ClassReader.EXPAND_FRAMES);
                transformeredByteCode = writer.toByteArray();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }catch (Throwable t){
            t.printStackTrace();
        }
        return transformeredByteCode;
    }
}
