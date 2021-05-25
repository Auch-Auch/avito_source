package com.yandex.metrica.impl.ob;

import java.io.IOException;
import java.util.Arrays;
public interface uu {

    public static final class a extends e {
        private static volatile a[] l;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public String g;
        public boolean h;
        public int i;
        public int j;
        public long k;

        public a() {
            e();
        }

        public static a[] d() {
            if (l == null) {
                synchronized (c.a) {
                    if (l == null) {
                        l = new a[0];
                    }
                }
            }
            return l;
        }

        /* renamed from: b */
        public a a(a aVar) throws IOException {
            while (true) {
                int a = aVar.a();
                switch (a) {
                    case 0:
                        return this;
                    case 8:
                        this.b = aVar.k();
                        break;
                    case 16:
                        this.c = aVar.l();
                        break;
                    case 24:
                        this.d = aVar.k();
                        break;
                    case 32:
                        this.e = aVar.k();
                        break;
                    case 40:
                        this.f = aVar.k();
                        break;
                    case 50:
                        this.g = aVar.i();
                        break;
                    case 56:
                        this.h = aVar.h();
                        break;
                    case 64:
                        int g2 = aVar.g();
                        if (g2 != 0 && g2 != 1 && g2 != 2 && g2 != 3 && g2 != 4) {
                            break;
                        } else {
                            this.i = g2;
                            break;
                        }
                        break;
                    case 72:
                        this.j = aVar.k();
                        break;
                    case 80:
                        this.k = aVar.e();
                        break;
                    default:
                        if (g.a(aVar, a)) {
                            break;
                        } else {
                            return this;
                        }
                }
            }
        }

        @Override // com.yandex.metrica.impl.ob.e
        public int c() {
            int c2 = super.c();
            int i2 = this.b;
            if (i2 != -1) {
                c2 += b.e(1, i2);
            }
            int i3 = this.c;
            if (i3 != 0) {
                c2 += b.f(2, i3);
            }
            int i4 = this.d;
            if (i4 != -1) {
                c2 += b.e(3, i4);
            }
            int i5 = this.e;
            if (i5 != -1) {
                c2 += b.e(4, i5);
            }
            int i6 = this.f;
            if (i6 != -1) {
                c2 += b.e(5, i6);
            }
            if (!this.g.equals("")) {
                c2 += b.b(6, this.g);
            }
            boolean z = this.h;
            if (z) {
                c2 += b.b(7, z);
            }
            int i7 = this.i;
            if (i7 != 0) {
                c2 += b.d(8, i7);
            }
            int i8 = this.j;
            if (i8 != -1) {
                c2 += b.e(9, i8);
            }
            long j2 = this.k;
            return j2 != 0 ? c2 + b.d(10, j2) : c2;
        }

        public a e() {
            this.b = -1;
            this.c = 0;
            this.d = -1;
            this.e = -1;
            this.f = -1;
            this.g = "";
            this.h = false;
            this.i = 0;
            this.j = -1;
            this.k = 0;
            this.a = -1;
            return this;
        }

        @Override // com.yandex.metrica.impl.ob.e
        public void a(b bVar) throws IOException {
            int i2 = this.b;
            if (i2 != -1) {
                bVar.b(1, i2);
            }
            int i3 = this.c;
            if (i3 != 0) {
                bVar.c(2, i3);
            }
            int i4 = this.d;
            if (i4 != -1) {
                bVar.b(3, i4);
            }
            int i5 = this.e;
            if (i5 != -1) {
                bVar.b(4, i5);
            }
            int i6 = this.f;
            if (i6 != -1) {
                bVar.b(5, i6);
            }
            if (!this.g.equals("")) {
                bVar.a(6, this.g);
            }
            boolean z = this.h;
            if (z) {
                bVar.a(7, z);
            }
            int i7 = this.i;
            if (i7 != 0) {
                bVar.a(8, i7);
            }
            int i8 = this.j;
            if (i8 != -1) {
                bVar.b(9, i8);
            }
            long j2 = this.k;
            if (j2 != 0) {
                bVar.a(10, j2);
            }
            super.a(bVar);
        }
    }

    public static final class b extends e {
        public C0342b[] b;
        public a[] c;

        public static final class a extends e {
            private static volatile a[] i;
            public long b;
            public long c;
            public a[] d;
            public d[] e;
            public long f;
            public int g;
            public int h;

            public a() {
                e();
            }

            public static a[] d() {
                if (i == null) {
                    synchronized (c.a) {
                        if (i == null) {
                            i = new a[0];
                        }
                    }
                }
                return i;
            }

            /* renamed from: b */
            public a a(a aVar) throws IOException {
                while (true) {
                    int a = aVar.a();
                    if (a == 0) {
                        return this;
                    }
                    if (a == 8) {
                        this.b = aVar.e();
                    } else if (a == 16) {
                        this.c = aVar.e();
                    } else if (a == 26) {
                        int b2 = g.b(aVar, 26);
                        a[] aVarArr = this.d;
                        int length = aVarArr == null ? 0 : aVarArr.length;
                        int i2 = b2 + length;
                        a[] aVarArr2 = new a[i2];
                        if (length != 0) {
                            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                        }
                        while (length < i2 - 1) {
                            aVarArr2[length] = new a();
                            aVar.a(aVarArr2[length]);
                            aVar.a();
                            length++;
                        }
                        aVarArr2[length] = new a();
                        aVar.a(aVarArr2[length]);
                        this.d = aVarArr2;
                    } else if (a == 34) {
                        int b3 = g.b(aVar, 34);
                        d[] dVarArr = this.e;
                        int length2 = dVarArr == null ? 0 : dVarArr.length;
                        int i3 = b3 + length2;
                        d[] dVarArr2 = new d[i3];
                        if (length2 != 0) {
                            System.arraycopy(dVarArr, 0, dVarArr2, 0, length2);
                        }
                        while (length2 < i3 - 1) {
                            dVarArr2[length2] = new d();
                            aVar.a(dVarArr2[length2]);
                            aVar.a();
                            length2++;
                        }
                        dVarArr2[length2] = new d();
                        aVar.a(dVarArr2[length2]);
                        this.e = dVarArr2;
                    } else if (a == 40) {
                        this.f = aVar.e();
                    } else if (a == 48) {
                        int g2 = aVar.g();
                        if (g2 == 0 || g2 == 1 || g2 == 2 || g2 == 3 || g2 == 4) {
                            this.g = g2;
                        }
                    } else if (a == 56) {
                        int g3 = aVar.g();
                        if (g3 == 0 || g3 == 1 || g3 == 2 || g3 == 3) {
                            this.h = g3;
                        }
                    } else if (!g.a(aVar, a)) {
                        return this;
                    }
                }
            }

            @Override // com.yandex.metrica.impl.ob.e
            public int c() {
                int d2 = b.d(2, this.c) + b.d(1, this.b) + super.c();
                a[] aVarArr = this.d;
                int i2 = 0;
                if (aVarArr != null && aVarArr.length > 0) {
                    int i3 = 0;
                    while (true) {
                        a[] aVarArr2 = this.d;
                        if (i3 >= aVarArr2.length) {
                            break;
                        }
                        a aVar = aVarArr2[i3];
                        if (aVar != null) {
                            d2 += b.b(3, aVar);
                        }
                        i3++;
                    }
                }
                d[] dVarArr = this.e;
                if (dVarArr != null && dVarArr.length > 0) {
                    while (true) {
                        d[] dVarArr2 = this.e;
                        if (i2 >= dVarArr2.length) {
                            break;
                        }
                        d dVar = dVarArr2[i2];
                        if (dVar != null) {
                            d2 += b.b(4, dVar);
                        }
                        i2++;
                    }
                }
                long j = this.f;
                if (j != 0) {
                    d2 += b.d(5, j);
                }
                int i4 = this.g;
                if (i4 != 0) {
                    d2 += b.d(6, i4);
                }
                int i5 = this.h;
                return i5 != 0 ? d2 + b.d(7, i5) : d2;
            }

            public a e() {
                this.b = 0;
                this.c = 0;
                this.d = a.d();
                this.e = d.d();
                this.f = 0;
                this.g = 0;
                this.h = 0;
                this.a = -1;
                return this;
            }

