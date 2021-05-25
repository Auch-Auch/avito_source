package com.yandex.runtime.bindings.internal;

import a2.b.a.a.a;
import com.yandex.runtime.bindings.Serializable;
import java.util.HashMap;
import java.util.Map;
public class GuidRegister {
    private static final Map<Class<? extends Serializable>, String> classesToGuidsMap = new HashMap();
    private static final Map<String, Class<? extends Serializable>> guidsToClassesMap = new HashMap();

    public static Class<? extends Serializable> getClass(String str) {
        Class<? extends Serializable> cls = guidsToClassesMap.get(str);
        if (cls != null) {
            return cls;
        }
        throw new RuntimeException(a.c3("Unregistered guid ", str));
    }

    public static String getGuid(Class<? extends Serializable> cls) {
        String str = classesToGuidsMap.get(cls);
        if (str != null) {
            return str;
        }
        throw new RuntimeException(a.B2(cls, a.L("Unknown guid for class ")));
    }

    public static void registerGuid(Class<? extends Serializable> cls, String str) {
        guidsToClassesMap.put(str, cls);
        classesToGuidsMap.put(cls, str);
    }
}
