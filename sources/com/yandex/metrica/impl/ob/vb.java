package com.yandex.metrica.impl.ob;

import java.io.IOException;
public interface vb {

    public static final class a extends e {
        public C0348a[] b;

        /* renamed from: com.yandex.metrica.impl.ob.vb$a$a  reason: collision with other inner class name */
        public static final class C0348a extends e {
            private static volatile C0348a[] d;
            public String b;
            public boolean c;

            public C0348a() {
                e();
            }

            public static C0348a[] d() {
                if (d == null) {
                    synchronized (c.a) {
                        if (d == null) {
                            d = new C0348a[0];
                        }
                    }
                }
                return d;
            }

            /* renamed from: b */
            public C0348a a(a aVar) throws IOException {
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

            public C0348a e() {
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
                    C0348a[] aVarArr = this.b;
                    int length = aVarArr == null ? 0 : aVarArr.length;
                    int i = b2 + length;
                    C0348a[] aVarArr2 = new C0348a[i];
                    if (length != 0) {
                        System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                    }
                    while (length < i - 1) {
                        aVarArr2[length] = new C0348a();
                        aVar.a(aVarArr2[length]);
                        aVar.a();
                        length++;
                    }
                    aVarArr2[length] = new C0348a();
                    aVar.a(aVarArr2[length]);
                    this.b = aVarArr2;
                } else if (!g.a(aVar, a)) {
                    return this;
                }
            }
        }

        @Override // com.yandex.metrica.impl.ob.e
        public int c() {
            int c = super.c();
            C0348a[] aVarArr = this.b;
            if (aVarArr != null && aVarArr.length > 0) {
                int i = 0;
                while (true) {
                    C0348a[] aVarArr2 = this.b;
                    if (i >= aVarArr2.length) {
                        break;
                    }
                    C0348a aVar = aVarArr2[i];
                    if (aVar != null) {
                        c += b.b(1, aVar);
                    }
                    i++;
                }
            }
            return c;
        }

        public a d() {
            this.b = C0348a.d();
            this.a = -1;
            return this;
        }

        @Override // com.yandex.metrica.impl.ob.e
        public void a(b bVar) throws IOException {
            C0348a[] aVarArr = this.b;
            if (aVarArr != null && aVarArr.length > 0) {
                int i = 0;
                while (true) {
                    C0348a[] aVarArr2 = this.b;
                    if (i >= aVarArr2.length) {
                        break;
                    }
                    C0348a aVar = aVarArr2[i];
                    if (aVar != null) {
                        bVar.a(1, aVar);
                    }
                    i++;
                }
            }
            super.a(bVar);
        }

        public static a a(byte[] bArr) throws d {
            return (a) e.a(new a(), bArr);
        }
    }
}
