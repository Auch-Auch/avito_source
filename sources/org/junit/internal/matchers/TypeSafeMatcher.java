package org.junit.internal.matchers;

import java.lang.reflect.Method;
import org.hamcrest.BaseMatcher;
import org.junit.internal.MethodSorter;
@Deprecated
public abstract class TypeSafeMatcher<T> extends BaseMatcher<T> {
    public Class<?> a;

    public TypeSafeMatcher() {
        for (Class<?> cls = getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            Method[] declaredMethods = MethodSorter.getDeclaredMethods(cls);
            for (Method method : declaredMethods) {
                boolean z = true;
                if ((!"matchesSafely".equals(method.getName()) || method.getParameterTypes().length != 1 || method.isSynthetic()) ? false : z) {
                    this.a = method.getParameterTypes()[0];
                    return;
                }
            }
        }
        throw new Error("Cannot determine correct type for matchesSafely() method.");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.hamcrest.Matcher
    public final boolean matches(Object obj) {
        return obj != 0 && this.a.isInstance(obj) && matchesSafely(obj);
    }

    public abstract boolean matchesSafely(T t);

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Class<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public TypeSafeMatcher(Class<T> cls) {
        this.a = cls;
    }
}
