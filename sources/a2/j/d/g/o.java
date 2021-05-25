package a2.j.d.g;

import com.google.common.base.Supplier;
import java.util.concurrent.atomic.AtomicLong;
public final class o {
    public static final Supplier<n> a;

    public static class a implements Supplier<n> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.google.common.base.Supplier
        public n get() {
            return new p();
        }
    }

    public static class b implements Supplier<n> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.google.common.base.Supplier
        public n get() {
            return new c(null);
        }
    }

    public static final class c extends AtomicLong implements n {
        public c(a aVar) {
        }

        @Override // a2.j.d.g.n
        public long a() {
            return get();
        }

        @Override // a2.j.d.g.n
        public void add(long j) {
            getAndAdd(j);
        }

        @Override // a2.j.d.g.n
        public void b() {
            getAndIncrement();
        }
    }

    static {
        Supplier<n> supplier;
        try {
            new p();
            supplier = new a();
        } catch (Throwable unused) {
            supplier = new b();
        }
        a = supplier;
    }
}
