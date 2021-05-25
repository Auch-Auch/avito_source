package com.yandex.runtime.any;

import com.yandex.runtime.NativeObject;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;
public class Collection {
    private ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
    private NativeObject nativeObject;

    private Collection(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    private native Object getItemNative(String str);

    private <T> String keyForClass(Class<T> cls) {
        try {
            return (String) cls.getMethod("getNativeName", new Class[0]).invoke(null, new Object[0]);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException e) {
            throw new IllegalArgumentException(String.format("Objects of class %s cannot be stored in com.yandex.maps.mapkit.any.Collection", cls.getName(), e));
        }
    }

    public <T> T getItem(Class<T> cls) {
        T t;
        String keyForClass = keyForClass(cls);
        if (keyForClass == null) {
            return null;
        }
        T t2 = (T) this.map.get(keyForClass);
        if (t2 != null) {
            return t2;
        }
        T t3 = (T) getItemNative(keyForClass);
        return (t3 == null || (t = (T) this.map.putIfAbsent(keyForClass, t3)) == null) ? t3 : t;
    }

    private Collection() {
    }
}
