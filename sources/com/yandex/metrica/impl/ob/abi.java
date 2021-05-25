package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class abi<K, V> {
    @NonNull
    private final Map<K, V> a;
    @NonNull
    private final V b;

    public abi(@NonNull V v) {
        this(new HashMap(), v);
    }

    public void a(@Nullable K k, @Nullable V v) {
        this.a.put(k, v);
    }

    @VisibleForTesting
    public abi(@NonNull Map<K, V> map, @NonNull V v) {
        this.a = map;
        this.b = v;
    }

    @NonNull
    public V a(@Nullable K k) {
        V v = this.a.get(k);
        return v == null ? this.b : v;
    }

    @NonNull
    public Set<K> a() {
        return this.a.keySet();
    }
}
