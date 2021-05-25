package com.yandex.metrica.impl.ob;

import java.io.IOException;
public interface uz {

    public static final class a extends e {
        public b[] b;
        public C0347a c;
        public String[] d;

        /* renamed from: com.yandex.metrica.impl.ob.uz$a$a  reason: collision with other inner class name */
        public static final class C0347a extends e {
            public int b;
            public int c;

            public C0347a() {
                d();
            }

            /* renamed from: b */
            public C0347a a(a aVar) throws IOException {
                while (true) {
                    int a = aVar.a();
                    if (a == 0) {
                        return this;
                    }
                    if (a == 16) {
                        int g = aVar.g();
                        if (g == 0 || g == 1 || g == 2 || g == 3 || g == 4) {
                            this.b = g;
                        }
                    } else if (a == 24) {
                        int g2 = aVar.g();
                        if (g2 == -1 || g2 == 0 || g2 == 1) {
                            this.c = g2;
                        }
                    } else if (!g.a(aVar, a)) {
                        return this;
                    }
                }
            }

            @Override // com.yandex.metrica.impl.ob.e
            public int c() {
                return b.d(3, this.c) + b.d(2, this.b) + super.c();
            }

            public C0347a d() {
                this.b = 0;
                this.c = -1;
                this.a = -1;
                return this;
            }

            @Override // com.yandex.metrica.impl.ob.e
            public void a(b bVar) throws IOException {
                bVar.a(2, this.b);
                bVar.a(3, this.c);
                super.a(bVar);
            }
        }

        public static final class b extends e {
            private static volatile b[] d;
            public String b;
            public boolean c;

            public b() {
                e();
            }

            public static b[] d() {
                if (d == null) {
                    synchronized (c.a) {
                        if (d == null) {
                            d = new b[0];
                        }
                    }
                }
                return d;
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

            public b e() {
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
                    b[] bVarArr = this.b;
                    int length = bVarArr == null ? 0 : bVarArr.length;
                    int i = b2 + length;
                    b[] bVarArr2 = new b[i];
                    if (length != 0) {
                        System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                    }
                    while (length < i - 1) {
                        bVarArr2[length] = new b();
                        aVar.a(bVarArr2[length]);
                        aVar.a();
                        length++;
                    }
                    bVarArr2[length] = new b();
                    aVar.a(bVarArr2[length]);
                    this.b = bVarArr2;
                } else if (a == 18) {
                    if (this.c == null) {
                        this.c = new C0347a();
                    }
                    aVar.a(this.c);
                } else if (a == 26) {
                    int b3 = g.b(aVar, 26);
                    String[] strArr = this.d;
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
                    this.d = strArr2;
                } else if (!g.a(aVar, a)) {
                    return this;
                }
            }
        }

        @Override // com.yandex.metrica.impl.ob.e
        public int c() {
            int c2 = super.c();
            b[] bVarArr = this.b;
            int i = 0;
            if (bVarArr != null && bVarArr.length > 0) {
                int i2 = 0;
                while (true) {
                    b[] bVarArr2 = this.b;
                    if (i2 >= bVarArr2.length) {
                        break;
                    }
                    b bVar = bVarArr2[i2];
                    if (bVar != null) {
                        c2 += b.b(1, bVar);
                    }
                    i2++;
                }
            }
            C0347a aVar = this.c;
            if (aVar != null) {
                c2 += b.b(2, aVar);
            }
            String[] strArr = this.d;
            if (strArr == null || strArr.length <= 0) {
                return c2;
            }
            int i3 = 0;
            int i4 = 0;
            while (true) {
                String[] strArr2 = this.d;
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
            this.b = b.d();
            this.c = null;
            this.d = g.f;
            this.a = -1;
            return this;
        }

        @Override // com.yandex.metrica.impl.ob.e
        public void a(b bVar) throws IOException {
            b[] bVarArr = this.b;
            int i = 0;
            if (bVarArr != null && bVarArr.length > 0) {
                int i2 = 0;
                while (true) {
                    b[] bVarArr2 = this.b;
                    if (i2 >= bVarArr2.length) {
                        break;
                    }
                    b bVar2 = bVarArr2[i2];
                    if (bVar2 != null) {
                        bVar.a(1, bVar2);
                    }
                    i2++;
                }
            }
            C0347a aVar = this.c;
            if (aVar != null) {
                bVar.a(2, aVar);
            }
            String[] strArr = this.d;
            if (strArr != null && strArr.length > 0) {
                while (true) {
                    String[] strArr2 = this.d;
                    if (i >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i];
                    if (str != null) {
                        bVar.a(3, str);
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
