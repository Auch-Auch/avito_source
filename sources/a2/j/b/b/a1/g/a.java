package a2.j.b.b.a1.g;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;
public final class a implements Subtitle {
    public final Cue[] a;
    public final long[] b;

    public a(Cue[] cueArr, long[] jArr) {
        this.a = cueArr;
        this.b = jArr;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public List<Cue> getCues(long j) {
        int binarySearchFloor = Util.binarySearchFloor(this.b, j, true, false);
        if (binarySearchFloor != -1) {
            Cue[] cueArr = this.a;
            if (cueArr[binarySearchFloor] != Cue.EMPTY) {
                return Collections.singletonList(cueArr[binarySearchFloor]);
            }
        }
        return Collections.emptyList();
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int i) {
        boolean z = true;
        Assertions.checkArgument(i >= 0);
        if (i >= this.b.length) {
            z = false;
        }
        Assertions.checkArgument(z);
        return this.b[i];
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return this.b.length;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long j) {
        int binarySearchCeil = Util.binarySearchCeil(this.b, j, false, false);
        if (binarySearchCeil < this.b.length) {
            return binarySearchCeil;
        }
        return -1;
    }
}
