package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.util.Assertions;
public abstract class AbstractConcatenatedTimeline extends Timeline {
    public final int a;
    public final ShuffleOrder b;
    public final boolean c;

    public AbstractConcatenatedTimeline(boolean z, ShuffleOrder shuffleOrder) {
        this.c = z;
        this.b = shuffleOrder;
        this.a = shuffleOrder.getLength();
    }

    public static Object getChildPeriodUidFromConcatenatedUid(Object obj) {
        return ((Pair) obj).second;
    }

    public static Object getChildTimelineUidFromConcatenatedUid(Object obj) {
        return ((Pair) obj).first;
    }

    public static Object getConcatenatedUid(Object obj, Object obj2) {
        return Pair.create(obj, obj2);
    }

    public final int a(int i, boolean z) {
        if (z) {
            return this.b.getNextIndex(i);
        }
        if (i < this.a - 1) {
            return i + 1;
        }
        return -1;
    }

    public final int b(int i, boolean z) {
        if (z) {
            return this.b.getPreviousIndex(i);
        }
        if (i > 0) {
            return i - 1;
        }
        return -1;
    }

    public abstract int getChildIndexByChildUid(Object obj);

    public abstract int getChildIndexByPeriodIndex(int i);

    public abstract int getChildIndexByWindowIndex(int i);

    public abstract Object getChildUidByChildIndex(int i);

    public abstract int getFirstPeriodIndexByChildIndex(int i);

    @Override // com.google.android.exoplayer2.Timeline
    public int getFirstWindowIndex(boolean z) {
        if (this.a == 0) {
            return -1;
        }
        int i = 0;
        if (this.c) {
            z = false;
        }
        if (z) {
            i = this.b.getFirstIndex();
        }
        while (getTimelineByChildIndex(i).isEmpty()) {
            i = a(i, z);
            if (i == -1) {
                return -1;
            }
        }
        return getTimelineByChildIndex(i).getFirstWindowIndex(z) + getFirstWindowIndexByChildIndex(i);
    }

    public abstract int getFirstWindowIndexByChildIndex(int i);

