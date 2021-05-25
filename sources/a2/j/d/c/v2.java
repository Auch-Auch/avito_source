package a2.j.d.c;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multisets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.spongycastle.asn1.cmc.BodyPartID;
@GwtCompatible(emulated = true, serializable = true)
public class v2<K> {
    public transient Object[] a;
    public transient int[] b;
    public transient int c;
    public transient int d;
    public transient int[] e;
    @VisibleForTesting
    public transient long[] f;
    public transient float g;
    public transient int h;

    public class a extends Multisets.e<K> {
        @NullableDecl
        public final K a;
        public int b;

        public a(int i) {
            this.a = (K) v2.this.a[i];
            this.b = i;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0015, code lost:
            if (com.google.common.base.Objects.equal(r4.a, r2.a[r0]) != false) goto L_0x0021;
         */
        @Override // com.google.common.collect.Multiset.Entry
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int getCount() {
            /*
                r4 = this;
                int r0 = r4.b
                r1 = -1
                if (r0 == r1) goto L_0x0017
                a2.j.d.c.v2 r2 = a2.j.d.c.v2.this
                int r3 = r2.c
                if (r0 >= r3) goto L_0x0017
                K r3 = r4.a
                java.lang.Object[] r2 = r2.a
                r0 = r2[r0]
                boolean r0 = com.google.common.base.Objects.equal(r3, r0)
                if (r0 != 0) goto L_0x0021
            L_0x0017:
                a2.j.d.c.v2 r0 = a2.j.d.c.v2.this
                K r2 = r4.a
                int r0 = r0.i(r2)
                r4.b = r0
            L_0x0021:
                int r0 = r4.b
                if (r0 != r1) goto L_0x0027
                r0 = 0
                goto L_0x002d
            L_0x0027:
                a2.j.d.c.v2 r1 = a2.j.d.c.v2.this
                int[] r1 = r1.b
                r0 = r1[r0]
            L_0x002d:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: a2.j.d.c.v2.a.getCount():int");
        }

        @Override // com.google.common.collect.Multiset.Entry
        public K getElement() {
            return this.a;
        }
    }

    public v2() {
        j(3, 1.0f);
    }

    public static int e(long j) {
        return (int) (j >>> 32);
    }

    public static long u(long j, int i) {
        return (j & -4294967296L) | (((long) i) & BodyPartID.bodyIdMax);
    }

    public void a() {
        this.d++;
        Arrays.fill(this.a, 0, this.c, (Object) null);
        Arrays.fill(this.b, 0, this.c, 0);
        Arrays.fill(this.e, -1);
        Arrays.fill(this.f, -1L);
        this.c = 0;
    }

    public void b(int i) {
        if (i > this.f.length) {
            r(i);
        }
        if (i >= this.h) {
            s(Math.max(2, Integer.highestOneBit(i - 1) << 1));
        }
    }

    public int c() {
        return this.c == 0 ? -1 : 0;
    }

    public int d(@NullableDecl Object obj) {
        int i = i(obj);
        if (i == -1) {
            return 0;
        }
        return this.b[i];
    }

    public K f(int i) {
        Preconditions.checkElementIndex(i, this.c);
        return (K) this.a[i];
    }

    public int g(int i) {
        Preconditions.checkElementIndex(i, this.c);
        return this.b[i];
    }

    public final int h() {
        return this.e.length - 1;
    }

    public int i(@NullableDecl Object obj) {
        int W1 = AppCompatDelegateImpl.i.W1(obj);
        int i = this.e[h() & W1];
        while (i != -1) {
            long j = this.f[i];
            if (e(j) == W1 && Objects.equal(obj, this.a[i])) {
                return i;
            }
            i = (int) j;
        }
        return -1;
    }

    public void j(int i, float f2) {
        boolean z = false;
        Preconditions.checkArgument(i >= 0, "Initial capacity must be non-negative");
        if (f2 > 0.0f) {
            z = true;
        }
        Preconditions.checkArgument(z, "Illegal load factor");
        int J = AppCompatDelegateImpl.i.J(i, (double) f2);
        int[] iArr = new int[J];
        Arrays.fill(iArr, -1);
        this.e = iArr;
        this.g = f2;
        this.a = new Object[i];
        this.b = new int[i];
        long[] jArr = new long[i];
        Arrays.fill(jArr, -1L);
        this.f = jArr;
        this.h = Math.max(1, (int) (((float) J) * f2));
    }

    public void k(int i, @NullableDecl K k, int i2, int i3) {
        this.f[i] = (((long) i3) << 32) | BodyPartID.bodyIdMax;
        this.a[i] = k;
        this.b[i] = i2;
    }

    public void l(int i) {
        int i2 = this.c - 1;
        if (i < i2) {
            Object[] objArr = this.a;
            objArr[i] = objArr[i2];
            int[] iArr = this.b;
            iArr[i] = iArr[i2];
            objArr[i2] = null;
            iArr[i2] = 0;
            long[] jArr = this.f;
            long j = jArr[i2];
            jArr[i] = j;
            jArr[i2] = -1;
            int e2 = e(j) & h();
            int[] iArr2 = this.e;
            int i3 = iArr2[e2];
            if (i3 == i2) {
                iArr2[e2] = i;
                return;
            }
            while (true) {
                long[] jArr2 = this.f;
                long j2 = jArr2[i3];
                int i4 = (int) j2;
                if (i4 == i2) {
                    jArr2[i3] = u(j2, i);
                    return;
                }
                i3 = i4;
            }
        } else {
            this.a[i] = null;
            this.b[i] = 0;
            this.f[i] = -1;
        }
    }

    public int m(int i) {
        int i2 = i + 1;
        if (i2 < this.c) {
            return i2;
        }
        return -1;
    }

    public int n(int i, int i2) {
        return i - 1;
    }

    @CanIgnoreReturnValue
    public int o(@NullableDecl K k, int i) {
        AppCompatDelegateImpl.i.E(i, "count");
        long[] jArr = this.f;
        Object[] objArr = this.a;
        int[] iArr = this.b;
        int W1 = AppCompatDelegateImpl.i.W1(k);
        int h2 = h() & W1;
        int i2 = this.c;
        int[] iArr2 = this.e;
        int i3 = iArr2[h2];
        if (i3 == -1) {
            iArr2[h2] = i2;
        } else {
            while (true) {
                long j = jArr[i3];
                if (e(j) != W1 || !Objects.equal(k, objArr[i3])) {
                    int i4 = (int) j;
                    if (i4 == -1) {
                        jArr[i3] = u(j, i2);
                        break;
                    }
                    i3 = i4;
                } else {
                    int i5 = iArr[i3];
                    iArr[i3] = i;
                    return i5;
                }
            }
        }
        int i6 = Integer.MAX_VALUE;
        if (i2 != Integer.MAX_VALUE) {
            int i7 = i2 + 1;
            int length = this.f.length;
            if (i7 > length) {
                int max = Math.max(1, length >>> 1) + length;
                if (max >= 0) {
                    i6 = max;
                }
                if (i6 != length) {
                    r(i6);
                }
            }
            k(i2, k, i, W1);
            this.c = i7;
            if (i2 >= this.h) {
                s(this.e.length * 2);
            }
            this.d++;
            return 0;
        }
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
    }

    public final int p(@NullableDecl Object obj, int i) {
        int h2 = h() & i;
        int i2 = this.e[h2];
        if (i2 == -1) {
            return 0;
        }
        int i3 = -1;
        while (true) {
            if (e(this.f[i2]) != i || !Objects.equal(obj, this.a[i2])) {
                int i4 = (int) this.f[i2];
                if (i4 == -1) {
                    return 0;
                }
                i3 = i2;
                i2 = i4;
            } else {
                int i5 = this.b[i2];
                if (i3 == -1) {
                    this.e[h2] = (int) this.f[i2];
                } else {
                    long[] jArr = this.f;
                    jArr[i3] = u(jArr[i3], (int) jArr[i2]);
                }
                l(i2);
                this.c--;
                this.d++;
                return i5;
            }
        }
    }

    @CanIgnoreReturnValue
    public int q(int i) {
        return p(this.a[i], e(this.f[i]));
    }

    public void r(int i) {
        this.a = Arrays.copyOf(this.a, i);
        this.b = Arrays.copyOf(this.b, i);
        long[] jArr = this.f;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i);
        if (i > length) {
            Arrays.fill(copyOf, length, i, -1L);
        }
        this.f = copyOf;
    }

    public final void s(int i) {
        if (this.e.length >= 1073741824) {
            this.h = Integer.MAX_VALUE;
            return;
        }
        int i2 = ((int) (((float) i) * this.g)) + 1;
        int[] iArr = new int[i];
        Arrays.fill(iArr, -1);
        long[] jArr = this.f;
        int i3 = i - 1;
        for (int i4 = 0; i4 < this.c; i4++) {
            int e2 = e(jArr[i4]);
            int i5 = e2 & i3;
            int i6 = iArr[i5];
            iArr[i5] = i4;
            jArr[i4] = (((long) e2) << 32) | (((long) i6) & BodyPartID.bodyIdMax);
        }
        this.h = i2;
        this.e = iArr;
    }

    public void t(int i, int i2) {
        Preconditions.checkElementIndex(i, this.c);
        this.b[i] = i2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: a2.j.d.c.v2<K> */
    /* JADX WARN: Multi-variable type inference failed */
    public v2(v2<? extends K> v2Var) {
        j(v2Var.c, 1.0f);
        int c2 = v2Var.c();
        while (c2 != -1) {
            o(v2Var.f(c2), v2Var.g(c2));
            c2 = v2Var.m(c2);
        }
    }

    public v2(int i) {
        j(i, 1.0f);
    }

    public v2(int i, float f2) {
        j(i, f2);
    }
}
