package com.facebook.imagepipeline.memory;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Sets;
import com.facebook.common.internal.Throwables;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.Pool;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;
public abstract class BasePool<V> implements Pool<V> {
    public final Class<?> a;
    public final MemoryTrimmableRegistry b;
    public final PoolParams c;
    @VisibleForTesting
    public final SparseArray<a2.g.p.d.a<V>> d;
    @VisibleForTesting
    public final Set<V> e;
    public boolean f;
    @VisibleForTesting
    @GuardedBy("this")
    public final a g;
    @VisibleForTesting
    @GuardedBy("this")
    public final a h;
    public final PoolStatsTracker i;
    public boolean j;

    public static class InvalidSizeException extends RuntimeException {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public InvalidSizeException(java.lang.Object r2) {
            /*
                r1 = this;
                java.lang.String r0 = "Invalid size: "
                java.lang.StringBuilder r0 = a2.b.a.a.a.L(r0)
                java.lang.String r2 = r2.toString()
                r0.append(r2)
                java.lang.String r2 = r0.toString()
                r1.<init>(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.memory.BasePool.InvalidSizeException.<init>(java.lang.Object):void");
        }
    }

    public static class InvalidValueException extends RuntimeException {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public InvalidValueException(java.lang.Object r2) {
            /*
                r1 = this;
                java.lang.String r0 = "Invalid value: "
                java.lang.StringBuilder r0 = a2.b.a.a.a.L(r0)
                java.lang.String r2 = r2.toString()
                r0.append(r2)
                java.lang.String r2 = r0.toString()
                r1.<init>(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.memory.BasePool.InvalidValueException.<init>(java.lang.Object):void");
        }
    }

    public static class PoolSizeViolationException extends RuntimeException {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public PoolSizeViolationException(int r4, int r5, int r6, int r7) {
            /*
                r3 = this;
                java.lang.String r0 = "Pool hard cap violation? Hard cap = "
                java.lang.String r1 = " Used size = "
                java.lang.String r2 = " Free size = "
                java.lang.StringBuilder r4 = a2.b.a.a.a.N(r0, r4, r1, r5, r2)
                r4.append(r6)
                java.lang.String r5 = " Request size = "
                r4.append(r5)
                r4.append(r7)
                java.lang.String r4 = r4.toString()
                r3.<init>(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException.<init>(int, int, int, int):void");
        }
    }

    public static class SizeTooLargeException extends InvalidSizeException {
        public SizeTooLargeException(Object obj) {
            super(obj);
        }
    }

    @NotThreadSafe
    @VisibleForTesting
    public static class a {
        public int a;
        public int b;

        public void a(int i) {
            int i2;
            int i3 = this.b;
            if (i3 < i || (i2 = this.a) <= 0) {
                FLog.wtf("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.b), Integer.valueOf(this.a));
                return;
            }
            this.a = i2 - 1;
            this.b = i3 - i;
        }

        public void b(int i) {
            this.a++;
            this.b += i;
        }
    }

    public BasePool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        this.a = getClass();
        this.b = (MemoryTrimmableRegistry) Preconditions.checkNotNull(memoryTrimmableRegistry);
        PoolParams poolParams2 = (PoolParams) Preconditions.checkNotNull(poolParams);
        this.c = poolParams2;
        this.i = (PoolStatsTracker) Preconditions.checkNotNull(poolStatsTracker);
        SparseArray<a2.g.p.d.a<V>> sparseArray = new SparseArray<>();
        this.d = sparseArray;
        if (poolParams2.fixBucketsReinitialization) {
            synchronized (this) {
                SparseIntArray sparseIntArray = poolParams2.bucketSizes;
                if (sparseIntArray != null) {
                    sparseArray.clear();
                    for (int i2 = 0; i2 < sparseIntArray.size(); i2++) {
                        int keyAt = sparseIntArray.keyAt(i2);
                        this.d.put(keyAt, new a2.g.p.d.a<>(getSizeInBytes(keyAt), sparseIntArray.valueAt(i2), 0, this.c.fixBucketsReinitialization));
                    }
                    this.f = false;
                } else {
                    this.f = true;
                }
            }
        } else {
            d(new SparseIntArray(0));
        }
        this.e = Sets.newIdentityHashSet();
        this.h = new a();
        this.g = new a();
    }

    @VisibleForTesting
    public synchronized boolean a(int i2) {
        if (this.j) {
            return true;
        }
        PoolParams poolParams = this.c;
        int i3 = poolParams.maxSizeHardCap;
        int i4 = this.g.b;
        if (i2 > i3 - i4) {
            this.i.onHardCapReached();
            return false;
        }
        int i5 = poolParams.maxSizeSoftCap;
        if (i2 > i5 - (i4 + this.h.b)) {
            h(i5 - i2);
        }
        if (i2 <= i3 - (this.g.b + this.h.b)) {
            return true;
        }
        this.i.onHardCapReached();
        return false;
    }

    public abstract V alloc(int i2);

    @VisibleForTesting
    public synchronized a2.g.p.d.a<V> b(int i2) {
        a2.g.p.d.a<V> aVar = this.d.get(i2);
        if (aVar == null) {
            if (this.f) {
                if (FLog.isLoggable(2)) {
                    FLog.v(this.a, "creating new bucket %s", Integer.valueOf(i2));
                }
                a2.g.p.d.a<V> f2 = f(i2);
                this.d.put(i2, f2);
                return f2;
            }
        }
        return aVar;
    }

    @VisibleForTesting
    public synchronized boolean c() {
        boolean z;
        z = this.g.b + this.h.b > this.c.maxSizeSoftCap;
        if (z) {
            this.i.onSoftCapReached();
        }
        return z;
    }

    public final synchronized void d(SparseIntArray sparseIntArray) {
        Preconditions.checkNotNull(sparseIntArray);
        this.d.clear();
        SparseIntArray sparseIntArray2 = this.c.bucketSizes;
        if (sparseIntArray2 != null) {
            for (int i2 = 0; i2 < sparseIntArray2.size(); i2++) {
                int keyAt = sparseIntArray2.keyAt(i2);
                this.d.put(keyAt, new a2.g.p.d.a<>(getSizeInBytes(keyAt), sparseIntArray2.valueAt(i2), sparseIntArray.get(keyAt, 0), this.c.fixBucketsReinitialization));
            }
            this.f = false;
        } else {
            this.f = true;
        }
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    public final void e() {
        if (FLog.isLoggable(2)) {
            FLog.v(this.a, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.g.a), Integer.valueOf(this.g.b), Integer.valueOf(this.h.a), Integer.valueOf(this.h.b));
        }
    }

    public a2.g.p.d.a<V> f(int i2) {
        return new a2.g.p.d.a<>(getSizeInBytes(i2), Integer.MAX_VALUE, 0, this.c.fixBucketsReinitialization);
    }

    @VisibleForTesting
    public abstract void free(V v);

    public final List<a2.g.p.d.a<V>> g() {
        ArrayList arrayList = new ArrayList(this.d.size());
        int size = this.d.size();
        for (int i2 = 0; i2 < size; i2++) {
            a2.g.p.d.a<V> valueAt = this.d.valueAt(i2);
            int i3 = valueAt.a;
            int i4 = valueAt.b;
            int i5 = valueAt.e;
            if (valueAt.c() > 0) {
                arrayList.add(valueAt);
            }
            this.d.setValueAt(i2, new a2.g.p.d.a<>(getSizeInBytes(i3), i4, i5, this.c.fixBucketsReinitialization));
        }
        return arrayList;
    }

    @Override // com.facebook.common.memory.Pool
    public V get(int i2) {
        boolean z;
        int sizeInBytes;
        V value;
        synchronized (this) {
            if (c()) {
                if (this.h.b != 0) {
                    z = false;
                    Preconditions.checkState(z);
                }
            }
            z = true;
            Preconditions.checkState(z);
        }
        int bucketedSize = getBucketedSize(i2);
        synchronized (this) {
            a2.g.p.d.a<V> b2 = b(bucketedSize);
            if (b2 == null || (value = getValue(b2)) == null) {
                sizeInBytes = getSizeInBytes(bucketedSize);
                if (a(sizeInBytes)) {
                    this.g.b(sizeInBytes);
                    if (b2 != null) {
                        b2.e++;
                    }
                } else {
                    throw new PoolSizeViolationException(this.c.maxSizeHardCap, this.g.b, this.h.b, sizeInBytes);
                }
            } else {
                Preconditions.checkState(this.e.add(value));
                int bucketedSizeForValue = getBucketedSizeForValue(value);
                int sizeInBytes2 = getSizeInBytes(bucketedSizeForValue);
                this.g.b(sizeInBytes2);
                this.h.a(sizeInBytes2);
                this.i.onValueReuse(sizeInBytes2);
                e();
                if (FLog.isLoggable(2)) {
                    FLog.v(this.a, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(value)), Integer.valueOf(bucketedSizeForValue));
                }
                return value;
            }
        }
        V v = null;
        try {
            v = alloc(bucketedSize);
        } catch (Throwable th) {
            synchronized (this) {
                this.g.a(sizeInBytes);
                a2.g.p.d.a<V> b3 = b(bucketedSize);
                if (b3 != null) {
                    b3.b();
                }
                Throwables.propagateIfPossible(th);
            }
        }
        synchronized (this) {
            Preconditions.checkState(this.e.add(v));
            synchronized (this) {
                if (c()) {
                    h(this.c.maxSizeSoftCap);
                }
            }
            return v;
        }
        this.i.onAlloc(sizeInBytes);
        e();
        if (FLog.isLoggable(2)) {
            FLog.v(this.a, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bucketedSize));
        }
        return v;
    }

    public abstract int getBucketedSize(int i2);

    public abstract int getBucketedSizeForValue(V v);

    public abstract int getSizeInBytes(int i2);

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.util.HashMap */
    /* JADX WARN: Multi-variable type inference failed */
    public synchronized Map<String, Integer> getStats() {
        HashMap hashMap;
        hashMap = new HashMap();
        for (int i2 = 0; i2 < this.d.size(); i2++) {
            int keyAt = this.d.keyAt(i2);
            hashMap.put(PoolStatsTracker.BUCKETS_USED_PREFIX + getSizeInBytes(keyAt), Integer.valueOf(this.d.valueAt(i2).e));
        }
        hashMap.put(PoolStatsTracker.SOFT_CAP, Integer.valueOf(this.c.maxSizeSoftCap));
        hashMap.put(PoolStatsTracker.HARD_CAP, Integer.valueOf(this.c.maxSizeHardCap));
        hashMap.put(PoolStatsTracker.USED_COUNT, Integer.valueOf(this.g.a));
        hashMap.put(PoolStatsTracker.USED_BYTES, Integer.valueOf(this.g.b));
        hashMap.put(PoolStatsTracker.FREE_COUNT, Integer.valueOf(this.h.a));
        hashMap.put(PoolStatsTracker.FREE_BYTES, Integer.valueOf(this.h.b));
        return hashMap;
    }

