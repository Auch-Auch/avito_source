package com.google.android.exoplayer2.upstream.cache;

import a2.j.b.b.d1.i.g;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataSink;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DummyDataSource;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.PriorityDataSource;
import com.google.android.exoplayer2.upstream.TeeDataSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.Util;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.List;
import java.util.Map;
public final class CacheDataSource implements DataSource {
    public static final int CACHE_IGNORED_REASON_ERROR = 0;
    public static final int CACHE_IGNORED_REASON_UNSET_LENGTH = 1;
    public static final int FLAG_BLOCK_ON_CACHE = 1;
    public static final int FLAG_IGNORE_CACHE_FOR_UNSET_LENGTH_REQUESTS = 4;
    public static final int FLAG_IGNORE_CACHE_ON_ERROR = 2;
    public final Cache a;
    public final DataSource b;
    @Nullable
    public final DataSource c;
    public final DataSource d;
    public final CacheKeyFactory e;
    @Nullable
    public final EventListener f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    @Nullable
    public Uri j;
    @Nullable
    public DataSpec k;
    @Nullable
    public DataSource l;
    public boolean m;
    public long n;
    public long o;
    @Nullable
    public CacheSpan p;
    public boolean q;
    public boolean r;
    public long s;
    public long t;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface CacheIgnoredReason {
    }

    public interface EventListener {
        void onCacheIgnored(int i);

        void onCachedBytesRead(long j, long j2);
    }

    public static final class Factory implements DataSource.Factory {
        public Cache a;
        public DataSource.Factory b = new FileDataSource.Factory();
        @Nullable
        public DataSink.Factory c;
        public CacheKeyFactory d = CacheKeyFactory.DEFAULT;
        public boolean e;
        @Nullable
        public DataSource.Factory f;
        @Nullable
        public PriorityTaskManager g;
        public int h;
        public int i;
        @Nullable
        public EventListener j;

        public final CacheDataSource a(@Nullable DataSource dataSource, int i2, int i3) {
            DataSink dataSink;
            Cache cache = (Cache) Assertions.checkNotNull(this.a);
            if (this.e || dataSource == null) {
                dataSink = null;
            } else {
                DataSink.Factory factory = this.c;
                dataSink = factory != null ? factory.createDataSink() : new CacheDataSink.Factory().setCache(cache).createDataSink();
            }
            return new CacheDataSource(cache, dataSource, this.b.createDataSource(), dataSink, this.d, i2, this.g, i3, this.j);
        }

        public CacheDataSource createDataSourceForDownloading() {
            DataSource.Factory factory = this.f;
            return a(factory != null ? factory.createDataSource() : null, this.i | 1, -1000);
        }

        public CacheDataSource createDataSourceForRemovingDownload() {
            return a(null, this.i | 1, -1000);
        }

        @Nullable
        public Cache getCache() {
            return this.a;
        }

        public CacheKeyFactory getCacheKeyFactory() {
            return this.d;
        }

        @Nullable
        public PriorityTaskManager getUpstreamPriorityTaskManager() {
            return this.g;
        }

        public Factory setCache(Cache cache) {
            this.a = cache;
            return this;
        }

        public Factory setCacheKeyFactory(CacheKeyFactory cacheKeyFactory) {
            this.d = cacheKeyFactory;
            return this;
        }

        public Factory setCacheReadDataSourceFactory(DataSource.Factory factory) {
            this.b = factory;
            return this;
        }

        public Factory setCacheWriteDataSinkFactory(@Nullable DataSink.Factory factory) {
            this.c = factory;
            this.e = factory == null;
            return this;
        }

        public Factory setEventListener(@Nullable EventListener eventListener) {
            this.j = eventListener;
            return this;
        }

        public Factory setFlags(int i2) {
            this.i = i2;
            return this;
        }

        public Factory setUpstreamDataSourceFactory(@Nullable DataSource.Factory factory) {
            this.f = factory;
            return this;
        }

        public Factory setUpstreamPriority(int i2) {
            this.h = i2;
            return this;
        }

        public Factory setUpstreamPriorityTaskManager(@Nullable PriorityTaskManager priorityTaskManager) {
            this.g = priorityTaskManager;
            return this;
        }