            @Override // com.yandex.metrica.impl.ob.e
            public void a(b bVar) throws IOException {
                bVar.a(1, this.b);
                bVar.a(2, this.c);
                a[] aVarArr = this.d;
                int i2 = 0;
                if (aVarArr != null && aVarArr.length > 0) {
                    int i3 = 0;
                    while (true) {
                        a[] aVarArr2 = this.d;
                        if (i3 >= aVarArr2.length) {
                            break;
                        }
                        a aVar = aVarArr2[i3];
                        if (aVar != null) {
                            bVar.a(3, aVar);
                        }
                        i3++;
                    }
                }
                d[] dVarArr = this.e;
                if (dVarArr != null && dVarArr.length > 0) {
                    while (true) {
                        d[] dVarArr2 = this.e;
                        if (i2 >= dVarArr2.length) {
                            break;
                        }
                        d dVar = dVarArr2[i2];
                        if (dVar != null) {
                            bVar.a(4, dVar);
                        }
                        i2++;
                    }
                }
                long j = this.f;
                if (j != 0) {
                    bVar.a(5, j);
                }
                int i4 = this.g;
                if (i4 != 0) {
                    bVar.a(6, i4);
                }
                int i5 = this.h;
                if (i5 != 0) {
                    bVar.a(7, i5);
                }
                super.a(bVar);
            }
        }

        /* renamed from: com.yandex.metrica.impl.ob.uu$b$b  reason: collision with other inner class name */
        public static final class C0342b extends e {
            private static volatile C0342b[] o;
            public long b;
            public long c;
            public long d;
            public double e;
            public double f;
            public int g;
            public int h;
            public int i;
            public int j;
            public int k;
            public int l;
            public long m;
            public int n;

            public C0342b() {
                e();
            }

            public static C0342b[] d() {
                if (o == null) {
                    synchronized (c.a) {
                        if (o == null) {
                            o = new C0342b[0];
                        }
                    }
                }
                return o;
            }

            /* renamed from: b */
            public C0342b a(a aVar) throws IOException {
                while (true) {
                    int a = aVar.a();
                    switch (a) {
                        case 0:
                            return this;
                        case 8:
                            this.b = aVar.e();
                            break;
                        case 16:
                            this.c = aVar.e();
                            break;
                        case 24:
                            this.d = aVar.e();
                            break;
                        case 33:
                            this.e = aVar.c();
                            break;
                        case 41:
                            this.f = aVar.c();
                            break;
                        case 48:
                            this.g = aVar.k();
                            break;
                        case 56:
                            this.h = aVar.k();
                            break;
                        case 64:
                            this.i = aVar.k();
                            break;
                        case 72:
                            this.j = aVar.g();
                            break;
                        case 80:
                            int g2 = aVar.g();
                            if (g2 != 0 && g2 != 1 && g2 != 2 && g2 != 3) {
                                break;
                            } else {
                                this.k = g2;
                                break;
                            }
                        case 88:
                            int g3 = aVar.g();
                            if (g3 != 0 && g3 != 1 && g3 != 2 && g3 != 3) {
                                break;
                            } else {
                                this.l = g3;
                                break;
                            }
                        case 96:
                            this.m = aVar.e();
                            break;
                        case 104:
                            int g4 = aVar.g();
                            if (g4 != 0 && g4 != 1 && g4 != 2 && g4 != 3 && g4 != 4) {
                                break;
                            } else {
                                this.n = g4;
                                break;
                            }
                        default:
                            if (g.a(aVar, a)) {
                                break;
                            } else {
                                return this;
                            }
                    }
                }
            }

            @Override // com.yandex.metrica.impl.ob.e
            public int c() {
                int d2 = b.d(2, this.c) + b.d(1, this.b) + super.c();
                long j2 = this.d;
                if (j2 != 0) {
                    d2 += b.d(3, j2);
                }
                int b2 = b.b(5, this.f) + b.b(4, this.e) + d2;
                int i2 = this.g;
                if (i2 != 0) {
                    b2 += b.e(6, i2);
                }
                int i3 = this.h;
                if (i3 != 0) {
                    b2 += b.e(7, i3);
                }
                int i4 = this.i;
                if (i4 != 0) {
                    b2 += b.e(8, i4);
                }
                int i5 = this.j;
                if (i5 != 0) {
                    b2 += b.d(9, i5);
                }
                int i6 = this.k;
                if (i6 != 0) {
                    b2 += b.d(10, i6);
                }
                int i7 = this.l;
                if (i7 != 0) {
                    b2 += b.d(11, i7);
                }
                long j3 = this.m;
                if (j3 != 0) {
                    b2 += b.d(12, j3);
                }
                int i8 = this.n;
                return i8 != 0 ? b2 + b.d(13, i8) : b2;
            }

            public C0342b e() {
                this.b = 0;
                this.c = 0;
                this.d = 0;
                this.e = 0.0d;
                this.f = 0.0d;
                this.g = 0;
                this.h = 0;
                this.i = 0;
                this.j = 0;
                this.k = 0;
                this.l = 0;
                this.m = 0;
                this.n = 0;
                this.a = -1;
                return this;
            }

            @Override // com.yandex.metrica.impl.ob.e
            public void a(b bVar) throws IOException {
                bVar.a(1, this.b);
                bVar.a(2, this.c);
                long j2 = this.d;
                if (j2 != 0) {
                    bVar.a(3, j2);
                }
                bVar.a(4, this.e);
                bVar.a(5, this.f);
                int i2 = this.g;
                if (i2 != 0) {
                    bVar.b(6, i2);
                }
                int i3 = this.h;
                if (i3 != 0) {
                    bVar.b(7, i3);
                }
                int i4 = this.i;
                if (i4 != 0) {
                    bVar.b(8, i4);
                }
                int i5 = this.j;
                if (i5 != 0) {
                    bVar.a(9, i5);
                }
                int i6 = this.k;
                if (i6 != 0) {
                    bVar.a(10, i6);
                }
                int i7 = this.l;
                if (i7 != 0) {
                    bVar.a(11, i7);
                }
                long j3 = this.m;
                if (j3 != 0) {
                    bVar.a(12, j3);
                }
                int i8 = this.n;
                if (i8 != 0) {
                    bVar.a(13, i8);
                }
                super.a(bVar);
            }
        }

        public b() {
            d();
        }

        /* renamed from: b */
        public b a(a aVar) throws IOException {
            while (true) {
                int a3 = aVar.a();
                if (a3 == 0) {
                    return this;
                }
                if (a3 == 10) {
                    int b2 = g.b(aVar, 10);
                    C0342b[] bVarArr = this.b;
                    int length = bVarArr == null ? 0 : bVarArr.length;
                    int i = b2 + length;
                    C0342b[] bVarArr2 = new C0342b[i];
                    if (length != 0) {
                        System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                    }
                    while (length < i - 1) {
                        bVarArr2[length] = new C0342b();
                        aVar.a(bVarArr2[length]);
                        aVar.a();
                        length++;
                    }
                    bVarArr2[length] = new C0342b();
                    aVar.a(bVarArr2[length]);
                    this.b = bVarArr2;
                } else if (a3 == 18) {
                    int b3 = g.b(aVar, 18);
                    a[] aVarArr = this.c;
                    int length2 = aVarArr == null ? 0 : aVarArr.length;
                    int i2 = b3 + length2;
                    a[] aVarArr2 = new a[i2];
                    if (length2 != 0) {
                        System.arraycopy(aVarArr, 0, aVarArr2, 0, length2);
                    }
                    while (length2 < i2 - 1) {
                        aVarArr2[length2] = new a();
                        aVar.a(aVarArr2[length2]);
                        aVar.a();
                        length2++;
                    }
                    aVarArr2[length2] = new a();
                    aVar.a(aVarArr2[length2]);
                    this.c = aVarArr2;
                } else if (!g.a(aVar, a3)) {
                    return this;
                }
            }
        }

        @Override // com.yandex.metrica.impl.ob.e
        public int c() {
            int c2 = super.c();
            C0342b[] bVarArr = this.b;
            int i = 0;
            if (bVarArr != null && bVarArr.length > 0) {
                int i2 = 0;
                while (true) {
                    C0342b[] bVarArr2 = this.b;
                    if (i2 >= bVarArr2.length) {
                        break;
                    }
                    C0342b bVar = bVarArr2[i2];
                    if (bVar != null) {
                        c2 += b.b(1, bVar);
                    }
                    i2++;
                }
            }
            a[] aVarArr = this.c;
            if (aVarArr != null && aVarArr.length > 0) {
                while (true) {
                    a[] aVarArr2 = this.c;
                    if (i >= aVarArr2.length) {
                        break;
                    }
                    a aVar = aVarArr2[i];
                    if (aVar != null) {
                        c2 += b.b(2, aVar);
                    }
                    i++;
                }
            }
            return c2;
        }

