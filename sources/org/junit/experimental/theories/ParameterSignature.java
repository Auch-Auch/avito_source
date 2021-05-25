package org.junit.experimental.theories;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ParameterSignature {
    public static final Map<Class<?>, Class<?>> c;
    public final Class<?> a;
    public final Annotation[] b;

    static {
        HashMap hashMap = new HashMap();
        Class cls = Boolean.TYPE;
        hashMap.put(cls, Boolean.class);
        hashMap.put(Boolean.class, cls);
        Class cls2 = Byte.TYPE;
        hashMap.put(cls2, Byte.class);
        hashMap.put(Byte.class, cls2);
        Class cls3 = Short.TYPE;
        hashMap.put(cls3, Short.class);
        hashMap.put(Short.class, cls3);
        Class cls4 = Character.TYPE;
        hashMap.put(cls4, Character.class);
        hashMap.put(Character.class, cls4);
        Class cls5 = Integer.TYPE;
        hashMap.put(cls5, Integer.class);
        hashMap.put(Integer.class, cls5);
        Class cls6 = Long.TYPE;
        hashMap.put(cls6, Long.class);
        hashMap.put(Long.class, cls6);
        Class cls7 = Float.TYPE;
        hashMap.put(cls7, Float.class);
        hashMap.put(Float.class, cls7);
        Class cls8 = Double.TYPE;
        hashMap.put(cls8, Double.class);
        hashMap.put(Double.class, cls8);
        c = Collections.unmodifiableMap(hashMap);
    }

    public ParameterSignature(Class<?> cls, Annotation[] annotationArr) {
        this.a = cls;
        this.b = annotationArr;
    }

    public static ArrayList<ParameterSignature> c(Class<?>[] clsArr, Annotation[][] annotationArr) {
        ArrayList<ParameterSignature> arrayList = new ArrayList<>();
        for (int i = 0; i < clsArr.length; i++) {
            arrayList.add(new ParameterSignature(clsArr[i], annotationArr[i]));
        }
        return arrayList;
    }

    public static ArrayList<ParameterSignature> signatures(Method method) {
        return c(method.getParameterTypes(), method.getParameterAnnotations());
    }

    public final <T extends Annotation> T a(Annotation[] annotationArr, Class<T> cls, int i) {
        if (i == 0) {
            return null;
        }
        for (Annotation annotation : annotationArr) {
            if (cls.isInstance(annotation)) {
                return cls.cast(annotation);
            }
            Annotation a3 = a(annotation.annotationType().getAnnotations(), cls, i - 1);
            if (a3 != null) {
                return cls.cast(a3);
            }
        }
        return null;
    }

    public final boolean b(Class<?> cls, Class<?> cls2) {
        Map<Class<?>, Class<?>> map = c;
        if (map.containsKey(cls2)) {
            return cls.isAssignableFrom(map.get(cls2));
        }
        return false;
    }

    public boolean canAcceptType(Class<?> cls) {
        return this.a.isAssignableFrom(cls) || b(this.a, cls);
    }

    public boolean canAcceptValue(Object obj) {
        if (obj == null) {
            return !this.a.isPrimitive();
        }
        return canAcceptType(obj.getClass());
    }

    public boolean canPotentiallyAcceptType(Class<?> cls) {
        return cls.isAssignableFrom(this.a) || b(cls, this.a) || canAcceptType(cls);
    }

    public <T extends Annotation> T findDeepAnnotation(Class<T> cls) {
        return (T) a(this.b, cls, 3);
    }

    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        for (Annotation annotation : getAnnotations()) {
            if (cls.isInstance(annotation)) {
                return cls.cast(annotation);
            }
        }
        return null;
    }

    public List<Annotation> getAnnotations() {
        return Arrays.asList(this.b);
    }

    public Class<?> getType() {
        return this.a;
    }

    public boolean hasAnnotation(Class<? extends Annotation> cls) {
        return getAnnotation(cls) != null;
    }

    public static List<ParameterSignature> signatures(Constructor<?> constructor) {
        return c(constructor.getParameterTypes(), constructor.getParameterAnnotations());
    }
}
