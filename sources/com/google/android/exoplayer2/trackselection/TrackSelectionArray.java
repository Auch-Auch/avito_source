package com.google.android.exoplayer2.trackselection;

import androidx.annotation.Nullable;
import java.util.Arrays;
public final class TrackSelectionArray {
    public final TrackSelection[] a;
    public int b;
    public final int length;

    public TrackSelectionArray(TrackSelection... trackSelectionArr) {
        this.a = trackSelectionArr;
        this.length = trackSelectionArr.length;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackSelectionArray.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.a, ((TrackSelectionArray) obj).a);
    }

    @Nullable
    public TrackSelection get(int i) {
        return this.a[i];
    }

    public TrackSelection[] getAll() {
        return (TrackSelection[]) this.a.clone();
    }

    public int hashCode() {
        if (this.b == 0) {
            this.b = 527 + Arrays.hashCode(this.a);
        }
        return this.b;
    }
}
