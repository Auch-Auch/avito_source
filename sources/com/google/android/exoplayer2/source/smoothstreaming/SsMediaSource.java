package com.google.android.exoplayer2.source.smoothstreaming;

import a2.j.b.b.z0.x.b;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.offline.FilteringManifestParser;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.BaseMediaSource;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.SinglePeriodTimeline;
import com.google.android.exoplayer2.source.chunk.ChunkSampleStream;
import com.google.android.exoplayer2.source.smoothstreaming.DefaultSsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsUtil;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public final class SsMediaSource extends BaseMediaSource implements Loader.Callback<ParsingLoadable<SsManifest>> {
    public static final long DEFAULT_LIVE_PRESENTATION_DELAY_MS = 30000;
    public static final /* synthetic */ int z = 0;
    public final boolean g;
    public final Uri h;
    public final DataSource.Factory i;
    public final SsChunkSource.Factory j;
    public final CompositeSequenceableLoaderFactory k;
    public final DrmSessionManager<?> l;
    public final LoadErrorHandlingPolicy m;
    public final long n;
    public final MediaSourceEventListener.EventDispatcher o;
    public final ParsingLoadable.Parser<? extends SsManifest> p;
    public final ArrayList<b> q;
    @Nullable
    public final Object r;
    public DataSource s;
    public Loader t;
    public LoaderErrorThrower u;
    @Nullable
    public TransferListener v;
    public long w;
    public SsManifest x;
    public Handler y;

    public static final class Factory implements MediaSourceFactory {
        public final SsChunkSource.Factory a;
        @Nullable
        public final DataSource.Factory b;
        @Nullable
        public ParsingLoadable.Parser<? extends SsManifest> c;
        @Nullable
        public List<StreamKey> d;
        public CompositeSequenceableLoaderFactory e;
        public DrmSessionManager<?> f;
        public LoadErrorHandlingPolicy g;
        public long h;
        public boolean i;
        @Nullable
        public Object j;

        public Factory(DataSource.Factory factory) {
            this(new DefaultSsChunkSource.Factory(factory), factory);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public int[] getSupportedTypes() {
            return new int[]{1};
        }

        public Factory setCompositeSequenceableLoaderFactory(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory) {
            Assertions.checkState(!this.i);
            this.e = (CompositeSequenceableLoaderFactory) Assertions.checkNotNull(compositeSequenceableLoaderFactory);
            return this;
        }

        public Factory setLivePresentationDelayMs(long j2) {
            Assertions.checkState(!this.i);
            this.h = j2;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public Factory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            Assertions.checkState(!this.i);
            this.g = loadErrorHandlingPolicy;
            return this;
        }

        public Factory setManifestParser(ParsingLoadable.Parser<? extends SsManifest> parser) {
            Assertions.checkState(!this.i);
            this.c = (ParsingLoadable.Parser) Assertions.checkNotNull(parser);
            return this;
        }

        @Deprecated
        public Factory setMinLoadableRetryCount(int i2) {
            return setLoadErrorHandlingPolicy((LoadErrorHandlingPolicy) new DefaultLoadErrorHandlingPolicy(i2));
        }

        public Factory setTag(@Nullable Object obj) {
            Assertions.checkState(!this.i);
            this.j = obj;
            return this;
        }

        public Factory(SsChunkSource.Factory factory, @Nullable DataSource.Factory factory2) {
            this.a = (SsChunkSource.Factory) Assertions.checkNotNull(factory);
            this.b = factory2;
            this.f = DrmSessionManager.DUMMY;
            this.g = new DefaultLoadErrorHandlingPolicy();
            this.h = 30000;
            this.e = new DefaultCompositeSequenceableLoaderFactory();
        }

        public SsMediaSource createMediaSource(SsManifest ssManifest) {
            Assertions.checkArgument(!ssManifest.isLive);
            this.i = true;
            List<StreamKey> list = this.d;
            if (list != null && !list.isEmpty()) {
                ssManifest = ssManifest.copy(this.d);
            }
            return new SsMediaSource(ssManifest, null, null, null, this.a, this.e, this.f, this.g, this.h, this.j);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public Factory setDrmSessionManager(DrmSessionManager<?> drmSessionManager) {
            Assertions.checkState(!this.i);
            if (drmSessionManager == null) {
                drmSessionManager = DrmSessionManager.DUMMY;
            }
            this.f = drmSessionManager;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public Factory setStreamKeys(List<StreamKey> list) {
            Assertions.checkState(!this.i);
            this.d = list;
            return this;
        }

        @Deprecated
        public SsMediaSource createMediaSource(SsManifest ssManifest, @Nullable Handler handler, @Nullable MediaSourceEventListener mediaSourceEventListener) {
            SsMediaSource createMediaSource = createMediaSource(ssManifest);
            if (!(handler == null || mediaSourceEventListener == null)) {
                createMediaSource.addEventListener(handler, mediaSourceEventListener);
            }
            return createMediaSource;
        }

        @Deprecated
        public SsMediaSource createMediaSource(Uri uri, @Nullable Handler handler, @Nullable MediaSourceEventListener mediaSourceEventListener) {
            SsMediaSource createMediaSource = createMediaSource(uri);
            if (!(handler == null || mediaSourceEventListener == null)) {
                createMediaSource.addEventListener(handler, mediaSourceEventListener);
            }
            return createMediaSource;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public SsMediaSource createMediaSource(Uri uri) {
            this.i = true;
            if (this.c == null) {
                this.c = new SsManifestParser();
            }
            List<StreamKey> list = this.d;
            if (list != null) {
                this.c = new FilteringManifestParser(this.c, list);
            }
            return new SsMediaSource(null, (Uri) Assertions.checkNotNull(uri), this.b, this.c, this.a, this.e, this.f, this.g, this.h, this.j);
        }
    }

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.smoothstreaming");
    }

    @Deprecated
    public SsMediaSource(SsManifest ssManifest, SsChunkSource.Factory factory, @Nullable Handler handler, @Nullable MediaSourceEventListener mediaSourceEventListener) {
        this(ssManifest, factory, 3, handler, mediaSourceEventListener);
    }

    public final void a() {
        SinglePeriodTimeline singlePeriodTimeline;
        for (int i2 = 0; i2 < this.q.size(); i2++) {
            b bVar = this.q.get(i2);
            SsManifest ssManifest = this.x;
            bVar.k = ssManifest;
            for (ChunkSampleStream<SsChunkSource> chunkSampleStream : bVar.l) {
                chunkSampleStream.getChunkSource().updateManifest(ssManifest);
            }
            bVar.j.onContinueLoadingRequested(bVar);
        }
        long j2 = Long.MIN_VALUE;
        SsManifest.StreamElement[] streamElementArr = this.x.streamElements;
        long j3 = Long.MAX_VALUE;
        for (SsManifest.StreamElement streamElement : streamElementArr) {
            if (streamElement.chunkCount > 0) {
                j3 = Math.min(j3, streamElement.getStartTimeUs(0));
                j2 = Math.max(j2, streamElement.getChunkDurationUs(streamElement.chunkCount - 1) + streamElement.getStartTimeUs(streamElement.chunkCount - 1));
            }
        }
        if (j3 == Long.MAX_VALUE) {
            long j4 = this.x.isLive ? -9223372036854775807L : 0;
            SsManifest ssManifest2 = this.x;
            boolean z2 = ssManifest2.isLive;
            singlePeriodTimeline = new SinglePeriodTimeline(j4, 0L, 0L, 0L, true, z2, z2, (Object) ssManifest2, this.r);
        } else {
            SsManifest ssManifest3 = this.x;
            if (ssManifest3.isLive) {
                long j5 = ssManifest3.dvrWindowLengthUs;
                if (j5 != C.TIME_UNSET && j5 > 0) {
                    j3 = Math.max(j3, j2 - j5);
                }
                long j6 = j2 - j3;
                long msToUs = j6 - C.msToUs(this.n);
                if (msToUs < 5000000) {
                    msToUs = Math.min(5000000L, j6 / 2);
                }
                singlePeriodTimeline = new SinglePeriodTimeline((long) C.TIME_UNSET, j6, j3, msToUs, true, true, true, (Object) this.x, this.r);
            } else {
                long j7 = ssManifest3.durationUs;
                long j8 = j7 != C.TIME_UNSET ? j7 : j2 - j3;
                singlePeriodTimeline = new SinglePeriodTimeline(j3 + j8, j8, j3, 0L, true, false, false, (Object) this.x, this.r);
            }
        }
        refreshSourceInfo(singlePeriodTimeline);
    }

    public final void b() {
        if (!this.t.hasFatalError()) {
            ParsingLoadable parsingLoadable = new ParsingLoadable(this.s, this.h, 4, this.p);
            this.o.loadStarted(parsingLoadable.dataSpec, parsingLoadable.type, this.t.startLoading(parsingLoadable, this, this.m.getMinimumLoadableRetryCount(parsingLoadable.type)));
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        b bVar = new b(this.x, this.j, this.v, this.k, this.l, this.m, createEventDispatcher(mediaPeriodId), this.u, allocator);
        this.q.add(bVar);
        return bVar;
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource, com.google.android.exoplayer2.source.MediaSource
    @Nullable
    public Object getTag() {
        return this.r;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        this.u.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        this.v = transferListener;
        this.l.prepare();
        if (this.g) {
            this.u = new LoaderErrorThrower.Dummy();
            a();
            return;
        }
        this.s = this.i.createDataSource();
        Loader loader = new Loader("Loader:Manifest");
        this.t = loader;
        this.u = loader;
        this.y = new Handler();
        b();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((b) mediaPeriod).c();
        this.q.remove(mediaPeriod);
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        this.x = this.g ? this.x : null;
        this.s = null;
        this.w = 0;
        Loader loader = this.t;
        if (loader != null) {
            loader.release();
            this.t = null;
        }
        Handler handler = this.y;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.y = null;
        }
        this.l.release();
    }

    @Deprecated
    public SsMediaSource(SsManifest ssManifest, SsChunkSource.Factory factory, int i2, @Nullable Handler handler, @Nullable MediaSourceEventListener mediaSourceEventListener) {
        this(ssManifest, null, null, null, factory, new DefaultCompositeSequenceableLoaderFactory(), DrmSessionManager.DUMMY, new DefaultLoadErrorHandlingPolicy(i2), 30000, null);
        if (handler != null && mediaSourceEventListener != null) {
            addEventListener(handler, mediaSourceEventListener);
        }
    }

    public void onLoadCanceled(ParsingLoadable<SsManifest> parsingLoadable, long j2, long j3, boolean z2) {
        this.o.loadCanceled(parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), parsingLoadable.type, j2, j3, parsingLoadable.bytesLoaded());
    }

    public void onLoadCompleted(ParsingLoadable<SsManifest> parsingLoadable, long j2, long j3) {
        this.o.loadCompleted(parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), parsingLoadable.type, j2, j3, parsingLoadable.bytesLoaded());
        this.x = parsingLoadable.getResult();
        this.w = j2 - j3;
        a();
        if (this.x.isLive) {
            this.y.postDelayed(new Runnable() { // from class: a2.j.b.b.z0.x.a
                @Override // java.lang.Runnable
                public final void run() {
                    SsMediaSource ssMediaSource = SsMediaSource.this;
                    int i2 = SsMediaSource.z;
                    ssMediaSource.b();
                }
            }, Math.max(0L, (this.w + 5000) - SystemClock.elapsedRealtime()));
        }
    }

    public Loader.LoadErrorAction onLoadError(ParsingLoadable<SsManifest> parsingLoadable, long j2, long j3, IOException iOException, int i2) {
        Loader.LoadErrorAction loadErrorAction;
        long retryDelayMsFor = this.m.getRetryDelayMsFor(4, j3, iOException, i2);
        if (retryDelayMsFor == C.TIME_UNSET) {
            loadErrorAction = Loader.DONT_RETRY_FATAL;
        } else {
            loadErrorAction = Loader.createRetryAction(false, retryDelayMsFor);
        }
        this.o.loadError(parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), parsingLoadable.type, j2, j3, parsingLoadable.bytesLoaded(), iOException, !loadErrorAction.isRetry());
        return loadErrorAction;
    }

    @Deprecated
    public SsMediaSource(Uri uri, DataSource.Factory factory, SsChunkSource.Factory factory2, @Nullable Handler handler, @Nullable MediaSourceEventListener mediaSourceEventListener) {
        this(uri, factory, factory2, 3, 30000, handler, mediaSourceEventListener);
    }

    @Deprecated
    public SsMediaSource(Uri uri, DataSource.Factory factory, SsChunkSource.Factory factory2, int i2, long j2, @Nullable Handler handler, @Nullable MediaSourceEventListener mediaSourceEventListener) {
        this(uri, factory, new SsManifestParser(), factory2, i2, j2, handler, mediaSourceEventListener);
    }

    @Deprecated
    public SsMediaSource(Uri uri, DataSource.Factory factory, ParsingLoadable.Parser<? extends SsManifest> parser, SsChunkSource.Factory factory2, int i2, long j2, @Nullable Handler handler, @Nullable MediaSourceEventListener mediaSourceEventListener) {
        this(null, uri, factory, parser, factory2, new DefaultCompositeSequenceableLoaderFactory(), DrmSessionManager.DUMMY, new DefaultLoadErrorHandlingPolicy(i2), j2, null);
        if (handler != null && mediaSourceEventListener != null) {
            addEventListener(handler, mediaSourceEventListener);
        }
    }

    public SsMediaSource(@Nullable SsManifest ssManifest, @Nullable Uri uri, @Nullable DataSource.Factory factory, @Nullable ParsingLoadable.Parser<? extends SsManifest> parser, SsChunkSource.Factory factory2, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, DrmSessionManager<?> drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, long j2, @Nullable Object obj) {
        Uri uri2;
        boolean z2 = false;
        Assertions.checkState(ssManifest == null || !ssManifest.isLive);
        this.x = ssManifest;
        if (uri == null) {
            uri2 = null;
        } else {
            uri2 = SsUtil.fixManifestUri(uri);
        }
        this.h = uri2;
        this.i = factory;
        this.p = parser;
        this.j = factory2;
        this.k = compositeSequenceableLoaderFactory;
        this.l = drmSessionManager;
        this.m = loadErrorHandlingPolicy;
        this.n = j2;
        this.o = createEventDispatcher(null);
        this.r = obj;
        this.g = ssManifest != null ? true : z2;
        this.q = new ArrayList<>();
    }
}