        public b d() {
            this.b = C0342b.d();
            this.c = a.d();
            this.a = -1;
            return this;
        }

        @Override // com.yandex.metrica.impl.ob.e
        public void a(b bVar) throws IOException {
            C0342b[] bVarArr = this.b;
            int i = 0;
            if (bVarArr != null && bVarArr.length > 0) {
                int i2 = 0;
                while (true) {
                    C0342b[] bVarArr2 = this.b;
                    if (i2 >= bVarArr2.length) {
                        break;
                    }
                    C0342b bVar2 = bVarArr2[i2];
                    if (bVar2 != null) {
                        bVar.a(1, bVar2);
                    }
                    i2++;
                }
            }
            a[] aVarArr = this.c;
            if (aVarArr != null && aVarArr.length > 0) {
                while (true) {
                    a[] aVarArr2 = this.c;
                    if (i >= aVarArr2.length) {
                        break;
                    }
                    a aVar = aVarArr2[i];
                    if (aVar != null) {
                        bVar.a(2, aVar);
                    }
                    i++;
                }
            }
            super.a(bVar);
        }
    }

    public static final class c extends e {
        public e[] b;
        public d c;
        public a[] d;
        public C0343c[] e;
        public String[] f;
        public f[] g;
        public String[] h;

        public static final class a extends e {
            private static volatile a[] d;
            public String b;
            public String c;

            public a() {
                e();
            }

            public static a[] d() {
                if (d == null) {
                    synchronized (c.a) {
                        if (d == null) {
                            d = new a[0];
                        }
                    }
                }
                return d;
            }

            /* renamed from: b */
            public a a(a aVar) throws IOException {
                while (true) {
                    int a = aVar.a();
                    if (a == 0) {
                        return this;
                    }
                    if (a == 10) {
                        this.b = aVar.i();
                    } else if (a == 18) {
                        this.c = aVar.i();
                    } else if (!g.a(aVar, a)) {
                        return this;
                    }
                }
            }

            @Override // com.yandex.metrica.impl.ob.e
            public int c() {
                return b.b(2, this.c) + b.b(1, this.b) + super.c();
            }

            public a e() {
                this.b = "";
                this.c = "";
                this.a = -1;
                return this;
            }

            @Override // com.yandex.metrica.impl.ob.e
            public void a(b bVar) throws IOException {
                bVar.a(1, this.b);
                bVar.a(2, this.c);
                super.a(bVar);
            }
        }

        public static final class b extends e {
            public double b;
            public double c;
            public long d;
            public int e;
            public int f;
            public int g;
            public int h;
            public int i;
            public String j;

            public b() {
                d();
            }

            /* renamed from: b */
            public b a(a aVar) throws IOException {
                while (true) {
                    int a = aVar.a();
                    if (a == 0) {
                        return this;
                    }
                    if (a == 9) {
                        this.b = aVar.c();
                    } else if (a == 17) {
                        this.c = aVar.c();
                    } else if (a == 24) {
                        this.d = aVar.e();
                    } else if (a == 32) {
                        this.e = aVar.k();
                    } else if (a == 40) {
                        this.f = aVar.k();
                    } else if (a == 48) {
                        this.g = aVar.k();
                    } else if (a == 56) {
                        this.h = aVar.g();
                    } else if (a == 64) {
                        int g2 = aVar.g();
                        if (g2 == 0 || g2 == 1 || g2 == 2) {
                            this.i = g2;
                        }
                    } else if (a == 74) {
                        this.j = aVar.i();
                    } else if (!g.a(aVar, a)) {
                        return this;
                    }
                }
            }

            @Override // com.yandex.metrica.impl.ob.e
            public int c() {
                int b2 = b.b(2, this.c) + b.b(1, this.b) + super.c();
                long j2 = this.d;
                if (j2 != 0) {
                    b2 += b.d(3, j2);
                }
                int i2 = this.e;
                if (i2 != 0) {
                    b2 += b.e(4, i2);
                }
                int i3 = this.f;
                if (i3 != 0) {
                    b2 += b.e(5, i3);
                }
                int i4 = this.g;
                if (i4 != 0) {
                    b2 += b.e(6, i4);
                }
                int i5 = this.h;
                if (i5 != 0) {
                    b2 += b.d(7, i5);
                }
                int i6 = this.i;
                if (i6 != 0) {
                    b2 += b.d(8, i6);
                }
                return !this.j.equals("") ? b2 + b.b(9, this.j) : b2;
            }

            public b d() {
                this.b = 0.0d;
                this.c = 0.0d;
                this.d = 0;
                this.e = 0;
                this.f = 0;
                this.g = 0;
                this.h = 0;
                this.i = 0;
                this.j = "";
                this.a = -1;
                return this;
            }

            @Override // com.yandex.metrica.impl.ob.e
            public void a(b bVar) throws IOException {
                bVar.a(1, this.b);
                bVar.a(2, this.c);
                long j2 = this.d;
                if (j2 != 0) {
                    bVar.a(3, j2);
                }
                int i2 = this.e;
                if (i2 != 0) {
                    bVar.b(4, i2);
                }
                int i3 = this.f;
                if (i3 != 0) {
                    bVar.b(5, i3);
                }
                int i4 = this.g;
                if (i4 != 0) {
                    bVar.b(6, i4);
                }
                int i5 = this.h;
                if (i5 != 0) {
                    bVar.a(7, i5);
                }
                int i6 = this.i;
                if (i6 != 0) {
                    bVar.a(8, i6);
                }
                if (!this.j.equals("")) {
                    bVar.a(9, this.j);
                }
                super.a(bVar);
            }
        }

        /* renamed from: com.yandex.metrica.impl.ob.uu$c$c  reason: collision with other inner class name */
        public static final class C0343c extends e {
            private static volatile C0343c[] d;
            public String b;
            public String c;

            public C0343c() {
                e();
            }

            public static C0343c[] d() {
                if (d == null) {
                    synchronized (c.a) {
                        if (d == null) {
                            d = new C0343c[0];
                        }
                    }
                }
                return d;
            }

            /* renamed from: b */
            public C0343c a(a aVar) throws IOException {
                while (true) {
                    int a = aVar.a();
                    if (a == 0) {
                        return this;
                    }
                    if (a == 10) {
                        this.b = aVar.i();
                    } else if (a == 18) {
                        this.c = aVar.i();
                    } else if (!g.a(aVar, a)) {
                        return this;
                    }
                }
            }

            @Override // com.yandex.metrica.impl.ob.e
            public int c() {
                return b.b(2, this.c) + b.b(1, this.b) + super.c();
            }

            public C0343c e() {
                this.b = "";
                this.c = "";
                this.a = -1;
                return this;
            }

            @Override // com.yandex.metrica.impl.ob.e
            public void a(b bVar) throws IOException {
                bVar.a(1, this.b);
                bVar.a(2, this.c);
                super.a(bVar);
            }
        }

        public static final class d extends e {
            public String b;
            public String c;
            public String d;
            public int e;
            public String f;
            public String g;
            public boolean h;
            public int i;
            public String j;
            public String k;
            public String l;
            public int m;
            public a[] n;
            public String o;

            public static final class a extends e {
                private static volatile a[] d;
                public String b;
                public long c;

                public a() {
                    e();
                }

                public static a[] d() {
                    if (d == null) {
                        synchronized (c.a) {
                            if (d == null) {
                                d = new a[0];
                            }
                        }
                    }
                    return d;
                }

                /* renamed from: b */
                public a a(a aVar) throws IOException {
                    while (true) {
                        int a = aVar.a();
                        if (a == 0) {
                            return this;
                        }
                        if (a == 10) {
                            this.b = aVar.i();
                        } else if (a == 16) {
                            this.c = aVar.e();
                        } else if (!g.a(aVar, a)) {
                            return this;
                        }
                    }
                }

