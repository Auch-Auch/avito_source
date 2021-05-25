package a2.j.d.a;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.CharMatcher;
import java.util.BitSet;
@GwtIncompatible
public final class l extends CharMatcher.u {
    public final char[] b;
    public final boolean c;
    public final long d;

    public l(char[] cArr, long j, boolean z, String str) {
        super(str);
        this.b = cArr;
        this.d = j;
        this.c = z;
    }

    @Override // com.google.common.base.CharMatcher
    public void d(BitSet bitSet) {
        if (this.c) {
            bitSet.set(0);
        }
        char[] cArr = this.b;
        for (char c2 : cArr) {
            if (c2 != 0) {
                bitSet.set(c2);
            }
        }
    }

    @Override // com.google.common.base.CharMatcher
    public boolean matches(char c2) {
        if (c2 == 0) {
            return this.c;
        }
        if (!(1 == ((this.d >> c2) & 1))) {
            return false;
        }
        int length = this.b.length - 1;
        int rotateLeft = (Integer.rotateLeft(11601 * c2, 15) * 461845907) & length;
        int i = rotateLeft;
        do {
            char[] cArr = this.b;
            if (cArr[i] == 0) {
                return false;
            }
            if (cArr[i] == c2) {
                return true;
            }
            i = (i + 1) & length;
        } while (i != rotateLeft);
        return false;
    }
}
