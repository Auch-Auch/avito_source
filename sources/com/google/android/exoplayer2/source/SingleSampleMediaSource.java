package com.google.android.exoplayer2.source;

import a2.j.b.b.z0.o;
import a2.j.b.b.z0.t;
import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Collections;
public final class SingleSampleMediaSource extends BaseMediaSource {
    public final DataSpec g;
    public final DataSource.Factory h;
    public final Format i;
    public final long j;
    public final LoadErrorHandlingPolicy k;
    public final boolean l;
    public final Timeline m;
    public final MediaItem n;
    @Nullable
    public TransferListener o;

    @Deprecated
    public interface EventListener {
        void onLoadError(int i, IOException iOException);
    }

    @Deprecated
    public static final class a implements MediaSourceEventListener {
        public final EventListener a;
        public final int b;

        public a(EventListener eventListener, int i) {
            this.a = (EventListener) Assertions.checkNotNull(eventListener);
            this.b = i;
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
            this.a.onLoadError(this.b, iOException);
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
    public SingleSampleMediaSource(Uri uri, DataSource.Factory factory, Format format, long j2) {
        this(uri, factory, format, j2, 3);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        return new t(this.g, this.h, this.o, this.i, this.j, this.k, createEventDispatcher(mediaPeriodId), this.l);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaItem getMediaItem() {
        return this.n;
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource, com.google.android.exoplayer2.source.MediaSource
    @Nullable
    @Deprecated
    public Object getTag() {
        return ((MediaItem.PlaybackProperties) Util.castNonNull(this.n.playbackProperties)).tag;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() {
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        this.o = transferListener;
        refreshSourceInfo(this.m);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((t) mediaPeriod).i.release();
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
    }

    public static final class Factory {
        public final DataSource.Factory a;
        public LoadErrorHandlingPolicy b = new DefaultLoadErrorHandlingPolicy();
        public boolean c;
        @Nullable
        public Object d;
        @Nullable
        public String e;

        public Factory(DataSource.Factory factory) {
            this.a = (DataSource.Factory) Assertions.checkNotNull(factory);
        }

        public SingleSampleMediaSource createMediaSource(MediaItem.Subtitle subtitle, long j) {
            return new SingleSampleMediaSource(this.e, subtitle, this.a, j, this.b, this.c, this.d);
        }

        public Factory setLoadErrorHandlingPolicy(@Nullable LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            if (loadErrorHandlingPolicy == null) {
                loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
            }
            this.b = loadErrorHandlingPolicy;
            return this;
        }

        @Deprecated
        public Factory setMinLoadableRetryCount(int i) {
            return setLoadErrorHandlingPolicy(new DefaultLoadErrorHandlingPolicy(i));
        }

        public Factory setTag(@Nullable Object obj) {
            this.d = obj;
            return this;
        }

        public Factory setTrackId(@Nullable String str) {
            this.e = str;
            return this;
        }

        public Factory setTreatLoadErrorsAsEndOfStream(boolean z) {
            this.c = z;
            return this;
        }

        @Deprecated
        public SingleSampleMediaSource createMediaSource(Uri uri, Format format, long j) {
            String str = format.id;
            if (str == null) {
                str = this.e;
            }
            return new SingleSampleMediaSource(str, new MediaItem.Subtitle(uri, (String) Assertions.checkNotNull(format.sampleMimeType), format.language, format.selectionFlags), this.a, j, this.b, this.c, this.d);
        }
    }

    @Deprecated
    public SingleSampleMediaSource(Uri uri, DataSource.Factory factory, Format format, long j2, int i2) {
        this(uri, factory, format, j2, i2, null, null, -1, false);
    }

    @Deprecated
    public SingleSampleMediaSource(Uri uri, DataSource.Factory factory, Format format, long j2, int i2, @Nullable Handler handler, @Nullable EventListener eventListener, int i3, boolean z) {
        this(null, new MediaItem.Subtitle(uri, (String) Assertions.checkNotNull(format.sampleMimeType), format.language, format.selectionFlags), factory, j2, new DefaultLoadErrorHandlingPolicy(i2), z, null);
        if (handler != null && eventListener != null) {
            addEventListener(handler, new a(eventListener, i3));
        }
    }

    public SingleSampleMediaSource(@Nullable String str, MediaItem.Subtitle subtitle, DataSource.Factory factory, long j2, LoadErrorHandlingPolicy loadErrorHandlingPolicy, boolean z, @Nullable Object obj) {
        this.h = factory;
        this.j = j2;
        this.k = loadErrorHandlingPolicy;
        this.l = z;
        MediaItem build = new MediaItem.Builder().setUri(Uri.EMPTY).setMediaId(subtitle.uri.toString()).setSubtitles(Collections.singletonList(subtitle)).setTag(obj).build();
        this.n = build;
        this.i = new Format.Builder().setId(str).setSampleMimeType(subtitle.mimeType).setLanguage(subtitle.language).setSelectionFlags(subtitle.selectionFlags).setRoleFlags(subtitle.roleFlags).setLabel(subtitle.label).build();
        this.g = new DataSpec.Builder().setUri(subtitle.uri).setFlags(1).build();
        this.m = new SinglePeriodTimeline(j2, true, false, false, (Object) null, build);
    }
}
