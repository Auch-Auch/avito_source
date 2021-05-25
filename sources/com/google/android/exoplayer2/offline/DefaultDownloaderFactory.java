package com.google.android.exoplayer2.offline;

import a2.b.a.a.a;
import a2.j.b.b.x0.m;
import android.util.SparseArray;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.lang.reflect.Constructor;
import java.util.concurrent.Executor;
public class DefaultDownloaderFactory implements DownloaderFactory {
    public static final SparseArray<Constructor<? extends Downloader>> c;
    public final CacheDataSource.Factory a;
    public final Executor b;

    static {
        SparseArray<Constructor<? extends Downloader>> sparseArray = new SparseArray<>();
        try {
            sparseArray.put(0, a(Class.forName("com.google.android.exoplayer2.source.dash.offline.DashDownloader")));
        } catch (ClassNotFoundException unused) {
        }
        try {
            sparseArray.put(2, a(Class.forName("com.google.android.exoplayer2.source.hls.offline.HlsDownloader")));
        } catch (ClassNotFoundException unused2) {
        }
        try {
            sparseArray.put(1, a(Class.forName("com.google.android.exoplayer2.source.smoothstreaming.offline.SsDownloader")));
        } catch (ClassNotFoundException unused3) {
        }
        c = sparseArray;
    }

    @Deprecated
    public DefaultDownloaderFactory(CacheDataSource.Factory factory) {
        this(factory, m.a);
    }

    public static Constructor<? extends Downloader> a(Class<?> cls) {
        try {
            return cls.asSubclass(Downloader.class).getConstructor(MediaItem.class, CacheDataSource.Factory.class, Executor.class);
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException("Downloader constructor missing", e);
        }
    }

    @Override // com.google.android.exoplayer2.offline.DownloaderFactory
    public Downloader createDownloader(DownloadRequest downloadRequest) {
        int inferContentTypeForUriAndMimeType = Util.inferContentTypeForUriAndMimeType(downloadRequest.uri, downloadRequest.mimeType);
        if (inferContentTypeForUriAndMimeType == 0 || inferContentTypeForUriAndMimeType == 1 || inferContentTypeForUriAndMimeType == 2) {
            Constructor<? extends Downloader> constructor = c.get(inferContentTypeForUriAndMimeType);
            if (constructor != null) {
                try {
                    return (Downloader) constructor.newInstance(new MediaItem.Builder().setUri(downloadRequest.uri).setStreamKeys(downloadRequest.streamKeys).setCustomCacheKey(downloadRequest.customCacheKey).setDrmKeySetId(downloadRequest.keySetId).build(), this.a, this.b);
                } catch (Exception unused) {
                    throw new IllegalStateException(a.M2("Failed to instantiate downloader for content type ", inferContentTypeForUriAndMimeType));
                }
            } else {
                throw new IllegalStateException(a.M2("Module missing for content type ", inferContentTypeForUriAndMimeType));
            }
        } else if (inferContentTypeForUriAndMimeType == 3) {
            return new ProgressiveDownloader(new MediaItem.Builder().setUri(downloadRequest.uri).setCustomCacheKey(downloadRequest.customCacheKey).build(), this.a, this.b);
        } else {
            throw new IllegalArgumentException(a.M2("Unsupported type: ", inferContentTypeForUriAndMimeType));
        }
    }

    public DefaultDownloaderFactory(CacheDataSource.Factory factory, Executor executor) {
        this.a = (CacheDataSource.Factory) Assertions.checkNotNull(factory);
        this.b = (Executor) Assertions.checkNotNull(executor);
    }
}