                @Override // com.yandex.metrica.impl.ob.e
                public int c() {
                    return b.d(2, this.c) + b.b(1, this.b) + super.c();
                }

                public a e() {
                    this.b = "";
                    this.c = 0;
                    this.a = -1;
                    return this;
                }

                @Override // com.yandex.metrica.impl.ob.e
                public void a(b bVar) throws IOException {
                    bVar.a(1, this.b);
                    bVar.a(2, this.c);
                    super.a(bVar);
                }
            }

            public d() {
                d();
            }

            /* renamed from: b */
            public d a(a aVar) throws IOException {
                while (true) {
                    int a3 = aVar.a();
                    switch (a3) {
                        case 0:
                            return this;
                        case 10:
                            this.b = aVar.i();
                            break;
                        case 18:
                            this.c = aVar.i();
                            break;
                        case 34:
                            this.d = aVar.i();
                            break;
                        case 40:
                            this.e = aVar.k();
                            break;
                        case 82:
                            this.f = aVar.i();
                            break;
                        case 122:
                            this.g = aVar.i();
                            break;
                        case 136:
                            this.h = aVar.h();
                            break;
                        case 144:
                            this.i = aVar.k();
                            break;
                        case 154:
                            this.j = aVar.i();
                            break;
                        case 162:
                            this.k = aVar.i();
                            break;
                        case 170:
                            this.l = aVar.i();
                            break;
                        case 176:
                            this.m = aVar.k();
                            break;
                        case 186:
                            int b2 = g.b(aVar, 186);
                            a[] aVarArr = this.n;
                            int length = aVarArr == null ? 0 : aVarArr.length;
                            int i2 = b2 + length;
                            a[] aVarArr2 = new a[i2];
                            if (length != 0) {
                                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                            }
                            while (length < i2 - 1) {
                                aVarArr2[length] = new a();
                                aVar.a(aVarArr2[length]);
                                aVar.a();
                                length++;
                            }
                            aVarArr2[length] = new a();
                            aVar.a(aVarArr2[length]);
                            this.n = aVarArr2;
                            break;
                        case 194:
                            this.o = aVar.i();
                            break;
                        default:
                            if (g.a(aVar, a3)) {
                                break;
                            } else {
                                return this;
                            }
                    }
                }
            }

            @Override // com.yandex.metrica.impl.ob.e
            public int c() {
                int c2 = super.c();
                if (!this.b.equals("")) {
                    c2 += b.b(1, this.b);
                }
                if (!this.c.equals("")) {
                    c2 += b.b(2, this.c);
                }
                if (!this.d.equals("")) {
                    c2 += b.b(4, this.d);
                }
                int i2 = this.e;
                if (i2 != 0) {
                    c2 += b.e(5, i2);
                }
                if (!this.f.equals("")) {
                    c2 += b.b(10, this.f);
                }
                if (!this.g.equals("")) {
                    c2 += b.b(15, this.g);
                }
                boolean z = this.h;
                if (z) {
                    c2 += b.b(17, z);
                }
                int i3 = this.i;
                if (i3 != 0) {
                    c2 += b.e(18, i3);
                }
                if (!this.j.equals("")) {
                    c2 += b.b(19, this.j);
                }
                if (!this.k.equals("")) {
                    c2 += b.b(20, this.k);
                }
                if (!this.l.equals("")) {
                    c2 += b.b(21, this.l);
                }
                int i4 = this.m;
                if (i4 != 0) {
                    c2 += b.e(22, i4);
                }
                a[] aVarArr = this.n;
                if (aVarArr != null && aVarArr.length > 0) {
                    int i5 = 0;
                    while (true) {
                        a[] aVarArr2 = this.n;
                        if (i5 >= aVarArr2.length) {
                            break;
                        }
                        a aVar = aVarArr2[i5];
                        if (aVar != null) {
                            c2 += b.b(23, aVar);
                        }
                        i5++;
                    }
                }
                return !this.o.equals("") ? c2 + b.b(24, this.o) : c2;
            }

            public d d() {
                this.b = "";
                this.c = "";
                this.d = "";
                this.e = 0;
                this.f = "";
                this.g = "";
                this.h = false;
                this.i = 0;
                this.j = "";
                this.k = "";
                this.l = "";
                this.m = 0;
                this.n = a.d();
                this.o = "";
                this.a = -1;
                return this;
            }

            @Override // com.yandex.metrica.impl.ob.e
            public void a(b bVar) throws IOException {
                if (!this.b.equals("")) {
                    bVar.a(1, this.b);
                }
                if (!this.c.equals("")) {
                    bVar.a(2, this.c);
                }
                if (!this.d.equals("")) {
                    bVar.a(4, this.d);
                }
                int i2 = this.e;
                if (i2 != 0) {
                    bVar.b(5, i2);
                }
                if (!this.f.equals("")) {
                    bVar.a(10, this.f);
                }
                if (!this.g.equals("")) {
                    bVar.a(15, this.g);
                }
                boolean z = this.h;
                if (z) {
                    bVar.a(17, z);
                }
                int i3 = this.i;
                if (i3 != 0) {
                    bVar.b(18, i3);
                }
                if (!this.j.equals("")) {
                    bVar.a(19, this.j);
                }
                if (!this.k.equals("")) {
                    bVar.a(20, this.k);
                }
                if (!this.l.equals("")) {
                    bVar.a(21, this.l);
                }
                int i4 = this.m;
                if (i4 != 0) {
                    bVar.b(22, i4);
                }
                a[] aVarArr = this.n;
                if (aVarArr != null && aVarArr.length > 0) {
                    int i5 = 0;
                    while (true) {
                        a[] aVarArr2 = this.n;
                        if (i5 >= aVarArr2.length) {
                            break;
                        }
                        a aVar = aVarArr2[i5];
                        if (aVar != null) {
                            bVar.a(23, aVar);
                        }
                        i5++;
                    }
                }
                if (!this.o.equals("")) {
                    bVar.a(24, this.o);
                }
                super.a(bVar);
            }
        }

        public static final class e extends e {
            private static volatile e[] e;
            public long b;
            public b c;
            public a[] d;

            public static final class a extends e {
                private static volatile a[] t;
                public long b;
                public long c;
                public int d;
                public String e;
                public byte[] f;
                public b g;
                public b h;
                public String i;
                public C0344a j;
                public int k;
                public int l;
                public int m;
                public byte[] n;
                public int o;
                public long p;
                public long q;
                public int r;
                public int s;

                /* renamed from: com.yandex.metrica.impl.ob.uu$c$e$a$a  reason: collision with other inner class name */
                public static final class C0344a extends e {
                    public String b;
                    public String c;
                    public String d;

                    public C0344a() {
                        d();
                    }

                    /* renamed from: b */
                    public C0344a a(a aVar) throws IOException {
                        while (true) {
                            int a = aVar.a();
                            if (a == 0) {
                                return this;
                            }
                            if (a == 10) {
                                this.b = aVar.i();
                            } else if (a == 18) {
                                this.c = aVar.i();
                            } else if (a == 26) {
                                this.d = aVar.i();
                            } else if (!g.a(aVar, a)) {
                                return this;
                            }
                        }
                    }

                    @Override // com.yandex.metrica.impl.ob.e
                    public int c() {
                        int b2 = b.b(1, this.b) + super.c();
                        if (!this.c.equals("")) {
                            b2 += b.b(2, this.c);
                        }
                        return !this.d.equals("") ? b2 + b.b(3, this.d) : b2;
                    }

                    public C0344a d() {
                        this.b = "";
                        this.c = "";
                        this.d = "";
                        this.a = -1;
                        return this;
                    }

                    @Override // com.yandex.metrica.impl.ob.e
                    public void a(b bVar) throws IOException {
                        bVar.a(1, this.b);
                        if (!this.c.equals("")) {
                            bVar.a(2, this.c);
                        }
                        if (!this.d.equals("")) {
                            bVar.a(3, this.d);
                        }
                        super.a(bVar);
                    }
                }

                public static final class b extends e {
                    public a[] b;
                    public d[] c;
                    public int d;
                    public String e;
                    public C0345a f;

                    /* renamed from: com.yandex.metrica.impl.ob.uu$c$e$a$b$a  reason: collision with other inner class name */
                    public static final class C0345a extends e {
                        public String b;
                        public int c;

