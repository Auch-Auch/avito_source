package a2.j.b.b;

import android.os.Handler;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.common.collect.ImmutableList;
public final class h0 {
    public final Timeline.Period a = new Timeline.Period();
    public final Timeline.Window b = new Timeline.Window();
    @Nullable
    public final AnalyticsCollector c;
    public final Handler d;
    public long e;
    public int f;
    public boolean g;
    @Nullable
    public f0 h;
    @Nullable
    public f0 i;
    @Nullable
    public f0 j;
    public int k;
    @Nullable
    public Object l;
    public long m;

    public h0(@Nullable AnalyticsCollector analyticsCollector, Handler handler) {
        this.c = analyticsCollector;
        this.d = handler;
    }

    public static MediaSource.MediaPeriodId o(Timeline timeline, Object obj, long j2, long j3, Timeline.Period period) {
        timeline.getPeriodByUid(obj, period);
        int adGroupIndexForPositionUs = period.getAdGroupIndexForPositionUs(j2);
        if (adGroupIndexForPositionUs == -1) {
            return new MediaSource.MediaPeriodId(obj, j3, period.getAdGroupIndexAfterPositionUs(j2));
        }
        return new MediaSource.MediaPeriodId(obj, adGroupIndexForPositionUs, period.getFirstAdIndexToPlay(adGroupIndexForPositionUs), j3);
    }

    @Nullable
    public f0 a() {
        f0 f0Var = this.h;
        if (f0Var == null) {
            return null;
        }
        if (f0Var == this.i) {
            this.i = f0Var.l;
        }
        f0Var.h();
        int i2 = this.k - 1;
        this.k = i2;
        if (i2 == 0) {
            this.j = null;
            f0 f0Var2 = this.h;
            this.l = f0Var2.b;
            this.m = f0Var2.f.a.windowSequenceNumber;
        }
        this.h = this.h.l;
        k();
        return this.h;
    }

    public void b() {
        if (this.k != 0) {
            f0 f0Var = (f0) Assertions.checkStateNotNull(this.h);
            this.l = f0Var.b;
            this.m = f0Var.f.a.windowSequenceNumber;
            while (f0Var != null) {
                f0Var.h();
                f0Var = f0Var.l;
            }
            this.h = null;
            this.j = null;
            this.i = null;
            this.k = 0;
            k();
        }
    }

