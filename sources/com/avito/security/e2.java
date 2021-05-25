package com.avito.security;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
public final class e2 implements u1<q1> {
    private final CharSequence a;
    private final int b;
    private final int c;
    private final f1<CharSequence, Integer, p<Integer, Integer>> d;

    public static final class a implements Iterator<q1> {
        private int a = -1;
        private int b;
        private int c;
        private q1 d;
        private int e;
        public final /* synthetic */ e2 f;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a(e2 e2Var) {
            this.f = e2Var;
            int i = t1.a(e2Var.b, 0, e2Var.a.length());
            this.b = i;
            this.c = i;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
            if (r0 < r6.f.c) goto L_0x0023;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void a() {
            /*
                r6 = this;
                int r0 = r6.c
                r1 = 0
                if (r0 >= 0) goto L_0x000c
                r6.a = r1
                r0 = 0
                r6.d = r0
                goto L_0x0099
            L_0x000c:
                com.avito.security.e2 r0 = r6.f
                int r0 = com.avito.security.e2.c(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L_0x0023
                int r0 = r6.e
                int r0 = r0 + r3
                r6.e = r0
                com.avito.security.e2 r4 = r6.f
                int r4 = com.avito.security.e2.c(r4)
                if (r0 >= r4) goto L_0x0031
            L_0x0023:
                int r0 = r6.c
                com.avito.security.e2 r4 = r6.f
                java.lang.CharSequence r4 = com.avito.security.e2.b(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L_0x0047
            L_0x0031:
                int r0 = r6.b
                com.avito.security.q1 r1 = new com.avito.security.q1
                com.avito.security.e2 r4 = r6.f
                java.lang.CharSequence r4 = com.avito.security.e2.b(r4)
                int r4 = com.avito.security.p2.a(r4)
                r1.<init>(r0, r4)
            L_0x0042:
                r6.d = r1
            L_0x0044:
                r6.c = r2
                goto L_0x0097
            L_0x0047:
                com.avito.security.e2 r0 = r6.f
                com.avito.security.f1 r0 = com.avito.security.e2.a(r0)
                com.avito.security.e2 r4 = r6.f
                java.lang.CharSequence r4 = com.avito.security.e2.b(r4)
                int r5 = r6.c
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.a(r4, r5)
                com.avito.security.p r0 = (com.avito.security.p) r0
                if (r0 != 0) goto L_0x0073
                int r0 = r6.b
                com.avito.security.q1 r1 = new com.avito.security.q1
                com.avito.security.e2 r4 = r6.f
                java.lang.CharSequence r4 = com.avito.security.e2.b(r4)
                int r4 = com.avito.security.p2.a(r4)
                r1.<init>(r0, r4)
                goto L_0x0042
            L_0x0073:
                java.lang.Object r2 = r0.a()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.b()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.b
                com.avito.security.q1 r4 = com.avito.security.r1.d(r4, r2)
                r6.d = r4
                int r2 = r2 + r0
                r6.b = r2
                if (r0 != 0) goto L_0x0095
                r1 = 1
            L_0x0095:
                int r2 = r2 + r1
                goto L_0x0044
            L_0x0097:
                r6.a = r3
            L_0x0099:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.security.e2.a.a():void");
        }

        /* renamed from: b */
        public q1 next() {
            if (this.a == -1) {
                a();
            }
            if (this.a != 0) {
                q1 q1Var = this.d;
                Objects.requireNonNull(q1Var, "null cannot be cast to non-null type kotlin.ranges.IntRange");
                this.d = null;
                this.a = -1;
                return q1Var;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.a == -1) {
                a();
            }
            return this.a == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.avito.security.f1<? super java.lang.CharSequence, ? super java.lang.Integer, com.avito.security.p<java.lang.Integer, java.lang.Integer>> */
    /* JADX WARN: Multi-variable type inference failed */
    public e2(CharSequence charSequence, int i, int i2, f1<? super CharSequence, ? super Integer, p<Integer, Integer>> f1Var) {
        j1.b(charSequence, "input");
        j1.b(f1Var, "getNextMatch");
        this.a = charSequence;
        this.b = i;
        this.c = i2;
        this.d = f1Var;
    }

    @Override // com.avito.security.u1
    public Iterator<q1> iterator() {
        return new a(this);
    }
}
