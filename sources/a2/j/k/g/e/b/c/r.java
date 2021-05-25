package a2.j.k.g.e.b.c;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;
public final class r {
    public final BitArray a;
    public final l b = new l();
    public final StringBuilder c = new StringBuilder();

    public r(BitArray bitArray) {
        this.a = bitArray;
    }

    public static int d(BitArray bitArray, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (bitArray.get(i + i4)) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    public String a(StringBuilder sb, int i) throws NotFoundException, FormatException {
        String str = null;
        while (true) {
            n b2 = b(i, str);
            String a3 = q.a(b2.b);
            if (a3 != null) {
                sb.append(a3);
            }
            String valueOf = b2.d ? String.valueOf(b2.c) : null;
            int i2 = b2.a;
            if (i == i2) {
                return sb.toString();
            }
            i = i2;
            str = valueOf;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:161:0x02f3  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x03ce  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x03e6  */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x03a1 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a2.j.k.g.e.b.c.n b(int r18, java.lang.String r19) throws com.google.zxing.FormatException {
        /*
        // Method dump skipped, instructions count: 1102
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.j.k.g.e.b.c.r.b(int, java.lang.String):a2.j.k.g.e.b.c.n");
    }

    public int c(int i, int i2) {
        return d(this.a, i, i2);
    }

    public final boolean e(int i) {
        int i2 = i + 3;
        if (i2 > this.a.getSize()) {
            return false;
        }
        while (i < i2) {
            if (this.a.get(i)) {
                return false;
            }
            i++;
        }
        return true;
    }

    public final boolean f(int i) {
        int i2;
        if (i + 1 > this.a.getSize()) {
            return false;
        }
        int i3 = 0;
        while (i3 < 5 && (i2 = i3 + i) < this.a.getSize()) {
            if (i3 == 2) {
                if (!this.a.get(i + 2)) {
                    return false;
                }
            } else if (this.a.get(i2)) {
                return false;
            }
            i3++;
        }
        return true;
    }
}
