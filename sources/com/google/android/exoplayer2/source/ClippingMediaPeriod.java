package com.google.android.exoplayer2.source;

import a2.j.b.b.z0.m;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.List;
public final class ClippingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
    @Nullable
    public MediaPeriod.Callback a;
    public a[] b = new a[0];
    public long c;
    public long d;
    public long e;
    public final MediaPeriod mediaPeriod;

    public final class a implements SampleStream {
        public final SampleStream a;
        public boolean b;

        public a(SampleStream sampleStream) {
            this.a = sampleStream;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return !ClippingMediaPeriod.this.a() && this.a.isReady();
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() throws IOException {
            this.a.maybeThrowError();
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
            if (ClippingMediaPeriod.this.a()) {
                return -3;
            }
            if (this.b) {
                decoderInputBuffer.setFlags(4);
                return -4;
            }
            int readData = this.a.readData(formatHolder, decoderInputBuffer, z);
            if (readData == -5) {
                Format format = (Format) Assertions.checkNotNull(formatHolder.format);
                int i = format.encoderDelay;
                if (!(i == 0 && format.encoderPadding == 0)) {
                    ClippingMediaPeriod clippingMediaPeriod = ClippingMediaPeriod.this;
                    int i2 = 0;
                    if (clippingMediaPeriod.d != 0) {
                        i = 0;
                    }
                    if (clippingMediaPeriod.e == Long.MIN_VALUE) {
                        i2 = format.encoderPadding;
                    }
                    formatHolder.format = format.buildUpon().setEncoderDelay(i).setEncoderPadding(i2).build();
                }
                return -5;
            }
            ClippingMediaPeriod clippingMediaPeriod2 = ClippingMediaPeriod.this;
            long j = clippingMediaPeriod2.e;
            if (j == Long.MIN_VALUE || ((readData != -4 || decoderInputBuffer.timeUs < j) && (readData != -3 || clippingMediaPeriod2.getBufferedPositionUs() != Long.MIN_VALUE || decoderInputBuffer.waitingForKeys))) {
                return readData;
            }
            decoderInputBuffer.clear();
            decoderInputBuffer.setFlags(4);
            this.b = true;
            return -4;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long j) {
            if (ClippingMediaPeriod.this.a()) {
                return -3;
            }
            return this.a.skipData(j);
        }
    }

    public ClippingMediaPeriod(MediaPeriod mediaPeriod2, boolean z, long j, long j2) {
        this.mediaPeriod = mediaPeriod2;
        this.c = z ? j : C.TIME_UNSET;
        this.d = j;
        this.e = j2;
    }

    public boolean a() {
        return this.c != C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        return this.mediaPeriod.continueLoading(j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j, boolean z) {
        this.mediaPeriod.discardBuffer(j, z);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        long j2 = this.d;
        if (j == j2) {
            return j2;
        }
        long constrainValue = Util.constrainValue(seekParameters.toleranceBeforeUs, 0, j - j2);
        long j3 = seekParameters.toleranceAfterUs;
        long j4 = this.e;
        long constrainValue2 = Util.constrainValue(j3, 0, j4 == Long.MIN_VALUE ? Long.MAX_VALUE : j4 - j);
        if (!(constrainValue == seekParameters.toleranceBeforeUs && constrainValue2 == seekParameters.toleranceAfterUs)) {
            seekParameters = new SeekParameters(constrainValue, constrainValue2);
        }
        return this.mediaPeriod.getAdjustedSeekPositionUs(j, seekParameters);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        long bufferedPositionUs = this.mediaPeriod.getBufferedPositionUs();
        if (bufferedPositionUs != Long.MIN_VALUE) {
            long j = this.e;
            if (j == Long.MIN_VALUE || bufferedPositionUs < j) {
                return bufferedPositionUs;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        long nextLoadPositionUs = this.mediaPeriod.getNextLoadPositionUs();
        if (nextLoadPositionUs != Long.MIN_VALUE) {
            long j = this.e;
            if (j == Long.MIN_VALUE || nextLoadPositionUs < j) {
                return nextLoadPositionUs;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public /* synthetic */ List getStreamKeys(List list) {
        return m.$default$getStreamKeys(this, list);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        return this.mediaPeriod.getTrackGroups();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        return this.mediaPeriod.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws IOException {
        this.mediaPeriod.maybeThrowPrepareError();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public void onPrepared(MediaPeriod mediaPeriod2) {
        ((MediaPeriod.Callback) Assertions.checkNotNull(this.a)).onPrepared(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(MediaPeriod.Callback callback, long j) {
        this.a = callback;
        this.mediaPeriod.prepare(this, j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        if (a()) {
            long j = this.c;
            this.c = C.TIME_UNSET;
            long readDiscontinuity = readDiscontinuity();
            return readDiscontinuity != C.TIME_UNSET ? readDiscontinuity : j;
        }
        long readDiscontinuity2 = this.mediaPeriod.readDiscontinuity();
        if (readDiscontinuity2 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        boolean z = true;
        Assertions.checkState(readDiscontinuity2 >= this.d);
        long j2 = this.e;
        if (j2 != Long.MIN_VALUE && readDiscontinuity2 > j2) {
            z = false;
        }
        Assertions.checkState(z);
        return readDiscontinuity2;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j) {
        this.mediaPeriod.reevaluateBuffer(j);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        if (r0 > r7) goto L_0x0034;
     */
    @Override // com.google.android.exoplayer2.source.MediaPeriod
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long seekToUs(long r7) {
        /*
            r6 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6.c = r0
            com.google.android.exoplayer2.source.ClippingMediaPeriod$a[] r0 = r6.b
            int r1 = r0.length
            r2 = 0
            r3 = 0
        L_0x000c:
            if (r3 >= r1) goto L_0x0017
            r4 = r0[r3]
            if (r4 == 0) goto L_0x0014
            r4.b = r2
        L_0x0014:
            int r3 = r3 + 1
            goto L_0x000c
        L_0x0017:
            com.google.android.exoplayer2.source.MediaPeriod r0 = r6.mediaPeriod
            long r0 = r0.seekToUs(r7)
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x0033
            long r7 = r6.d
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 < 0) goto L_0x0034
            long r7 = r6.e
            r3 = -9223372036854775808
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0033
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 > 0) goto L_0x0034
        L_0x0033:
            r2 = 1
        L_0x0034:
            com.google.android.exoplayer2.util.Assertions.checkState(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.ClippingMediaPeriod.seekToUs(long):long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0085, code lost:
        if (r1 > r5) goto L_0x0088;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008f  */
    @Override // com.google.android.exoplayer2.source.MediaPeriod
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long selectTracks(com.google.android.exoplayer2.trackselection.TrackSelection[] r16, boolean[] r17, com.google.android.exoplayer2.source.SampleStream[] r18, boolean[] r19, long r20) {
        /*
            r15 = this;
            r0 = r15
            r8 = r16
            r9 = r18
            int r1 = r9.length
            com.google.android.exoplayer2.source.ClippingMediaPeriod$a[] r1 = new com.google.android.exoplayer2.source.ClippingMediaPeriod.a[r1]
            r0.b = r1
            int r1 = r9.length
            com.google.android.exoplayer2.source.SampleStream[] r10 = new com.google.android.exoplayer2.source.SampleStream[r1]
            r11 = 0
            r1 = 0
        L_0x000f:
            int r2 = r9.length
            r12 = 0
            if (r1 >= r2) goto L_0x0028
            com.google.android.exoplayer2.source.ClippingMediaPeriod$a[] r2 = r0.b
            r3 = r9[r1]
            com.google.android.exoplayer2.source.ClippingMediaPeriod$a r3 = (com.google.android.exoplayer2.source.ClippingMediaPeriod.a) r3
            r2[r1] = r3
            r3 = r2[r1]
            if (r3 == 0) goto L_0x0023
            r2 = r2[r1]
            com.google.android.exoplayer2.source.SampleStream r12 = r2.a
        L_0x0023:
            r10[r1] = r12
            int r1 = r1 + 1
            goto L_0x000f
        L_0x0028:
            com.google.android.exoplayer2.source.MediaPeriod r1 = r0.mediaPeriod
            r2 = r16
            r3 = r17
            r4 = r10
            r5 = r19
            r6 = r20
            long r1 = r1.selectTracks(r2, r3, r4, r5, r6)
            boolean r3 = r15.a()
            r4 = 1
            if (r3 == 0) goto L_0x006a
            long r5 = r0.d
            int r3 = (r20 > r5 ? 1 : (r20 == r5 ? 0 : -1))
            if (r3 != 0) goto L_0x006a
            r13 = 0
            int r3 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r3 == 0) goto L_0x0065
            int r3 = r8.length
            r5 = 0
        L_0x004c:
            if (r5 >= r3) goto L_0x0065
            r6 = r8[r5]
            if (r6 == 0) goto L_0x0062
            com.google.android.exoplayer2.Format r6 = r6.getSelectedFormat()
            java.lang.String r7 = r6.sampleMimeType
            java.lang.String r6 = r6.codecs
            boolean r6 = com.google.android.exoplayer2.util.MimeTypes.allSamplesAreSyncSamples(r7, r6)
            if (r6 != 0) goto L_0x0062
            r3 = 1
            goto L_0x0066
        L_0x0062:
            int r5 = r5 + 1
            goto L_0x004c
        L_0x0065:
            r3 = 0
        L_0x0066:
            if (r3 == 0) goto L_0x006a
            r5 = r1
            goto L_0x006f
        L_0x006a:
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x006f:
            r0.c = r5
            int r3 = (r1 > r20 ? 1 : (r1 == r20 ? 0 : -1))
            if (r3 == 0) goto L_0x0089
            long r5 = r0.d
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 < 0) goto L_0x0088
            long r5 = r0.e
            r7 = -9223372036854775808
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x0089
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 > 0) goto L_0x0088
            goto L_0x0089
        L_0x0088:
            r4 = 0
        L_0x0089:
            com.google.android.exoplayer2.util.Assertions.checkState(r4)
        L_0x008c:
            int r3 = r9.length
            if (r11 >= r3) goto L_0x00b8
            r3 = r10[r11]
            if (r3 != 0) goto L_0x0098
            com.google.android.exoplayer2.source.ClippingMediaPeriod$a[] r3 = r0.b
            r3[r11] = r12
            goto L_0x00af
        L_0x0098:
            com.google.android.exoplayer2.source.ClippingMediaPeriod$a[] r3 = r0.b
            r4 = r3[r11]
            if (r4 == 0) goto L_0x00a6
            r4 = r3[r11]
            com.google.android.exoplayer2.source.SampleStream r4 = r4.a
            r5 = r10[r11]
            if (r4 == r5) goto L_0x00af
        L_0x00a6:
            com.google.android.exoplayer2.source.ClippingMediaPeriod$a r4 = new com.google.android.exoplayer2.source.ClippingMediaPeriod$a
            r5 = r10[r11]
            r4.<init>(r5)
            r3[r11] = r4
        L_0x00af:
            com.google.android.exoplayer2.source.ClippingMediaPeriod$a[] r3 = r0.b
            r3 = r3[r11]
            r9[r11] = r3
            int r11 = r11 + 1
            goto L_0x008c
        L_0x00b8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.ClippingMediaPeriod.selectTracks(com.google.android.exoplayer2.trackselection.TrackSelection[], boolean[], com.google.android.exoplayer2.source.SampleStream[], boolean[], long):long");
    }

    public void updateClipping(long j, long j2) {
        this.d = j;
        this.e = j2;
    }

    public void onContinueLoadingRequested(MediaPeriod mediaPeriod2) {
        ((MediaPeriod.Callback) Assertions.checkNotNull(this.a)).onContinueLoadingRequested(this);
    }
}
