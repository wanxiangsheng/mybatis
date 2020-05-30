package cn.itcast.cglib;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {

        Pro pro = new Pro();

        Pro oo =(Pro) Enhancer.create(pro.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

                Object value = null;
                Object object = objects[0];
                if ("sale".equals(method.getName())) {
                    value = method.invoke(pro, (float) object * 232F);
                }
                return value;
            }
        });

        oo.sale(1212);
    }
}