                        public C0345a() {
                            d();
                        }

                        /* renamed from: b */
                        public C0345a a(a aVar) throws IOException {
                            while (true) {
                                int a = aVar.a();
                                if (a == 0) {
                                    return this;
                                }
                                if (a == 10) {
                                    this.b = aVar.i();
                                } else if (a == 16) {
                                    int g = aVar.g();
                                    if (g == 0 || g == 1 || g == 2) {
                                        this.c = g;
                                    }
                                } else if (!g.a(aVar, a)) {
                                    return this;
                                }
                            }
                        }

                        @Override // com.yandex.metrica.impl.ob.e
                        public int c() {
                            int b2 = b.b(1, this.b) + super.c();
                            int i = this.c;
                            return i != 0 ? b2 + b.d(2, i) : b2;
                        }

                        public C0345a d() {
                            this.b = "";
                            this.c = 0;
                            this.a = -1;
                            return this;
                        }

                        @Override // com.yandex.metrica.impl.ob.e
                        public void a(b bVar) throws IOException {
                            bVar.a(1, this.b);
                            int i = this.c;
                            if (i != 0) {
                                bVar.a(2, i);
                            }
                            super.a(bVar);
                        }
                    }

                    public b() {
                        d();
                    }

                    /* renamed from: b */
                    public b a(a aVar) throws IOException {
                        while (true) {
                            int a = aVar.a();
                            if (a == 0) {
                                return this;
                            }
                            if (a == 10) {
                                int b2 = g.b(aVar, 10);
                                a[] aVarArr = this.b;
                                int length = aVarArr == null ? 0 : aVarArr.length;
                                int i = b2 + length;
                                a[] aVarArr2 = new a[i];
                                if (length != 0) {
                                    System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                                }
                                while (length < i - 1) {
                                    aVarArr2[length] = new a();
                                    aVar.a(aVarArr2[length]);
                                    aVar.a();
                                    length++;
                                }
                                aVarArr2[length] = new a();
                                aVar.a(aVarArr2[length]);
                                this.b = aVarArr2;
                            } else if (a == 18) {
                                int b3 = g.b(aVar, 18);
                                d[] dVarArr = this.c;
                                int length2 = dVarArr == null ? 0 : dVarArr.length;
                                int i2 = b3 + length2;
                                d[] dVarArr2 = new d[i2];
                                if (length2 != 0) {
                                    System.arraycopy(dVarArr, 0, dVarArr2, 0, length2);
                                }
                                while (length2 < i2 - 1) {
                                    dVarArr2[length2] = new d();
                                    aVar.a(dVarArr2[length2]);
                                    aVar.a();
                                    length2++;
                                }
                                dVarArr2[length2] = new d();
                                aVar.a(dVarArr2[length2]);
                                this.c = dVarArr2;
                            } else if (a == 24) {
                                int g = aVar.g();
                                switch (g) {
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 8:
                                    case 9:
                                    case 10:
                                    case 11:
                                    case 12:
                                        this.d = g;
                                        continue;
                                }
                            } else if (a == 34) {
                                this.e = aVar.i();
                            } else if (a == 42) {
                                if (this.f == null) {
                                    this.f = new C0345a();
                                }
                                aVar.a(this.f);
                            } else if (!g.a(aVar, a)) {
                                return this;
                            }
                        }
                    }

                    @Override // com.yandex.metrica.impl.ob.e
                    public int c() {
                        int c2 = super.c();
                        a[] aVarArr = this.b;
                        int i = 0;
                        if (aVarArr != null && aVarArr.length > 0) {
                            int i2 = 0;
                            while (true) {
                                a[] aVarArr2 = this.b;
                                if (i2 >= aVarArr2.length) {
                                    break;
                                }
                                a aVar = aVarArr2[i2];
                                if (aVar != null) {
                                    c2 += b.b(1, aVar);
                                }
                                i2++;
                            }
                        }
                        d[] dVarArr = this.c;
                        if (dVarArr != null && dVarArr.length > 0) {
                            while (true) {
                                d[] dVarArr2 = this.c;
                                if (i >= dVarArr2.length) {
                                    break;
                                }
                                d dVar = dVarArr2[i];
                                if (dVar != null) {
                                    c2 += b.b(2, dVar);
                                }
                                i++;
                            }
                        }
                        int i3 = this.d;
                        if (i3 != 2) {
                            c2 += b.d(3, i3);
                        }
                        if (!this.e.equals("")) {
                            c2 += b.b(4, this.e);
                        }
                        C0345a aVar2 = this.f;
                        return aVar2 != null ? c2 + b.b(5, aVar2) : c2;
                    }

                    public b d() {
                        this.b = a.d();
                        this.c = d.d();
                        this.d = 2;
                        this.e = "";
                        this.f = null;
                        this.a = -1;
                        return this;
                    }

                    @Override // com.yandex.metrica.impl.ob.e
                    public void a(b bVar) throws IOException {
                        a[] aVarArr = this.b;
                        int i = 0;
                        if (aVarArr != null && aVarArr.length > 0) {
                            int i2 = 0;
                            while (true) {
                                a[] aVarArr2 = this.b;
                                if (i2 >= aVarArr2.length) {
                                    break;
                                }
                                a aVar = aVarArr2[i2];
                                if (aVar != null) {
                                    bVar.a(1, aVar);
                                }
                                i2++;
                            }
                        }
                        d[] dVarArr = this.c;
                        if (dVarArr != null && dVarArr.length > 0) {
                            while (true) {
                                d[] dVarArr2 = this.c;
                                if (i >= dVarArr2.length) {
                                    break;
                                }
                                d dVar = dVarArr2[i];
                                if (dVar != null) {
                                    bVar.a(2, dVar);
                                }
                                i++;
                            }
                        }
                        int i3 = this.d;
                        if (i3 != 2) {
                            bVar.a(3, i3);
                        }
                        if (!this.e.equals("")) {
                            bVar.a(4, this.e);
                        }
                        C0345a aVar2 = this.f;
                        if (aVar2 != null) {
                            bVar.a(5, aVar2);
                        }
                        super.a(bVar);
                    }
                }

                public a() {
                    e();
                }

                public static a[] d() {
                    if (t == null) {
                        synchronized (c.a) {
                            if (t == null) {
                                t = new a[0];
                            }
                        }
                    }
                    return t;
                }

                /* renamed from: b */
                public a a(a aVar) throws IOException {
                    while (true) {
                        int a = aVar.a();
                        switch (a) {
                            case 0:
                                return this;
                            case 8:
                                this.b = aVar.e();
                                break;
                            case 16:
                                this.c = aVar.e();
                                break;
                            case 24:
                                this.d = aVar.k();
                                break;
                            case 34:
                                this.e = aVar.i();
                                break;
                            case 42:
                                this.f = aVar.j();
                                break;
                            case 50:
                                if (this.g == null) {
                                    this.g = new b();
                                }
                                aVar.a(this.g);
                                break;
                            case 58:
                                if (this.h == null) {
                                    this.h = new b();
                                }
                                aVar.a(this.h);
                                break;
                            case 66:
                                this.i = aVar.i();
                                break;
                            case 74:
                                if (this.j == null) {
                                    this.j = new C0344a();
                                }
                                aVar.a(this.j);
                                break;
                            case 80:
                                this.k = aVar.k();
                                break;
                            case 96:
                                int g2 = aVar.g();
                                if (g2 != 0 && g2 != 1) {
                                    break;
                                } else {
                                    this.l = g2;
                                    break;
                                }
                            case 104:
                                int g3 = aVar.g();
                                if (g3 != -1 && g3 != 0 && g3 != 1) {
                                    break;
                                } else {
                                    this.m = g3;
                                    break;
                                }
                            case 114:
                                this.n = aVar.j();
                                break;
                            case 120:
                                int g4 = aVar.g();
                                if (g4 != -1 && g4 != 0 && g4 != 1) {
                                    break;
                                } else {
                                    this.o = g4;
                                    break;
                                }
                            case 128:
                                this.p = aVar.e();
                                break;
                            case 136:
                                this.q = aVar.e();
                                break;
                            case 144:
                                int g5 = aVar.g();
                                if (g5 != 0 && g5 != 1 && g5 != 2 && g5 != 3 && g5 != 4) {
                                    break;
                                } else {
                                    this.r = g5;
                                    break;
                                }
                            case 152:
                                int g6 = aVar.g();
                                if (g6 != 0 && g6 != 1 && g6 != 2 && g6 != 3) {
                                    break;
                                } else {
                                    this.s = g6;
                                    break;
                                }
                            default:
                                if (g.a(aVar, a)) {
                                    break;
                                } else {
                                    return this;
                                }
                        }
                    }
                }

