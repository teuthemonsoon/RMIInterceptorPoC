# RMIInterceptorPoC

alternative to [mogwailabs's youdebug way to attack rmi service(with the knowledge of rmi interface method abstraction)](https://mogwailabs.de/blog/2019/03/attacking-java-rmi-services-after-jep-290/)

在已知RMI接口函数的情况下的RMI exploit，使用JAVA RASP的思路，对[java.rmi.server.RemoteObjectInvocationHandler](https://github.com/frohoff/jdk8u-jdk/blob/master/src/share/classes/java/rmi/server/RemoteObjectInvocationHandler.java) 的InvokeRemoteMethod方法进行hook，将第三个参数`Object[] args`的数组为包含有payload的Object[]数组，以完成java反序列化攻击。



本例中的RMI接口函数：

```java
import java.rmi.RemoteException;

public interface RmiServerInterface {
    public String action(String msg) throws RemoteException;
    public void action2(Object msg) throws RemoteException;
}
```

本例RMIInterceptor尝试攻击action函数



通过修改[visitorAdapter/RMIInterceptorVisitorAdapter.java](https://github.com/teuthemonsoon/RMIInterceptorPoC/blob/master/RMIInterceptor/src/main/java/teu/rasp/visitorAdapter/RMIInterceptorVisitorAdapter.java) 可改变要修改为payload的参数、要执行的命令。

如：若函数摘要如下：

```java
public void sum(Integer number,int[] values);
```

需要替换第二个参数，则：

将 `mv.visitInsn(ICONST_0);` 改为 ` mv.visitInsn(ICONST_1);`

需要改变命令，则：

将`mv.visitLdcInsn("calc.exe");`改为`mv.visitLdcInsn("touch command_you_want");`