    @Nullable
    public synchronized V getValue(a2.g.p.d.a<V> aVar) {
        V d2;
        d2 = aVar.d();
        if (d2 != null) {
            aVar.e++;
        }
        return d2;
    }

    @VisibleForTesting
    public synchronized void h(int i2) {
        int i3 = this.g.b;
        int i4 = this.h.b;
        int min = Math.min((i3 + i4) - i2, i4);
        if (min > 0) {
            if (FLog.isLoggable(2)) {
                FLog.v(this.a, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i2), Integer.valueOf(this.g.b + this.h.b), Integer.valueOf(min));
            }
            e();
            for (int i5 = 0; i5 < this.d.size() && min > 0; i5++) {
                a2.g.p.d.a<V> valueAt = this.d.valueAt(i5);
                while (min > 0) {
                    V d2 = valueAt.d();
                    if (d2 == null) {
                        break;
                    }
                    free(d2);
                    int i6 = valueAt.a;
                    min -= i6;
                    this.h.a(i6);
                }
            }
            e();
            if (FLog.isLoggable(2)) {
                FLog.v(this.a, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i2), Integer.valueOf(this.g.b + this.h.b));
            }
        }
    }

    public void initialize() {
        this.b.registerMemoryTrimmable(this);
        this.i.setBasePool(this);
    }

