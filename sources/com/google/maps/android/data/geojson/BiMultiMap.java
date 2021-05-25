package com.google.maps.android.data.geojson;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
public class BiMultiMap<K> extends HashMap<K, Object> {
    public final Map<Object, K> a = new HashMap();

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        super.clear();
        this.a.clear();
    }

    public K getKey(Object obj) {
        return this.a.get(obj);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object put(K k, Object obj) {
        this.a.put(obj, k);
        return super.put((BiMultiMap<K>) k, (K) obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.maps.android.data.geojson.BiMultiMap<K> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ?> map) {
        for (Map.Entry<? extends K, ?> entry : map.entrySet()) {
            put((BiMultiMap<K>) entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        Object remove = super.remove(obj);
        if (remove instanceof Collection) {
            for (Object obj2 : (Collection) remove) {
                this.a.remove(obj2);
            }
        } else {
            this.a.remove(remove);
        }
        return remove;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.lang.Object
    public BiMultiMap<K> clone() {
        BiMultiMap<K> biMultiMap = new BiMultiMap<>();
        biMultiMap.putAll((Map) super.clone());
        return biMultiMap;
    }

    public Object put(K k, Collection collection) {
        for (Object obj : collection) {
            this.a.put(obj, k);
        }
        return super.put((BiMultiMap<K>) k, (K) collection);
    }
}
