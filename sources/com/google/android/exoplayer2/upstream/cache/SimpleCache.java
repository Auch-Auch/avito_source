package com.google.android.exoplayer2.upstream.cache;

import a2.b.a.a.a;
import a2.j.b.b.d1.i.c;
import a2.j.b.b.d1.i.d;
import a2.j.b.b.d1.i.e;
import a2.j.b.b.d1.i.f;
import a2.j.b.b.d1.i.g;
import a2.j.b.b.d1.i.h;
import a2.j.b.b.d1.i.i;
import android.database.SQLException;
import android.os.ConditionVariable;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
public final class SimpleCache implements Cache {
    public static final HashSet<File> l = new HashSet<>();
    public final File a;
    public final CacheEvictor b;
    public final f c;
    @Nullable
    public final d d;
    public final HashMap<String, ArrayList<Cache.Listener>> e;
    public final Random f;
    public final boolean g;
    public long h;
    public long i;
    public boolean j;
    public Cache.CacheException k;

    @Deprecated
    public SimpleCache(File file, CacheEvictor cacheEvictor) {
        this(file, cacheEvictor, null, false);
    }

    public static void a(SimpleCache simpleCache) {
        if (simpleCache.a.exists() || simpleCache.a.mkdirs()) {
            File[] listFiles = simpleCache.a.listFiles();
            if (listFiles == null) {
                StringBuilder L = a.L("Failed to list cache directory files: ");
                L.append(simpleCache.a);
                String sb = L.toString();
                Log.e("SimpleCache", sb);
                simpleCache.k = new Cache.CacheException(sb);
                return;
            }
            long e2 = e(listFiles);
            simpleCache.h = e2;
            if (e2 == -1) {
                try {
                    simpleCache.h = c(simpleCache.a);
                } catch (IOException e3) {
                    StringBuilder L2 = a.L("Failed to create cache UID: ");
                    L2.append(simpleCache.a);
                    String sb2 = L2.toString();
                    Log.e("SimpleCache", sb2, e3);
                    simpleCache.k = new Cache.CacheException(sb2, e3);
                    return;
                }
            }
            try {
                simpleCache.c.e(simpleCache.h);
                d dVar = simpleCache.d;
                if (dVar != null) {
                    dVar.c(simpleCache.h);
                    Map<String, c> b2 = simpleCache.d.b();
                    simpleCache.d(simpleCache.a, true, listFiles, b2);
                    simpleCache.d.d(((HashMap) b2).keySet());
                } else {
                    simpleCache.d(simpleCache.a, true, listFiles, null);
                }
                f fVar = simpleCache.c;
                int size = fVar.a.size();
                String[] strArr = new String[size];
                fVar.a.keySet().toArray(strArr);
                for (int i2 = 0; i2 < size; i2++) {
                    fVar.f(strArr[i2]);
                }
                try {
                    simpleCache.c.g();
                } catch (IOException e4) {
                    Log.e("SimpleCache", "Storing index file failed", e4);
                }
            } catch (IOException e5) {
                StringBuilder L3 = a.L("Failed to initialize cache indices: ");
                L3.append(simpleCache.a);
                String sb3 = L3.toString();
                Log.e("SimpleCache", sb3, e5);
                simpleCache.k = new Cache.CacheException(sb3, e5);
            }
        } else {
            StringBuilder L4 = a.L("Failed to create cache directory: ");
            L4.append(simpleCache.a);
            String sb4 = L4.toString();
            Log.e("SimpleCache", sb4);
            simpleCache.k = new Cache.CacheException(sb4);
        }
    }

    public static long c(File file) throws IOException {
        long j2;
        long nextLong = new SecureRandom().nextLong();
        if (nextLong == Long.MIN_VALUE) {
            j2 = 0;
        } else {
            j2 = Math.abs(nextLong);
        }
        File file2 = new File(file, a.c3(Long.toString(j2, 16), ".uid"));
        if (file2.createNewFile()) {
            return j2;
        }
        throw new IOException(a.Y2("Failed to create UID file: ", file2));
    }

