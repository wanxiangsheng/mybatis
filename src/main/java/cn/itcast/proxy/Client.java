package cn.itcast.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        Pro pro = new Pro();

        Product o = (Product) Proxy.newProxyInstance(pro.getClass().getClassLoader(), pro.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                Object value = null;

                float arg = (float) args[0];

                if ("sale".equals(method.getName())) {
                    value = method.invoke(pro, arg * 0.8F);
                }


                return value;
            }
        });

        o.sale(100F);

    }

}
