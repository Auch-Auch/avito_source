package com.yandex.metrica.impl.ob;

import java.io.IOException;
public interface va {

    public static final class a extends e {
        public boolean b;
        public int c;
        public int d;
        public int[] e;

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
                if (a == 8) {
                    this.b = aVar.h();
                } else if (a == 16) {
                    this.c = aVar.k();
                } else if (a == 24) {
                    this.d = aVar.k();
                } else if (a == 32) {
                    int b2 = g.b(aVar, 32);
                    int[] iArr = this.e;
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
                    this.e = iArr2;
                } else if (a == 34) {
                    int d2 = aVar.d(aVar.n());
                    int t = aVar.t();
                    int i2 = 0;
                    while (aVar.r() > 0) {
                        aVar.g();
                        i2++;
                    }
                    aVar.f(t);
                    int[] iArr3 = this.e;
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
                    this.e = iArr4;
                    aVar.e(d2);
                } else if (!g.a(aVar, a)) {
                    return this;
                }
            }
        }

        @Override // com.yandex.metrica.impl.ob.e
        public int c() {
            int e2 = b.e(3, this.d) + b.e(2, this.c) + b.b(1, this.b) + super.c();
            int[] iArr = this.e;
            if (iArr == null || iArr.length <= 0) {
                return e2;
            }
            int i = 0;
            int i2 = 0;
            while (true) {
                int[] iArr2 = this.e;
                if (i >= iArr2.length) {
                    return e2 + i2 + (iArr2.length * 1);
                }
                i2 += b.d(iArr2[i]);
                i++;
            }
        }

        public a d() {
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = g.a;
            this.a = -1;
            return this;
        }

        @Override // com.yandex.metrica.impl.ob.e
        public void a(b bVar) throws IOException {
            bVar.a(1, this.b);
            bVar.b(2, this.c);
            bVar.b(3, this.d);
            int[] iArr = this.e;
            if (iArr != null && iArr.length > 0) {
                int i = 0;
                while (true) {
                    int[] iArr2 = this.e;
                    if (i >= iArr2.length) {
                        break;
                    }
                    bVar.a(4, iArr2[i]);
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
