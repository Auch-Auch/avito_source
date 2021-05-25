package com.google.android.exoplayer2.trackselection;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.Iterables;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class AdaptiveTrackSelection extends BaseTrackSelection {
    public static final float DEFAULT_BANDWIDTH_FRACTION = 0.7f;
    public static final float DEFAULT_BUFFERED_FRACTION_TO_LIVE_EDGE_FOR_QUALITY_INCREASE = 0.75f;
    public static final int DEFAULT_MAX_DURATION_FOR_QUALITY_DECREASE_MS = 25000;
    public static final int DEFAULT_MIN_DURATION_FOR_QUALITY_INCREASE_MS = 10000;
    public static final int DEFAULT_MIN_DURATION_TO_RETAIN_AFTER_DISCARD_MS = 25000;
    public final a d;
    public final long e;
    public final long f;
    public final long g;
    public final float h;
    public final Clock i;
    public float j;
    public int k;
    public int l;
    public long m;
    @Nullable
    public MediaChunk n;

    public static class Factory implements TrackSelection.Factory {
        public final int a;
        public final int b;
        public final int c;
        public final float d;
        public final float e;
        public final Clock f;

        public Factory() {
            this(10000, 25000, 25000, 0.7f, 0.75f, Clock.DEFAULT);
        }

        public AdaptiveTrackSelection createAdaptiveTrackSelection(TrackGroup trackGroup, BandwidthMeter bandwidthMeter, int[] iArr, int i) {
            return new AdaptiveTrackSelection(trackGroup, iArr, new b(bandwidthMeter, this.d, (long) i), (long) this.a, (long) this.b, (long) this.c, this.e, this.f);
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection.Factory
        public final TrackSelection[] createTrackSelections(TrackSelection.Definition[] definitionArr, BandwidthMeter bandwidthMeter) {
            int i;
            double d2;
            TrackSelection[] trackSelectionArr = new TrackSelection[definitionArr.length];
            int i2 = 0;
            for (int i3 = 0; i3 < definitionArr.length; i3++) {
                TrackSelection.Definition definition = definitionArr[i3];
                if (definition != null) {
                    int[] iArr = definition.tracks;
                    if (iArr.length == 1) {
                        trackSelectionArr[i3] = new FixedTrackSelection(definition.group, iArr[0], definition.reason, definition.data);
                        int i4 = definition.group.getFormat(definition.tracks[0]).bitrate;
                        if (i4 != -1) {
                            i2 += i4;
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i5 = 0; i5 < definitionArr.length; i5++) {
                TrackSelection.Definition definition2 = definitionArr[i5];
                if (definition2 != null) {
                    int[] iArr2 = definition2.tracks;
                    if (iArr2.length > 1) {
                        AdaptiveTrackSelection createAdaptiveTrackSelection = createAdaptiveTrackSelection(definition2.group, bandwidthMeter, iArr2, i2);
                        arrayList.add(createAdaptiveTrackSelection);
                        trackSelectionArr[i5] = createAdaptiveTrackSelection;
                    }
                }
            }
            if (arrayList.size() > 1) {
                int size = arrayList.size();
                long[][] jArr = new long[size][];
                for (int i6 = 0; i6 < arrayList.size(); i6++) {
                    AdaptiveTrackSelection adaptiveTrackSelection = (AdaptiveTrackSelection) arrayList.get(i6);
                    jArr[i6] = new long[adaptiveTrackSelection.length()];
                    for (int i7 = 0; i7 < adaptiveTrackSelection.length(); i7++) {
                        jArr[i6][i7] = (long) adaptiveTrackSelection.getFormat((adaptiveTrackSelection.length() - i7) - 1).bitrate;
                    }
                }
                double[][] dArr = new double[size][];
                for (int i8 = 0; i8 < size; i8++) {
                    dArr[i8] = new double[jArr[i8].length];
                    for (int i9 = 0; i9 < jArr[i8].length; i9++) {
                        dArr[i8][i9] = jArr[i8][i9] == -1 ? 0.0d : Math.log((double) jArr[i8][i9]);
                    }
                }
                double[][] dArr2 = new double[size][];
                for (int i10 = 0; i10 < size; i10++) {
                    dArr2[i10] = new double[(dArr[i10].length - 1)];
                    if (dArr2[i10].length != 0) {
                        double d3 = dArr[i10][dArr[i10].length - 1] - dArr[i10][0];
                        int i11 = 0;
                        while (i11 < dArr[i10].length - 1) {
                            int i12 = i11 + 1;
                            double d4 = (dArr[i10][i11] + dArr[i10][i12]) * 0.5d;
                            double[] dArr3 = dArr2[i10];
                            if (d3 == 0.0d) {
                                d2 = 1.0d;
                            } else {
                                d2 = (d4 - dArr[i10][0]) / d3;
                            }
                            dArr3[i11] = d2;
                            i11 = i12;
                        }
                    }
                }
                int i13 = 0;
                for (int i14 = 0; i14 < size; i14++) {
                    i13 += dArr2[i14].length;
                }
                int i15 = i13 + 3;
                int[] iArr3 = new int[3];
                int i16 = 2;
                iArr3[2] = 2;
                iArr3[1] = i15;
                iArr3[0] = size;
                long[][][] jArr2 = (long[][][]) Array.newInstance(long.class, iArr3);
                int[] iArr4 = new int[size];
                AdaptiveTrackSelection.b(jArr2, 1, jArr, iArr4);
                while (true) {
                    i = i15 - 1;
                    if (i16 >= i) {
                        break;
                    }
                    double d5 = Double.MAX_VALUE;
                    int i17 = 0;
                    for (int i18 = 0; i18 < size; i18++) {
                        if (iArr4[i18] + 1 != dArr[i18].length) {
                            double d6 = dArr2[i18][iArr4[i18]];
                            if (d6 < d5) {
                                i17 = i18;
                                d5 = d6;
                            }
                        }
                    }
                    iArr4[i17] = iArr4[i17] + 1;
                    AdaptiveTrackSelection.b(jArr2, i16, jArr, iArr4);
                    i16++;
                }
                for (long[][] jArr3 : jArr2) {
                    int i19 = i15 - 2;
                    jArr3[i][0] = jArr3[i19][0] * 2;
                    jArr3[i][1] = jArr3[i19][1] * 2;
                }
                for (int i20 = 0; i20 < arrayList.size(); i20++) {
                    ((AdaptiveTrackSelection) arrayList.get(i20)).experimentalSetBandwidthAllocationCheckpoints(jArr2[i20]);
                }
            }
            return trackSelectionArr;
        }

        public Factory(int i, int i2, int i3, float f2) {
            this(i, i2, i3, f2, 0.75f, Clock.DEFAULT);
        }

        public Factory(int i, int i2, int i3, float f2, float f3, Clock clock) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = f2;
            this.e = f3;
            this.f = clock;
        }
    }

    public interface a {
    }

    public static final class b implements a {
        public final BandwidthMeter a;
        public final float b;
        public final long c;
        @Nullable
        public long[][] d;

        public b(BandwidthMeter bandwidthMeter, float f, long j) {
            this.a = bandwidthMeter;
            this.b = f;
            this.c = j;
        }
    }

    public AdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, BandwidthMeter bandwidthMeter) {
        this(trackGroup, iArr, bandwidthMeter, 0, 10000, 25000, 25000, 0.7f, 0.75f, Clock.DEFAULT);
    }

    public static void b(long[][][] jArr, int i2, long[][] jArr2, int[] iArr) {
        long j2 = 0;
        for (int i3 = 0; i3 < jArr.length; i3++) {
            jArr[i3][i2][1] = jArr2[i3][iArr[i3]];
            j2 += jArr[i3][i2][1];
        }
        for (long[][] jArr3 : jArr) {
            jArr3[i2][0] = j2;
        }
    }

    public final int a(long j2) {
        long[][] jArr;
        b bVar = (b) this.d;
        long max = Math.max(0L, ((long) (((float) bVar.a.getBitrateEstimate()) * bVar.b)) - bVar.c);
        if (bVar.d != null) {
            int i2 = 1;
            while (true) {
                jArr = bVar.d;
                if (i2 >= jArr.length - 1 || jArr[i2][0] >= max) {
                    break;
                }
                i2++;
            }
            long[] jArr2 = jArr[i2 - 1];
            long[] jArr3 = jArr[i2];
            max = jArr2[1] + ((long) ((((float) (max - jArr2[0])) / ((float) (jArr3[0] - jArr2[0]))) * ((float) (jArr3[1] - jArr2[1]))));
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.length; i4++) {
            if (j2 == Long.MIN_VALUE || !isBlacklisted(i4, j2)) {
                Format format = getFormat(i4);
                if (canSelectFormat(format, format.bitrate, this.j, max)) {
                    return i4;
                }
                i3 = i4;
            }
        }
        return i3;
    }

    public boolean canSelectFormat(Format format, int i2, float f2, long j2) {
        return ((long) Math.round(((float) i2) * f2)) <= j2;
    }

    @Override // com.google.android.exoplayer2.trackselection.BaseTrackSelection, com.google.android.exoplayer2.trackselection.TrackSelection
    @CallSuper
    public void disable() {
        this.n = null;
    }

    @Override // com.google.android.exoplayer2.trackselection.BaseTrackSelection, com.google.android.exoplayer2.trackselection.TrackSelection
    @CallSuper
    public void enable() {
        this.m = C.TIME_UNSET;
        this.n = null;
    }

    @Override // com.google.android.exoplayer2.trackselection.BaseTrackSelection, com.google.android.exoplayer2.trackselection.TrackSelection
    public int evaluateQueueSize(long j2, List<? extends MediaChunk> list) {
        int i2;
        int i3;
        long elapsedRealtime = this.i.elapsedRealtime();
        if (!shouldEvaluateQueueSize(elapsedRealtime, list)) {
            return list.size();
        }
        this.m = elapsedRealtime;
        this.n = list.isEmpty() ? null : (MediaChunk) Iterables.getLast(list);
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        long playoutDurationForMediaDuration = Util.getPlayoutDurationForMediaDuration(((MediaChunk) list.get(size - 1)).startTimeUs - j2, this.j);
        long minDurationToRetainAfterDiscardUs = getMinDurationToRetainAfterDiscardUs();
        if (playoutDurationForMediaDuration < minDurationToRetainAfterDiscardUs) {
            return size;
        }
        Format format = getFormat(a(elapsedRealtime));
        for (int i4 = 0; i4 < size; i4++) {
            MediaChunk mediaChunk = (MediaChunk) list.get(i4);
            Format format2 = mediaChunk.trackFormat;
            if (Util.getPlayoutDurationForMediaDuration(mediaChunk.startTimeUs - j2, this.j) >= minDurationToRetainAfterDiscardUs && format2.bitrate < format.bitrate && (i2 = format2.height) != -1 && i2 < 720 && (i3 = format2.width) != -1 && i3 < 1280 && i2 < format.height) {
                return i4;
            }
        }
        return size;
    }

    public void experimentalSetBandwidthAllocationCheckpoints(long[][] jArr) {
        b bVar = (b) this.d;
        Objects.requireNonNull(bVar);
        Assertions.checkArgument(jArr.length >= 2);
        bVar.d = jArr;
    }

    public long getMinDurationToRetainAfterDiscardUs() {
        return this.g;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public int getSelectedIndex() {
        return this.k;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    @Nullable
    public Object getSelectionData() {
        return null;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public int getSelectionReason() {
        return this.l;
    }

    @Override // com.google.android.exoplayer2.trackselection.BaseTrackSelection, com.google.android.exoplayer2.trackselection.TrackSelection
    public void onPlaybackSpeed(float f2) {
        this.j = f2;
    }

    public boolean shouldEvaluateQueueSize(long j2, List<? extends MediaChunk> list) {
        long j3 = this.m;
        return j3 == C.TIME_UNSET || j2 - j3 >= 1000 || (!list.isEmpty() && !((MediaChunk) Iterables.getLast(list)).equals(this.n));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006c, code lost:
        if (r8 < r10) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0075, code lost:
        if (r8 >= r5.f) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0077, code lost:
        r12 = r1;
     */
    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateSelectedTrack(long r6, long r8, long r10, java.util.List<? extends com.google.android.exoplayer2.source.chunk.MediaChunk> r12, com.google.android.exoplayer2.source.chunk.MediaChunkIterator[] r13) {
        /*
            r5 = this;
            com.google.android.exoplayer2.util.Clock r6 = r5.i
            long r6 = r6.elapsedRealtime()
            int r13 = r5.l
            r0 = 1
            if (r13 != 0) goto L_0x0014
            r5.l = r0
            int r6 = r5.a(r6)
            r5.k = r6
            return
        L_0x0014:
            int r1 = r5.k
            boolean r2 = r12.isEmpty()
            r3 = -1
            if (r2 == 0) goto L_0x001f
            r2 = -1
            goto L_0x002b
        L_0x001f:
            java.lang.Object r2 = com.google.common.collect.Iterables.getLast(r12)
            com.google.android.exoplayer2.source.chunk.MediaChunk r2 = (com.google.android.exoplayer2.source.chunk.MediaChunk) r2
            com.google.android.exoplayer2.Format r2 = r2.trackFormat
            int r2 = r5.indexOf(r2)
        L_0x002b:
            if (r2 == r3) goto L_0x0036
            java.lang.Object r12 = com.google.common.collect.Iterables.getLast(r12)
            com.google.android.exoplayer2.source.chunk.MediaChunk r12 = (com.google.android.exoplayer2.source.chunk.MediaChunk) r12
            int r13 = r12.trackSelectionReason
            r1 = r2
        L_0x0036:
            int r12 = r5.a(r6)
            boolean r6 = r5.isBlacklisted(r1, r6)
            if (r6 != 0) goto L_0x0078
            com.google.android.exoplayer2.Format r6 = r5.getFormat(r1)
            com.google.android.exoplayer2.Format r7 = r5.getFormat(r12)
            int r7 = r7.bitrate
            int r6 = r6.bitrate
            if (r7 <= r6) goto L_0x006f
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x005e
            long r2 = r5.e
            int r4 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x005e
            goto L_0x005f
        L_0x005e:
            r0 = 0
        L_0x005f:
            if (r0 == 0) goto L_0x0068
            float r10 = (float) r10
            float r11 = r5.h
            float r10 = r10 * r11
            long r10 = (long) r10
            goto L_0x006a
        L_0x0068:
            long r10 = r5.e
        L_0x006a:
            int r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r0 >= 0) goto L_0x006f
            goto L_0x0077
        L_0x006f:
            if (r7 >= r6) goto L_0x0078
            long r6 = r5.f
            int r10 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r10 < 0) goto L_0x0078
        L_0x0077:
            r12 = r1
        L_0x0078:
            if (r12 != r1) goto L_0x007b
            goto L_0x007c
        L_0x007b:
            r13 = 3
        L_0x007c:
            r5.l = r13
            r5.k = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.updateSelectedTrack(long, long, long, java.util.List, com.google.android.exoplayer2.source.chunk.MediaChunkIterator[]):void");
    }

    public AdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, BandwidthMeter bandwidthMeter, long j2, long j3, long j4, long j5, float f2, float f3, Clock clock) {
        this(trackGroup, iArr, new b(bandwidthMeter, f2, j2), j3, j4, j5, f3, clock);
    }

    public AdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, a aVar, long j2, long j3, long j4, float f2, Clock clock) {
        super(trackGroup, iArr);
        this.d = aVar;
        this.e = j2 * 1000;
        this.f = j3 * 1000;
        this.g = j4 * 1000;
        this.h = f2;
        this.i = clock;
        this.j = 1.0f;
        this.l = 0;
        this.m = C.TIME_UNSET;
    }
}
