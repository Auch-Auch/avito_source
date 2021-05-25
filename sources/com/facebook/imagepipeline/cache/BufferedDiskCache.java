package com.facebook.imagepipeline.cache;

import bolts.Task;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.instrumentation.FrescoInstrumenter;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
public class BufferedDiskCache {
    public final FileCache a;
    public final PooledByteBufferFactory b;
    public final PooledByteStreams c;
    public final Executor d;
    public final Executor e;
    public final StagingArea f = StagingArea.getInstance();
    public final ImageCacheStatsTracker g;

    public class a implements Callable<Void> {
        public final /* synthetic */ Object a;
        public final /* synthetic */ CacheKey b;

        public a(Object obj, CacheKey cacheKey) {
            this.a = obj;
            this.b = cacheKey;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            Object onBeginWork = FrescoInstrumenter.onBeginWork(this.a, null);
            try {
                BufferedDiskCache.this.a.probe(this.b);
                return null;
            } finally {
                FrescoInstrumenter.onEndWork(onBeginWork);
            }
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ Object a;
        public final /* synthetic */ CacheKey b;
        public final /* synthetic */ EncodedImage c;

        public b(Object obj, CacheKey cacheKey, EncodedImage encodedImage) {
            this.a = obj;
            this.b = cacheKey;
            this.c = encodedImage;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object onBeginWork = FrescoInstrumenter.onBeginWork(this.a, null);
            try {
                BufferedDiskCache.b(BufferedDiskCache.this, this.b, this.c);
                BufferedDiskCache.this.f.remove(this.b, this.c);
                EncodedImage.closeSafely(this.c);
                FrescoInstrumenter.onEndWork(onBeginWork);
            } catch (Throwable th) {
                BufferedDiskCache.this.f.remove(this.b, this.c);
                EncodedImage.closeSafely(this.c);
                FrescoInstrumenter.onEndWork(onBeginWork);
                throw th;
            }
        }
    }

    public class c implements Callable<Void> {
        public final /* synthetic */ Object a;
        public final /* synthetic */ CacheKey b;

        public c(Object obj, CacheKey cacheKey) {
            this.a = obj;
            this.b = cacheKey;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            Object onBeginWork = FrescoInstrumenter.onBeginWork(this.a, null);
            try {
                BufferedDiskCache.this.f.remove(this.b);
                BufferedDiskCache.this.a.remove(this.b);
                FrescoInstrumenter.onEndWork(onBeginWork);
                return null;
            } catch (Throwable th) {
                FrescoInstrumenter.onEndWork(onBeginWork);
                throw th;
            }
        }
    }

    public class d implements Callable<Void> {
        public final /* synthetic */ Object a;

        public d(Object obj) {
            this.a = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            Object onBeginWork = FrescoInstrumenter.onBeginWork(this.a, null);
            try {
                BufferedDiskCache.this.f.clearAll();
                BufferedDiskCache.this.a.clearAll();
                FrescoInstrumenter.onEndWork(onBeginWork);
                return null;
            } catch (Throwable th) {
                FrescoInstrumenter.onEndWork(onBeginWork);
                throw th;
            }
        }
    }

    public BufferedDiskCache(FileCache fileCache, PooledByteBufferFactory pooledByteBufferFactory, PooledByteStreams pooledByteStreams, Executor executor, Executor executor2, ImageCacheStatsTracker imageCacheStatsTracker) {
        this.a = fileCache;
        this.b = pooledByteBufferFactory;
        this.c = pooledByteStreams;
        this.d = executor;
        this.e = executor2;
        this.g = imageCacheStatsTracker;
    }

    /* JADX INFO: finally extract failed */
    public static PooledByteBuffer a(BufferedDiskCache bufferedDiskCache, CacheKey cacheKey) throws IOException {
        Objects.requireNonNull(bufferedDiskCache);
        try {
            FLog.v(BufferedDiskCache.class, "Disk cache read for %s", cacheKey.getUriString());
            BinaryResource resource = bufferedDiskCache.a.getResource(cacheKey);
            if (resource == null) {
                FLog.v(BufferedDiskCache.class, "Disk cache miss for %s", cacheKey.getUriString());
                bufferedDiskCache.g.onDiskCacheMiss(cacheKey);
                return null;
            }
            FLog.v(BufferedDiskCache.class, "Found entry in disk cache for %s", cacheKey.getUriString());
            bufferedDiskCache.g.onDiskCacheHit(cacheKey);
            InputStream openStream = resource.openStream();
            try {
                PooledByteBuffer newByteBuffer = bufferedDiskCache.b.newByteBuffer(openStream, (int) resource.size());
                openStream.close();
                FLog.v(BufferedDiskCache.class, "Successful read from disk cache for %s", cacheKey.getUriString());
                return newByteBuffer;
            } catch (Throwable th) {
                openStream.close();
                throw th;
            }
        } catch (IOException e2) {
            FLog.w(BufferedDiskCache.class, e2, "Exception reading from cache for %s", cacheKey.getUriString());
            bufferedDiskCache.g.onDiskCacheGetFail(cacheKey);
            throw e2;
        }
    }

