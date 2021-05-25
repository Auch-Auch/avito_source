package a2.j.b.b.u0.m;

import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.Util;
public final class d implements SeekMap {
    public final b a;
    public final int b;
    public final long c;
    public final long d;
    public final long e;

    public d(b bVar, int i, long j, long j2) {
        this.a = bVar;
        this.b = i;
        this.c = j;
        long j3 = (j2 - j) / ((long) bVar.d);
        this.d = j3;
        this.e = a(j3);
    }

    public final long a(long j) {
        return Util.scaleLargeTimestamp(j * ((long) this.b), 1000000, (long) this.a.c);
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.e;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public SeekMap.SeekPoints getSeekPoints(long j) {
        long constrainValue = Util.constrainValue((((long) this.a.c) * j) / (((long) this.b) * 1000000), 0, this.d - 1);
        long j2 = (((long) this.a.d) * constrainValue) + this.c;
        long a3 = a(constrainValue);
        SeekPoint seekPoint = new SeekPoint(a3, j2);
        if (a3 >= j || constrainValue == this.d - 1) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        long j3 = constrainValue + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(a(j3), (((long) this.a.d) * j3) + this.c));
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }
}
