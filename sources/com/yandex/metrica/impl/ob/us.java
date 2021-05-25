package com.yandex.metrica.impl.ob;

import java.io.IOException;
public interface us {

    public static final class a extends e {
        public e b;
        public e[] c;

        public a() {
            d();
        }

        /* renamed from: b */
        public a a(a aVar) throws IOException {
            while (true) {
                int a = aVar.a();
                if (a == 0) {
                    return this;
                }
                if (a == 10) {
                    if (this.b == null) {
                        this.b = new e();
                    }
                    aVar.a(this.b);
                } else if (a == 18) {
                    int b2 = g.b(aVar, 18);
                    e[] eVarArr = this.c;
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
                    this.c = eVarArr2;
                } else if (!g.a(aVar, a)) {
                    return this;
                }
            }
        }

        @Override // com.yandex.metrica.impl.ob.e
        public int c() {
            int c2 = super.c();
            e eVar = this.b;
            if (eVar != null) {
                c2 += b.b(1, eVar);
            }
            e[] eVarArr = this.c;
            if (eVarArr != null && eVarArr.length > 0) {
                int i = 0;
                while (true) {
                    e[] eVarArr2 = this.c;
                    if (i >= eVarArr2.length) {
                        break;
                    }
                    e eVar2 = eVarArr2[i];
                    if (eVar2 != null) {
                        c2 += b.b(2, eVar2);
                    }
                    i++;
                }
            }
            return c2;
        }

        public a d() {
            this.b = null;
            this.c = e.d();
            this.a = -1;
            return this;
        }

        @Override // com.yandex.metrica.impl.ob.e
        public void a(b bVar) throws IOException {
            e eVar = this.b;
            if (eVar != null) {
                bVar.a(1, eVar);
            }
            e[] eVarArr = this.c;
            if (eVarArr != null && eVarArr.length > 0) {
                int i = 0;
                while (true) {
                    e[] eVarArr2 = this.c;
                    if (i >= eVarArr2.length) {
                        break;
                    }
                    e eVar2 = eVarArr2[i];
                    if (eVar2 != null) {
                        bVar.a(2, eVar2);
                    }
                    i++;
                }
            }
            super.a(bVar);
        }
    }

