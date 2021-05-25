package com.google.android.exoplayer2.source;

import a2.j.b.b.z0.m;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.List;
public final class MaskingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
    public final Allocator a;
    @Nullable
    public MediaPeriod b;
    @Nullable
    public MediaPeriod.Callback c;
    public long d;
    @Nullable
    public PrepareListener e;
    public boolean f;
    public long g = C.TIME_UNSET;
    public final MediaSource.MediaPeriodId id;
    public final MediaSource mediaSource;

    public interface PrepareListener {
        void onPrepareComplete(MediaSource.MediaPeriodId mediaPeriodId);

        void onPrepareError(MediaSource.MediaPeriodId mediaPeriodId, IOException iOException);
    }

    public MaskingMediaPeriod(MediaSource mediaSource2, MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        this.id = mediaPeriodId;
        this.a = allocator;
        this.mediaSource = mediaSource2;
        this.d = j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        MediaPeriod mediaPeriod = this.b;
        return mediaPeriod != null && mediaPeriod.continueLoading(j);
    }

    public void createPeriod(MediaSource.MediaPeriodId mediaPeriodId) {
        long j = this.d;
        long j2 = this.g;
        if (j2 != C.TIME_UNSET) {
            j = j2;
        }
        MediaPeriod createPeriod = this.mediaSource.createPeriod(mediaPeriodId, this.a, j);
        this.b = createPeriod;
        if (this.c != null) {
            createPeriod.prepare(this, j);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j, boolean z) {
        ((MediaPeriod) Util.castNonNull(this.b)).discardBuffer(j, z);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        return ((MediaPeriod) Util.castNonNull(this.b)).getAdjustedSeekPositionUs(j, seekParameters);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        return ((MediaPeriod) Util.castNonNull(this.b)).getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        return ((MediaPeriod) Util.castNonNull(this.b)).getNextLoadPositionUs();
    }

    public long getPreparePositionOverrideUs() {
        return this.g;
    }

    public long getPreparePositionUs() {
        return this.d;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public /* synthetic */ List getStreamKeys(List list) {
        return m.$default$getStreamKeys(this, list);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        return ((MediaPeriod) Util.castNonNull(this.b)).getTrackGroups();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        MediaPeriod mediaPeriod = this.b;
        return mediaPeriod != null && mediaPeriod.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws IOException {
        try {
            MediaPeriod mediaPeriod = this.b;
            if (mediaPeriod != null) {
                mediaPeriod.maybeThrowPrepareError();
            } else {
                this.mediaSource.maybeThrowSourceInfoRefreshError();
            }
        } catch (IOException e2) {
            PrepareListener prepareListener = this.e;
            if (prepareListener == null) {
                throw e2;
            } else if (!this.f) {
                this.f = true;
                prepareListener.onPrepareError(this.id, e2);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public void onPrepared(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) Util.castNonNull(this.c)).onPrepared(this);
        PrepareListener prepareListener = this.e;
        if (prepareListener != null) {
            prepareListener.onPrepareComplete(this.id);
        }
    }

    public void overridePreparePositionUs(long j) {
        this.g = j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(MediaPeriod.Callback callback, long j) {
        this.c = callback;
        MediaPeriod mediaPeriod = this.b;
        if (mediaPeriod != null) {
            long j2 = this.d;
            long j3 = this.g;
            if (j3 != C.TIME_UNSET) {
                j2 = j3;
            }
            mediaPeriod.prepare(this, j2);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        return ((MediaPeriod) Util.castNonNull(this.b)).readDiscontinuity();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j) {
        ((MediaPeriod) Util.castNonNull(this.b)).reevaluateBuffer(j);
    }

    public void releasePeriod() {
        MediaPeriod mediaPeriod = this.b;
        if (mediaPeriod != null) {
            this.mediaSource.releasePeriod(mediaPeriod);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j) {
        return ((MediaPeriod) Util.castNonNull(this.b)).seekToUs(j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        long j2;
        long j3 = this.g;
        if (j3 == C.TIME_UNSET || j != this.d) {
            j2 = j;
        } else {
            this.g = C.TIME_UNSET;
            j2 = j3;
        }
        return ((MediaPeriod) Util.castNonNull(this.b)).selectTracks(trackSelectionArr, zArr, sampleStreamArr, zArr2, j2);
    }

    public void setPrepareListener(PrepareListener prepareListener) {
        this.e = prepareListener;
    }

    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) Util.castNonNull(this.c)).onContinueLoadingRequested(this);
    }
}
