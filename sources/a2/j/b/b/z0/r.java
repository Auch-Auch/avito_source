package a2.j.b.b.z0;

import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.source.IcyDataSource;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
public final class r implements MediaPeriod, ExtractorOutput, Loader.Callback<a>, Loader.ReleaseCallback, SampleQueue.UpstreamFormatChangedListener {
    public static final Map<String, String> M;
    public static final Format N = new Format.Builder().setId("icy").setSampleMimeType(MimeTypes.APPLICATION_ICY).build();
    public boolean A;
    public int B;
    public boolean C;
    public boolean D;
    public int E;
    public long F;
    public long G;
    public long H;
    public boolean I;
    public int J;
    public boolean K;
    public boolean L;
    public final Uri a;
    public final DataSource b;
    public final DrmSessionManager c;
    public final LoadErrorHandlingPolicy d;
    public final MediaSourceEventListener.EventDispatcher e;
    public final DrmSessionEventListener.EventDispatcher f;
    public final b g;
    public final Allocator h;
    @Nullable
    public final String i;
    public final long j;
    public final Loader k = new Loader("Loader:ProgressiveMediaPeriod");
    public final l l;
    public final ConditionVariable m;
    public final Runnable n;
    public final Runnable o;
    public final Handler p;
    @Nullable
    public MediaPeriod.Callback q;
    @Nullable
    public IcyHeaders r;
    public SampleQueue[] s;
    public d[] t;
    public boolean u;
    public boolean v;
    public boolean w;
    public e x;
    public SeekMap y;
    public long z;

    public final class a implements Loader.Loadable, IcyDataSource.Listener {
        public final long a = LoadEventInfo.getNewId();
        public final Uri b;
        public final StatsDataSource c;
        public final l d;
        public final ExtractorOutput e;
        public final ConditionVariable f;
        public final PositionHolder g = new PositionHolder();
        public volatile boolean h;
        public boolean i = true;
        public long j;
        public DataSpec k = a(0);
        public long l = -1;
        @Nullable
        public TrackOutput m;
        public boolean n;

        public a(Uri uri, DataSource dataSource, l lVar, ExtractorOutput extractorOutput, ConditionVariable conditionVariable) {
            this.b = uri;
            this.c = new StatsDataSource(dataSource);
            this.d = lVar;
            this.e = extractorOutput;
            this.f = conditionVariable;
        }