        @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
        public CacheDataSource createDataSource() {
            DataSource.Factory factory = this.f;
            return a(factory != null ? factory.createDataSource() : null, this.i, this.h);
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public CacheDataSource(Cache cache, @Nullable DataSource dataSource) {
        this(cache, dataSource, 0);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.android.exoplayer2.upstream.cache.CacheSpan, com.google.android.exoplayer2.upstream.DataSource] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() throws java.io.IOException {
        /*
            r4 = this;
            com.google.android.exoplayer2.upstream.DataSource r0 = r4.l
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            r1 = 0
            r2 = 0
            r0.close()     // Catch:{ all -> 0x001a }
            r4.l = r2
            r4.m = r1
            com.google.android.exoplayer2.upstream.cache.CacheSpan r0 = r4.p
            if (r0 == 0) goto L_0x0019
            com.google.android.exoplayer2.upstream.cache.Cache r1 = r4.a
            r1.releaseHoleSpan(r0)
            r4.p = r2
        L_0x0019:
            return
        L_0x001a:
            r0 = move-exception
            r4.l = r2
            r4.m = r1
            com.google.android.exoplayer2.upstream.cache.CacheSpan r1 = r4.p
            if (r1 == 0) goto L_0x002a
            com.google.android.exoplayer2.upstream.cache.Cache r3 = r4.a
            r3.releaseHoleSpan(r1)
            r4.p = r2
        L_0x002a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.cache.CacheDataSource.a():void");
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void addTransferListener(TransferListener transferListener) {
        Assertions.checkNotNull(transferListener);
        this.b.addTransferListener(transferListener);
        this.d.addTransferListener(transferListener);
    }

    public final void b(Throwable th) {
        if (c() || (th instanceof Cache.CacheException)) {
            this.q = true;
        }
    }

    public final boolean c() {
        return this.l == this.b;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws IOException {
        this.k = null;
        this.j = null;
        this.n = 0;
        EventListener eventListener = this.f;
        if (eventListener != null && this.s > 0) {
            eventListener.onCachedBytesRead(this.a.getCacheSpace(), this.s);
            this.s = 0;
        }
        try {
            a();
        } catch (Throwable th) {
            b(th);
            throw th;
        }
    }

    public final void d(DataSpec dataSpec, boolean z) throws IOException {
        CacheSpan cacheSpan;
        DataSpec dataSpec2;
        DataSource dataSource;
        long j2;
        String str = (String) Util.castNonNull(dataSpec.key);
        Uri uri = null;
        if (this.r) {
            cacheSpan = null;
        } else if (this.g) {
            try {
                cacheSpan = this.a.startReadWrite(str, this.n, this.o);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        } else {
            cacheSpan = this.a.startReadWriteNonBlocking(str, this.n, this.o);
        }
        if (cacheSpan == null) {
            dataSource = this.d;
            dataSpec2 = dataSpec.buildUpon().setPosition(this.n).setLength(this.o).build();
        } else if (cacheSpan.isCached) {
            Uri fromFile = Uri.fromFile((File) Util.castNonNull(cacheSpan.file));
            long j3 = cacheSpan.position;
            long j4 = this.n - j3;
            long j5 = cacheSpan.length - j4;
            long j6 = this.o;
            if (j6 != -1) {
                j5 = Math.min(j5, j6);
            }
            dataSpec2 = dataSpec.buildUpon().setUri(fromFile).setUriPositionOffset(j3).setPosition(j4).setLength(j5).build();
            dataSource = this.b;
        } else {
            if (cacheSpan.isOpenEnded()) {
                j2 = this.o;
            } else {
                j2 = cacheSpan.length;
                long j7 = this.o;
                if (j7 != -1) {
                    j2 = Math.min(j2, j7);
                }
            }
            dataSpec2 = dataSpec.buildUpon().setPosition(this.n).setLength(j2).build();
            dataSource = this.c;
            if (dataSource == null) {
                dataSource = this.d;
                this.a.releaseHoleSpan(cacheSpan);
                cacheSpan = null;
            }
        }
        this.t = (this.r || dataSource != this.d) ? Long.MAX_VALUE : this.n + 102400;
        boolean z2 = false;
        if (z) {
            Assertions.checkState(this.l == this.d);
            if (dataSource != this.d) {
                try {
                    a();
                } catch (Throwable th) {
                    if (((CacheSpan) Util.castNonNull(cacheSpan)).isHoleSpan()) {
                        this.a.releaseHoleSpan(cacheSpan);
                    }
                    throw th;
                }
            } else {
                return;
            }
        }
        if (cacheSpan != null && cacheSpan.isHoleSpan()) {
            this.p = cacheSpan;
        }
        this.l = dataSource;
        this.m = dataSpec2.length == -1;
        long open = dataSource.open(dataSpec2);
        ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
        if (this.m && open != -1) {
            this.o = open;
            ContentMetadataMutations.setContentLength(contentMetadataMutations, this.n + open);
        }
        if (!c()) {
            Uri uri2 = dataSource.getUri();
            this.j = uri2;
            if (!dataSpec.uri.equals(uri2)) {
                uri = this.j;
            }
            ContentMetadataMutations.setRedirectedUri(contentMetadataMutations, uri);
        }
        if (this.l == this.c) {
            z2 = true;
        }
        if (z2) {
            this.a.applyContentMetadataMutations(str, contentMetadataMutations);
        }
    }

    public final void e(String str) throws IOException {
        this.o = 0;
        if (this.l == this.c) {
            ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
            ContentMetadataMutations.setContentLength(contentMetadataMutations, this.n);
            this.a.applyContentMetadataMutations(str, contentMetadataMutations);
        }
    }

    public Cache getCache() {
        return this.a;
    }

    public CacheKeyFactory getCacheKeyFactory() {
        return this.e;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Map<String, List<String>> getResponseHeaders() {
        if (!c()) {
            return this.d.getResponseHeaders();
        }
        return Collections.emptyMap();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        return this.j;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) throws IOException {
        int i2;
        EventListener eventListener;
        try {
            String buildCacheKey = this.e.buildCacheKey(dataSpec);
            DataSpec build = dataSpec.buildUpon().setKey(buildCacheKey).build();
            this.k = build;
            Cache cache = this.a;
            Uri uri = build.uri;
            Uri uri2 = null;
            String str = cache.getContentMetadata(buildCacheKey).get(ContentMetadata.KEY_REDIRECTED_URI, (String) null);
            if (str != null) {
                uri2 = Uri.parse(str);
            }
            if (uri2 != null) {
                uri = uri2;
            }
            this.j = uri;
            this.n = dataSpec.position;
            boolean z = true;
            if (!this.h || !this.q) {
                i2 = (!this.i || dataSpec.length != -1) ? -1 : 1;
            } else {
                i2 = 0;
            }
            if (i2 == -1) {
                z = false;
            }
            this.r = z;
            if (z && (eventListener = this.f) != null) {
                eventListener.onCacheIgnored(i2);
            }
            long j2 = dataSpec.length;
            if (j2 == -1) {
                if (!this.r) {
                    long a3 = g.a(this.a.getContentMetadata(buildCacheKey));
                    this.o = a3;
                    if (a3 != -1) {
                        long j3 = a3 - dataSpec.position;
                        this.o = j3;
                        if (j3 <= 0) {
                            throw new DataSourceException(0);
                        }
                    }
                    d(build, false);
                    return this.o;
                }
            }
            this.o = j2;
            d(build, false);
            return this.o;
        } catch (Throwable th) {
            b(th);
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        DataSpec dataSpec = (DataSpec) Assertions.checkNotNull(this.k);
        if (i3 == 0) {
            return 0;
        }
        if (this.o == 0) {
            return -1;
        }
        try {
            if (this.n >= this.t) {
                d(dataSpec, true);
            }
            int read = ((DataSource) Assertions.checkNotNull(this.l)).read(bArr, i2, i3);
            if (read != -1) {
                if (c()) {
                    this.s += (long) read;
                }
                long j2 = (long) read;
                this.n += j2;
                long j3 = this.o;
                if (j3 != -1) {
                    this.o = j3 - j2;
                }
            } else if (this.m) {
                e((String) Util.castNonNull(dataSpec.key));
            } else {
                long j4 = this.o;
                if (j4 <= 0) {
                    if (j4 == -1) {
                    }
                }
                a();
                d(dataSpec, false);
                return read(bArr, i2, i3);
            }
            return read;
        } catch (IOException e2) {
            if (!this.m || !DataSourceException.isCausedByPositionOutOfRange(e2)) {
                b(e2);
                throw e2;
            }
            e((String) Util.castNonNull(dataSpec.key));
            return -1;
        } catch (Throwable th) {
            b(th);
            throw th;
        }
    }

    public CacheDataSource(Cache cache, @Nullable DataSource dataSource, int i2) {
        this(cache, dataSource, new FileDataSource(), new CacheDataSink(cache, CacheDataSink.DEFAULT_FRAGMENT_SIZE), i2, null);
    }

    public CacheDataSource(Cache cache, @Nullable DataSource dataSource, DataSource dataSource2, @Nullable DataSink dataSink, int i2, @Nullable EventListener eventListener) {
        this(cache, dataSource, dataSource2, dataSink, i2, eventListener, null);
    }

    public CacheDataSource(Cache cache, @Nullable DataSource dataSource, DataSource dataSource2, @Nullable DataSink dataSink, int i2, @Nullable EventListener eventListener, @Nullable CacheKeyFactory cacheKeyFactory) {
        this(cache, dataSource, dataSource2, dataSink, cacheKeyFactory, i2, null, 0, eventListener);
    }

    public CacheDataSource(Cache cache, @Nullable DataSource dataSource, DataSource dataSource2, @Nullable DataSink dataSink, @Nullable CacheKeyFactory cacheKeyFactory, int i2, @Nullable PriorityTaskManager priorityTaskManager, int i3, @Nullable EventListener eventListener) {
        this.a = cache;
        this.b = dataSource2;
        this.e = cacheKeyFactory == null ? CacheKeyFactory.DEFAULT : cacheKeyFactory;
        boolean z = false;
        this.g = (i2 & 1) != 0;
        this.h = (i2 & 2) != 0;
        this.i = (i2 & 4) != 0 ? true : z;
        TeeDataSource teeDataSource = null;
        if (dataSource != null) {
            dataSource = priorityTaskManager != null ? new PriorityDataSource(dataSource, priorityTaskManager, i3) : dataSource;
            this.d = dataSource;
            this.c = dataSink != null ? new TeeDataSource(dataSource, dataSink) : teeDataSource;
        } else {
            this.d = DummyDataSource.INSTANCE;
            this.c = null;
        }
        this.f = eventListener;
    }
}
