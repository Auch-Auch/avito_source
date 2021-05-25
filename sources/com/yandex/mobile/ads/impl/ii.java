package com.yandex.mobile.ads.impl;

import java.util.List;
public class ii {

    public static class a {
        private final List<C0366a> a;
        private boolean b;

        /* renamed from: com.yandex.mobile.ads.impl.ii$a$a  reason: collision with other inner class name */
        public static class C0366a {
            public final String a;
            public final long b;
            public final long c;
        }

        public final void finalize() throws Throwable {
            if (!this.b) {
                this.b = true;
                if ((this.a.size() == 0 ? 0 : ((C0366a) a2.b.a.a.a.j2(this.a, 1)).c - this.a.get(0).c) > 0) {
                    long j = this.a.get(0).c;
                    for (C0366a aVar : this.a) {
                        long j2 = aVar.c;
                    }
                }
            }
            super.finalize();
        }
    }
}