    @Override // com.google.android.exoplayer2.Timeline
    public final int getIndexOfPeriod(Object obj) {
        int indexOfPeriod;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Object childTimelineUidFromConcatenatedUid = getChildTimelineUidFromConcatenatedUid(obj);
        Object childPeriodUidFromConcatenatedUid = getChildPeriodUidFromConcatenatedUid(obj);
        int childIndexByChildUid = getChildIndexByChildUid(childTimelineUidFromConcatenatedUid);
        if (childIndexByChildUid == -1 || (indexOfPeriod = getTimelineByChildIndex(childIndexByChildUid).getIndexOfPeriod(childPeriodUidFromConcatenatedUid)) == -1) {
            return -1;
        }
        return getFirstPeriodIndexByChildIndex(childIndexByChildUid) + indexOfPeriod;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getLastWindowIndex(boolean z) {
        int i = this.a;
        if (i == 0) {
            return -1;
        }
        if (this.c) {
            z = false;
        }
        int lastIndex = z ? this.b.getLastIndex() : i - 1;
        while (getTimelineByChildIndex(lastIndex).isEmpty()) {
            lastIndex = b(lastIndex, z);
            if (lastIndex == -1) {
                return -1;
            }
        }
        return getTimelineByChildIndex(lastIndex).getLastWindowIndex(z) + getFirstWindowIndexByChildIndex(lastIndex);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getNextWindowIndex(int i, int i2, boolean z) {
        int i3 = 0;
        if (this.c) {
            if (i2 == 1) {
                i2 = 2;
            }
            z = false;
        }
        int childIndexByWindowIndex = getChildIndexByWindowIndex(i);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByWindowIndex);
        Timeline timelineByChildIndex = getTimelineByChildIndex(childIndexByWindowIndex);
        int i4 = i - firstWindowIndexByChildIndex;
        if (i2 != 2) {
            i3 = i2;
        }
        int nextWindowIndex = timelineByChildIndex.getNextWindowIndex(i4, i3, z);
        if (nextWindowIndex != -1) {
            return firstWindowIndexByChildIndex + nextWindowIndex;
        }
        int a3 = a(childIndexByWindowIndex, z);
        while (a3 != -1 && getTimelineByChildIndex(a3).isEmpty()) {
            a3 = a(a3, z);
        }
        if (a3 != -1) {
            return getTimelineByChildIndex(a3).getFirstWindowIndex(z) + getFirstWindowIndexByChildIndex(a3);
        } else if (i2 == 2) {
            return getFirstWindowIndex(z);
        } else {
            return -1;
        }
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
        int childIndexByPeriodIndex = getChildIndexByPeriodIndex(i);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByPeriodIndex);
        getTimelineByChildIndex(childIndexByPeriodIndex).getPeriod(i - getFirstPeriodIndexByChildIndex(childIndexByPeriodIndex), period, z);
        period.windowIndex += firstWindowIndexByChildIndex;
        if (z) {
            period.uid = getConcatenatedUid(getChildUidByChildIndex(childIndexByPeriodIndex), Assertions.checkNotNull(period.uid));
        }
        return period;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final Timeline.Period getPeriodByUid(Object obj, Timeline.Period period) {
        Object childTimelineUidFromConcatenatedUid = getChildTimelineUidFromConcatenatedUid(obj);
        Object childPeriodUidFromConcatenatedUid = getChildPeriodUidFromConcatenatedUid(obj);
        int childIndexByChildUid = getChildIndexByChildUid(childTimelineUidFromConcatenatedUid);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByChildUid);
        getTimelineByChildIndex(childIndexByChildUid).getPeriodByUid(childPeriodUidFromConcatenatedUid, period);
        period.windowIndex += firstWindowIndexByChildIndex;
        period.uid = obj;
        return period;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getPreviousWindowIndex(int i, int i2, boolean z) {
        int i3 = 0;
        if (this.c) {
            if (i2 == 1) {
                i2 = 2;
            }
            z = false;
        }
        int childIndexByWindowIndex = getChildIndexByWindowIndex(i);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByWindowIndex);
        Timeline timelineByChildIndex = getTimelineByChildIndex(childIndexByWindowIndex);
        int i4 = i - firstWindowIndexByChildIndex;
        if (i2 != 2) {
            i3 = i2;
        }
        int previousWindowIndex = timelineByChildIndex.getPreviousWindowIndex(i4, i3, z);
        if (previousWindowIndex != -1) {
            return firstWindowIndexByChildIndex + previousWindowIndex;
        }
        int b2 = b(childIndexByWindowIndex, z);
        while (b2 != -1 && getTimelineByChildIndex(b2).isEmpty()) {
            b2 = b(b2, z);
        }
        if (b2 != -1) {
            return getTimelineByChildIndex(b2).getLastWindowIndex(z) + getFirstWindowIndexByChildIndex(b2);
        } else if (i2 == 2) {
            return getLastWindowIndex(z);
        } else {
            return -1;
        }
    }

    public abstract Timeline getTimelineByChildIndex(int i);

    @Override // com.google.android.exoplayer2.Timeline
    public final Object getUidOfPeriod(int i) {
        int childIndexByPeriodIndex = getChildIndexByPeriodIndex(i);
        return getConcatenatedUid(getChildUidByChildIndex(childIndexByPeriodIndex), getTimelineByChildIndex(childIndexByPeriodIndex).getUidOfPeriod(i - getFirstPeriodIndexByChildIndex(childIndexByPeriodIndex)));
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final Timeline.Window getWindow(int i, Timeline.Window window, long j) {
        int childIndexByWindowIndex = getChildIndexByWindowIndex(i);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByWindowIndex);
        int firstPeriodIndexByChildIndex = getFirstPeriodIndexByChildIndex(childIndexByWindowIndex);
        getTimelineByChildIndex(childIndexByWindowIndex).getWindow(i - firstWindowIndexByChildIndex, window, j);
        Object childUidByChildIndex = getChildUidByChildIndex(childIndexByWindowIndex);
        if (!Timeline.Window.SINGLE_WINDOW_UID.equals(window.uid)) {
            childUidByChildIndex = getConcatenatedUid(childUidByChildIndex, window.uid);
        }
        window.uid = childUidByChildIndex;
        window.firstPeriodIndex += firstPeriodIndexByChildIndex;
        window.lastPeriodIndex += firstPeriodIndexByChildIndex;
        return window;
    }
}
