package com.yandex.metrica.impl.ob;

import androidx.work.WorkRequest;
import com.avito.android.BuildConfig;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import java.io.IOException;
import java.util.Arrays;
import ru.avito.messenger.internal.ConstantsKt;
public interface ve {

    public static final class a extends e {
        public String A;
        public String B;
        public long C;
        public long D;
        public boolean E;
        public f F;
        public c G;
        public C0352a H;
        public int I;
        public int J;
        public l K;
        public k L;
        public k M;
        public String N;
        public String b;
        public long c;
        public String[] d;
        public String e;
        public String f;
        public String[] g;
        public String[] h;
        public String[] i;
        public b j;
        public d[] k;
        public m l;
        public i m;
        public g[] n;
        public String o;
        public String p;
        public boolean q;
        public String r;
        public String s;
        public String[] t;
        public j u;
        public boolean v;
        public e[] w;
        public h x;
        public String y;
        public String z;

        /* renamed from: com.yandex.metrica.impl.ob.ve$a$a  reason: collision with other inner class name */
        public static final class C0352a extends e {
            public b b;
            public C0353a[] c;
            public long d;
            public long e;

            /* renamed from: com.yandex.metrica.impl.ob.ve$a$a$a  reason: collision with other inner class name */
            public static final class C0353a extends e {
                private static volatile C0353a[] g;
                public String b;
                public String c;
                public C0354a d;
                public b e;
                public c f;

                /* renamed from: com.yandex.metrica.impl.ob.ve$a$a$a$a  reason: collision with other inner class name */
                public static final class C0354a extends e {
                    public int b;
                    public byte[] c;
                    public byte[] d;

                    public C0354a() {
                        d();
                    }

                    /* renamed from: b */
                    public C0354a a(a aVar) throws IOException {
                        while (true) {
                            int a = aVar.a();
                            if (a == 0) {
                                return this;
                            }
                            if (a == 8) {
                                this.b = aVar.g();
                            } else if (a == 18) {
                                this.c = aVar.j();
                            } else if (a == 26) {
                                this.d = aVar.j();
                            } else if (!g.a(aVar, a)) {
                                return this;
                            }
                        }
                    }

                    @Override // com.yandex.metrica.impl.ob.e
                    public int c() {
                        int d2 = b.d(1, this.b) + super.c();
                        byte[] bArr = this.c;
                        byte[] bArr2 = g.h;
                        if (!Arrays.equals(bArr, bArr2)) {
                            d2 += b.b(2, this.c);
                        }
                        return !Arrays.equals(this.d, bArr2) ? d2 + b.b(3, this.d) : d2;
                    }

                    public C0354a d() {
                        this.b = 0;
                        byte[] bArr = g.h;
                        this.c = bArr;
                        this.d = bArr;
                        this.a = -1;
                        return this;
                    }

                    @Override // com.yandex.metrica.impl.ob.e
                    public void a(b bVar) throws IOException {
                        bVar.a(1, this.b);
                        byte[] bArr = this.c;
                        byte[] bArr2 = g.h;
                        if (!Arrays.equals(bArr, bArr2)) {
                            bVar.a(2, this.c);
                        }
                        if (!Arrays.equals(this.d, bArr2)) {
                            bVar.a(3, this.d);
                        }
                        super.a(bVar);
                    }
                }

                /* renamed from: com.yandex.metrica.impl.ob.ve$a$a$a$b */
                public static final class b extends e {
                    public String b;
                    public byte[] c;
                    public byte[] d;

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
                                this.b = aVar.i();
                            } else if (a == 18) {
                                this.c = aVar.j();
                            } else if (a == 26) {
                                this.d = aVar.j();
                            } else if (!g.a(aVar, a)) {
                                return this;
                            }
                        }
                    }

                    @Override // com.yandex.metrica.impl.ob.e
                    public int c() {
                        int b2 = b.b(1, this.b) + super.c();
                        byte[] bArr = this.c;
                        byte[] bArr2 = g.h;
                        if (!Arrays.equals(bArr, bArr2)) {
                            b2 += b.b(2, this.c);
                        }
                        return !Arrays.equals(this.d, bArr2) ? b2 + b.b(3, this.d) : b2;
                    }

                    public b d() {
                        this.b = "";
                        byte[] bArr = g.h;
                        this.c = bArr;
                        this.d = bArr;
                        this.a = -1;
                        return this;
                    }

                    @Override // com.yandex.metrica.impl.ob.e
                    public void a(b bVar) throws IOException {
                        bVar.a(1, this.b);
                        byte[] bArr = this.c;
                        byte[] bArr2 = g.h;
                        if (!Arrays.equals(bArr, bArr2)) {
                            bVar.a(2, this.c);
                        }
                        if (!Arrays.equals(this.d, bArr2)) {
                            bVar.a(3, this.d);
                        }
                        super.a(bVar);
                    }
                }

                /* renamed from: com.yandex.metrica.impl.ob.ve$a$a$a$c */
                public static final class c extends e {
                    public String b;
                    public String c;

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
                        int b2 = b.b(1, this.b) + super.c();
                        return !this.c.equals("") ? b2 + b.b(2, this.c) : b2;
                    }

                    public c d() {
                        this.b = "";
                        this.c = "";
                        this.a = -1;
                        return this;
                    }

