package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class acb<K, V> {
    private final HashMap<K, Collection<V>> a = new HashMap<>();

    @NonNull
    private Collection<V> c() {
        return new ArrayList();
    }

    public int a() {
        int i = 0;
        for (Collection<V> collection : this.a.values()) {
            i += collection.size();
        }
        return i;
    }

    @Nullable
    public Collection<V> b(@Nullable K k) {
        return this.a.remove(k);
    }

    public String toString() {
        return this.a.toString();
    }

    @Nullable
    public Collection<V> b(@Nullable K k, @Nullable V v) {
        Collection<V> collection = this.a.get(k);
        if (collection == null || !collection.remove(v)) {
            return null;
        }
        return a((Collection) collection);
    }

    @Nullable
    public Collection<V> a(@Nullable K k) {
        return this.a.get(k);
    }

    @Nullable
    public Collection<V> a(@Nullable K k, @Nullable V v) {
        Collection<V> collection;
        Collection<V> collection2 = this.a.get(k);
        if (collection2 == null) {
            collection = c();
        } else {
            collection = a((Collection) collection2);
        }
        collection.add(v);
        return this.a.put(k, collection);
    }

    @NonNull
    public Set<? extends Map.Entry<K, ? extends Collection<V>>> b() {
        return this.a.entrySet();
    }

    @NonNull
    private Collection<V> a(@NonNull Collection<V> collection) {
        return new ArrayList(collection);
    }
}
