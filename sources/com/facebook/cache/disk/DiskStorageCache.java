package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.CacheKeyUtil;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.common.disk.DiskTrimmable;
import com.facebook.common.disk.DiskTrimmableRegistry;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClock;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
public class DiskStorageCache implements FileCache, DiskTrimmable {
    public static final int START_OF_VERSIONING = 1;
    public static final long r = TimeUnit.HOURS.toMillis(2);
    public static final long s = TimeUnit.MINUTES.toMillis(30);
    public final long a;
    public final long b;
    public final CountDownLatch c;
    public long d;
    public final CacheEventListener e;
    @VisibleForTesting
    @GuardedBy("mLock")
    public final Set<String> f;
    public long g;
    public final long h;
    public final StatFsHelper i;
    public final DiskStorage j;
    public final EntryEvictionComparatorSupplier k;
    public final CacheErrorLogger l;
    public final boolean m;
    public final b n;
    public final Clock o;
    public final Object p = new Object();
    public boolean q;

    public static class Params {
        public final long mCacheSizeLimitMinimum;
        public final long mDefaultCacheSizeLimit;
        public final long mLowDiskSpaceCacheSizeLimit;

        public Params(long j, long j2, long j3) {
            this.mCacheSizeLimitMinimum = j;
            this.mLowDiskSpaceCacheSizeLimit = j2;
            this.mDefaultCacheSizeLimit = j3;
        }
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (DiskStorageCache.this.p) {
                DiskStorageCache.this.c();
            }
            DiskStorageCache diskStorageCache = DiskStorageCache.this;
            diskStorageCache.q = true;
            diskStorageCache.c.countDown();
        }
    }

    @VisibleForTesting
    public static class b {
        public boolean a = false;
        public long b = -1;
        public long c = -1;

        public synchronized long a() {
            return this.b;
        }

        public synchronized void b(long j, long j2) {
            if (this.a) {
                this.b += j;
                this.c += j2;
            }
        }

        public synchronized void c() {
            this.a = false;
            this.c = -1;
            this.b = -1;
        }
    }

    public DiskStorageCache(DiskStorage diskStorage, EntryEvictionComparatorSupplier entryEvictionComparatorSupplier, Params params, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable DiskTrimmableRegistry diskTrimmableRegistry, Executor executor, boolean z) {
        this.a = params.mLowDiskSpaceCacheSizeLimit;
        long j2 = params.mDefaultCacheSizeLimit;
        this.b = j2;
        this.d = j2;
        this.i = StatFsHelper.getInstance();
        this.j = diskStorage;
        this.k = entryEvictionComparatorSupplier;
        this.g = -1;
        this.e = cacheEventListener;
        this.h = params.mCacheSizeLimitMinimum;
        this.l = cacheErrorLogger;
        this.n = new b();
        this.o = SystemClock.get();
        this.m = z;
        this.f = new HashSet();
        if (diskTrimmableRegistry != null) {
            diskTrimmableRegistry.registerDiskTrimmable(this);
        }
        if (z) {
            this.c = new CountDownLatch(1);
            executor.execute(new a());
            return;
        }
        this.c = new CountDownLatch(0);
    }

    @GuardedBy("mLock")
    public final void a(long j2, CacheEventListener.EvictionReason evictionReason) throws IOException {
        try {
            Collection<DiskStorage.Entry> b2 = b(this.j.getEntries());
            long a3 = this.n.a();
            long j3 = a3 - j2;
            int i2 = 0;
            Iterator it = ((ArrayList) b2).iterator();
            long j4 = 0;
            while (it.hasNext()) {
                DiskStorage.Entry entry = (DiskStorage.Entry) it.next();
                if (j4 > j3) {
                    break;
                }
                long remove = this.j.remove(entry);
                this.f.remove(entry.getId());
                if (remove > 0) {
                    i2++;
                    j4 += remove;
                    SettableCacheEvent cacheLimit = SettableCacheEvent.obtain().setResourceId(entry.getId()).setEvictionReason(evictionReason).setItemSize(remove).setCacheSize(a3 - j4).setCacheLimit(j2);
                    this.e.onEviction(cacheLimit);
                    cacheLimit.recycle();
                }
            }
            this.n.b(-j4, (long) (-i2));
            this.j.purgeUnexpectedResources();
        } catch (IOException e2) {
            this.l.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, DiskStorageCache.class, a2.b.a.a.a.A2(e2, a2.b.a.a.a.L("evictAboveSize: ")), e2);
            throw e2;
        }
    }

    @VisibleForTesting
    public void awaitIndex() {
        try {
            this.c.await();
        } catch (InterruptedException unused) {
            FLog.e(DiskStorageCache.class, "Memory Index is not ready yet. ");
        }
    }

    public final Collection<DiskStorage.Entry> b(Collection<DiskStorage.Entry> collection) {
        long now = this.o.now() + r;
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (DiskStorage.Entry entry : collection) {
            if (entry.getTimestamp() > now) {
                arrayList.add(entry);
            } else {
                arrayList2.add(entry);
            }
        }
        Collections.sort(arrayList2, this.k.get());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    public final boolean c() {
        boolean z;
        Set<String> set;
        long j2;
        Set<String> set2;
        long j3;
        long now = this.o.now();
        b bVar = this.n;
        synchronized (bVar) {
            z = bVar.a;
        }
        long j4 = -1;
        int i2 = 0;
        if (z) {
            long j5 = this.g;
            if (j5 != -1 && now - j5 <= s) {
                return false;
            }
        }
        long now2 = this.o.now();
        long j6 = r + now2;
        if (!this.m || !this.f.isEmpty()) {
            set = this.m ? new HashSet<>() : null;
        } else {
            set = this.f;
        }
        try {
            long j7 = 0;
            int i3 = 0;
            int i4 = 0;
            boolean z2 = false;
            for (DiskStorage.Entry entry : this.j.getEntries()) {
                i2++;
                j7 += entry.getSize();
                if (entry.getTimestamp() > j6) {
                    i4++;
                    j3 = j6;
                    i3 = (int) (((long) i3) + entry.getSize());
                    j4 = Math.max(entry.getTimestamp() - now2, j4);
                    z2 = true;
                } else {
                    j3 = j6;
                    if (this.m) {
                        set.add(entry.getId());
                    }
                }
                j6 = j3;
            }
            if (z2) {
                CacheErrorLogger cacheErrorLogger = this.l;
                CacheErrorLogger.CacheErrorCategory cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY;
                cacheErrorLogger.logError(cacheErrorCategory, DiskStorageCache.class, "Future timestamp found in " + i4 + " files , with a total size of " + i3 + " bytes, and a maximum time delta of " + j4 + "ms", null);
            }
            b bVar2 = this.n;
            synchronized (bVar2) {
                j2 = bVar2.c;
            }
            long j8 = (long) i2;
            if (!(j2 == j8 && this.n.a() == j7)) {
                if (this.m && (set2 = this.f) != set) {
                    set2.clear();
                    this.f.addAll(set);
                }
                b bVar3 = this.n;
                synchronized (bVar3) {
                    bVar3.c = j8;
                    bVar3.b = j7;
                    bVar3.a = true;
                }
            }
            this.g = now2;
            return true;
        } catch (IOException e2) {
            this.l.logError(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, DiskStorageCache.class, a2.b.a.a.a.A2(e2, a2.b.a.a.a.L("calcFileCacheSize: ")), e2);
            return false;
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public void clearAll() {
        synchronized (this.p) {
            try {
                this.j.clearAll();
                this.f.clear();
                this.e.onCleared();
            } catch (IOException | NullPointerException e2) {
                CacheErrorLogger cacheErrorLogger = this.l;
                CacheErrorLogger.CacheErrorCategory cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.EVICTION;
                cacheErrorLogger.logError(cacheErrorCategory, DiskStorageCache.class, "clearAll: " + e2.getMessage(), e2);
            }
            this.n.c();
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public long clearOldEntries(long j2) {
        long j3;
        long j4;
        IOException e2;
        synchronized (this.p) {
            try {
                long now = this.o.now();
                Collection<DiskStorage.Entry> entries = this.j.getEntries();
                long a3 = this.n.a();
                int i2 = 0;
                long j5 = 0;
                j3 = 0;
                for (DiskStorage.Entry entry : entries) {
                    try {
                        long max = Math.max(1L, Math.abs(now - entry.getTimestamp()));
                        if (max >= j2) {
                            long remove = this.j.remove(entry);
                            this.f.remove(entry.getId());
                            if (remove > 0) {
                                i2++;
                                j5 += remove;
                                SettableCacheEvent cacheSize = SettableCacheEvent.obtain().setResourceId(entry.getId()).setEvictionReason(CacheEventListener.EvictionReason.CONTENT_STALE).setItemSize(remove).setCacheSize(a3 - j5);
                                this.e.onEviction(cacheSize);
                                cacheSize.recycle();
                            }
                        } else {
                            j3 = Math.max(j3, max);
                        }
                        now = now;
                    } catch (IOException e3) {
                        e2 = e3;
                        j4 = j3;
                        this.l.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, DiskStorageCache.class, "clearOldEntries: " + e2.getMessage(), e2);
                        j3 = j4;
                        return j3;
                    }
                }
                this.j.purgeUnexpectedResources();
                if (i2 > 0) {
                    c();
                    this.n.b(-j5, (long) (-i2));
                }
            } catch (IOException e4) {
                e2 = e4;
                j4 = 0;
                this.l.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, DiskStorageCache.class, "clearOldEntries: " + e2.getMessage(), e2);
                j3 = j4;
                return j3;
            }
        }
        return j3;
    }

    public final DiskStorage.Inserter d(String str, CacheKey cacheKey) throws IOException {
        synchronized (this.p) {
            boolean c2 = c();
            if (this.i.testLowDiskSpace(this.j.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.b - this.n.a())) {
                this.d = this.a;
            } else {
                this.d = this.b;
            }
            long a3 = this.n.a();
            if (a3 > this.d && !c2) {
                this.n.c();
                c();
            }
            long j2 = this.d;
            if (a3 > j2) {
                a((j2 * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
        return this.j.insert(str, cacheKey);
    }

    public final void e(double d2) {
        synchronized (this.p) {
            try {
                this.n.c();
                c();
                long a3 = this.n.a();
                a(a3 - ((long) (d2 * ((double) a3))), CacheEventListener.EvictionReason.CACHE_MANAGER_TRIMMED);
            } catch (IOException e2) {
                CacheErrorLogger cacheErrorLogger = this.l;
                CacheErrorLogger.CacheErrorCategory cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.EVICTION;
                cacheErrorLogger.logError(cacheErrorCategory, DiskStorageCache.class, "trimBy: " + e2.getMessage(), e2);
            }
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public long getCount() {
        long j2;
        b bVar = this.n;
        synchronized (bVar) {
            j2 = bVar.c;
        }
        return j2;
    }

    @Override // com.facebook.cache.disk.FileCache
    public DiskStorage.DiskDumpInfo getDumpInfo() throws IOException {
        return this.j.getDumpInfo();
    }

    @Override // com.facebook.cache.disk.FileCache
    @Nullable
    public BinaryResource getResource(CacheKey cacheKey) {
        BinaryResource binaryResource;
        SettableCacheEvent cacheKey2 = SettableCacheEvent.obtain().setCacheKey(cacheKey);
        try {
            synchronized (this.p) {
                List<String> resourceIds = CacheKeyUtil.getResourceIds(cacheKey);
                int i2 = 0;
                String str = null;
                binaryResource = null;
                while (true) {
                    if (i2 >= resourceIds.size()) {
                        break;
                    }
                    str = resourceIds.get(i2);
                    cacheKey2.setResourceId(str);
                    binaryResource = this.j.getResource(str, cacheKey);
                    if (binaryResource != null) {
                        break;
                    }
                    i2++;
                }
                if (binaryResource == null) {
                    this.e.onMiss(cacheKey2);
                    this.f.remove(str);
                } else {
                    this.e.onHit(cacheKey2);
                    this.f.add(str);
                }
            }
            return binaryResource;
        } catch (IOException e2) {
            this.l.logError(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, DiskStorageCache.class, "getResource", e2);
            cacheKey2.setException(e2);
            this.e.onReadException(cacheKey2);
            return null;
        } finally {
            cacheKey2.recycle();
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public long getSize() {
        return this.n.a();
    }

    @Override // com.facebook.cache.disk.FileCache
    public boolean hasKey(CacheKey cacheKey) {
        synchronized (this.p) {
            if (hasKeySync(cacheKey)) {
                return true;
            }
            try {
                List<String> resourceIds = CacheKeyUtil.getResourceIds(cacheKey);
                for (int i2 = 0; i2 < resourceIds.size(); i2++) {
                    String str = resourceIds.get(i2);
                    if (this.j.contains(str, cacheKey)) {
                        this.f.add(str);
                        return true;
                    }
                }
                return false;
            } catch (IOException unused) {
                return false;
            }
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public boolean hasKeySync(CacheKey cacheKey) {
        synchronized (this.p) {
            List<String> resourceIds = CacheKeyUtil.getResourceIds(cacheKey);
            for (int i2 = 0; i2 < resourceIds.size(); i2++) {
                if (this.f.contains(resourceIds.get(i2))) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public BinaryResource insert(CacheKey cacheKey, WriterCallback writerCallback) throws IOException {
        String firstResourceId;
        BinaryResource commit;
        Class<DiskStorageCache> cls = DiskStorageCache.class;
        SettableCacheEvent cacheKey2 = SettableCacheEvent.obtain().setCacheKey(cacheKey);
        this.e.onWriteAttempt(cacheKey2);
        synchronized (this.p) {
            firstResourceId = CacheKeyUtil.getFirstResourceId(cacheKey);
        }
        cacheKey2.setResourceId(firstResourceId);
        try {
            DiskStorage.Inserter d2 = d(firstResourceId, cacheKey);
            try {
                d2.writeData(writerCallback, cacheKey);
                synchronized (this.p) {
                    commit = d2.commit(cacheKey);
                    this.f.add(firstResourceId);
                    this.n.b(commit.size(), 1);
                }
                cacheKey2.setItemSize(commit.size()).setCacheSize(this.n.a());
                this.e.onWriteSuccess(cacheKey2);
                cacheKey2.recycle();
                return commit;
            } finally {
                if (!d2.cleanUp()) {
                    FLog.e(cls, "Failed to delete temp file");
                }
            }
        } catch (IOException e2) {
            cacheKey2.setException(e2);
            this.e.onWriteException(cacheKey2);
            FLog.e(DiskStorageCache.class, "Failed inserting a file into the cache", e2);
            throw e2;
        } catch (Throwable th) {
            cacheKey2.recycle();
            throw th;
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public boolean isEnabled() {
        return this.j.isEnabled();
    }

    public boolean isIndexReady() {
        return this.q || !this.m;
    }

    @Override // com.facebook.cache.disk.FileCache
    public boolean probe(CacheKey cacheKey) {
        String str;
        IOException e2;
        Throwable th;
        try {
            synchronized (this.p) {
                try {
                    List<String> resourceIds = CacheKeyUtil.getResourceIds(cacheKey);
                    for (int i2 = 0; i2 < resourceIds.size(); i2++) {
                        str = resourceIds.get(i2);
                        try {
                            if (this.j.touch(str, cacheKey)) {
                                this.f.add(str);
                                return true;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    return false;
                } catch (Throwable th3) {
                    str = null;
                    th = th3;
                }
            }
            try {
                throw th;
            } catch (IOException e3) {
                e2 = e3;
            }
        } catch (IOException e4) {
            str = null;
            e2 = e4;
            SettableCacheEvent exception = SettableCacheEvent.obtain().setCacheKey(cacheKey).setResourceId(str).setException(e2);
            this.e.onReadException(exception);
            exception.recycle();
            return false;
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public void remove(CacheKey cacheKey) {
        synchronized (this.p) {
            try {
                List<String> resourceIds = CacheKeyUtil.getResourceIds(cacheKey);
                for (int i2 = 0; i2 < resourceIds.size(); i2++) {
                    String str = resourceIds.get(i2);
                    this.j.remove(str);
                    this.f.remove(str);
                }
            } catch (IOException e2) {
                CacheErrorLogger cacheErrorLogger = this.l;
                CacheErrorLogger.CacheErrorCategory cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.DELETE_FILE;
                cacheErrorLogger.logError(cacheErrorCategory, DiskStorageCache.class, "delete: " + e2.getMessage(), e2);
            }
        }
    }

    @Override // com.facebook.common.disk.DiskTrimmable
    public void trimToMinimum() {
        synchronized (this.p) {
            c();
            long a3 = this.n.a();
            long j2 = this.h;
            if (j2 > 0 && a3 > 0) {
                if (a3 >= j2) {
                    double d2 = 1.0d - (((double) j2) / ((double) a3));
                    if (d2 > 0.02d) {
                        e(d2);
                    }
                }
            }
        }
    }

    @Override // com.facebook.common.disk.DiskTrimmable
    public void trimToNothing() {
        clearAll();
    }
}
