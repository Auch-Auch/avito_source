package com.yandex.metrica.impl.ob;

import java.io.IOException;
import java.util.Arrays;
public interface uy {

    public static final class a extends e {
        public C0346a[] b;

        /* renamed from: com.yandex.metrica.impl.ob.uy$a$a  reason: collision with other inner class name */
        public static final class C0346a extends e {
            private static volatile C0346a[] f;
            public byte[] b;
            public int c;
            public b d;
            public c e;

            public C0346a() {
                e();
            }

            public static C0346a[] d() {
                if (f == null) {
                    synchronized (c.a) {
                        if (f == null) {
                            f = new C0346a[0];
                        }
                    }
                }
                return f;
            }

            /* renamed from: b */
            public C0346a a(a aVar) throws IOException {
                while (true) {
                    int a = aVar.a();
                    if (a == 0) {
                        return this;
                    }
                    if (a == 10) {
                        this.b = aVar.j();
                    } else if (a == 16) {
                        int g = aVar.g();
                        if (g == 0 || g == 1 || g == 2 || g == 3) {
                            this.c = g;
                        }
                    } else if (a == 26) {
                        if (this.d == null) {
                            this.d = new b();
                        }
                        aVar.a(this.d);
                    } else if (a == 34) {
                        if (this.e == null) {
                            this.e = new c();
                        }
                        aVar.a(this.e);
                    } else if (!g.a(aVar, a)) {
                        return this;
                    }
                }
            }

            @Override // com.yandex.metrica.impl.ob.e
            public int c() {
                int d2 = b.d(2, this.c) + b.b(1, this.b) + super.c();
                b bVar = this.d;
                if (bVar != null) {
                    d2 += b.b(3, bVar);
                }
                c cVar = this.e;
                return cVar != null ? d2 + b.b(4, cVar) : d2;
            }

            public C0346a e() {
                this.b = g.h;
                this.c = 0;
                this.d = null;
                this.e = null;
                this.a = -1;
                return this;
            }

            @Override // com.yandex.metrica.impl.ob.e
            public void a(b bVar) throws IOException {
                bVar.a(1, this.b);
                bVar.a(2, this.c);
                b bVar2 = this.d;
                if (bVar2 != null) {
                    bVar.a(3, bVar2);
                }
                c cVar = this.e;
                if (cVar != null) {
                    bVar.a(4, cVar);
                }
                super.a(bVar);
            }
        }

        public static final class b extends e {
            public boolean b;
            public boolean c;

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
                    } else if (!g.a(aVar, a)) {
                        return this;
                    }
                }
            }

            @Override // com.yandex.metrica.impl.ob.e
            public int c() {
                int c2 = super.c();
                boolean z = this.b;
                if (z) {
                    c2 += b.b(1, z);
                }
                boolean z2 = this.c;
                return z2 ? c2 + b.b(2, z2) : c2;
            }

            public b d() {
                this.b = false;
                this.c = false;
                this.a = -1;
                return this;
            }

            @Override // com.yandex.metrica.impl.ob.e
            public void a(b bVar) throws IOException {
                boolean z = this.b;
                if (z) {
                    bVar.a(1, z);
                }
                boolean z2 = this.c;
                if (z2) {
                    bVar.a(2, z2);
                }
                super.a(bVar);
            }
        }

        public static final class c extends e {
            public byte[] b;
            public double c;
            public double d;
            public boolean e;

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
                        this.b = aVar.j();
                    } else if (a == 17) {
                        this.c = aVar.c();
                    } else if (a == 25) {
                        this.d = aVar.c();
                    } else if (a == 32) {
                        this.e = aVar.h();
                    } else if (!g.a(aVar, a)) {
                        return this;
                    }
                }
            }

            @Override // com.yandex.metrica.impl.ob.e
            public int c() {
                int c2 = super.c();
                if (!Arrays.equals(this.b, g.h)) {
                    c2 += b.b(1, this.b);
                }
                if (Double.doubleToLongBits(this.c) != Double.doubleToLongBits(0.0d)) {
                    c2 += b.b(2, this.c);
                }
                if (Double.doubleToLongBits(this.d) != Double.doubleToLongBits(0.0d)) {
                    c2 += b.b(3, this.d);
                }
                boolean z = this.e;
                return z ? c2 + b.b(4, z) : c2;
            }

            public c d() {
                this.b = g.h;
                this.c = 0.0d;
                this.d = 0.0d;
                this.e = false;
                this.a = -1;
                return this;
            }

            @Override // com.yandex.metrica.impl.ob.e
            public void a(b bVar) throws IOException {
                if (!Arrays.equals(this.b, g.h)) {
                    bVar.a(1, this.b);
                }
                if (Double.doubleToLongBits(this.c) != Double.doubleToLongBits(0.0d)) {
                    bVar.a(2, this.c);
                }
                if (Double.doubleToLongBits(this.d) != Double.doubleToLongBits(0.0d)) {
                    bVar.a(3, this.d);
                }
                boolean z = this.e;
                if (z) {
                    bVar.a(4, z);
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
                if (a == 0) {
                    return this;
                }
                if (a == 10) {
                    int b2 = g.b(aVar, 10);
                    C0346a[] aVarArr = this.b;
                    int length = aVarArr == null ? 0 : aVarArr.length;
                    int i = b2 + length;
                    C0346a[] aVarArr2 = new C0346a[i];
                    if (length != 0) {
                        System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                    }
                    while (length < i - 1) {
                        aVarArr2[length] = new C0346a();
                        aVar.a(aVarArr2[length]);
                        aVar.a();
                        length++;
                    }
                    aVarArr2[length] = new C0346a();
                    aVar.a(aVarArr2[length]);
                    this.b = aVarArr2;
                } else if (!g.a(aVar, a)) {
                    return this;
                }
            }
        }

        @Override // com.yandex.metrica.impl.ob.e
        public int c() {
            int c2 = super.c();
            C0346a[] aVarArr = this.b;
            if (aVarArr != null && aVarArr.length > 0) {
                int i = 0;
                while (true) {
                    C0346a[] aVarArr2 = this.b;
                    if (i >= aVarArr2.length) {
                        break;
                    }
                    C0346a aVar = aVarArr2[i];
                    if (aVar != null) {
                        c2 += b.b(1, aVar);
                    }
                    i++;
                }
            }
            return c2;
        }

        public a d() {
            this.b = C0346a.d();
            this.a = -1;
            return this;
        }

        @Override // com.yandex.metrica.impl.ob.e
        public void a(b bVar) throws IOException {
            C0346a[] aVarArr = this.b;
            if (aVarArr != null && aVarArr.length > 0) {
                int i = 0;
                while (true) {
                    C0346a[] aVarArr2 = this.b;
                    if (i >= aVarArr2.length) {
                        break;
                    }
                    C0346a aVar = aVarArr2[i];
                    if (aVar != null) {
                        bVar.a(1, aVar);
                    }
                    i++;
                }
            }
            super.a(bVar);
        }
    }
}