    public static final class b extends e {
        public a b;
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
                        this.b = new a();
                    }
                    aVar.a(this.b);
                } else if (a == 18) {
                    this.c = aVar.i();
                } else if (a == 24) {
                    int g = aVar.g();
                    if (g == -1 || g == 0 || g == 1) {
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
            a aVar = this.b;
            if (aVar != null) {
                c2 += b.b(1, aVar);
            }
            if (!this.c.equals("")) {
                c2 += b.b(2, this.c);
            }
            int i = this.d;
            return i != -1 ? c2 + b.d(3, i) : c2;
        }

        public b d() {
            this.b = null;
            this.c = "";
            this.d = -1;
            this.a = -1;
            return this;
        }

        @Override // com.yandex.metrica.impl.ob.e
        public void a(b bVar) throws IOException {
            a aVar = this.b;
            if (aVar != null) {
                bVar.a(1, aVar);
            }
            if (!this.c.equals("")) {
                bVar.a(2, this.c);
            }
            int i = this.d;
            if (i != -1) {
                bVar.a(3, i);
            }
            super.a(bVar);
        }
    }

    public static final class c extends e {
        public f b;
        public a c;
        public String d;
        public int e;
        public d[] f;

        public c() {
            d();
        }

        /* renamed from: b */
        public c a(a aVar) throws IOException {
            while (true) {
                int a = aVar.a();
                if (a == 0) {
                    return this;
                }
                if (a == 10) {
                    if (this.b == null) {
                        this.b = new f();
                    }
                    aVar.a(this.b);
                } else if (a == 18) {
                    if (this.c == null) {
                        this.c = new a();
                    }
                    aVar.a(this.c);
                } else if (a == 26) {
                    this.d = aVar.i();
                } else if (a == 32) {
                    int g = aVar.g();
                    if (g == -1 || g == 0 || g == 1) {
                        this.e = g;
                    }
                } else if (a == 42) {
                    int b2 = g.b(aVar, 42);
                    d[] dVarArr = this.f;
                    int length = dVarArr == null ? 0 : dVarArr.length;
                    int i = b2 + length;
                    d[] dVarArr2 = new d[i];
                    if (length != 0) {
                        System.arraycopy(dVarArr, 0, dVarArr2, 0, length);
                    }
                    while (length < i - 1) {
                        dVarArr2[length] = new d();
                        aVar.a(dVarArr2[length]);
                        aVar.a();
                        length++;
                    }
                    dVarArr2[length] = new d();
                    aVar.a(dVarArr2[length]);
                    this.f = dVarArr2;
                } else if (!g.a(aVar, a)) {
                    return this;
                }
            }
        }

        @Override // com.yandex.metrica.impl.ob.e
        public int c() {
            int c2 = super.c();
            f fVar = this.b;
            if (fVar != null) {
                c2 += b.b(1, fVar);
            }
            a aVar = this.c;
            if (aVar != null) {
                c2 += b.b(2, aVar);
            }
            if (!this.d.equals("")) {
                c2 += b.b(3, this.d);
            }
            int i = this.e;
            if (i != -1) {
                c2 += b.d(4, i);
            }
            d[] dVarArr = this.f;
            if (dVarArr != null && dVarArr.length > 0) {
                int i2 = 0;
                while (true) {
                    d[] dVarArr2 = this.f;
                    if (i2 >= dVarArr2.length) {
                        break;
                    }
                    d dVar = dVarArr2[i2];
                    if (dVar != null) {
                        c2 += b.b(5, dVar);
                    }
                    i2++;
                }
            }
            return c2;
        }

        public c d() {
            this.b = null;
            this.c = null;
            this.d = "";
            this.e = -1;
            this.f = d.d();
            this.a = -1;
            return this;
        }

        @Override // com.yandex.metrica.impl.ob.e
        public void a(b bVar) throws IOException {
            f fVar = this.b;
            if (fVar != null) {
                bVar.a(1, fVar);
            }
            a aVar = this.c;
            if (aVar != null) {
                bVar.a(2, aVar);
            }
            if (!this.d.equals("")) {
                bVar.a(3, this.d);
            }
            int i = this.e;
            if (i != -1) {
                bVar.a(4, i);
            }
            d[] dVarArr = this.f;
            if (dVarArr != null && dVarArr.length > 0) {
                int i2 = 0;
                while (true) {
                    d[] dVarArr2 = this.f;
                    if (i2 >= dVarArr2.length) {
                        break;
                    }
                    d dVar = dVarArr2[i2];
                    if (dVar != null) {
                        bVar.a(5, dVar);
                    }
                    i2++;
                }
            }
            super.a(bVar);
        }
    }

    public static final class d extends e {
        private static volatile d[] g;
        public String b;
        public String c;
        public int d;
        public String e;
        public boolean f;

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
                } else if (a == 18) {
                    this.c = aVar.i();
                } else if (a == 24) {
                    this.d = aVar.l();
                } else if (a == 34) {
                    this.e = aVar.i();
                } else if (a == 40) {
                    this.f = aVar.h();
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
            return b.b(5, this.f) + b.b(4, this.e) + b.f(3, this.d) + b2;
        }

        public d e() {
            this.b = "";
            this.c = "";
            this.d = 0;
            this.e = "";
            this.f = false;
            this.a = -1;
            return this;
        }

        @Override // com.yandex.metrica.impl.ob.e
        public void a(b bVar) throws IOException {
            bVar.a(1, this.b);
            if (!this.c.equals("")) {
                bVar.a(2, this.c);
            }
            bVar.c(3, this.d);
            bVar.a(4, this.e);
            bVar.a(5, this.f);
            super.a(bVar);
        }
    }

    public static final class e extends e {
        private static volatile e[] h;
        public String b;
        public int c;
        public long d;
        public String e;
        public int f;
        public d[] g;

        public e() {
            e();
        }

        public static e[] d() {
            if (h == null) {
                synchronized (c.a) {
                    if (h == null) {
                        h = new e[0];
                    }
                }
            }
            return h;
        }

        /* renamed from: b */
        public e a(a aVar) throws IOException {
            while (true) {
                int a = aVar.a();
                if (a == 0) {
                    return this;
                }
                if (a == 10) {
                    this.b = aVar.i();
                } else if (a == 16) {
                    this.c = aVar.l();
                } else if (a == 24) {
                    this.d = aVar.m();
                } else if (a == 34) {
                    this.e = aVar.i();
                } else if (a == 40) {
                    this.f = aVar.k();
                } else if (a == 50) {
                    int b2 = g.b(aVar, 50);
                    d[] dVarArr = this.g;
                    int length = dVarArr == null ? 0 : dVarArr.length;
                    int i = b2 + length;
                    d[] dVarArr2 = new d[i];
                    if (length != 0) {
                        System.arraycopy(dVarArr, 0, dVarArr2, 0, length);
                    }
                    while (length < i - 1) {
                        dVarArr2[length] = new d();
                        aVar.a(dVarArr2[length]);
                        aVar.a();
                        length++;
                    }
                    dVarArr2[length] = new d();
                    aVar.a(dVarArr2[length]);
                    this.g = dVarArr2;
                } else if (!g.a(aVar, a)) {
                    return this;
                }
            }
        }

        @Override // com.yandex.metrica.impl.ob.e
        public int c() {
            int f2 = b.f(3, this.d) + b.f(2, this.c) + b.b(1, this.b) + super.c();
            if (!this.e.equals("")) {
                f2 += b.b(4, this.e);
            }
            int i = this.f;
            if (i != 0) {
                f2 += b.e(5, i);
            }
            d[] dVarArr = this.g;
            if (dVarArr != null && dVarArr.length > 0) {
                int i2 = 0;
                while (true) {
                    d[] dVarArr2 = this.g;
                    if (i2 >= dVarArr2.length) {
                        break;
                    }
                    d dVar = dVarArr2[i2];
                    if (dVar != null) {
                        f2 += b.b(6, dVar);
                    }
                    i2++;
                }
            }
            return f2;
        }

        public e e() {
            this.b = "";
            this.c = 0;
            this.d = 0;
            this.e = "";
            this.f = 0;
            this.g = d.d();
            this.a = -1;
            return this;
        }

        @Override // com.yandex.metrica.impl.ob.e
        public void a(b bVar) throws IOException {
            bVar.a(1, this.b);
            bVar.c(2, this.c);
            bVar.c(3, this.d);
            if (!this.e.equals("")) {
                bVar.a(4, this.e);
            }
            int i = this.f;
            if (i != 0) {
                bVar.b(5, i);
            }
            d[] dVarArr = this.g;
            if (dVarArr != null && dVarArr.length > 0) {
                int i2 = 0;
                while (true) {
                    d[] dVarArr2 = this.g;
                    if (i2 >= dVarArr2.length) {
                        break;
                    }
                    d dVar = dVarArr2[i2];
                    if (dVar != null) {
                        bVar.a(6, dVar);
                    }
                    i2++;
                }
            }
            super.a(bVar);
        }
    }

    public static final class f extends e {
        private static volatile f[] g;
        public String b;
        public String c;
        public d[] d;
        public f e;
        public f[] f;

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
                if (a == 10) {
                    this.b = aVar.i();
                } else if (a == 18) {
                    this.c = aVar.i();
                } else if (a == 26) {
                    int b2 = g.b(aVar, 26);
                    d[] dVarArr = this.d;
                    int length = dVarArr == null ? 0 : dVarArr.length;
                    int i = b2 + length;
                    d[] dVarArr2 = new d[i];
                    if (length != 0) {
                        System.arraycopy(dVarArr, 0, dVarArr2, 0, length);
                    }
                    while (length < i - 1) {
                        dVarArr2[length] = new d();
                        aVar.a(dVarArr2[length]);
                        aVar.a();
                        length++;
                    }
                    dVarArr2[length] = new d();
                    aVar.a(dVarArr2[length]);
                    this.d = dVarArr2;
                } else if (a == 34) {
                    if (this.e == null) {
                        this.e = new f();
                    }
                    aVar.a(this.e);
                } else if (a == 42) {
                    int b3 = g.b(aVar, 42);
                    f[] fVarArr = this.f;
                    int length2 = fVarArr == null ? 0 : fVarArr.length;
                    int i2 = b3 + length2;
                    f[] fVarArr2 = new f[i2];
                    if (length2 != 0) {
                        System.arraycopy(fVarArr, 0, fVarArr2, 0, length2);
                    }
                    while (length2 < i2 - 1) {
                        fVarArr2[length2] = new f();
                        aVar.a(fVarArr2[length2]);
                        aVar.a();
                        length2++;
                    }
                    fVarArr2[length2] = new f();
                    aVar.a(fVarArr2[length2]);
                    this.f = fVarArr2;
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
            d[] dVarArr = this.d;
            int i = 0;
            if (dVarArr != null && dVarArr.length > 0) {
                int i2 = 0;
                while (true) {
                    d[] dVarArr2 = this.d;
                    if (i2 >= dVarArr2.length) {
                        break;
                    }
                    d dVar = dVarArr2[i2];
                    if (dVar != null) {
                        b2 += b.b(3, dVar);
                    }
                    i2++;
                }
            }
            f fVar = this.e;
            if (fVar != null) {
                b2 += b.b(4, fVar);
            }
            f[] fVarArr = this.f;
            if (fVarArr != null && fVarArr.length > 0) {
                while (true) {
                    f[] fVarArr2 = this.f;
                    if (i >= fVarArr2.length) {
                        break;
                    }
                    f fVar2 = fVarArr2[i];
                    if (fVar2 != null) {
                        b2 += b.b(5, fVar2);
                    }
                    i++;
                }
            }
            return b2;
        }

        public f e() {
            this.b = "";
            this.c = "";
            this.d = d.d();
            this.e = null;
            this.f = d();
            this.a = -1;
            return this;
        }

        @Override // com.yandex.metrica.impl.ob.e
        public void a(b bVar) throws IOException {
            bVar.a(1, this.b);
            if (!this.c.equals("")) {
                bVar.a(2, this.c);
            }
            d[] dVarArr = this.d;
            int i = 0;
            if (dVarArr != null && dVarArr.length > 0) {
                int i2 = 0;
                while (true) {
                    d[] dVarArr2 = this.d;
                    if (i2 >= dVarArr2.length) {
                        break;
                    }
                    d dVar = dVarArr2[i2];
                    if (dVar != null) {
                        bVar.a(3, dVar);
                    }
                    i2++;
                }
            }
            f fVar = this.e;
            if (fVar != null) {
                bVar.a(4, fVar);
            }
            f[] fVarArr = this.f;
            if (fVarArr != null && fVarArr.length > 0) {
                while (true) {
                    f[] fVarArr2 = this.f;
                    if (i >= fVarArr2.length) {
                        break;
                    }
                    f fVar2 = fVarArr2[i];
                    if (fVar2 != null) {
                        bVar.a(5, fVar2);
                    }
                    i++;
                }
            }
            super.a(bVar);
        }
    }
}
