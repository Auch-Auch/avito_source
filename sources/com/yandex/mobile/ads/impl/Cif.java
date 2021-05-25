package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
/* renamed from: com.yandex.mobile.ads.impl.if  reason: invalid class name */
public final class Cif {
    @Nullable
    public static Object a(@NonNull Class<?> cls, @NonNull String str, @NonNull Object... objArr) {
        return a(null, cls, str, objArr);
    }

    public static boolean b(@NonNull Class<?> cls, @NonNull String str, @NonNull Object... objArr) {
        try {
            return c(cls, str, objArr) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Method c(@NonNull Class<?> cls, @NonNull String str, @NonNull Object... objArr) {
        Class<?>[] a = a(objArr);
        while (cls != null) {
            Method[] declaredMethods = cls.getDeclaredMethods();
            for (Method method : declaredMethods) {
                if (a(method, str, a)) {
                    return method;
                }
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    @Nullable
    public static Object a(@NonNull Object obj, @NonNull String str, @NonNull Object... objArr) {
        return a(obj, obj.getClass(), str, objArr);
    }

    @Nullable
    private static Object a(@Nullable Object obj, @NonNull Class<?> cls, @NonNull String str, @NonNull Object... objArr) {
        try {
            Method c = c(cls, str, objArr);
            if (c == null) {
                return null;
            }
            c.setAccessible(true);
            Object invoke = c.invoke(obj, objArr);
            c.setAccessible(false);
            return invoke;
        } catch (Exception unused) {
            return null;
        }
    }

    @Nullable
    public static <T> T a(@NonNull Class<T> cls, @NonNull Object... objArr) {
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            clsArr[i] = objArr[i].getClass();
        }
        try {
            Constructor<T> declaredConstructor = cls.getDeclaredConstructor(clsArr);
            boolean isAccessible = declaredConstructor.isAccessible();
            if (!isAccessible) {
                declaredConstructor.setAccessible(true);
            }
            T newInstance = declaredConstructor.newInstance(objArr);
            if (!isAccessible) {
                declaredConstructor.setAccessible(false);
            }
            return newInstance;
        } catch (Exception unused) {
            cls.getCanonicalName();
            Arrays.toString(objArr);
            return null;
        }
    }

    private static boolean a(@NonNull Method method, @NonNull String str, @NonNull Class<?>... clsArr) {
        return str.equals(method.getName()) && a(method, clsArr);
    }

    private static boolean a(@NonNull Method method, @NonNull Class<?>[] clsArr) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length != clsArr.length) {
            return false;
        }
        for (int i = 0; i < parameterTypes.length; i++) {
            if (!parameterTypes[i].isAssignableFrom(clsArr[i])) {
                return false;
            }
        }
        return true;
    }

    private static Class<?>[] a(@NonNull Object... objArr) {
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            clsArr[i] = objArr[i].getClass();
        }
        return clsArr;
    }

    @Nullable
    public static Class<?> a(@NonNull String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
