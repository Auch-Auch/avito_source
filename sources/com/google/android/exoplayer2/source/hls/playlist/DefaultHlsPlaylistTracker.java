package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.hls.HlsDataSourceFactory;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
public final class DefaultHlsPlaylistTracker implements HlsPlaylistTracker, Loader.Callback<ParsingLoadable<HlsPlaylist>> {
    public static final double DEFAULT_PLAYLIST_STUCK_TARGET_DURATION_COEFFICIENT = 3.5d;
    public static final HlsPlaylistTracker.Factory FACTORY = a2.j.b.b.z0.w.h.a.a;
    public final HlsDataSourceFactory a;
    public final HlsPlaylistParserFactory b;
    public final LoadErrorHandlingPolicy c;
    public final HashMap<Uri, a> d;
    public final List<HlsPlaylistTracker.PlaylistEventListener> e;
    public final double f;
    @Nullable
    public ParsingLoadable.Parser<HlsPlaylist> g;
    @Nullable
    public MediaSourceEventListener.EventDispatcher h;
    @Nullable
    public Loader i;
    @Nullable
    public Handler j;
    @Nullable
    public HlsPlaylistTracker.PrimaryPlaylistListener k;
    @Nullable
    public HlsMasterPlaylist l;
    @Nullable
    public Uri m;
    @Nullable
    public HlsMediaPlaylist n;
    public boolean o;
    public long p;

    public final class a implements Loader.Callback<ParsingLoadable<HlsPlaylist>>, Runnable {
        public final Uri a;
        public final Loader b = new Loader("DefaultHlsPlaylistTracker:MediaPlaylist");
        public final ParsingLoadable<HlsPlaylist> c;
        @Nullable
        public HlsMediaPlaylist d;
        public long e;
        public long f;
        public long g;
        public long h;
        public boolean i;
        public IOException j;

        public a(Uri uri) {
            this.a = uri;
            this.c = new ParsingLoadable<>(DefaultHlsPlaylistTracker.this.a.createDataSource(4), uri, 4, DefaultHlsPlaylistTracker.this.g);
        }

