package com.yandex.metrica.impl.ob;

import java.io.IOException;
public interface vd {

    public static final class a extends e {
        public C0351a[] b;
        public String c;
        public long d;
        public boolean e;
        public boolean f;

        /* renamed from: com.yandex.metrica.impl.ob.vd$a$a  reason: collision with other inner class name */
        public static final class C0351a extends e {
            private static volatile C0351a[] d;
            public String b;
            public String[] c;

            public C0351a() {
                e();
            }

            public static C0351a[] d() {
                if (d == null) {
                    synchronized (c.a) {
                        if (d == null) {
                            d = new C0351a[0];
                        }
                    }
                }
                return d;
            }

            /* renamed from: b */
            public C0351a a(a aVar) throws IOException {
                while (true) {
                    int a = aVar.a();
                    if (a == 0) {
                        return this;
                    }
                    if (a == 10) {
                        this.b = aVar.i();
                    } else if (a == 18) {
                        int b2 = g.b(aVar, 18);
                        String[] strArr = this.c;
                        int length = strArr == null ? 0 : strArr.length;
                        int i = b2 + length;
                        String[] strArr2 = new String[i];
                        if (length != 0) {
                            System.arraycopy(strArr, 0, strArr2, 0, length);
                        }
                        while (length < i - 1) {
                            strArr2[length] = aVar.i();
                            aVar.a();
                            length++;
                        }
                        strArr2[length] = aVar.i();
                        this.c = strArr2;
                    } else if (!g.a(aVar, a)) {
                        return this;
                    }
                }
            }

            @Override // com.yandex.metrica.impl.ob.e
            public int c() {
                int b2 = b.b(1, this.b) + super.c();
                String[] strArr = this.c;
                if (strArr == null || strArr.length <= 0) {
                    return b2;
                }
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    String[] strArr2 = this.c;
                    if (i >= strArr2.length) {
                        return b2 + i2 + (i3 * 1);
                    }
                    String str = strArr2[i];
                    if (str != null) {
                        i3++;
                        i2 = b.b(str) + i2;
                    }
                    i++;
                }
            }

            public C0351a e() {
                this.b = "";
                this.c = g.f;
                this.a = -1;
                return this;
            }

            @Override // com.yandex.metrica.impl.ob.e
            public void a(b bVar) throws IOException {
                bVar.a(1, this.b);
                String[] strArr = this.c;
                if (strArr != null && strArr.length > 0) {
                    int i = 0;
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
                    C0351a[] aVarArr = this.b;
                    int length = aVarArr == null ? 0 : aVarArr.length;
                    int i = b2 + length;
                    C0351a[] aVarArr2 = new C0351a[i];
                    if (length != 0) {
                        System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                    }
                    while (length < i - 1) {
                        aVarArr2[length] = new C0351a();
                        aVar.a(aVarArr2[length]);
                        aVar.a();
                        length++;
                    }
                    aVarArr2[length] = new C0351a();
                    aVar.a(aVarArr2[length]);
                    this.b = aVarArr2;
                } else if (a == 18) {
                    this.c = aVar.i();
                } else if (a == 24) {
                    this.d = aVar.f();
                } else if (a == 32) {
                    this.e = aVar.h();
                } else if (a == 40) {
                    this.f = aVar.h();
                } else if (!g.a(aVar, a)) {
                    return this;
                }
            }
        }

        @Override // com.yandex.metrica.impl.ob.e
        public int c() {
            int c2 = super.c();
            C0351a[] aVarArr = this.b;
            if (aVarArr != null && aVarArr.length > 0) {
                int i = 0;
                while (true) {
                    C0351a[] aVarArr2 = this.b;
                    if (i >= aVarArr2.length) {
                        break;
                    }
                    C0351a aVar = aVarArr2[i];
                    if (aVar != null) {
                        c2 += b.b(1, aVar);
                    }
                    i++;
                }
            }
            return b.b(5, this.f) + b.b(4, this.e) + b.e(3, this.d) + b.b(2, this.c) + c2;
        }

        public a d() {
            this.b = C0351a.d();
            this.c = "";
            this.d = 0;
            this.e = false;
            this.f = false;
            this.a = -1;
            return this;
        }

        @Override // com.yandex.metrica.impl.ob.e
        public void a(b bVar) throws IOException {
            C0351a[] aVarArr = this.b;
            if (aVarArr != null && aVarArr.length > 0) {
                int i = 0;
                while (true) {
                    C0351a[] aVarArr2 = this.b;
                    if (i >= aVarArr2.length) {
                        break;
                    }
                    C0351a aVar = aVarArr2[i];
                    if (aVar != null) {
                        bVar.a(1, aVar);
                    }
                    i++;
                }
            }
            bVar.a(2, this.c);
            bVar.b(3, this.d);
            bVar.a(4, this.e);
            bVar.a(5, this.f);
            super.a(bVar);
        }

        public static a a(byte[] bArr) throws d {
            return (a) e.a(new a(), bArr);
        }
    }
}
