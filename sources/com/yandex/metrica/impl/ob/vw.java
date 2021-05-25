package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import java.lang.reflect.Proxy;
public class vw {
    @NonNull
    private final Context a;

    public vw(@NonNull Context context) {
        this.a = context.getApplicationContext();
    }

    @SuppressLint({"PrivateApi"})
    public void a(@NonNull final vv vvVar) {
        try {
            Class<?> cls = Class.forName("com.android.installreferrer.api.InstallReferrerClient");
            Object invoke = cls.getDeclaredMethod("newBuilder", Context.class).invoke(cls, this.a);
            Class<?> cls2 = Class.forName("com.android.installreferrer.api.InstallReferrerStateListener");
            final Object invoke2 = invoke.getClass().getDeclaredMethod("build", new Class[0]).invoke(invoke, new Object[0]);
            invoke2.getClass().getDeclaredMethod("startConnection", cls2).invoke(invoke2, Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls2}, new vs(invoke2, new vv() { // from class: com.yandex.metrica.impl.ob.vw.1
                @Override // com.yandex.metrica.impl.ob.vv
                public void a(@NonNull vu vuVar) {
                    vvVar.a(vuVar);
                    a();
                }

                @Override // com.yandex.metrica.impl.ob.vv
                public void a(@NonNull Throwable th) {
                    vvVar.a(th);
                    a();
                }

                public void a() {
                    Object obj = invoke2;
                    if (obj != null) {
                        try {
                            obj.getClass().getDeclaredMethod("endConnection", new Class[0]).invoke(invoke2, new Object[0]);
                        } catch (Throwable unused) {
                        }
                    }
                }
            })));
        } catch (Throwable th) {
            vvVar.a(th);
        }
    }
}
