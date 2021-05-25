package a2.j.d.c;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ObjectArrays;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.spongycastle.asn1.cmc.BodyPartID;
@GwtIncompatible
public class e0<E> extends c0<E> {
    @MonotonicNonNullDecl
    public transient int[] f;
    @MonotonicNonNullDecl
    public transient int[] g;
    public transient int h;
    public transient int i;

    public e0() {
    }

    @Override // a2.j.d.c.c0
    public int a(int i2, int i3) {
        return i2 >= size() ? i3 : i2;
    }

    @Override // a2.j.d.c.c0
    public void b() {
        super.b();
        int length = this.c.length;
        int[] iArr = new int[length];
        this.f = iArr;
        this.g = new int[length];
        Arrays.fill(iArr, -1);
        Arrays.fill(this.g, -1);
    }

    @Override // a2.j.d.c.c0
    public int c() {
        return this.h;
    }

    @Override // a2.j.d.c.c0, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (!l()) {
            this.h = -2;
            this.i = -2;
            Arrays.fill(this.f, 0, size(), -1);
            Arrays.fill(this.g, 0, size(), -1);
            super.clear();
        }
    }

    @Override // a2.j.d.c.c0
    public int e(int i2) {
        return this.g[i2];
    }

    @Override // a2.j.d.c.c0
    public void h(int i2) {
        super.h(i2);
        this.h = -2;
        this.i = -2;
    }

    @Override // a2.j.d.c.c0
    public void i(int i2, E e, int i3) {
        this.b[i2] = (((long) i3) << 32) | BodyPartID.bodyIdMax;
        this.c[i2] = e;
        p(this.i, i2);
        p(i2, -2);
    }

    @Override // a2.j.d.c.c0
    public void j(int i2) {
        int size = size() - 1;
        super.j(i2);
        p(this.f[i2], this.g[i2]);
        if (i2 < size) {
            p(this.f[size], i2);
            p(i2, this.g[size]);
        }
        this.f[size] = -1;
        this.g[size] = -1;
    }

    @Override // a2.j.d.c.c0
    public void n(int i2) {
        super.n(i2);
        int[] iArr = this.f;
        int length = iArr.length;
        this.f = Arrays.copyOf(iArr, i2);
        this.g = Arrays.copyOf(this.g, i2);
        if (length < i2) {
            Arrays.fill(this.f, length, i2, -1);
            Arrays.fill(this.g, length, i2, -1);
        }
    }

    public final void p(int i2, int i3) {
        if (i2 == -2) {
            this.h = i3;
        } else {
            this.g[i2] = i3;
        }
        if (i3 == -2) {
            this.i = i2;
        } else {
            this.f[i3] = i2;
        }
    }

    @Override // a2.j.d.c.c0, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        Object[] objArr = new Object[size()];
        ObjectArrays.c(this, objArr);
        return objArr;
    }

    public e0(int i2) {
        super(i2);
    }

    @Override // a2.j.d.c.c0, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) ObjectArrays.d(this, tArr);
    }
}
