package com.yandex.metrica.impl.ob;

import java.io.IOException;
import java.util.Arrays;
public final class ux extends e {
    public int b;
    public double c;
    public byte[] d;
    public byte[] e;
    public byte[] f;
    public a g;
    public long h;

    public static final class a extends e {
        public byte[] b;
        public byte[] c;

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
                    this.b = aVar.j();
                } else if (a == 18) {
                    this.c = aVar.j();
                } else if (!g.a(aVar, a)) {
                    return this;
                }
            }
        }

        @Override // com.yandex.metrica.impl.ob.e
        public int c() {
            int c2 = super.c();
            byte[] bArr = this.b;
            byte[] bArr2 = g.h;
            if (!Arrays.equals(bArr, bArr2)) {
                c2 += b.b(1, this.b);
            }
            return !Arrays.equals(this.c, bArr2) ? c2 + b.b(2, this.c) : c2;
        }

        public a d() {
            byte[] bArr = g.h;
            this.b = bArr;
            this.c = bArr;
            this.a = -1;
            return this;
        }

        @Override // com.yandex.metrica.impl.ob.e
        public void a(b bVar) throws IOException {
            byte[] bArr = this.b;
            byte[] bArr2 = g.h;
            if (!Arrays.equals(bArr, bArr2)) {
                bVar.a(1, this.b);
            }
            if (!Arrays.equals(this.c, bArr2)) {
                bVar.a(2, this.c);
            }
            super.a(bVar);
        }
    }

    public ux() {
        d();
    }

    /* renamed from: b */
    public ux a(a aVar) throws IOException {
        while (true) {
            int a3 = aVar.a();
            if (a3 == 0) {
                return this;
            }
            if (a3 == 8) {
                this.b = aVar.k();
            } else if (a3 == 17) {
                this.c = aVar.c();
            } else if (a3 == 26) {
                this.d = aVar.j();
            } else if (a3 == 34) {
                this.e = aVar.j();
            } else if (a3 == 42) {
                this.f = aVar.j();
            } else if (a3 == 50) {
                if (this.g == null) {
                    this.g = new a();
                }
                aVar.a(this.g);
            } else if (a3 == 56) {
                this.h = aVar.f();
            } else if (!g.a(aVar, a3)) {
                return this;
            }
        }
    }

    @Override // com.yandex.metrica.impl.ob.e
    public int c() {
        int c2 = super.c();
        int i = this.b;
        if (i != 1) {
            c2 += b.e(1, i);
        }
        if (Double.doubleToLongBits(this.c) != Double.doubleToLongBits(0.0d)) {
            c2 += b.b(2, this.c);
        }
        int b2 = b.b(3, this.d) + c2;
        byte[] bArr = this.e;
        byte[] bArr2 = g.h;
        if (!Arrays.equals(bArr, bArr2)) {
            b2 += b.b(4, this.e);
        }
        if (!Arrays.equals(this.f, bArr2)) {
            b2 += b.b(5, this.f);
        }
        a aVar = this.g;
        if (aVar != null) {
            b2 += b.b(6, aVar);
        }
        long j = this.h;
        return j != 0 ? b2 + b.e(7, j) : b2;
    }

    public ux d() {
        this.b = 1;
        this.c = 0.0d;
        byte[] bArr = g.h;
        this.d = bArr;
        this.e = bArr;
        this.f = bArr;
        this.g = null;
        this.h = 0;
        this.a = -1;
        return this;
    }

    @Override // com.yandex.metrica.impl.ob.e
    public void a(b bVar) throws IOException {
        int i = this.b;
        if (i != 1) {
            bVar.b(1, i);
        }
        if (Double.doubleToLongBits(this.c) != Double.doubleToLongBits(0.0d)) {
            bVar.a(2, this.c);
        }
        bVar.a(3, this.d);
        byte[] bArr = this.e;
        byte[] bArr2 = g.h;
        if (!Arrays.equals(bArr, bArr2)) {
            bVar.a(4, this.e);
        }
        if (!Arrays.equals(this.f, bArr2)) {
            bVar.a(5, this.f);
        }
        a aVar = this.g;
        if (aVar != null) {
            bVar.a(6, aVar);
        }
        long j = this.h;
        if (j != 0) {
            bVar.b(7, j);
        }
        super.a(bVar);
    }
}
