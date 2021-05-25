package com.google.android.exoplayer2.offline;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.offline.Downloader;
import com.google.android.exoplayer2.offline.FilterableManifest;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheKeyFactory;
import com.google.android.exoplayer2.upstream.cache.CacheWriter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.RunnableFutureTask;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
public abstract class SegmentDownloader<M extends FilterableManifest<M>> implements Downloader {
    public final DataSpec a;
    public final ParsingLoadable.Parser<M> b;
    public final ArrayList<StreamKey> c;
    public final CacheDataSource.Factory d;
    public final Cache e;
    public final CacheKeyFactory f;
    @Nullable
    public final PriorityTaskManager g;
    public final Executor h;
    public final ArrayList<RunnableFutureTask<?, ?>> i = new ArrayList<>();
    public volatile boolean j;

    public static class Segment implements Comparable<Segment> {
        public final DataSpec dataSpec;
        public final long startTimeUs;

        public Segment(long j, DataSpec dataSpec2) {
            this.startTimeUs = j;
            this.dataSpec = dataSpec2;
        }

        public int compareTo(Segment segment) {
            return Util.compareLong(this.startTimeUs, segment.startTimeUs);
        }
    }

    public class a extends RunnableFutureTask<M, IOException> {
        public final /* synthetic */ DataSource h;
        public final /* synthetic */ DataSpec i;

        public a(DataSource dataSource, DataSpec dataSpec) {
            this.h = dataSource;
            this.i = dataSpec;
        }

        @Override // com.google.android.exoplayer2.util.RunnableFutureTask
        public Object doWork() throws Exception {
            return (FilterableManifest) ParsingLoadable.load(this.h, SegmentDownloader.this.b, this.i, 4);
        }
    }

    public static final class b implements CacheWriter.ProgressListener {
        public final Downloader.ProgressListener a;
        public final long b;
        public final int c;
        public long d;
        public int e;

        public b(Downloader.ProgressListener progressListener, long j, int i, long j2, int i2) {
            this.a = progressListener;
            this.b = j;
            this.c = i;
            this.d = j2;
            this.e = i2;
        }

        public final float a() {
            long j = this.b;
            if (j != -1 && j != 0) {
                return (((float) this.d) * 100.0f) / ((float) j);
            }
            int i = this.c;
            if (i != 0) {
                return (((float) this.e) * 100.0f) / ((float) i);
            }
            return -1.0f;
        }

        @Override // com.google.android.exoplayer2.upstream.cache.CacheWriter.ProgressListener
        public void onProgress(long j, long j2, long j3) {
            long j4 = this.d + j3;
            this.d = j4;
            this.a.onProgress(this.b, j4, a());
        }
    }

    public static final class c extends RunnableFutureTask<Void, IOException> {
        public final Segment h;
        public final CacheDataSource i;
        @Nullable
        public final b j;
        public final byte[] k;
        public final CacheWriter l;

        public c(Segment segment, CacheDataSource cacheDataSource, @Nullable b bVar, byte[] bArr) {
            this.h = segment;
            this.i = cacheDataSource;
            this.j = bVar;
            this.k = bArr;
            this.l = new CacheWriter(cacheDataSource, segment.dataSpec, false, bArr, bVar);
        }

        @Override // com.google.android.exoplayer2.util.RunnableFutureTask
        public void cancelWork() {
            this.l.cancel();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.google.android.exoplayer2.util.RunnableFutureTask
        public Void doWork() throws Exception {
            this.l.cache();
            b bVar = this.j;
            if (bVar == null) {
                return null;
            }
            bVar.e++;
            bVar.a.onProgress(bVar.b, bVar.d, bVar.a());
            return null;
        }
    }

