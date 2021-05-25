package com.google.android.exoplayer2.source;

import a2.j.b.b.z0.p;
import android.content.Context;
import android.net.Uri;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.SingleSampleMediaSource;
import com.google.android.exoplayer2.source.ads.AdsLoader;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.List;
public final class DefaultMediaSourceFactory implements MediaSourceFactory {
    public final MediaSourceDrmHelper a;
    public final DataSource.Factory b;
    public final SparseArray<MediaSourceFactory> c;
    public final int[] d;
    @Nullable
    public AdsLoaderProvider e;
    @Nullable
    public AdsLoader.AdViewProvider f;
    @Nullable
    public DrmSessionManager g;
    @Nullable
    public List<StreamKey> h;
    @Nullable
    public LoadErrorHandlingPolicy i;

    public interface AdsLoaderProvider {
        @Nullable
        AdsLoader getAdsLoader(Uri uri);
    }

    public DefaultMediaSourceFactory(Context context) {
        this(new DefaultDataSourceFactory(context));
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceFactory
    public /* synthetic */ MediaSource createMediaSource(Uri uri) {
        return p.$default$createMediaSource(this, uri);
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceFactory
    public MediaSource createMediaSource(MediaItem mediaItem) {
        List<StreamKey> list;
        MediaSource mediaSource;
        Assertions.checkNotNull(mediaItem.playbackProperties);
        MediaItem.PlaybackProperties playbackProperties = mediaItem.playbackProperties;
        int inferContentTypeForUriAndMimeType = Util.inferContentTypeForUriAndMimeType(playbackProperties.uri, playbackProperties.mimeType);
        MediaSourceFactory mediaSourceFactory = this.c.get(inferContentTypeForUriAndMimeType);
        Assertions.checkNotNull(mediaSourceFactory, "No suitable media source factory found for content type: " + inferContentTypeForUriAndMimeType);
        DrmSessionManager drmSessionManager = this.g;
        if (drmSessionManager == null) {
            drmSessionManager = this.a.create(mediaItem);
        }
        mediaSourceFactory.setDrmSessionManager(drmSessionManager);
        if (!mediaItem.playbackProperties.streamKeys.isEmpty()) {
            list = mediaItem.playbackProperties.streamKeys;
        } else {
            list = this.h;
        }
        mediaSourceFactory.setStreamKeys(list);
        mediaSourceFactory.setLoadErrorHandlingPolicy(this.i);
        MediaSource createMediaSource = mediaSourceFactory.createMediaSource(mediaItem);
        List<MediaItem.Subtitle> list2 = mediaItem.playbackProperties.subtitles;
        if (!list2.isEmpty()) {
            MediaSource[] mediaSourceArr = new MediaSource[(list2.size() + 1)];
            int i2 = 0;
            mediaSourceArr[0] = createMediaSource;
            SingleSampleMediaSource.Factory factory = new SingleSampleMediaSource.Factory(this.b);
            while (i2 < list2.size()) {
                int i3 = i2 + 1;
                mediaSourceArr[i3] = factory.createMediaSource(list2.get(i2), C.TIME_UNSET);
                i2 = i3;
            }
            createMediaSource = new MergingMediaSource(mediaSourceArr);
        }
        MediaItem.ClippingProperties clippingProperties = mediaItem.clippingProperties;
        long j = clippingProperties.startPositionMs;
        if (j == 0 && clippingProperties.endPositionMs == Long.MIN_VALUE && !clippingProperties.relativeToDefaultPosition) {
            mediaSource = createMediaSource;
        } else {
            long msToUs = C.msToUs(j);
            long msToUs2 = C.msToUs(mediaItem.clippingProperties.endPositionMs);
            MediaItem.ClippingProperties clippingProperties2 = mediaItem.clippingProperties;
            mediaSource = new ClippingMediaSource(createMediaSource, msToUs, msToUs2, !clippingProperties2.startsAtKeyFrame, clippingProperties2.relativeToLiveWindow, clippingProperties2.relativeToDefaultPosition);
        }
        Assertions.checkNotNull(mediaItem.playbackProperties);
        Uri uri = mediaItem.playbackProperties.adTagUri;
        if (uri == null) {
            return mediaSource;
        }
        AdsLoaderProvider adsLoaderProvider = this.e;
        AdsLoader.AdViewProvider adViewProvider = this.f;
        if (adsLoaderProvider == null || adViewProvider == null) {
            Log.w("DefaultMediaSourceFactory", "Playing media without ads. Configure ad support by calling setAdsLoaderProvider and setAdViewProvider.");
            return mediaSource;
        }
        AdsLoader adsLoader = adsLoaderProvider.getAdsLoader(uri);
        if (adsLoader != null) {
            return new AdsMediaSource(mediaSource, new DataSpec(uri), this, adsLoader, adViewProvider);
        }
        Log.w("DefaultMediaSourceFactory", "Playing media without ads. No AdsLoader for provided adTagUri");
        return mediaSource;
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceFactory
    public int[] getSupportedTypes() {
        int[] iArr = this.d;
        return Arrays.copyOf(iArr, iArr.length);
    }

    public DefaultMediaSourceFactory setAdViewProvider(@Nullable AdsLoader.AdViewProvider adViewProvider) {
        this.f = adViewProvider;
        return this;
    }

    public DefaultMediaSourceFactory setAdsLoaderProvider(@Nullable AdsLoaderProvider adsLoaderProvider) {
        this.e = adsLoaderProvider;
        return this;
    }

    public DefaultMediaSourceFactory(Context context, ExtractorsFactory extractorsFactory) {
        this(new DefaultDataSourceFactory(context), extractorsFactory);
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceFactory
    public DefaultMediaSourceFactory setDrmHttpDataSourceFactory(@Nullable HttpDataSource.Factory factory) {
        this.a.setDrmHttpDataSourceFactory(factory);
        return this;
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceFactory
    public DefaultMediaSourceFactory setDrmSessionManager(@Nullable DrmSessionManager drmSessionManager) {
        this.g = drmSessionManager;
        return this;
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceFactory
    public DefaultMediaSourceFactory setDrmUserAgent(@Nullable String str) {
        this.a.setDrmUserAgent(str);
        return this;
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceFactory
    public DefaultMediaSourceFactory setLoadErrorHandlingPolicy(@Nullable LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        this.i = loadErrorHandlingPolicy;
        return this;
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceFactory
    @Deprecated
    public DefaultMediaSourceFactory setStreamKeys(@Nullable List<StreamKey> list) {
        if (list == null || list.isEmpty()) {
            list = null;
        }
        this.h = list;
        return this;
    }

    public DefaultMediaSourceFactory(DataSource.Factory factory) {
        this(factory, new DefaultExtractorsFactory());
    }

    public DefaultMediaSourceFactory(DataSource.Factory factory, ExtractorsFactory extractorsFactory) {
        this.b = factory;
        this.a = new MediaSourceDrmHelper();
        SparseArray<MediaSourceFactory> sparseArray = new SparseArray<>();
        try {
            sparseArray.put(0, (MediaSourceFactory) Class.forName("com.google.android.exoplayer2.source.dash.DashMediaSource$Factory").asSubclass(MediaSourceFactory.class).getConstructor(DataSource.Factory.class).newInstance(factory));
        } catch (Exception unused) {
        }
        try {
            sparseArray.put(1, (MediaSourceFactory) Class.forName("com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource$Factory").asSubclass(MediaSourceFactory.class).getConstructor(DataSource.Factory.class).newInstance(factory));
        } catch (Exception unused2) {
        }
        try {
            sparseArray.put(2, (MediaSourceFactory) Class.forName("com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory").asSubclass(MediaSourceFactory.class).getConstructor(DataSource.Factory.class).newInstance(factory));
        } catch (Exception unused3) {
        }
        sparseArray.put(3, new ProgressiveMediaSource.Factory(factory, extractorsFactory));
        this.c = sparseArray;
        this.d = new int[sparseArray.size()];
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            this.d[i2] = this.c.keyAt(i2);
        }
    }
}
