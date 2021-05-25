package org.junit.internal.runners;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.internal.MethodSorter;
@Deprecated
public class TestClass {
    public final Class<?> a;

    public TestClass(Class<?> cls) {
        this.a = cls;
    }

    public List<Method> getAnnotatedMethods(Class<? extends Annotation> cls) {
        boolean z;
        boolean z2;
        boolean z3;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Class<?> cls2 = this.a; cls2 != null; cls2 = cls2.getSuperclass()) {
            arrayList2.add(cls2);
        }
        Iterator it = arrayList2.iterator();
        while (true) {
            z = false;
            if (!it.hasNext()) {
                break;
            }
            Method[] declaredMethods = MethodSorter.getDeclaredMethods((Class) it.next());
            for (Method method : declaredMethods) {
                if (method.getAnnotation(cls) != null) {
                    Iterator it2 = arrayList.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z2 = false;
                            break;
                        }
                        Method method2 = (Method) it2.next();
                        if (method2.getName().equals(method.getName()) && method2.getParameterTypes().length == method.getParameterTypes().length) {
                            int i = 0;
                            while (true) {
                                if (i >= method2.getParameterTypes().length) {
                                    z3 = true;
                                    continue;
                                    break;
                                } else if (!method2.getParameterTypes()[i].equals(method.getParameterTypes()[i])) {
                                    break;
                                } else {
                                    i++;
                                }
                            }
                        }
                        z3 = false;
                        continue;
                        if (z3) {
                            z2 = true;
                            break;
                        }
                    }
                    if (!z2) {
                        arrayList.add(method);
                    }
                }
            }
        }
        if (cls.equals(Before.class) || cls.equals(BeforeClass.class)) {
            z = true;
        }
        if (z) {
            Collections.reverse(arrayList);
        }
        return arrayList;
    }

    public Constructor<?> getConstructor() throws SecurityException, NoSuchMethodException {
        return this.a.getConstructor(new Class[0]);
    }

    public Class<?> getJavaClass() {
        return this.a;
    }

    public String getName() {
        return this.a.getName();
    }

    public List<Method> getTestMethods() {
        return getAnnotatedMethods(Test.class);
    }
}
