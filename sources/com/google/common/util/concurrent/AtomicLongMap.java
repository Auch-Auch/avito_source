package com.google.common.util.concurrent;

import a2.j.d.l.a.i;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
@GwtCompatible
public final class AtomicLongMap<K> implements Serializable {
    public final ConcurrentHashMap<K, AtomicLong> a;
    @MonotonicNonNullDecl
    public transient Map<K, Long> b;

    public AtomicLongMap(ConcurrentHashMap<K, AtomicLong> concurrentHashMap) {
        this.a = (ConcurrentHashMap) Preconditions.checkNotNull(concurrentHashMap);
    }

    public static <K> AtomicLongMap<K> create() {
        return new AtomicLongMap<>(new ConcurrentHashMap());
    }

    @CanIgnoreReturnValue
    public long addAndGet(K k, long j) {
        AtomicLong atomicLong;
        do {
            atomicLong = this.a.get(k);
            if (atomicLong == null && (atomicLong = this.a.putIfAbsent(k, new AtomicLong(j))) == null) {
                return j;
            }
            while (true) {
                long j2 = atomicLong.get();
                if (j2 != 0) {
                    long j3 = j2 + j;
                    if (atomicLong.compareAndSet(j2, j3)) {
                        return j3;
                    }
                }
            }
        } while (!this.a.replace(k, atomicLong, new AtomicLong(j)));
        return j;
    }

    public Map<K, Long> asMap() {
        Map<K, Long> map = this.b;
        if (map != null) {
            return map;
        }
        Map<K, Long> unmodifiableMap = Collections.unmodifiableMap(Maps.transformValues(this.a, new i(this)));
        this.b = unmodifiableMap;
        return unmodifiableMap;
    }

    public void clear() {
        this.a.clear();
    }

    public boolean containsKey(Object obj) {
        return this.a.containsKey(obj);
    }

    @CanIgnoreReturnValue
    public long decrementAndGet(K k) {
        return addAndGet(k, -1);
    }

    public long get(K k) {
        AtomicLong atomicLong = this.a.get(k);
        if (atomicLong == null) {
            return 0;
        }
        return atomicLong.get();
    }

    @CanIgnoreReturnValue
    public long getAndAdd(K k, long j) {
        AtomicLong atomicLong;
        do {
            atomicLong = this.a.get(k);
            if (atomicLong == null && (atomicLong = this.a.putIfAbsent(k, new AtomicLong(j))) == null) {
                return 0;
            }
            while (true) {
                long j2 = atomicLong.get();
                if (j2 != 0) {
                    if (atomicLong.compareAndSet(j2, j2 + j)) {
                        return j2;
                    }
                }
            }
        } while (!this.a.replace(k, atomicLong, new AtomicLong(j)));
        return 0;
    }

    @CanIgnoreReturnValue
    public long getAndDecrement(K k) {
        return getAndAdd(k, -1);
    }

    @CanIgnoreReturnValue
    public long getAndIncrement(K k) {
        return getAndAdd(k, 1);
    }

    @CanIgnoreReturnValue
    public long incrementAndGet(K k) {
        return addAndGet(k, 1);
    }

    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @CanIgnoreReturnValue
    public long put(K k, long j) {
        AtomicLong atomicLong;
        do {
            atomicLong = this.a.get(k);
            if (atomicLong == null && (atomicLong = this.a.putIfAbsent(k, new AtomicLong(j))) == null) {
                return 0;
            }
            while (true) {
                long j2 = atomicLong.get();
                if (j2 != 0) {
                    if (atomicLong.compareAndSet(j2, j)) {
                        return j2;
                    }
                }
            }
        } while (!this.a.replace(k, atomicLong, new AtomicLong(j)));
        return 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.util.concurrent.AtomicLongMap<K> */
    /* JADX WARN: Multi-variable type inference failed */
    public void putAll(Map<? extends K, ? extends Long> map) {
        for (Map.Entry<? extends K, ? extends Long> entry : map.entrySet()) {
            put(entry.getKey(), ((Long) entry.getValue()).longValue());
        }
    }

    @CanIgnoreReturnValue
    public long remove(K k) {
        long j;
        AtomicLong atomicLong = this.a.get(k);
        if (atomicLong == null) {
            return 0;
        }
        do {
            j = atomicLong.get();
            if (j == 0) {
                break;
            }
        } while (!atomicLong.compareAndSet(j, 0));
        this.a.remove(k, atomicLong);
        return j;
    }

    public void removeAllZeros() {
        Iterator<Map.Entry<K, AtomicLong>> it = this.a.entrySet().iterator();
        while (it.hasNext()) {
            AtomicLong value = it.next().getValue();
            if (value != null && value.get() == 0) {
                it.remove();
            }
        }
    }

    @CanIgnoreReturnValue
    @Beta
    public boolean removeIfZero(K k) {
        long j;
        int i;
        AtomicLong atomicLong = this.a.get(k);
        if (atomicLong == null || (j = atomicLong.get()) != 0) {
            return false;
        }
        if (i != 0 && !atomicLong.compareAndSet(j, 0)) {
            return false;
        }
        this.a.remove(k, atomicLong);
        return true;
    }

    public int size() {
        return this.a.size();
    }

    public long sum() {
        long j = 0;
        for (AtomicLong atomicLong : this.a.values()) {
            j += atomicLong.get();
        }
        return j;
    }

    @Override // java.lang.Object
    public String toString() {
        return this.a.toString();
    }

    public static <K> AtomicLongMap<K> create(Map<? extends K, ? extends Long> map) {
        AtomicLongMap<K> create = create();
        create.putAll(map);
        return create;
    }
}
