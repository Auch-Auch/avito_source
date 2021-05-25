package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Predicate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
public class CountingLruMap<K, V> {
    public final ValueDescriptor<V> a;
    @GuardedBy("this")
    public final LinkedHashMap<K, V> b = new LinkedHashMap<>();
    @GuardedBy("this")
    public int c = 0;

    public CountingLruMap(ValueDescriptor<V> valueDescriptor) {
        this.a = valueDescriptor;
    }

    public final int a(V v) {
        if (v == null) {
            return 0;
        }
        return this.a.getSizeInBytes(v);
    }

    public synchronized ArrayList<V> clear() {
        ArrayList<V> arrayList;
        arrayList = new ArrayList<>(this.b.values());
        this.b.clear();
        this.c = 0;
        return arrayList;
    }

    public synchronized boolean contains(K k) {
        return this.b.containsKey(k);
    }

    @Nullable
    public synchronized V get(K k) {
        return this.b.get(k);
    }

    public synchronized int getCount() {
        return this.b.size();
    }

    @Nullable
    public synchronized K getFirstKey() {
        return this.b.isEmpty() ? null : this.b.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> getMatchingEntries(@Nullable Predicate<K> predicate) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.b.entrySet().size());
        for (Map.Entry<K, V> entry : this.b.entrySet()) {
            if (predicate == null || predicate.apply(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    public synchronized int getSizeInBytes() {
        return this.c;
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.b.remove(k);
        this.c -= a(remove);
        this.b.put(k, v);
        this.c += a(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.b.remove(k);
        this.c -= a(remove);
        return remove;
    }

    public synchronized ArrayList<V> removeAll(@Nullable Predicate<K> predicate) {
        ArrayList<V> arrayList;
        arrayList = new ArrayList<>();
        Iterator<Map.Entry<K, V>> it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (predicate == null || predicate.apply(next.getKey())) {
                arrayList.add(next.getValue());
                this.c -= a(next.getValue());
                it.remove();
            }
        }
        return arrayList;
    }
}