    @Nullable
    public final g0 c(Timeline timeline, f0 f0Var, long j2) {
        long j3;
        g0 g0Var = f0Var.f;
        long j4 = (f0Var.o + g0Var.e) - j2;
        if (g0Var.f) {
            long j5 = 0;
            int nextPeriodIndex = timeline.getNextPeriodIndex(timeline.getIndexOfPeriod(g0Var.a.periodUid), this.a, this.b, this.f, this.g);
            if (nextPeriodIndex == -1) {
                return null;
            }
            int i2 = timeline.getPeriod(nextPeriodIndex, this.a, true).windowIndex;
            Object obj = this.a.uid;
            long j6 = g0Var.a.windowSequenceNumber;
            if (timeline.getWindow(i2, this.b).firstPeriodIndex == nextPeriodIndex) {
                Pair<Object, Long> periodPosition = timeline.getPeriodPosition(this.b, this.a, i2, C.TIME_UNSET, Math.max(0L, j4));
                if (periodPosition == null) {
                    return null;
                }
                obj = periodPosition.first;
                long longValue = ((Long) periodPosition.second).longValue();
                f0 f0Var2 = f0Var.l;
                if (f0Var2 == null || !f0Var2.b.equals(obj)) {
                    j6 = this.e;
                    this.e = 1 + j6;
                } else {
                    j6 = f0Var2.f.a.windowSequenceNumber;
                }
                j3 = longValue;
                j5 = C.TIME_UNSET;
            } else {
                j3 = 0;
            }
            return d(timeline, o(timeline, obj, j3, j6, this.a), j5, j3);
        }
        MediaSource.MediaPeriodId mediaPeriodId = g0Var.a;
        timeline.getPeriodByUid(mediaPeriodId.periodUid, this.a);
        if (mediaPeriodId.isAd()) {
            int i3 = mediaPeriodId.adGroupIndex;
            int adCountInAdGroup = this.a.getAdCountInAdGroup(i3);
            if (adCountInAdGroup == -1) {
                return null;
            }
            int nextAdIndexToPlay = this.a.getNextAdIndexToPlay(i3, mediaPeriodId.adIndexInAdGroup);
            if (nextAdIndexToPlay >= adCountInAdGroup) {
                long j7 = g0Var.c;
                if (j7 == C.TIME_UNSET) {
                    Timeline.Window window = this.b;
                    Timeline.Period period = this.a;
                    Pair<Object, Long> periodPosition2 = timeline.getPeriodPosition(window, period, period.windowIndex, C.TIME_UNSET, Math.max(0L, j4));
                    if (periodPosition2 == null) {
                        return null;
                    }
                    j7 = ((Long) periodPosition2.second).longValue();
                }
                return f(timeline, mediaPeriodId.periodUid, j7, g0Var.c, mediaPeriodId.windowSequenceNumber);
            } else if (!this.a.isAdAvailable(i3, nextAdIndexToPlay)) {
                return null;
            } else {
                return e(timeline, mediaPeriodId.periodUid, i3, nextAdIndexToPlay, g0Var.c, mediaPeriodId.windowSequenceNumber);
            }
        } else {
            int adGroupIndexForPositionUs = this.a.getAdGroupIndexForPositionUs(g0Var.d);
            if (adGroupIndexForPositionUs == -1) {
                Object obj2 = mediaPeriodId.periodUid;
                long j8 = g0Var.e;
                return f(timeline, obj2, j8, j8, mediaPeriodId.windowSequenceNumber);
            }
            int firstAdIndexToPlay = this.a.getFirstAdIndexToPlay(adGroupIndexForPositionUs);
            if (!this.a.isAdAvailable(adGroupIndexForPositionUs, firstAdIndexToPlay)) {
                return null;
            }
            return e(timeline, mediaPeriodId.periodUid, adGroupIndexForPositionUs, firstAdIndexToPlay, g0Var.e, mediaPeriodId.windowSequenceNumber);
        }
    }

    @Nullable
    public final g0 d(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, long j2, long j3) {
        timeline.getPeriodByUid(mediaPeriodId.periodUid, this.a);
        if (!mediaPeriodId.isAd()) {
            return f(timeline, mediaPeriodId.periodUid, j3, j2, mediaPeriodId.windowSequenceNumber);
        }
        if (!this.a.isAdAvailable(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup)) {
            return null;
        }
        return e(timeline, mediaPeriodId.periodUid, mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup, j2, mediaPeriodId.windowSequenceNumber);
    }

