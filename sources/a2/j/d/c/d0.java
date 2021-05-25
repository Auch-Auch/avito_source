package a2.j.d.c;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.spongycastle.asn1.cmc.BodyPartID;
@GwtIncompatible
public class d0<K, V> extends b0<K, V> {
    @VisibleForTesting
    @MonotonicNonNullDecl
    public transient long[] k;
    public transient int l;
    public transient int m;
    public final boolean n = false;

    public d0() {
        super(3);
    }

    @Override // a2.j.d.c.b0
    public void c(int i) {
        if (this.n) {
            long[] jArr = this.k;
            u((int) (jArr[i] >>> 32), (int) jArr[i]);
            u(this.m, i);
            u(i, -2);
            this.e++;
        }
    }

    @Override // a2.j.d.c.b0, java.util.AbstractMap, java.util.Map
    public void clear() {
        if (!p()) {
            this.l = -2;
            this.m = -2;
            Arrays.fill(this.k, 0, size(), -1L);
            super.clear();
        }
    }

    @Override // a2.j.d.c.b0
    public int d(int i, int i2) {
        return i >= size() ? i2 : i;
    }

    @Override // a2.j.d.c.b0
    public void e() {
        super.e();
        long[] jArr = new long[this.c.length];
        this.k = jArr;
        Arrays.fill(jArr, -1L);
    }

    @Override // a2.j.d.c.b0
    public int f() {
        return this.l;
    }

    @Override // a2.j.d.c.b0
    public int i(int i) {
        return (int) this.k[i];
    }

    @Override // a2.j.d.c.b0
    public void m(int i) {
        super.m(i);
        this.l = -2;
        this.m = -2;
    }

    @Override // a2.j.d.c.b0
    public void n(int i, K k2, V v, int i2) {
        super.n(i, k2, v, i2);
        u(this.m, i);
        u(i, -2);
    }

    @Override // a2.j.d.c.b0
    public void o(int i) {
        int size = size() - 1;
        super.o(i);
        long[] jArr = this.k;
        u((int) (jArr[i] >>> 32), (int) jArr[i]);
        if (i < size) {
            u(t(size), i);
            u(i, i(size));
        }
        this.k[size] = -1;
    }

    @Override // a2.j.d.c.b0
    public void r(int i) {
        super.r(i);
        long[] jArr = this.k;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i);
        this.k = copyOf;
        if (length < i) {
            Arrays.fill(copyOf, length, i, -1L);
        }
    }

    public final int t(int i) {
        return (int) (this.k[i] >>> 32);
    }

    public final void u(int i, int i2) {
        if (i == -2) {
            this.l = i2;
        } else {
            long[] jArr = this.k;
            jArr[i] = (jArr[i] & -4294967296L) | (((long) i2) & BodyPartID.bodyIdMax);
        }
        if (i2 == -2) {
            this.m = i;
            return;
        }
        long[] jArr2 = this.k;
        jArr2[i2] = (BodyPartID.bodyIdMax & jArr2[i2]) | (((long) i) << 32);
    }

    public d0(int i) {
        super(i);
    }
}
