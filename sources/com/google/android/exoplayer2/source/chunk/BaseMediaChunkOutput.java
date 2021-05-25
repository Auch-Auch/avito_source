package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.util.Log;
public final class BaseMediaChunkOutput implements ChunkExtractor.TrackOutputProvider {
    public final int[] a;
    public final SampleQueue[] b;

    public BaseMediaChunkOutput(int[] iArr, SampleQueue[] sampleQueueArr) {
        this.a = iArr;
        this.b = sampleQueueArr;
    }

    public int[] getWriteIndices() {
        int[] iArr = new int[this.b.length];
        int i = 0;
        while (true) {
            SampleQueue[] sampleQueueArr = this.b;
            if (i >= sampleQueueArr.length) {
                return iArr;
            }
            iArr[i] = sampleQueueArr[i].getWriteIndex();
            i++;
        }
    }

    public void setSampleOffsetUs(long j) {
        for (SampleQueue sampleQueue : this.b) {
            sampleQueue.setSampleOffsetUs(j);
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor.TrackOutputProvider
    public TrackOutput track(int i, int i2) {
        int i3 = 0;
        while (true) {
            int[] iArr = this.a;
            if (i3 >= iArr.length) {
                Log.e("BaseMediaChunkOutput", "Unmatched track of type: " + i2);
                return new DummyTrackOutput();
            } else if (i2 == iArr[i3]) {
                return this.b[i3];
            } else {
                i3++;
            }
        }
    }
}
