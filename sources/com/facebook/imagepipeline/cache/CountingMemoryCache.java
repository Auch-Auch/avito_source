package com.facebook.imagepipeline.cache;

import a2.g.p.a.d;
import android.graphics.Bitmap;
import android.os.SystemClock;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Predicate;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imagepipeline.cache.MemoryCache;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
public class CountingMemoryCache<K, V> implements MemoryCache<K, V>, MemoryTrimmable {
    @Nullable
    public final EntryStateObserver<K> a;
    @VisibleForTesting
    @GuardedBy("this")
    public final CountingLruMap<K, b<K, V>> b;
    @VisibleForTesting
    @GuardedBy("this")
    public final CountingLruMap<K, b<K, V>> c;
    @VisibleForTesting
    @GuardedBy("this")
    public final Map<Bitmap, Object> d = new WeakHashMap();
    public final ValueDescriptor<V> e;
    public final MemoryCache.CacheTrimStrategy f;
    public final Supplier<MemoryCacheParams> g;
    @GuardedBy("this")
    public long h;
    @GuardedBy("this")
    public MemoryCacheParams mMemoryCacheParams;

    public interface EntryStateObserver<K> {
        void onExclusivityChanged(K k, boolean z);
    }

    public class a implements ResourceReleaser<V> {
        public final /* synthetic */ b a;

