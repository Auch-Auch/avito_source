package com.avito.security;
public final class q1 extends o1 {
    private static final q1 e = new q1(1, 0);
    public static final a f = new a(null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h1 h1Var) {
            this();
        }

        public final q1 a() {
            return q1.e;
        }
    }

    public q1(int i, int i2) {
        super(i, i2, 1);
    }

    @Override // com.avito.security.o1, java.lang.Object
    public boolean equals(Object obj) {
        if (obj instanceof q1) {
            if (!isEmpty() || !((q1) obj).isEmpty()) {
                q1 q1Var = (q1) obj;
                if (!(a() == q1Var.a() && b() == q1Var.b())) {
                }
            }
            return true;
        }
        return false;
    }

    public Integer f() {
        return Integer.valueOf(b());
    }

    public Integer g() {
        return Integer.valueOf(a());
    }

    @Override // com.avito.security.o1, java.lang.Object
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (a() * 31) + b();
    }

    @Override // com.avito.security.o1
    public boolean isEmpty() {
        return a() > b();
    }

    @Override // com.avito.security.o1, java.lang.Object
    public String toString() {
        return a() + ".." + b();
    }
}
