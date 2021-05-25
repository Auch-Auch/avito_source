package a2.j.b.b.z0.x;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.chunk.ChunkSampleStream;
import com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public final class b implements MediaPeriod, SequenceableLoader.Callback<ChunkSampleStream<SsChunkSource>> {
    public final SsChunkSource.Factory a;
    @Nullable
    public final TransferListener b;
    public final LoaderErrorThrower c;
    public final DrmSessionManager<?> d;
    public final LoadErrorHandlingPolicy e;
    public final MediaSourceEventListener.EventDispatcher f;
    public final Allocator g;
    public final TrackGroupArray h;
    public final CompositeSequenceableLoaderFactory i;
    @Nullable
    public MediaPeriod.Callback j;
    public SsManifest k;
    public ChunkSampleStream<SsChunkSource>[] l;
    public SequenceableLoader m;
    public boolean n;

    public b(SsManifest ssManifest, SsChunkSource.Factory factory, @Nullable TransferListener transferListener, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, DrmSessionManager<?> drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher, LoaderErrorThrower loaderErrorThrower, Allocator allocator) {
        this.k = ssManifest;
        this.a = factory;
        this.b = transferListener;
        this.c = loaderErrorThrower;
        this.d = drmSessionManager;
        this.e = loadErrorHandlingPolicy;
        this.f = eventDispatcher;
        this.g = allocator;
        this.i = compositeSequenceableLoaderFactory;
        this.h = b(ssManifest, drmSessionManager);
        ChunkSampleStream<SsChunkSource>[] chunkSampleStreamArr = new ChunkSampleStream[0];
        this.l = chunkSampleStreamArr;
        this.m = compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(chunkSampleStreamArr);
        eventDispatcher.mediaPeriodCreated();
    }

    public static TrackGroupArray b(SsManifest ssManifest, DrmSessionManager<?> drmSessionManager) {
        TrackGroup[] trackGroupArr = new TrackGroup[ssManifest.streamElements.length];
        int i2 = 0;
        while (true) {
            SsManifest.StreamElement[] streamElementArr = ssManifest.streamElements;
            if (i2 >= streamElementArr.length) {
                return new TrackGroupArray(trackGroupArr);
            }
            Format[] formatArr = streamElementArr[i2].formats;
            Format[] formatArr2 = new Format[formatArr.length];
            for (int i3 = 0; i3 < formatArr.length; i3++) {
                Format format = formatArr[i3];
                DrmInitData drmInitData = format.drmInitData;
                if (drmInitData != null) {
                    format = format.copyWithExoMediaCryptoType(drmSessionManager.getExoMediaCryptoType(drmInitData));
                }
                formatArr2[i3] = format;
            }
            trackGroupArr[i2] = new TrackGroup(formatArr2);
            i2++;
        }
    }

    public final ChunkSampleStream<SsChunkSource> a(TrackSelection trackSelection, long j2) {
        int indexOf = this.h.indexOf(trackSelection.getTrackGroup());
        return new ChunkSampleStream<>(this.k.streamElements[indexOf].type, null, null, this.a.createChunkSource(this.c, this.k, indexOf, trackSelection, this.b), this, this.g, j2, this.d, this.e, this.f);
    }

    public void c() {
        for (ChunkSampleStream<SsChunkSource> chunkSampleStream : this.l) {
            chunkSampleStream.release();
        }
        this.j = null;
        this.f.mediaPeriodReleased();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j2) {
        return this.m.continueLoading(j2);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j2, boolean z) {
        for (ChunkSampleStream<SsChunkSource> chunkSampleStream : this.l) {
            chunkSampleStream.discardBuffer(j2, z);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long j2, SeekParameters seekParameters) {
        ChunkSampleStream<SsChunkSource>[] chunkSampleStreamArr = this.l;
        for (ChunkSampleStream<SsChunkSource> chunkSampleStream : chunkSampleStreamArr) {
            if (chunkSampleStream.primaryTrackType == 2) {
                return chunkSampleStream.getAdjustedSeekPositionUs(j2, seekParameters);
            }
        }
        return j2;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        return this.m.getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        return this.m.getNextLoadPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public List<StreamKey> getStreamKeys(List<TrackSelection> list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            TrackSelection trackSelection = list.get(i2);
            int indexOf = this.h.indexOf(trackSelection.getTrackGroup());
            for (int i3 = 0; i3 < trackSelection.length(); i3++) {
                arrayList.add(new StreamKey(indexOf, trackSelection.getIndexInTrackGroup(i3)));
            }
        }
        return arrayList;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        return this.h;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        return this.m.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws IOException {
        this.c.maybeThrowError();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.exoplayer2.source.SequenceableLoader] */
    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(ChunkSampleStream<SsChunkSource> chunkSampleStream) {
        this.j.onContinueLoadingRequested(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(MediaPeriod.Callback callback, long j2) {
        this.j = callback;
        callback.onPrepared(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        if (this.n) {
            return C.TIME_UNSET;
        }
        this.f.readingStarted();
        this.n = true;
        return C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j2) {
        this.m.reevaluateBuffer(j2);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j2) {
        for (ChunkSampleStream<SsChunkSource> chunkSampleStream : this.l) {
            chunkSampleStream.seekToUs(j2);
        }
        return j2;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < trackSelectionArr.length; i2++) {
            if (sampleStreamArr[i2] != null) {
                ChunkSampleStream chunkSampleStream = (ChunkSampleStream) sampleStreamArr[i2];
                if (trackSelectionArr[i2] == null || !zArr[i2]) {
                    chunkSampleStream.release();
                    sampleStreamArr[i2] = null;
                } else {
                    ((SsChunkSource) chunkSampleStream.getChunkSource()).updateTrackSelection(trackSelectionArr[i2]);
                    arrayList.add(chunkSampleStream);
                }
            }
            if (sampleStreamArr[i2] == null && trackSelectionArr[i2] != null) {
                ChunkSampleStream<SsChunkSource> a3 = a(trackSelectionArr[i2], j2);
                arrayList.add(a3);
                sampleStreamArr[i2] = a3;
                zArr2[i2] = true;
            }
        }
        ChunkSampleStream<SsChunkSource>[] chunkSampleStreamArr = new ChunkSampleStream[arrayList.size()];
        this.l = chunkSampleStreamArr;
        arrayList.toArray(chunkSampleStreamArr);
        this.m = this.i.createCompositeSequenceableLoader(this.l);
        return j2;
    }
}
