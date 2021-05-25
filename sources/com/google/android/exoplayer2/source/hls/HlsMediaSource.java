package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.BaseMediaSource;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.SinglePeriodTimeline;
import com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistParserFactory;
import com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.FilteringHlsPlaylistParserFactory;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
public final class HlsMediaSource extends BaseMediaSource implements HlsPlaylistTracker.PrimaryPlaylistListener {
    public static final int METADATA_TYPE_EMSG = 3;
    public static final int METADATA_TYPE_ID3 = 1;
    public final HlsExtractorFactory g;
    public final Uri h;
    public final HlsDataSourceFactory i;
    public final CompositeSequenceableLoaderFactory j;
    public final DrmSessionManager<?> k;
    public final LoadErrorHandlingPolicy l;
    public final boolean m;
    public final int n;
    public final boolean o;
    public final HlsPlaylistTracker p;
    @Nullable
    public final Object q;
    @Nullable
    public TransferListener r;

    public static final class Factory implements MediaSourceFactory {
        public final HlsDataSourceFactory a;
        public HlsExtractorFactory b;
        public HlsPlaylistParserFactory c;
        @Nullable
        public List<StreamKey> d;
        public HlsPlaylistTracker.Factory e;
        public CompositeSequenceableLoaderFactory f;
        public DrmSessionManager<?> g;
        public LoadErrorHandlingPolicy h;
        public boolean i;
        public int j;
        public boolean k;
        public boolean l;
        @Nullable
        public Object m;

