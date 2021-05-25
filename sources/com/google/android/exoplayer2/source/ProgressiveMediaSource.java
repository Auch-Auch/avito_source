package com.google.android.exoplayer2.source;

import a2.j.b.b.z0.p;
import a2.j.b.b.z0.r;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
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
import java.util.List;
public final class ProgressiveMediaSource extends BaseMediaSource implements r.b {
    public static final int DEFAULT_LOADING_CHECK_INTERVAL_BYTES = 1048576;
    public final MediaItem g;
    public final MediaItem.PlaybackProperties h;
    public final DataSource.Factory i;
    public final ExtractorsFactory j;
    public final DrmSessionManager k;
    public final LoadErrorHandlingPolicy l;
    public final int m;
    public boolean n = true;
    public long o = C.TIME_UNSET;
    public boolean p;
    public boolean q;
    @Nullable
    public TransferListener r;

    public static final class Factory implements MediaSourceFactory {
        public final DataSource.Factory a;
        public final MediaSourceDrmHelper b;
        public ExtractorsFactory c;
        @Nullable
        public DrmSessionManager d;
        public LoadErrorHandlingPolicy e;
        public int f;
        @Nullable
        public String g;
        @Nullable
        public Object h;

        public Factory(DataSource.Factory factory) {
            this(factory, new DefaultExtractorsFactory());
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public int[] getSupportedTypes() {
            return new int[]{3};
        }

        public Factory setContinueLoadingCheckIntervalBytes(int i) {
            this.f = i;
            return this;
        }

        @Deprecated
        public Factory setCustomCacheKey(@Nullable String str) {
            this.g = str;
            return this;
        }

        @Deprecated
        public Factory setExtractorsFactory(@Nullable ExtractorsFactory extractorsFactory) {
            if (extractorsFactory == null) {
                extractorsFactory = new DefaultExtractorsFactory();
            }
            this.c = extractorsFactory;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public /* synthetic */ MediaSourceFactory setStreamKeys(List list) {
            return p.$default$setStreamKeys(this, list);
        }

        @Deprecated
        public Factory setTag(@Nullable Object obj) {
            this.h = obj;
            return this;
        }

        public Factory(DataSource.Factory factory, ExtractorsFactory extractorsFactory) {
            this.a = factory;
            this.c = extractorsFactory;
            this.b = new MediaSourceDrmHelper();
            this.e = new DefaultLoadErrorHandlingPolicy();
            this.f = 1048576;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public Factory setDrmHttpDataSourceFactory(@Nullable HttpDataSource.Factory factory) {
            this.b.setDrmHttpDataSourceFactory(factory);
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public Factory setDrmSessionManager(@Nullable DrmSessionManager drmSessionManager) {
            this.d = drmSessionManager;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public Factory setDrmUserAgent(@Nullable String str) {
            this.b.setDrmUserAgent(str);
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public Factory setLoadErrorHandlingPolicy(@Nullable LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            if (loadErrorHandlingPolicy == null) {
                loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
            }
            this.e = loadErrorHandlingPolicy;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        @Deprecated
        public ProgressiveMediaSource createMediaSource(Uri uri) {
            return createMediaSource(new MediaItem.Builder().setUri(uri).build());
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public ProgressiveMediaSource createMediaSource(MediaItem mediaItem) {
            Assertions.checkNotNull(mediaItem.playbackProperties);
            MediaItem.PlaybackProperties playbackProperties = mediaItem.playbackProperties;
            boolean z = true;
            boolean z2 = playbackProperties.tag == null && this.h != null;
            if (playbackProperties.customCacheKey != null || this.g == null) {
                z = false;
            }
            if (z2 && z) {
                mediaItem = mediaItem.buildUpon().setTag(this.h).setCustomCacheKey(this.g).build();
            } else if (z2) {
                mediaItem = mediaItem.buildUpon().setTag(this.h).build();
            } else if (z) {
                mediaItem = mediaItem.buildUpon().setCustomCacheKey(this.g).build();
            }
            DataSource.Factory factory = this.a;
            ExtractorsFactory extractorsFactory = this.c;
            DrmSessionManager drmSessionManager = this.d;
            if (drmSessionManager == null) {
                drmSessionManager = this.b.create(mediaItem);
            }
            return new ProgressiveMediaSource(mediaItem, factory, extractorsFactory, drmSessionManager, this.e, this.f);
        }
    }

    public class a extends ForwardingTimeline {
        public a(ProgressiveMediaSource progressiveMediaSource, Timeline timeline) {
            super(timeline);
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public Timeline.Window getWindow(int i, Timeline.Window window, long j) {
            super.getWindow(i, window, j);
            window.isPlaceholder = true;
            return window;
        }
    }

    public ProgressiveMediaSource(MediaItem mediaItem, DataSource.Factory factory, ExtractorsFactory extractorsFactory, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, int i2) {
        this.h = (MediaItem.PlaybackProperties) Assertions.checkNotNull(mediaItem.playbackProperties);
        this.g = mediaItem;
        this.i = factory;
        this.j = extractorsFactory;
        this.k = drmSessionManager;
        this.l = loadErrorHandlingPolicy;
        this.m = i2;
    }

    public final void a() {
        Timeline singlePeriodTimeline = new SinglePeriodTimeline(this.o, this.p, false, this.q, (Object) null, this.g);
        if (this.n) {
            singlePeriodTimeline = new a(this, singlePeriodTimeline);
        }
        refreshSourceInfo(singlePeriodTimeline);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        DataSource createDataSource = this.i.createDataSource();
        TransferListener transferListener = this.r;
        if (transferListener != null) {
            createDataSource.addTransferListener(transferListener);
        }
        return new r(this.h.uri, createDataSource, this.j, this.k, createDrmEventDispatcher(mediaPeriodId), this.l, createEventDispatcher(mediaPeriodId), this, allocator, this.h.customCacheKey, this.m);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaItem getMediaItem() {
        return this.g;
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource, com.google.android.exoplayer2.source.MediaSource
    @Nullable
    @Deprecated
    public Object getTag() {
        return this.h.tag;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() {
    }

    @Override // a2.j.b.b.z0.r.b
    public void onSourceInfoRefreshed(long j2, boolean z, boolean z2) {
        if (j2 == C.TIME_UNSET) {
            j2 = this.o;
        }
        if (this.n || this.o != j2 || this.p != z || this.q != z2) {
            this.o = j2;
            this.p = z;
            this.q = z2;
            this.n = false;
            a();
        }
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        this.r = transferListener;
        this.k.prepare();
        a();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        r rVar = (r) mediaPeriod;
        if (rVar.v) {
            for (SampleQueue sampleQueue : rVar.s) {
                sampleQueue.preRelease();
            }
        }
        rVar.k.release(rVar);
        rVar.p.removeCallbacksAndMessages(null);
        rVar.q = null;
        rVar.L = true;
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        this.k.release();
    }
}
