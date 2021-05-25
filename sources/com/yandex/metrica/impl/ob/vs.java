package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
import android.support.annotation.NonNull;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
public class vs implements InvocationHandler {
    @NonNull
    private Object a;
    @NonNull
    private final vv b;

    public vs(@NonNull Object obj, @NonNull vv vvVar) {
        this.a = obj;
        this.b = vvVar;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (!"onInstallReferrerSetupFinished".equals(method.getName())) {
            vv vvVar = this.b;
            StringBuilder L = a.L("Unexpected method called ");
            L.append(method.getName());
            vvVar.a(new IllegalArgumentException(L.toString()));
            return null;
        } else if (objArr.length != 1) {
            this.b.a(new IllegalArgumentException("Args size is not equal to one."));
            return null;
        } else if (objArr[0].equals(0)) {
            try {
                Object invoke = this.a.getClass().getMethod("getInstallReferrer", new Class[0]).invoke(this.a, new Object[0]);
                this.b.a(new vu((String) invoke.getClass().getMethod("getInstallReferrer", new Class[0]).invoke(invoke, new Object[0]), ((Long) invoke.getClass().getMethod("getReferrerClickTimestampSeconds", new Class[0]).invoke(invoke, new Object[0])).longValue(), ((Long) invoke.getClass().getMethod("getInstallBeginTimestampSeconds", new Class[0]).invoke(invoke, new Object[0])).longValue()));
                return null;
            } catch (Throwable th) {
                this.b.a(th);
                return null;
            }
        } else {
            vv vvVar2 = this.b;
            StringBuilder L2 = a.L("Referrer check failed with error ");
            L2.append(objArr[0]);
            vvVar2.a(new IllegalStateException(L2.toString()));
            return null;
        }
    }
}