    @WorkerThread
    public static void delete(File file, @Nullable DatabaseProvider databaseProvider) {
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                file.delete();
                return;
            }
            if (databaseProvider != null) {
                long e2 = e(listFiles);
                if (e2 != -1) {
                    try {
                        d.a(databaseProvider, e2);
                    } catch (DatabaseIOException unused) {
                        Log.w("SimpleCache", "Failed to delete file metadata: " + e2);
                    }
                    try {
                        f.a.i(databaseProvider, Long.toHexString(e2));
                    } catch (DatabaseIOException unused2) {
                        Log.w("SimpleCache", "Failed to delete file metadata: " + e2);
                    }
                }
            }
            Util.recursiveDelete(file);
        }
    }

    public static long e(File[] fileArr) {
        int length = fileArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            File file = fileArr[i2];
            String name = file.getName();
            if (name.endsWith(".uid")) {
                try {
                    return Long.parseLong(name.substring(0, name.indexOf(46)), 16);
                } catch (NumberFormatException unused) {
                    Log.e("SimpleCache", "Malformed UID file: " + file);
                    file.delete();
                }
            }
        }
        return -1;
    }

    public static synchronized void i(File file) {
        synchronized (SimpleCache.class) {
            l.remove(file.getAbsoluteFile());
        }
    }

    public static synchronized boolean isCacheFolderLocked(File file) {
        boolean contains;
        synchronized (SimpleCache.class) {
            contains = l.contains(file.getAbsoluteFile());
        }
        return contains;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized NavigableSet<CacheSpan> addListener(String str, Cache.Listener listener) {
        Assertions.checkState(!this.j);
        Assertions.checkNotNull(str);
        Assertions.checkNotNull(listener);
        ArrayList<Cache.Listener> arrayList = this.e.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.e.put(str, arrayList);
        }
        arrayList.add(listener);
        return getCachedSpans(str);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void applyContentMetadataMutations(String str, ContentMetadataMutations contentMetadataMutations) throws Cache.CacheException {
        Assertions.checkState(!this.j);
        checkInitialization();
        f fVar = this.c;
        e d2 = fVar.d(str);
        DefaultContentMetadata defaultContentMetadata = d2.e;
        DefaultContentMetadata copyWithMutationsApplied = defaultContentMetadata.copyWithMutationsApplied(contentMetadataMutations);
        d2.e = copyWithMutationsApplied;
        if (!copyWithMutationsApplied.equals(defaultContentMetadata)) {
            fVar.e.f(d2);
        }
        try {
            this.c.g();
        } catch (IOException e2) {
            throw new Cache.CacheException(e2);
        }
    }

    public final void b(i iVar) {
        this.c.d(iVar.key).c.add(iVar);
        this.i += iVar.length;
        ArrayList<Cache.Listener> arrayList = this.e.get(iVar.key);
        if (arrayList != null) {
            int size = arrayList.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                arrayList.get(size).onSpanAdded(this, iVar);
            }
        }
        this.b.onSpanAdded(this, iVar);
    }

    public synchronized void checkInitialization() throws Cache.CacheException {
        Cache.CacheException cacheException = this.k;
        if (cacheException != null) {
            throw cacheException;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void commitFile(File file, long j2) throws Cache.CacheException {
        boolean z = true;
        Assertions.checkState(!this.j);
        if (file.exists()) {
            if (j2 == 0) {
                file.delete();
                return;
            }
            i iVar = (i) Assertions.checkNotNull(i.a(file, j2, C.TIME_UNSET, this.c));
            e eVar = (e) Assertions.checkNotNull(this.c.c(iVar.key));
            Assertions.checkState(eVar.c(iVar.position, iVar.length));
            long a3 = g.a(eVar.e);
            if (a3 != -1) {
                if (iVar.position + iVar.length > a3) {
                    z = false;
                }
                Assertions.checkState(z);
            }
            if (this.d != null) {
                try {
                    this.d.e(file.getName(), iVar.length, iVar.lastTouchTimestamp);
                } catch (IOException e2) {
                    throw new Cache.CacheException(e2);
                }
            }
            b(iVar);
            try {
                this.c.g();
                notifyAll();
            } catch (IOException e3) {
                throw new Cache.CacheException(e3);
            }
        }
    }

    public final void d(File file, boolean z, @Nullable File[] fileArr, @Nullable Map<String, c> map) {
        if (fileArr != null && fileArr.length != 0) {
            for (File file2 : fileArr) {
                String name = file2.getName();
                if (z && name.indexOf(46) == -1) {
                    d(file2, false, file2.listFiles(), map);
                } else if (!z || (!name.startsWith("cached_content_index.exi") && !name.endsWith(".uid"))) {
                    long j2 = -1;
                    long j3 = C.TIME_UNSET;
                    c remove = map != null ? map.remove(name) : null;
                    if (remove != null) {
                        j2 = remove.a;
                        j3 = remove.b;
                    }
                    i a3 = i.a(file2, j2, j3, this.c);
                    if (a3 != null) {
                        b(a3);
                    } else {
                        file2.delete();
                    }
                }
            }
        } else if (!z) {
            file.delete();
        }
    }

    public final void f(CacheSpan cacheSpan) {
        boolean z;
        e c2 = this.c.c(cacheSpan.key);
        if (c2 != null) {
            if (c2.c.remove(cacheSpan)) {
                File file = cacheSpan.file;
                if (file != null) {
                    file.delete();
                }
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.i -= cacheSpan.length;
                if (this.d != null) {
                    String name = cacheSpan.file.getName();
                    try {
                        d dVar = this.d;
                        Assertions.checkNotNull(dVar.b);
                        try {
                            dVar.a.getWritableDatabase().delete(dVar.b, "name = ?", new String[]{name});
                        } catch (SQLException e2) {
                            throw new DatabaseIOException(e2);
                        }
                    } catch (IOException unused) {
                        a.V0("Failed to remove file index entry for: ", name, "SimpleCache");
                    }
                }
                this.c.f(c2.b);
                ArrayList<Cache.Listener> arrayList = this.e.get(cacheSpan.key);
                if (arrayList != null) {
                    int size = arrayList.size();
                    while (true) {
                        size--;
                        if (size < 0) {
                            break;
                        }
                        arrayList.get(size).onSpanRemoved(this, cacheSpan);
                    }
                }
                this.b.onSpanRemoved(this, cacheSpan);
            }
        }
    }

    public final void g() {
        ArrayList arrayList = new ArrayList();
        for (e eVar : Collections.unmodifiableCollection(this.c.a.values())) {
            Iterator<i> it = eVar.c.iterator();
            while (it.hasNext()) {
                i next = it.next();
                if (next.file.length() != next.length) {
                    arrayList.add(next);
                }
            }
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            f((CacheSpan) arrayList.get(i2));
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized long getCacheSpace() {
        Assertions.checkState(!this.j);
        return this.i;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized long getCachedBytes(String str, long j2, long j3) {
        long j4;
        long j5 = Long.MAX_VALUE;
        long j6 = j3 == -1 ? Long.MAX_VALUE : j3 + j2;
        if (j6 >= 0) {
            j5 = j6;
        }
        j4 = 0;
        while (j2 < j5) {
            long cachedLength = getCachedLength(str, j2, j5 - j2);
            if (cachedLength > 0) {
                j4 += cachedLength;
            } else {
                cachedLength = -cachedLength;
            }
            j2 += cachedLength;
        }
        return j4;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized long getCachedLength(String str, long j2, long j3) {
        e eVar;
        Assertions.checkState(!this.j);
        if (j3 == -1) {
            j3 = Long.MAX_VALUE;
        }
        eVar = this.c.a.get(str);
        return eVar != null ? eVar.a(j2, j3) : -j3;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized NavigableSet<CacheSpan> getCachedSpans(String str) {
        TreeSet treeSet;
        Assertions.checkState(!this.j);
        e eVar = this.c.a.get(str);
        if (eVar != null) {
            if (!eVar.c.isEmpty()) {
                treeSet = new TreeSet((Collection) eVar.c);
            }
        }
        treeSet = new TreeSet();
        return treeSet;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized ContentMetadata getContentMetadata(String str) {
        DefaultContentMetadata defaultContentMetadata;
        Assertions.checkState(!this.j);
        e eVar = this.c.a.get(str);
        if (eVar != null) {
            defaultContentMetadata = eVar.e;
        } else {
            defaultContentMetadata = DefaultContentMetadata.EMPTY;
        }
        return defaultContentMetadata;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized Set<String> getKeys() {
        Assertions.checkState(!this.j);
        return new HashSet(this.c.a.keySet());
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized long getUid() {
        return this.h;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00aa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final a2.j.b.b.d1.i.i h(java.lang.String r17, a2.j.b.b.d1.i.i r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r0.g
            if (r2 != 0) goto L_0x0009
            return r1
        L_0x0009:
            java.io.File r2 = r1.file
            java.lang.Object r2 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r2)
            java.io.File r2 = (java.io.File) r2
            java.lang.String r4 = r2.getName()
            long r5 = r1.length
            long r13 = java.lang.System.currentTimeMillis()
            r2 = 0
            a2.j.b.b.d1.i.d r3 = r0.d
            if (r3 == 0) goto L_0x002d
            r7 = r13
            r3.e(r4, r5, r7)     // Catch:{ IOException -> 0x0025 }
            goto L_0x002e
        L_0x0025:
            java.lang.String r3 = "SimpleCache"
            java.lang.String r4 = "Failed to update index with new touch timestamp."
            com.google.android.exoplayer2.util.Log.w(r3, r4)
            goto L_0x002e
        L_0x002d:
            r2 = 1
        L_0x002e:
            a2.j.b.b.d1.i.f r3 = r0.c
            java.util.HashMap<java.lang.String, a2.j.b.b.d1.i.e> r3 = r3.a
            r4 = r17
            java.lang.Object r3 = r3.get(r4)
            a2.j.b.b.d1.i.e r3 = (a2.j.b.b.d1.i.e) r3
            java.util.TreeSet<a2.j.b.b.d1.i.i> r4 = r3.c
            boolean r4 = r4.remove(r1)
            com.google.android.exoplayer2.util.Assertions.checkState(r4)
            java.io.File r4 = r1.file
            java.lang.Object r4 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r4)
            java.io.File r4 = (java.io.File) r4
            if (r2 == 0) goto L_0x0087
            java.io.File r2 = r4.getParentFile()
            java.lang.Object r2 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r2)
            r7 = r2
            java.io.File r7 = (java.io.File) r7
            long r9 = r1.position
            int r8 = r3.a
            r11 = r13
            java.io.File r2 = a2.j.b.b.d1.i.i.b(r7, r8, r9, r11)
            boolean r5 = r4.renameTo(r2)
            if (r5 == 0) goto L_0x0069
            r15 = r2
            goto L_0x0088
        L_0x0069:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Failed to rename "
            r5.append(r6)
            r5.append(r4)
            java.lang.String r6 = " to "
            r5.append(r6)
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            java.lang.String r5 = "CachedContent"
            com.google.android.exoplayer2.util.Log.w(r5, r2)
        L_0x0087:
            r15 = r4
        L_0x0088:
            boolean r2 = r1.isCached
            com.google.android.exoplayer2.util.Assertions.checkState(r2)
            a2.j.b.b.d1.i.i r2 = new a2.j.b.b.d1.i.i
            java.lang.String r8 = r1.key
            long r9 = r1.position
            long r11 = r1.length
            r7 = r2
            r7.<init>(r8, r9, r11, r13, r15)
            java.util.TreeSet<a2.j.b.b.d1.i.i> r3 = r3.c
            r3.add(r2)
            java.util.HashMap<java.lang.String, java.util.ArrayList<com.google.android.exoplayer2.upstream.cache.Cache$Listener>> r3 = r0.e
            java.lang.String r4 = r1.key
            java.lang.Object r3 = r3.get(r4)
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            if (r3 == 0) goto L_0x00bc
            int r4 = r3.size()
        L_0x00ae:
            int r4 = r4 + -1
            if (r4 < 0) goto L_0x00bc
            java.lang.Object r5 = r3.get(r4)
            com.google.android.exoplayer2.upstream.cache.Cache$Listener r5 = (com.google.android.exoplayer2.upstream.cache.Cache.Listener) r5
            r5.onSpanTouched(r0, r1, r2)
            goto L_0x00ae
        L_0x00bc:
            com.google.android.exoplayer2.upstream.cache.CacheEvictor r3 = r0.b
            r3.onSpanTouched(r0, r1, r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.cache.SimpleCache.h(java.lang.String, a2.j.b.b.d1.i.i):a2.j.b.b.d1.i.i");
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized boolean isCached(String str, long j2, long j3) {
        boolean z;
        z = true;
        Assertions.checkState(!this.j);
        e eVar = this.c.a.get(str);
        if (eVar == null || eVar.a(j2, j3) < j3) {
            z = false;
        }
        return z;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void release() {
        if (!this.j) {
            this.e.clear();
            g();
            try {
                this.c.g();
                i(this.a);
            } catch (IOException e2) {
                Log.e("SimpleCache", "Storing index file failed", e2);
                i(this.a);
            } catch (Throwable th) {
                i(this.a);
                this.j = true;
                throw th;
            }
            this.j = true;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void releaseHoleSpan(CacheSpan cacheSpan) {
        Assertions.checkState(!this.j);
        e eVar = (e) Assertions.checkNotNull(this.c.c(cacheSpan.key));
        long j2 = cacheSpan.position;
        for (int i2 = 0; i2 < eVar.d.size(); i2++) {
            if (eVar.d.get(i2).a == j2) {
                eVar.d.remove(i2);
                this.c.f(eVar.b);
                notifyAll();
            }
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void removeListener(String str, Cache.Listener listener) {
        if (!this.j) {
            ArrayList<Cache.Listener> arrayList = this.e.get(str);
            if (arrayList != null) {
                arrayList.remove(listener);
                if (arrayList.isEmpty()) {
                    this.e.remove(str);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void removeResource(String str) {
        Assertions.checkState(!this.j);
        for (CacheSpan cacheSpan : getCachedSpans(str)) {
            f(cacheSpan);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void removeSpan(CacheSpan cacheSpan) {
        Assertions.checkState(!this.j);
        f(cacheSpan);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized File startFile(String str, long j2, long j3) throws Cache.CacheException {
        e eVar;
        File file;
        Assertions.checkState(!this.j);
        checkInitialization();
        eVar = this.c.a.get(str);
        Assertions.checkNotNull(eVar);
        Assertions.checkState(eVar.c(j2, j3));
        if (!this.a.exists()) {
            this.a.mkdirs();
            g();
        }
        this.b.onStartFile(this, str, j2, j3);
        file = new File(this.a, Integer.toString(this.f.nextInt(10)));
        if (!file.exists()) {
            file.mkdir();
        }
        return i.b(file, eVar.a, j2, System.currentTimeMillis());
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized CacheSpan startReadWrite(String str, long j2, long j3) throws InterruptedException, Cache.CacheException {
        CacheSpan startReadWriteNonBlocking;
        Assertions.checkState(!this.j);
        checkInitialization();
        while (true) {
            startReadWriteNonBlocking = startReadWriteNonBlocking(str, j2, j3);
            if (startReadWriteNonBlocking == null) {
                wait();
            }
        }
        return startReadWriteNonBlocking;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0081, code lost:
        if ((r6 + r13) <= r18) goto L_0x008f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x008c, code lost:
        if ((r18 + r2) <= r6) goto L_0x008f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0096 A[LOOP:1: B:22:0x0060->B:38:0x0096, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0094 A[SYNTHETIC] */
    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.google.android.exoplayer2.upstream.cache.CacheSpan startReadWriteNonBlocking(java.lang.String r17, long r18, long r20) throws com.google.android.exoplayer2.upstream.cache.Cache.CacheException {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            r11 = r18
            monitor-enter(r16)
            boolean r2 = r1.j     // Catch:{ all -> 0x00ab }
            if (r2 != 0) goto L_0x000d
            r2 = 1
            goto L_0x000e
        L_0x000d:
            r2 = 0
        L_0x000e:
            com.google.android.exoplayer2.util.Assertions.checkState(r2)     // Catch:{ all -> 0x00ab }
            r16.checkInitialization()     // Catch:{ all -> 0x00ab }
            a2.j.b.b.d1.i.f r2 = r1.c     // Catch:{ all -> 0x00ab }
            java.util.HashMap<java.lang.String, a2.j.b.b.d1.i.e> r2 = r2.a     // Catch:{ all -> 0x00ab }
            java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x00ab }
            a2.j.b.b.d1.i.e r2 = (a2.j.b.b.d1.i.e) r2     // Catch:{ all -> 0x00ab }
            if (r2 != 0) goto L_0x0033
            a2.j.b.b.d1.i.i r15 = new a2.j.b.b.d1.i.i     // Catch:{ all -> 0x00ab }
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r10 = 0
            r2 = r15
            r3 = r17
            r4 = r18
            r6 = r20
            r2.<init>(r3, r4, r6, r8, r10)     // Catch:{ all -> 0x00ab }
            goto L_0x004d
        L_0x0033:
            r3 = r20
        L_0x0035:
            a2.j.b.b.d1.i.i r15 = r2.b(r11, r3)     // Catch:{ all -> 0x00ab }
            boolean r5 = r15.isCached     // Catch:{ all -> 0x00ab }
            if (r5 == 0) goto L_0x004d
            java.io.File r5 = r15.file     // Catch:{ all -> 0x00ab }
            long r5 = r5.length()     // Catch:{ all -> 0x00ab }
            long r7 = r15.length     // Catch:{ all -> 0x00ab }
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x004d
            r16.g()     // Catch:{ all -> 0x00ab }
            goto L_0x0035
        L_0x004d:
            boolean r2 = r15.isCached     // Catch:{ all -> 0x00ab }
            if (r2 == 0) goto L_0x0057
            a2.j.b.b.d1.i.i r0 = r1.h(r0, r15)     // Catch:{ all -> 0x00ab }
            monitor-exit(r16)
            return r0
        L_0x0057:
            a2.j.b.b.d1.i.f r2 = r1.c
            a2.j.b.b.d1.i.e r0 = r2.d(r0)
            long r2 = r15.length
            r4 = 0
        L_0x0060:
            java.util.ArrayList<a2.j.b.b.d1.i.e$a> r5 = r0.d
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x0099
            java.util.ArrayList<a2.j.b.b.d1.i.e$a> r5 = r0.d
            java.lang.Object r5 = r5.get(r4)
            a2.j.b.b.d1.i.e$a r5 = (a2.j.b.b.d1.i.e.a) r5
            long r6 = r5.a
            r8 = -1
            int r10 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r10 > 0) goto L_0x0084
            long r13 = r5.b
            int r5 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r5 == 0) goto L_0x0091
            long r6 = r6 + r13
            int r5 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r5 <= 0) goto L_0x008f
            goto L_0x0091
        L_0x0084:
            int r5 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r5 == 0) goto L_0x0091
            long r8 = r11 + r2
            int r5 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r5 <= 0) goto L_0x008f
            goto L_0x0091
        L_0x008f:
            r5 = 0
            goto L_0x0092
        L_0x0091:
            r5 = 1
        L_0x0092:
            if (r5 == 0) goto L_0x0096
            r13 = 0
            goto L_0x00a4
        L_0x0096:
            int r4 = r4 + 1
            goto L_0x0060
        L_0x0099:
            java.util.ArrayList<a2.j.b.b.d1.i.e$a> r0 = r0.d
            a2.j.b.b.d1.i.e$a r4 = new a2.j.b.b.d1.i.e$a
            r4.<init>(r11, r2)
            r0.add(r4)
            r13 = 1
        L_0x00a4:
            if (r13 == 0) goto L_0x00a8
            monitor-exit(r16)
            return r15
        L_0x00a8:
            r0 = 0
            monitor-exit(r16)
            return r0
        L_0x00ab:
            r0 = move-exception
            monitor-exit(r16)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.cache.SimpleCache.startReadWriteNonBlocking(java.lang.String, long, long):com.google.android.exoplayer2.upstream.cache.CacheSpan");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public SimpleCache(File file, CacheEvictor cacheEvictor, @Nullable byte[] bArr) {
        this(file, cacheEvictor, bArr, bArr != null);
    }

    @Deprecated
    public SimpleCache(File file, CacheEvictor cacheEvictor, @Nullable byte[] bArr, boolean z) {
        this(file, cacheEvictor, null, bArr, z, true);
    }

    public SimpleCache(File file, CacheEvictor cacheEvictor, DatabaseProvider databaseProvider) {
        this(file, cacheEvictor, databaseProvider, null, false, false);
    }

    public SimpleCache(File file, CacheEvictor cacheEvictor, @Nullable DatabaseProvider databaseProvider, @Nullable byte[] bArr, boolean z, boolean z2) {
        boolean add;
        f fVar = new f(databaseProvider, file, bArr, z, z2);
        d dVar = (databaseProvider == null || z2) ? null : new d(databaseProvider);
        synchronized (SimpleCache.class) {
            add = l.add(file.getAbsoluteFile());
        }
        if (add) {
            this.a = file;
            this.b = cacheEvictor;
            this.c = fVar;
            this.d = dVar;
            this.e = new HashMap<>();
            this.f = new Random();
            this.g = cacheEvictor.requiresCacheSpanTouches();
            this.h = -1;
            ConditionVariable conditionVariable = new ConditionVariable();
            new h(this, "ExoPlayer:SimpleCacheInit", conditionVariable).start();
            conditionVariable.block();
            return;
        }
        throw new IllegalStateException(a.Y2("Another SimpleCache instance uses the folder: ", file));
    }
}