    public boolean isReusable(V v) {
        Preconditions.checkNotNull(v);
        return true;
    }

    public void onParamsChanged() {
    }

    @Override // com.facebook.common.memory.Pool, com.facebook.common.references.ResourceReleaser
    public void release(V v) {
        a2.g.p.d.a<V> aVar;
        Preconditions.checkNotNull(v);
        int bucketedSizeForValue = getBucketedSizeForValue(v);
        int sizeInBytes = getSizeInBytes(bucketedSizeForValue);
        synchronized (this) {
            synchronized (this) {
                aVar = this.d.get(bucketedSizeForValue);
            }
        }
        boolean z = true;
        if (!this.e.remove(v)) {
            FLog.e(this.a, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bucketedSizeForValue));
            free(v);
            this.i.onFree(sizeInBytes);
        } else {
            if (aVar != null) {
                if (aVar.c() + aVar.e <= aVar.b) {
                    z = false;
                }
                if (!z && !c() && isReusable(v)) {
                    aVar.e(v);
                    this.h.b(sizeInBytes);
                    this.g.a(sizeInBytes);
                    this.i.onValueRelease(sizeInBytes);
                    if (FLog.isLoggable(2)) {
                        FLog.v(this.a, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bucketedSizeForValue));
                    }
                }
            }
            if (aVar != null) {
                aVar.b();
            }
            if (FLog.isLoggable(2)) {
                FLog.v(this.a, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bucketedSizeForValue));
            }
            free(v);
            this.g.a(sizeInBytes);
            this.i.onFree(sizeInBytes);
        }
        e();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.facebook.imagepipeline.memory.BasePool<V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.common.memory.MemoryTrimmable
    public void trim(MemoryTrimType memoryTrimType) {
        int i2;
        ArrayList arrayList;
        synchronized (this) {
            if (this.c.fixBucketsReinitialization) {
                arrayList = g();
            } else {
                ArrayList arrayList2 = new ArrayList(this.d.size());
                SparseIntArray sparseIntArray = new SparseIntArray();
                for (int i3 = 0; i3 < this.d.size(); i3++) {
                    a2.g.p.d.a<V> valueAt = this.d.valueAt(i3);
                    if (valueAt.c() > 0) {
                        arrayList2.add(valueAt);
                    }
                    sparseIntArray.put(this.d.keyAt(i3), valueAt.e);
                }
                d(sparseIntArray);
                arrayList = arrayList2;
            }
            a aVar = this.h;
            aVar.a = 0;
            aVar.b = 0;
            e();
        }
        onParamsChanged();
        for (i2 = 0; i2 < arrayList.size(); i2++) {
            a2.g.p.d.a aVar2 = (a2.g.p.d.a) arrayList.get(i2);
            while (true) {
                Object d2 = aVar2.d();
                if (d2 == null) {
                    break;
                }
                free(d2);
            }
        }
    }

    public BasePool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker, boolean z) {
        this(memoryTrimmableRegistry, poolParams, poolStatsTracker);
        this.j = z;
    }
}
