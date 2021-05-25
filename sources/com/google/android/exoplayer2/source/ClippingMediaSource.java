package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
public final class ClippingMediaSource extends CompositeMediaSource<Void> {
    public final MediaSource j;
    public final long k;
    public final long l;
    public final boolean m;
    public final boolean n;
    public final boolean o;
    public final ArrayList<ClippingMediaPeriod> p;
    public final Timeline.Window q;
    @Nullable
    public a r;
    @Nullable
    public IllegalClippingException s;
    public long t;
    public long u;

    public static final class IllegalClippingException extends IOException {
        public static final int REASON_INVALID_PERIOD_COUNT = 0;
        public static final int REASON_NOT_SEEKABLE_TO_START = 1;
        public static final int REASON_START_EXCEEDS_END = 2;
        public final int reason;

        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface Reason {
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public IllegalClippingException(int r3) {
            /*
                r2 = this;
                java.lang.String r0 = "Illegal clipping: "
                java.lang.StringBuilder r0 = a2.b.a.a.a.L(r0)
                if (r3 == 0) goto L_0x0017
                r1 = 1
                if (r3 == r1) goto L_0x0014
                r1 = 2
                if (r3 == r1) goto L_0x0011
                java.lang.String r1 = "unknown"
                goto L_0x0019
            L_0x0011:
                java.lang.String r1 = "start exceeds end"
                goto L_0x0019
            L_0x0014:
                java.lang.String r1 = "not seekable to start"
                goto L_0x0019
            L_0x0017:
                java.lang.String r1 = "invalid period count"
            L_0x0019:
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r2.<init>(r0)
                r2.reason = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.ClippingMediaSource.IllegalClippingException.<init>(int):void");
        }
    }

    public static final class a extends ForwardingTimeline {
        public final long a;
        public final long b;
        public final long c;
        public final boolean d;

        public a(Timeline timeline, long j, long j2) throws IllegalClippingException {
            super(timeline);
            boolean z = true;
            if (timeline.getPeriodCount() == 1) {
                Timeline.Window window = timeline.getWindow(0, new Timeline.Window());
                long max = Math.max(0L, j);
                if (window.isPlaceholder || max == 0 || window.isSeekable) {
                    long max2 = j2 == Long.MIN_VALUE ? window.durationUs : Math.max(0L, j2);
                    long j3 = window.durationUs;
                    long j4 = C.TIME_UNSET;
                    int i = (j3 > C.TIME_UNSET ? 1 : (j3 == C.TIME_UNSET ? 0 : -1));
                    if (i != 0) {
                        max2 = max2 > j3 ? j3 : max2;
                        if (max > max2) {
                            throw new IllegalClippingException(2);
                        }
                    }
                    this.a = max;
                    this.b = max2;
                    int i2 = (max2 > C.TIME_UNSET ? 1 : (max2 == C.TIME_UNSET ? 0 : -1));
                    this.c = i2 != 0 ? max2 - max : j4;
                    if (!window.isDynamic || (i2 != 0 && (i == 0 || max2 != j3))) {
                        z = false;
                    }
                    this.d = z;
                    return;
                }
                throw new IllegalClippingException(1);
            }
            throw new IllegalClippingException(0);
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
            this.timeline.getPeriod(0, period, z);
            long positionInWindowUs = period.getPositionInWindowUs() - this.a;
            long j = this.c;
            return period.set(period.id, period.uid, 0, j == C.TIME_UNSET ? -9223372036854775807L : j - positionInWindowUs, positionInWindowUs);
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public Timeline.Window getWindow(int i, Timeline.Window window, long j) {
            this.timeline.getWindow(0, window, 0);
            long j2 = window.positionInFirstPeriodUs;
            long j3 = this.a;
            window.positionInFirstPeriodUs = j2 + j3;
            window.durationUs = this.c;
            window.isDynamic = this.d;
            long j4 = window.defaultPositionUs;
            if (j4 != C.TIME_UNSET) {
                long max = Math.max(j4, j3);
                window.defaultPositionUs = max;
                long j5 = this.b;
                if (j5 != C.TIME_UNSET) {
                    max = Math.min(max, j5);
                }
                window.defaultPositionUs = max;
                window.defaultPositionUs = max - this.a;
            }
            long usToMs = C.usToMs(this.a);
            long j6 = window.presentationStartTimeMs;
            if (j6 != C.TIME_UNSET) {
                window.presentationStartTimeMs = j6 + usToMs;
            }
            long j7 = window.windowStartTimeMs;
            if (j7 != C.TIME_UNSET) {
                window.windowStartTimeMs = j7 + usToMs;
            }
            return window;
        }
    }

    public ClippingMediaSource(MediaSource mediaSource, long j2, long j3) {
        this(mediaSource, j2, j3, true, false, false);
    }

    public final void a(Timeline timeline) {
        long j2;
        timeline.getWindow(0, this.q);
        long positionInFirstPeriodUs = this.q.getPositionInFirstPeriodUs();
        long j3 = Long.MIN_VALUE;
        if (this.r == null || this.p.isEmpty() || this.n) {
            long j4 = this.k;
            long j5 = this.l;
            if (this.o) {
                long defaultPositionUs = this.q.getDefaultPositionUs();
                j4 += defaultPositionUs;
                j5 += defaultPositionUs;
            }
            this.t = positionInFirstPeriodUs + j4;
            if (this.l != Long.MIN_VALUE) {
                j3 = positionInFirstPeriodUs + j5;
            }
            this.u = j3;
            int size = this.p.size();
            for (int i = 0; i < size; i++) {
                this.p.get(i).updateClipping(this.t, this.u);
            }
            j2 = j4;
            j3 = j5;
        } else {
            long j6 = this.t - positionInFirstPeriodUs;
            if (this.l != Long.MIN_VALUE) {
                j3 = this.u - positionInFirstPeriodUs;
            }
            j2 = j6;
        }
        try {
            a aVar = new a(timeline, j2, j3);
            this.r = aVar;
            refreshSourceInfo(aVar);
        } catch (IllegalClippingException e) {
            this.s = e;
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        ClippingMediaPeriod clippingMediaPeriod = new ClippingMediaPeriod(this.j.createPeriod(mediaPeriodId, allocator, j2), this.m, this.t, this.u);
        this.p.add(clippingMediaPeriod);
        return clippingMediaPeriod;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaItem getMediaItem() {
        return this.j.getMediaItem();
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource, com.google.android.exoplayer2.source.MediaSource
    @Nullable
    @Deprecated
    public Object getTag() {
        return this.j.getTag();
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        IllegalClippingException illegalClippingException = this.s;
        if (illegalClippingException == null) {
            super.maybeThrowSourceInfoRefreshError();
            return;
        }
        throw illegalClippingException;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        prepareChildSource(null, this.j);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        Assertions.checkState(this.p.remove(mediaPeriod));
        this.j.releasePeriod(((ClippingMediaPeriod) mediaPeriod).mediaPeriod);
        if (this.p.isEmpty() && !this.n) {
            a(((a) Assertions.checkNotNull(this.r)).timeline);
        }
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        super.releaseSourceInternal();
        this.s = null;
        this.r = null;
    }

    public ClippingMediaSource(MediaSource mediaSource, long j2) {
        this(mediaSource, 0, j2, true, false, true);
    }

    public long getMediaTimeForChildMediaTime(Void r7, long j2) {
        if (j2 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        long usToMs = C.usToMs(this.k);
        long max = Math.max(0L, j2 - usToMs);
        long j3 = this.l;
        return j3 != Long.MIN_VALUE ? Math.min(C.usToMs(j3) - usToMs, max) : max;
    }

    public void onChildSourceInfoRefreshed(Void r1, MediaSource mediaSource, Timeline timeline) {
        if (this.s == null) {
            a(timeline);
        }
    }

    public ClippingMediaSource(MediaSource mediaSource, long j2, long j3, boolean z, boolean z2, boolean z3) {
        Assertions.checkArgument(j2 >= 0);
        this.j = (MediaSource) Assertions.checkNotNull(mediaSource);
        this.k = j2;
        this.l = j3;
        this.m = z;
        this.n = z2;
        this.o = z3;
        this.p = new ArrayList<>();
        this.q = new Timeline.Window();
    }
}
