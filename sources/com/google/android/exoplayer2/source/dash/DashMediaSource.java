package com.google.android.exoplayer2.source.dash;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.Timeline;
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
import com.google.android.exoplayer2.source.chunk.ChunkSampleStream;
import com.google.android.exoplayer2.source.dash.DashChunkSource;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.dash.DefaultDashChunkSource;
import com.google.android.exoplayer2.source.dash.PlayerEmsgHandler;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.DashManifestParser;
import com.google.android.exoplayer2.source.dash.manifest.EventStream;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public final class DashMediaSource extends BaseMediaSource {
    @Deprecated
    public static final long DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS = 30000;
    public static final long DEFAULT_LIVE_PRESENTATION_DELAY_MS = 30000;
    @Deprecated
    public static final long DEFAULT_LIVE_PRESENTATION_DELAY_PREFER_MANIFEST_MS = -1;
    public static final /* synthetic */ int N = 0;
    @Nullable
    public TransferListener A;
    public IOException B;
    public Handler C;
    public Uri D;
    public Uri E;
    public DashManifest F;
    public boolean G;
    public long H;
    public long I;
    public long J;
    public int K;
    public long L;
    public int M;
    public final boolean g;
    public final DataSource.Factory h;
    public final DashChunkSource.Factory i;
    public final CompositeSequenceableLoaderFactory j;
    public final DrmSessionManager<?> k;
    public final LoadErrorHandlingPolicy l;
    public final long m;
    public final boolean n;
    public final MediaSourceEventListener.EventDispatcher o;
    public final ParsingLoadable.Parser<? extends DashManifest> p;
    public final e q;
    public final Object r;
    public final SparseArray<DashMediaPeriod> s;
    public final Runnable t;
    public final Runnable u;
    public final PlayerEmsgHandler.PlayerEmsgCallback v;
    public final LoaderErrorThrower w;
    @Nullable
    public final Object x;
    public DataSource y;
    public Loader z;

    public static final class Factory implements MediaSourceFactory {
        public final DashChunkSource.Factory a;
        @Nullable
        public final DataSource.Factory b;
        public DrmSessionManager<?> c;
        @Nullable
        public ParsingLoadable.Parser<? extends DashManifest> d;
        @Nullable
        public List<StreamKey> e;
        public CompositeSequenceableLoaderFactory f;
        public LoadErrorHandlingPolicy g;
        public long h;
        public boolean i;
        public boolean j;
        @Nullable
        public Object k;

        public Factory(DataSource.Factory factory) {
            this(new DefaultDashChunkSource.Factory(factory), factory);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public int[] getSupportedTypes() {
            return new int[]{0};
        }

        public Factory setCompositeSequenceableLoaderFactory(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory) {
            Assertions.checkState(!this.j);
            this.f = (CompositeSequenceableLoaderFactory) Assertions.checkNotNull(compositeSequenceableLoaderFactory);
            return this;
        }

        @Deprecated
        public Factory setLivePresentationDelayMs(long j2) {
            if (j2 == -1) {
                return setLivePresentationDelayMs(30000, false);
            }
            return setLivePresentationDelayMs(j2, true);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public Factory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            Assertions.checkState(!this.j);
            this.g = loadErrorHandlingPolicy;
            return this;
        }

        public Factory setManifestParser(ParsingLoadable.Parser<? extends DashManifest> parser) {
            Assertions.checkState(!this.j);
            this.d = (ParsingLoadable.Parser) Assertions.checkNotNull(parser);
            return this;
        }

        @Deprecated
        public Factory setMinLoadableRetryCount(int i2) {
            return setLoadErrorHandlingPolicy((LoadErrorHandlingPolicy) new DefaultLoadErrorHandlingPolicy(i2));
        }

        public Factory setTag(@Nullable Object obj) {
            Assertions.checkState(!this.j);
            this.k = obj;
            return this;
        }

        public Factory(DashChunkSource.Factory factory, @Nullable DataSource.Factory factory2) {
            this.a = (DashChunkSource.Factory) Assertions.checkNotNull(factory);
            this.b = factory2;
            this.c = DrmSessionManager.DUMMY;
            this.g = new DefaultLoadErrorHandlingPolicy();
            this.h = 30000;
            this.f = new DefaultCompositeSequenceableLoaderFactory();
        }

        public DashMediaSource createMediaSource(DashManifest dashManifest) {
            Assertions.checkArgument(!dashManifest.dynamic);
            this.j = true;
            List<StreamKey> list = this.e;
            if (list != null && !list.isEmpty()) {
                dashManifest = dashManifest.copy(this.e);
            }
            return new DashMediaSource(dashManifest, null, null, null, this.a, this.f, this.c, this.g, this.h, this.i, this.k);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public Factory setDrmSessionManager(DrmSessionManager<?> drmSessionManager) {
            Assertions.checkState(!this.j);
            if (drmSessionManager == null) {
                drmSessionManager = DrmSessionManager.DUMMY;
            }
            this.c = drmSessionManager;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public Factory setStreamKeys(List<StreamKey> list) {
            Assertions.checkState(!this.j);
            this.e = list;
            return this;
        }

        public Factory setLivePresentationDelayMs(long j2, boolean z) {
            Assertions.checkState(!this.j);
            this.h = j2;
            this.i = z;
            return this;
        }

        @Deprecated
        public DashMediaSource createMediaSource(DashManifest dashManifest, @Nullable Handler handler, @Nullable MediaSourceEventListener mediaSourceEventListener) {
            DashMediaSource createMediaSource = createMediaSource(dashManifest);
            if (!(handler == null || mediaSourceEventListener == null)) {
                createMediaSource.addEventListener(handler, mediaSourceEventListener);
            }
            return createMediaSource;
        }

        @Deprecated
        public DashMediaSource createMediaSource(Uri uri, @Nullable Handler handler, @Nullable MediaSourceEventListener mediaSourceEventListener) {
            DashMediaSource createMediaSource = createMediaSource(uri);
            if (!(handler == null || mediaSourceEventListener == null)) {
                createMediaSource.addEventListener(handler, mediaSourceEventListener);
            }
            return createMediaSource;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public DashMediaSource createMediaSource(Uri uri) {
            this.j = true;
            if (this.d == null) {
                this.d = new DashManifestParser();
            }
            List<StreamKey> list = this.e;
            if (list != null) {
                this.d = new FilteringManifestParser(this.d, list);
            }
            return new DashMediaSource(null, (Uri) Assertions.checkNotNull(uri), this.b, this.d, this.a, this.f, this.c, this.g, this.h, this.i, this.k);
        }
    }

    public static final class b extends Timeline {
        public final long a;
        public final long b;
        public final int c;
        public final long d;
        public final long e;
        public final long f;
        public final DashManifest g;
        @Nullable
        public final Object h;

        public b(long j, long j2, int i, long j3, long j4, long j5, DashManifest dashManifest, @Nullable Object obj) {
            this.a = j;
            this.b = j2;
            this.c = i;
            this.d = j3;
            this.e = j4;
            this.f = j5;
            this.g = dashManifest;
            this.h = obj;
        }

        public static boolean a(DashManifest dashManifest) {
            return dashManifest.dynamic && dashManifest.minUpdatePeriodMs != C.TIME_UNSET && dashManifest.durationMs == C.TIME_UNSET;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getIndexOfPeriod(Object obj) {
            int intValue;
            if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue() - this.c) >= 0 && intValue < getPeriodCount()) {
                return intValue;
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
            Assertions.checkIndex(i, 0, getPeriodCount());
            Integer num = null;
            String str = z ? this.g.getPeriod(i).id : null;
            if (z) {
                num = Integer.valueOf(this.c + i);
            }
            return period.set(str, num, 0, this.g.getPeriodDurationUs(i), C.msToUs(this.g.getPeriod(i).startMs - this.g.getPeriod(0).startMs) - this.d);
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            return this.g.getPeriodCount();
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Object getUidOfPeriod(int i) {
            Assertions.checkIndex(i, 0, getPeriodCount());
            return Integer.valueOf(this.c + i);
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.Window getWindow(int i, Timeline.Window window, long j) {
            DashSegmentIndex index;
            Assertions.checkIndex(i, 0, 1);
            long j2 = this.f;
            if (a(this.g)) {
                if (j > 0) {
                    j2 += j;
                    if (j2 > this.e) {
                        j2 = C.TIME_UNSET;
                    }
                }
                long j3 = this.d + j2;
                long periodDurationUs = this.g.getPeriodDurationUs(0);
                int i2 = 0;
                while (i2 < this.g.getPeriodCount() - 1 && j3 >= periodDurationUs) {
                    j3 -= periodDurationUs;
                    i2++;
                    periodDurationUs = this.g.getPeriodDurationUs(i2);
                }
                Period period = this.g.getPeriod(i2);
                int adaptationSetIndex = period.getAdaptationSetIndex(2);
                if (!(adaptationSetIndex == -1 || (index = period.adaptationSets.get(adaptationSetIndex).representations.get(0).getIndex()) == null || index.getSegmentCount(periodDurationUs) == 0)) {
                    j2 = (index.getTimeUs(index.getSegmentNum(j3, periodDurationUs)) + j2) - j3;
                }
            }
            Object obj = Timeline.Window.SINGLE_WINDOW_UID;
            Object obj2 = this.h;
            DashManifest dashManifest = this.g;
            return window.set(obj, obj2, dashManifest, this.a, this.b, true, a(dashManifest), this.g.dynamic, j2, this.e, 0, getPeriodCount() - 1, this.d);
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            return 1;
        }
    }

    public final class c implements PlayerEmsgHandler.PlayerEmsgCallback {
        public c(a aVar) {
        }

        @Override // com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerEmsgCallback
        public void onDashManifestPublishTimeExpired(long j) {
            DashMediaSource dashMediaSource = DashMediaSource.this;
            long j2 = dashMediaSource.L;
            if (j2 == C.TIME_UNSET || j2 < j) {
                dashMediaSource.L = j;
            }
        }

        @Override // com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerEmsgCallback
        public void onDashManifestRefreshRequested() {
            DashMediaSource dashMediaSource = DashMediaSource.this;
            dashMediaSource.C.removeCallbacks(dashMediaSource.u);
            dashMediaSource.j();
        }
    }

    public static final class d implements ParsingLoadable.Parser<Long> {
        public static final Pattern a = Pattern.compile("(.+?)(Z|((\\+|-|−)(\\d\\d)(:?(\\d\\d))?))");

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
        public Long parse(Uri uri, InputStream inputStream) throws IOException {
            String readLine = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8"))).readLine();
            try {
                Matcher matcher = a.matcher(readLine);
                if (!matcher.matches()) {
                    String valueOf = String.valueOf(readLine);
                    throw new ParserException(valueOf.length() != 0 ? "Couldn't parse timestamp: ".concat(valueOf) : new String("Couldn't parse timestamp: "));
                }
                String group = matcher.group(1);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                long time = simpleDateFormat.parse(group).getTime();
                if (!"Z".equals(matcher.group(2))) {
                    long j = "+".equals(matcher.group(4)) ? 1 : -1;
                    long parseLong = Long.parseLong(matcher.group(5));
                    String group2 = matcher.group(7);
                    time -= ((((parseLong * 60) + (TextUtils.isEmpty(group2) ? 0 : Long.parseLong(group2))) * 60) * 1000) * j;
                }
                return Long.valueOf(time);
            } catch (ParseException e) {
                throw new ParserException(e);
            }
        }
    }

    public final class e implements Loader.Callback<ParsingLoadable<DashManifest>> {
        public e(a aVar) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.exoplayer2.upstream.Loader$Loadable, long, long, boolean] */
        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCanceled(ParsingLoadable<DashManifest> parsingLoadable, long j, long j2, boolean z) {
            DashMediaSource.this.a(parsingLoadable, j, j2);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.exoplayer2.upstream.Loader$Loadable, long, long] */
        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCompleted(ParsingLoadable<DashManifest> parsingLoadable, long j, long j2) {
            DashMediaSource.this.b(parsingLoadable, j, j2);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.exoplayer2.upstream.Loader$Loadable, long, long, java.io.IOException, int] */
        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public Loader.LoadErrorAction onLoadError(ParsingLoadable<DashManifest> parsingLoadable, long j, long j2, IOException iOException, int i) {
            return DashMediaSource.this.c(parsingLoadable, j, j2, iOException, i);
        }
    }

    public static final class g {
        public final boolean a;
        public final long b;
        public final long c;

        public g(boolean z, long j, long j2) {
            this.a = z;
            this.b = j;
            this.c = j2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
            r3 = true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.google.android.exoplayer2.source.dash.DashMediaSource.g a(com.google.android.exoplayer2.source.dash.manifest.Period r19, long r20) {
            /*
                r0 = r19
                r4 = r20
                java.util.List<com.google.android.exoplayer2.source.dash.manifest.AdaptationSet> r1 = r0.adaptationSets
                int r1 = r1.size()
                r2 = 0
                r3 = 0
            L_0x000c:
                r6 = 1
                if (r3 >= r1) goto L_0x0024
                java.util.List<com.google.android.exoplayer2.source.dash.manifest.AdaptationSet> r7 = r0.adaptationSets
                java.lang.Object r7 = r7.get(r3)
                com.google.android.exoplayer2.source.dash.manifest.AdaptationSet r7 = (com.google.android.exoplayer2.source.dash.manifest.AdaptationSet) r7
                int r7 = r7.type
                if (r7 == r6) goto L_0x0022
                r8 = 2
                if (r7 != r8) goto L_0x001f
                goto L_0x0022
            L_0x001f:
                int r3 = r3 + 1
                goto L_0x000c
            L_0x0022:
                r3 = 1
                goto L_0x0025
            L_0x0024:
                r3 = 0
            L_0x0025:
                r7 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                r11 = 0
                r12 = 0
                r13 = 0
                r15 = 0
            L_0x002f:
                if (r11 >= r1) goto L_0x00a3
                java.util.List<com.google.android.exoplayer2.source.dash.manifest.AdaptationSet> r6 = r0.adaptationSets
                java.lang.Object r6 = r6.get(r11)
                com.google.android.exoplayer2.source.dash.manifest.AdaptationSet r6 = (com.google.android.exoplayer2.source.dash.manifest.AdaptationSet) r6
                if (r3 == 0) goto L_0x0045
                int r9 = r6.type
                r10 = 3
                if (r9 != r10) goto L_0x0045
            L_0x0040:
                r17 = r3
                r18 = r11
                goto L_0x009c
            L_0x0045:
                java.util.List<com.google.android.exoplayer2.source.dash.manifest.Representation> r6 = r6.representations
                java.lang.Object r6 = r6.get(r2)
                com.google.android.exoplayer2.source.dash.manifest.Representation r6 = (com.google.android.exoplayer2.source.dash.manifest.Representation) r6
                com.google.android.exoplayer2.source.dash.DashSegmentIndex r6 = r6.getIndex()
                if (r6 != 0) goto L_0x005f
                com.google.android.exoplayer2.source.dash.DashMediaSource$g r6 = new com.google.android.exoplayer2.source.dash.DashMediaSource$g
                r1 = 1
                r2 = 0
                r0 = r6
                r4 = r20
                r0.<init>(r1, r2, r4)
                return r6
            L_0x005f:
                boolean r9 = r6.isExplicit()
                r12 = r12 | r9
                int r9 = r6.getSegmentCount(r4)
                if (r9 != 0) goto L_0x0074
                r17 = r3
                r18 = r11
                r7 = 0
                r13 = 0
                r15 = 1
                goto L_0x009c
            L_0x0074:
                if (r15 != 0) goto L_0x0040
                r17 = r3
                long r2 = r6.getFirstSegmentNum()
                r18 = r11
                long r10 = r6.getTimeUs(r2)
                long r13 = java.lang.Math.max(r13, r10)
                r10 = -1
                if (r9 == r10) goto L_0x009c
                long r9 = (long) r9
                long r2 = r2 + r9
                r9 = 1
                long r2 = r2 - r9
                long r9 = r6.getTimeUs(r2)
                long r2 = r6.getDurationUs(r2, r4)
                long r2 = r2 + r9
                long r2 = java.lang.Math.min(r7, r2)
                r7 = r2
            L_0x009c:
                int r11 = r18 + 1
                r3 = r17
                r2 = 0
                r6 = 1
                goto L_0x002f
            L_0x00a3:
                com.google.android.exoplayer2.source.dash.DashMediaSource$g r0 = new com.google.android.exoplayer2.source.dash.DashMediaSource$g
                r11 = r0
                r15 = r7
                r11.<init>(r12, r13, r15)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.DashMediaSource.g.a(com.google.android.exoplayer2.source.dash.manifest.Period, long):com.google.android.exoplayer2.source.dash.DashMediaSource$g");
        }
    }

    public final class h implements Loader.Callback<ParsingLoadable<Long>> {
        public h(a aVar) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.exoplayer2.upstream.Loader$Loadable, long, long, boolean] */
        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCanceled(ParsingLoadable<Long> parsingLoadable, long j, long j2, boolean z) {
            DashMediaSource.this.a(parsingLoadable, j, j2);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.exoplayer2.upstream.Loader$Loadable, long, long] */
        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCompleted(ParsingLoadable<Long> parsingLoadable, long j, long j2) {
            DashMediaSource.this.d(parsingLoadable, j, j2);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.exoplayer2.upstream.Loader$Loadable, long, long, java.io.IOException, int] */
        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public Loader.LoadErrorAction onLoadError(ParsingLoadable<Long> parsingLoadable, long j, long j2, IOException iOException, int i) {
            return DashMediaSource.this.e(parsingLoadable, j, j2, iOException);
        }
    }

    public static final class i implements ParsingLoadable.Parser<Long> {
        public i(a aVar) {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
        public Long parse(Uri uri, InputStream inputStream) throws IOException {
            return Long.valueOf(Util.parseXsDateTime(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
        }
    }

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.dash");
    }

    @Deprecated
    public DashMediaSource(DashManifest dashManifest, DashChunkSource.Factory factory, @Nullable Handler handler, @Nullable MediaSourceEventListener mediaSourceEventListener) {
        this(dashManifest, factory, 3, handler, mediaSourceEventListener);
    }

    public void a(ParsingLoadable<?> parsingLoadable, long j2, long j3) {
        this.o.loadCanceled(parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), parsingLoadable.type, j2, j3, parsingLoadable.bytesLoaded());
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.dash.manifest.DashManifest> r18, long r19, long r21) {
        /*
        // Method dump skipped, instructions count: 372
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.DashMediaSource.b(com.google.android.exoplayer2.upstream.ParsingLoadable, long, long):void");
    }

    public Loader.LoadErrorAction c(ParsingLoadable<DashManifest> parsingLoadable, long j2, long j3, IOException iOException, int i2) {
        Loader.LoadErrorAction loadErrorAction;
        long retryDelayMsFor = this.l.getRetryDelayMsFor(4, j3, iOException, i2);
        if (retryDelayMsFor == C.TIME_UNSET) {
            loadErrorAction = Loader.DONT_RETRY_FATAL;
        } else {
            loadErrorAction = Loader.createRetryAction(false, retryDelayMsFor);
        }
        this.o.loadError(parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), parsingLoadable.type, j2, j3, parsingLoadable.bytesLoaded(), iOException, !loadErrorAction.isRetry());
        return loadErrorAction;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        int intValue = ((Integer) mediaPeriodId.periodUid).intValue() - this.M;
        MediaSourceEventListener.EventDispatcher createEventDispatcher = createEventDispatcher(mediaPeriodId, this.F.getPeriod(intValue).startMs);
        int i2 = this.M + intValue;
        DashMediaPeriod dashMediaPeriod = new DashMediaPeriod(i2, this.F, intValue, this.i, this.A, this.k, this.l, createEventDispatcher, this.J, this.w, allocator, this.j, this.v);
        this.s.put(i2, dashMediaPeriod);
        return dashMediaPeriod;
    }

    public void d(ParsingLoadable<Long> parsingLoadable, long j2, long j3) {
        this.o.loadCompleted(parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), parsingLoadable.type, j2, j3, parsingLoadable.bytesLoaded());
        this.J = parsingLoadable.getResult().longValue() - j2;
        g(true);
    }

    public Loader.LoadErrorAction e(ParsingLoadable<Long> parsingLoadable, long j2, long j3, IOException iOException) {
        this.o.loadError(parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), parsingLoadable.type, j2, j3, parsingLoadable.bytesLoaded(), iOException, true);
        f(iOException);
        return Loader.DONT_RETRY;
    }

    public final void f(IOException iOException) {
        Log.e("DashMediaSource", "Failed to resolve UtcTiming element.", iOException);
        g(true);
    }

    public final void g(boolean z2) {
        long j2;
        boolean z3;
        long j3;
        long j4;
        long j5;
        for (int i2 = 0; i2 < this.s.size(); i2++) {
            int keyAt = this.s.keyAt(i2);
            if (keyAt >= this.M) {
                DashMediaPeriod valueAt = this.s.valueAt(i2);
                DashManifest dashManifest = this.F;
                int i3 = keyAt - this.M;
                valueAt.s = dashManifest;
                valueAt.t = i3;
                valueAt.l.updateManifest(dashManifest);
                ChunkSampleStream<DashChunkSource>[] chunkSampleStreamArr = valueAt.p;
                if (chunkSampleStreamArr != null) {
                    for (ChunkSampleStream<DashChunkSource> chunkSampleStream : chunkSampleStreamArr) {
                        chunkSampleStream.getChunkSource().updateManifest(dashManifest, i3);
                    }
                    valueAt.o.onContinueLoadingRequested(valueAt);
                }
                valueAt.u = dashManifest.getPeriod(i3).eventStreams;
                a2.j.b.b.z0.v.c[] cVarArr = valueAt.q;
                for (a2.j.b.b.z0.v.c cVar : cVarArr) {
                    Iterator<EventStream> it = valueAt.u.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        EventStream next = it.next();
                        if (next.id().equals(cVar.e.id())) {
                            cVar.b(next, dashManifest.dynamic && i3 == dashManifest.getPeriodCount() - 1);
                        }
                    }
                }
            }
        }
        int periodCount = this.F.getPeriodCount() - 1;
        g a3 = g.a(this.F.getPeriod(0), this.F.getPeriodDurationUs(0));
        g a4 = g.a(this.F.getPeriod(periodCount), this.F.getPeriodDurationUs(periodCount));
        long j6 = a3.b;
        long j7 = a4.c;
        if (!this.F.dynamic || a4.a) {
            j2 = j6;
            z3 = false;
        } else {
            if (this.J != 0) {
                j4 = C.msToUs(SystemClock.elapsedRealtime() + this.J);
            } else {
                j4 = C.msToUs(System.currentTimeMillis());
            }
            j7 = Math.min((j4 - C.msToUs(this.F.availabilityStartTimeMs)) - C.msToUs(this.F.getPeriod(periodCount).startMs), j7);
            long j8 = this.F.timeShiftBufferDepthMs;
            if (j8 != C.TIME_UNSET) {
                long msToUs = j7 - C.msToUs(j8);
                while (msToUs < 0 && periodCount > 0) {
                    periodCount--;
                    msToUs += this.F.getPeriodDurationUs(periodCount);
                }
                if (periodCount == 0) {
                    j5 = Math.max(j6, msToUs);
                } else {
                    j5 = this.F.getPeriodDurationUs(0);
                }
                j6 = j5;
            }
            j2 = j6;
            z3 = true;
        }
        long j9 = j7 - j2;
        for (int i4 = 0; i4 < this.F.getPeriodCount() - 1; i4++) {
            j9 = this.F.getPeriodDurationUs(i4) + j9;
        }
        DashManifest dashManifest2 = this.F;
        if (dashManifest2.dynamic) {
            long j10 = this.m;
            if (!this.n) {
                long j11 = dashManifest2.suggestedPresentationDelayMs;
                if (j11 != C.TIME_UNSET) {
                    j10 = j11;
                }
            }
            long msToUs2 = j9 - C.msToUs(j10);
            if (msToUs2 < 5000000) {
                msToUs2 = Math.min(5000000L, j9 / 2);
            }
            j3 = msToUs2;
        } else {
            j3 = 0;
        }
        DashManifest dashManifest3 = this.F;
        long j12 = dashManifest3.availabilityStartTimeMs;
        long usToMs = j12 != C.TIME_UNSET ? C.usToMs(j2) + j12 + dashManifest3.getPeriod(0).startMs : -9223372036854775807L;
        DashManifest dashManifest4 = this.F;
        refreshSourceInfo(new b(dashManifest4.availabilityStartTimeMs, usToMs, this.M, j2, j9, j3, dashManifest4, this.x));
        if (!this.g) {
            this.C.removeCallbacks(this.u);
            long j13 = 5000;
            if (z3) {
                this.C.postDelayed(this.u, 5000);
            }
            if (this.G) {
                j();
            } else if (z2) {
                DashManifest dashManifest5 = this.F;
                if (dashManifest5.dynamic) {
                    long j14 = dashManifest5.minUpdatePeriodMs;
                    if (j14 != C.TIME_UNSET) {
                        if (j14 != 0) {
                            j13 = j14;
                        }
                        this.C.postDelayed(this.t, Math.max(0L, (this.H + j13) - SystemClock.elapsedRealtime()));
                    }
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource, com.google.android.exoplayer2.source.MediaSource
    @Nullable
    public Object getTag() {
        return this.x;
    }

    public final void h(UtcTimingElement utcTimingElement, ParsingLoadable.Parser<Long> parser) {
        i(new ParsingLoadable(this.y, Uri.parse(utcTimingElement.value), 5, parser), new h(null), 1);
    }

    public final <T> void i(ParsingLoadable<T> parsingLoadable, Loader.Callback<ParsingLoadable<T>> callback, int i2) {
        this.o.loadStarted(parsingLoadable.dataSpec, parsingLoadable.type, this.z.startLoading(parsingLoadable, callback, i2));
    }

    public final void j() {
        Uri uri;
        this.C.removeCallbacks(this.t);
        if (!this.z.hasFatalError()) {
            if (this.z.isLoading()) {
                this.G = true;
                return;
            }
            synchronized (this.r) {
                uri = this.E;
            }
            this.G = false;
            i(new ParsingLoadable(this.y, uri, 4, this.p), this.q, this.l.getMinimumLoadableRetryCount(4));
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        this.w.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        this.A = transferListener;
        this.k.prepare();
        if (this.g) {
            g(false);
            return;
        }
        this.y = this.h.createDataSource();
        this.z = new Loader("Loader:DashMediaSource");
        this.C = new Handler();
        j();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        DashMediaPeriod dashMediaPeriod = (DashMediaPeriod) mediaPeriod;
        dashMediaPeriod.h();
        this.s.remove(dashMediaPeriod.a);
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        this.G = false;
        this.y = null;
        Loader loader = this.z;
        if (loader != null) {
            loader.release();
            this.z = null;
        }
        this.H = 0;
        this.I = 0;
        this.F = this.g ? this.F : null;
        this.E = this.D;
        this.B = null;
        Handler handler = this.C;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.C = null;
        }
        this.J = 0;
        this.K = 0;
        this.L = C.TIME_UNSET;
        this.M = 0;
        this.s.clear();
        this.k.release();
    }

    public void replaceManifestUri(Uri uri) {
        synchronized (this.r) {
            this.E = uri;
            this.D = uri;
        }
    }

    @Deprecated
    public DashMediaSource(DashManifest dashManifest, DashChunkSource.Factory factory, int i2, @Nullable Handler handler, @Nullable MediaSourceEventListener mediaSourceEventListener) {
        this(dashManifest, null, null, null, factory, new DefaultCompositeSequenceableLoaderFactory(), DrmSessionManager.DUMMY, new DefaultLoadErrorHandlingPolicy(i2), 30000, false, null);
        if (handler != null && mediaSourceEventListener != null) {
            addEventListener(handler, mediaSourceEventListener);
        }
    }

    public final class f implements LoaderErrorThrower {
        public f() {
        }

        @Override // com.google.android.exoplayer2.upstream.LoaderErrorThrower
        public void maybeThrowError() throws IOException {
            DashMediaSource.this.z.maybeThrowError();
            IOException iOException = DashMediaSource.this.B;
            if (iOException != null) {
                throw iOException;
            }
        }

        @Override // com.google.android.exoplayer2.upstream.LoaderErrorThrower
        public void maybeThrowError(int i) throws IOException {
            DashMediaSource.this.z.maybeThrowError(i);
            IOException iOException = DashMediaSource.this.B;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    @Deprecated
    public DashMediaSource(Uri uri, DataSource.Factory factory, DashChunkSource.Factory factory2, @Nullable Handler handler, @Nullable MediaSourceEventListener mediaSourceEventListener) {
        this(uri, factory, factory2, 3, -1, handler, mediaSourceEventListener);
    }

    @Deprecated
    public DashMediaSource(Uri uri, DataSource.Factory factory, DashChunkSource.Factory factory2, int i2, long j2, @Nullable Handler handler, @Nullable MediaSourceEventListener mediaSourceEventListener) {
        this(uri, factory, new DashManifestParser(), factory2, i2, j2, handler, mediaSourceEventListener);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DashMediaSource(android.net.Uri r16, com.google.android.exoplayer2.upstream.DataSource.Factory r17, com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<? extends com.google.android.exoplayer2.source.dash.manifest.DashManifest> r18, com.google.android.exoplayer2.source.dash.DashChunkSource.Factory r19, int r20, long r21, @androidx.annotation.Nullable android.os.Handler r23, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSourceEventListener r24) {
        /*
            r15 = this;
            r0 = r23
            r1 = r24
            com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory r8 = new com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory
            r8.<init>()
            com.google.android.exoplayer2.drm.DrmSessionManager r9 = com.google.android.exoplayer2.drm.DrmSessionManager.DUMMY
            com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy r10 = new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy
            r2 = r20
            r10.<init>(r2)
            r2 = -1
            int r4 = (r21 > r2 ? 1 : (r21 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x001c
            r2 = 30000(0x7530, double:1.4822E-319)
            r11 = r2
            goto L_0x001e
        L_0x001c:
            r11 = r21
        L_0x001e:
            if (r4 == 0) goto L_0x0023
            r2 = 1
            r13 = 1
            goto L_0x0025
        L_0x0023:
            r2 = 0
            r13 = 0
        L_0x0025:
            r14 = 0
            r3 = 0
            r2 = r15
            r4 = r16
            r5 = r17
            r6 = r18
            r7 = r19
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r14)
            if (r0 == 0) goto L_0x003c
            if (r1 == 0) goto L_0x003c
            r2 = r15
            r15.addEventListener(r0, r1)
            goto L_0x003d
        L_0x003c:
            r2 = r15
        L_0x003d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.DashMediaSource.<init>(android.net.Uri, com.google.android.exoplayer2.upstream.DataSource$Factory, com.google.android.exoplayer2.upstream.ParsingLoadable$Parser, com.google.android.exoplayer2.source.dash.DashChunkSource$Factory, int, long, android.os.Handler, com.google.android.exoplayer2.source.MediaSourceEventListener):void");
    }

    public DashMediaSource(@Nullable DashManifest dashManifest, @Nullable Uri uri, @Nullable DataSource.Factory factory, @Nullable ParsingLoadable.Parser<? extends DashManifest> parser, DashChunkSource.Factory factory2, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, DrmSessionManager<?> drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, long j2, boolean z2, @Nullable Object obj) {
        this.D = uri;
        this.F = dashManifest;
        this.E = uri;
        this.h = factory;
        this.p = parser;
        this.i = factory2;
        this.k = drmSessionManager;
        this.l = loadErrorHandlingPolicy;
        this.m = j2;
        this.n = z2;
        this.j = compositeSequenceableLoaderFactory;
        this.x = obj;
        boolean z3 = dashManifest != null;
        this.g = z3;
        this.o = createEventDispatcher(null);
        this.r = new Object();
        this.s = new SparseArray<>();
        this.v = new c(null);
        this.L = C.TIME_UNSET;
        if (z3) {
            Assertions.checkState(!dashManifest.dynamic);
            this.q = null;
            this.t = null;
            this.u = null;
            this.w = new LoaderErrorThrower.Dummy();
            return;
        }
        this.q = new e(null);
        this.w = new f();
        this.t = new Runnable() { // from class: a2.j.b.b.z0.v.a
            @Override // java.lang.Runnable
            public final void run() {
                DashMediaSource dashMediaSource = DashMediaSource.this;
                int i2 = DashMediaSource.N;
                dashMediaSource.j();
            }
        };
        this.u = new Runnable() { // from class: a2.j.b.b.z0.v.b
            @Override // java.lang.Runnable
            public final void run() {
                DashMediaSource.this.g(false);
            }
        };
    }
}
