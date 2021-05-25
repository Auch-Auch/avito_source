package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
public final class FlacSeekTableSeekMap implements SeekMap {
    public final FlacStreamMetadata a;
    public final long b;

    public FlacSeekTableSeekMap(FlacStreamMetadata flacStreamMetadata, long j) {
        this.a = flacStreamMetadata;
        this.b = j;
    }

    public final SeekPoint a(long j, long j2) {
        return new SeekPoint((j * 1000000) / ((long) this.a.sampleRate), this.b + j2);
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.a.getDurationUs();
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public SeekMap.SeekPoints getSeekPoints(long j) {
        long j2;
        Assertions.checkStateNotNull(this.a.seekTable);
        FlacStreamMetadata flacStreamMetadata = this.a;
        FlacStreamMetadata.SeekTable seekTable = flacStreamMetadata.seekTable;
        long[] jArr = seekTable.pointSampleNumbers;
        long[] jArr2 = seekTable.pointOffsets;
        int binarySearchFloor = Util.binarySearchFloor(jArr, flacStreamMetadata.getSampleNumber(j), true, false);
        long j3 = 0;
        if (binarySearchFloor == -1) {
            j2 = 0;
        } else {
            j2 = jArr[binarySearchFloor];
        }
        if (binarySearchFloor != -1) {
            j3 = jArr2[binarySearchFloor];
        }
        SeekPoint a3 = a(j2, j3);
        if (a3.timeUs == j || binarySearchFloor == jArr.length - 1) {
            return new SeekMap.SeekPoints(a3);
        }
        int i = binarySearchFloor + 1;
        return new SeekMap.SeekPoints(a3, a(jArr[i], jArr2[i]));
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }
}