        public Factory(DataSource.Factory factory) {
            this(new DefaultHlsDataSourceFactory(factory));
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public int[] getSupportedTypes() {
            return new int[]{2};
        }

        public Factory setAllowChunklessPreparation(boolean z) {
            Assertions.checkState(!this.l);
            this.i = z;
            return this;
        }

        public Factory setCompositeSequenceableLoaderFactory(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory) {
            Assertions.checkState(!this.l);
            this.f = (CompositeSequenceableLoaderFactory) Assertions.checkNotNull(compositeSequenceableLoaderFactory);
            return this;
        }

        public Factory setExtractorFactory(HlsExtractorFactory hlsExtractorFactory) {
            Assertions.checkState(!this.l);
            this.b = (HlsExtractorFactory) Assertions.checkNotNull(hlsExtractorFactory);
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public Factory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            Assertions.checkState(!this.l);
            this.h = loadErrorHandlingPolicy;
            return this;
        }

        public Factory setMetadataType(int i2) {
            Assertions.checkState(!this.l);
            this.j = i2;
            return this;
        }

        @Deprecated
        public Factory setMinLoadableRetryCount(int i2) {
            Assertions.checkState(!this.l);
            this.h = new DefaultLoadErrorHandlingPolicy(i2);
            return this;
        }

        public Factory setPlaylistParserFactory(HlsPlaylistParserFactory hlsPlaylistParserFactory) {
            Assertions.checkState(!this.l);
            this.c = (HlsPlaylistParserFactory) Assertions.checkNotNull(hlsPlaylistParserFactory);
            return this;
        }

        public Factory setPlaylistTrackerFactory(HlsPlaylistTracker.Factory factory) {
            Assertions.checkState(!this.l);
            this.e = (HlsPlaylistTracker.Factory) Assertions.checkNotNull(factory);
            return this;
        }

        public Factory setTag(@Nullable Object obj) {
            Assertions.checkState(!this.l);
            this.m = obj;
            return this;
        }

        public Factory setUseSessionKeys(boolean z) {
            this.k = z;
            return this;
        }

        public Factory(HlsDataSourceFactory hlsDataSourceFactory) {
            this.a = (HlsDataSourceFactory) Assertions.checkNotNull(hlsDataSourceFactory);
            this.c = new DefaultHlsPlaylistParserFactory();
            this.e = DefaultHlsPlaylistTracker.FACTORY;
            this.b = HlsExtractorFactory.DEFAULT;
            this.g = DrmSessionManager.DUMMY;
            this.h = new DefaultLoadErrorHandlingPolicy();
            this.f = new DefaultCompositeSequenceableLoaderFactory();
            this.j = 1;
        }

        @Deprecated
        public HlsMediaSource createMediaSource(Uri uri, @Nullable Handler handler, @Nullable MediaSourceEventListener mediaSourceEventListener) {
            HlsMediaSource createMediaSource = createMediaSource(uri);
            if (!(handler == null || mediaSourceEventListener == null)) {
                createMediaSource.addEventListener(handler, mediaSourceEventListener);
            }
            return createMediaSource;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public Factory setDrmSessionManager(DrmSessionManager<?> drmSessionManager) {
            Assertions.checkState(!this.l);
            if (drmSessionManager == null) {
                drmSessionManager = DrmSessionManager.DUMMY;
            }
            this.g = drmSessionManager;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public Factory setStreamKeys(List<StreamKey> list) {
            Assertions.checkState(!this.l);
            this.d = list;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public HlsMediaSource createMediaSource(Uri uri) {
            this.l = true;
            List<StreamKey> list = this.d;
            if (list != null) {
                this.c = new FilteringHlsPlaylistParserFactory(this.c, list);
            }
            HlsDataSourceFactory hlsDataSourceFactory = this.a;
            HlsExtractorFactory hlsExtractorFactory = this.b;
            CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory = this.f;
            DrmSessionManager<?> drmSessionManager = this.g;
            LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.h;
            return new HlsMediaSource(uri, hlsDataSourceFactory, hlsExtractorFactory, compositeSequenceableLoaderFactory, drmSessionManager, loadErrorHandlingPolicy, this.e.createTracker(hlsDataSourceFactory, loadErrorHandlingPolicy, this.c), this.i, this.j, this.k, this.m, null);
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface MetadataType {
    }

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.hls");
    }

    public HlsMediaSource(Uri uri, HlsDataSourceFactory hlsDataSourceFactory, HlsExtractorFactory hlsExtractorFactory, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, HlsPlaylistTracker hlsPlaylistTracker, boolean z, int i2, boolean z2, Object obj, a aVar) {
        this.h = uri;
        this.i = hlsDataSourceFactory;
        this.g = hlsExtractorFactory;
        this.j = compositeSequenceableLoaderFactory;
        this.k = drmSessionManager;
        this.l = loadErrorHandlingPolicy;
        this.p = hlsPlaylistTracker;
        this.m = z;
        this.n = i2;
        this.o = z2;
        this.q = obj;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        return new HlsMediaPeriod(this.g, this.p, this.i, this.r, this.k, this.l, createEventDispatcher(mediaPeriodId), allocator, this.j, this.m, this.n, this.o);
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource, com.google.android.exoplayer2.source.MediaSource
    @Nullable
    public Object getTag() {
        return this.q;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        this.p.maybeThrowPrimaryPlaylistRefreshError();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PrimaryPlaylistListener
    public void onPrimaryPlaylistRefreshed(HlsMediaPlaylist hlsMediaPlaylist) {
        SinglePeriodTimeline singlePeriodTimeline;
        long j2;
        long usToMs = hlsMediaPlaylist.hasProgramDateTime ? C.usToMs(hlsMediaPlaylist.startTimeUs) : -9223372036854775807L;
        int i2 = hlsMediaPlaylist.playlistType;
        long j3 = (i2 == 2 || i2 == 1) ? usToMs : -9223372036854775807L;
        long j4 = hlsMediaPlaylist.startOffsetUs;
        HlsManifest hlsManifest = new HlsManifest((HlsMasterPlaylist) Assertions.checkNotNull(this.p.getMasterPlaylist()), hlsMediaPlaylist);
        if (this.p.isLive()) {
            long initialStartTimeUs = hlsMediaPlaylist.startTimeUs - this.p.getInitialStartTimeUs();
            long j5 = hlsMediaPlaylist.hasEndTag ? initialStartTimeUs + hlsMediaPlaylist.durationUs : -9223372036854775807L;
            List<HlsMediaPlaylist.Segment> list = hlsMediaPlaylist.segments;
            if (j4 != C.TIME_UNSET) {
                j2 = j4;
            } else if (!list.isEmpty()) {
                int max = Math.max(0, list.size() - 3);
                long j6 = hlsMediaPlaylist.durationUs - (hlsMediaPlaylist.targetDurationUs * 2);
                while (max > 0 && list.get(max).relativeStartTimeUs > j6) {
                    max--;
                }
                j2 = list.get(max).relativeStartTimeUs;
            } else {
                j2 = 0;
            }
            singlePeriodTimeline = new SinglePeriodTimeline(j3, usToMs, j5, hlsMediaPlaylist.durationUs, initialStartTimeUs, j2, true, !hlsMediaPlaylist.hasEndTag, true, hlsManifest, this.q);
        } else {
            long j7 = j4 == C.TIME_UNSET ? 0 : j4;
            long j8 = hlsMediaPlaylist.durationUs;
            singlePeriodTimeline = new SinglePeriodTimeline(j3, usToMs, j8, j8, 0, j7, true, false, false, hlsManifest, this.q);
        }
        refreshSourceInfo(singlePeriodTimeline);
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        this.r = transferListener;
        this.k.prepare();
        this.p.start(this.h, createEventDispatcher(null), this);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((HlsMediaPeriod) mediaPeriod).release();
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        this.p.stop();
        this.k.release();
    }
}
