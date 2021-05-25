package com.avito.security;
public class o1 implements Iterable<Integer> {
    public static final a d = new a(null);
    private final int a;
    private final int b;
    private final int c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h1 h1Var) {
            this();
        }

        public final o1 a(int i, int i2, int i3) {
            return new o1(i, i2, i3);
        }
    }

    public o1(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i3 != Integer.MIN_VALUE) {
            this.a = i;
            this.b = t0.b(i, i2, i3);
            this.c = i3;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }

    /* renamed from: d */
    public m0 iterator() {
        return new p1(this.a, this.b, this.c);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj instanceof o1) {
            if (!isEmpty() || !((o1) obj).isEmpty()) {
                o1 o1Var = (o1) obj;
                if (!(this.a == o1Var.a && this.b == o1Var.b && this.c == o1Var.c)) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.a * 31) + this.b) * 31) + this.c;
    }

    public boolean isEmpty() {
        return this.c <= 0 ? this.a < this.b : this.a > this.b;
    }

    @Override // java.lang.Object
    public String toString() {
        int i;
        StringBuilder sb;
        if (this.c > 0) {
            sb = new StringBuilder();
            sb.append(this.a);
            sb.append("..");
            sb.append(this.b);
            sb.append(" step ");
            i = this.c;
        } else {
            sb = new StringBuilder();
            sb.append(this.a);
            sb.append(" downTo ");
            sb.append(this.b);
            sb.append(" step ");
            i = -this.c;
        }
        sb.append(i);
        return sb.toString();
    }
}
