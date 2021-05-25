package a2.j.b.b;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.AbstractConcatenatedTimeline;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.MediaSourceList;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ClippingMediaPeriod;
import com.google.android.exoplayer2.source.EmptySampleStream;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import java.util.Objects;
public final class f0 {
    public final MediaPeriod a;
    public final Object b;
    public final SampleStream[] c;
    public boolean d;
    public boolean e;
    public g0 f;
    public boolean g;
    public final boolean[] h;
    public final RendererCapabilities[] i;
    public final TrackSelector j;
    public final MediaSourceList k;
    @Nullable
    public f0 l;
    public TrackGroupArray m = TrackGroupArray.EMPTY;
    public TrackSelectorResult n;
    public long o;

    public f0(RendererCapabilities[] rendererCapabilitiesArr, long j2, TrackSelector trackSelector, Allocator allocator, MediaSourceList mediaSourceList, g0 g0Var, TrackSelectorResult trackSelectorResult) {
        this.i = rendererCapabilitiesArr;
        this.o = j2;
        this.j = trackSelector;
        this.k = mediaSourceList;
        MediaSource.MediaPeriodId mediaPeriodId = g0Var.a;
        this.b = mediaPeriodId.periodUid;
        this.f = g0Var;
        this.n = trackSelectorResult;
        this.c = new SampleStream[rendererCapabilitiesArr.length];
        this.h = new boolean[rendererCapabilitiesArr.length];
        long j3 = g0Var.b;
        long j4 = g0Var.d;
        Objects.requireNonNull(mediaSourceList);
        Object childTimelineUidFromConcatenatedUid = AbstractConcatenatedTimeline.getChildTimelineUidFromConcatenatedUid(mediaPeriodId.periodUid);
        MediaSource.MediaPeriodId copyWithPeriodUid = mediaPeriodId.copyWithPeriodUid(AbstractConcatenatedTimeline.getChildPeriodUidFromConcatenatedUid(mediaPeriodId.periodUid));
        MediaSourceList.c cVar = (MediaSourceList.c) Assertions.checkNotNull(mediaSourceList.c.get(childTimelineUidFromConcatenatedUid));
        mediaSourceList.h.add(cVar);
        MediaSourceList.b bVar = mediaSourceList.g.get(cVar);
        if (bVar != null) {
            bVar.a.enable(bVar.b);
        }
        cVar.c.add(copyWithPeriodUid);
        MediaPeriod createPeriod = cVar.a.createPeriod(copyWithPeriodUid, allocator, j3);
        mediaSourceList.b.put(createPeriod, cVar);
        mediaSourceList.d();
        if (!(j4 == C.TIME_UNSET || j4 == Long.MIN_VALUE)) {
            createPeriod = new ClippingMediaPeriod(createPeriod, true, 0, j4);
        }
        this.a = createPeriod;
    }

    public long a(TrackSelectorResult trackSelectorResult, long j2, boolean z, boolean[] zArr) {
        int i2 = 0;
        while (true) {
            boolean z2 = true;
            if (i2 >= trackSelectorResult.length) {
                break;
            }
            boolean[] zArr2 = this.h;
            if (z || !trackSelectorResult.isEquivalent(this.n, i2)) {
                z2 = false;
            }
            zArr2[i2] = z2;
            i2++;
        }
        SampleStream[] sampleStreamArr = this.c;
        int i3 = 0;
        while (true) {
            RendererCapabilities[] rendererCapabilitiesArr = this.i;
            if (i3 >= rendererCapabilitiesArr.length) {
                break;
            }
            if (rendererCapabilitiesArr[i3].getTrackType() == 6) {
                sampleStreamArr[i3] = null;
            }
            i3++;
        }
        b();
        this.n = trackSelectorResult;
        c();
        TrackSelectionArray trackSelectionArray = trackSelectorResult.selections;
        long selectTracks = this.a.selectTracks(trackSelectionArray.getAll(), this.h, this.c, zArr, j2);
        SampleStream[] sampleStreamArr2 = this.c;
        int i4 = 0;
        while (true) {
            RendererCapabilities[] rendererCapabilitiesArr2 = this.i;
            if (i4 >= rendererCapabilitiesArr2.length) {
                break;
            }
            if (rendererCapabilitiesArr2[i4].getTrackType() == 6 && this.n.isRendererEnabled(i4)) {
                sampleStreamArr2[i4] = new EmptySampleStream();
            }
            i4++;
        }
        this.e = false;
        int i5 = 0;
        while (true) {
            SampleStream[] sampleStreamArr3 = this.c;
            if (i5 >= sampleStreamArr3.length) {
                return selectTracks;
            }
            if (sampleStreamArr3[i5] != null) {
                Assertions.checkState(trackSelectorResult.isRendererEnabled(i5));
                if (this.i[i5].getTrackType() != 6) {
                    this.e = true;
                }
            } else {
                Assertions.checkState(trackSelectionArray.get(i5) == null);
            }
            i5++;
        }
    }

    public final void b() {
        if (g()) {
            int i2 = 0;
            while (true) {
                TrackSelectorResult trackSelectorResult = this.n;
                if (i2 < trackSelectorResult.length) {
                    boolean isRendererEnabled = trackSelectorResult.isRendererEnabled(i2);
                    TrackSelection trackSelection = this.n.selections.get(i2);
                    if (isRendererEnabled && trackSelection != null) {
                        trackSelection.disable();
                    }
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public final void c() {
        if (g()) {
            int i2 = 0;
            while (true) {
                TrackSelectorResult trackSelectorResult = this.n;
                if (i2 < trackSelectorResult.length) {
                    boolean isRendererEnabled = trackSelectorResult.isRendererEnabled(i2);
                    TrackSelection trackSelection = this.n.selections.get(i2);
                    if (isRendererEnabled && trackSelection != null) {
                        trackSelection.enable();
                    }
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public long d() {
        if (!this.d) {
            return this.f.b;
        }
        long bufferedPositionUs = this.e ? this.a.getBufferedPositionUs() : Long.MIN_VALUE;
        return bufferedPositionUs == Long.MIN_VALUE ? this.f.e : bufferedPositionUs;
    }

    public long e() {
        return this.f.b + this.o;
    }

    public boolean f() {
        return this.d && (!this.e || this.a.getBufferedPositionUs() == Long.MIN_VALUE);
    }

    public final boolean g() {
        return this.l == null;
    }

    public void h() {
        b();
        long j2 = this.f.d;
        MediaSourceList mediaSourceList = this.k;
        MediaPeriod mediaPeriod = this.a;
        if (j2 == C.TIME_UNSET || j2 == Long.MIN_VALUE) {
            mediaSourceList.h(mediaPeriod);
            return;
        }
        try {
            mediaSourceList.h(((ClippingMediaPeriod) mediaPeriod).mediaPeriod);
        } catch (RuntimeException e2) {
            Log.e("MediaPeriodHolder", "Period release failed.", e2);
        }
    }

    public TrackSelectorResult i(float f2, Timeline timeline) throws ExoPlaybackException {
        TrackSelectorResult selectTracks = this.j.selectTracks(this.i, this.m, this.f.a, timeline);
        TrackSelection[] all = selectTracks.selections.getAll();
        for (TrackSelection trackSelection : all) {
            if (trackSelection != null) {
                trackSelection.onPlaybackSpeed(f2);
            }
        }
        return selectTracks;
    }
}
