package com.google.android.exoplayer2.source.hls;

import android.util.SparseArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
public final class TimestampAdjusterProvider {
    public final SparseArray<TimestampAdjuster> a = new SparseArray<>();

    public TimestampAdjuster getAdjuster(int i) {
        TimestampAdjuster timestampAdjuster = this.a.get(i);
        if (timestampAdjuster != null) {
            return timestampAdjuster;
        }
        TimestampAdjuster timestampAdjuster2 = new TimestampAdjuster(Long.MAX_VALUE);
        this.a.put(i, timestampAdjuster2);
        return timestampAdjuster2;
    }

    public void reset() {
        this.a.clear();
    }
}