                    @Override // com.yandex.metrica.impl.ob.e
                    public void a(b bVar) throws IOException {
                        bVar.a(1, this.b);
                        if (!this.c.equals("")) {
                            bVar.a(2, this.c);
                        }
                        super.a(bVar);
                    }
                }

                public C0353a() {
                    e();
                }

                public static C0353a[] d() {
                    if (g == null) {
                        synchronized (c.a) {
                            if (g == null) {
                                g = new C0353a[0];
                            }
                        }
                    }
                    return g;
                }

                /* renamed from: b */
                public C0353a a(a aVar) throws IOException {
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
                            if (this.d == null) {
                                this.d = new C0354a();
                            }
                            aVar.a(this.d);
                        } else if (a == 34) {
                            if (this.e == null) {
                                this.e = new b();
                            }
                            aVar.a(this.e);
                        } else if (a == 42) {
                            if (this.f == null) {
                                this.f = new c();
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
                    if (!this.b.equals("")) {
                        c2 += b.b(1, this.b);
                    }
                    if (!this.c.equals("")) {
                        c2 += b.b(2, this.c);
                    }
                    C0354a aVar = this.d;
                    if (aVar != null) {
                        c2 += b.b(3, aVar);
                    }
                    b bVar = this.e;
                    if (bVar != null) {
                        c2 += b.b(4, bVar);
                    }
                    c cVar = this.f;
                    return cVar != null ? c2 + b.b(5, cVar) : c2;
                }

                public C0353a e() {
                    this.b = "";
                    this.c = "";
                    this.d = null;
                    this.e = null;
                    this.f = null;
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
                    C0354a aVar = this.d;
                    if (aVar != null) {
                        bVar.a(3, aVar);
                    }
                    b bVar2 = this.e;
                    if (bVar2 != null) {
                        bVar.a(4, bVar2);
                    }
                    c cVar = this.f;
                    if (cVar != null) {
                        bVar.a(5, cVar);
                    }
                    super.a(bVar);
                }
            }

            /* renamed from: com.yandex.metrica.impl.ob.ve$a$a$b */
            public static final class b extends e {
                public int b;
                public int c;
                public int d;
                public int e;
                public long f;

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
                        if (a == 8) {
                            int g = aVar.g();
                            if (g == 1 || g == 2 || g == 3) {
                                this.b = g;
                            }
                        } else if (a == 16) {
                            int g2 = aVar.g();
                            if (g2 == 1 || g2 == 2) {
                                this.c = g2;
                            }
                        } else if (a == 24) {
                            int g3 = aVar.g();
                            if (g3 == 1 || g3 == 2 || g3 == 3) {
                                this.d = g3;
                            }
                        } else if (a == 32) {
                            int g4 = aVar.g();
                            if (g4 == 1 || g4 == 2 || g4 == 3) {
                                this.e = g4;
                            }
                        } else if (a == 40) {
                            this.f = aVar.f();
                        } else if (!g.a(aVar, a)) {
                            return this;
                        }
                    }
                }

                @Override // com.yandex.metrica.impl.ob.e
                public int c() {
                    int c2 = super.c();
                    int i = this.b;
                    if (i != 1) {
                        c2 += b.d(1, i);
                    }
                    int i2 = this.c;
                    if (i2 != 2) {
                        c2 += b.d(2, i2);
                    }
                    int i3 = this.d;
                    if (i3 != 3) {
                        c2 += b.d(3, i3);
                    }
                    int i4 = this.e;
                    if (i4 != 1) {
                        c2 += b.d(4, i4);
                    }
                    long j = this.f;
                    return j != 300000 ? c2 + b.e(5, j) : c2;
                }

                public b d() {
                    this.b = 1;
                    this.c = 2;
                    this.d = 3;
                    this.e = 1;
                    this.f = 300000;
                    this.a = -1;
                    return this;
                }

                @Override // com.yandex.metrica.impl.ob.e
                public void a(b bVar) throws IOException {
                    int i = this.b;
                    if (i != 1) {
                        bVar.a(1, i);
                    }
                    int i2 = this.c;
                    if (i2 != 2) {
                        bVar.a(2, i2);
                    }
                    int i3 = this.d;
                    if (i3 != 3) {
                        bVar.a(3, i3);
                    }
                    int i4 = this.e;
                    if (i4 != 1) {
                        bVar.a(4, i4);
                    }
                    long j = this.f;
                    if (j != 300000) {
                        bVar.b(5, j);
                    }
                    super.a(bVar);
                }
            }

            public C0352a() {
                d();
            }

            /* renamed from: b */
            public C0352a a(a aVar) throws IOException {
                while (true) {
                    int a = aVar.a();
                    if (a == 0) {
                        return this;
                    }
                    if (a == 10) {
                        if (this.b == null) {
                            this.b = new b();
                        }
                        aVar.a(this.b);
                    } else if (a == 18) {
                        int b2 = g.b(aVar, 18);
                        C0353a[] aVarArr = this.c;
                        int length = aVarArr == null ? 0 : aVarArr.length;
                        int i = b2 + length;
                        C0353a[] aVarArr2 = new C0353a[i];
                        if (length != 0) {
                            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                        }
                        while (length < i - 1) {
                            aVarArr2[length] = new C0353a();
                            aVar.a(aVarArr2[length]);
                            aVar.a();
                            length++;
                        }
                        aVarArr2[length] = new C0353a();
                        aVar.a(aVarArr2[length]);
                        this.c = aVarArr2;
                    } else if (a == 24) {
                        this.d = aVar.f();
                    } else if (a == 32) {
                        this.e = aVar.f();
                    } else if (!g.a(aVar, a)) {
                        return this;
                    }
                }
            }

            @Override // com.yandex.metrica.impl.ob.e
            public int c() {
                int c2 = super.c();
                b bVar = this.b;
                if (bVar != null) {
                    c2 += b.b(1, bVar);
                }
                C0353a[] aVarArr = this.c;
                if (aVarArr != null && aVarArr.length > 0) {
                    int i = 0;
                    while (true) {
                        C0353a[] aVarArr2 = this.c;
                        if (i >= aVarArr2.length) {
                            break;
                        }
                        C0353a aVar = aVarArr2[i];
                        if (aVar != null) {
                            c2 += b.b(2, aVar);
                        }
                        i++;
                    }
                }
                return b.e(4, this.e) + b.e(3, this.d) + c2;
            }

            public C0352a d() {
                this.b = null;
                this.c = C0353a.d();
                this.d = 1200000;
                this.e = 259200000;
                this.a = -1;
                return this;
            }

            @Override // com.yandex.metrica.impl.ob.e
            public void a(b bVar) throws IOException {
                b bVar2 = this.b;
                if (bVar2 != null) {
                    bVar.a(1, bVar2);
                }
                C0353a[] aVarArr = this.c;
                if (aVarArr != null && aVarArr.length > 0) {
                    int i = 0;
                    while (true) {
                        C0353a[] aVarArr2 = this.c;
                        if (i >= aVarArr2.length) {
                            break;
                        }
                        C0353a aVar = aVarArr2[i];
                        if (aVar != null) {
                            bVar.a(2, aVar);
                        }
                        i++;
                    }
                }
                bVar.b(3, this.d);
                bVar.b(4, this.e);
                super.a(bVar);
            }
        }

        public static final class b extends e {
            public boolean b;
            public boolean c;
            public boolean d;
            public boolean e;
            public boolean f;
            public boolean g;
            public boolean h;
            public boolean i;
            public boolean j;
            public boolean k;
            public boolean l;
            public boolean m;
            public boolean n;
            public boolean o;
            public boolean p;
            public boolean q;
            public boolean r;
            public boolean s;
            public boolean t;
            public boolean u;
            public boolean v;
            public boolean w;
            public boolean x;

            public b() {
                d();
            }

            /* renamed from: b */
            public b a(a aVar) throws IOException {
                while (true) {
                    int a = aVar.a();
                    switch (a) {
                        case 0:
                            return this;
                        case 8:
                            this.b = aVar.h();
                            break;
                        case 16:
                            this.c = aVar.h();
                            break;
                        case 24:
                            this.d = aVar.h();
                            break;
                        case 32:
                            this.e = aVar.h();
                            break;
                        case 40:
                            this.f = aVar.h();
                            break;
                        case 48:
                            this.g = aVar.h();
                            break;
                        case 64:
                            this.h = aVar.h();
                            break;
                        case 72:
                            this.i = aVar.h();
                            break;
                        case 80:
                            this.j = aVar.h();
                            break;
                        case 88:
                            this.k = aVar.h();
                            break;
                        case 96:
                            this.l = aVar.h();
                            break;
                        case 104:
                            this.m = aVar.h();
                            break;
                        case 112:
                            this.n = aVar.h();
                            break;
                        case 120:
                            this.o = aVar.h();
                            break;
                        case 128:
                            this.p = aVar.h();
                            break;
                        case 136:
                            this.q = aVar.h();
                            break;
                        case 144:
                            this.r = aVar.h();
                            break;
                        case 152:
                            this.s = aVar.h();
                            break;
                        case 160:
                            this.t = aVar.h();
                            break;
                        case 168:
                            this.u = aVar.h();
                            break;
                        case 176:
                            this.v = aVar.h();
                            break;
                        case 184:
                            this.w = aVar.h();
                            break;
                        case 192:
                            this.x = aVar.h();
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
                return b.b(24, this.x) + b.b(23, this.w) + b.b(22, this.v) + b.b(21, this.u) + b.b(20, this.t) + b.b(19, this.s) + b.b(18, this.r) + b.b(17, this.q) + b.b(16, this.p) + b.b(15, this.o) + b.b(14, this.n) + b.b(13, this.m) + b.b(12, this.l) + b.b(11, this.k) + b.b(10, this.j) + b.b(9, this.i) + b.b(8, this.h) + b.b(6, this.g) + b.b(5, this.f) + b.b(4, this.e) + b.b(3, this.d) + b.b(2, this.c) + b.b(1, this.b) + super.c();
            }

            public b d() {
                this.b = false;
                this.c = false;
                this.d = false;
                this.e = false;
                this.f = false;
                this.g = false;
                this.h = false;
                this.i = false;
                this.j = false;
                this.k = false;
                this.l = false;
                this.m = false;
                this.n = false;
                this.o = false;
                this.p = true;
                this.q = false;
                this.r = false;
                this.s = false;
                this.t = false;
                this.u = false;
                this.v = false;
                this.w = false;
                this.x = false;
                this.a = -1;
                return this;
            }

            @Override // com.yandex.metrica.impl.ob.e
            public void a(b bVar) throws IOException {
                bVar.a(1, this.b);
                bVar.a(2, this.c);
                bVar.a(3, this.d);
                bVar.a(4, this.e);
                bVar.a(5, this.f);
                bVar.a(6, this.g);
                bVar.a(8, this.h);
                bVar.a(9, this.i);
                bVar.a(10, this.j);
                bVar.a(11, this.k);
                bVar.a(12, this.l);
                bVar.a(13, this.m);
                bVar.a(14, this.n);
                bVar.a(15, this.o);
                bVar.a(16, this.p);
                bVar.a(17, this.q);
                bVar.a(18, this.r);
                bVar.a(19, this.s);
                bVar.a(20, this.t);
                bVar.a(21, this.u);
                bVar.a(22, this.v);
                bVar.a(23, this.w);
                bVar.a(24, this.x);
                super.a(bVar);
            }
        }

        public static final class c extends e {
            public long b;

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
                    if (a == 8) {
                        this.b = aVar.f();
                    } else if (!g.a(aVar, a)) {
                        return this;
                    }
                }
            }

            @Override // com.yandex.metrica.impl.ob.e
            public int c() {
                return b.e(1, this.b) + super.c();
            }

            public c d() {
                this.b = 900;
                this.a = -1;
                return this;
            }

            @Override // com.yandex.metrica.impl.ob.e
            public void a(b bVar) throws IOException {
                bVar.b(1, this.b);
                super.a(bVar);
            }
        }

        public static final class d extends e {
            private static volatile d[] d;
            public C0355a b;
            public b c;

            /* renamed from: com.yandex.metrica.impl.ob.ve$a$d$a  reason: collision with other inner class name */
            public static final class C0355a extends e {
                public long b;
                public float c;
                public int d;
                public int e;
                public long f;
                public int g;
                public boolean h;
                public boolean i;
                public boolean j;
                public long k;
                public C0356a l;
                public C0356a m;
                public C0356a n;
                public C0356a o;
                public b p;

                /* renamed from: com.yandex.metrica.impl.ob.ve$a$d$a$a  reason: collision with other inner class name */
                public static final class C0356a extends e {
                    public boolean b;
                    public boolean c;
                    public C0357a d;

                    /* renamed from: com.yandex.metrica.impl.ob.ve$a$d$a$a$a  reason: collision with other inner class name */
                    public static final class C0357a extends e {
                        public long b;
                        public long c;

                        public C0357a() {
                            d();
                        }

                        /* renamed from: b */
                        public C0357a a(a aVar) throws IOException {
                            while (true) {
                                int a = aVar.a();
                                if (a == 0) {
                                    return this;
                                }
                                if (a == 8) {
                                    this.b = aVar.f();
                                } else if (a == 16) {
                                    this.c = aVar.f();
                                } else if (!g.a(aVar, a)) {
                                    return this;
                                }
                            }
                        }

                        @Override // com.yandex.metrica.impl.ob.e
                        public int c() {
                            return b.e(2, this.c) + b.e(1, this.b) + super.c();
                        }

                        public C0357a d() {
                            this.b = 0;
                            this.c = 0;
                            this.a = -1;
                            return this;
                        }

                        @Override // com.yandex.metrica.impl.ob.e
                        public void a(b bVar) throws IOException {
                            bVar.b(1, this.b);
                            bVar.b(2, this.c);
                            super.a(bVar);
                        }
                    }

                    public C0356a() {
                        d();
                    }

                    /* renamed from: b */
                    public C0356a a(a aVar) throws IOException {
                        while (true) {
                            int a = aVar.a();
                            if (a == 0) {
                                return this;
                            }
                            if (a == 8) {
                                this.b = aVar.h();
                            } else if (a == 16) {
                                this.c = aVar.h();
                            } else if (a == 26) {
                                if (this.d == null) {
                                    this.d = new C0357a();
                                }
                                aVar.a(this.d);
                            } else if (!g.a(aVar, a)) {
                                return this;
                            }
                        }
                    }

                    @Override // com.yandex.metrica.impl.ob.e
                    public int c() {
                        int b2 = b.b(2, this.c) + b.b(1, this.b) + super.c();
                        C0357a aVar = this.d;
                        return aVar != null ? b2 + b.b(3, aVar) : b2;
                    }

                    public C0356a d() {
                        this.b = true;
                        this.c = false;
                        this.d = null;
                        this.a = -1;
                        return this;
                    }

                    @Override // com.yandex.metrica.impl.ob.e
                    public void a(b bVar) throws IOException {
                        bVar.a(1, this.b);
                        bVar.a(2, this.c);
                        C0357a aVar = this.d;
                        if (aVar != null) {
                            bVar.a(3, aVar);
                        }
                        super.a(bVar);
                    }
                }

                /* renamed from: com.yandex.metrica.impl.ob.ve$a$d$a$b */
                public static final class b extends e {
                    public boolean b;
                    public boolean c;
                    public C0358a d;

                    /* renamed from: com.yandex.metrica.impl.ob.ve$a$d$a$b$a  reason: collision with other inner class name */
                    public static final class C0358a extends e {
                        public long b;
                        public long c;
                        public int d;

                        public C0358a() {
                            d();
                        }

                        /* renamed from: b */
                        public C0358a a(a aVar) throws IOException {
                            while (true) {
                                int a = aVar.a();
                                if (a == 0) {
                                    return this;
                                }
                                if (a == 8) {
                                    this.b = aVar.f();
                                } else if (a == 16) {
                                    this.c = aVar.f();
                                } else if (a == 24) {
                                    int g = aVar.g();
                                    if (g == 0 || g == 1 || g == 2 || g == 3) {
                                        this.d = g;
                                    }
                                } else if (!g.a(aVar, a)) {
                                    return this;
                                }
                            }
                        }

                        @Override // com.yandex.metrica.impl.ob.e
                        public int c() {
                            return b.d(3, this.d) + b.e(2, this.c) + b.e(1, this.b) + super.c();
                        }

                        public C0358a d() {
                            this.b = 0;
                            this.c = 0;
                            this.d = 0;
                            this.a = -1;
                            return this;
                        }

                        @Override // com.yandex.metrica.impl.ob.e
                        public void a(b bVar) throws IOException {
                            bVar.b(1, this.b);
                            bVar.b(2, this.c);
                            bVar.a(3, this.d);
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
                            if (a == 8) {
                                this.b = aVar.h();
                            } else if (a == 16) {
                                this.c = aVar.h();
                            } else if (a == 26) {
                                if (this.d == null) {
                                    this.d = new C0358a();
                                }
                                aVar.a(this.d);
                            } else if (!g.a(aVar, a)) {
                                return this;
                            }
                        }
                    }

                    @Override // com.yandex.metrica.impl.ob.e
                    public int c() {
                        int b2 = b.b(2, this.c) + b.b(1, this.b) + super.c();
                        C0358a aVar = this.d;
                        return aVar != null ? b2 + b.b(3, aVar) : b2;
                    }

                    public b d() {
                        this.b = true;
                        this.c = false;
                        this.d = null;
                        this.a = -1;
                        return this;
                    }

                    @Override // com.yandex.metrica.impl.ob.e
                    public void a(b bVar) throws IOException {
                        bVar.a(1, this.b);
                        bVar.a(2, this.c);
                        C0358a aVar = this.d;
                        if (aVar != null) {
                            bVar.a(3, aVar);
                        }
                        super.a(bVar);
                    }
                }

                public C0355a() {
                    d();
                }

                /* renamed from: b */
                public C0355a a(a aVar) throws IOException {
                    while (true) {
                        int a = aVar.a();
                        switch (a) {
                            case 0:
                                return this;
                            case 8:
                                this.b = aVar.f();
                                break;
                            case 21:
                                this.c = aVar.d();
                                break;
                            case 24:
                                this.d = aVar.g();
                                break;
                            case 32:
                                this.e = aVar.g();
                                break;
                            case 40:
                                this.f = aVar.f();
                                break;
                            case 48:
                                this.g = aVar.g();
                                break;
                            case 56:
                                this.h = aVar.h();
                                break;
                            case 64:
                                this.i = aVar.h();
                                break;
                            case 72:
                                this.k = aVar.f();
                                break;
                            case 82:
                                if (this.l == null) {
                                    this.l = new C0356a();
                                }
                                aVar.a(this.l);
                                break;
                            case 90:
                                if (this.m == null) {
                                    this.m = new C0356a();
                                }
                                aVar.a(this.m);
                                break;
                            case 98:
                                if (this.n == null) {
                                    this.n = new C0356a();
                                }
                                aVar.a(this.n);
                                break;
                            case 104:
                                this.j = aVar.h();
                                break;
                            case 114:
                                if (this.o == null) {
                                    this.o = new C0356a();
                                }
                                aVar.a(this.o);
                                break;
                            case 122:
                                if (this.p == null) {
                                    this.p = new b();
                                }
                                aVar.a(this.p);
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
                    int e2 = b.e(9, this.k) + b.b(8, this.i) + b.b(7, this.h) + b.d(6, this.g) + b.e(5, this.f) + b.d(4, this.e) + b.d(3, this.d) + b.b(2, this.c) + b.e(1, this.b) + super.c();
                    C0356a aVar = this.l;
                    if (aVar != null) {
                        e2 += b.b(10, aVar);
                    }
                    C0356a aVar2 = this.m;
                    if (aVar2 != null) {
                        e2 += b.b(11, aVar2);
                    }
                    C0356a aVar3 = this.n;
                    if (aVar3 != null) {
                        e2 += b.b(12, aVar3);
                    }
                    int b2 = b.b(13, this.j) + e2;
                    C0356a aVar4 = this.o;
                    if (aVar4 != null) {
                        b2 += b.b(14, aVar4);
                    }
                    b bVar = this.p;
                    return bVar != null ? b2 + b.b(15, bVar) : b2;
                }

                public C0355a d() {
                    this.b = 5000;
                    this.c = 10.0f;
                    this.d = 20;
                    this.e = 200;
                    this.f = DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS;
                    this.g = 10000;
                    this.h = false;
                    this.i = false;
                    this.j = true;
                    this.k = DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS;
                    this.l = null;
                    this.m = null;
                    this.n = null;
                    this.o = null;
                    this.p = null;
                    this.a = -1;
                    return this;
                }

                @Override // com.yandex.metrica.impl.ob.e
                public void a(b bVar) throws IOException {
                    bVar.b(1, this.b);
                    bVar.a(2, this.c);
                    bVar.a(3, this.d);
                    bVar.a(4, this.e);
                    bVar.b(5, this.f);
                    bVar.a(6, this.g);
                    bVar.a(7, this.h);
                    bVar.a(8, this.i);
                    bVar.b(9, this.k);
                    C0356a aVar = this.l;
                    if (aVar != null) {
                        bVar.a(10, aVar);
                    }
                    C0356a aVar2 = this.m;
                    if (aVar2 != null) {
                        bVar.a(11, aVar2);
                    }
                    C0356a aVar3 = this.n;
                    if (aVar3 != null) {
                        bVar.a(12, aVar3);
                    }
                    bVar.a(13, this.j);
                    C0356a aVar4 = this.o;
                    if (aVar4 != null) {
                        bVar.a(14, aVar4);
                    }
                    b bVar2 = this.p;
                    if (bVar2 != null) {
                        bVar.a(15, bVar2);
                    }
                    super.a(bVar);
                }
            }

            public static final class b extends e {
                public int[] b;
                public int[] c;

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
                        if (a == 8) {
                            int b2 = g.b(aVar, 8);
                            int[] iArr = new int[b2];
                            int i = 0;
                            for (int i2 = 0; i2 < b2; i2++) {
                                if (i2 != 0) {
                                    aVar.a();
                                }
                                int g = aVar.g();
                                if (g == 0 || g == 1 || g == 2 || g == 3 || g == 4) {
                                    iArr[i] = g;
                                    i++;
                                }
                            }
                            if (i != 0) {
                                int[] iArr2 = this.b;
                                int length = iArr2 == null ? 0 : iArr2.length;
                                if (length == 0 && i == b2) {
                                    this.b = iArr;
                                } else {
                                    int[] iArr3 = new int[(length + i)];
                                    if (length != 0) {
                                        System.arraycopy(iArr2, 0, iArr3, 0, length);
                                    }
                                    System.arraycopy(iArr, 0, iArr3, length, i);
                                    this.b = iArr3;
                                }
                            }
                        } else if (a == 10) {
                            int d = aVar.d(aVar.n());
                            int t = aVar.t();
                            int i3 = 0;
                            while (aVar.r() > 0) {
                                int g2 = aVar.g();
                                if (g2 == 0 || g2 == 1 || g2 == 2 || g2 == 3 || g2 == 4) {
                                    i3++;
                                }
                            }
                            if (i3 != 0) {
                                aVar.f(t);
                                int[] iArr4 = this.b;
                                int length2 = iArr4 == null ? 0 : iArr4.length;
                                int[] iArr5 = new int[(i3 + length2)];
                                if (length2 != 0) {
                                    System.arraycopy(iArr4, 0, iArr5, 0, length2);
                                }
                                while (aVar.r() > 0) {
                                    int g3 = aVar.g();
                                    if (g3 == 0 || g3 == 1 || g3 == 2 || g3 == 3 || g3 == 4) {
                                        iArr5[length2] = g3;
                                        length2++;
                                    }
                                }
                                this.b = iArr5;
                            }
                            aVar.e(d);
                        } else if (a == 16) {
                            int b3 = g.b(aVar, 16);
                            int[] iArr6 = new int[b3];
                            int i4 = 0;
                            for (int i5 = 0; i5 < b3; i5++) {
                                if (i5 != 0) {
                                    aVar.a();
                                }
                                int g4 = aVar.g();
                                if (g4 == 0 || g4 == 1 || g4 == 2 || g4 == 3) {
                                    iArr6[i4] = g4;
                                    i4++;
                                }
                            }
                            if (i4 != 0) {
                                int[] iArr7 = this.c;
                                int length3 = iArr7 == null ? 0 : iArr7.length;
                                if (length3 == 0 && i4 == b3) {
                                    this.c = iArr6;
                                } else {
                                    int[] iArr8 = new int[(length3 + i4)];
                                    if (length3 != 0) {
                                        System.arraycopy(iArr7, 0, iArr8, 0, length3);
                                    }
                                    System.arraycopy(iArr6, 0, iArr8, length3, i4);
                                    this.c = iArr8;
                                }
                            }
                        } else if (a == 18) {
                            int d2 = aVar.d(aVar.n());
                            int t2 = aVar.t();
                            int i6 = 0;
                            while (aVar.r() > 0) {
                                int g5 = aVar.g();
                                if (g5 == 0 || g5 == 1 || g5 == 2 || g5 == 3) {
                                    i6++;
                                }
                            }
                            if (i6 != 0) {
                                aVar.f(t2);
                                int[] iArr9 = this.c;
                                int length4 = iArr9 == null ? 0 : iArr9.length;
                                int[] iArr10 = new int[(i6 + length4)];
                                if (length4 != 0) {
                                    System.arraycopy(iArr9, 0, iArr10, 0, length4);
                                }
                                while (aVar.r() > 0) {
                                    int g6 = aVar.g();
                                    if (g6 == 0 || g6 == 1 || g6 == 2 || g6 == 3) {
                                        iArr10[length4] = g6;
                                        length4++;
                                    }
                                }
                                this.c = iArr10;
                            }
                            aVar.e(d2);
                        } else if (!g.a(aVar, a)) {
                            return this;
                        }
                    }
                }

                @Override // com.yandex.metrica.impl.ob.e
                public int c() {
                    int[] iArr;
                    int c2 = super.c();
                    int[] iArr2 = this.b;
                    int i = 0;
                    if (iArr2 != null && iArr2.length > 0) {
                        int i2 = 0;
                        int i3 = 0;
                        while (true) {
                            iArr = this.b;
                            if (i2 >= iArr.length) {
                                break;
                            }
                            i3 += b.d(iArr[i2]);
                            i2++;
                        }
                        c2 = c2 + i3 + (iArr.length * 1);
                    }
                    int[] iArr3 = this.c;
                    if (iArr3 == null || iArr3.length <= 0) {
                        return c2;
                    }
                    int i4 = 0;
                    while (true) {
                        int[] iArr4 = this.c;
                        if (i >= iArr4.length) {
                            return c2 + i4 + (iArr4.length * 1);
                        }
                        i4 += b.d(iArr4[i]);
                        i++;
                    }
                }

                public b d() {
                    int[] iArr = g.a;
                    this.b = iArr;
                    this.c = iArr;
                    this.a = -1;
                    return this;
                }

                @Override // com.yandex.metrica.impl.ob.e
                public void a(b bVar) throws IOException {
                    int[] iArr = this.b;
                    int i = 0;
                    if (iArr != null && iArr.length > 0) {
                        int i2 = 0;
                        while (true) {
                            int[] iArr2 = this.b;
                            if (i2 >= iArr2.length) {
                                break;
                            }
                            bVar.a(1, iArr2[i2]);
                            i2++;
                        }
                    }
                    int[] iArr3 = this.c;
                    if (iArr3 != null && iArr3.length > 0) {
                        while (true) {
                            int[] iArr4 = this.c;
                            if (i >= iArr4.length) {
                                break;
                            }
                            bVar.a(2, iArr4[i]);
                            i++;
                        }
                    }
                    super.a(bVar);
                }
            }

            public d() {
                e();
            }

            public static d[] d() {
                if (d == null) {
                    synchronized (c.a) {
                        if (d == null) {
                            d = new d[0];
                        }
                    }
                }
                return d;
            }

            /* renamed from: b */
            public d a(a aVar) throws IOException {
                while (true) {
                    int a = aVar.a();
                    if (a == 0) {
                        return this;
                    }
                    if (a == 10) {
                        if (this.b == null) {
                            this.b = new C0355a();
                        }
                        aVar.a(this.b);
                    } else if (a == 18) {
                        if (this.c == null) {
                            this.c = new b();
                        }
                        aVar.a(this.c);
                    } else if (!g.a(aVar, a)) {
                        return this;
                    }
                }
            }

            @Override // com.yandex.metrica.impl.ob.e
            public int c() {
                int c2 = super.c();
                C0355a aVar = this.b;
                if (aVar != null) {
                    c2 += b.b(1, aVar);
                }
                b bVar = this.c;
                return bVar != null ? c2 + b.b(2, bVar) : c2;
            }

            public d e() {
                this.b = null;
                this.c = null;
                this.a = -1;
                return this;
            }

            @Override // com.yandex.metrica.impl.ob.e
            public void a(b bVar) throws IOException {
                C0355a aVar = this.b;
                if (aVar != null) {
                    bVar.a(1, aVar);
                }
                b bVar2 = this.c;
                if (bVar2 != null) {
                    bVar.a(2, bVar2);
                }
                super.a(bVar);
            }
        }

        public static final class e extends e {
            private static volatile e[] d;
            public String b;
            public boolean c;

            public e() {
                e();
            }

            public static e[] d() {
                if (d == null) {
                    synchronized (c.a) {
                        if (d == null) {
                            d = new e[0];
                        }
                    }
                }
                return d;
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
                        this.c = aVar.h();
                    } else if (!g.a(aVar, a)) {
                        return this;
                    }
                }
            }

            @Override // com.yandex.metrica.impl.ob.e
            public int c() {
                return b.b(2, this.c) + b.b(1, this.b) + super.c();
            }

            public e e() {
                this.b = "";
                this.c = false;
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

        public static final class f extends e {
            public long b;
            public long c;

            public f() {
                d();
            }

            /* renamed from: b */
            public f a(a aVar) throws IOException {
                while (true) {
                    int a = aVar.a();
                    if (a == 0) {
                        return this;
                    }
                    if (a == 8) {
                        this.b = aVar.f();
                    } else if (a == 16) {
                        this.c = aVar.f();
                    } else if (!g.a(aVar, a)) {
                        return this;
                    }
                }
            }

            @Override // com.yandex.metrica.impl.ob.e
            public int c() {
                return b.e(2, this.c) + b.e(1, this.b) + super.c();
            }

            public f d() {
                this.b = 86400;
                this.c = 432000;
                this.a = -1;
                return this;
            }

            @Override // com.yandex.metrica.impl.ob.e
            public void a(b bVar) throws IOException {
                bVar.b(1, this.b);
                bVar.b(2, this.c);
                super.a(bVar);
            }
        }

        public static final class g extends e {
            private static volatile g[] h;
            public String b;
            public String c;
            public String d;
            public C0359a[] e;
            public long f;
            public int[] g;

            /* renamed from: com.yandex.metrica.impl.ob.ve$a$g$a  reason: collision with other inner class name */
            public static final class C0359a extends e {
                private static volatile C0359a[] d;
                public String b;
                public String c;

                public C0359a() {
                    e();
                }

                public static C0359a[] d() {
                    if (d == null) {
                        synchronized (c.a) {
                            if (d == null) {
                                d = new C0359a[0];
                            }
                        }
                    }
                    return d;
                }

                /* renamed from: b */
                public C0359a a(a aVar) throws IOException {
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

                public C0359a e() {
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

            public g() {
                e();
            }

            public static g[] d() {
                if (h == null) {
                    synchronized (c.a) {
                        if (h == null) {
                            h = new g[0];
                        }
                    }
                }
                return h;
            }

            /* renamed from: b */
            public g a(a aVar) throws IOException {
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
                    } else if (a == 34) {
                        int b2 = g.b(aVar, 34);
                        C0359a[] aVarArr = this.e;
                        int length = aVarArr == null ? 0 : aVarArr.length;
                        int i = b2 + length;
                        C0359a[] aVarArr2 = new C0359a[i];
                        if (length != 0) {
                            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                        }
                        while (length < i - 1) {
                            aVarArr2[length] = new C0359a();
                            aVar.a(aVarArr2[length]);
                            aVar.a();
                            length++;
                        }
                        aVarArr2[length] = new C0359a();
                        aVar.a(aVarArr2[length]);
                        this.e = aVarArr2;
                    } else if (a == 40) {
                        this.f = aVar.f();
                    } else if (a == 48) {
                        int b3 = g.b(aVar, 48);
                        int[] iArr = new int[b3];
                        int i2 = 0;
                        for (int i3 = 0; i3 < b3; i3++) {
                            if (i3 != 0) {
                                aVar.a();
                            }
                            int g2 = aVar.g();
                            if (g2 == 1 || g2 == 2) {
                                iArr[i2] = g2;
                                i2++;
                            }
                        }
                        if (i2 != 0) {
                            int[] iArr2 = this.g;
                            int length2 = iArr2 == null ? 0 : iArr2.length;
                            if (length2 == 0 && i2 == b3) {
                                this.g = iArr;
                            } else {
                                int[] iArr3 = new int[(length2 + i2)];
                                if (length2 != 0) {
                                    System.arraycopy(iArr2, 0, iArr3, 0, length2);
                                }
                                System.arraycopy(iArr, 0, iArr3, length2, i2);
                                this.g = iArr3;
                            }
                        }
                    } else if (a == 50) {
                        int d2 = aVar.d(aVar.n());
                        int t = aVar.t();
                        int i4 = 0;
                        while (aVar.r() > 0) {
                            int g3 = aVar.g();
                            if (g3 == 1 || g3 == 2) {
                                i4++;
                            }
                        }
                        if (i4 != 0) {
                            aVar.f(t);
                            int[] iArr4 = this.g;
                            int length3 = iArr4 == null ? 0 : iArr4.length;
                            int[] iArr5 = new int[(i4 + length3)];
                            if (length3 != 0) {
                                System.arraycopy(iArr4, 0, iArr5, 0, length3);
                            }
                            while (aVar.r() > 0) {
                                int g4 = aVar.g();
                                if (g4 == 1 || g4 == 2) {
                                    iArr5[length3] = g4;
                                    length3++;
                                }
                            }
                            this.g = iArr5;
                        }
                        aVar.e(d2);
                    } else if (!g.a(aVar, a)) {
                        return this;
                    }
                }
            }

            @Override // com.yandex.metrica.impl.ob.e
            public int c() {
                int b2 = b.b(3, this.d) + b.b(2, this.c) + b.b(1, this.b) + super.c();
                C0359a[] aVarArr = this.e;
                int i = 0;
                if (aVarArr != null && aVarArr.length > 0) {
                    int i2 = 0;
                    while (true) {
                        C0359a[] aVarArr2 = this.e;
                        if (i2 >= aVarArr2.length) {
                            break;
                        }
                        C0359a aVar = aVarArr2[i2];
                        if (aVar != null) {
                            b2 += b.b(4, aVar);
                        }
                        i2++;
                    }
                }
                int e2 = b.e(5, this.f) + b2;
                int[] iArr = this.g;
                if (iArr == null || iArr.length <= 0) {
                    return e2;
                }
                int i3 = 0;
                while (true) {
                    int[] iArr2 = this.g;
                    if (i >= iArr2.length) {
                        return e2 + i3 + (iArr2.length * 1);
                    }
                    i3 += b.d(iArr2[i]);
                    i++;
                }
            }

            public g e() {
                this.b = "";
                this.c = "";
                this.d = "";
                this.e = C0359a.d();
                this.f = 0;
                this.g = g.a;
                this.a = -1;
                return this;
            }

            @Override // com.yandex.metrica.impl.ob.e
            public void a(b bVar) throws IOException {
                bVar.a(1, this.b);
                bVar.a(2, this.c);
                bVar.a(3, this.d);
                C0359a[] aVarArr = this.e;
                int i = 0;
                if (aVarArr != null && aVarArr.length > 0) {
                    int i2 = 0;
                    while (true) {
                        C0359a[] aVarArr2 = this.e;
                        if (i2 >= aVarArr2.length) {
                            break;
                        }
                        C0359a aVar = aVarArr2[i2];
                        if (aVar != null) {
                            bVar.a(4, aVar);
                        }
                        i2++;
                    }
                }
                bVar.b(5, this.f);
                int[] iArr = this.g;
                if (iArr != null && iArr.length > 0) {
                    while (true) {
                        int[] iArr2 = this.g;
                        if (i >= iArr2.length) {
                            break;
                        }
                        bVar.a(6, iArr2[i]);
                        i++;
                    }
                }
                super.a(bVar);
            }
        }

        public static final class h extends e {
            public long b;
            public long c;
            public long d;
            public long e;

            public h() {
                d();
            }

            /* renamed from: b */
            public h a(a aVar) throws IOException {
                while (true) {
                    int a = aVar.a();
                    if (a == 0) {
                        return this;
                    }
                    if (a == 8) {
                        this.b = aVar.f();
                    } else if (a == 16) {
                        this.c = aVar.f();
                    } else if (a == 24) {
                        this.d = aVar.f();
                    } else if (a == 32) {
                        this.e = aVar.f();
                    } else if (!g.a(aVar, a)) {
                        return this;
                    }
                }
            }

            @Override // com.yandex.metrica.impl.ob.e
            public int c() {
                int c2 = super.c();
                long j = this.b;
                if (j != 432000000) {
                    c2 += b.e(1, j);
                }
                long j2 = this.c;
                if (j2 != 86400000) {
                    c2 += b.e(2, j2);
                }
                long j3 = this.d;
                if (j3 != 10000) {
                    c2 += b.e(3, j3);
                }
                long j4 = this.e;
                return j4 != ConstantsKt.DEFAULT_TIME_TO_MODIFY_MESSAGE_MS ? c2 + b.e(4, j4) : c2;
            }

            public h d() {
                this.b = 432000000;
                this.c = 86400000;
                this.d = 10000;
                this.e = ConstantsKt.DEFAULT_TIME_TO_MODIFY_MESSAGE_MS;
                this.a = -1;
                return this;
            }

            @Override // com.yandex.metrica.impl.ob.e
            public void a(b bVar) throws IOException {
                long j = this.b;
                if (j != 432000000) {
                    bVar.b(1, j);
                }
                long j2 = this.c;
                if (j2 != 86400000) {
                    bVar.b(2, j2);
                }
                long j3 = this.d;
                if (j3 != 10000) {
                    bVar.b(3, j3);
                }
                long j4 = this.e;
                if (j4 != ConstantsKt.DEFAULT_TIME_TO_MODIFY_MESSAGE_MS) {
                    bVar.b(4, j4);
                }
                super.a(bVar);
            }
        }

        public static final class i extends e {
            public long b;
            public String c;
            public int[] d;
            public long e;
            public int f;

            public i() {
                d();
            }

            /* renamed from: b */
            public i a(a aVar) throws IOException {
                while (true) {
                    int a = aVar.a();
                    if (a == 0) {
                        return this;
                    }
                    if (a == 8) {
                        this.b = aVar.f();
                    } else if (a == 18) {
                        this.c = aVar.i();
                    } else if (a == 24) {
                        int b2 = g.b(aVar, 24);
                        int[] iArr = this.d;
                        int length = iArr == null ? 0 : iArr.length;
                        int i = b2 + length;
                        int[] iArr2 = new int[i];
                        if (length != 0) {
                            System.arraycopy(iArr, 0, iArr2, 0, length);
                        }
                        while (length < i - 1) {
                            iArr2[length] = aVar.g();
                            aVar.a();
                            length++;
                        }
                        iArr2[length] = aVar.g();
                        this.d = iArr2;
                    } else if (a == 26) {
                        int d2 = aVar.d(aVar.n());
                        int t = aVar.t();
                        int i2 = 0;
                        while (aVar.r() > 0) {
                            aVar.g();
                            i2++;
                        }
                        aVar.f(t);
                        int[] iArr3 = this.d;
                        int length2 = iArr3 == null ? 0 : iArr3.length;
                        int i3 = i2 + length2;
                        int[] iArr4 = new int[i3];
                        if (length2 != 0) {
                            System.arraycopy(iArr3, 0, iArr4, 0, length2);
                        }
                        while (length2 < i3) {
                            iArr4[length2] = aVar.g();
                            length2++;
                        }
                        this.d = iArr4;
                        aVar.e(d2);
                    } else if (a == 32) {
                        this.e = aVar.f();
                    } else if (a == 40) {
                        this.f = aVar.g();
                    } else if (!g.a(aVar, a)) {
                        return this;
                    }
                }
            }

            @Override // com.yandex.metrica.impl.ob.e
            public int c() {
                int[] iArr;
                int b2 = b.b(2, this.c) + b.e(1, this.b) + super.c();
                int[] iArr2 = this.d;
                if (iArr2 != null && iArr2.length > 0) {
                    int i = 0;
                    int i2 = 0;
                    while (true) {
                        iArr = this.d;
                        if (i >= iArr.length) {
                            break;
                        }
                        i2 += b.d(iArr[i]);
                        i++;
                    }
                    b2 = b2 + i2 + (iArr.length * 1);
                }
                return b.d(5, this.f) + b.e(4, this.e) + b2;
            }

            public i d() {
                this.b = 0;
                this.c = "";
                this.d = g.a;
                this.e = 259200;
                this.f = 10;
                this.a = -1;
                return this;
            }

            @Override // com.yandex.metrica.impl.ob.e
            public void a(b bVar) throws IOException {
                bVar.b(1, this.b);
                bVar.a(2, this.c);
                int[] iArr = this.d;
                if (iArr != null && iArr.length > 0) {
                    int i = 0;
                    while (true) {
                        int[] iArr2 = this.d;
                        if (i >= iArr2.length) {
                            break;
                        }
                        bVar.a(3, iArr2[i]);
                        i++;
                    }
                }
                bVar.b(4, this.e);
                bVar.a(5, this.f);
                super.a(bVar);
            }
        }

        public static final class j extends e {
            public long b;

            public j() {
                d();
            }

            /* renamed from: b */
            public j a(a aVar) throws IOException {
                while (true) {
                    int a = aVar.a();
                    if (a == 0) {
                        return this;
                    }
                    if (a == 8) {
                        this.b = aVar.f();
                    } else if (!g.a(aVar, a)) {
                        return this;
                    }
                }
            }

            @Override // com.yandex.metrica.impl.ob.e
            public int c() {
                return b.e(1, this.b) + super.c();
            }

            public j d() {
                this.b = WorkRequest.MAX_BACKOFF_MILLIS;
                this.a = -1;
                return this;
            }

            @Override // com.yandex.metrica.impl.ob.e
            public void a(b bVar) throws IOException {
                bVar.b(1, this.b);
                super.a(bVar);
            }
        }

        public static final class k extends e {
            public boolean b;
            public boolean c;
            public boolean d;
            public boolean e;
            public int f;
            public int g;
            public int h;
            public int i;
            public boolean j;
            public boolean k;
            public boolean l;

            public k() {
                d();
            }

            /* renamed from: b */
            public k a(a aVar) throws IOException {
                while (true) {
                    int a = aVar.a();
                    switch (a) {
                        case 0:
                            return this;
                        case 8:
                            this.b = aVar.h();
                            break;
                        case 16:
                            this.c = aVar.h();
                            break;
                        case 24:
                            this.d = aVar.h();
                            break;
                        case 32:
                            this.e = aVar.h();
                            break;
                        case 40:
                            this.f = aVar.g();
                            break;
                        case 48:
                            this.g = aVar.g();
                            break;
                        case 56:
                            this.h = aVar.g();
                            break;
                        case 64:
                            this.i = aVar.g();
                            break;
                        case 72:
                            this.j = aVar.h();
                            break;
                        case 80:
                            this.k = aVar.h();
                            break;
                        case 88:
                            this.l = aVar.h();
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
                return b.b(11, this.l) + b.b(10, this.k) + b.b(9, this.j) + b.d(8, this.i) + b.d(7, this.h) + b.d(6, this.g) + b.d(5, this.f) + b.b(4, this.e) + b.b(3, this.d) + b.b(2, this.c) + b.b(1, this.b) + super.c();
            }

            public k d() {
                this.b = true;
                this.c = true;
                this.d = true;
                this.e = true;
                this.f = 10000;
                this.g = 1000;
                this.h = 1000;
                this.i = 200000;
                this.j = false;
                this.k = false;
                this.l = false;
                this.a = -1;
                return this;
            }

            @Override // com.yandex.metrica.impl.ob.e
            public void a(b bVar) throws IOException {
                bVar.a(1, this.b);
                bVar.a(2, this.c);
                bVar.a(3, this.d);
                bVar.a(4, this.e);
                bVar.a(5, this.f);
                bVar.a(6, this.g);
                bVar.a(7, this.h);
                bVar.a(8, this.i);
                bVar.a(9, this.j);
                bVar.a(10, this.k);
                bVar.a(11, this.l);
                super.a(bVar);
            }
        }

        public static final class l extends e {
            public int b;
            public int c;
            public int d;
            public long e;
            public boolean f;

            public l() {
                d();
            }

            /* renamed from: b */
            public l a(a aVar) throws IOException {
                while (true) {
                    int a = aVar.a();
                    if (a == 0) {
                        return this;
                    }
                    if (a == 8) {
                        this.b = aVar.g();
                    } else if (a == 16) {
                        this.c = aVar.g();
                    } else if (a == 24) {
                        this.d = aVar.g();
                    } else if (a == 32) {
                        this.e = aVar.f();
                    } else if (a == 40) {
                        this.f = aVar.h();
                    } else if (!g.a(aVar, a)) {
                        return this;
                    }
                }
            }

            @Override // com.yandex.metrica.impl.ob.e
            public int c() {
                return b.b(5, this.f) + b.e(4, this.e) + b.d(3, this.d) + b.d(2, this.c) + b.d(1, this.b) + super.c();
            }

            public l d() {
                this.b = 10000;
                this.c = 1000;
                this.d = 100;
                this.e = 5000;
                this.f = true;
                this.a = -1;
                return this;
            }

            @Override // com.yandex.metrica.impl.ob.e
            public void a(b bVar) throws IOException {
                bVar.a(1, this.b);
                bVar.a(2, this.c);
                bVar.a(3, this.d);
                bVar.b(4, this.e);
                bVar.a(5, this.f);
                super.a(bVar);
            }
        }

        public static final class m extends e {
            public long b;
            public boolean c;
            public C0360a[] d;

            /* renamed from: com.yandex.metrica.impl.ob.ve$a$m$a  reason: collision with other inner class name */
            public static final class C0360a extends e {
                private static volatile C0360a[] d;
                public long b;
                public long c;

                public C0360a() {
                    e();
                }

                public static C0360a[] d() {
                    if (d == null) {
                        synchronized (c.a) {
                            if (d == null) {
                                d = new C0360a[0];
                            }
                        }
                    }
                    return d;
                }

                /* renamed from: b */
                public C0360a a(a aVar) throws IOException {
                    while (true) {
                        int a = aVar.a();
                        if (a == 0) {
                            return this;
                        }
                        if (a == 8) {
                            this.b = aVar.f();
                        } else if (a == 16) {
                            this.c = aVar.f();
                        } else if (!g.a(aVar, a)) {
                            return this;
                        }
                    }
                }

                @Override // com.yandex.metrica.impl.ob.e
                public int c() {
                    return b.e(2, this.c) + b.e(1, this.b) + super.c();
                }

                public C0360a e() {
                    this.b = 0;
                    this.c = 0;
                    this.a = -1;
                    return this;
                }

                @Override // com.yandex.metrica.impl.ob.e
                public void a(b bVar) throws IOException {
                    bVar.b(1, this.b);
                    bVar.b(2, this.c);
                    super.a(bVar);
                }
            }

            public m() {
                d();
            }

            /* renamed from: b */
            public m a(a aVar) throws IOException {
                while (true) {
                    int a = aVar.a();
                    if (a == 0) {
                        return this;
                    }
                    if (a == 8) {
                        this.b = aVar.f();
                    } else if (a == 16) {
                        this.c = aVar.h();
                    } else if (a == 42) {
                        int b2 = g.b(aVar, 42);
                        C0360a[] aVarArr = this.d;
                        int length = aVarArr == null ? 0 : aVarArr.length;
                        int i = b2 + length;
                        C0360a[] aVarArr2 = new C0360a[i];
                        if (length != 0) {
                            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                        }
                        while (length < i - 1) {
                            aVarArr2[length] = new C0360a();
                            aVar.a(aVarArr2[length]);
                            aVar.a();
                            length++;
                        }
                        aVarArr2[length] = new C0360a();
                        aVar.a(aVarArr2[length]);
                        this.d = aVarArr2;
                    } else if (!g.a(aVar, a)) {
                        return this;
                    }
                }
            }

            @Override // com.yandex.metrica.impl.ob.e
            public int c() {
                int b2 = b.b(2, this.c) + b.e(1, this.b) + super.c();
                C0360a[] aVarArr = this.d;
                if (aVarArr != null && aVarArr.length > 0) {
                    int i = 0;
                    while (true) {
                        C0360a[] aVarArr2 = this.d;
                        if (i >= aVarArr2.length) {
                            break;
                        }
                        C0360a aVar = aVarArr2[i];
                        if (aVar != null) {
                            b2 += b.b(5, aVar);
                        }
                        i++;
                    }
                }
                return b2;
            }

            public m d() {
                this.b = DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS;
                this.c = false;
                this.d = C0360a.d();
                this.a = -1;
                return this;
            }

            @Override // com.yandex.metrica.impl.ob.e
            public void a(b bVar) throws IOException {
                bVar.b(1, this.b);
                bVar.a(2, this.c);
                C0360a[] aVarArr = this.d;
                if (aVarArr != null && aVarArr.length > 0) {
                    int i = 0;
                    while (true) {
                        C0360a[] aVarArr2 = this.d;
                        if (i >= aVarArr2.length) {
                            break;
                        }
                        C0360a aVar = aVarArr2[i];
                        if (aVar != null) {
                            bVar.a(5, aVar);
                        }
                        i++;
                    }
                }
                super.a(bVar);
            }
        }

        public a() {
            d();
        }

        /* renamed from: b */
        public a a(a aVar) throws IOException {
            while (true) {
                int a = aVar.a();
                switch (a) {
                    case 0:
                        return this;
                    case 10:
                        this.b = aVar.i();
                        break;
                    case 24:
                        this.c = aVar.f();
                        break;
                    case 34:
                        int b2 = g.b(aVar, 34);
                        String[] strArr = this.d;
                        int length = strArr == null ? 0 : strArr.length;
                        int i2 = b2 + length;
                        String[] strArr2 = new String[i2];
                        if (length != 0) {
                            System.arraycopy(strArr, 0, strArr2, 0, length);
                        }
                        while (length < i2 - 1) {
                            strArr2[length] = aVar.i();
                            aVar.a();
                            length++;
                        }
                        strArr2[length] = aVar.i();
                        this.d = strArr2;
                        break;
                    case 42:
                        this.e = aVar.i();
                        break;
                    case 50:
                        this.f = aVar.i();
                        break;
                    case 58:
                        int b3 = g.b(aVar, 58);
                        String[] strArr3 = this.g;
                        int length2 = strArr3 == null ? 0 : strArr3.length;
                        int i3 = b3 + length2;
                        String[] strArr4 = new String[i3];
                        if (length2 != 0) {
                            System.arraycopy(strArr3, 0, strArr4, 0, length2);
                        }
                        while (length2 < i3 - 1) {
                            strArr4[length2] = aVar.i();
                            aVar.a();
                            length2++;
                        }
                        strArr4[length2] = aVar.i();
                        this.g = strArr4;
                        break;
                    case 66:
                        int b4 = g.b(aVar, 66);
                        String[] strArr5 = this.h;
                        int length3 = strArr5 == null ? 0 : strArr5.length;
                        int i4 = b4 + length3;
                        String[] strArr6 = new String[i4];
                        if (length3 != 0) {
                            System.arraycopy(strArr5, 0, strArr6, 0, length3);
                        }
                        while (length3 < i4 - 1) {
                            strArr6[length3] = aVar.i();
                            aVar.a();
                            length3++;
                        }
                        strArr6[length3] = aVar.i();
                        this.h = strArr6;
                        break;
                    case 74:
                        int b5 = g.b(aVar, 74);
                        String[] strArr7 = this.i;
                        int length4 = strArr7 == null ? 0 : strArr7.length;
                        int i5 = b5 + length4;
                        String[] strArr8 = new String[i5];
                        if (length4 != 0) {
                            System.arraycopy(strArr7, 0, strArr8, 0, length4);
                        }
                        while (length4 < i5 - 1) {
                            strArr8[length4] = aVar.i();
                            aVar.a();
                            length4++;
                        }
                        strArr8[length4] = aVar.i();
                        this.i = strArr8;
                        break;
                    case 82:
                        if (this.j == null) {
                            this.j = new b();
                        }
                        aVar.a(this.j);
                        break;
                    case 90:
                        int b6 = g.b(aVar, 90);
                        d[] dVarArr = this.k;
                        int length5 = dVarArr == null ? 0 : dVarArr.length;
                        int i6 = b6 + length5;
                        d[] dVarArr2 = new d[i6];
                        if (length5 != 0) {
                            System.arraycopy(dVarArr, 0, dVarArr2, 0, length5);
                        }
                        while (length5 < i6 - 1) {
                            dVarArr2[length5] = new d();
                            aVar.a(dVarArr2[length5]);
                            aVar.a();
                            length5++;
                        }
                        dVarArr2[length5] = new d();
                        aVar.a(dVarArr2[length5]);
                        this.k = dVarArr2;
                        break;
                    case 98:
                        if (this.l == null) {
                            this.l = new m();
                        }
                        aVar.a(this.l);
                        break;
                    case 106:
                        if (this.m == null) {
                            this.m = new i();
                        }
                        aVar.a(this.m);
                        break;
                    case 114:
                        int b8 = g.b(aVar, 114);
                        g[] gVarArr = this.n;
                        int length6 = gVarArr == null ? 0 : gVarArr.length;
                        int i7 = b8 + length6;
                        g[] gVarArr2 = new g[i7];
                        if (length6 != 0) {
                            System.arraycopy(gVarArr, 0, gVarArr2, 0, length6);
                        }
                        while (length6 < i7 - 1) {
                            gVarArr2[length6] = new g();
                            aVar.a(gVarArr2[length6]);
                            aVar.a();
                            length6++;
                        }
                        gVarArr2[length6] = new g();
                        aVar.a(gVarArr2[length6]);
                        this.n = gVarArr2;
                        break;
                    case 122:
                        this.o = aVar.i();
                        break;
                    case 130:
                        this.p = aVar.i();
                        break;
                    case 136:
                        this.q = aVar.h();
                        break;
                    case 146:
                        this.r = aVar.i();
                        break;
                    case 154:
                        this.s = aVar.i();
                        break;
                    case 162:
                        int b9 = g.b(aVar, 162);
                        String[] strArr9 = this.t;
                        int length7 = strArr9 == null ? 0 : strArr9.length;
                        int i8 = b9 + length7;
                        String[] strArr10 = new String[i8];
                        if (length7 != 0) {
                            System.arraycopy(strArr9, 0, strArr10, 0, length7);
                        }
                        while (length7 < i8 - 1) {
                            strArr10[length7] = aVar.i();
                            aVar.a();
                            length7++;
                        }
                        strArr10[length7] = aVar.i();
                        this.t = strArr10;
                        break;
                    case 170:
                        if (this.u == null) {
                            this.u = new j();
                        }
                        aVar.a(this.u);
                        break;
                    case 176:
                        this.v = aVar.h();
                        break;
                    case 186:
                        int b10 = g.b(aVar, 186);
                        e[] eVarArr = this.w;
                        int length8 = eVarArr == null ? 0 : eVarArr.length;
                        int i9 = b10 + length8;
                        e[] eVarArr2 = new e[i9];
                        if (length8 != 0) {
                            System.arraycopy(eVarArr, 0, eVarArr2, 0, length8);
                        }
                        while (length8 < i9 - 1) {
                            eVarArr2[length8] = new e();
                            aVar.a(eVarArr2[length8]);
                            aVar.a();
                            length8++;
                        }
                        eVarArr2[length8] = new e();
                        aVar.a(eVarArr2[length8]);
                        this.w = eVarArr2;
                        break;
                    case 194:
                        if (this.x == null) {
                            this.x = new h();
                        }
                        aVar.a(this.x);
                        break;
                    case 202:
                        this.y = aVar.i();
                        break;
                    case 210:
                        this.z = aVar.i();
                        break;
                    case 218:
                        this.B = aVar.i();
                        break;
                    case 224:
                        this.C = aVar.f();
                        break;
                    case 232:
                        this.D = aVar.f();
                        break;
                    case 240:
                        this.E = aVar.h();
                        break;
                    case 250:
                        this.A = aVar.i();
                        break;
                    case 258:
                        if (this.F == null) {
                            this.F = new f();
                        }
                        aVar.a(this.F);
                        break;
                    case 266:
                        if (this.G == null) {
                            this.G = new c();
                        }
                        aVar.a(this.G);
                        break;
                    case 274:
                        if (this.H == null) {
                            this.H = new C0352a();
                        }
                        aVar.a(this.H);
                        break;
                    case 280:
                        this.I = aVar.g();
                        break;
                    case 288:
                        this.J = aVar.g();
                        break;
                    case 298:
                        if (this.K == null) {
                            this.K = new l();
                        }
                        aVar.a(this.K);
                        break;
                    case 306:
                        if (this.L == null) {
                            this.L = new k();
                        }
                        aVar.a(this.L);
                        break;
                    case 314:
                        if (this.M == null) {
                            this.M = new k();
                        }
                        aVar.a(this.M);
                        break;
                    case 322:
                        this.N = aVar.i();
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
            if (!this.b.equals("")) {
                c2 += b.b(1, this.b);
            }
            int e2 = b.e(3, this.c) + c2;
            String[] strArr = this.d;
            int i2 = 0;
            if (strArr != null && strArr.length > 0) {
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    String[] strArr2 = this.d;
                    if (i3 >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i3];
                    if (str != null) {
                        i5++;
                        i4 += b.b(str);
                    }
                    i3++;
                }
                e2 = e2 + i4 + (i5 * 1);
            }
            if (!this.e.equals("")) {
                e2 += b.b(5, this.e);
            }
            if (!this.f.equals("")) {
                e2 += b.b(6, this.f);
            }
            String[] strArr3 = this.g;
            if (strArr3 != null && strArr3.length > 0) {
                int i6 = 0;
                int i7 = 0;
                int i8 = 0;
                while (true) {
                    String[] strArr4 = this.g;
                    if (i6 >= strArr4.length) {
                        break;
                    }
                    String str2 = strArr4[i6];
                    if (str2 != null) {
                        i8++;
                        i7 += b.b(str2);
                    }
                    i6++;
                }
                e2 = e2 + i7 + (i8 * 1);
            }
            String[] strArr5 = this.h;
            if (strArr5 != null && strArr5.length > 0) {
                int i9 = 0;
                int i10 = 0;
                int i11 = 0;
                while (true) {
                    String[] strArr6 = this.h;
                    if (i9 >= strArr6.length) {
                        break;
                    }
                    String str3 = strArr6[i9];
                    if (str3 != null) {
                        i11++;
                        i10 += b.b(str3);
                    }
                    i9++;
                }
                e2 = e2 + i10 + (i11 * 1);
            }
            String[] strArr7 = this.i;
            if (strArr7 != null && strArr7.length > 0) {
                int i12 = 0;
                int i13 = 0;
                int i14 = 0;
                while (true) {
                    String[] strArr8 = this.i;
                    if (i12 >= strArr8.length) {
                        break;
                    }
                    String str4 = strArr8[i12];
                    if (str4 != null) {
                        i14++;
                        i13 += b.b(str4);
                    }
                    i12++;
                }
                e2 = e2 + i13 + (i14 * 1);
            }
            b bVar = this.j;
            if (bVar != null) {
                e2 += b.b(10, bVar);
            }
            d[] dVarArr = this.k;
            if (dVarArr != null && dVarArr.length > 0) {
                int i15 = 0;
                while (true) {
                    d[] dVarArr2 = this.k;
                    if (i15 >= dVarArr2.length) {
                        break;
                    }
                    d dVar = dVarArr2[i15];
                    if (dVar != null) {
                        e2 += b.b(11, dVar);
                    }
                    i15++;
                }
            }
            m mVar = this.l;
            if (mVar != null) {
                e2 += b.b(12, mVar);
            }
            i iVar = this.m;
            if (iVar != null) {
                e2 += b.b(13, iVar);
            }
            g[] gVarArr = this.n;
            if (gVarArr != null && gVarArr.length > 0) {
                int i16 = 0;
                while (true) {
                    g[] gVarArr2 = this.n;
                    if (i16 >= gVarArr2.length) {
                        break;
                    }
                    g gVar = gVarArr2[i16];
                    if (gVar != null) {
                        e2 += b.b(14, gVar);
                    }
                    i16++;
                }
            }
            if (!this.o.equals("")) {
                e2 += b.b(15, this.o);
            }
            if (!this.p.equals("")) {
                e2 += b.b(16, this.p);
            }
            int b2 = b.b(17, this.q) + e2;
            if (!this.r.equals("")) {
                b2 += b.b(18, this.r);
            }
            if (!this.s.equals("")) {
                b2 += b.b(19, this.s);
            }
            String[] strArr9 = this.t;
            if (strArr9 != null && strArr9.length > 0) {
                int i17 = 0;
                int i18 = 0;
                int i19 = 0;
                while (true) {
                    String[] strArr10 = this.t;
                    if (i17 >= strArr10.length) {
                        break;
                    }
                    String str5 = strArr10[i17];
                    if (str5 != null) {
                        i19++;
                        i18 += b.b(str5);
                    }
                    i17++;
                }
                b2 = b2 + i18 + (i19 * 2);
            }
            j jVar = this.u;
            if (jVar != null) {
                b2 += b.b(21, jVar);
            }
            boolean z2 = this.v;
            if (z2) {
                b2 += b.b(22, z2);
            }
            e[] eVarArr = this.w;
            if (eVarArr != null && eVarArr.length > 0) {
                while (true) {
                    e[] eVarArr2 = this.w;
                    if (i2 >= eVarArr2.length) {
                        break;
                    }
                    e eVar = eVarArr2[i2];
                    if (eVar != null) {
                        b2 += b.b(23, eVar);
                    }
                    i2++;
                }
            }
            h hVar = this.x;
            if (hVar != null) {
                b2 += b.b(24, hVar);
            }
            if (!this.y.equals("")) {
                b2 += b.b(25, this.y);
            }
            if (!this.z.equals("")) {
                b2 += b.b(26, this.z);
            }
            if (!this.B.equals("")) {
                b2 += b.b(27, this.B);
            }
            int e3 = b.e(29, this.D) + b.e(28, this.C) + b2;
            boolean z3 = this.E;
            if (z3) {
                e3 += b.b(30, z3);
            }
            if (!this.A.equals("")) {
                e3 += b.b(31, this.A);
            }
            f fVar = this.F;
            if (fVar != null) {
                e3 += b.b(32, fVar);
            }
            c cVar = this.G;
            if (cVar != null) {
                e3 += b.b(33, cVar);
            }
            C0352a aVar = this.H;
            if (aVar != null) {
                e3 += b.b(34, aVar);
            }
            int d2 = b.d(36, this.J) + b.d(35, this.I) + e3;
            l lVar = this.K;
            if (lVar != null) {
                d2 += b.b(37, lVar);
            }
            k kVar = this.L;
            if (kVar != null) {
                d2 += b.b(38, kVar);
            }
            k kVar2 = this.M;
            if (kVar2 != null) {
                d2 += b.b(39, kVar2);
            }
            return b.b(40, this.N) + d2;
        }

        public a d() {
            this.b = "";
            this.c = 0;
            String[] strArr = g.f;
            this.d = strArr;
            this.e = "";
            this.f = "";
            this.g = strArr;
            this.h = strArr;
            this.i = strArr;
            this.j = null;
            this.k = d.d();
            this.l = null;
            this.m = null;
            this.n = g.d();
            this.o = "";
            this.p = "";
            this.q = false;
            this.r = "";
            this.s = "";
            this.t = strArr;
            this.u = null;
            this.v = false;
            this.w = e.d();
            this.x = null;
            this.y = "";
            this.z = "";
            this.A = "";
            this.B = "";
            this.C = 0;
            this.D = 0;
            this.E = false;
            this.F = null;
            this.G = null;
            this.H = null;
            this.I = 600;
            this.J = 1;
            this.K = null;
            this.L = null;
            this.M = null;
            this.N = BuildConfig.ADJUST_DEFAULT_TRACKER;
            this.a = -1;
            return this;
        }

        @Override // com.yandex.metrica.impl.ob.e
        public void a(b bVar) throws IOException {
            if (!this.b.equals("")) {
                bVar.a(1, this.b);
            }
            bVar.b(3, this.c);
            String[] strArr = this.d;
            int i2 = 0;
            if (strArr != null && strArr.length > 0) {
                int i3 = 0;
                while (true) {
                    String[] strArr2 = this.d;
                    if (i3 >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i3];
                    if (str != null) {
                        bVar.a(4, str);
                    }
                    i3++;
                }
            }
            if (!this.e.equals("")) {
                bVar.a(5, this.e);
            }
            if (!this.f.equals("")) {
                bVar.a(6, this.f);
            }
            String[] strArr3 = this.g;
            if (strArr3 != null && strArr3.length > 0) {
                int i4 = 0;
                while (true) {
                    String[] strArr4 = this.g;
                    if (i4 >= strArr4.length) {
                        break;
                    }
                    String str2 = strArr4[i4];
                    if (str2 != null) {
                        bVar.a(7, str2);
                    }
                    i4++;
                }
            }
            String[] strArr5 = this.h;
            if (strArr5 != null && strArr5.length > 0) {
                int i5 = 0;
                while (true) {
                    String[] strArr6 = this.h;
                    if (i5 >= strArr6.length) {
                        break;
                    }
                    String str3 = strArr6[i5];
                    if (str3 != null) {
                        bVar.a(8, str3);
                    }
                    i5++;
                }
            }
            String[] strArr7 = this.i;
            if (strArr7 != null && strArr7.length > 0) {
                int i6 = 0;
                while (true) {
                    String[] strArr8 = this.i;
                    if (i6 >= strArr8.length) {
                        break;
                    }
                    String str4 = strArr8[i6];
                    if (str4 != null) {
                        bVar.a(9, str4);
                    }
                    i6++;
                }
            }
            b bVar2 = this.j;
            if (bVar2 != null) {
                bVar.a(10, bVar2);
            }
            d[] dVarArr = this.k;
            if (dVarArr != null && dVarArr.length > 0) {
                int i7 = 0;
                while (true) {
                    d[] dVarArr2 = this.k;
                    if (i7 >= dVarArr2.length) {
                        break;
                    }
                    d dVar = dVarArr2[i7];
                    if (dVar != null) {
                        bVar.a(11, dVar);
                    }
                    i7++;
                }
            }
            m mVar = this.l;
            if (mVar != null) {
                bVar.a(12, mVar);
            }
            i iVar = this.m;
            if (iVar != null) {
                bVar.a(13, iVar);
            }
            g[] gVarArr = this.n;
            if (gVarArr != null && gVarArr.length > 0) {
                int i8 = 0;
                while (true) {
                    g[] gVarArr2 = this.n;
                    if (i8 >= gVarArr2.length) {
                        break;
                    }
                    g gVar = gVarArr2[i8];
                    if (gVar != null) {
                        bVar.a(14, gVar);
                    }
                    i8++;
                }
            }
            if (!this.o.equals("")) {
                bVar.a(15, this.o);
            }
            if (!this.p.equals("")) {
                bVar.a(16, this.p);
            }
            bVar.a(17, this.q);
            if (!this.r.equals("")) {
                bVar.a(18, this.r);
            }
            if (!this.s.equals("")) {
                bVar.a(19, this.s);
            }
            String[] strArr9 = this.t;
            if (strArr9 != null && strArr9.length > 0) {
                int i9 = 0;
                while (true) {
                    String[] strArr10 = this.t;
                    if (i9 >= strArr10.length) {
                        break;
                    }
                    String str5 = strArr10[i9];
                    if (str5 != null) {
                        bVar.a(20, str5);
                    }
                    i9++;
                }
            }
            j jVar = this.u;
            if (jVar != null) {
                bVar.a(21, jVar);
            }
            boolean z2 = this.v;
            if (z2) {
                bVar.a(22, z2);
            }
            e[] eVarArr = this.w;
            if (eVarArr != null && eVarArr.length > 0) {
                while (true) {
                    e[] eVarArr2 = this.w;
                    if (i2 >= eVarArr2.length) {
                        break;
                    }
                    e eVar = eVarArr2[i2];
                    if (eVar != null) {
                        bVar.a(23, eVar);
                    }
                    i2++;
                }
            }
            h hVar = this.x;
            if (hVar != null) {
                bVar.a(24, hVar);
            }
            if (!this.y.equals("")) {
                bVar.a(25, this.y);
            }
            if (!this.z.equals("")) {
                bVar.a(26, this.z);
            }
            if (!this.B.equals("")) {
                bVar.a(27, this.B);
            }
            bVar.b(28, this.C);
            bVar.b(29, this.D);
            boolean z3 = this.E;
            if (z3) {
                bVar.a(30, z3);
            }
            if (!this.A.equals("")) {
                bVar.a(31, this.A);
            }
            f fVar = this.F;
            if (fVar != null) {
                bVar.a(32, fVar);
            }
            c cVar = this.G;
            if (cVar != null) {
                bVar.a(33, cVar);
            }
            C0352a aVar = this.H;
            if (aVar != null) {
                bVar.a(34, aVar);
            }
            bVar.a(35, this.I);
            bVar.a(36, this.J);
            l lVar = this.K;
            if (lVar != null) {
                bVar.a(37, lVar);
            }
            k kVar = this.L;
            if (kVar != null) {
                bVar.a(38, kVar);
            }
            k kVar2 = this.M;
            if (kVar2 != null) {
                bVar.a(39, kVar2);
            }
            bVar.a(40, this.N);
            super.a(bVar);
        }

        public static a a(byte[] bArr) throws d {
            return (a) e.a(new a(), bArr);
        }
    }
}
