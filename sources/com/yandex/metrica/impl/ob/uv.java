package com.yandex.metrica.impl.ob;

import java.io.IOException;
public final class uv extends e {
    public byte[] b;
    public long c;
    public long d;

    public uv() {
        d();
    }

    /* renamed from: b */
    public uv a(a aVar) throws IOException {
        while (true) {
            int a = aVar.a();
            if (a == 0) {
                return this;
            }
            if (a == 10) {
                this.b = aVar.j();
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
        int b2 = b.b(1, this.b) + super.c();
        long j = this.c;
        if (j != 0) {
            b2 += b.d(2, j);
        }
        long j2 = this.d;
        return j2 != 0 ? b2 + b.d(3, j2) : b2;
    }

    public uv d() {
        this.b = g.h;
        this.c = 0;
        this.d = 0;
        this.a = -1;
        return this;
    }

    @Override // com.yandex.metrica.impl.ob.e
    public void a(b bVar) throws IOException {
        bVar.a(1, this.b);
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
}