        public final boolean a(long j2) {
            boolean z;
            this.h = SystemClock.elapsedRealtime() + j2;
            if (!this.a.equals(DefaultHlsPlaylistTracker.this.m)) {
                return false;
            }
            DefaultHlsPlaylistTracker defaultHlsPlaylistTracker = DefaultHlsPlaylistTracker.this;
            List<HlsMasterPlaylist.Variant> list = defaultHlsPlaylistTracker.l.variants;
            int size = list.size();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    z = false;
                    break;
                }
                a aVar = defaultHlsPlaylistTracker.d.get(list.get(i2).url);
                if (elapsedRealtime > aVar.h) {
                    defaultHlsPlaylistTracker.m = aVar.a;
                    aVar.b();
                    z = true;
                    break;
                }
                i2++;
            }
            if (!z) {
                return true;
            }
            return false;
        }

        public void b() {
            this.h = 0;
            if (!this.i && !this.b.isLoading() && !this.b.hasFatalError()) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j2 = this.g;
                if (elapsedRealtime < j2) {
                    this.i = true;
                    DefaultHlsPlaylistTracker.this.j.postDelayed(this, j2 - elapsedRealtime);
                    return;
                }
                c();
            }
        }

        public final void c() {
            Loader loader = this.b;
            ParsingLoadable<HlsPlaylist> parsingLoadable = this.c;
            long startLoading = loader.startLoading(parsingLoadable, this, DefaultHlsPlaylistTracker.this.c.getMinimumLoadableRetryCount(parsingLoadable.type));
            MediaSourceEventListener.EventDispatcher eventDispatcher = DefaultHlsPlaylistTracker.this.h;
            ParsingLoadable<HlsPlaylist> parsingLoadable2 = this.c;
            eventDispatcher.loadStarted(parsingLoadable2.dataSpec, parsingLoadable2.type, startLoading);
        }

        /* JADX WARN: Incorrect args count in method signature: (Lcom/google/android/exoplayer2/upstream/ParsingLoadable<Lcom/google/android/exoplayer2/source/hls/playlist/HlsPlaylist;>;JJZ)V */
        public void d(ParsingLoadable parsingLoadable, long j2, long j3) {
            DefaultHlsPlaylistTracker.this.h.loadCanceled(parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), 4, j2, j3, parsingLoadable.bytesLoaded());
        }

        /* renamed from: e */
        public void onLoadCompleted(ParsingLoadable<HlsPlaylist> parsingLoadable, long j2, long j3) {
            HlsPlaylist result = parsingLoadable.getResult();
            if (result instanceof HlsMediaPlaylist) {
                g((HlsMediaPlaylist) result, j3);
                DefaultHlsPlaylistTracker.this.h.loadCompleted(parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), 4, j2, j3, parsingLoadable.bytesLoaded());
                return;
            }
            this.j = new ParserException("Loaded playlist has unexpected type.");
        }

        /* renamed from: f */
        public Loader.LoadErrorAction onLoadError(ParsingLoadable<HlsPlaylist> parsingLoadable, long j2, long j3, IOException iOException, int i2) {
            Loader.LoadErrorAction loadErrorAction;
            long blacklistDurationMsFor = DefaultHlsPlaylistTracker.this.c.getBlacklistDurationMsFor(parsingLoadable.type, j3, iOException, i2);
            boolean z = blacklistDurationMsFor != C.TIME_UNSET;
            boolean z2 = DefaultHlsPlaylistTracker.a(DefaultHlsPlaylistTracker.this, this.a, blacklistDurationMsFor) || !z;
            if (z) {
                z2 |= a(blacklistDurationMsFor);
            }
            if (z2) {
                long retryDelayMsFor = DefaultHlsPlaylistTracker.this.c.getRetryDelayMsFor(parsingLoadable.type, j3, iOException, i2);
                if (retryDelayMsFor != C.TIME_UNSET) {
                    loadErrorAction = Loader.createRetryAction(false, retryDelayMsFor);
                } else {
                    loadErrorAction = Loader.DONT_RETRY_FATAL;
                }
            } else {
                loadErrorAction = Loader.DONT_RETRY;
            }
            DefaultHlsPlaylistTracker.this.h.loadError(parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), 4, j2, j3, parsingLoadable.bytesLoaded(), iOException, !loadErrorAction.isRetry());
            return loadErrorAction;
        }

        public final void g(HlsMediaPlaylist hlsMediaPlaylist, long j2) {
            HlsMediaPlaylist hlsMediaPlaylist2;
            long j3;
            long j4;
            int i2;
            HlsMediaPlaylist.Segment b2;
            HlsMediaPlaylist hlsMediaPlaylist3 = this.d;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.e = elapsedRealtime;
            DefaultHlsPlaylistTracker defaultHlsPlaylistTracker = DefaultHlsPlaylistTracker.this;
            HlsPlaylistTracker.Factory factory = DefaultHlsPlaylistTracker.FACTORY;
            Objects.requireNonNull(defaultHlsPlaylistTracker);
            if (!hlsMediaPlaylist.isNewerThan(hlsMediaPlaylist3)) {
                hlsMediaPlaylist2 = hlsMediaPlaylist.hasEndTag ? hlsMediaPlaylist3.copyWithEndTag() : hlsMediaPlaylist3;
            } else {
                if (hlsMediaPlaylist.hasProgramDateTime) {
                    j4 = hlsMediaPlaylist.startTimeUs;
                } else {
                    HlsMediaPlaylist hlsMediaPlaylist4 = defaultHlsPlaylistTracker.n;
                    j4 = hlsMediaPlaylist4 != null ? hlsMediaPlaylist4.startTimeUs : 0;
                    if (hlsMediaPlaylist3 != null) {
                        int size = hlsMediaPlaylist3.segments.size();
                        HlsMediaPlaylist.Segment b3 = DefaultHlsPlaylistTracker.b(hlsMediaPlaylist3, hlsMediaPlaylist);
                        if (b3 != null) {
                            j4 = hlsMediaPlaylist3.startTimeUs + b3.relativeStartTimeUs;
                        } else if (((long) size) == hlsMediaPlaylist.mediaSequence - hlsMediaPlaylist3.mediaSequence) {
                            j4 = hlsMediaPlaylist3.getEndTimeUs();
                        }
                    }
                }
                if (hlsMediaPlaylist.hasDiscontinuitySequence) {
                    i2 = hlsMediaPlaylist.discontinuitySequence;
                } else {
                    HlsMediaPlaylist hlsMediaPlaylist5 = defaultHlsPlaylistTracker.n;
                    i2 = hlsMediaPlaylist5 != null ? hlsMediaPlaylist5.discontinuitySequence : 0;
                    if (!(hlsMediaPlaylist3 == null || (b2 = DefaultHlsPlaylistTracker.b(hlsMediaPlaylist3, hlsMediaPlaylist)) == null)) {
                        i2 = (hlsMediaPlaylist3.discontinuitySequence + b2.relativeDiscontinuitySequence) - hlsMediaPlaylist.segments.get(0).relativeDiscontinuitySequence;
                    }
                }
                hlsMediaPlaylist2 = hlsMediaPlaylist.copyWith(j4, i2);
            }
            this.d = hlsMediaPlaylist2;
            if (hlsMediaPlaylist2 != hlsMediaPlaylist3) {
                this.j = null;
                this.f = elapsedRealtime;
                DefaultHlsPlaylistTracker defaultHlsPlaylistTracker2 = DefaultHlsPlaylistTracker.this;
                if (this.a.equals(defaultHlsPlaylistTracker2.m)) {
                    if (defaultHlsPlaylistTracker2.n == null) {
                        defaultHlsPlaylistTracker2.o = !hlsMediaPlaylist2.hasEndTag;
                        defaultHlsPlaylistTracker2.p = hlsMediaPlaylist2.startTimeUs;
                    }
                    defaultHlsPlaylistTracker2.n = hlsMediaPlaylist2;
                    defaultHlsPlaylistTracker2.k.onPrimaryPlaylistRefreshed(hlsMediaPlaylist2);
                }
                int size2 = defaultHlsPlaylistTracker2.e.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    defaultHlsPlaylistTracker2.e.get(i3).onPlaylistChanged();
                }
            } else if (!hlsMediaPlaylist2.hasEndTag) {
                HlsMediaPlaylist hlsMediaPlaylist6 = this.d;
                if (hlsMediaPlaylist.mediaSequence + ((long) hlsMediaPlaylist.segments.size()) < hlsMediaPlaylist6.mediaSequence) {
                    this.j = new HlsPlaylistTracker.PlaylistResetException(this.a);
                    DefaultHlsPlaylistTracker.a(DefaultHlsPlaylistTracker.this, this.a, C.TIME_UNSET);
                } else if (((double) (elapsedRealtime - this.f)) > ((double) C.usToMs(hlsMediaPlaylist6.targetDurationUs)) * DefaultHlsPlaylistTracker.this.f) {
                    HlsPlaylistTracker.PlaylistStuckException playlistStuckException = new HlsPlaylistTracker.PlaylistStuckException(this.a);
                    this.j = playlistStuckException;
                    long blacklistDurationMsFor = DefaultHlsPlaylistTracker.this.c.getBlacklistDurationMsFor(4, j2, playlistStuckException, 1);
                    DefaultHlsPlaylistTracker.a(DefaultHlsPlaylistTracker.this, this.a, blacklistDurationMsFor);
                    if (blacklistDurationMsFor != C.TIME_UNSET) {
                        a(blacklistDurationMsFor);
                    }
                }
            }
            HlsMediaPlaylist hlsMediaPlaylist7 = this.d;
            if (hlsMediaPlaylist7 != hlsMediaPlaylist3) {
                j3 = hlsMediaPlaylist7.targetDurationUs;
            } else {
                j3 = hlsMediaPlaylist7.targetDurationUs / 2;
            }
            this.g = C.usToMs(j3) + elapsedRealtime;
            if (this.a.equals(DefaultHlsPlaylistTracker.this.m) && !this.d.hasEndTag) {
                b();
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.exoplayer2.upstream.Loader$Loadable, long, long, boolean] */
        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public /* bridge */ /* synthetic */ void onLoadCanceled(ParsingLoadable<HlsPlaylist> parsingLoadable, long j2, long j3, boolean z) {
            d(parsingLoadable, j2, j3);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.i = false;
            c();
        }
    }

    public DefaultHlsPlaylistTracker(HlsDataSourceFactory hlsDataSourceFactory, LoadErrorHandlingPolicy loadErrorHandlingPolicy, HlsPlaylistParserFactory hlsPlaylistParserFactory) {
        this(hlsDataSourceFactory, loadErrorHandlingPolicy, hlsPlaylistParserFactory, 3.5d);
    }

    public static boolean a(DefaultHlsPlaylistTracker defaultHlsPlaylistTracker, Uri uri, long j2) {
        int size = defaultHlsPlaylistTracker.e.size();
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            z |= !defaultHlsPlaylistTracker.e.get(i2).onPlaylistError(uri, j2);
        }
        return z;
    }

    public static HlsMediaPlaylist.Segment b(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        int i2 = (int) (hlsMediaPlaylist2.mediaSequence - hlsMediaPlaylist.mediaSequence);
        List<HlsMediaPlaylist.Segment> list = hlsMediaPlaylist.segments;
        if (i2 < list.size()) {
            return list.get(i2);
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void addListener(HlsPlaylistTracker.PlaylistEventListener playlistEventListener) {
        this.e.add(playlistEventListener);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public long getInitialStartTimeUs() {
        return this.p;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    @Nullable
    public HlsMasterPlaylist getMasterPlaylist() {
        return this.l;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    @Nullable
    public HlsMediaPlaylist getPlaylistSnapshot(Uri uri, boolean z) {
        HlsMediaPlaylist hlsMediaPlaylist;
        HlsMediaPlaylist hlsMediaPlaylist2 = this.d.get(uri).d;
        if (hlsMediaPlaylist2 != null && z && !uri.equals(this.m)) {
            List<HlsMasterPlaylist.Variant> list = this.l.variants;
            boolean z2 = false;
            int i2 = 0;
            while (true) {
                if (i2 >= list.size()) {
                    break;
                } else if (uri.equals(list.get(i2).url)) {
                    z2 = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z2 && ((hlsMediaPlaylist = this.n) == null || !hlsMediaPlaylist.hasEndTag)) {
                this.m = uri;
                this.d.get(uri).b();
            }
        }
        return hlsMediaPlaylist2;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean isLive() {
        return this.o;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean isSnapshotValid(Uri uri) {
        int i2;
        a aVar = this.d.get(uri);
        if (aVar.d == null) {
            return false;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long max = Math.max(30000L, C.usToMs(aVar.d.durationUs));
        HlsMediaPlaylist hlsMediaPlaylist = aVar.d;
        if (hlsMediaPlaylist.hasEndTag || (i2 = hlsMediaPlaylist.playlistType) == 2 || i2 == 1 || aVar.e + max > elapsedRealtime) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void maybeThrowPlaylistRefreshError(Uri uri) throws IOException {
        a aVar = this.d.get(uri);
        aVar.b.maybeThrowError();
        IOException iOException = aVar.j;
        if (iOException != null) {
            throw iOException;
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void maybeThrowPrimaryPlaylistRefreshError() throws IOException {
        Loader loader = this.i;
        if (loader != null) {
            loader.maybeThrowError();
        }
        Uri uri = this.m;
        if (uri != null) {
            maybeThrowPlaylistRefreshError(uri);
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void refreshPlaylist(Uri uri) {
        this.d.get(uri).b();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void removeListener(HlsPlaylistTracker.PlaylistEventListener playlistEventListener) {
        this.e.remove(playlistEventListener);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void start(Uri uri, MediaSourceEventListener.EventDispatcher eventDispatcher, HlsPlaylistTracker.PrimaryPlaylistListener primaryPlaylistListener) {
        this.j = new Handler();
        this.h = eventDispatcher;
        this.k = primaryPlaylistListener;
        ParsingLoadable parsingLoadable = new ParsingLoadable(this.a.createDataSource(4), uri, 4, this.b.createPlaylistParser());
        Assertions.checkState(this.i == null);
        Loader loader = new Loader("DefaultHlsPlaylistTracker:MasterPlaylist");
        this.i = loader;
        eventDispatcher.loadStarted(parsingLoadable.dataSpec, parsingLoadable.type, loader.startLoading(parsingLoadable, this, this.c.getMinimumLoadableRetryCount(parsingLoadable.type)));
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void stop() {
        this.m = null;
        this.n = null;
        this.l = null;
        this.p = C.TIME_UNSET;
        this.i.release();
        this.i = null;
        for (a aVar : this.d.values()) {
            aVar.b.release();
        }
        this.j.removeCallbacksAndMessages(null);
        this.j = null;
        this.d.clear();
    }

    public DefaultHlsPlaylistTracker(HlsDataSourceFactory hlsDataSourceFactory, LoadErrorHandlingPolicy loadErrorHandlingPolicy, HlsPlaylistParserFactory hlsPlaylistParserFactory, double d2) {
        this.a = hlsDataSourceFactory;
        this.b = hlsPlaylistParserFactory;
        this.c = loadErrorHandlingPolicy;
        this.f = d2;
        this.e = new ArrayList();
        this.d = new HashMap<>();
        this.p = C.TIME_UNSET;
    }

    public void onLoadCanceled(ParsingLoadable<HlsPlaylist> parsingLoadable, long j2, long j3, boolean z) {
        this.h.loadCanceled(parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), 4, j2, j3, parsingLoadable.bytesLoaded());
    }

    public void onLoadCompleted(ParsingLoadable<HlsPlaylist> parsingLoadable, long j2, long j3) {
        HlsMasterPlaylist hlsMasterPlaylist;
        HlsPlaylist result = parsingLoadable.getResult();
        boolean z = result instanceof HlsMediaPlaylist;
        if (z) {
            hlsMasterPlaylist = HlsMasterPlaylist.createSingleVariantMasterPlaylist(result.baseUri);
        } else {
            hlsMasterPlaylist = (HlsMasterPlaylist) result;
        }
        this.l = hlsMasterPlaylist;
        this.g = this.b.createPlaylistParser(hlsMasterPlaylist);
        this.m = hlsMasterPlaylist.variants.get(0).url;
        List<Uri> list = hlsMasterPlaylist.mediaPlaylistUrls;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Uri uri = list.get(i2);
            this.d.put(uri, new a(uri));
        }
        a aVar = this.d.get(this.m);
        if (z) {
            aVar.g((HlsMediaPlaylist) result, j3);
        } else {
            aVar.b();
        }
        this.h.loadCompleted(parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), 4, j2, j3, parsingLoadable.bytesLoaded());
    }

    public Loader.LoadErrorAction onLoadError(ParsingLoadable<HlsPlaylist> parsingLoadable, long j2, long j3, IOException iOException, int i2) {
        long retryDelayMsFor = this.c.getRetryDelayMsFor(parsingLoadable.type, j3, iOException, i2);
        boolean z = retryDelayMsFor == C.TIME_UNSET;
        this.h.loadError(parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), 4, j2, j3, parsingLoadable.bytesLoaded(), iOException, z);
        if (z) {
            return Loader.DONT_RETRY_FATAL;
        }
        return Loader.createRetryAction(false, retryDelayMsFor);
    }
}