    public static void b(BufferedDiskCache bufferedDiskCache, CacheKey cacheKey, EncodedImage encodedImage) {
        Objects.requireNonNull(bufferedDiskCache);
        FLog.v(BufferedDiskCache.class, "About to write to disk-cache for key %s", cacheKey.getUriString());
        try {
            bufferedDiskCache.a.insert(cacheKey, new a2.g.p.a.c(bufferedDiskCache, encodedImage));
            bufferedDiskCache.g.onDiskCachePut(cacheKey);
            FLog.v(BufferedDiskCache.class, "Successful disk-cache write for key %s", cacheKey.getUriString());
        } catch (IOException e2) {
            FLog.w(BufferedDiskCache.class, e2, "Failed to write to disk-cache for key %s", cacheKey.getUriString());
        }
    }

    public void addKeyForAsyncProbing(CacheKey cacheKey) {
        Preconditions.checkNotNull(cacheKey);
        this.a.probe(cacheKey);
    }

    public final boolean c(CacheKey cacheKey) {
        EncodedImage encodedImage = this.f.get(cacheKey);
        if (encodedImage != null) {
            encodedImage.close();
            FLog.v(BufferedDiskCache.class, "Found image for %s in staging area", cacheKey.getUriString());
            this.g.onStagingAreaHit(cacheKey);
            return true;
        }
        FLog.v(BufferedDiskCache.class, "Did not find image for %s in staging area", cacheKey.getUriString());
        this.g.onStagingAreaMiss(cacheKey);
        try {
            return this.a.hasKey(cacheKey);
        } catch (Exception unused) {
            return false;
        }
    }

    public Task<Void> clearAll() {
        this.f.clearAll();
        try {
            return Task.call(new d(FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_clearAll")), this.e);
        } catch (Exception e2) {
            FLog.w(BufferedDiskCache.class, e2, "Failed to schedule disk-cache clear", new Object[0]);
            return Task.forError(e2);
        }
    }

    public Task<Boolean> contains(CacheKey cacheKey) {
        if (containsSync(cacheKey)) {
            return Task.forResult(Boolean.TRUE);
        }
        try {
            return Task.call(new a2.g.p.a.a(this, FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_containsAsync"), cacheKey), this.d);
        } catch (Exception e2) {
            FLog.w(BufferedDiskCache.class, e2, "Failed to schedule disk-cache read for %s", cacheKey.getUriString());
            return Task.forError(e2);
        }
    }

    public boolean containsSync(CacheKey cacheKey) {
        return this.f.containsKey(cacheKey) || this.a.hasKeySync(cacheKey);
    }

    public boolean diskCheckSync(CacheKey cacheKey) {
        if (containsSync(cacheKey)) {
            return true;
        }
        return c(cacheKey);
    }

    public Task<EncodedImage> get(CacheKey cacheKey, AtomicBoolean atomicBoolean) {
        Task<EncodedImage> task;
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("BufferedDiskCache#get");
            }
            EncodedImage encodedImage = this.f.get(cacheKey);
            if (encodedImage != null) {
                FLog.v(BufferedDiskCache.class, "Found image for %s in staging area", cacheKey.getUriString());
                this.g.onStagingAreaHit(cacheKey);
                return Task.forResult(encodedImage);
            }
            try {
                task = Task.call(new a2.g.p.a.b(this, FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_getAsync"), atomicBoolean, cacheKey), this.d);
            } catch (Exception e2) {
                FLog.w(BufferedDiskCache.class, e2, "Failed to schedule disk-cache read for %s", cacheKey.getUriString());
                task = Task.forError(e2);
            }
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            return task;
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    public long getSize() {
        return this.a.getSize();
    }

    public Task<Void> probe(CacheKey cacheKey) {
        Preconditions.checkNotNull(cacheKey);
        try {
            return Task.call(new a(FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_probe"), cacheKey), this.e);
        } catch (Exception e2) {
            FLog.w(BufferedDiskCache.class, e2, "Failed to schedule disk-cache probe for %s", cacheKey.getUriString());
            return Task.forError(e2);
        }
    }

    public void put(CacheKey cacheKey, EncodedImage encodedImage) {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("BufferedDiskCache#put");
            }
            Preconditions.checkNotNull(cacheKey);
            Preconditions.checkArgument(EncodedImage.isValid(encodedImage));
            this.f.put(cacheKey, encodedImage);
            EncodedImage cloneOrNull = EncodedImage.cloneOrNull(encodedImage);
            try {
                this.e.execute(new b(FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_putAsync"), cacheKey, cloneOrNull));
            } catch (Exception e2) {
                FLog.w(BufferedDiskCache.class, e2, "Failed to schedule disk-cache write for %s", cacheKey.getUriString());
                this.f.remove(cacheKey, encodedImage);
                EncodedImage.closeSafely(cloneOrNull);
            }
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    public Task<Void> remove(CacheKey cacheKey) {
        Preconditions.checkNotNull(cacheKey);
        this.f.remove(cacheKey);
        try {
            return Task.call(new c(FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_remove"), cacheKey), this.e);
        } catch (Exception e2) {
            FLog.w(BufferedDiskCache.class, e2, "Failed to schedule disk-cache remove for %s", cacheKey.getUriString());
            return Task.forError(e2);
        }
    }
}
