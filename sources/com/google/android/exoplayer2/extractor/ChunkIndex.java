package com.google.android.exoplayer2.extractor;

import a2.b.a.a.a;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
public final class ChunkIndex implements SeekMap {
    public final long a;
    public final long[] durationsUs;
    public final int length;
    public final long[] offsets;
    public final int[] sizes;
    public final long[] timesUs;

    public ChunkIndex(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.sizes = iArr;
        this.offsets = jArr;
        this.durationsUs = jArr2;
        this.timesUs = jArr3;
        int length2 = iArr.length;
        this.length = length2;
        if (length2 > 0) {
            this.a = jArr2[length2 - 1] + jArr3[length2 - 1];
        } else {
            this.a = 0;
        }
    }

    public int getChunkIndex(long j) {
        return Util.binarySearchFloor(this.timesUs, j, true, true);
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.a;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public SeekMap.SeekPoints getSeekPoints(long j) {
        int chunkIndex = getChunkIndex(j);
        SeekPoint seekPoint = new SeekPoint(this.timesUs[chunkIndex], this.offsets[chunkIndex]);
        if (seekPoint.timeUs >= j || chunkIndex == this.length - 1) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        int i = chunkIndex + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(this.timesUs[i], this.offsets[i]));
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }

    public String toString() {
        StringBuilder L = a.L("ChunkIndex(length=");
        L.append(this.length);
        L.append(", sizes=");
        L.append(Arrays.toString(this.sizes));
        L.append(", offsets=");
        L.append(Arrays.toString(this.offsets));
        L.append(", timeUs=");
        L.append(Arrays.toString(this.timesUs));
        L.append(", durationsUs=");
        L.append(Arrays.toString(this.durationsUs));
        L.append(")");
        return L.toString();
    }
}
