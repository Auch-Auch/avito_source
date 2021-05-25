package com.yandex.metrica.impl.ob;

import java.io.IOException;
public interface vc {

    public static final class a extends e {
        public C0349a[] b;
        public String[] c;

        /* renamed from: com.yandex.metrica.impl.ob.vc$a$a  reason: collision with other inner class name */
        public static final class C0349a extends e {
            private static volatile C0349a[] h;
            public String b;
            public String c;
            public String d;
            public C0350a[] e;
            public long f;
            public int[] g;

            /* renamed from: com.yandex.metrica.impl.ob.vc$a$a$a  reason: collision with other inner class name */
            public static final class C0350a extends e {
                private static volatile C0350a[] d;
                public String b;
                public String c;

                public C0350a() {
                    e();
                }

                public static C0350a[] d() {
                    if (d == null) {
                        synchronized (c.a) {
                            if (d == null) {
                                d = new C0350a[0];
                            }
                        }
                    }
                    return d;
                }

                /* renamed from: b */
                public C0350a a(a aVar) throws IOException {
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

                public C0350a e() {
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

            public C0349a() {
                e();
            }

            public static C0349a[] d() {
                if (h == null) {
                    synchronized (c.a) {
                        if (h == null) {
                            h = new C0349a[0];
                        }
                    }
                }
                return h;
            }

            /* renamed from: b */
            public C0349a a(a aVar) throws IOException {
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
                        C0350a[] aVarArr = this.e;
                        int length = aVarArr == null ? 0 : aVarArr.length;
                        int i = b2 + length;
                        C0350a[] aVarArr2 = new C0350a[i];
                        if (length != 0) {
                            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                        }
                        while (length < i - 1) {
                            aVarArr2[length] = new C0350a();
                            aVar.a(aVarArr2[length]);
                            aVar.a();
                            length++;
                        }
                        aVarArr2[length] = new C0350a();
                        aVar.a(aVarArr2[length]);
                        this.e = aVarArr2;
                    } else if (a == 40) {
                        this.f = aVar.e();
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
                C0350a[] aVarArr = this.e;
                int i = 0;
                if (aVarArr != null && aVarArr.length > 0) {
                    int i2 = 0;
                    while (true) {
                        C0350a[] aVarArr2 = this.e;
                        if (i2 >= aVarArr2.length) {
                            break;
                        }
                        C0350a aVar = aVarArr2[i2];
                        if (aVar != null) {
                            b2 += b.b(4, aVar);
                        }
                        i2++;
                    }
                }
                int d2 = b.d(5, this.f) + b2;
                int[] iArr = this.g;
                if (iArr == null || iArr.length <= 0) {
                    return d2;
                }
                int i3 = 0;
                while (true) {
                    int[] iArr2 = this.g;
                    if (i >= iArr2.length) {
                        return d2 + i3 + (iArr2.length * 1);
                    }
                    i3 += b.d(iArr2[i]);
                    i++;
                }
            }

            public C0349a e() {
                this.b = "";
                this.c = "";
                this.d = "";
                this.e = C0350a.d();
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
                C0350a[] aVarArr = this.e;
                int i = 0;
                if (aVarArr != null && aVarArr.length > 0) {
                    int i2 = 0;
                    while (true) {
                        C0350a[] aVarArr2 = this.e;
                        if (i2 >= aVarArr2.length) {
                            break;
                        }
                        C0350a aVar = aVarArr2[i2];
                        if (aVar != null) {
                            bVar.a(4, aVar);
                        }
                        i2++;
                    }
                }
                bVar.a(5, this.f);
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
                    C0349a[] aVarArr = this.b;
                    int length = aVarArr == null ? 0 : aVarArr.length;
                    int i = b2 + length;
                    C0349a[] aVarArr2 = new C0349a[i];
                    if (length != 0) {
                        System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                    }
                    while (length < i - 1) {
                        aVarArr2[length] = new C0349a();
                        aVar.a(aVarArr2[length]);
                        aVar.a();
                        length++;
                    }
                    aVarArr2[length] = new C0349a();
                    aVar.a(aVarArr2[length]);
                    this.b = aVarArr2;
                } else if (a == 18) {
                    int b3 = g.b(aVar, 18);
                    String[] strArr = this.c;
                    int length2 = strArr == null ? 0 : strArr.length;
                    int i2 = b3 + length2;
                    String[] strArr2 = new String[i2];
                    if (length2 != 0) {
                        System.arraycopy(strArr, 0, strArr2, 0, length2);
                    }
                    while (length2 < i2 - 1) {
                        strArr2[length2] = aVar.i();
                        aVar.a();
                        length2++;
                    }
                    strArr2[length2] = aVar.i();
                    this.c = strArr2;
                } else if (!g.a(aVar, a)) {
                    return this;
                }
            }
        }

        @Override // com.yandex.metrica.impl.ob.e
        public int c() {
            int c2 = super.c();
            C0349a[] aVarArr = this.b;
            int i = 0;
            if (aVarArr != null && aVarArr.length > 0) {
                int i2 = 0;
                while (true) {
                    C0349a[] aVarArr2 = this.b;
                    if (i2 >= aVarArr2.length) {
                        break;
                    }
                    C0349a aVar = aVarArr2[i2];
                    if (aVar != null) {
                        c2 += b.b(1, aVar);
                    }
                    i2++;
                }
            }
            String[] strArr = this.c;
            if (strArr == null || strArr.length <= 0) {
                return c2;
            }
            int i3 = 0;
            int i4 = 0;
            while (true) {
                String[] strArr2 = this.c;
                if (i >= strArr2.length) {
                    return c2 + i3 + (i4 * 1);
                }
                String str = strArr2[i];
                if (str != null) {
                    i4++;
                    i3 = b.b(str) + i3;
                }
                i++;
            }
        }

        public a d() {
            this.b = C0349a.d();
            this.c = g.f;
            this.a = -1;
            return this;
        }

        @Override // com.yandex.metrica.impl.ob.e
        public void a(b bVar) throws IOException {
            C0349a[] aVarArr = this.b;
            int i = 0;
            if (aVarArr != null && aVarArr.length > 0) {
                int i2 = 0;
                while (true) {
                    C0349a[] aVarArr2 = this.b;
                    if (i2 >= aVarArr2.length) {
                        break;
                    }
                    C0349a aVar = aVarArr2[i2];
                    if (aVar != null) {
                        bVar.a(1, aVar);
                    }
                    i2++;
                }
            }
            String[] strArr = this.c;
            if (strArr != null && strArr.length > 0) {
                while (true) {
                    String[] strArr2 = this.c;
                    if (i >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i];
                    if (str != null) {
                        bVar.a(2, str);
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
