package a2.j.b.b;

import com.google.android.exoplayer2.AbstractConcatenatedTimeline;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.util.Util;
import java.util.Collection;
import java.util.HashMap;
public final class l0 extends AbstractConcatenatedTimeline {
    public final int d;
    public final int e;
    public final int[] f;
    public final int[] g;
    public final Timeline[] h;
    public final Object[] i;
    public final HashMap<Object, Integer> j = new HashMap<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l0(Collection<? extends i0> collection, ShuffleOrder shuffleOrder) {
        super(false, shuffleOrder);
        int i2 = 0;
        int size = collection.size();
        this.f = new int[size];
        this.g = new int[size];
        this.h = new Timeline[size];
        this.i = new Object[size];
        int i3 = 0;
        int i4 = 0;
        for (i0 i0Var : collection) {
            this.h[i4] = i0Var.a();
            this.g[i4] = i2;
            this.f[i4] = i3;
            i2 += this.h[i4].getWindowCount();
            i3 += this.h[i4].getPeriodCount();
            this.i[i4] = i0Var.getUid();
            this.j.put(this.i[i4], Integer.valueOf(i4));
            i4++;
        }
        this.d = i2;
        this.e = i3;
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public int getChildIndexByChildUid(Object obj) {
        Integer num = this.j.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public int getChildIndexByPeriodIndex(int i2) {
        return Util.binarySearchFloor(this.f, i2 + 1, false, false);
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public int getChildIndexByWindowIndex(int i2) {
        return Util.binarySearchFloor(this.g, i2 + 1, false, false);
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public Object getChildUidByChildIndex(int i2) {
        return this.i[i2];
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public int getFirstPeriodIndexByChildIndex(int i2) {
        return this.f[i2];
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public int getFirstWindowIndexByChildIndex(int i2) {
        return this.g[i2];
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getPeriodCount() {
        return this.e;
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public Timeline getTimelineByChildIndex(int i2) {
        return this.h[i2];
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getWindowCount() {
        return this.d;
    }
}