        public final DataSpec a(long j2) {
            return new DataSpec.Builder().setUri(this.b).setPosition(j2).setKey(r.this.i).setFlags(6).setHttpRequestHeaders(r.M).build();
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void cancelLoad() {
            this.h = true;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void load() throws IOException {
            DataReader dataReader;
            int i2;
            int i3 = 0;
            while (i3 == 0 && !this.h) {
                try {
                    long j2 = this.g.position;
                    DataSpec a3 = a(j2);
                    this.k = a3;
                    long open = this.c.open(a3);
                    this.l = open;
                    if (open != -1) {
                        this.l = open + j2;
                    }
                    r.this.r = IcyHeaders.parse(this.c.getResponseHeaders());
                    StatsDataSource statsDataSource = this.c;
                    IcyHeaders icyHeaders = r.this.r;
                    if (icyHeaders == null || (i2 = icyHeaders.metadataInterval) == -1) {
                        dataReader = statsDataSource;
                    } else {
                        dataReader = new IcyDataSource(statsDataSource, i2, this);
                        TrackOutput h2 = r.this.h(new d(0, true));
                        this.m = h2;
                        h2.format(r.N);
                    }
                    long j3 = j2;
                    this.d.b(dataReader, this.b, this.c.getResponseHeaders(), j2, this.l, this.e);
                    if (r.this.r != null) {
                        Extractor extractor = this.d.b;
                        if (extractor instanceof Mp3Extractor) {
                            ((Mp3Extractor) extractor).disableSeeking();
                        }
                    }
                    if (this.i) {
                        ((Extractor) Assertions.checkNotNull(this.d.b)).seek(j3, this.j);
                        this.i = false;
                    }
                    while (true) {
                        while (i3 == 0 && !this.h) {
                            try {
                                this.f.block();
                                l lVar = this.d;
                                i3 = ((Extractor) Assertions.checkNotNull(lVar.b)).read((ExtractorInput) Assertions.checkNotNull(lVar.c), this.g);
                                j3 = this.d.a();
                                if (j3 > r.this.j + j3) {
                                    this.f.close();
                                    r rVar = r.this;
                                    rVar.p.post(rVar.o);
                                }
                            } catch (InterruptedException unused) {
                                throw new InterruptedIOException();
                            }
                        }
                    }
                    if (i3 == 1) {
                        i3 = 0;
                    } else if (this.d.a() != -1) {
                        this.g.position = this.d.a();
                    }
                    Util.closeQuietly(this.c);
                } catch (Throwable th) {
                    if (!(i3 == 1 || this.d.a() == -1)) {
                        this.g.position = this.d.a();
                    }
                    Util.closeQuietly(this.c);
                    throw th;
                }
            }
        }

        @Override // com.google.android.exoplayer2.source.IcyDataSource.Listener
        public void onIcyMetadata(ParsableByteArray parsableByteArray) {
            long j2;
            if (!this.n) {
                j2 = this.j;
            } else {
                r rVar = r.this;
                Map<String, String> map = r.M;
                j2 = Math.max(rVar.c(), this.j);
            }
            int bytesLeft = parsableByteArray.bytesLeft();
            TrackOutput trackOutput = (TrackOutput) Assertions.checkNotNull(this.m);
            trackOutput.sampleData(parsableByteArray, bytesLeft);
            trackOutput.sampleMetadata(j2, 1, bytesLeft, 0, null);
            this.n = true;
        }
    }

    public interface b {
        void onSourceInfoRefreshed(long j, boolean z, boolean z2);
    }

    public final class c implements SampleStream {
        public final int a;

        public c(int i) {
            this.a = i;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            r rVar = r.this;
            return !rVar.j() && rVar.s[this.a].isReady(rVar.K);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() throws IOException {
            r rVar = r.this;
            rVar.s[this.a].maybeThrowError();
            rVar.k.maybeThrowError(rVar.d.getMinimumLoadableRetryCount(rVar.B));
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
            r rVar = r.this;
            int i = this.a;
            if (rVar.j()) {
                return -3;
            }
            rVar.f(i);
            int read = rVar.s[i].read(formatHolder, decoderInputBuffer, z, rVar.K);
            if (read == -3) {
                rVar.g(i);
            }
            return read;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long j) {
            r rVar = r.this;
            int i = this.a;
            if (rVar.j()) {
                return 0;
            }
            rVar.f(i);
            SampleQueue sampleQueue = rVar.s[i];
            int skipCount = sampleQueue.getSkipCount(j, rVar.K);
            sampleQueue.skip(skipCount);
            if (skipCount != 0) {
                return skipCount;
            }
            rVar.g(i);
            return skipCount;
        }
    }

    public static final class d {
        public final int a;
        public final boolean b;

        public d(int i, boolean z) {
            this.a = i;
            this.b = z;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            if (this.a == dVar.a && this.b == dVar.b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.a * 31) + (this.b ? 1 : 0);
        }
    }

    public static final class e {
        public final TrackGroupArray a;
        public final boolean[] b;
        public final boolean[] c;
        public final boolean[] d;

        public e(TrackGroupArray trackGroupArray, boolean[] zArr) {
            this.a = trackGroupArray;
            this.b = zArr;
            int i = trackGroupArray.length;
            this.c = new boolean[i];
            this.d = new boolean[i];
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_NAME, "1");
        M = Collections.unmodifiableMap(hashMap);
    }

    public r(Uri uri, DataSource dataSource, ExtractorsFactory extractorsFactory, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher2, b bVar, Allocator allocator, @Nullable String str, int i2) {
        this.a = uri;
        this.b = dataSource;
        this.c = drmSessionManager;
        this.f = eventDispatcher;
        this.d = loadErrorHandlingPolicy;
        this.e = eventDispatcher2;
        this.g = bVar;
        this.h = allocator;
        this.i = str;
        this.j = (long) i2;
        this.l = new l(extractorsFactory);
        this.m = new ConditionVariable();
        this.n = new Runnable() { // from class: a2.j.b.b.z0.i
            @Override // java.lang.Runnable
            public final void run() {
                r.this.e();
            }
        };
        this.o = new Runnable() { // from class: a2.j.b.b.z0.k
            @Override // java.lang.Runnable
            public final void run() {
                r rVar = r.this;
                if (!rVar.L) {
                    ((MediaPeriod.Callback) Assertions.checkNotNull(rVar.q)).onContinueLoadingRequested(rVar);
                }
            }
        };
        this.p = Util.createHandlerForCurrentLooper();
        this.t = new d[0];
        this.s = new SampleQueue[0];
        this.H = C.TIME_UNSET;
        this.F = -1;
        this.z = C.TIME_UNSET;
        this.B = 1;
    }

    @EnsuresNonNull({"trackState", "seekMap"})
    public final void a() {
        Assertions.checkState(this.v);
        Assertions.checkNotNull(this.x);
        Assertions.checkNotNull(this.y);
    }

    public final int b() {
        int i2 = 0;
        for (SampleQueue sampleQueue : this.s) {
            i2 += sampleQueue.getWriteIndex();
        }
        return i2;
    }

    public final long c() {
        long j2 = Long.MIN_VALUE;
        for (SampleQueue sampleQueue : this.s) {
            j2 = Math.max(j2, sampleQueue.getLargestQueuedTimestampUs());
        }
        return j2;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j2) {
        if (this.K || this.k.hasFatalError() || this.I) {
            return false;
        }
        if (this.v && this.E == 0) {
            return false;
        }
        boolean open = this.m.open();
        if (this.k.isLoading()) {
            return open;
        }
        i();
        return true;
    }

    public final boolean d() {
        return this.H != C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j2, boolean z2) {
        a();
        if (!d()) {
            boolean[] zArr = this.x.c;
            int length = this.s.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.s[i2].discardTo(j2, z2, zArr[i2]);
            }
        }
    }

    public final void e() {
        Metadata metadata;
        if (!(this.L || this.v || !this.u || this.y == null)) {
            for (SampleQueue sampleQueue : this.s) {
                if (sampleQueue.getUpstreamFormat() == null) {
                    return;
                }
            }
            this.m.close();
            int length = this.s.length;
            TrackGroup[] trackGroupArr = new TrackGroup[length];
            boolean[] zArr = new boolean[length];
            for (int i2 = 0; i2 < length; i2++) {
                Format format = (Format) Assertions.checkNotNull(this.s[i2].getUpstreamFormat());
                String str = format.sampleMimeType;
                boolean isAudio = MimeTypes.isAudio(str);
                boolean z2 = isAudio || MimeTypes.isVideo(str);
                zArr[i2] = z2;
                this.w = z2 | this.w;
                IcyHeaders icyHeaders = this.r;
                if (icyHeaders != null) {
                    if (isAudio || this.t[i2].b) {
                        Metadata metadata2 = format.metadata;
                        if (metadata2 == null) {
                            metadata = new Metadata(icyHeaders);
                        } else {
                            metadata = metadata2.copyWithAppendedEntries(icyHeaders);
                        }
                        format = format.buildUpon().setMetadata(metadata).build();
                    }
                    if (isAudio && format.averageBitrate == -1 && format.peakBitrate == -1 && icyHeaders.bitrate != -1) {
                        format = format.buildUpon().setAverageBitrate(icyHeaders.bitrate).build();
                    }
                }
                trackGroupArr[i2] = new TrackGroup(format.copyWithExoMediaCryptoType(this.c.getExoMediaCryptoType(format)));
            }
            this.x = new e(new TrackGroupArray(trackGroupArr), zArr);
            this.v = true;
            ((MediaPeriod.Callback) Assertions.checkNotNull(this.q)).onPrepared(this);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void endTracks() {
        this.u = true;
        this.p.post(this.n);
    }

    public final void f(int i2) {
        a();
        e eVar = this.x;
        boolean[] zArr = eVar.d;
        if (!zArr[i2]) {
            Format format = eVar.a.get(i2).getFormat(0);
            this.e.downstreamFormatChanged(MimeTypes.getTrackType(format.sampleMimeType), format, 0, null, this.G);
            zArr[i2] = true;
        }
    }

    public final void g(int i2) {
        a();
        boolean[] zArr = this.x.b;
        if (this.I && zArr[i2]) {
            if (!this.s[i2].isReady(false)) {
                this.H = 0;
                this.I = false;
                this.D = true;
                this.G = 0;
                this.J = 0;
                for (SampleQueue sampleQueue : this.s) {
                    sampleQueue.reset();
                }
                ((MediaPeriod.Callback) Assertions.checkNotNull(this.q)).onContinueLoadingRequested(this);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long j2, SeekParameters seekParameters) {
        a();
        if (!this.y.isSeekable()) {
            return 0;
        }
        SeekMap.SeekPoints seekPoints = this.y.getSeekPoints(j2);
        return seekParameters.resolveSeekPositionUs(j2, seekPoints.first.timeUs, seekPoints.second.timeUs);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        long j2;
        a();
        boolean[] zArr = this.x.b;
        if (this.K) {
            return Long.MIN_VALUE;
        }
        if (d()) {
            return this.H;
        }
        if (this.w) {
            int length = this.s.length;
            j2 = Long.MAX_VALUE;
            for (int i2 = 0; i2 < length; i2++) {
                if (zArr[i2] && !this.s[i2].isLastSampleQueued()) {
                    j2 = Math.min(j2, this.s[i2].getLargestQueuedTimestampUs());
                }
            }
        } else {
            j2 = Long.MAX_VALUE;
        }
        if (j2 == Long.MAX_VALUE) {
            j2 = c();
        }
        return j2 == Long.MIN_VALUE ? this.G : j2;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        if (this.E == 0) {
            return Long.MIN_VALUE;
        }
        return getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public /* synthetic */ List getStreamKeys(List list) {
        return m.$default$getStreamKeys(this, list);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        a();
        return this.x.a;
    }

    public final TrackOutput h(d dVar) {
        int length = this.s.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (dVar.equals(this.t[i2])) {
                return this.s[i2];
            }
        }
        SampleQueue sampleQueue = new SampleQueue(this.h, this.p.getLooper(), this.c, this.f);
        sampleQueue.setUpstreamFormatChangeListener(this);
        int i3 = length + 1;
        d[] dVarArr = (d[]) Arrays.copyOf(this.t, i3);
        dVarArr[length] = dVar;
        this.t = (d[]) Util.castNonNullTypeArray(dVarArr);
        SampleQueue[] sampleQueueArr = (SampleQueue[]) Arrays.copyOf(this.s, i3);
        sampleQueueArr[length] = sampleQueue;
        this.s = (SampleQueue[]) Util.castNonNullTypeArray(sampleQueueArr);
        return sampleQueue;
    }

    public final void i() {
        a aVar = new a(this.a, this.b, this.l, this, this.m);
        if (this.v) {
            Assertions.checkState(d());
            long j2 = this.z;
            if (j2 == C.TIME_UNSET || this.H <= j2) {
                long j3 = ((SeekMap) Assertions.checkNotNull(this.y)).getSeekPoints(this.H).first.position;
                long j4 = this.H;
                aVar.g.position = j3;
                aVar.j = j4;
                aVar.i = true;
                aVar.n = false;
                for (SampleQueue sampleQueue : this.s) {
                    sampleQueue.setStartTimeUs(this.H);
                }
                this.H = C.TIME_UNSET;
            } else {
                this.K = true;
                this.H = C.TIME_UNSET;
                return;
            }
        }
        this.J = b();
        this.e.loadStarted(new LoadEventInfo(aVar.a, aVar.k, this.k.startLoading(aVar, this, this.d.getMinimumLoadableRetryCount(this.B))), 1, -1, null, 0, null, aVar.j, this.z);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        return this.k.isLoading() && this.m.isOpen();
    }

    public final boolean j() {
        return this.D || d();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws IOException {
        this.k.maybeThrowError(this.d.getMinimumLoadableRetryCount(this.B));
        if (this.K && !this.v) {
            throw new ParserException("Loading finished before preparation is complete.");
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.exoplayer2.upstream.Loader$Loadable, long, long, boolean] */
    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCanceled(a aVar, long j2, long j3, boolean z2) {
        a aVar2 = aVar;
        StatsDataSource statsDataSource = aVar2.c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(aVar2.a, aVar2.k, statsDataSource.getLastOpenedUri(), statsDataSource.getLastResponseHeaders(), j2, j3, statsDataSource.getBytesRead());
        this.d.onLoadTaskConcluded(aVar2.a);
        this.e.loadCanceled(loadEventInfo, 1, -1, null, 0, null, aVar2.j, this.z);
        if (!z2) {
            if (this.F == -1) {
                this.F = aVar2.l;
            }
            for (SampleQueue sampleQueue : this.s) {
                sampleQueue.reset();
            }
            if (this.E > 0) {
                ((MediaPeriod.Callback) Assertions.checkNotNull(this.q)).onContinueLoadingRequested(this);
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.exoplayer2.upstream.Loader$Loadable, long, long] */
    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCompleted(a aVar, long j2, long j3) {
        SeekMap seekMap;
        a aVar2 = aVar;
        if (this.z == C.TIME_UNSET && (seekMap = this.y) != null) {
            boolean isSeekable = seekMap.isSeekable();
            long c2 = c();
            long j4 = c2 == Long.MIN_VALUE ? 0 : c2 + 10000;
            this.z = j4;
            this.g.onSourceInfoRefreshed(j4, isSeekable, this.A);
        }
        StatsDataSource statsDataSource = aVar2.c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(aVar2.a, aVar2.k, statsDataSource.getLastOpenedUri(), statsDataSource.getLastResponseHeaders(), j2, j3, statsDataSource.getBytesRead());
        this.d.onLoadTaskConcluded(aVar2.a);
        this.e.loadCompleted(loadEventInfo, 1, -1, null, 0, null, aVar2.j, this.z);
        if (this.F == -1) {
            this.F = aVar2.l;
        }
        this.K = true;
        ((MediaPeriod.Callback) Assertions.checkNotNull(this.q)).onContinueLoadingRequested(this);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.exoplayer2.upstream.Loader$Loadable, long, long, java.io.IOException, int] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c0  */
    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.upstream.Loader.LoadErrorAction onLoadError(a2.j.b.b.z0.r.a r29, long r30, long r32, java.io.IOException r34, int r35) {
        /*
        // Method dump skipped, instructions count: 237
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.j.b.b.z0.r.onLoadError(com.google.android.exoplayer2.upstream.Loader$Loadable, long, long, java.io.IOException, int):com.google.android.exoplayer2.upstream.Loader$LoadErrorAction");
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.ReleaseCallback
    public void onLoaderReleased() {
        for (SampleQueue sampleQueue : this.s) {
            sampleQueue.release();
        }
        l lVar = this.l;
        Extractor extractor = lVar.b;
        if (extractor != null) {
            extractor.release();
            lVar.b = null;
        }
        lVar.c = null;
    }

    @Override // com.google.android.exoplayer2.source.SampleQueue.UpstreamFormatChangedListener
    public void onUpstreamFormatChanged(Format format) {
        this.p.post(this.n);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(MediaPeriod.Callback callback, long j2) {
        this.q = callback;
        this.m.open();
        i();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        if (!this.D) {
            return C.TIME_UNSET;
        }
        if (!this.K && b() <= this.J) {
            return C.TIME_UNSET;
        }
        this.D = false;
        return this.G;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j2) {
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void seekMap(SeekMap seekMap) {
        this.p.post(new Runnable(seekMap) { // from class: a2.j.b.b.z0.j
            public final /* synthetic */ SeekMap b;

            {
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                r rVar = r.this;
                SeekMap seekMap2 = this.b;
                rVar.y = rVar.r == null ? seekMap2 : new SeekMap.Unseekable(C.TIME_UNSET);
                rVar.z = seekMap2.getDurationUs();
                int i2 = 1;
                boolean z2 = rVar.F == -1 && seekMap2.getDurationUs() == C.TIME_UNSET;
                rVar.A = z2;
                if (z2) {
                    i2 = 7;
                }
                rVar.B = i2;
                rVar.g.onSourceInfoRefreshed(rVar.z, seekMap2.isSeekable(), rVar.A);
                if (!rVar.v) {
                    rVar.e();
                }
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j2) {
        boolean z2;
        a();
        boolean[] zArr = this.x.b;
        if (!this.y.isSeekable()) {
            j2 = 0;
        }
        int i2 = 0;
        this.D = false;
        this.G = j2;
        if (d()) {
            this.H = j2;
            return j2;
        }
        if (this.B != 7) {
            int length = this.s.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    z2 = true;
                    break;
                } else if (this.s[i3].seekTo(j2, false) || (!zArr[i3] && this.w)) {
                    i3++;
                }
            }
            z2 = false;
            if (z2) {
                return j2;
            }
        }
        this.I = false;
        this.H = j2;
        this.K = false;
        if (this.k.isLoading()) {
            SampleQueue[] sampleQueueArr = this.s;
            int length2 = sampleQueueArr.length;
            while (i2 < length2) {
                sampleQueueArr[i2].discardToEnd();
                i2++;
            }
            this.k.cancelLoading();
        } else {
            this.k.clearFatalError();
            SampleQueue[] sampleQueueArr2 = this.s;
            int length3 = sampleQueueArr2.length;
            while (i2 < length3) {
                sampleQueueArr2[i2].reset();
                i2++;
            }
        }
        return j2;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
        a();
        e eVar = this.x;
        TrackGroupArray trackGroupArray = eVar.a;
        boolean[] zArr3 = eVar.c;
        int i2 = this.E;
        int i3 = 0;
        for (int i4 = 0; i4 < trackSelectionArr.length; i4++) {
            if (sampleStreamArr[i4] != null && (trackSelectionArr[i4] == null || !zArr[i4])) {
                int i5 = ((c) sampleStreamArr[i4]).a;
                Assertions.checkState(zArr3[i5]);
                this.E--;
                zArr3[i5] = false;
                sampleStreamArr[i4] = null;
            }
        }
        boolean z2 = !this.C ? j2 != 0 : i2 == 0;
        for (int i6 = 0; i6 < trackSelectionArr.length; i6++) {
            if (sampleStreamArr[i6] == null && trackSelectionArr[i6] != null) {
                TrackSelection trackSelection = trackSelectionArr[i6];
                Assertions.checkState(trackSelection.length() == 1);
                Assertions.checkState(trackSelection.getIndexInTrackGroup(0) == 0);
                int indexOf = trackGroupArray.indexOf(trackSelection.getTrackGroup());
                Assertions.checkState(!zArr3[indexOf]);
                this.E++;
                zArr3[indexOf] = true;
                sampleStreamArr[i6] = new c(indexOf);
                zArr2[i6] = true;
                if (!z2) {
                    SampleQueue sampleQueue = this.s[indexOf];
                    z2 = !sampleQueue.seekTo(j2, true) && sampleQueue.getReadIndex() != 0;
                }
            }
        }
        if (this.E == 0) {
            this.I = false;
            this.D = false;
            if (this.k.isLoading()) {
                SampleQueue[] sampleQueueArr = this.s;
                int length = sampleQueueArr.length;
                while (i3 < length) {
                    sampleQueueArr[i3].discardToEnd();
                    i3++;
                }
                this.k.cancelLoading();
            } else {
                SampleQueue[] sampleQueueArr2 = this.s;
                int length2 = sampleQueueArr2.length;
                while (i3 < length2) {
                    sampleQueueArr2[i3].reset();
                    i3++;
                }
            }
        } else if (z2) {
            j2 = seekToUs(j2);
            while (i3 < sampleStreamArr.length) {
                if (sampleStreamArr[i3] != null) {
                    zArr2[i3] = true;
                }
                i3++;
            }
        }
        this.C = true;
        return j2;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public TrackOutput track(int i2, int i3) {
        return h(new d(i2, false));
    }
}