    public final g0 e(Timeline timeline, Object obj, int i2, int i3, long j2, long j3) {
        MediaSource.MediaPeriodId mediaPeriodId = new MediaSource.MediaPeriodId(obj, i2, i3, j3);
        long adDurationUs = timeline.getPeriodByUid(mediaPeriodId.periodUid, this.a).getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup);
        long adResumePositionUs = i3 == this.a.getFirstAdIndexToPlay(i2) ? this.a.getAdResumePositionUs() : 0;
        return new g0(mediaPeriodId, (adDurationUs == C.TIME_UNSET || adResumePositionUs < adDurationUs) ? adResumePositionUs : Math.max(0L, adDurationUs - 1), j2, C.TIME_UNSET, adDurationUs, false, false, false);
    }

    public final g0 f(Timeline timeline, Object obj, long j2, long j3, long j4) {
        long j5;
        long j6 = j2;
        timeline.getPeriodByUid(obj, this.a);
        int adGroupIndexAfterPositionUs = this.a.getAdGroupIndexAfterPositionUs(j6);
        MediaSource.MediaPeriodId mediaPeriodId = new MediaSource.MediaPeriodId(obj, j4, adGroupIndexAfterPositionUs);
        boolean h2 = h(mediaPeriodId);
        boolean j7 = j(timeline, mediaPeriodId);
        boolean i2 = i(timeline, mediaPeriodId, h2);
        long adGroupTimeUs = adGroupIndexAfterPositionUs != -1 ? this.a.getAdGroupTimeUs(adGroupIndexAfterPositionUs) : -9223372036854775807L;
        if (adGroupTimeUs == C.TIME_UNSET || adGroupTimeUs == Long.MIN_VALUE) {
            j5 = this.a.durationUs;
        } else {
            j5 = adGroupTimeUs;
        }
        if (j5 != C.TIME_UNSET && j6 >= j5) {
            j6 = Math.max(0L, j5 - 1);
        }
        return new g0(mediaPeriodId, j6, j3, adGroupTimeUs, j5, h2, j7, i2);
    }

    public g0 g(Timeline timeline, g0 g0Var) {
        long j2;
        MediaSource.MediaPeriodId mediaPeriodId = g0Var.a;
        boolean h2 = h(mediaPeriodId);
        boolean j3 = j(timeline, mediaPeriodId);
        boolean i2 = i(timeline, mediaPeriodId, h2);
        timeline.getPeriodByUid(g0Var.a.periodUid, this.a);
        if (mediaPeriodId.isAd()) {
            j2 = this.a.getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup);
        } else {
            j2 = g0Var.d;
            if (j2 == C.TIME_UNSET || j2 == Long.MIN_VALUE) {
                j2 = this.a.getDurationUs();
            }
        }
        return new g0(mediaPeriodId, g0Var.b, g0Var.c, g0Var.d, j2, h2, j3, i2);
    }

    public final boolean h(MediaSource.MediaPeriodId mediaPeriodId) {
        return !mediaPeriodId.isAd() && mediaPeriodId.nextAdGroupIndex == -1;
    }

    public final boolean i(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, boolean z) {
        int indexOfPeriod = timeline.getIndexOfPeriod(mediaPeriodId.periodUid);
        return !timeline.getWindow(timeline.getPeriod(indexOfPeriod, this.a).windowIndex, this.b).isDynamic && timeline.isLastPeriod(indexOfPeriod, this.a, this.b, this.f, this.g) && z;
    }

    public final boolean j(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        if (!h(mediaPeriodId)) {
            return false;
        }
        int i2 = timeline.getPeriodByUid(mediaPeriodId.periodUid, this.a).windowIndex;
        if (timeline.getWindow(i2, this.b).lastPeriodIndex == timeline.getIndexOfPeriod(mediaPeriodId.periodUid)) {
            return true;
        }
        return false;
    }

    public final void k() {
        if (this.c != null) {
            ImmutableList.Builder builder = ImmutableList.builder();
            for (f0 f0Var = this.h; f0Var != null; f0Var = f0Var.l) {
                builder.add((ImmutableList.Builder) f0Var.f.a);
            }
            f0 f0Var2 = this.i;
            this.d.post(new Runnable(builder, f0Var2 == null ? null : f0Var2.f.a) { // from class: a2.j.b.b.y
                public final /* synthetic */ ImmutableList.Builder b;
                public final /* synthetic */ MediaSource.MediaPeriodId c;

                {
                    this.b = r2;
                    this.c = r3;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    h0 h0Var = h0.this;
                    ImmutableList.Builder builder2 = this.b;
                    h0Var.c.updateMediaPeriodQueueInfo(builder2.build(), this.c);
                }
            });
        }
    }

    public void l(long j2) {
        f0 f0Var = this.j;
        if (f0Var != null) {
            Assertions.checkState(f0Var.g());
            if (f0Var.d) {
                f0Var.a.reevaluateBuffer(j2 - f0Var.o);
            }
        }
    }

    public boolean m(f0 f0Var) {
        boolean z = false;
        Assertions.checkState(f0Var != null);
        if (f0Var.equals(this.j)) {
            return false;
        }
        this.j = f0Var;
        while (true) {
            f0Var = f0Var.l;
            if (f0Var == null) {
                break;
            }
            if (f0Var == this.i) {
                this.i = this.h;
                z = true;
            }
            f0Var.h();
            this.k--;
        }
        f0 f0Var2 = this.j;
        if (f0Var2.l != null) {
            f0Var2.b();
            f0Var2.l = null;
            f0Var2.c();
        }
        k();
        return z;
    }

    public MediaSource.MediaPeriodId n(Timeline timeline, Object obj, long j2) {
        long j3;
        int indexOfPeriod;
        int i2 = timeline.getPeriodByUid(obj, this.a).windowIndex;
        Object obj2 = this.l;
        if (obj2 == null || (indexOfPeriod = timeline.getIndexOfPeriod(obj2)) == -1 || timeline.getPeriod(indexOfPeriod, this.a).windowIndex != i2) {
            f0 f0Var = this.h;
            while (true) {
                if (f0Var == null) {
                    f0 f0Var2 = this.h;
                    while (true) {
                        if (f0Var2 != null) {
                            int indexOfPeriod2 = timeline.getIndexOfPeriod(f0Var2.b);
                            if (indexOfPeriod2 != -1 && timeline.getPeriod(indexOfPeriod2, this.a).windowIndex == i2) {
                                j3 = f0Var2.f.a.windowSequenceNumber;
                                break;
                            }
                            f0Var2 = f0Var2.l;
                        } else {
                            j3 = this.e;
                            this.e = 1 + j3;
                            if (this.h == null) {
                                this.l = obj;
                                this.m = j3;
                            }
                        }
                    }
                } else if (f0Var.b.equals(obj)) {
                    j3 = f0Var.f.a.windowSequenceNumber;
                    break;
                } else {
                    f0Var = f0Var.l;
                }
            }
        } else {
            j3 = this.m;
        }
        return o(timeline, obj, j2, j3, this.a);
    }

    public final boolean p(Timeline timeline) {
        f0 f0Var;
        f0 f0Var2 = this.h;
        if (f0Var2 == null) {
            return true;
        }
        int indexOfPeriod = timeline.getIndexOfPeriod(f0Var2.b);
        while (true) {
            indexOfPeriod = timeline.getNextPeriodIndex(indexOfPeriod, this.a, this.b, this.f, this.g);
            while (true) {
                f0Var = f0Var2.l;
                if (f0Var == null || f0Var2.f.f) {
                    break;
                }
                f0Var2 = f0Var;
            }
            if (indexOfPeriod == -1 || f0Var == null || timeline.getIndexOfPeriod(f0Var.b) != indexOfPeriod) {
                break;
            }
            f0Var2 = f0Var;
        }
        boolean m2 = m(f0Var2);
        f0Var2.f = g(timeline, f0Var2.f);
        return !m2;
    }

    public boolean q(Timeline timeline, long j2, long j3) {
        g0 g0Var;
        g0 g0Var2;
        long j4;
        boolean m2;
        Timeline timeline2 = timeline;
        f0 f0Var = this.h;
        f0 f0Var2 = null;
        while (f0Var != null) {
            g0 g0Var3 = f0Var.f;
            if (f0Var2 == null) {
                g0Var = g(timeline2, g0Var3);
            } else {
                g0 c2 = c(timeline2, f0Var2, j2);
                if (c2 == null) {
                    m2 = m(f0Var2);
                } else {
                    if (!(g0Var3.b == c2.b && g0Var3.a.equals(c2.a))) {
                        m2 = m(f0Var2);
                    } else {
                        g0Var = c2;
                    }
                }
                return !m2;
            }
            long j5 = g0Var3.c;
            if (j5 == g0Var.c) {
                g0Var2 = g0Var;
            } else {
                g0Var2 = new g0(g0Var.a, g0Var.b, j5, g0Var.d, g0Var.e, g0Var.f, g0Var.g, g0Var.h);
            }
            f0Var.f = g0Var2;
            long j6 = g0Var3.e;
            long j7 = g0Var.e;
            if (!(j6 == C.TIME_UNSET || j6 == j7)) {
                if (j7 == C.TIME_UNSET) {
                    j4 = Long.MAX_VALUE;
                } else {
                    j4 = f0Var.o + j7;
                }
                return !m(f0Var) && !(f0Var == this.i && ((j3 > Long.MIN_VALUE ? 1 : (j3 == Long.MIN_VALUE ? 0 : -1)) == 0 || (j3 > j4 ? 1 : (j3 == j4 ? 0 : -1)) >= 0));
            }
            f0Var2 = f0Var;
            f0Var = f0Var.l;
            timeline2 = timeline;
        }
        return true;
    }
}
