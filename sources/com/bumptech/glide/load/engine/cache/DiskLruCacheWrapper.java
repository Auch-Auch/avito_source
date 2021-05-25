package com.bumptech.glide.load.engine.cache;

import a2.d.a.d.b.v.a;
import android.util.Log;
import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;
import java.io.IOException;
public class DiskLruCacheWrapper implements DiskCache {
    public static DiskLruCacheWrapper f;
    public final SafeKeyGenerator a;
    public final File b;
    public final long c;
    public final a d = new a();
    public DiskLruCache e;

    @Deprecated
    public DiskLruCacheWrapper(File file, long j) {
        this.b = file;
        this.c = j;
        this.a = new SafeKeyGenerator();
    }

    public static DiskCache create(File file, long j) {
        return new DiskLruCacheWrapper(file, j);
    }

    @Deprecated
    public static synchronized DiskCache get(File file, long j) {
        DiskLruCacheWrapper diskLruCacheWrapper;
        synchronized (DiskLruCacheWrapper.class) {
            if (f == null) {
                f = new DiskLruCacheWrapper(file, j);
            }
            diskLruCacheWrapper = f;
        }
        return diskLruCacheWrapper;
    }

    public final synchronized DiskLruCache a() throws IOException {
        if (this.e == null) {
            this.e = DiskLruCache.open(this.b, 1, 1, this.c);
        }
        return this.e;
    }

    public final synchronized void b() {
        this.e = null;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public synchronized void clear() {
        try {
            a().delete();
        } catch (IOException unused) {
            Log.isLoggable("DiskLruCacheWrapper", 5);
        } catch (Throwable th) {
            b();
            throw th;
        }
        b();
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void delete(Key key) {
        try {
            a().remove(this.a.getSafeKey(key));
        } catch (IOException unused) {
            Log.isLoggable("DiskLruCacheWrapper", 5);
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void put(Key key, DiskCache.Writer writer) {
        a.C0016a aVar;
        String safeKey = this.a.getSafeKey(key);
        a aVar2 = this.d;
        synchronized (aVar2) {
            aVar = aVar2.a.get(safeKey);
            if (aVar == null) {
                a.b bVar = aVar2.b;
                synchronized (bVar.a) {
                    aVar = bVar.a.poll();
                }
                if (aVar == null) {
                    aVar = new a.C0016a();
                }
                aVar2.a.put(safeKey, aVar);
            }
            aVar.b++;
        }
        aVar.a.lock();
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                String str = "Put: Obtained: " + safeKey + " for for Key: " + key;
            }
            try {
                DiskLruCache a3 = a();
                if (a3.get(safeKey) == null) {
                    DiskLruCache.Editor edit = a3.edit(safeKey);
                    if (edit != null) {
                        try {
                            if (writer.write(edit.getFile(0))) {
                                edit.commit();
                            }
                            this.d.a(safeKey);
                        } finally {
                            edit.abortUnlessCommitted();
                        }
                    } else {
                        throw new IllegalStateException("Had two simultaneous puts for: " + safeKey);
                    }
                }
            } catch (IOException unused) {
                Log.isLoggable("DiskLruCacheWrapper", 5);
            }
        } finally {
            this.d.a(safeKey);
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public File get(Key key) {
        String safeKey = this.a.getSafeKey(key);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            String str = "Get: Obtained: " + safeKey + " for for Key: " + key;
        }
        try {
            DiskLruCache.Value value = a().get(safeKey);
            if (value != null) {
                return value.getFile(0);
            }
            return null;
        } catch (IOException unused) {
            Log.isLoggable("DiskLruCacheWrapper", 5);
            return null;
        }
    }
}
