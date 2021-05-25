package t6.w.f.a.n;
public final class b<V> {
    public static final b<Object> f = new b<>();
    public final long a;
    public final V b;
    public final b<V> c;
    public final b<V> d;
    public final int e;

    public b() {
        this.e = 0;
        this.a = 0;
        this.b = null;
        this.c = null;
        this.d = null;
    }

    public static <V> b<V> e(long j, V v, b<V> bVar, b<V> bVar2) {
        int i = bVar.e;
        int i2 = bVar2.e;
        if (i + i2 > 1) {
            if (i >= i2 * 5) {
                b<V> bVar3 = bVar.c;
                b<V> bVar4 = bVar.d;
                if (bVar4.e < bVar3.e * 2) {
                    long j2 = bVar.a;
                    return new b<>(j2 + j, bVar.b, bVar3, new b(-j2, v, bVar4.g(bVar4.a + j2), bVar2));
                }
                b<V> bVar5 = bVar4.c;
                b<V> bVar6 = bVar4.d;
                long j3 = bVar4.a;
                long j4 = bVar.a + j3 + j;
                V v2 = bVar4.b;
                b bVar7 = new b(-j3, bVar.b, bVar3, bVar5.g(bVar5.a + j3));
                long j5 = bVar.a;
                long j6 = bVar4.a;
                return new b<>(j4, v2, bVar7, new b((-j5) - j6, v, bVar6.g(bVar6.a + j6 + j5), bVar2));
            } else if (i2 >= i * 5) {
                b<V> bVar8 = bVar2.c;
                b<V> bVar9 = bVar2.d;
                if (bVar8.e < bVar9.e * 2) {
                    long j7 = bVar2.a;
                    return new b<>(j7 + j, bVar2.b, new b(-j7, v, bVar, bVar8.g(bVar8.a + j7)), bVar9);
                }
                b<V> bVar10 = bVar8.c;
                b<V> bVar11 = bVar8.d;
                long j8 = bVar8.a;
                long j9 = bVar2.a;
                long j10 = j8 + j9 + j;
                V v3 = bVar8.b;
                b bVar12 = new b((-j9) - j8, v, bVar, bVar10.g(bVar10.a + j8 + j9));
                long j11 = bVar8.a;
                return new b<>(j10, v3, bVar12, new b(-j11, bVar2.b, bVar11.g(bVar11.a + j11), bVar9));
            }
        }
        return new b<>(j, v, bVar, bVar2);
    }

    public V a(long j) {
        if (this.e == 0) {
            return null;
        }
        long j2 = this.a;
        if (j < j2) {
            return this.c.a(j - j2);
        }
        if (j > j2) {
            return this.d.a(j - j2);
        }
        return this.b;
    }

    public final long b() {
        b<V> bVar = this.c;
        if (bVar.e == 0) {
            return this.a;
        }
        return bVar.b() + this.a;
    }

    public b<V> c(long j) {
        long j2;
        if (this.e == 0) {
            return this;
        }
        long j3 = this.a;
        if (j < j3) {
            return f(this.c.c(j - j3), this.d);
        }
        if (j > j3) {
            return f(this.c, this.d.c(j - j3));
        }
        b<V> bVar = this.c;
        if (bVar.e == 0) {
            b<V> bVar2 = this.d;
            return bVar2.g(bVar2.a + j3);
        }
        b<V> bVar3 = this.d;
        if (bVar3.e == 0) {
            return bVar.g(bVar.a + j3);
        }
        b<V> bVar4 = bVar3.c;
        if (bVar4.e == 0) {
            j2 = bVar3.a;
        } else {
            j2 = bVar3.a + bVar4.b();
        }
        long j4 = this.a;
        long j5 = j2 + j4;
        V a3 = this.d.a(j5 - j4);
        b<V> c2 = this.d.c(j5 - this.a);
        b<V> g = c2.g((c2.a + this.a) - j5);
        b<V> bVar5 = this.c;
        return e(j5, a3, bVar5.g((bVar5.a + this.a) - j5), g);
    }

    public b<V> d(long j, V v) {
        if (this.e == 0) {
            return new b<>(j, v, this, this);
        }
        long j2 = this.a;
        if (j < j2) {
            return f(this.c.d(j - j2, v), this.d);
        }
        if (j > j2) {
            return f(this.c, this.d.d(j - j2, v));
        }
        if (v == this.b) {
            return this;
        }
        return new b<>(j, v, this.c, this.d);
    }

    public final b<V> f(b<V> bVar, b<V> bVar2) {
        if (bVar == this.c && bVar2 == this.d) {
            return this;
        }
        return e(this.a, this.b, bVar, bVar2);
    }

    public final b<V> g(long j) {
        return (this.e == 0 || j == this.a) ? this : new b<>(j, this.b, this.c, this.d);
    }

    public b(long j, V v, b<V> bVar, b<V> bVar2) {
        this.a = j;
        this.b = v;
        this.c = bVar;
        this.d = bVar2;
        this.e = bVar.e + 1 + bVar2.e;
    }
}
