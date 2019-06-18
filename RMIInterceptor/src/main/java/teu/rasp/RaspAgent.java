package teu.rasp;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;


public class RaspAgent {
    public static void premain(String agentArgs, Instrumentation instru) throws ClassNotFoundException, UnmodifiableClassException {
        System.out.println("intercepting...");
        instru.addTransformer(new ClassTransFormer());
    }

}