        public a(b bVar) {
            this.a = bVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x0040  */
        @Override // com.facebook.common.references.ResourceReleaser
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void release(V r5) {
            /*
                r4 = this;
                com.facebook.imagepipeline.cache.CountingMemoryCache r5 = com.facebook.imagepipeline.cache.CountingMemoryCache.this
                com.facebook.imagepipeline.cache.CountingMemoryCache$b r0 = r4.a
                java.util.Objects.requireNonNull(r5)
                com.facebook.common.internal.Preconditions.checkNotNull(r0)
                monitor-enter(r5)
                monitor-enter(r5)     // Catch:{ all -> 0x0059 }
                com.facebook.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ all -> 0x0056 }
                int r1 = r0.c     // Catch:{ all -> 0x0056 }
                r2 = 0
                r3 = 1
                if (r1 <= 0) goto L_0x0017
                r1 = 1
                goto L_0x0018
            L_0x0017:
                r1 = 0
            L_0x0018:
                com.facebook.common.internal.Preconditions.checkState(r1)     // Catch:{ all -> 0x0056 }
                int r1 = r0.c     // Catch:{ all -> 0x0056 }
                int r1 = r1 - r3
                r0.c = r1     // Catch:{ all -> 0x0056 }
                monitor-exit(r5)
                monitor-enter(r5)
                boolean r1 = r0.d     // Catch:{ all -> 0x0053 }
                if (r1 != 0) goto L_0x0034
                int r1 = r0.c     // Catch:{ all -> 0x0053 }
                if (r1 != 0) goto L_0x0034
                com.facebook.imagepipeline.cache.CountingLruMap<K, com.facebook.imagepipeline.cache.CountingMemoryCache$b<K, V>> r1 = r5.b     // Catch:{ all -> 0x0053 }
                K r2 = r0.a     // Catch:{ all -> 0x0053 }
                r1.put(r2, r0)     // Catch:{ all -> 0x0053 }
                monitor-exit(r5)
                r2 = 1
                goto L_0x0035
            L_0x0034:
                monitor-exit(r5)
            L_0x0035:
                com.facebook.common.references.CloseableReference r1 = r5.i(r0)
                monitor-exit(r5)
                com.facebook.common.references.CloseableReference.closeSafely(r1)
                if (r2 == 0) goto L_0x0040
                goto L_0x0041
            L_0x0040:
                r0 = 0
            L_0x0041:
                if (r0 == 0) goto L_0x004c
                com.facebook.imagepipeline.cache.CountingMemoryCache$EntryStateObserver<K> r1 = r0.e
                if (r1 == 0) goto L_0x004c
                K r0 = r0.a
                r1.onExclusivityChanged(r0, r3)
            L_0x004c:
                r5.g()
                r5.d()
                return
            L_0x0053:
                r0 = move-exception
                monitor-exit(r5)
                throw r0
            L_0x0056:
                r0 = move-exception
                monitor-exit(r5)
                throw r0
            L_0x0059:
                r0 = move-exception
                monitor-exit(r5)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.cache.CountingMemoryCache.a.release(java.lang.Object):void");
        }
    }

    @VisibleForTesting
    public static class b<K, V> {
        public final K a;
        public final CloseableReference<V> b;
        public int c = 0;
        public boolean d = false;
        @Nullable
        public final EntryStateObserver<K> e;

        public b(K k, CloseableReference<V> closeableReference, @Nullable EntryStateObserver<K> entryStateObserver) {
            this.a = (K) Preconditions.checkNotNull(k);
            this.b = (CloseableReference) Preconditions.checkNotNull(CloseableReference.cloneOrNull(closeableReference));
            this.e = entryStateObserver;
        }
    }

    public CountingMemoryCache(ValueDescriptor<V> valueDescriptor, MemoryCache.CacheTrimStrategy cacheTrimStrategy, Supplier<MemoryCacheParams> supplier, @Nullable EntryStateObserver<K> entryStateObserver) {
        this.e = valueDescriptor;
        this.b = new CountingLruMap<>(new d(this, valueDescriptor));
        this.c = new CountingLruMap<>(new d(this, valueDescriptor));
        this.f = cacheTrimStrategy;
        this.g = supplier;
        this.mMemoryCacheParams = supplier.get();
        this.h = SystemClock.uptimeMillis();
        this.a = entryStateObserver;
    }

    public static <K, V> void e(@Nullable b<K, V> bVar) {
        EntryStateObserver<K> entryStateObserver;
        if (bVar != null && (entryStateObserver = bVar.e) != null) {
            entryStateObserver.onExclusivityChanged(bVar.a, false);
        }
    }

    public final synchronized void a(b<K, V> bVar) {
        Preconditions.checkNotNull(bVar);
        Preconditions.checkState(!bVar.d);
        bVar.d = true;
    }

    public final synchronized void b(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
        }
    }

    public final void c(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                CloseableReference.closeSafely((CloseableReference<?>) i(it.next()));
            }
        }
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public CloseableReference<V> cache(K k, CloseableReference<V> closeableReference) {
        return cache(k, closeableReference, this.a);
    }

    public void clear() {
        ArrayList<b<K, V>> clear;
        ArrayList<b<K, V>> clear2;
        synchronized (this) {
            clear = this.b.clear();
            clear2 = this.c.clear();
            b(clear2);
        }
        c(clear2);
        f(clear);
        g();
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public synchronized boolean contains(Predicate<K> predicate) {
        return !this.c.getMatchingEntries(predicate).isEmpty();
    }

    public final void d() {
        ArrayList<b<K, V>> j;
        synchronized (this) {
            MemoryCacheParams memoryCacheParams = this.mMemoryCacheParams;
            int min = Math.min(memoryCacheParams.maxEvictionQueueEntries, memoryCacheParams.maxCacheEntries - getInUseCount());
            MemoryCacheParams memoryCacheParams2 = this.mMemoryCacheParams;
            j = j(min, Math.min(memoryCacheParams2.maxEvictionQueueSize, memoryCacheParams2.maxCacheSize - getInUseSizeInBytes()));
            b(j);
        }
        c(j);
        f(j);
    }

    public final void f(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                e(it.next());
            }
        }
    }

    public final synchronized void g() {
        if (this.h + this.mMemoryCacheParams.paramsCheckIntervalMs <= SystemClock.uptimeMillis()) {
            this.h = SystemClock.uptimeMillis();
            this.mMemoryCacheParams = this.g.get();
        }
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    @Nullable
    public CloseableReference<V> get(K k) {
        b<K, V> remove;
        CloseableReference<V> h2;
        Preconditions.checkNotNull(k);
        synchronized (this) {
            remove = this.b.remove(k);
            b<K, V> bVar = this.c.get(k);
            h2 = bVar != null ? h(bVar) : null;
        }
        e(remove);
        g();
        d();
        return h2;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public synchronized int getCount() {
        return this.c.getCount();
    }

    public synchronized int getEvictionQueueCount() {
        return this.b.getCount();
    }

    public synchronized int getEvictionQueueSizeInBytes() {
        return this.b.getSizeInBytes();
    }

    public synchronized int getInUseCount() {
        return this.c.getCount() - this.b.getCount();
    }

    public synchronized int getInUseSizeInBytes() {
        return this.c.getSizeInBytes() - this.b.getSizeInBytes();
    }

    public MemoryCacheParams getMemoryCacheParams() {
        return this.mMemoryCacheParams;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public synchronized int getSizeInBytes() {
        return this.c.getSizeInBytes();
    }

    public final synchronized CloseableReference<V> h(b<K, V> bVar) {
        synchronized (this) {
            Preconditions.checkNotNull(bVar);
            Preconditions.checkState(!bVar.d);
            bVar.c++;
        }
        return CloseableReference.of(bVar.b.get(), new a(bVar));
        return CloseableReference.of(bVar.b.get(), new a(bVar));
    }

    @Nullable
    public final synchronized CloseableReference<V> i(b<K, V> bVar) {
        Preconditions.checkNotNull(bVar);
        return (!bVar.d || bVar.c != 0) ? null : bVar.b;
    }

    @Nullable
    public final synchronized ArrayList<b<K, V>> j(int i, int i2) {
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (this.b.getCount() <= max && this.b.getSizeInBytes() <= max2) {
            return null;
        }
        ArrayList<b<K, V>> arrayList = new ArrayList<>();
        while (true) {
            if (this.b.getCount() <= max && this.b.getSizeInBytes() <= max2) {
                return arrayList;
            }
            K firstKey = this.b.getFirstKey();
            this.b.remove(firstKey);
            arrayList.add(this.c.remove(firstKey));
        }
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public void probe(K k) {
        Preconditions.checkNotNull(k);
        synchronized (this) {
            b<K, V> remove = this.b.remove(k);
            if (remove != null) {
                this.b.put(k, remove);
            }
        }
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public int removeAll(Predicate<K> predicate) {
        ArrayList<b<K, V>> removeAll;
        ArrayList<b<K, V>> removeAll2;
        synchronized (this) {
            removeAll = this.b.removeAll(predicate);
            removeAll2 = this.c.removeAll(predicate);
            b(removeAll2);
        }
        c(removeAll2);
        f(removeAll);
        g();
        d();
        return removeAll2.size();
    }

    public String reportData() {
        return Objects.toStringHelper("CountingMemoryCache").add("cached_entries_count:", this.c.getCount()).add("cached_entries_size_bytes", this.c.getSizeInBytes()).add("exclusive_entries_count", this.b.getCount()).add("exclusive_entries_size_bytes", this.b.getSizeInBytes()).toString();
    }

    @Nullable
    public CloseableReference<V> reuse(K k) {
        b<K, V> remove;
        boolean z;
        CloseableReference<V> closeableReference;
        Preconditions.checkNotNull(k);
        synchronized (this) {
            remove = this.b.remove(k);
            z = true;
            boolean z2 = false;
            if (remove != null) {
                b<K, V> remove2 = this.c.remove(k);
                Preconditions.checkNotNull(remove2);
                if (remove2.c == 0) {
                    z2 = true;
                }
                Preconditions.checkState(z2);
                closeableReference = remove2.b;
            } else {
                closeableReference = null;
                z = false;
            }
        }
        if (z) {
            e(remove);
        }
        return closeableReference;
    }

    @Override // com.facebook.common.memory.MemoryTrimmable
    public void trim(MemoryTrimType memoryTrimType) {
        ArrayList<b<K, V>> j;
        double trimRatio = this.f.getTrimRatio(memoryTrimType);
        synchronized (this) {
            j = j(Integer.MAX_VALUE, Math.max(0, ((int) ((1.0d - trimRatio) * ((double) this.c.getSizeInBytes()))) - getInUseSizeInBytes()));
            b(j);
        }
        c(j);
        f(j);
        g();
        d();
    }

    @Nullable
    public CloseableReference<V> cache(K k, CloseableReference<V> closeableReference, EntryStateObserver<K> entryStateObserver) {
        CloseableReference<V> closeableReference2;
        CloseableReference<V> closeableReference3;
        boolean z;
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(closeableReference);
        g();
        synchronized (this) {
            b<K, V> remove = this.b.remove(k);
            b<K, V> remove2 = this.c.remove(k);
            closeableReference2 = null;
            if (remove2 != null) {
                a(remove2);
                closeableReference3 = i(remove2);
            } else {
                closeableReference3 = null;
            }
            V v = closeableReference.get();
            synchronized (this) {
                int sizeInBytes = this.e.getSizeInBytes(v);
                z = true;
                if (sizeInBytes > this.mMemoryCacheParams.maxCacheEntrySize || getInUseCount() > this.mMemoryCacheParams.maxCacheEntries - 1 || getInUseSizeInBytes() > this.mMemoryCacheParams.maxCacheSize - sizeInBytes) {
                    z = false;
                }
            }
            CloseableReference.closeSafely((CloseableReference<?>) closeableReference3);
            e(remove);
            d();
            return closeableReference2;
        }
        if (z) {
            b<K, V> bVar = new b<>(k, closeableReference, entryStateObserver);
            this.c.put(k, bVar);
            closeableReference2 = h(bVar);
        }
        CloseableReference.closeSafely((CloseableReference<?>) closeableReference3);
        e(remove);
        d();
        return closeableReference2;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public synchronized boolean contains(K k) {
        return this.c.contains(k);
    }
}
