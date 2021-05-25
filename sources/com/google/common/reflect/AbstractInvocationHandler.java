package com.google.common.reflect;

import com.google.common.annotations.Beta;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Beta
public abstract class AbstractInvocationHandler implements InvocationHandler {
    public static final Object[] a = new Object[0];

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public abstract Object handleInvocation(Object obj, Method method, Object[] objArr) throws Throwable;

    @Override // java.lang.Object
    public int hashCode() {
        return super.hashCode();
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, @NullableDecl Object[] objArr) throws Throwable {
        if (objArr == null) {
            objArr = a;
        }
        if (objArr.length == 0 && method.getName().equals("hashCode")) {
            return Integer.valueOf(hashCode());
        }
        boolean z = true;
        if (objArr.length == 1 && method.getName().equals("equals") && method.getParameterTypes()[0] == Object.class) {
            Object obj2 = objArr[0];
            if (obj2 == null) {
                return Boolean.FALSE;
            }
            if (obj == obj2) {
                return Boolean.TRUE;
            }
            Class<?> cls = obj.getClass();
            if (!(cls.isInstance(obj2) || (Proxy.isProxyClass(obj2.getClass()) && Arrays.equals(obj2.getClass().getInterfaces(), cls.getInterfaces()))) || !equals(Proxy.getInvocationHandler(obj2))) {
                z = false;
            }
            return Boolean.valueOf(z);
        } else if (objArr.length != 0 || !method.getName().equals("toString")) {
            return handleInvocation(obj, method, objArr);
        } else {
            return toString();
        }
    }

    @Override // java.lang.Object
    public String toString() {
        return super.toString();
    }
}
