package com.google.common.primitives;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
@GwtIncompatible
public final class Primitives {
    public static final Map<Class<?>, Class<?>> a;
    public static final Map<Class<?>, Class<?>> b;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap(16);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(16);
        Class cls = Boolean.TYPE;
        linkedHashMap.put(cls, Boolean.class);
        linkedHashMap2.put(Boolean.class, cls);
        Class cls2 = Byte.TYPE;
        linkedHashMap.put(cls2, Byte.class);
        linkedHashMap2.put(Byte.class, cls2);
        Class cls3 = Character.TYPE;
        linkedHashMap.put(cls3, Character.class);
        linkedHashMap2.put(Character.class, cls3);
        Class cls4 = Double.TYPE;
        linkedHashMap.put(cls4, Double.class);
        linkedHashMap2.put(Double.class, cls4);
        Class cls5 = Float.TYPE;
        linkedHashMap.put(cls5, Float.class);
        linkedHashMap2.put(Float.class, cls5);
        Class cls6 = Integer.TYPE;
        linkedHashMap.put(cls6, Integer.class);
        linkedHashMap2.put(Integer.class, cls6);
        Class cls7 = Long.TYPE;
        linkedHashMap.put(cls7, Long.class);
        linkedHashMap2.put(Long.class, cls7);
        Class cls8 = Short.TYPE;
        linkedHashMap.put(cls8, Short.class);
        linkedHashMap2.put(Short.class, cls8);
        Class cls9 = Void.TYPE;
        linkedHashMap.put(cls9, Void.class);
        linkedHashMap2.put(Void.class, cls9);
        a = Collections.unmodifiableMap(linkedHashMap);
        b = Collections.unmodifiableMap(linkedHashMap2);
    }

    public static Set<Class<?>> allPrimitiveTypes() {
        return a.keySet();
    }

    public static Set<Class<?>> allWrapperTypes() {
        return b.keySet();
    }

    public static boolean isWrapperType(Class<?> cls) {
        return b.containsKey(Preconditions.checkNotNull(cls));
    }

    public static <T> Class<T> unwrap(Class<T> cls) {
        Preconditions.checkNotNull(cls);
        Class<T> cls2 = (Class<T>) b.get(cls);
        return cls2 == null ? cls : cls2;
    }

    public static <T> Class<T> wrap(Class<T> cls) {
        Preconditions.checkNotNull(cls);
        Class<T> cls2 = (Class<T>) a.get(cls);
        return cls2 == null ? cls : cls2;
    }
}
