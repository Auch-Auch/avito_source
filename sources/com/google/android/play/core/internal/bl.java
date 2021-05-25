package com.google.android.play.core.internal;

import android.content.ComponentName;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
public final class bl {
    public static <T> bk<T> a(Object obj, String str, Class<T> cls) {
        return new bk<>(obj, c(obj, str), cls);
    }

    public static <R, P0> R a(Class cls, String str, Class<R> cls2, Class<P0> cls3, P0 p0) {
        try {
            return cls2.cast(b(cls, str, cls3).invoke(null, p0));
        } catch (Exception e) {
            throw new bm(String.format("Failed to invoke static method %s on type %s", str, cls), e);
        }
    }

    public static <R, P0, P1> R a(Class cls, String str, Class<R> cls2, Class<P0> cls3, P0 p0, Class<P1> cls4, P1 p1) {
        try {
            return cls2.cast(b(cls, str, cls3, cls4).invoke(null, p0, p1));
        } catch (Exception e) {
            throw new bm(String.format("Failed to invoke static method %s on type %s", str, cls), e);
        }
    }

    public static <R, P0> R a(Object obj, String str, Class<R> cls, Class<P0> cls2, P0 p0) {
        try {
            return cls.cast(b(obj.getClass(), str, cls2).invoke(obj, p0));
        } catch (Exception e) {
            throw new bm(String.format("Failed to invoke method %s on an object of type %s", str, obj.getClass()), e);
        }
    }

    public static void a(PackageManager packageManager, ComponentName componentName) {
        ComponentInfo componentInfo;
        int componentEnabledSetting = packageManager.getComponentEnabledSetting(componentName);
        if (componentEnabledSetting != 1) {
            if (componentEnabledSetting != 2) {
                String packageName = componentName.getPackageName();
                String className = componentName.getClassName();
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 527);
                    ComponentInfo[][] componentInfoArr = {packageInfo.activities, packageInfo.services, packageInfo.providers};
                    int i = 0;
                    loop0:
                    while (true) {
                        if (i >= 3) {
                            componentInfo = null;
                            break;
                        }
                        ComponentInfo[] componentInfoArr2 = componentInfoArr[i];
                        if (componentInfoArr2 != null) {
                            int length = componentInfoArr2.length;
                            for (int i2 = 0; i2 < length; i2++) {
                                componentInfo = componentInfoArr2[i2];
                                if (componentInfo.name.equals(className)) {
                                    break loop0;
                                }
                            }
                            continue;
                        }
                        i++;
                    }
                    if (componentInfo != null && componentInfo.isEnabled()) {
                        return;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        }
    }

    public static <T> void a(T t) {
        Objects.requireNonNull(t);
    }

    public static <T> void a(T t, String str) {
        Objects.requireNonNull(t, str);
    }

    public static <T> bk b(Object obj, String str, Class<T> cls) {
        return new bk(obj, c(obj, str), cls, null);
    }

    public static Method b(Class<?> cls, String str, Class<?>... clsArr) {
        for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            try {
                Method declaredMethod = cls2.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
            }
        }
        throw new bm(String.format("Could not find a method named %s with parameters %s in type %s", str, Arrays.asList(clsArr), cls));
    }

    public static Field c(Object obj, String str) {
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
            }
        }
        throw new bm(String.format("Failed to find a field named %s on an object of instance %s", str, obj.getClass().getName()));
    }

    public static <R, P0, P1, P2> R a(Object obj, String str, Class<R> cls, Class<P0> cls2, P0 p0, Class<P1> cls3, P1 p1, Class<P2> cls4, P2 p2) {
        try {
            return cls.cast(b(obj.getClass(), str, cls2, cls3, cls4).invoke(obj, p0, p1, p2));
        } catch (Exception e) {
            throw new bm(String.format("Failed to invoke method %s on an object of type %s", str, obj.getClass()), e);
        }
    }
}
