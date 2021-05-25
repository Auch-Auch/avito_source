package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.Util;
public class ConstantBitrateSeekMap implements SeekMap {
    public final long a;
    public final long b;
    public final int c;
    public final long d;
    public final int e;
    public final long f;

    public ConstantBitrateSeekMap(long j, long j2, int i, int i2) {
        this.a = j;
        this.b = j2;
        this.c = i2 == -1 ? 1 : i2;
        this.e = i;
        if (j == -1) {
            this.d = -1;
            this.f = C.TIME_UNSET;
            return;
        }
        this.d = j - j2;
        this.f = a(j, j2, i);
    }

    public static long a(long j, long j2, int i) {
        return ((Math.max(0L, j - j2) * 8) * 1000000) / ((long) i);
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.f;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public SeekMap.SeekPoints getSeekPoints(long j) {
        long j2 = this.d;
        if (j2 == -1) {
            return new SeekMap.SeekPoints(new SeekPoint(0, this.b));
        }
        long j3 = (long) this.c;
        long constrainValue = this.b + Util.constrainValue((((((long) this.e) * j) / 8000000) / j3) * j3, 0, j2 - j3);
        long timeUsAtPosition = getTimeUsAtPosition(constrainValue);
        SeekPoint seekPoint = new SeekPoint(timeUsAtPosition, constrainValue);
        if (timeUsAtPosition < j) {
            int i = this.c;
            if (((long) i) + constrainValue < this.a) {
                long j4 = constrainValue + ((long) i);
                return new SeekMap.SeekPoints(seekPoint, new SeekPoint(getTimeUsAtPosition(j4), j4));
            }
        }
        return new SeekMap.SeekPoints(seekPoint);
    }

    public long getTimeUsAtPosition(long j) {
        return a(j, this.b, this.e);
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return this.d != -1;
    }
}
