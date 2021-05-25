package a2.j.b.b.z0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public final class t implements MediaPeriod, Loader.Callback<c> {
    public final DataSpec a;
    public final DataSource.Factory b;
    @Nullable
    public final TransferListener c;
    public final LoadErrorHandlingPolicy d;
    public final MediaSourceEventListener.EventDispatcher e;
    public final TrackGroupArray f;
    public final ArrayList<b> g = new ArrayList<>();
    public final long h;
    public final Loader i = new Loader("Loader:SingleSampleMediaPeriod");
    public final Format j;
    public final boolean k;
    public boolean l;
    public byte[] m;
    public int n;

    public final class b implements SampleStream {
        public int a;
        public boolean b;

        public b(a aVar) {
        }

        public final void a() {
            if (!this.b) {
                t tVar = t.this;
                tVar.e.downstreamFormatChanged(MimeTypes.getTrackType(tVar.j.sampleMimeType), t.this.j, 0, null, 0);
                this.b = true;
            }
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return t.this.l;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() throws IOException {
            t tVar = t.this;
            if (!tVar.k) {
                tVar.i.maybeThrowError();
            }
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
            a();
            int i = this.a;
            if (i == 2) {
                decoderInputBuffer.addFlag(4);
                return -4;
            } else if (z || i == 0) {
                formatHolder.format = t.this.j;
                this.a = 1;
                return -5;
            } else {
                t tVar = t.this;
                if (!tVar.l) {
                    return -3;
                }
                if (tVar.m != null) {
                    decoderInputBuffer.addFlag(1);
                    decoderInputBuffer.timeUs = 0;
                    if (decoderInputBuffer.isFlagsOnly()) {
                        return -4;
                    }
                    decoderInputBuffer.ensureSpaceForWrite(t.this.n);
                    ByteBuffer byteBuffer = decoderInputBuffer.data;
                    t tVar2 = t.this;
                    byteBuffer.put(tVar2.m, 0, tVar2.n);
                } else {
                    decoderInputBuffer.addFlag(4);
                }
                this.a = 2;
                return -4;
            }
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long j) {
            a();
            if (j <= 0 || this.a == 2) {
                return 0;
            }
            this.a = 2;
            return 1;
        }
    }

    public static final class c implements Loader.Loadable {
        public final long a = LoadEventInfo.getNewId();
        public final DataSpec b;
        public final StatsDataSource c;
        @Nullable
        public byte[] d;

        public c(DataSpec dataSpec, DataSource dataSource) {
            this.b = dataSpec;
            this.c = new StatsDataSource(dataSource);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void cancelLoad() {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void load() throws IOException {
            this.c.resetBytesRead();
            try {
                this.c.open(this.b);
                int i = 0;
                while (i != -1) {
                    int bytesRead = (int) this.c.getBytesRead();
                    byte[] bArr = this.d;
                    if (bArr == null) {
                        this.d = new byte[1024];
                    } else if (bytesRead == bArr.length) {
                        this.d = Arrays.copyOf(bArr, bArr.length * 2);
                    }
                    StatsDataSource statsDataSource = this.c;
                    byte[] bArr2 = this.d;
                    i = statsDataSource.read(bArr2, bytesRead, bArr2.length - bytesRead);
                }
            } finally {
                Util.closeQuietly(this.c);
            }
        }
    }

    public t(DataSpec dataSpec, DataSource.Factory factory, @Nullable TransferListener transferListener, Format format, long j2, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher, boolean z) {
        this.a = dataSpec;
        this.b = factory;
        this.c = transferListener;
        this.j = format;
        this.h = j2;
        this.d = loadErrorHandlingPolicy;
        this.e = eventDispatcher;
        this.k = z;
        this.f = new TrackGroupArray(new TrackGroup(format));
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j2) {
        if (this.l || this.i.isLoading() || this.i.hasFatalError()) {
            return false;
        }
        DataSource createDataSource = this.b.createDataSource();
        TransferListener transferListener = this.c;
        if (transferListener != null) {
            createDataSource.addTransferListener(transferListener);
        }
        c cVar = new c(this.a, createDataSource);
        this.e.loadStarted(new LoadEventInfo(cVar.a, this.a, this.i.startLoading(cVar, this, this.d.getMinimumLoadableRetryCount(1))), 1, -1, this.j, 0, null, 0, this.h);
        return true;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j2, boolean z) {
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long j2, SeekParameters seekParameters) {
        return j2;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        return this.l ? Long.MIN_VALUE : 0;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        return (this.l || this.i.isLoading()) ? Long.MIN_VALUE : 0;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public /* synthetic */ List getStreamKeys(List list) {
        return m.$default$getStreamKeys(this, list);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        return this.f;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        return this.i.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.exoplayer2.upstream.Loader$Loadable, long, long, boolean] */
    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCanceled(c cVar, long j2, long j3, boolean z) {
        c cVar2 = cVar;
        StatsDataSource statsDataSource = cVar2.c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(cVar2.a, cVar2.b, statsDataSource.getLastOpenedUri(), statsDataSource.getLastResponseHeaders(), j2, j3, statsDataSource.getBytesRead());
        this.d.onLoadTaskConcluded(cVar2.a);
        this.e.loadCanceled(loadEventInfo, 1, -1, null, 0, null, 0, this.h);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.exoplayer2.upstream.Loader$Loadable, long, long] */
    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCompleted(c cVar, long j2, long j3) {
        c cVar2 = cVar;
        this.n = (int) cVar2.c.getBytesRead();
        this.m = (byte[]) Assertions.checkNotNull(cVar2.d);
        this.l = true;
        StatsDataSource statsDataSource = cVar2.c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(cVar2.a, cVar2.b, statsDataSource.getLastOpenedUri(), statsDataSource.getLastResponseHeaders(), j2, j3, (long) this.n);
        this.d.onLoadTaskConcluded(cVar2.a);
        this.e.loadCompleted(loadEventInfo, 1, -1, this.j, 0, null, 0, this.h);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.exoplayer2.upstream.Loader$Loadable, long, long, java.io.IOException, int] */
    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public Loader.LoadErrorAction onLoadError(c cVar, long j2, long j3, IOException iOException, int i2) {
        Loader.LoadErrorAction loadErrorAction;
        c cVar2 = cVar;
        StatsDataSource statsDataSource = cVar2.c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(cVar2.a, cVar2.b, statsDataSource.getLastOpenedUri(), statsDataSource.getLastResponseHeaders(), j2, j3, statsDataSource.getBytesRead());
        long retryDelayMsFor = this.d.getRetryDelayMsFor(new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(1, -1, this.j, 0, null, 0, C.usToMs(this.h)), iOException, i2));
        int i3 = (retryDelayMsFor > C.TIME_UNSET ? 1 : (retryDelayMsFor == C.TIME_UNSET ? 0 : -1));
        boolean z = i3 == 0 || i2 >= this.d.getMinimumLoadableRetryCount(1);
        if (this.k && z) {
            this.l = true;
            loadErrorAction = Loader.DONT_RETRY;
        } else if (i3 != 0) {
            loadErrorAction = Loader.createRetryAction(false, retryDelayMsFor);
        } else {
            loadErrorAction = Loader.DONT_RETRY_FATAL;
        }
        boolean z2 = !loadErrorAction.isRetry();
        this.e.loadError(loadEventInfo, 1, -1, this.j, 0, null, 0, this.h, iOException, z2);
        if (z2) {
            this.d.onLoadTaskConcluded(cVar2.a);
        }
        return loadErrorAction;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(MediaPeriod.Callback callback, long j2) {
        callback.onPrepared(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        return C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j2) {
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j2) {
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            b bVar = this.g.get(i2);
            if (bVar.a == 2) {
                bVar.a = 1;
            }
        }
        return j2;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
        for (int i2 = 0; i2 < trackSelectionArr.length; i2++) {
            if (sampleStreamArr[i2] != null && (trackSelectionArr[i2] == null || !zArr[i2])) {
                this.g.remove(sampleStreamArr[i2]);
                sampleStreamArr[i2] = null;
            }
            if (sampleStreamArr[i2] == null && trackSelectionArr[i2] != null) {
                b bVar = new b(null);
                this.g.add(bVar);
                sampleStreamArr[i2] = bVar;
                zArr2[i2] = true;
            }
        }
        return j2;
    }
}
