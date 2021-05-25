package com.google.android.exoplayer2.upstream.cache;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataSpec;
import java.io.InterruptedIOException;
public final class CacheWriter {
    public static final int DEFAULT_BUFFER_SIZE_BYTES = 131072;
    public final CacheDataSource a;
    public final Cache b;
    public final DataSpec c;
    public final boolean d;
    public final String e;
    public final byte[] f;
    @Nullable
    public final ProgressListener g;
    public boolean h;
    public long i;
    public long j;
    public long k;
    public volatile boolean l;

    public interface ProgressListener {
        void onProgress(long j, long j2, long j3);
    }

    public CacheWriter(CacheDataSource cacheDataSource, DataSpec dataSpec, boolean z, @Nullable byte[] bArr, @Nullable ProgressListener progressListener) {
        this.a = cacheDataSource;
        this.b = cacheDataSource.getCache();
        this.c = dataSpec;
        this.d = z;
        this.f = bArr == null ? new byte[131072] : bArr;
        this.g = progressListener;
        this.e = cacheDataSource.getCacheKeyFactory().buildCacheKey(dataSpec);
        this.i = dataSpec.position;
    }

    public final long a() {
        long j2 = this.j;
        if (j2 == -1) {
            return -1;
        }
        return j2 - this.c.position;
    }

    public final void b(long j2) {
        if (this.j != j2) {
            this.j = j2;
            ProgressListener progressListener = this.g;
            if (progressListener != null) {
                progressListener.onProgress(a(), this.k, 0);
            }
        }
    }

    public final void c() throws InterruptedIOException {
        if (this.l) {
            throw new InterruptedIOException();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d9 A[Catch:{ IOException -> 0x00c1, all -> 0x00be }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0103 A[Catch:{ IOException -> 0x00c1, all -> 0x00be }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x012f A[Catch:{ IOException -> 0x00c1, all -> 0x00be }] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void cache() throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 329
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.cache.CacheWriter.cache():void");
    }

    public void cancel() {
        this.l = true;
    }
}
