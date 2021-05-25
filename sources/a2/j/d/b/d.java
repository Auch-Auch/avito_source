package a2.j.d.b;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Supplier;
import java.util.concurrent.atomic.AtomicLong;
@GwtCompatible(emulated = true)
public final class d {
    public static final Supplier<c> a;

    public static class a implements Supplier<c> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.google.common.base.Supplier
        public c get() {
            return new e();
        }
    }

    public static class b implements Supplier<c> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.google.common.base.Supplier
        public c get() {
            return new c(null);
        }
    }

    public static final class c extends AtomicLong implements c {
        public c(a aVar) {
        }

        @Override // a2.j.d.b.c
        public long a() {
            return get();
        }

        @Override // a2.j.d.b.c
        public void add(long j) {
            getAndAdd(j);
        }

        @Override // a2.j.d.b.c
        public void b() {
            getAndIncrement();
        }
    }

    static {
        Supplier<c> supplier;
        try {
            new e();
            supplier = new a();
        } catch (Throwable unused) {
            supplier = new b();
        }
        a = supplier;
    }

    public static c a() {
        return a.get();
    }
}
