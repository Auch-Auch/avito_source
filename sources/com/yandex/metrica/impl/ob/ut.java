package com.yandex.metrica.impl.ob;

import java.io.IOException;
import java.util.Arrays;
public interface ut {

    public static final class a extends e {
        public byte[] b;

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
                } else if (!g.a(aVar, a)) {
                    return this;
                }
            }
        }

        @Override // com.yandex.metrica.impl.ob.e
        public int c() {
            int c = super.c();
            return !Arrays.equals(this.b, g.h) ? c + b.b(1, this.b) : c;
        }

        public a d() {
            this.b = g.h;
            this.a = -1;
            return this;
        }

        @Override // com.yandex.metrica.impl.ob.e
        public void a(b bVar) throws IOException {
            if (!Arrays.equals(this.b, g.h)) {
                bVar.a(1, this.b);
            }
            super.a(bVar);
        }
    }
}