                @Override // com.yandex.metrica.impl.ob.e
                public int c() {
                    int e2 = b.e(3, this.d) + b.d(2, this.c) + b.d(1, this.b) + super.c();
                    if (!this.e.equals("")) {
                        e2 += b.b(4, this.e);
                    }
                    byte[] bArr = this.f;
                    byte[] bArr2 = g.h;
                    if (!Arrays.equals(bArr, bArr2)) {
                        e2 += b.b(5, this.f);
                    }
                    b bVar = this.g;
                    if (bVar != null) {
                        e2 += b.b(6, bVar);
                    }
                    b bVar2 = this.h;
                    if (bVar2 != null) {
                        e2 += b.b(7, bVar2);
                    }
                    if (!this.i.equals("")) {
                        e2 += b.b(8, this.i);
                    }
                    C0344a aVar = this.j;
                    if (aVar != null) {
                        e2 += b.b(9, aVar);
                    }
                    int i2 = this.k;
                    if (i2 != 0) {
                        e2 += b.e(10, i2);
                    }
                    int i3 = this.l;
                    if (i3 != 0) {
                        e2 += b.d(12, i3);
                    }
                    int i4 = this.m;
                    if (i4 != -1) {
                        e2 += b.d(13, i4);
                    }
                    if (!Arrays.equals(this.n, bArr2)) {
                        e2 += b.b(14, this.n);
                    }
                    int i5 = this.o;
                    if (i5 != -1) {
                        e2 += b.d(15, i5);
                    }
                    long j2 = this.p;
                    if (j2 != 0) {
                        e2 += b.d(16, j2);
                    }
                    long j3 = this.q;
                    if (j3 != 0) {
                        e2 += b.d(17, j3);
                    }
                    int i6 = this.r;
                    if (i6 != 0) {
                        e2 += b.d(18, i6);
                    }
                    int i7 = this.s;
                    return i7 != 0 ? e2 + b.d(19, i7) : e2;
                }

                public a e() {
                    this.b = 0;
                    this.c = 0;
                    this.d = 0;
                    this.e = "";
                    byte[] bArr = g.h;
                    this.f = bArr;
                    this.g = null;
                    this.h = null;
                    this.i = "";
                    this.j = null;
                    this.k = 0;
                    this.l = 0;
                    this.m = -1;
                    this.n = bArr;
                    this.o = -1;
                    this.p = 0;
                    this.q = 0;
                    this.r = 0;
                    this.s = 0;
                    this.a = -1;
                    return this;
                }

                @Override // com.yandex.metrica.impl.ob.e
                public void a(b bVar) throws IOException {
                    bVar.a(1, this.b);
                    bVar.a(2, this.c);
                    bVar.b(3, this.d);
                    if (!this.e.equals("")) {
                        bVar.a(4, this.e);
                    }
                    byte[] bArr = this.f;
                    byte[] bArr2 = g.h;
                    if (!Arrays.equals(bArr, bArr2)) {
                        bVar.a(5, this.f);
                    }
                    b bVar2 = this.g;
                    if (bVar2 != null) {
                        bVar.a(6, bVar2);
                    }
                    b bVar3 = this.h;
                    if (bVar3 != null) {
                        bVar.a(7, bVar3);
                    }
                    if (!this.i.equals("")) {
                        bVar.a(8, this.i);
                    }
                    C0344a aVar = this.j;
                    if (aVar != null) {
                        bVar.a(9, aVar);
                    }
                    int i2 = this.k;
                    if (i2 != 0) {
                        bVar.b(10, i2);
                    }
                    int i3 = this.l;
                    if (i3 != 0) {
                        bVar.a(12, i3);
                    }
                    int i4 = this.m;
                    if (i4 != -1) {
                        bVar.a(13, i4);
                    }
                    if (!Arrays.equals(this.n, bArr2)) {
                        bVar.a(14, this.n);
                    }
                    int i5 = this.o;
                    if (i5 != -1) {
                        bVar.a(15, i5);
                    }
                    long j2 = this.p;
                    if (j2 != 0) {
                        bVar.a(16, j2);
                    }
                    long j3 = this.q;
                    if (j3 != 0) {
                        bVar.a(17, j3);
                    }
                    int i6 = this.r;
                    if (i6 != 0) {
                        bVar.a(18, i6);
                    }
                    int i7 = this.s;
                    if (i7 != 0) {
                        bVar.a(19, i7);
                    }
                    super.a(bVar);
                }
            }

            public static final class b extends e {
                public g b;
                public String c;
                public int d;

                public b() {
                    d();
                }

                /* renamed from: b */
                public b a(a aVar) throws IOException {
                    while (true) {
                        int a = aVar.a();
                        if (a == 0) {
                            return this;
                        }
                        if (a == 10) {
                            if (this.b == null) {
                                this.b = new g();
                            }
                            aVar.a(this.b);
                        } else if (a == 18) {
                            this.c = aVar.i();
                        } else if (a == 40) {
                            int g = aVar.g();
                            if (g == 0 || g == 1 || g == 2) {
                                this.d = g;
                            }
                        } else if (!g.a(aVar, a)) {
                            return this;
                        }
                    }
                }

                @Override // com.yandex.metrica.impl.ob.e
                public int c() {
                    int c2 = super.c();
                    g gVar = this.b;
                    if (gVar != null) {
                        c2 += b.b(1, gVar);
                    }
                    int b2 = b.b(2, this.c) + c2;
                    int i = this.d;
                    return i != 0 ? b2 + b.d(5, i) : b2;
                }

                public b d() {
                    this.b = null;
                    this.c = "";
                    this.d = 0;
                    this.a = -1;
                    return this;
                }

                @Override // com.yandex.metrica.impl.ob.e
                public void a(b bVar) throws IOException {
                    g gVar = this.b;
                    if (gVar != null) {
                        bVar.a(1, gVar);
                    }
                    bVar.a(2, this.c);
                    int i = this.d;
                    if (i != 0) {
                        bVar.a(5, i);
                    }
                    super.a(bVar);
                }
            }

            public e() {
                e();
            }

            public static e[] d() {
                if (e == null) {
                    synchronized (c.a) {
                        if (e == null) {
                            e = new e[0];
                        }
                    }
                }
                return e;
            }

            /* renamed from: b */
            public e a(a aVar) throws IOException {
                while (true) {
                    int a3 = aVar.a();
                    if (a3 == 0) {
                        return this;
                    }
                    if (a3 == 8) {
                        this.b = aVar.e();
                    } else if (a3 == 18) {
                        if (this.c == null) {
                            this.c = new b();
                        }
                        aVar.a(this.c);
                    } else if (a3 == 26) {
                        int b2 = g.b(aVar, 26);
                        a[] aVarArr = this.d;
                        int length = aVarArr == null ? 0 : aVarArr.length;
                        int i = b2 + length;
                        a[] aVarArr2 = new a[i];
                        if (length != 0) {
                            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                        }
                        while (length < i - 1) {
                            aVarArr2[length] = new a();
                            aVar.a(aVarArr2[length]);
                            aVar.a();
                            length++;
                        }
                        aVarArr2[length] = new a();
                        aVar.a(aVarArr2[length]);
                        this.d = aVarArr2;
                    } else if (!g.a(aVar, a3)) {
                        return this;
                    }
                }
            }

            @Override // com.yandex.metrica.impl.ob.e
            public int c() {
                int d2 = b.d(1, this.b) + super.c();
                b bVar = this.c;
                if (bVar != null) {
                    d2 += b.b(2, bVar);
                }
                a[] aVarArr = this.d;
                if (aVarArr != null && aVarArr.length > 0) {
                    int i = 0;
                    while (true) {
                        a[] aVarArr2 = this.d;
                        if (i >= aVarArr2.length) {
                            break;
                        }
                        a aVar = aVarArr2[i];
                        if (aVar != null) {
                            d2 += b.b(3, aVar);
                        }
                        i++;
                    }
                }
                return d2;
            }

