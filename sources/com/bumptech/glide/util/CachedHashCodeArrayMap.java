package com.bumptech.glide.util;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
public final class CachedHashCodeArrayMap<K, V> extends ArrayMap<K, V> {
    public int i;

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public void clear() {
        this.i = 0;
        super.clear();
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map, java.lang.Object
    public int hashCode() {
        if (this.i == 0) {
            this.i = super.hashCode();
        }
        return this.i;
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public V put(K k, V v) {
        this.i = 0;
        return (V) super.put(k, v);
    }

    @Override // androidx.collection.SimpleArrayMap
    public void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        this.i = 0;
        super.putAll(simpleArrayMap);
    }

    @Override // androidx.collection.SimpleArrayMap
    public V removeAt(int i2) {
        this.i = 0;
        return (V) super.removeAt(i2);
    }

    @Override // androidx.collection.SimpleArrayMap
    public V setValueAt(int i2, V v) {
        this.i = 0;
        return (V) super.setValueAt(i2, v);
    }
}
