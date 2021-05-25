package com.google.android.exoplayer2.source;

import a2.j.b.b.z0.o;
import a2.j.b.b.z0.p;
import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.List;
@Deprecated
public final class ExtractorMediaSource extends CompositeMediaSource<Void> {
    @Deprecated
    public static final int DEFAULT_LOADING_CHECK_INTERVAL_BYTES = 1048576;
    public final ProgressiveMediaSource j;

    @Deprecated
    public interface EventListener {
        void onLoadError(IOException iOException);
    }

    @Deprecated
    public static final class Factory implements MediaSourceFactory {
        public final DataSource.Factory a;
        public ExtractorsFactory b = new DefaultExtractorsFactory();
        public LoadErrorHandlingPolicy c = new DefaultLoadErrorHandlingPolicy();
        public int d = 1048576;
        @Nullable
        public String e;
        @Nullable
        public Object f;

        public Factory(DataSource.Factory factory) {
            this.a = factory;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public int[] getSupportedTypes() {
            return new int[]{3};
        }

        public Factory setContinueLoadingCheckIntervalBytes(int i) {
            this.d = i;
            return this;
        }

        public Factory setCustomCacheKey(@Nullable String str) {
            this.e = str;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        @Deprecated
        public MediaSourceFactory setDrmHttpDataSourceFactory(@Nullable HttpDataSource.Factory factory) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        @Deprecated
        public MediaSourceFactory setDrmUserAgent(@Nullable String str) {
            throw new UnsupportedOperationException();
        }

        public Factory setExtractorsFactory(@Nullable ExtractorsFactory extractorsFactory) {
            if (extractorsFactory == null) {
                extractorsFactory = new DefaultExtractorsFactory();
            }
            this.b = extractorsFactory;
            return this;
        }

        @Deprecated
        public Factory setMinLoadableRetryCount(int i) {
            return setLoadErrorHandlingPolicy((LoadErrorHandlingPolicy) new DefaultLoadErrorHandlingPolicy(i));
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public /* synthetic */ MediaSourceFactory setStreamKeys(List list) {
            return p.$default$setStreamKeys(this, list);
        }

        @Deprecated
        public Factory setTag(@Nullable Object obj) {
            this.f = obj;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        @Deprecated
        public Factory setDrmSessionManager(@Nullable DrmSessionManager drmSessionManager) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public Factory setLoadErrorHandlingPolicy(@Nullable LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            if (loadErrorHandlingPolicy == null) {
                loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
            }
            this.c = loadErrorHandlingPolicy;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        @Deprecated
        public ExtractorMediaSource createMediaSource(Uri uri) {
            return createMediaSource(new MediaItem.Builder().setUri(uri).build());
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public ExtractorMediaSource createMediaSource(MediaItem mediaItem) {
            Assertions.checkNotNull(mediaItem.playbackProperties);
            MediaItem.PlaybackProperties playbackProperties = mediaItem.playbackProperties;
            Uri uri = playbackProperties.uri;
            DataSource.Factory factory = this.a;
            ExtractorsFactory extractorsFactory = this.b;
            LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.c;
            String str = this.e;
            int i = this.d;
            Object obj = playbackProperties.tag;
            if (obj == null) {
                obj = this.f;
            }
            return new ExtractorMediaSource(uri, factory, extractorsFactory, loadErrorHandlingPolicy, str, i, obj);
        }

        @Deprecated
        public ExtractorMediaSource createMediaSource(Uri uri, @Nullable Handler handler, @Nullable MediaSourceEventListener mediaSourceEventListener) {
            ExtractorMediaSource createMediaSource = createMediaSource(uri);
            if (!(handler == null || mediaSourceEventListener == null)) {
                createMediaSource.addEventListener(handler, mediaSourceEventListener);
            }
            return createMediaSource;
        }
    }

    @Deprecated
    public static final class a implements MediaSourceEventListener {
        public final EventListener a;

        public a(EventListener eventListener) {
            this.a = (EventListener) Assertions.checkNotNull(eventListener);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public /* synthetic */ void onDownstreamFormatChanged(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            o.$default$onDownstreamFormatChanged(this, i, mediaPeriodId, mediaLoadData);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public /* synthetic */ void onLoadCanceled(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            o.$default$onLoadCanceled(this, i, mediaPeriodId, loadEventInfo, mediaLoadData);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public /* synthetic */ void onLoadCompleted(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            o.$default$onLoadCompleted(this, i, mediaPeriodId, loadEventInfo, mediaLoadData);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadError(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
            this.a.onLoadError(iOException);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public /* synthetic */ void onLoadStarted(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            o.$default$onLoadStarted(this, i, mediaPeriodId, loadEventInfo, mediaLoadData);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public /* synthetic */ void onUpstreamDiscarded(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            o.$default$onUpstreamDiscarded(this, i, mediaPeriodId, mediaLoadData);
        }
    }

    @Deprecated
    public ExtractorMediaSource(Uri uri, DataSource.Factory factory, ExtractorsFactory extractorsFactory, @Nullable Handler handler, @Nullable EventListener eventListener) {
        this(uri, factory, extractorsFactory, handler, eventListener, null);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        return this.j.createPeriod(mediaPeriodId, allocator, j2);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaItem getMediaItem() {
        return this.j.getMediaItem();
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource, com.google.android.exoplayer2.source.MediaSource
    @Nullable
    @Deprecated
    public Object getTag() {
        return this.j.getTag();
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        prepareChildSource(null, this.j);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        this.j.releasePeriod(mediaPeriod);
    }

    @Deprecated
    public ExtractorMediaSource(Uri uri, DataSource.Factory factory, ExtractorsFactory extractorsFactory, @Nullable Handler handler, @Nullable EventListener eventListener, @Nullable String str) {
        this(uri, factory, extractorsFactory, handler, eventListener, str, 1048576);
    }

    public void onChildSourceInfoRefreshed(@Nullable Void r1, MediaSource mediaSource, Timeline timeline) {
        refreshSourceInfo(timeline);
    }

    @Deprecated
    public ExtractorMediaSource(Uri uri, DataSource.Factory factory, ExtractorsFactory extractorsFactory, @Nullable Handler handler, @Nullable EventListener eventListener, @Nullable String str, int i) {
        this(uri, factory, extractorsFactory, new DefaultLoadErrorHandlingPolicy(), str, i, (Object) null);
        if (eventListener != null && handler != null) {
            addEventListener(handler, new a(eventListener));
        }
    }

    public ExtractorMediaSource(Uri uri, DataSource.Factory factory, ExtractorsFactory extractorsFactory, LoadErrorHandlingPolicy loadErrorHandlingPolicy, @Nullable String str, int i, @Nullable Object obj) {
        this.j = new ProgressiveMediaSource(new MediaItem.Builder().setUri(uri).setCustomCacheKey(str).setTag(obj).build(), factory, extractorsFactory, DrmSessionManager.DUMMY, loadErrorHandlingPolicy, i);
    }
}
