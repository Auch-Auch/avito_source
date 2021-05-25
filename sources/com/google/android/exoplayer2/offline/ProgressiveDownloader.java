package com.google.android.exoplayer2.offline;

import a2.j.b.b.x0.m;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.offline.Downloader;
import com.google.android.exoplayer2.offline.ProgressiveDownloader;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheWriter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.RunnableFutureTask;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
public final class ProgressiveDownloader implements Downloader {
    public final Executor a;
    public final DataSpec b;
    public final CacheDataSource c;
    public final CacheWriter d;
    @Nullable
    public final PriorityTaskManager e;
    @Nullable
    public Downloader.ProgressListener f;
    public volatile RunnableFutureTask<Void, IOException> g;
    public volatile boolean h;

    public class a extends RunnableFutureTask<Void, IOException> {
        public a() {
        }

        @Override // com.google.android.exoplayer2.util.RunnableFutureTask
        public void cancelWork() {
            ProgressiveDownloader.this.d.cancel();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.google.android.exoplayer2.util.RunnableFutureTask
        public Void doWork() throws Exception {
            ProgressiveDownloader.this.d.cache();
            return null;
        }
    }

    @Deprecated
    public ProgressiveDownloader(Uri uri, @Nullable String str, CacheDataSource.Factory factory) {
        this(uri, str, factory, m.a);
    }

    @Override // com.google.android.exoplayer2.offline.Downloader
    public void cancel() {
        this.h = true;
        RunnableFutureTask<Void, IOException> runnableFutureTask = this.g;
        if (runnableFutureTask != null) {
            runnableFutureTask.cancel(true);
        }
    }

    @Override // com.google.android.exoplayer2.offline.Downloader
    public void download(@Nullable Downloader.ProgressListener progressListener) throws IOException, InterruptedException {
        this.f = progressListener;
        this.g = new a();
        PriorityTaskManager priorityTaskManager = this.e;
        if (priorityTaskManager != null) {
            priorityTaskManager.add(-1000);
        }
        boolean z = false;
        while (!z) {
            try {
                if (this.h) {
                    break;
                }
                PriorityTaskManager priorityTaskManager2 = this.e;
                if (priorityTaskManager2 != null) {
                    priorityTaskManager2.proceed(-1000);
                }
                this.a.execute(this.g);
                try {
                    this.g.get();
                    z = true;
                } catch (ExecutionException e2) {
                    Throwable th = (Throwable) Assertions.checkNotNull(e2.getCause());
                    if (th instanceof PriorityTaskManager.PriorityTooLowException) {
                        continue;
                    } else if (!(th instanceof IOException)) {
                        Util.sneakyThrow(th);
                    } else {
                        throw ((IOException) th);
                    }
                }
            } catch (Throwable th2) {
                this.g.blockUntilFinished();
                PriorityTaskManager priorityTaskManager3 = this.e;
                if (priorityTaskManager3 != null) {
                    priorityTaskManager3.remove(-1000);
                }
                throw th2;
            }
        }
        this.g.blockUntilFinished();
        PriorityTaskManager priorityTaskManager4 = this.e;
        if (priorityTaskManager4 != null) {
            priorityTaskManager4.remove(-1000);
        }
    }

    @Override // com.google.android.exoplayer2.offline.Downloader
    public void remove() {
        this.c.getCache().removeResource(this.c.getCacheKeyFactory().buildCacheKey(this.b));
    }

    public ProgressiveDownloader(MediaItem mediaItem, CacheDataSource.Factory factory) {
        this(mediaItem, factory, m.a);
    }

    @Deprecated
    public ProgressiveDownloader(Uri uri, @Nullable String str, CacheDataSource.Factory factory, Executor executor) {
        this(new MediaItem.Builder().setUri(uri).setCustomCacheKey(str).build(), factory, executor);
    }

    public ProgressiveDownloader(MediaItem mediaItem, CacheDataSource.Factory factory, Executor executor) {
        this.a = (Executor) Assertions.checkNotNull(executor);
        Assertions.checkNotNull(mediaItem.playbackProperties);
        DataSpec build = new DataSpec.Builder().setUri(mediaItem.playbackProperties.uri).setKey(mediaItem.playbackProperties.customCacheKey).setFlags(4).build();
        this.b = build;
        CacheDataSource createDataSourceForDownloading = factory.createDataSourceForDownloading();
        this.c = createDataSourceForDownloading;
        this.d = new CacheWriter(createDataSourceForDownloading, build, false, null, new CacheWriter.ProgressListener() { // from class: a2.j.b.b.x0.n
            @Override // com.google.android.exoplayer2.upstream.cache.CacheWriter.ProgressListener
            public final void onProgress(long j, long j2, long j3) {
                Downloader.ProgressListener progressListener = ProgressiveDownloader.this.f;
                if (progressListener != null) {
                    progressListener.onProgress(j, j2, (j == -1 || j == 0) ? -1.0f : (((float) j2) * 100.0f) / ((float) j));
                }
            }
        });
        this.e = factory.getUpstreamPriorityTaskManager();
    }
}