            public e e() {
                this.b = 0;
                this.c = null;
                this.d = a.d();
                this.a = -1;
                return this;
            }

            @Override // com.yandex.metrica.impl.ob.e
            public void a(b bVar) throws IOException {
                bVar.a(1, this.b);
                b bVar2 = this.c;
                if (bVar2 != null) {
                    bVar.a(2, bVar2);
                }
                a[] aVarArr = this.d;
                if (aVarArr != null && aVarArr.length > 0) {
                    int i = 0;
                    while (true) {
                        a[] aVarArr2 = this.d;
                        if (i >= aVarArr2.length) {
                            break;
                        }
                        a aVar = aVarArr2[i];
                        if (aVar != null) {
                            bVar.a(3, aVar);
                        }
                        i++;
                    }
                }
                super.a(bVar);
            }
        }

        public static final class f extends e {
            private static volatile f[] g;
            public int b;
            public int c;
            public String d;
            public boolean e;
            public String f;

            public f() {
                e();
            }

            public static f[] d() {
                if (g == null) {
                    synchronized (c.a) {
                        if (g == null) {
                            g = new f[0];
                        }
                    }
                }
                return g;
            }

            /* renamed from: b */
            public f a(a aVar) throws IOException {
                while (true) {
                    int a = aVar.a();
                    if (a == 0) {
                        return this;
                    }
                    if (a == 8) {
                        this.b = aVar.k();
                    } else if (a == 16) {
                        this.c = aVar.k();
                    } else if (a == 26) {
                        this.d = aVar.i();
                    } else if (a == 32) {
                        this.e = aVar.h();
                    } else if (a == 42) {
                        this.f = aVar.i();
                    } else if (!g.a(aVar, a)) {
                        return this;
                    }
                }
            }

            @Override // com.yandex.metrica.impl.ob.e
            public int c() {
                int c2 = super.c();
                int i = this.b;
                if (i != 0) {
                    c2 += b.e(1, i);
                }
                int i2 = this.c;
                if (i2 != 0) {
                    c2 += b.e(2, i2);
                }
                if (!this.d.equals("")) {
                    c2 += b.b(3, this.d);
                }
                boolean z = this.e;
                if (z) {
                    c2 += b.b(4, z);
                }
                return !this.f.equals("") ? c2 + b.b(5, this.f) : c2;
            }

            public f e() {
                this.b = 0;
                this.c = 0;
                this.d = "";
                this.e = false;
                this.f = "";
                this.a = -1;
                return this;
            }

            @Override // com.yandex.metrica.impl.ob.e
            public void a(b bVar) throws IOException {
                int i = this.b;
                if (i != 0) {
                    bVar.b(1, i);
                }
                int i2 = this.c;
                if (i2 != 0) {
                    bVar.b(2, i2);
                }
                if (!this.d.equals("")) {
                    bVar.a(3, this.d);
                }
                boolean z = this.e;
                if (z) {
                    bVar.a(4, z);
                }
                if (!this.f.equals("")) {
                    bVar.a(5, this.f);
                }
                super.a(bVar);
            }
        }

        public static final class g extends e {
            public long b;
            public int c;
            public long d;
            public boolean e;

            public g() {
                d();
            }

            /* renamed from: b */
            public g a(a aVar) throws IOException {
                while (true) {
                    int a = aVar.a();
                    if (a == 0) {
                        return this;
                    }
                    if (a == 8) {
                        this.b = aVar.e();
                    } else if (a == 16) {
                        this.c = aVar.l();
                    } else if (a == 24) {
                        this.d = aVar.f();
                    } else if (a == 32) {
                        this.e = aVar.h();
                    } else if (!g.a(aVar, a)) {
                        return this;
                    }
                }
            }

            @Override // com.yandex.metrica.impl.ob.e
            public int c() {
                int f = b.f(2, this.c) + b.d(1, this.b) + super.c();
                long j = this.d;
                if (j != 0) {
                    f += b.e(3, j);
                }
                boolean z = this.e;
                return z ? f + b.b(4, z) : f;
            }

            public g d() {
                this.b = 0;
                this.c = 0;
                this.d = 0;
                this.e = false;
                this.a = -1;
                return this;
            }

            @Override // com.yandex.metrica.impl.ob.e
            public void a(b bVar) throws IOException {
                bVar.a(1, this.b);
                bVar.c(2, this.c);
                long j = this.d;
                if (j != 0) {
                    bVar.b(3, j);
                }
                boolean z = this.e;
                if (z) {
                    bVar.a(4, z);
                }
                super.a(bVar);
            }
        }

        public c() {
            d();
        }

        /* renamed from: b */
        public c a(a aVar) throws IOException {
            while (true) {
                int a3 = aVar.a();
                if (a3 == 0) {
                    return this;
                }
                if (a3 == 26) {
                    int b2 = g.b(aVar, 26);
                    e[] eVarArr = this.b;
                    int length = eVarArr == null ? 0 : eVarArr.length;
                    int i = b2 + length;
                    e[] eVarArr2 = new e[i];
                    if (length != 0) {
                        System.arraycopy(eVarArr, 0, eVarArr2, 0, length);
                    }
                    while (length < i - 1) {
                        eVarArr2[length] = new e();
                        aVar.a(eVarArr2[length]);
                        aVar.a();
                        length++;
                    }
                    eVarArr2[length] = new e();
                    aVar.a(eVarArr2[length]);
                    this.b = eVarArr2;
                } else if (a3 == 34) {
                    if (this.c == null) {
                        this.c = new d();
                    }
                    aVar.a(this.c);
                } else if (a3 == 58) {
                    int b3 = g.b(aVar, 58);
                    a[] aVarArr = this.d;
                    int length2 = aVarArr == null ? 0 : aVarArr.length;
                    int i2 = b3 + length2;
                    a[] aVarArr2 = new a[i2];
                    if (length2 != 0) {
                        System.arraycopy(aVarArr, 0, aVarArr2, 0, length2);
                    }
                    while (length2 < i2 - 1) {
                        aVarArr2[length2] = new a();
                        aVar.a(aVarArr2[length2]);
                        aVar.a();
                        length2++;
                    }
                    aVarArr2[length2] = new a();
                    aVar.a(aVarArr2[length2]);
                    this.d = aVarArr2;
                } else if (a3 == 66) {
                    int b4 = g.b(aVar, 66);
                    C0343c[] cVarArr = this.e;
                    int length3 = cVarArr == null ? 0 : cVarArr.length;
                    int i3 = b4 + length3;
                    C0343c[] cVarArr2 = new C0343c[i3];
                    if (length3 != 0) {
                        System.arraycopy(cVarArr, 0, cVarArr2, 0, length3);
                    }
                    while (length3 < i3 - 1) {
                        cVarArr2[length3] = new C0343c();
                        aVar.a(cVarArr2[length3]);
                        aVar.a();
                        length3++;
                    }
                    cVarArr2[length3] = new C0343c();
                    aVar.a(cVarArr2[length3]);
                    this.e = cVarArr2;
                } else if (a3 == 74) {
                    int b5 = g.b(aVar, 74);
                    String[] strArr = this.f;
                    int length4 = strArr == null ? 0 : strArr.length;
                    int i4 = b5 + length4;
                    String[] strArr2 = new String[i4];
                    if (length4 != 0) {
                        System.arraycopy(strArr, 0, strArr2, 0, length4);
                    }
                    while (length4 < i4 - 1) {
                        strArr2[length4] = aVar.i();
                        aVar.a();
                        length4++;
                    }
                    strArr2[length4] = aVar.i();
                    this.f = strArr2;
                } else if (a3 == 82) {
                    int b6 = g.b(aVar, 82);
                    f[] fVarArr = this.g;
                    int length5 = fVarArr == null ? 0 : fVarArr.length;
                    int i5 = b6 + length5;
                    f[] fVarArr2 = new f[i5];
                    if (length5 != 0) {
                        System.arraycopy(fVarArr, 0, fVarArr2, 0, length5);
                    }
                    while (length5 < i5 - 1) {
                        fVarArr2[length5] = new f();
                        aVar.a(fVarArr2[length5]);
                        aVar.a();
                        length5++;
                    }
                    fVarArr2[length5] = new f();
                    aVar.a(fVarArr2[length5]);
                    this.g = fVarArr2;
                } else if (a3 == 90) {
                    int b8 = g.b(aVar, 90);
                    String[] strArr3 = this.h;
                    int length6 = strArr3 == null ? 0 : strArr3.length;
                    int i6 = b8 + length6;
                    String[] strArr4 = new String[i6];
                    if (length6 != 0) {
                        System.arraycopy(strArr3, 0, strArr4, 0, length6);
                    }
                    while (length6 < i6 - 1) {
                        strArr4[length6] = aVar.i();
                        aVar.a();
                        length6++;
                    }
                    strArr4[length6] = aVar.i();
                    this.h = strArr4;
                } else if (!g.a(aVar, a3)) {
                    return this;
                }
            }
        }

