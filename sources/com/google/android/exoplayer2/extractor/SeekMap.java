package com.google.android.exoplayer2.extractor;

import a2.b.a.a.a;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Assertions;
public interface SeekMap {

    public static final class SeekPoints {
        public final SeekPoint first;
        public final SeekPoint second;

        public SeekPoints(SeekPoint seekPoint) {
            this(seekPoint, seekPoint);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SeekPoints.class != obj.getClass()) {
                return false;
            }
            SeekPoints seekPoints = (SeekPoints) obj;
            if (!this.first.equals(seekPoints.first) || !this.second.equals(seekPoints.second)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.second.hashCode() + (this.first.hashCode() * 31);
        }

        public String toString() {
            String str;
            StringBuilder L = a.L("[");
            L.append(this.first);
            if (this.first.equals(this.second)) {
                str = "";
            } else {
                StringBuilder L2 = a.L(", ");
                L2.append(this.second);
                str = L2.toString();
            }
            return a.t(L, str, "]");
        }

        public SeekPoints(SeekPoint seekPoint, SeekPoint seekPoint2) {
            this.first = (SeekPoint) Assertions.checkNotNull(seekPoint);
            this.second = (SeekPoint) Assertions.checkNotNull(seekPoint2);
        }
    }

    public static class Unseekable implements SeekMap {
        public final long a;
        public final SeekPoints b;

        public Unseekable(long j) {
            this(j, 0);
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public long getDurationUs() {
            return this.a;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public SeekPoints getSeekPoints(long j) {
            return this.b;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public boolean isSeekable() {
            return false;
        }

        public Unseekable(long j, long j2) {
            this.a = j;
            this.b = new SeekPoints(j2 == 0 ? SeekPoint.START : new SeekPoint(0, j2));
        }
    }

    long getDurationUs();

    SeekPoints getSeekPoints(long j);

    boolean isSeekable();
}
