package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public abstract class ForwardingMapEntry<K, V> extends ForwardingObject implements Map.Entry<K, V> {
    @Override // com.google.common.collect.ForwardingObject
    /* renamed from: delegate */
    public abstract Map.Entry<K, V> mo147delegate();

    @Override // java.util.Map.Entry, java.lang.Object
    public boolean equals(@NullableDecl Object obj) {
        return mo147delegate().equals(obj);
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        return mo147delegate().getKey();
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return mo147delegate().getValue();
    }

    @Override // java.util.Map.Entry, java.lang.Object
    public int hashCode() {
        return mo147delegate().hashCode();
    }

    @Override // java.util.Map.Entry
    public V setValue(V v) {
        return mo147delegate().setValue(v);
    }

    public boolean standardEquals(@NullableDecl Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (!Objects.equal(getKey(), entry.getKey()) || !Objects.equal(getValue(), entry.getValue())) {
            return false;
        }
        return true;
    }

    public int standardHashCode() {
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

    @Beta
    public String standardToString() {
        return ((Object) getKey()) + "=" + ((Object) getValue());
    }
}
