package a2.j.b.b;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
public final class j0 {
    public static final MediaSource.MediaPeriodId q = new MediaSource.MediaPeriodId(new Object());
    public final Timeline a;
    public final MediaSource.MediaPeriodId b;
    public final long c;
    public final int d;
    @Nullable
    public final ExoPlaybackException e;
    public final boolean f;
    public final TrackGroupArray g;
    public final TrackSelectorResult h;
    public final MediaSource.MediaPeriodId i;
    public final boolean j;
    public final int k;
    public final PlaybackParameters l;
    public final boolean m;
    public volatile long n;
    public volatile long o;
    public volatile long p;

    public j0(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, long j2, int i2, @Nullable ExoPlaybackException exoPlaybackException, boolean z, TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult, MediaSource.MediaPeriodId mediaPeriodId2, boolean z2, int i3, PlaybackParameters playbackParameters, long j3, long j4, long j5, boolean z3) {
        this.a = timeline;
        this.b = mediaPeriodId;
        this.c = j2;
        this.d = i2;
        this.e = exoPlaybackException;
        this.f = z;
        this.g = trackGroupArray;
        this.h = trackSelectorResult;
        this.i = mediaPeriodId2;
        this.j = z2;
        this.k = i3;
        this.l = playbackParameters;
        this.n = j3;
        this.o = j4;
        this.p = j5;
        this.m = z3;
    }

    public static j0 i(TrackSelectorResult trackSelectorResult) {
        Timeline timeline = Timeline.EMPTY;
        MediaSource.MediaPeriodId mediaPeriodId = q;
        return new j0(timeline, mediaPeriodId, C.TIME_UNSET, 1, null, false, TrackGroupArray.EMPTY, trackSelectorResult, mediaPeriodId, false, 0, PlaybackParameters.DEFAULT, 0, 0, 0, false);
    }

    @CheckResult
    public j0 a(MediaSource.MediaPeriodId mediaPeriodId) {
        return new j0(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, mediaPeriodId, this.j, this.k, this.l, this.n, this.o, this.p, this.m);
    }

    @CheckResult
    public j0 b(MediaSource.MediaPeriodId mediaPeriodId, long j2, long j3, long j4, TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult) {
        return new j0(this.a, mediaPeriodId, j3, this.d, this.e, this.f, trackGroupArray, trackSelectorResult, this.i, this.j, this.k, this.l, this.n, j4, j2, this.m);
    }

    @CheckResult
    public j0 c(boolean z) {
        return new j0(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.n, this.o, this.p, z);
    }

    @CheckResult
    public j0 d(boolean z, int i2) {
        return new j0(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, z, i2, this.l, this.n, this.o, this.p, this.m);
    }

    @CheckResult
    public j0 e(@Nullable ExoPlaybackException exoPlaybackException) {
        return new j0(this.a, this.b, this.c, this.d, exoPlaybackException, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.n, this.o, this.p, this.m);
    }

    @CheckResult
    public j0 f(PlaybackParameters playbackParameters) {
        return new j0(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, playbackParameters, this.n, this.o, this.p, this.m);
    }

    @CheckResult
    public j0 g(int i2) {
        return new j0(this.a, this.b, this.c, i2, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.n, this.o, this.p, this.m);
    }

    @CheckResult
    public j0 h(Timeline timeline) {
        return new j0(timeline, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.n, this.o, this.p, this.m);
    }
}
