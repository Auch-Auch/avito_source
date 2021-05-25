package a2.j.d.c;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.Arrays;
import org.spongycastle.asn1.cmc.BodyPartID;
@GwtCompatible(emulated = true, serializable = true)
public class w2<K> extends v2<K> {
    @VisibleForTesting
    public transient long[] i;
    public transient int j;
    public transient int k;

    public w2(int i2) {
        super(i2, 1.0f);
    }

    @Override // a2.j.d.c.v2
    public void a() {
        super.a();
        this.j = -2;
        this.k = -2;
    }

    @Override // a2.j.d.c.v2
    public int c() {
        int i2 = this.j;
        if (i2 == -2) {
            return -1;
        }
        return i2;
    }

    @Override // a2.j.d.c.v2
    public void j(int i2, float f) {
        super.j(i2, f);
        this.j = -2;
        this.k = -2;
        long[] jArr = new long[i2];
        this.i = jArr;
        Arrays.fill(jArr, -1L);
    }

    @Override // a2.j.d.c.v2
    public void k(int i2, K k2, int i3, int i4) {
        super.k(i2, k2, i3, i4);
        w(this.k, i2);
        w(i2, -2);
    }

    @Override // a2.j.d.c.v2
    public void l(int i2) {
        int i3 = this.c - 1;
        long[] jArr = this.i;
        w((int) (jArr[i2] >>> 32), (int) jArr[i2]);
        if (i2 < i3) {
            w((int) (this.i[i3] >>> 32), i2);
            w(i2, v(i3));
        }
        super.l(i2);
    }

    @Override // a2.j.d.c.v2
    public int m(int i2) {
        int i3 = (int) this.i[i2];
        if (i3 == -2) {
            return -1;
        }
        return i3;
    }

    @Override // a2.j.d.c.v2
    public int n(int i2, int i3) {
        return i2 == this.c ? i3 : i2;
    }

    @Override // a2.j.d.c.v2
    public void r(int i2) {
        super.r(i2);
        long[] jArr = this.i;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i2);
        this.i = copyOf;
        Arrays.fill(copyOf, length, i2, -1L);
    }

    public final int v(int i2) {
        return (int) this.i[i2];
    }

    public final void w(int i2, int i3) {
        if (i2 == -2) {
            this.j = i3;
        } else {
            long[] jArr = this.i;
            jArr[i2] = (jArr[i2] & -4294967296L) | (((long) i3) & BodyPartID.bodyIdMax);
        }
        if (i3 == -2) {
            this.k = i2;
            return;
        }
        long[] jArr2 = this.i;
        jArr2[i3] = (BodyPartID.bodyIdMax & jArr2[i3]) | (((long) i2) << 32);
    }

    public w2(v2<K> v2Var) {
        j(v2Var.c, 1.0f);
        int c = v2Var.c();
        while (c != -1) {
            o(v2Var.f(c), v2Var.g(c));
            c = v2Var.m(c);
        }
    }
}
