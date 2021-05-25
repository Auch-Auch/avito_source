package androidx.work.impl.utils.futures;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.avito.android.remote.auth.AuthSource;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class AbstractFuture<V> implements ListenableFuture<V> {
    public static final boolean d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    public static final Logger e = Logger.getLogger(AbstractFuture.class.getName());
    public static final b f;
    public static final Object g = new Object();
    @Nullable
    public volatile Object a;
    @Nullable
    public volatile e b;
    @Nullable
    public volatile i c;

    public static abstract class b {
        public b(a aVar) {
        }

        public abstract boolean a(AbstractFuture<?> abstractFuture, e eVar, e eVar2);

        public abstract boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2);

        public abstract boolean c(AbstractFuture<?> abstractFuture, i iVar, i iVar2);

        public abstract void d(i iVar, i iVar2);

        public abstract void e(i iVar, Thread thread);
    }

    public static final class c {
        public static final c c;
        public static final c d;
        public final boolean a;
        @Nullable
        public final Throwable b;

        static {
            if (AbstractFuture.d) {
                d = null;
                c = null;
                return;
            }
            d = new c(false, null);
            c = new c(true, null);
        }

        public c(boolean z, @Nullable Throwable th) {
            this.a = z;
            this.b = th;
        }
    }

    public static final class d {
        public static final d b = new d(new a("Failure occurred while trying to finish a future."));
        public final Throwable a;

        public class a extends Throwable {
            public a(String str) {
                super(str);
            }

            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        public d(Throwable th) {
            boolean z = AbstractFuture.d;
            Objects.requireNonNull(th);
            this.a = th;
        }
    }

    public static final class e {
        public static final e d = new e(null, null);
        public final Runnable a;
        public final Executor b;
        @Nullable
        public e c;

        public e(Runnable runnable, Executor executor) {
            this.a = runnable;
            this.b = executor;
        }
    }

    public static final class f extends b {
        public final AtomicReferenceFieldUpdater<i, Thread> a;
        public final AtomicReferenceFieldUpdater<i, i> b;
        public final AtomicReferenceFieldUpdater<AbstractFuture, i> c;
        public final AtomicReferenceFieldUpdater<AbstractFuture, e> d;
        public final AtomicReferenceFieldUpdater<AbstractFuture, Object> e;

        public f(AtomicReferenceFieldUpdater<i, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<i, i> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractFuture, i> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractFuture, e> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractFuture, Object> atomicReferenceFieldUpdater5) {
            super(null);
            this.a = atomicReferenceFieldUpdater;
            this.b = atomicReferenceFieldUpdater2;
            this.c = atomicReferenceFieldUpdater3;
            this.d = atomicReferenceFieldUpdater4;
            this.e = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        public boolean a(AbstractFuture<?> abstractFuture, e eVar, e eVar2) {
            return this.d.compareAndSet(abstractFuture, eVar, eVar2);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        public boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            return this.e.compareAndSet(abstractFuture, obj, obj2);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        public boolean c(AbstractFuture<?> abstractFuture, i iVar, i iVar2) {
            return this.c.compareAndSet(abstractFuture, iVar, iVar2);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        public void d(i iVar, i iVar2) {
            this.b.lazySet(iVar, iVar2);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        public void e(i iVar, Thread thread) {
            this.a.lazySet(iVar, thread);
        }
    }

    public static final class g<V> implements Runnable {
        public final AbstractFuture<V> a;
        public final ListenableFuture<? extends V> b;

        public g(AbstractFuture<V> abstractFuture, ListenableFuture<? extends V> listenableFuture) {
            this.a = abstractFuture;
            this.b = listenableFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.a == this) {
                if (AbstractFuture.f.b(this.a, this, AbstractFuture.e(this.b))) {
                    AbstractFuture.b(this.a);
                }
            }
        }
    }

    public static final class h extends b {
        public h() {
            super(null);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        public boolean a(AbstractFuture<?> abstractFuture, e eVar, e eVar2) {
            synchronized (abstractFuture) {
                if (abstractFuture.b != eVar) {
                    return false;
                }
                abstractFuture.b = eVar2;
                return true;
            }
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        public boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            synchronized (abstractFuture) {
                if (abstractFuture.a != obj) {
                    return false;
                }
                abstractFuture.a = obj2;
                return true;
            }
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        public boolean c(AbstractFuture<?> abstractFuture, i iVar, i iVar2) {
            synchronized (abstractFuture) {
                if (abstractFuture.c != iVar) {
                    return false;
                }
                abstractFuture.c = iVar2;
                return true;
            }
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        public void d(i iVar, i iVar2) {
            iVar.b = iVar2;
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        public void e(i iVar, Thread thread) {
            iVar.a = thread;
        }
    }

    public static final class i {
        public static final i c = new i(false);
        @Nullable
        public volatile Thread a;
        @Nullable
        public volatile i b;

        public i(boolean z) {
        }

        public i() {
            AbstractFuture.f.e(this, Thread.currentThread());
        }
    }

    static {
        b bVar;
        Throwable th;
        try {
            bVar = new f(AtomicReferenceFieldUpdater.newUpdater(i.class, Thread.class, AuthSource.SEND_ABUSE), AtomicReferenceFieldUpdater.newUpdater(i.class, i.class, AuthSource.BOOKING_ORDER), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, i.class, "c"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, e.class, AuthSource.BOOKING_ORDER), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, AuthSource.SEND_ABUSE));
            th = null;
        } catch (Throwable th2) {
            th = th2;
            bVar = new h();
        }
        f = bVar;
        if (th != null) {
            e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0002 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x0002 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [androidx.work.impl.utils.futures.AbstractFuture<?>] */
    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.work.impl.utils.futures.AbstractFuture] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v7, types: [androidx.work.impl.utils.futures.AbstractFuture, androidx.work.impl.utils.futures.AbstractFuture<V>] */
    /* JADX WARN: Type inference failed for: r4v2, types: [androidx.work.impl.utils.futures.AbstractFuture$b] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(androidx.work.impl.utils.futures.AbstractFuture<?> r5) {
        /*
            r0 = 0
            r1 = r0
        L_0x0002:
            androidx.work.impl.utils.futures.AbstractFuture$i r2 = r5.c
            androidx.work.impl.utils.futures.AbstractFuture$b r3 = androidx.work.impl.utils.futures.AbstractFuture.f
            androidx.work.impl.utils.futures.AbstractFuture$i r4 = androidx.work.impl.utils.futures.AbstractFuture.i.c
            boolean r3 = r3.c(r5, r2, r4)
            if (r3 == 0) goto L_0x0002
        L_0x000e:
            if (r2 == 0) goto L_0x001c
            java.lang.Thread r3 = r2.a
            if (r3 == 0) goto L_0x0019
            r2.a = r0
            java.util.concurrent.locks.LockSupport.unpark(r3)
        L_0x0019:
            androidx.work.impl.utils.futures.AbstractFuture$i r2 = r2.b
            goto L_0x000e
        L_0x001c:
            r5.afterDone()
        L_0x001f:
            androidx.work.impl.utils.futures.AbstractFuture$e r2 = r5.b
            androidx.work.impl.utils.futures.AbstractFuture$b r3 = androidx.work.impl.utils.futures.AbstractFuture.f
            androidx.work.impl.utils.futures.AbstractFuture$e r4 = androidx.work.impl.utils.futures.AbstractFuture.e.d
            boolean r3 = r3.a(r5, r2, r4)
            if (r3 == 0) goto L_0x001f
        L_0x002b:
            r5 = r1
            r1 = r2
            if (r1 == 0) goto L_0x0034
            androidx.work.impl.utils.futures.AbstractFuture$e r2 = r1.c
            r1.c = r5
            goto L_0x002b
        L_0x0034:
            if (r5 == 0) goto L_0x005c
            androidx.work.impl.utils.futures.AbstractFuture$e r1 = r5.c
            java.lang.Runnable r2 = r5.a
            boolean r3 = r2 instanceof androidx.work.impl.utils.futures.AbstractFuture.g
            if (r3 == 0) goto L_0x0055
            androidx.work.impl.utils.futures.AbstractFuture$g r2 = (androidx.work.impl.utils.futures.AbstractFuture.g) r2
            androidx.work.impl.utils.futures.AbstractFuture<V> r5 = r2.a
            java.lang.Object r3 = r5.a
            if (r3 != r2) goto L_0x005a
            com.google.common.util.concurrent.ListenableFuture<? extends V> r3 = r2.b
            java.lang.Object r3 = e(r3)
            androidx.work.impl.utils.futures.AbstractFuture$b r4 = androidx.work.impl.utils.futures.AbstractFuture.f
            boolean r2 = r4.b(r5, r2, r3)
            if (r2 == 0) goto L_0x005a
            goto L_0x0002
        L_0x0055:
            java.util.concurrent.Executor r5 = r5.b
            c(r2, r5)
        L_0x005a:
            r5 = r1
            goto L_0x0034
        L_0x005c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.futures.AbstractFuture.b(androidx.work.impl.utils.futures.AbstractFuture):void");
    }

    public static void c(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = e;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    public static Object e(ListenableFuture<?> listenableFuture) {
        if (listenableFuture instanceof AbstractFuture) {
            Object obj = ((AbstractFuture) listenableFuture).a;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            if (!cVar.a) {
                return obj;
            }
            if (cVar.b != null) {
                return new c(false, cVar.b);
            }
            return c.d;
        }
        boolean isCancelled = listenableFuture.isCancelled();
        if ((!d) && isCancelled) {
            return c.d;
        }
        try {
            Object f2 = f(listenableFuture);
            return f2 == null ? g : f2;
        } catch (ExecutionException e2) {
            return new d(e2.getCause());
        } catch (CancellationException e3) {
            if (isCancelled) {
                return new c(false, e3);
            }
            return new d(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + listenableFuture, e3));
        } catch (Throwable th) {
            return new d(th);
        }
    }

    public static <V> V f(Future<V> future) throws ExecutionException {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    public final void a(StringBuilder sb) {
        String str;
        try {
            Object f2 = f(this);
            sb.append("SUCCESS, result=[");
            if (f2 == this) {
                str = "this future";
            } else {
                str = String.valueOf(f2);
            }
            sb.append(str);
            sb.append("]");
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e3) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e3.getClass());
            sb.append(" thrown from get()]");
        }
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void addListener(Runnable runnable, Executor executor) {
        Objects.requireNonNull(runnable);
        Objects.requireNonNull(executor);
        e eVar = this.b;
        if (eVar != e.d) {
            e eVar2 = new e(runnable, executor);
            do {
                eVar2.c = eVar;
                if (!f.a(this, eVar, eVar2)) {
                    eVar = this.b;
                } else {
                    return;
                }
            } while (eVar != e.d);
        }
        c(runnable, executor);
    }

    public void afterDone() {
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        c cVar;
        Object obj = this.a;
        if (!(obj == null) && !(obj instanceof g)) {
            return false;
        }
        if (d) {
            cVar = new c(z, new CancellationException("Future.cancel() was called."));
        } else if (z) {
            cVar = c.c;
        } else {
            cVar = c.d;
        }
        boolean z2 = false;
        AbstractFuture<V> abstractFuture = this;
        while (true) {
            if (f.b(abstractFuture, obj, cVar)) {
                if (z) {
                    abstractFuture.interruptTask();
                }
                b(abstractFuture);
                if (!(obj instanceof g)) {
                    return true;
                }
                ListenableFuture<? extends V> listenableFuture = ((g) obj).b;
                if (listenableFuture instanceof AbstractFuture) {
                    abstractFuture = (AbstractFuture) listenableFuture;
                    obj = abstractFuture.a;
                    if (!(obj == null) && !(obj instanceof g)) {
                        return true;
                    }
                    z2 = true;
                } else {
                    listenableFuture.cancel(z);
                    return true;
                }
            } else {
                obj = abstractFuture.a;
                if (!(obj instanceof g)) {
                    return z2;
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public final V d(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            Throwable th = ((c) obj).b;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        } else if (obj instanceof d) {
            throw new ExecutionException(((d) obj).a);
        } else if (obj == g) {
            return null;
        } else {
            return obj;
        }
    }

    public final void g(i iVar) {
        iVar.a = null;
        while (true) {
            i iVar2 = this.c;
            if (iVar2 != i.c) {
                i iVar3 = null;
                while (iVar2 != null) {
                    i iVar4 = iVar2.b;
                    if (iVar2.a != null) {
                        iVar3 = iVar2;
                    } else if (iVar3 != null) {
                        iVar3.b = iVar4;
                        if (iVar3.a == null) {
                        }
                    } else if (!f.c(this, iVar2, iVar4)) {
                    }
                    iVar2 = iVar4;
                }
                return;
            }
            return;
        }
    }

    @Override // java.util.concurrent.Future
    public final V get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long nanos = timeUnit.toNanos(j);
        if (!Thread.interrupted()) {
            Object obj = this.a;
            if ((obj != null) && (!(obj instanceof g))) {
                return d(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                i iVar = this.c;
                if (iVar != i.c) {
                    i iVar2 = new i();
                    do {
                        b bVar = f;
                        bVar.d(iVar2, iVar);
                        if (bVar.c(this, iVar, iVar2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.a;
                                    if ((obj2 != null) && (!(obj2 instanceof g))) {
                                        return d(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    g(iVar2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            g(iVar2);
                        } else {
                            iVar = this.c;
                        }
                    } while (iVar != i.c);
                }
                return d(this.a);
            }
            while (nanos > 0) {
                Object obj3 = this.a;
                if ((obj3 != null) && (!(obj3 instanceof g))) {
                    return d(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String abstractFuture = toString();
            String timeUnit2 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = timeUnit2.toLowerCase(locale);
            StringBuilder O = a2.b.a.a.a.O("Waited ", j, " ");
            O.append(timeUnit.toString().toLowerCase(locale));
            String sb = O.toString();
            if (nanos + 1000 < 0) {
                String c3 = a2.b.a.a.a.c3(sb, " (plus ");
                long j2 = -nanos;
                long convert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
                long nanos2 = j2 - timeUnit.toNanos(convert);
                int i2 = (convert > 0 ? 1 : (convert == 0 ? 0 : -1));
                boolean z = i2 == 0 || nanos2 > 1000;
                if (i2 > 0) {
                    String str = c3 + convert + " " + lowerCase;
                    if (z) {
                        str = a2.b.a.a.a.c3(str, ",");
                    }
                    c3 = a2.b.a.a.a.c3(str, " ");
                }
                if (z) {
                    c3 = a2.b.a.a.a.V2(c3, nanos2, " nanoseconds ");
                }
                sb = a2.b.a.a.a.c3(c3, "delay)");
            }
            if (isDone()) {
                throw new TimeoutException(a2.b.a.a.a.c3(sb, " but future completed as timeout expired"));
            }
            throw new TimeoutException(a2.b.a.a.a.e3(sb, " for ", abstractFuture));
        }
        throw new InterruptedException();
    }

    public void interruptTask() {
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.a instanceof c;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        Object obj = this.a;
        return (!(obj instanceof g)) & (obj != null);
    }

    @Nullable
    public String pendingToString() {
        String str;
        Object obj = this.a;
        if (obj instanceof g) {
            StringBuilder L = a2.b.a.a.a.L("setFuture=[");
            ListenableFuture<? extends V> listenableFuture = ((g) obj).b;
            if (listenableFuture == this) {
                str = "this future";
            } else {
                str = String.valueOf(listenableFuture);
            }
            return a2.b.a.a.a.t(L, str, "]");
        } else if (!(this instanceof ScheduledFuture)) {
            return null;
        } else {
            StringBuilder L2 = a2.b.a.a.a.L("remaining delay=[");
            L2.append(((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS));
            L2.append(" ms]");
            return L2.toString();
        }
    }

    public boolean set(@Nullable V v) {
        if (v == null) {
            v = (V) g;
        }
        if (!f.b(this, null, v)) {
            return false;
        }
        b(this);
        return true;
    }

    public boolean setException(Throwable th) {
        Objects.requireNonNull(th);
        if (!f.b(this, null, new d(th))) {
            return false;
        }
        b(this);
        return true;
    }

    public boolean setFuture(ListenableFuture<? extends V> listenableFuture) {
        g gVar;
        d dVar;
        Objects.requireNonNull(listenableFuture);
        Object obj = this.a;
        if (obj == null) {
            if (listenableFuture.isDone()) {
                if (!f.b(this, null, e(listenableFuture))) {
                    return false;
                }
                b(this);
                return true;
            }
            gVar = new g(this, listenableFuture);
            if (f.b(this, null, gVar)) {
                try {
                    listenableFuture.addListener(gVar, l6.d0.a.f.a.a.INSTANCE);
                } catch (Throwable unused) {
                    dVar = d.b;
                }
                return true;
            }
            obj = this.a;
        }
        if (obj instanceof c) {
            listenableFuture.cancel(((c) obj).a);
        }
        return false;
        f.b(this, gVar, dVar);
        return true;
    }

    @Override // java.lang.Object
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            a(sb);
        } else {
            try {
                str = pendingToString();
            } catch (RuntimeException e2) {
                StringBuilder L = a2.b.a.a.a.L("Exception thrown from implementation: ");
                L.append(e2.getClass());
                str = L.toString();
            }
            if (str != null && !str.isEmpty()) {
                a2.b.a.a.a.m1(sb, "PENDING, info=[", str, "]");
            } else if (isDone()) {
                a(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public final boolean wasInterrupted() {
        Object obj = this.a;
        return (obj instanceof c) && ((c) obj).a;
    }

    @Override // java.util.concurrent.Future
    public final V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.a;
            if ((obj2 != null) && (!(obj2 instanceof g))) {
                return d(obj2);
            }
            i iVar = this.c;
            if (iVar != i.c) {
                i iVar2 = new i();
                do {
                    b bVar = f;
                    bVar.d(iVar2, iVar);
                    if (bVar.c(this, iVar, iVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.a;
                            } else {
                                g(iVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof g))));
                        return d(obj);
                    }
                    iVar = this.c;
                } while (iVar != i.c);
            }
            return d(this.a);
        }
        throw new InterruptedException();
    }
}
