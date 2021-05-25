package org.hamcrest.internal;

import a2.b.a.a.a;
import java.lang.reflect.Method;
public class ReflectiveTypeFinder {
    public final String a;
    public final int b;
    public final int c;

    public ReflectiveTypeFinder(String str, int i, int i2) {
        this.a = str;
        this.b = i;
        this.c = i2;
    }

    public boolean canObtainExpectedTypeFrom(Method method) {
        return method.getName().equals(this.a) && method.getParameterTypes().length == this.b && !method.isSynthetic();
    }

    public Class<?> expectedTypeFrom(Method method) {
        return method.getParameterTypes()[this.c];
    }

    public Class<?> findExpectedType(Class<?> cls) {
        while (cls != Object.class) {
            Method[] declaredMethods = cls.getDeclaredMethods();
            for (Method method : declaredMethods) {
                if (canObtainExpectedTypeFrom(method)) {
                    return expectedTypeFrom(method);
                }
            }
            cls = cls.getSuperclass();
        }
        throw new Error(a.t(a.L("Cannot determine correct type for "), this.a, "() method."));
    }
}
