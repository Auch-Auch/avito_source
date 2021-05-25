package a2.j.b.b.u0.i;

import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.mp3.Seeker;
import com.google.android.exoplayer2.util.LongArray;
import com.google.android.exoplayer2.util.Util;
public final class d implements Seeker {
    public final long a;
    public final LongArray b;
    public final LongArray c;
    public long d;

    public d(long j, long j2, long j3) {
        this.d = j;
        this.a = j3;
        LongArray longArray = new LongArray();
        this.b = longArray;
        LongArray longArray2 = new LongArray();
        this.c = longArray2;
        longArray.add(0);
        longArray2.add(j2);
    }

    public boolean a(long j) {
        LongArray longArray = this.b;
        return j - longArray.get(longArray.size() - 1) < 100000;
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Seeker
    public long getDataEndPosition() {
        return this.a;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.d;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public SeekMap.SeekPoints getSeekPoints(long j) {
        int binarySearchFloor = Util.binarySearchFloor(this.b, j, true, true);
        SeekPoint seekPoint = new SeekPoint(this.b.get(binarySearchFloor), this.c.get(binarySearchFloor));
        if (seekPoint.timeUs == j || binarySearchFloor == this.b.size() - 1) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        int i = binarySearchFloor + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(this.b.get(i), this.c.get(i)));
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Seeker
    public long getTimeUs(long j) {
        return this.b.get(Util.binarySearchFloor(this.c, j, true, true));
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }
}
