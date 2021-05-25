package a2.j.b.b.z0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
public final class q implements MediaPeriod, MediaPeriod.Callback {
    public final MediaPeriod[] a;
    public final IdentityHashMap<SampleStream, Integer> b;
    public final CompositeSequenceableLoaderFactory c;
    public final ArrayList<MediaPeriod> d = new ArrayList<>();
    @Nullable
    public MediaPeriod.Callback e;
    @Nullable
    public TrackGroupArray f;
    public MediaPeriod[] g;
    public SequenceableLoader h;

    public static final class a implements MediaPeriod, MediaPeriod.Callback {
        public final MediaPeriod a;
        public final long b;
        public MediaPeriod.Callback c;

        public a(MediaPeriod mediaPeriod, long j) {
            this.a = mediaPeriod;
            this.b = j;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public boolean continueLoading(long j) {
            return this.a.continueLoading(j - this.b);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public void discardBuffer(long j, boolean z) {
            this.a.discardBuffer(j - this.b, z);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
            return this.a.getAdjustedSeekPositionUs(j - this.b, seekParameters) + this.b;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public long getBufferedPositionUs() {
            long bufferedPositionUs = this.a.getBufferedPositionUs();
            if (bufferedPositionUs == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            return this.b + bufferedPositionUs;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public long getNextLoadPositionUs() {
            long nextLoadPositionUs = this.a.getNextLoadPositionUs();
            if (nextLoadPositionUs == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            return this.b + nextLoadPositionUs;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public List<StreamKey> getStreamKeys(List<TrackSelection> list) {
            return this.a.getStreamKeys(list);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public TrackGroupArray getTrackGroups() {
            return this.a.getTrackGroups();
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public boolean isLoading() {
            return this.a.isLoading();
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public void maybeThrowPrepareError() throws IOException {
            this.a.maybeThrowPrepareError();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.exoplayer2.source.SequenceableLoader] */
        @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
        public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
            ((MediaPeriod.Callback) Assertions.checkNotNull(this.c)).onContinueLoadingRequested(this);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
        public void onPrepared(MediaPeriod mediaPeriod) {
            ((MediaPeriod.Callback) Assertions.checkNotNull(this.c)).onPrepared(this);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public void prepare(MediaPeriod.Callback callback, long j) {
            this.c = callback;
            this.a.prepare(this, j - this.b);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long readDiscontinuity() {
            long readDiscontinuity = this.a.readDiscontinuity();
            if (readDiscontinuity == C.TIME_UNSET) {
                return C.TIME_UNSET;
            }
            return this.b + readDiscontinuity;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public void reevaluateBuffer(long j) {
            this.a.reevaluateBuffer(j - this.b);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long seekToUs(long j) {
            return this.a.seekToUs(j - this.b) + this.b;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
            SampleStream[] sampleStreamArr2 = new SampleStream[sampleStreamArr.length];
            int i = 0;
            while (true) {
                SampleStream sampleStream = null;
                if (i >= sampleStreamArr.length) {
                    break;
                }
                b bVar = (b) sampleStreamArr[i];
                if (bVar != null) {
                    sampleStream = bVar.a;
                }
                sampleStreamArr2[i] = sampleStream;
                i++;
            }
            long selectTracks = this.a.selectTracks(trackSelectionArr, zArr, sampleStreamArr2, zArr2, j - this.b);
            for (int i2 = 0; i2 < sampleStreamArr.length; i2++) {
                SampleStream sampleStream2 = sampleStreamArr2[i2];
                if (sampleStream2 == null) {
                    sampleStreamArr[i2] = null;
                } else if (sampleStreamArr[i2] == null || ((b) sampleStreamArr[i2]).a != sampleStream2) {
                    sampleStreamArr[i2] = new b(sampleStream2, this.b);
                }
            }
            return selectTracks + this.b;
        }
    }

    public static final class b implements SampleStream {
        public final SampleStream a;
        public final long b;

        public b(SampleStream sampleStream, long j) {
            this.a = sampleStream;
            this.b = j;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return this.a.isReady();
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() throws IOException {
            this.a.maybeThrowError();
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
            int readData = this.a.readData(formatHolder, decoderInputBuffer, z);
            if (readData == -4) {
                decoderInputBuffer.timeUs = Math.max(0L, decoderInputBuffer.timeUs + this.b);
            }
            return readData;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long j) {
            return this.a.skipData(j - this.b);
        }
    }

    public q(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, long[] jArr, MediaPeriod... mediaPeriodArr) {
        this.c = compositeSequenceableLoaderFactory;
        this.a = mediaPeriodArr;
        this.h = compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(new SequenceableLoader[0]);
        this.b = new IdentityHashMap<>();
        this.g = new MediaPeriod[0];
        for (int i = 0; i < mediaPeriodArr.length; i++) {
            if (jArr[i] != 0) {
                this.a[i] = new a(mediaPeriodArr[i], jArr[i]);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        if (this.d.isEmpty()) {
            return this.h.continueLoading(j);
        }
        int size = this.d.size();
        for (int i = 0; i < size; i++) {
            this.d.get(i).continueLoading(j);
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j, boolean z) {
        for (MediaPeriod mediaPeriod : this.g) {
            mediaPeriod.discardBuffer(j, z);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        MediaPeriod[] mediaPeriodArr = this.g;
        return (mediaPeriodArr.length > 0 ? mediaPeriodArr[0] : this.a[0]).getAdjustedSeekPositionUs(j, seekParameters);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        return this.h.getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        return this.h.getNextLoadPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public /* synthetic */ List getStreamKeys(List list) {
        return m.$default$getStreamKeys(this, list);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        return (TrackGroupArray) Assertions.checkNotNull(this.f);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        return this.h.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws IOException {
        for (MediaPeriod mediaPeriod : this.a) {
            mediaPeriod.maybeThrowPrepareError();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.exoplayer2.source.SequenceableLoader] */
    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) Assertions.checkNotNull(this.e)).onContinueLoadingRequested(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public void onPrepared(MediaPeriod mediaPeriod) {
        this.d.remove(mediaPeriod);
        if (this.d.isEmpty()) {
            int i = 0;
            for (MediaPeriod mediaPeriod2 : this.a) {
                i += mediaPeriod2.getTrackGroups().length;
            }
            TrackGroup[] trackGroupArr = new TrackGroup[i];
            int i2 = 0;
            for (MediaPeriod mediaPeriod3 : this.a) {
                TrackGroupArray trackGroups = mediaPeriod3.getTrackGroups();
                int i3 = trackGroups.length;
                int i4 = 0;
                while (i4 < i3) {
                    trackGroupArr[i2] = trackGroups.get(i4);
                    i4++;
                    i2++;
                }
            }
            this.f = new TrackGroupArray(trackGroupArr);
            ((MediaPeriod.Callback) Assertions.checkNotNull(this.e)).onPrepared(this);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(MediaPeriod.Callback callback, long j) {
        this.e = callback;
        Collections.addAll(this.d, this.a);
        for (MediaPeriod mediaPeriod : this.a) {
            mediaPeriod.prepare(this, j);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        MediaPeriod[] mediaPeriodArr = this.g;
        long j = -9223372036854775807L;
        for (MediaPeriod mediaPeriod : mediaPeriodArr) {
            long readDiscontinuity = mediaPeriod.readDiscontinuity();
            if (readDiscontinuity != C.TIME_UNSET) {
                if (j == C.TIME_UNSET) {
                    MediaPeriod[] mediaPeriodArr2 = this.g;
                    for (MediaPeriod mediaPeriod2 : mediaPeriodArr2) {
                        if (mediaPeriod2 == mediaPeriod) {
                            break;
                        } else if (mediaPeriod2.seekToUs(readDiscontinuity) != readDiscontinuity) {
                            throw new IllegalStateException("Unexpected child seekToUs result.");
                        }
                    }
                    j = readDiscontinuity;
                } else if (readDiscontinuity != j) {
                    throw new IllegalStateException("Conflicting discontinuities.");
                }
            } else if (!(j == C.TIME_UNSET || mediaPeriod.seekToUs(j) == j)) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j) {
        this.h.reevaluateBuffer(j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j) {
        long seekToUs = this.g[0].seekToUs(j);
        int i = 1;
        while (true) {
            MediaPeriod[] mediaPeriodArr = this.g;
            if (i >= mediaPeriodArr.length) {
                return seekToUs;
            }
            if (mediaPeriodArr[i].seekToUs(seekToUs) == seekToUs) {
                i++;
            } else {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        int i;
        int[] iArr = new int[trackSelectionArr.length];
        int[] iArr2 = new int[trackSelectionArr.length];
        for (int i2 = 0; i2 < trackSelectionArr.length; i2++) {
            Integer num = sampleStreamArr[i2] == null ? null : this.b.get(sampleStreamArr[i2]);
            if (num == null) {
                i = -1;
            } else {
                i = num.intValue();
            }
            iArr[i2] = i;
            iArr2[i2] = -1;
            if (trackSelectionArr[i2] != null) {
                TrackGroup trackGroup = trackSelectionArr[i2].getTrackGroup();
                int i3 = 0;
                while (true) {
                    MediaPeriod[] mediaPeriodArr = this.a;
                    if (i3 >= mediaPeriodArr.length) {
                        break;
                    } else if (mediaPeriodArr[i3].getTrackGroups().indexOf(trackGroup) != -1) {
                        iArr2[i2] = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        }
        this.b.clear();
        int length = trackSelectionArr.length;
        SampleStream[] sampleStreamArr2 = new SampleStream[length];
        SampleStream[] sampleStreamArr3 = new SampleStream[trackSelectionArr.length];
        TrackSelection[] trackSelectionArr2 = new TrackSelection[trackSelectionArr.length];
        ArrayList arrayList = new ArrayList(this.a.length);
        long j2 = j;
        int i4 = 0;
        while (i4 < this.a.length) {
            for (int i5 = 0; i5 < trackSelectionArr.length; i5++) {
                sampleStreamArr3[i5] = iArr[i5] == i4 ? sampleStreamArr[i5] : null;
                trackSelectionArr2[i5] = iArr2[i5] == i4 ? trackSelectionArr[i5] : null;
            }
            long selectTracks = this.a[i4].selectTracks(trackSelectionArr2, zArr, sampleStreamArr3, zArr2, j2);
            if (i4 == 0) {
                j2 = selectTracks;
            } else if (selectTracks != j2) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z = false;
            for (int i6 = 0; i6 < trackSelectionArr.length; i6++) {
                boolean z2 = true;
                if (iArr2[i6] == i4) {
                    sampleStreamArr2[i6] = sampleStreamArr3[i6];
                    this.b.put((SampleStream) Assertions.checkNotNull(sampleStreamArr3[i6]), Integer.valueOf(i4));
                    z = true;
                } else if (iArr[i6] == i4) {
                    if (sampleStreamArr3[i6] != null) {
                        z2 = false;
                    }
                    Assertions.checkState(z2);
                }
            }
            if (z) {
                arrayList.add(this.a[i4]);
            }
            i4++;
            arrayList = arrayList;
            trackSelectionArr2 = trackSelectionArr2;
        }
        System.arraycopy(sampleStreamArr2, 0, sampleStreamArr, 0, length);
        MediaPeriod[] mediaPeriodArr2 = (MediaPeriod[]) arrayList.toArray(new MediaPeriod[0]);
        this.g = mediaPeriodArr2;
        this.h = this.c.createCompositeSequenceableLoader(mediaPeriodArr2);
        return j2;
    }
}
