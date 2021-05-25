package com.google.android.exoplayer2.source;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.util.Assertions;
public final class SinglePeriodTimeline extends Timeline {
    public static final Object m = new Object();
    public static final MediaItem n = new MediaItem.Builder().setMediaId("com.google.android.exoplayer2.source.SinglePeriodTimeline").setUri(Uri.EMPTY).build();
    public final long a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final long f;
    public final long g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    @Nullable
    public final Object k;
    @Nullable
    public final MediaItem l;

    @Deprecated
    public SinglePeriodTimeline(long j2, boolean z, boolean z2, boolean z3, @Nullable Object obj, @Nullable Object obj2) {
        this(j2, j2, 0, 0, z, z2, z3, obj, obj2);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getIndexOfPeriod(Object obj) {
        return m.equals(obj) ? 0 : -1;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public Timeline.Period getPeriod(int i2, Timeline.Period period, boolean z) {
        Assertions.checkIndex(i2, 0, 1);
        return period.set(null, z ? m : null, 0, this.d, -this.f);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getPeriodCount() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public Object getUidOfPeriod(int i2) {
        Assertions.checkIndex(i2, 0, 1);
        return m;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0027, code lost:
        if (r1 > r5) goto L_0x0020;
     */
    @Override // com.google.android.exoplayer2.Timeline
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.Timeline.Window getWindow(int r25, com.google.android.exoplayer2.Timeline.Window r26, long r27) {
        /*
            r24 = this;
            r0 = r24
            r1 = 0
            r2 = 1
            r3 = r25
            com.google.android.exoplayer2.util.Assertions.checkIndex(r3, r1, r2)
            long r1 = r0.g
            boolean r14 = r0.i
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r14 == 0) goto L_0x002a
            r5 = 0
            int r7 = (r27 > r5 ? 1 : (r27 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x002a
            long r5 = r0.e
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 != 0) goto L_0x0023
        L_0x0020:
            r16 = r3
            goto L_0x002c
        L_0x0023:
            long r1 = r1 + r27
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x002a
            goto L_0x0020
        L_0x002a:
            r16 = r1
        L_0x002c:
            java.lang.Object r4 = com.google.android.exoplayer2.Timeline.Window.SINGLE_WINDOW_UID
            com.google.android.exoplayer2.MediaItem r5 = r0.l
            java.lang.Object r6 = r0.k
            long r7 = r0.a
            long r9 = r0.b
            long r11 = r0.c
            boolean r13 = r0.h
            boolean r15 = r0.j
            long r1 = r0.e
            r18 = r1
            r20 = 0
            r21 = 0
            long r1 = r0.f
            r22 = r1
            r3 = r26
            com.google.android.exoplayer2.Timeline$Window r1 = r3.set(r4, r5, r6, r7, r9, r11, r13, r14, r15, r16, r18, r20, r21, r22)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.SinglePeriodTimeline.getWindow(int, com.google.android.exoplayer2.Timeline$Window, long):com.google.android.exoplayer2.Timeline$Window");
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getWindowCount() {
        return 1;
    }

    public SinglePeriodTimeline(long j2, boolean z, boolean z2, boolean z3, @Nullable Object obj, MediaItem mediaItem) {
        this(j2, j2, 0L, 0L, z, z2, z3, obj, mediaItem);
    }

    @Deprecated
    public SinglePeriodTimeline(long j2, long j3, long j4, long j5, boolean z, boolean z2, boolean z3, @Nullable Object obj, @Nullable Object obj2) {
        this((long) C.TIME_UNSET, (long) C.TIME_UNSET, (long) C.TIME_UNSET, j2, j3, j4, j5, z, z2, z3, obj, obj2);
    }

    public SinglePeriodTimeline(long j2, long j3, long j4, long j5, boolean z, boolean z2, boolean z3, @Nullable Object obj, MediaItem mediaItem) {
        this((long) C.TIME_UNSET, (long) C.TIME_UNSET, (long) C.TIME_UNSET, j2, j3, j4, j5, z, z2, z3, obj, mediaItem);
    }

    @Deprecated
    public SinglePeriodTimeline(long j2, long j3, long j4, long j5, long j6, long j7, long j8, boolean z, boolean z2, boolean z3, @Nullable Object obj, @Nullable Object obj2) {
        this(j2, j3, j4, j5, j6, j7, j8, z, z2, z3, obj, n.buildUpon().setTag(obj2).build());
    }

    public SinglePeriodTimeline(long j2, long j3, long j4, long j5, long j6, long j7, long j8, boolean z, boolean z2, boolean z3, @Nullable Object obj, MediaItem mediaItem) {
        this.a = j2;
        this.b = j3;
        this.c = j4;
        this.d = j5;
        this.e = j6;
        this.f = j7;
        this.g = j8;
        this.h = z;
        this.i = z2;
        this.j = z3;
        this.k = obj;
        this.l = (MediaItem) Assertions.checkNotNull(mediaItem);
    }
}