        @Override // com.yandex.metrica.impl.ob.e
        public int c() {
            int c2 = super.c();
            e[] eVarArr = this.b;
            int i = 0;
            if (eVarArr != null && eVarArr.length > 0) {
                int i2 = 0;
                while (true) {
                    e[] eVarArr2 = this.b;
                    if (i2 >= eVarArr2.length) {
                        break;
                    }
                    e eVar = eVarArr2[i2];
                    if (eVar != null) {
                        c2 += b.b(3, eVar);
                    }
                    i2++;
                }
            }
            d dVar = this.c;
            if (dVar != null) {
                c2 += b.b(4, dVar);
            }
            a[] aVarArr = this.d;
            if (aVarArr != null && aVarArr.length > 0) {
                int i3 = 0;
                while (true) {
                    a[] aVarArr2 = this.d;
                    if (i3 >= aVarArr2.length) {
                        break;
                    }
                    a aVar = aVarArr2[i3];
                    if (aVar != null) {
                        c2 = b.b(7, aVar) + c2;
                    }
                    i3++;
                }
            }
            C0343c[] cVarArr = this.e;
            if (cVarArr != null && cVarArr.length > 0) {
                int i4 = 0;
                while (true) {
                    C0343c[] cVarArr2 = this.e;
                    if (i4 >= cVarArr2.length) {
                        break;
                    }
                    C0343c cVar = cVarArr2[i4];
                    if (cVar != null) {
                        c2 = b.b(8, cVar) + c2;
                    }
                    i4++;
                }
            }
            String[] strArr = this.f;
            if (strArr != null && strArr.length > 0) {
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (true) {
                    String[] strArr2 = this.f;
                    if (i5 >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i5];
                    if (str != null) {
                        i7++;
                        i6 += b.b(str);
                    }
                    i5++;
                }
                c2 = c2 + i6 + (i7 * 1);
            }
            f[] fVarArr = this.g;
            if (fVarArr != null && fVarArr.length > 0) {
                int i8 = 0;
                while (true) {
                    f[] fVarArr2 = this.g;
                    if (i8 >= fVarArr2.length) {
                        break;
                    }
                    f fVar = fVarArr2[i8];
                    if (fVar != null) {
                        c2 += b.b(10, fVar);
                    }
                    i8++;
                }
            }
            String[] strArr3 = this.h;
            if (strArr3 == null || strArr3.length <= 0) {
                return c2;
            }
            int i9 = 0;
            int i10 = 0;
            while (true) {
                String[] strArr4 = this.h;
                if (i >= strArr4.length) {
                    return c2 + i9 + (i10 * 1);
                }
                String str2 = strArr4[i];
                if (str2 != null) {
                    i10++;
                    i9 = b.b(str2) + i9;
                }
                i++;
            }
        }

        public c d() {
            this.b = e.d();
            this.c = null;
            this.d = a.d();
            this.e = C0343c.d();
            String[] strArr = g.f;
            this.f = strArr;
            this.g = f.d();
            this.h = strArr;
            this.a = -1;
            return this;
        }

        @Override // com.yandex.metrica.impl.ob.e
        public void a(b bVar) throws IOException {
            e[] eVarArr = this.b;
            int i = 0;
            if (eVarArr != null && eVarArr.length > 0) {
                int i2 = 0;
                while (true) {
                    e[] eVarArr2 = this.b;
                    if (i2 >= eVarArr2.length) {
                        break;
                    }
                    e eVar = eVarArr2[i2];
                    if (eVar != null) {
                        bVar.a(3, eVar);
                    }
                    i2++;
                }
            }
            d dVar = this.c;
            if (dVar != null) {
                bVar.a(4, dVar);
            }
            a[] aVarArr = this.d;
            if (aVarArr != null && aVarArr.length > 0) {
                int i3 = 0;
                while (true) {
                    a[] aVarArr2 = this.d;
                    if (i3 >= aVarArr2.length) {
                        break;
                    }
                    a aVar = aVarArr2[i3];
                    if (aVar != null) {
                        bVar.a(7, aVar);
                    }
                    i3++;
                }
            }
            C0343c[] cVarArr = this.e;
            if (cVarArr != null && cVarArr.length > 0) {
                int i4 = 0;
                while (true) {
                    C0343c[] cVarArr2 = this.e;
                    if (i4 >= cVarArr2.length) {
                        break;
                    }
                    C0343c cVar = cVarArr2[i4];
                    if (cVar != null) {
                        bVar.a(8, cVar);
                    }
                    i4++;
                }
            }
            String[] strArr = this.f;
            if (strArr != null && strArr.length > 0) {
                int i5 = 0;
                while (true) {
                    String[] strArr2 = this.f;
                    if (i5 >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i5];
                    if (str != null) {
                        bVar.a(9, str);
                    }
                    i5++;
                }
            }
            f[] fVarArr = this.g;
            if (fVarArr != null && fVarArr.length > 0) {
                int i6 = 0;
                while (true) {
                    f[] fVarArr2 = this.g;
                    if (i6 >= fVarArr2.length) {
                        break;
                    }
                    f fVar = fVarArr2[i6];
                    if (fVar != null) {
                        bVar.a(10, fVar);
                    }
                    i6++;
                }
            }
            String[] strArr3 = this.h;
            if (strArr3 != null && strArr3.length > 0) {
                while (true) {
                    String[] strArr4 = this.h;
                    if (i >= strArr4.length) {
                        break;
                    }
                    String str2 = strArr4[i];
                    if (str2 != null) {
                        bVar.a(11, str2);
                    }
                    i++;
                }
            }
            super.a(bVar);
        }
    }

    public static final class d extends e {
        private static volatile d[] g;
        public String b;
        public int c;
        public String d;
        public boolean e;
        public long f;

        public d() {
            e();
        }

        public static d[] d() {
            if (g == null) {
                synchronized (c.a) {
                    if (g == null) {
                        g = new d[0];
                    }
                }
            }
            return g;
        }

        /* renamed from: b */
        public d a(a aVar) throws IOException {
            while (true) {
                int a = aVar.a();
                if (a == 0) {
                    return this;
                }
                if (a == 10) {
                    this.b = aVar.i();
                } else if (a == 16) {
                    this.c = aVar.l();
                } else if (a == 26) {
                    this.d = aVar.i();
                } else if (a == 32) {
                    this.e = aVar.h();
                } else if (a == 40) {
                    this.f = aVar.e();
                } else if (!g.a(aVar, a)) {
                    return this;
                }
            }
        }

        @Override // com.yandex.metrica.impl.ob.e
        public int c() {
            int b2 = b.b(1, this.b) + super.c();
            int i = this.c;
            if (i != 0) {
                b2 += b.f(2, i);
            }
            if (!this.d.equals("")) {
                b2 += b.b(3, this.d);
            }
            boolean z = this.e;
            if (z) {
                b2 += b.b(4, z);
            }
            long j = this.f;
            return j != 0 ? b2 + b.d(5, j) : b2;
        }

        public d e() {
            this.b = "";
            this.c = 0;
            this.d = "";
            this.e = false;
            this.f = 0;
            this.a = -1;
            return this;
        }

        @Override // com.yandex.metrica.impl.ob.e
        public void a(b bVar) throws IOException {
            bVar.a(1, this.b);
            int i = this.c;
            if (i != 0) {
                bVar.c(2, i);
            }
            if (!this.d.equals("")) {
                bVar.a(3, this.d);
            }
            boolean z = this.e;
            if (z) {
                bVar.a(4, z);
            }
            long j = this.f;
            if (j != 0) {
                bVar.a(5, j);
            }
            super.a(bVar);
        }
    }
}
