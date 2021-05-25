package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
public class LruCache<T, Y> {
    public final Map<T, Y> a = new LinkedHashMap(100, 0.75f, true);
    public final long b;
    public long c;
    public long d;

    public LruCache(long j) {
        this.b = j;
        this.c = j;
    }

    public void clearMemory() {
        trimToSize(0);
    }

    public synchronized boolean contains(@NonNull T t) {
        return this.a.containsKey(t);
    }

    @Nullable
    public synchronized Y get(@NonNull T t) {
        return this.a.get(t);
    }

    public synchronized int getCount() {
        return this.a.size();
    }

    public synchronized long getCurrentSize() {
        return this.d;
    }

    public synchronized long getMaxSize() {
        return this.c;
    }

    public int getSize(@Nullable Y y) {
        return 1;
    }

    public void onItemEvicted(@NonNull T t, @Nullable Y y) {
    }

    @Nullable
    public synchronized Y put(@NonNull T t, @Nullable Y y) {
        long size = (long) getSize(y);
        if (size >= this.c) {
            onItemEvicted(t, y);
            return null;
        }
        if (y != null) {
            this.d += size;
        }
        Y put = this.a.put(t, y);
        if (put != null) {
            this.d -= (long) getSize(put);
            if (!put.equals(y)) {
                onItemEvicted(t, put);
            }
        }
        trimToSize(this.c);
        return put;
    }

    @Nullable
    public synchronized Y remove(@NonNull T t) {
        Y remove;
        remove = this.a.remove(t);
        if (remove != null) {
            this.d -= (long) getSize(remove);
        }
        return remove;
    }

    public synchronized void setSizeMultiplier(float f) {
        if (f >= 0.0f) {
            long round = (long) Math.round(((float) this.b) * f);
            this.c = round;
            trimToSize(round);
        } else {
            throw new IllegalArgumentException("Multiplier must be >= 0");
        }
    }

    public synchronized void trimToSize(long j) {
        while (this.d > j) {
            Iterator<Map.Entry<T, Y>> it = this.a.entrySet().iterator();
            Map.Entry<T, Y> next = it.next();
            Y value = next.getValue();
            this.d -= (long) getSize(value);
            T key = next.getKey();
            it.remove();
            onItemEvicted(key, value);
        }
    }
}
