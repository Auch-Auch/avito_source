package a2.j.k.a.a;

import com.google.zxing.aztec.encoder.HighLevelEncoder;
import java.util.Objects;
public final class c {
    public static final c e = new c(d.b, 0, 0, 0);
    public final int a;
    public final d b;
    public final int c;
    public final int d;

    public c(d dVar, int i, int i2, int i3) {
        this.b = dVar;
        this.a = i;
        this.c = i2;
        this.d = i3;
    }

    public c a(int i) {
        d dVar = this.b;
        int i2 = this.a;
        int i3 = this.d;
        if (i2 == 4 || i2 == 2) {
            int i4 = HighLevelEncoder.c[i2][0];
            int i5 = 65535 & i4;
            int i6 = i4 >> 16;
            Objects.requireNonNull(dVar);
            i3 += i6;
            dVar = new b(dVar, i5, i6);
            i2 = 0;
        }
        int i7 = this.c;
        int i8 = (i7 == 0 || i7 == 31) ? 18 : i7 == 62 ? 9 : 8;
        int i9 = i7 + 1;
        c cVar = new c(dVar, i2, i9, i3 + i8);
        return i9 == 2078 ? cVar.b(i + 1) : cVar;
    }

    public c b(int i) {
        int i2 = this.c;
        if (i2 == 0) {
            return this;
        }
        d dVar = this.b;
        Objects.requireNonNull(dVar);
        return new c(new a(dVar, i - i2, i2), this.a, 0, this.d);
    }

    public boolean c(c cVar) {
        int i;
        int i2 = this.d + (HighLevelEncoder.c[this.a][cVar.a] >> 16);
        int i3 = cVar.c;
        if (i3 > 0 && ((i = this.c) == 0 || i > i3)) {
            i2 += 10;
        }
        return i2 <= cVar.d;
    }

    public c d(int i, int i2) {
        int i3 = this.d;
        d dVar = this.b;
        int i4 = this.a;
        if (i != i4) {
            int i5 = HighLevelEncoder.c[i4][i];
            int i6 = 65535 & i5;
            int i7 = i5 >> 16;
            Objects.requireNonNull(dVar);
            i3 += i7;
            dVar = new b(dVar, i6, i7);
        }
        int i8 = i == 2 ? 4 : 5;
        Objects.requireNonNull(dVar);
        return new c(new b(dVar, i2, i8), i, 0, i3 + i8);
    }

    public c e(int i, int i2) {
        d dVar = this.b;
        int i3 = this.a;
        int i4 = i3 == 2 ? 4 : 5;
        int i5 = HighLevelEncoder.e[i3][i];
        Objects.requireNonNull(dVar);
        return new c(new b(new b(dVar, i5, i4), i2, 5), this.a, 0, this.d + i4 + 5);
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", HighLevelEncoder.b[this.a], Integer.valueOf(this.d), Integer.valueOf(this.c));
    }
}
