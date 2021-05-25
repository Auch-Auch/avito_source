package com.facebook.imagepipeline.memory;

import android.util.SparseArray;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.infer.annotation.ThreadSafe;
import java.util.LinkedList;
import javax.annotation.Nullable;
@ThreadSafe
public class BucketMap<T> {
    @VisibleForTesting
    @Nullable
    public b<T> a;
    @VisibleForTesting
    @Nullable
    public b<T> b;
    public final SparseArray<b<T>> mMap = new SparseArray<>();

    @VisibleForTesting
    public static class b<I> {
        @Nullable
        public b<I> a = null;
        public int b;
        public LinkedList<I> c;
        @Nullable
        public b<I> d;

        public b(b bVar, int i, LinkedList linkedList, b bVar2, a aVar) {
            this.b = i;
            this.c = linkedList;
            this.d = null;
        }

        public String toString() {
            return a2.b.a.a.a.j(a2.b.a.a.a.L("LinkedEntry(key: "), this.b, ")");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.imagepipeline.memory.BucketMap$b<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void a(b<T> bVar) {
        if (this.a != bVar) {
            b(bVar);
            b bVar2 = (b<T>) this.a;
            if (bVar2 == null) {
                this.a = bVar;
                this.b = bVar;
                return;
            }
            bVar.d = bVar2;
            bVar2.a = bVar;
            this.a = bVar;
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
    @Nullable
    public synchronized T acquire(int i) {
        b<T> bVar = this.mMap.get(i);
        if (bVar == null) {
            return null;
        }
        I pollFirst = bVar.c.pollFirst();
        a(bVar);
        return pollFirst;
    }

    public final synchronized void b(b<T> bVar) {
        b bVar2 = (b<I>) bVar.a;
        b bVar3 = (b<I>) bVar.d;
        if (bVar2 != null) {
            bVar2.d = bVar3;
        }
        if (bVar3 != null) {
            bVar3.a = bVar2;
        }
        bVar.a = null;
        bVar.d = null;
        if (bVar == this.a) {
            this.a = bVar3;
        }
        if (bVar == this.b) {
            this.b = bVar2;
        }
    }

    public synchronized void release(int i, T t) {
        b<T> bVar = this.mMap.get(i);
        if (bVar == null) {
            bVar = new b<>(null, i, new LinkedList(), null, null);
            this.mMap.put(i, bVar);
        }
        bVar.c.addLast(t);
        a(bVar);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object] */
    @Nullable
    public synchronized T removeFromEnd() {
        b<T> bVar = this.b;
        if (bVar == null) {
            return null;
        }
        I pollLast = bVar.c.pollLast();
        if (bVar.c.isEmpty()) {
            b(bVar);
            this.mMap.remove(bVar.b);
        }
        return pollLast;
    }
}
