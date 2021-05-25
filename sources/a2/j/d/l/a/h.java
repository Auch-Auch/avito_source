package a2.j.d.l.a;

import com.avito.android.remote.auth.AuthSource;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Sets;
import com.google.j2objc.annotations.ReflectionSupport;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
@ReflectionSupport(ReflectionSupport.Level.FULL)
@GwtCompatible(emulated = true)
public abstract class h {
    public static final b c;
    public static final Logger d = Logger.getLogger(h.class.getName());
    private volatile Set<Throwable> a = null;
    private volatile int b;

    public static abstract class b {
        public b(a aVar) {
        }

        public abstract void a(h hVar, Set<Throwable> set, Set<Throwable> set2);

        public abstract int b(h hVar);
    }

    public static final class c extends b {
        public final AtomicReferenceFieldUpdater<h, Set<Throwable>> a;
        public final AtomicIntegerFieldUpdater<h> b;

        public c(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super(null);
            this.a = atomicReferenceFieldUpdater;
            this.b = atomicIntegerFieldUpdater;
        }

        @Override // a2.j.d.l.a.h.b
        public void a(h hVar, Set<Throwable> set, Set<Throwable> set2) {
            this.a.compareAndSet(hVar, null, set2);
        }

        @Override // a2.j.d.l.a.h.b
        public int b(h hVar) {
            return this.b.decrementAndGet(hVar);
        }
    }

    public static final class d extends b {
        public d(a aVar) {
            super(null);
        }

        @Override // a2.j.d.l.a.h.b
        public void a(h hVar, Set<Throwable> set, Set<Throwable> set2) {
            synchronized (hVar) {
                if (hVar.a == null) {
                    hVar.a = set2;
                }
            }
        }

        @Override // a2.j.d.l.a.h.b
        public int b(h hVar) {
            int i;
            synchronized (hVar) {
                h.d(hVar);
                i = hVar.b;
            }
            return i;
        }
    }

    static {
        b bVar;
        Throwable th = null;
        try {
            bVar = new c(AtomicReferenceFieldUpdater.newUpdater(h.class, Set.class, AuthSource.SEND_ABUSE), AtomicIntegerFieldUpdater.newUpdater(h.class, AuthSource.BOOKING_ORDER));
        } catch (Throwable th2) {
            bVar = new d(null);
            th = th2;
        }
        c = bVar;
        if (th != null) {
            d.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
    }

    public h(int i) {
        this.b = i;
    }

    public static /* synthetic */ int d(h hVar) {
        int i = hVar.b;
        hVar.b = i - 1;
        return i;
    }

    public abstract void e(Set<Throwable> set);

    public final Set<Throwable> f() {
        Set<Throwable> set = this.a;
        if (set != null) {
            return set;
        }
        Set<Throwable> newConcurrentHashSet = Sets.newConcurrentHashSet();
        e(newConcurrentHashSet);
        c.a(this, null, newConcurrentHashSet);
        return this.a;
    }
}
