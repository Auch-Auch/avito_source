package com.yandex.runtime.bindings.internal;

import com.yandex.runtime.NativeObject;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
public class StringDictionary<E> extends AbstractMap<String, E> {
    private ConcurrentHashMap<String, E> map = new ConcurrentHashMap<>();
    private NativeObject nativeObject;

    public StringDictionary(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj) || containsKeyNative(obj);
    }

    public native boolean containsKeyNative(Object obj);

    @Override // java.util.AbstractMap, java.util.Map
    public native Set<Map.Entry<String, E>> entrySet();

    @Override // java.util.AbstractMap, java.util.Map
    public E get(Object obj) {
        E putIfAbsent;
        E e = this.map.get(obj);
        if (e != null) {
            return e;
        }
        E e2 = getNative(obj);
        return (e2 == null || (putIfAbsent = this.map.putIfAbsent((String) obj, e2)) == null) ? e2 : putIfAbsent;
    }

    public native E getNative(Object obj);

    @Override // java.util.AbstractMap, java.util.Map
    public native int size();
}