    public SegmentDownloader(MediaItem mediaItem, ParsingLoadable.Parser<M> parser, CacheDataSource.Factory factory, Executor executor) {
        Assertions.checkNotNull(mediaItem.playbackProperties);
        this.a = getCompressibleDataSpec(mediaItem.playbackProperties.uri);
        this.b = parser;
        this.c = new ArrayList<>(mediaItem.playbackProperties.streamKeys);
        this.d = factory;
        this.h = executor;
        this.e = (Cache) Assertions.checkNotNull(factory.getCache());
        this.f = factory.getCacheKeyFactory();
        this.g = factory.getUpstreamPriorityTaskManager();
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0085  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(java.util.List<com.google.android.exoplayer2.offline.SegmentDownloader.Segment> r18, com.google.android.exoplayer2.upstream.cache.CacheKeyFactory r19) {
        /*
            r0 = r18
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r3 = 0
            r4 = 0
        L_0x0009:
            int r5 = r18.size()
            if (r3 >= r5) goto L_0x00c4
            java.lang.Object r5 = r0.get(r3)
            com.google.android.exoplayer2.offline.SegmentDownloader$Segment r5 = (com.google.android.exoplayer2.offline.SegmentDownloader.Segment) r5
            com.google.android.exoplayer2.upstream.DataSpec r6 = r5.dataSpec
            r7 = r19
            java.lang.String r6 = r7.buildCacheKey(r6)
            java.lang.Object r8 = r1.get(r6)
            java.lang.Integer r8 = (java.lang.Integer) r8
            if (r8 != 0) goto L_0x0027
            r9 = 0
            goto L_0x0031
        L_0x0027:
            int r9 = r8.intValue()
            java.lang.Object r9 = r0.get(r9)
            com.google.android.exoplayer2.offline.SegmentDownloader$Segment r9 = (com.google.android.exoplayer2.offline.SegmentDownloader.Segment) r9
        L_0x0031:
            if (r9 == 0) goto L_0x00b3
            long r10 = r5.startTimeUs
            long r12 = r9.startTimeUs
            r14 = 20000000(0x1312d00, double:9.881313E-317)
            long r12 = r12 + r14
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 > 0) goto L_0x00b3
            com.google.android.exoplayer2.upstream.DataSpec r10 = r9.dataSpec
            com.google.android.exoplayer2.upstream.DataSpec r11 = r5.dataSpec
            android.net.Uri r12 = r10.uri
            android.net.Uri r13 = r11.uri
            boolean r12 = r12.equals(r13)
            r13 = -1
            r15 = r3
            if (r12 == 0) goto L_0x0081
            long r2 = r10.length
            int r16 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r16 == 0) goto L_0x0081
            long r12 = r10.position
            long r12 = r12 + r2
            long r2 = r11.position
            int r17 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r17 != 0) goto L_0x0081
            java.lang.String r2 = r10.key
            java.lang.String r3 = r11.key
            boolean r2 = com.google.android.exoplayer2.util.Util.areEqual(r2, r3)
            if (r2 == 0) goto L_0x0081
            int r2 = r10.flags
            int r3 = r11.flags
            if (r2 != r3) goto L_0x0081
            int r2 = r10.httpMethod
            int r3 = r11.httpMethod
            if (r2 != r3) goto L_0x0081
            java.util.Map<java.lang.String, java.lang.String> r2 = r10.httpRequestHeaders
            java.util.Map<java.lang.String, java.lang.String> r3 = r11.httpRequestHeaders
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0081
            r2 = 1
            goto L_0x0082
        L_0x0081:
            r2 = 0
        L_0x0082:
            if (r2 != 0) goto L_0x0085
            goto L_0x00b4
        L_0x0085:
            com.google.android.exoplayer2.upstream.DataSpec r2 = r5.dataSpec
            long r2 = r2.length
            r5 = -1
            int r10 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r10 != 0) goto L_0x0091
            r2 = r5
            goto L_0x0096
        L_0x0091:
            com.google.android.exoplayer2.upstream.DataSpec r5 = r9.dataSpec
            long r5 = r5.length
            long r2 = r2 + r5
        L_0x0096:
            com.google.android.exoplayer2.upstream.DataSpec r5 = r9.dataSpec
            r10 = 0
            com.google.android.exoplayer2.upstream.DataSpec r2 = r5.subrange(r10, r2)
            java.lang.Object r3 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r8)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            com.google.android.exoplayer2.offline.SegmentDownloader$Segment r5 = new com.google.android.exoplayer2.offline.SegmentDownloader$Segment
            long r8 = r9.startTimeUs
            r5.<init>(r8, r2)
            r0.set(r3, r5)
            goto L_0x00c0
        L_0x00b3:
            r15 = r3
        L_0x00b4:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r1.put(r6, r2)
            r0.set(r4, r5)
            int r4 = r4 + 1
        L_0x00c0:
            int r3 = r15 + 1
            goto L_0x0009
        L_0x00c4:
            int r1 = r18.size()
            com.google.android.exoplayer2.util.Util.removeRange(r0, r4, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.offline.SegmentDownloader.b(java.util.List, com.google.android.exoplayer2.upstream.cache.CacheKeyFactory):void");
    }

    public static DataSpec getCompressibleDataSpec(Uri uri) {
        return new DataSpec.Builder().setUri(uri).setFlags(1).build();
    }

    public final <T> void a(RunnableFutureTask<T, ?> runnableFutureTask) throws InterruptedException {
        synchronized (this.i) {
            if (!this.j) {
                this.i.add(runnableFutureTask);
            } else {
                throw new InterruptedException();
            }
        }
    }

    public final void c(int i2) {
        synchronized (this.i) {
            this.i.remove(i2);
        }
    }

    @Override // com.google.android.exoplayer2.offline.Downloader
    public void cancel() {
        synchronized (this.i) {
            this.j = true;
            for (int i2 = 0; i2 < this.i.size(); i2++) {
                this.i.get(i2).cancel(true);
            }
        }
    }

    public final void d(RunnableFutureTask<?, ?> runnableFutureTask) {
        synchronized (this.i) {
            this.i.remove(runnableFutureTask);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12, types: [com.google.android.exoplayer2.offline.SegmentDownloader] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01a6 A[LOOP:5: B:80:0x019e->B:82:0x01a6, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01bf A[LOOP:6: B:84:0x01bd->B:85:0x01bf, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01d4  */
    @Override // com.google.android.exoplayer2.offline.Downloader
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void download(@androidx.annotation.Nullable com.google.android.exoplayer2.offline.Downloader.ProgressListener r26) throws java.io.IOException, java.lang.InterruptedException {
        /*
        // Method dump skipped, instructions count: 474
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.offline.SegmentDownloader.download(com.google.android.exoplayer2.offline.Downloader$ProgressListener):void");
    }

    public final <T> T execute(RunnableFutureTask<T, ?> runnableFutureTask, boolean z) throws InterruptedException, IOException {
        if (z) {
            runnableFutureTask.run();
            try {
                return runnableFutureTask.get();
            } catch (ExecutionException e2) {
                Throwable th = (Throwable) Assertions.checkNotNull(e2.getCause());
                if (!(th instanceof IOException)) {
                    Util.sneakyThrow(e2);
                } else {
                    throw ((IOException) th);
                }
            }
        }
        while (!this.j) {
            PriorityTaskManager priorityTaskManager = this.g;
            if (priorityTaskManager != null) {
                priorityTaskManager.proceed(-1000);
            }
            a(runnableFutureTask);
            this.h.execute(runnableFutureTask);
            try {
                return runnableFutureTask.get();
            } catch (ExecutionException e3) {
                Throwable th2 = (Throwable) Assertions.checkNotNull(e3.getCause());
                if (!(th2 instanceof PriorityTaskManager.PriorityTooLowException)) {
                    if (!(th2 instanceof IOException)) {
                        Util.sneakyThrow(e3);
                    } else {
                        throw ((IOException) th2);
                    }
                }
            } finally {
                runnableFutureTask.blockUntilFinished();
                d(runnableFutureTask);
            }
        }
        throw new InterruptedException();
    }

    public final M getManifest(DataSource dataSource, DataSpec dataSpec, boolean z) throws InterruptedException, IOException {
        return (M) ((FilterableManifest) execute(new a(dataSource, dataSpec), z));
    }

    public abstract List<Segment> getSegments(DataSource dataSource, M m, boolean z) throws IOException, InterruptedException;

    @Override // com.google.android.exoplayer2.offline.Downloader
    public final void remove() {
        CacheDataSource createDataSourceForRemovingDownload = this.d.createDataSourceForRemovingDownload();
        try {
            List<Segment> segments = getSegments(createDataSourceForRemovingDownload, getManifest(createDataSourceForRemovingDownload, this.a, true), true);
            for (int i2 = 0; i2 < segments.size(); i2++) {
                this.e.removeResource(this.f.buildCacheKey(segments.get(i2).dataSpec));
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        } catch (Exception unused2) {
        } catch (Throwable th) {
            this.e.removeResource(this.f.buildCacheKey(this.a));
            throw th;
        }
        this.e.removeResource(this.f.buildCacheKey(this.a));
    }
}
