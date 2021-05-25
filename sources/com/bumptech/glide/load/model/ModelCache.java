package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.util.Objects;
import java.util.Queue;
public class ModelCache<A, B> {
    public final LruCache<b<A>, B> a;

    public class a extends LruCache<b<A>, B> {
        public a(ModelCache modelCache, long j) {
            super(j);
        }

        @Override // com.bumptech.glide.util.LruCache
        public void onItemEvicted(@NonNull Object obj, @Nullable Object obj2) {
            b<?> bVar = (b) obj;
            Objects.requireNonNull(bVar);
            Queue<b<?>> queue = b.d;
            synchronized (queue) {
                queue.offer(bVar);
            }
        }
    }

    @VisibleForTesting
    public static final class b<A> {
        public static final Queue<b<?>> d = Util.createQueue(0);
        public int a;
        public int b;
        public A c;

        public static <A> b<A> a(A a3, int i, int i2) {
            b<A> bVar;
            Queue<b<?>> queue = d;
            synchronized (queue) {
                bVar = (b<A>) queue.poll();
            }
            if (bVar == null) {
                bVar = new b<>();
            }
            bVar.c = a3;
            bVar.b = i;
            bVar.a = i2;
            return bVar;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.b == bVar.b && this.a == bVar.a && this.c.equals(bVar.c)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.c.hashCode() + (((this.a * 31) + this.b) * 31);
        }
    }

    public ModelCache() {
        this(250);
    }

    public void clear() {
        this.a.clearMemory();
    }

    @Nullable
    public B get(A a3, int i, int i2) {
        b<A> a4 = b.a(a3, i, i2);
        B b2 = this.a.get(a4);
        Queue<b<?>> queue = b.d;
        synchronized (queue) {
            queue.offer(a4);
        }
        return b2;
    }

    public void put(A a3, int i, int i2, B b2) {
        this.a.put(b.a(a3, i, i2), b2);
    }

    public ModelCache(long j) {
        this.a = new a(this, j);
    }
}
