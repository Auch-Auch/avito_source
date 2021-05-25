package com.google.android.gms.internal.vision;

import a2.b.a.a.a;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public abstract class zzdl<K, V> implements Map.Entry<K, V> {
    @Override // java.util.Map.Entry, java.lang.Object
    public boolean equals(@NullableDecl Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            if (zzcz.equal(getKey(), entry.getKey()) && zzcz.equal(getValue(), entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public abstract K getKey();

    @Override // java.util.Map.Entry
    public abstract V getValue();

    @Override // java.util.Map.Entry, java.lang.Object
    public int hashCode() {
        int i;
        K key = getKey();
        V value = getValue();
        int i2 = 0;
        if (key == null) {
            i = 0;
        } else {
            i = key.hashCode();
        }
        if (value != null) {
            i2 = value.hashCode();
        }
        return i ^ i2;
    }

    @Override // java.util.Map.Entry
    public V setValue(V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.lang.Object
    public String toString() {
        String valueOf = String.valueOf(getKey());
        String valueOf2 = String.valueOf(getValue());
        return a.s2(valueOf2.length() + valueOf.length() + 1, valueOf, "=", valueOf2);
    }
}
