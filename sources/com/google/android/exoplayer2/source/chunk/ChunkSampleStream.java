package com.google.android.exoplayer2.source.chunk;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.chunk.ChunkSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class ChunkSampleStream<T extends ChunkSource> implements SampleStream, SequenceableLoader, Loader.Callback<Chunk>, Loader.ReleaseCallback {
    public final int[] a;
    public final Format[] b;
    public final boolean[] c;
    public final T d;
    public final SequenceableLoader.Callback<ChunkSampleStream<T>> e;
    public final MediaSourceEventListener.EventDispatcher f;
    public final LoadErrorHandlingPolicy g;
    public final Loader h;
    public final ChunkHolder i;
    public final ArrayList<BaseMediaChunk> j;
    public final List<BaseMediaChunk> k;
    public final SampleQueue l;
    public final SampleQueue[] m;
    public final BaseMediaChunkOutput n;
    @Nullable
    public Chunk o;
    public Format p;
    public final int primaryTrackType;
    @Nullable
    public ReleaseCallback<T> q;
    public long r;
    public long s;
    public int t;
    @Nullable
    public BaseMediaChunk u;
    public boolean v;

    public final class EmbeddedSampleStream implements SampleStream {
        public final SampleQueue a;
        public final int b;
        public boolean c;
        public final ChunkSampleStream<T> parent;

        public EmbeddedSampleStream(ChunkSampleStream<T> chunkSampleStream, SampleQueue sampleQueue, int i) {
            this.parent = chunkSampleStream;
            this.a = sampleQueue;
            this.b = i;
        }

        public final void a() {
            if (!this.c) {
                ChunkSampleStream chunkSampleStream = ChunkSampleStream.this;
                MediaSourceEventListener.EventDispatcher eventDispatcher = chunkSampleStream.f;
                int[] iArr = chunkSampleStream.a;
                int i = this.b;
                eventDispatcher.downstreamFormatChanged(iArr[i], chunkSampleStream.b[i], 0, null, chunkSampleStream.s);
                this.c = true;
            }
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return !ChunkSampleStream.this.d() && this.a.isReady(ChunkSampleStream.this.v);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() {
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
            if (ChunkSampleStream.this.d()) {
                return -3;
            }
            BaseMediaChunk baseMediaChunk = ChunkSampleStream.this.u;
            if (baseMediaChunk != null && baseMediaChunk.getFirstSampleIndex(this.b + 1) <= this.a.getReadIndex()) {
                return -3;
            }
            a();
            return this.a.read(formatHolder, decoderInputBuffer, z, ChunkSampleStream.this.v);
        }

        public void release() {
            Assertions.checkState(ChunkSampleStream.this.c[this.b]);
            ChunkSampleStream.this.c[this.b] = false;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long j) {
            if (ChunkSampleStream.this.d()) {
                return 0;
            }
            int skipCount = this.a.getSkipCount(j, ChunkSampleStream.this.v);
            BaseMediaChunk baseMediaChunk = ChunkSampleStream.this.u;
            if (baseMediaChunk != null) {
                skipCount = Math.min(skipCount, baseMediaChunk.getFirstSampleIndex(this.b + 1) - this.a.getReadIndex());
            }
            this.a.skip(skipCount);
            if (skipCount > 0) {
                a();
            }
            return skipCount;
        }
    }

    public interface ReleaseCallback<T extends ChunkSource> {
        void onSampleStreamReleased(ChunkSampleStream<T> chunkSampleStream);
    }

    public ChunkSampleStream(int i2, @Nullable int[] iArr, @Nullable Format[] formatArr, T t2, SequenceableLoader.Callback<ChunkSampleStream<T>> callback, Allocator allocator, long j2, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher2) {
        this.primaryTrackType = i2;
        int i3 = 0;
        iArr = iArr == null ? new int[0] : iArr;
        this.a = iArr;
        this.b = formatArr == null ? new Format[0] : formatArr;
        this.d = t2;
        this.e = callback;
        this.f = eventDispatcher2;
        this.g = loadErrorHandlingPolicy;
        this.h = new Loader("Loader:ChunkSampleStream");
        this.i = new ChunkHolder();
        ArrayList<BaseMediaChunk> arrayList = new ArrayList<>();
        this.j = arrayList;
        this.k = Collections.unmodifiableList(arrayList);
        int length = iArr.length;
        this.m = new SampleQueue[length];
        this.c = new boolean[length];
        int i4 = length + 1;
        int[] iArr2 = new int[i4];
        SampleQueue[] sampleQueueArr = new SampleQueue[i4];
        SampleQueue sampleQueue = new SampleQueue(allocator, (Looper) Assertions.checkNotNull(Looper.myLooper()), drmSessionManager, eventDispatcher);
        this.l = sampleQueue;
        iArr2[0] = i2;
        sampleQueueArr[0] = sampleQueue;
        while (i3 < length) {
            SampleQueue sampleQueue2 = new SampleQueue(allocator, (Looper) Assertions.checkNotNull(Looper.myLooper()), DrmSessionManager.DUMMY, eventDispatcher);
            this.m[i3] = sampleQueue2;
            int i5 = i3 + 1;
            sampleQueueArr[i5] = sampleQueue2;
            iArr2[i5] = this.a[i3];
            i3 = i5;
        }
        this.n = new BaseMediaChunkOutput(iArr2, sampleQueueArr);
        this.r = j2;
        this.s = j2;
    }

    public final BaseMediaChunk a(int i2) {
        BaseMediaChunk baseMediaChunk = this.j.get(i2);
        ArrayList<BaseMediaChunk> arrayList = this.j;
        Util.removeRange(arrayList, i2, arrayList.size());
        this.t = Math.max(this.t, this.j.size());
        int i3 = 0;
        this.l.discardUpstreamSamples(baseMediaChunk.getFirstSampleIndex(0));
        while (true) {
            SampleQueue[] sampleQueueArr = this.m;
            if (i3 >= sampleQueueArr.length) {
                return baseMediaChunk;
            }
            SampleQueue sampleQueue = sampleQueueArr[i3];
            i3++;
            sampleQueue.discardUpstreamSamples(baseMediaChunk.getFirstSampleIndex(i3));
        }
    }

    public final BaseMediaChunk b() {
        ArrayList<BaseMediaChunk> arrayList = this.j;
        return arrayList.get(arrayList.size() - 1);
    }

    public final boolean c(int i2) {
        int readIndex;
        BaseMediaChunk baseMediaChunk = this.j.get(i2);
        if (this.l.getReadIndex() > baseMediaChunk.getFirstSampleIndex(0)) {
            return true;
        }
        int i3 = 0;
        do {
            SampleQueue[] sampleQueueArr = this.m;
            if (i3 >= sampleQueueArr.length) {
                return false;
            }
            readIndex = sampleQueueArr[i3].getReadIndex();
            i3++;
        } while (readIndex <= baseMediaChunk.getFirstSampleIndex(i3));
        return true;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j2) {
        long j3;
        List<BaseMediaChunk> list;
        if (this.v || this.h.isLoading() || this.h.hasFatalError()) {
            return false;
        }
        boolean d2 = d();
        if (d2) {
            list = Collections.emptyList();
            j3 = this.r;
        } else {
            list = this.k;
            j3 = b().endTimeUs;
        }
        this.d.getNextChunk(j2, j3, list, this.i);
        ChunkHolder chunkHolder = this.i;
        boolean z = chunkHolder.endOfStream;
        Chunk chunk = chunkHolder.chunk;
        chunkHolder.clear();
        if (z) {
            this.r = C.TIME_UNSET;
            this.v = true;
            return true;
        } else if (chunk == null) {
            return false;
        } else {
            this.o = chunk;
            if (chunk instanceof BaseMediaChunk) {
                BaseMediaChunk baseMediaChunk = (BaseMediaChunk) chunk;
                if (d2) {
                    long j4 = baseMediaChunk.startTimeUs;
                    long j5 = this.r;
                    if (j4 != j5) {
                        this.l.setStartTimeUs(j5);
                        for (SampleQueue sampleQueue : this.m) {
                            sampleQueue.setStartTimeUs(this.r);
                        }
                    }
                    this.r = C.TIME_UNSET;
                }
                baseMediaChunk.init(this.n);
                this.j.add(baseMediaChunk);
            } else if (chunk instanceof InitializationChunk) {
                ((InitializationChunk) chunk).init(this.n);
            }
            this.f.loadStarted(new LoadEventInfo(chunk.loadTaskId, chunk.dataSpec, this.h.startLoading(chunk, this, this.g.getMinimumLoadableRetryCount(chunk.type))), chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs);
            return true;
        }
    }

    public boolean d() {
        return this.r != C.TIME_UNSET;
    }

    public void discardBuffer(long j2, boolean z) {
        if (!d()) {
            int firstIndex = this.l.getFirstIndex();
            this.l.discardTo(j2, z, true);
            int firstIndex2 = this.l.getFirstIndex();
            if (firstIndex2 > firstIndex) {
                long firstTimestampUs = this.l.getFirstTimestampUs();
                int i2 = 0;
                while (true) {
                    SampleQueue[] sampleQueueArr = this.m;
                    if (i2 >= sampleQueueArr.length) {
                        break;
                    }
                    sampleQueueArr[i2].discardTo(firstTimestampUs, z, this.c[i2]);
                    i2++;
                }
            }
            int min = Math.min(f(firstIndex2, 0), this.t);
            if (min > 0) {
                Util.removeRange(this.j, 0, min);
                this.t -= min;
            }
        }
    }

    public final void e() {
        int f2 = f(this.l.getReadIndex(), this.t - 1);
        while (true) {
            int i2 = this.t;
            if (i2 <= f2) {
                this.t = i2 + 1;
                BaseMediaChunk baseMediaChunk = this.j.get(i2);
                Format format = baseMediaChunk.trackFormat;
                if (!format.equals(this.p)) {
                    this.f.downstreamFormatChanged(this.primaryTrackType, format, baseMediaChunk.trackSelectionReason, baseMediaChunk.trackSelectionData, baseMediaChunk.startTimeUs);
                }
                this.p = format;
            } else {
                return;
            }
        }
    }

    public final int f(int i2, int i3) {
        do {
            i3++;
            if (i3 >= this.j.size()) {
                return this.j.size() - 1;
            }
        } while (this.j.get(i3).getFirstSampleIndex(0) <= i2);
        return i3 - 1;
    }

    public final void g() {
        this.l.reset();
        for (SampleQueue sampleQueue : this.m) {
            sampleQueue.reset();
        }
    }

    public long getAdjustedSeekPositionUs(long j2, SeekParameters seekParameters) {
        return this.d.getAdjustedSeekPositionUs(j2, seekParameters);
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        if (this.v) {
            return Long.MIN_VALUE;
        }
        if (d()) {
            return this.r;
        }
        long j2 = this.s;
        BaseMediaChunk b2 = b();
        if (!b2.isLoadCompleted()) {
            if (this.j.size() > 1) {
                ArrayList<BaseMediaChunk> arrayList = this.j;
                b2 = arrayList.get(arrayList.size() - 2);
            } else {
                b2 = null;
            }
        }
        if (b2 != null) {
            j2 = Math.max(j2, b2.endTimeUs);
        }
        return Math.max(j2, this.l.getLargestQueuedTimestampUs());
    }

    public T getChunkSource() {
        return this.d;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        if (d()) {
            return this.r;
        }
        if (this.v) {
            return Long.MIN_VALUE;
        }
        return b().endTimeUs;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        return this.h.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public boolean isReady() {
        return !d() && this.l.isReady(this.v);
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public void maybeThrowError() throws IOException {
        this.h.maybeThrowError();
        this.l.maybeThrowError();
        if (!this.h.isLoading()) {
            this.d.maybeThrowError();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.ReleaseCallback
    public void onLoaderReleased() {
        this.l.release();
        for (SampleQueue sampleQueue : this.m) {
            sampleQueue.release();
        }
        this.d.release();
        ReleaseCallback<T> releaseCallback = this.q;
        if (releaseCallback != null) {
            releaseCallback.onSampleStreamReleased(this);
        }
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
        if (d()) {
            return -3;
        }
        BaseMediaChunk baseMediaChunk = this.u;
        if (baseMediaChunk != null && baseMediaChunk.getFirstSampleIndex(0) <= this.l.getReadIndex()) {
            return -3;
        }
        e();
        return this.l.read(formatHolder, decoderInputBuffer, z, this.v);
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j2) {
        if (!this.h.hasFatalError() && !d()) {
            if (this.h.isLoading()) {
                Chunk chunk = (Chunk) Assertions.checkNotNull(this.o);
                boolean z = chunk instanceof BaseMediaChunk;
                if ((!z || !c(this.j.size() - 1)) && this.d.shouldCancelLoad(j2, chunk, this.k)) {
                    this.h.cancelLoading();
                    if (z) {
                        this.u = (BaseMediaChunk) chunk;
                        return;
                    }
                    return;
                }
                return;
            }
            int preferredQueueSize = this.d.getPreferredQueueSize(j2, this.k);
            if (preferredQueueSize < this.j.size()) {
                Assertions.checkState(!this.h.isLoading());
                int size = this.j.size();
                while (true) {
                    if (preferredQueueSize >= size) {
                        preferredQueueSize = -1;
                        break;
                    } else if (!c(preferredQueueSize)) {
                        break;
                    } else {
                        preferredQueueSize++;
                    }
                }
                if (preferredQueueSize != -1) {
                    long j3 = b().endTimeUs;
                    BaseMediaChunk a3 = a(preferredQueueSize);
                    if (this.j.isEmpty()) {
                        this.r = this.s;
                    }
                    this.v = false;
                    this.f.upstreamDiscarded(this.primaryTrackType, a3.startTimeUs, j3);
                }
            }
        }
    }

    public void release() {
        release(null);
    }

    public void seekToUs(long j2) {
        boolean z;
        this.s = j2;
        if (d()) {
            this.r = j2;
            return;
        }
        BaseMediaChunk baseMediaChunk = null;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= this.j.size()) {
                break;
            }
            BaseMediaChunk baseMediaChunk2 = this.j.get(i3);
            int i4 = (baseMediaChunk2.startTimeUs > j2 ? 1 : (baseMediaChunk2.startTimeUs == j2 ? 0 : -1));
            if (i4 == 0 && baseMediaChunk2.clippedStartTimeUs == C.TIME_UNSET) {
                baseMediaChunk = baseMediaChunk2;
                break;
            } else if (i4 > 0) {
                break;
            } else {
                i3++;
            }
        }
        if (baseMediaChunk != null) {
            z = this.l.seekTo(baseMediaChunk.getFirstSampleIndex(0));
        } else {
            z = this.l.seekTo(j2, j2 < getNextLoadPositionUs());
        }
        if (z) {
            this.t = f(this.l.getReadIndex(), 0);
            SampleQueue[] sampleQueueArr = this.m;
            int length = sampleQueueArr.length;
            while (i2 < length) {
                sampleQueueArr[i2].seekTo(j2, true);
                i2++;
            }
            return;
        }
        this.r = j2;
        this.v = false;
        this.j.clear();
        this.t = 0;
        if (this.h.isLoading()) {
            this.l.discardToEnd();
            SampleQueue[] sampleQueueArr2 = this.m;
            int length2 = sampleQueueArr2.length;
            while (i2 < length2) {
                sampleQueueArr2[i2].discardToEnd();
                i2++;
            }
            this.h.cancelLoading();
            return;
        }
        this.h.clearFatalError();
        g();
    }

    public ChunkSampleStream<T>.EmbeddedSampleStream selectEmbeddedTrack(long j2, int i2) {
        for (int i3 = 0; i3 < this.m.length; i3++) {
            if (this.a[i3] == i2) {
                Assertions.checkState(!this.c[i3]);
                this.c[i3] = true;
                this.m[i3].seekTo(j2, true);
                return new EmbeddedSampleStream(this, this.m[i3], i3);
            }
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int skipData(long j2) {
        if (d()) {
            return 0;
        }
        int skipCount = this.l.getSkipCount(j2, this.v);
        BaseMediaChunk baseMediaChunk = this.u;
        if (baseMediaChunk != null) {
            skipCount = Math.min(skipCount, baseMediaChunk.getFirstSampleIndex(0) - this.l.getReadIndex());
        }
        this.l.skip(skipCount);
        e();
        return skipCount;
    }

    public void onLoadCanceled(Chunk chunk, long j2, long j3, boolean z) {
        this.o = null;
        this.u = null;
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk.loadTaskId, chunk.dataSpec, chunk.getUri(), chunk.getResponseHeaders(), j2, j3, chunk.bytesLoaded());
        this.g.onLoadTaskConcluded(chunk.loadTaskId);
        this.f.loadCanceled(loadEventInfo, chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs);
        if (!z) {
            if (d()) {
                g();
            } else if (chunk instanceof BaseMediaChunk) {
                a(this.j.size() - 1);
                if (this.j.isEmpty()) {
                    this.r = this.s;
                }
            }
            this.e.onContinueLoadingRequested(this);
        }
    }

    public void onLoadCompleted(Chunk chunk, long j2, long j3) {
        this.o = null;
        this.d.onChunkLoadCompleted(chunk);
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk.loadTaskId, chunk.dataSpec, chunk.getUri(), chunk.getResponseHeaders(), j2, j3, chunk.bytesLoaded());
        this.g.onLoadTaskConcluded(chunk.loadTaskId);
        this.f.loadCompleted(loadEventInfo, chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs);
        this.e.onContinueLoadingRequested(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0101  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.upstream.Loader.LoadErrorAction onLoadError(com.google.android.exoplayer2.source.chunk.Chunk r36, long r37, long r39, java.io.IOException r41, int r42) {
        /*
        // Method dump skipped, instructions count: 273
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.chunk.ChunkSampleStream.onLoadError(com.google.android.exoplayer2.source.chunk.Chunk, long, long, java.io.IOException, int):com.google.android.exoplayer2.upstream.Loader$LoadErrorAction");
    }

    public void release(@Nullable ReleaseCallback<T> releaseCallback) {
        this.q = releaseCallback;
        this.l.preRelease();
        for (SampleQueue sampleQueue : this.m) {
            sampleQueue.preRelease();
        }
        this.h.release(this);
    }
}
