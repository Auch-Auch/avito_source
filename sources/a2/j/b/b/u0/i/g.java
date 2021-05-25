package a2.j.b.b.u0.i;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.mp3.Seeker;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
public final class g implements Seeker {
    public final long a;
    public final int b;
    public final long c;
    public final long d;
    public final long e;
    @Nullable
    public final long[] f;

    public g(long j, int i, long j2, long j3, @Nullable long[] jArr) {
        this.a = j;
        this.b = i;
        this.c = j2;
        this.f = jArr;
        this.d = j3;
        this.e = j3 != -1 ? j + j3 : -1;
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Seeker
    public long getDataEndPosition() {
        return this.e;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.c;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public SeekMap.SeekPoints getSeekPoints(long j) {
        double d2;
        if (!isSeekable()) {
            return new SeekMap.SeekPoints(new SeekPoint(0, this.a + ((long) this.b)));
        }
        long constrainValue = Util.constrainValue(j, 0, this.c);
        double d3 = (((double) constrainValue) * 100.0d) / ((double) this.c);
        double d4 = 0.0d;
        if (d3 > 0.0d) {
            if (d3 >= 100.0d) {
                d4 = 256.0d;
            } else {
                int i = (int) d3;
                long[] jArr = (long[]) Assertions.checkStateNotNull(this.f);
                double d5 = (double) jArr[i];
                if (i == 99) {
                    d2 = 256.0d;
                } else {
                    d2 = (double) jArr[i + 1];
                }
                d4 = d5 + ((d2 - d5) * (d3 - ((double) i)));
            }
        }
        return new SeekMap.SeekPoints(new SeekPoint(constrainValue, this.a + Util.constrainValue(Math.round((d4 / 256.0d) * ((double) this.d)), (long) this.b, this.d - 1)));
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Seeker
    public long getTimeUs(long j) {
        long j2;
        long j3 = j - this.a;
        if (!isSeekable() || j3 <= ((long) this.b)) {
            return 0;
        }
        long[] jArr = (long[]) Assertions.checkStateNotNull(this.f);
        double d2 = (((double) j3) * 256.0d) / ((double) this.d);
        int binarySearchFloor = Util.binarySearchFloor(jArr, (long) d2, true, true);
        long j4 = this.c;
        long j5 = (((long) binarySearchFloor) * j4) / 100;
        long j6 = jArr[binarySearchFloor];
        int i = binarySearchFloor + 1;
        long j7 = (j4 * ((long) i)) / 100;
        if (binarySearchFloor == 99) {
            j2 = 256;
        } else {
            j2 = jArr[i];
        }
        return Math.round((j6 == j2 ? 0.0d : (d2 - ((double) j6)) / ((double) (j2 - j6))) * ((double) (j7 - j5))) + j5;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return this.f != null;
    }
}
