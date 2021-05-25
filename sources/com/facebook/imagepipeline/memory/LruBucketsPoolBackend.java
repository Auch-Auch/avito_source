package com.facebook.imagepipeline.memory;

import a2.g.p.d.c;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
public abstract class LruBucketsPoolBackend<T> implements c<T> {
    public final Set<T> a = new HashSet();
    public final BucketMap<T> b = new BucketMap<>();

    @Override // a2.g.p.d.c
    @Nullable
    public T get(int i) {
        T acquire = this.b.acquire(i);
        if (acquire != null) {
            synchronized (this) {
                this.a.remove(acquire);
            }
        }
        return acquire;
    }

    @Override // a2.g.p.d.c
    public abstract /* synthetic */ int getSize(T t);

    @Override // a2.g.p.d.c
    @Nullable
    public T pop() {
        T removeFromEnd = this.b.removeFromEnd();
        if (removeFromEnd != null) {
            synchronized (this) {
                this.a.remove(removeFromEnd);
            }
        }
        return removeFromEnd;
    }

    @Override // a2.g.p.d.c
    public void put(T t) {
        boolean add;
        synchronized (this) {
            add = this.a.add(t);
        }
        if (add) {
            this.b.release(getSize(t), t);
        }
    }
}
