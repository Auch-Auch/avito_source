package com.yandex.metrica.impl.ob;

import java.io.IOException;
public final class uw extends e {
    public String b;
    public long c;
    public long d;

    public uw() {
        d();
    }

    /* renamed from: b */
    public uw a(a aVar) throws IOException {
        while (true) {
            int a = aVar.a();
            if (a == 0) {
                return this;
            }
            if (a == 10) {
                this.b = aVar.i();
            } else if (a == 16) {
                this.c = aVar.e();
            } else if (a == 24) {
                this.d = aVar.e();
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
        long j = this.c;
        if (j != 0) {
            c2 += b.d(2, j);
        }
        long j2 = this.d;
        return j2 != 0 ? c2 + b.d(3, j2) : c2;
    }

    public uw d() {
        this.b = "";
        this.c = 0;
        this.d = 0;
        this.a = -1;
        return this;
    }

    @Override // com.yandex.metrica.impl.ob.e
    public void a(b bVar) throws IOException {
        if (!this.b.equals("")) {
            bVar.a(1, this.b);
        }
        long j = this.c;
        if (j != 0) {
            bVar.a(2, j);
        }
        long j2 = this.d;
        if (j2 != 0) {
            bVar.a(3, j2);
        }
        super.a(bVar);
    }

    public static uw a(byte[] bArr) throws d {
        return (uw) e.a(new uw(), bArr);
    }
}
