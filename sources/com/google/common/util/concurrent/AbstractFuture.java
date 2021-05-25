package com.google.common.util.concurrent;

import a2.j.d.l.a.n;
import com.avito.android.remote.auth.AuthSource;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.common.util.concurrent.internal.InternalFutures;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.ForOverride;
import com.google.j2objc.annotations.ReflectionSupport;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
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
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import sun.misc.Unsafe;
@GwtCompatible(emulated = true)
@ReflectionSupport(ReflectionSupport.Level.FULL)
public abstract class AbstractFuture<V> extends InternalFutureFailureAccess implements ListenableFuture<V> {
    public static final boolean d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    public static final Logger e = Logger.getLogger(AbstractFuture.class.getName());
    public static final b f;
    public static final Object g = new Object();
    @NullableDecl
    private volatile Object a;
    @NullableDecl
    private volatile e b;
    @NullableDecl
    private volatile l c;

    public static abstract class b {
        public b(a aVar) {
        }

        public abstract boolean a(AbstractFuture<?> abstractFuture, e eVar, e eVar2);

        public abstract boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2);

        public abstract boolean c(AbstractFuture<?> abstractFuture, l lVar, l lVar2);

        public abstract void d(l lVar, l lVar2);

        public abstract void e(l lVar, Thread thread);
    }

    public static final class c {
        public static final c c;
        public static final c d;
        public final boolean a;
        @NullableDecl
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

        public c(boolean z, @NullableDecl Throwable th) {
            this.a = z;
            this.b = th;
        }
    }

    public static final class d {
        public static final d b = new d(new a("Failure occurred while trying to finish a future."));
        public final Throwable a;

        public static class a extends Throwable {
            public a(String str) {
                super(str);
            }

            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        public d(Throwable th) {
            this.a = (Throwable) Preconditions.checkNotNull(th);
        }
    }

    public static final class e {
        public static final e d = new e(null, null);
        public final Runnable a;
        public final Executor b;
        @NullableDecl
        public e c;

        public e(Runnable runnable, Executor executor) {
            this.a = runnable;
            this.b = executor;
        }
    }

    public static final class f extends b {
        public final AtomicReferenceFieldUpdater<l, Thread> a;
        public final AtomicReferenceFieldUpdater<l, l> b;
        public final AtomicReferenceFieldUpdater<AbstractFuture, l> c;
        public final AtomicReferenceFieldUpdater<AbstractFuture, e> d;
        public final AtomicReferenceFieldUpdater<AbstractFuture, Object> e;

        public f(AtomicReferenceFieldUpdater<l, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<l, l> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractFuture, l> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractFuture, e> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractFuture, Object> atomicReferenceFieldUpdater5) {
            super(null);
            this.a = atomicReferenceFieldUpdater;
            this.b = atomicReferenceFieldUpdater2;
            this.c = atomicReferenceFieldUpdater3;
            this.d = atomicReferenceFieldUpdater4;
            this.e = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean a(AbstractFuture<?> abstractFuture, e eVar, e eVar2) {
            return this.d.compareAndSet(abstractFuture, eVar, eVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            return this.e.compareAndSet(abstractFuture, obj, obj2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean c(AbstractFuture<?> abstractFuture, l lVar, l lVar2) {
            return this.c.compareAndSet(abstractFuture, lVar, lVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void d(l lVar, l lVar2) {
            this.b.lazySet(lVar, lVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void e(l lVar, Thread thread) {
            this.a.lazySet(lVar, thread);
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
            if (((AbstractFuture) this.a).a == this) {
                if (AbstractFuture.f.b(this.a, this, AbstractFuture.k(this.b))) {
                    AbstractFuture.h(this.a);
                }
            }
        }
    }

    public static final class h extends b {
        public h(a aVar) {
            super(null);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean a(AbstractFuture<?> abstractFuture, e eVar, e eVar2) {
            synchronized (abstractFuture) {
                if (((AbstractFuture) abstractFuture).b != eVar) {
                    return false;
                }
                ((AbstractFuture) abstractFuture).b = eVar2;
                return true;
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            synchronized (abstractFuture) {
                if (((AbstractFuture) abstractFuture).a != obj) {
                    return false;
                }
                ((AbstractFuture) abstractFuture).a = obj2;
                return true;
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean c(AbstractFuture<?> abstractFuture, l lVar, l lVar2) {
            synchronized (abstractFuture) {
                if (((AbstractFuture) abstractFuture).c != lVar) {
                    return false;
                }
                ((AbstractFuture) abstractFuture).c = lVar2;
                return true;
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void d(l lVar, l lVar2) {
            lVar.b = lVar2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void e(l lVar, Thread thread) {
            lVar.a = thread;
        }
    }

    public interface i<V> extends ListenableFuture<V> {
    }

    public static abstract class j<V> extends AbstractFuture<V> implements i<V> {
        @Override // com.google.common.util.concurrent.AbstractFuture, com.google.common.util.concurrent.ListenableFuture
        public final void addListener(Runnable runnable, Executor executor) {
            AbstractFuture.super.addListener(runnable, executor);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @CanIgnoreReturnValue
        public final boolean cancel(boolean z) {
            return AbstractFuture.super.cancel(z);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @CanIgnoreReturnValue
        public final V get() throws InterruptedException, ExecutionException {
            return (V) AbstractFuture.super.get();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isCancelled() {
            return AbstractFuture.super.isCancelled();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isDone() {
            return AbstractFuture.super.isDone();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @CanIgnoreReturnValue
        public final V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return (V) AbstractFuture.super.get(j, timeUnit);
        }
    }

    public static final class k extends b {
        public static final Unsafe a;
        public static final long b;
        public static final long c;
        public static final long d;
        public static final long e;
        public static final long f;

        public static class a implements PrivilegedExceptionAction<Unsafe> {
            /* renamed from: a */
            public Unsafe run() throws Exception {
                Field[] declaredFields = Unsafe.class.getDeclaredFields();
                for (Field field : declaredFields) {
                    field.setAccessible(true);
                    Object obj = field.get(null);
                    if (Unsafe.class.isInstance(obj)) {
                        return (Unsafe) Unsafe.class.cast(obj);
                    }
                }
                throw new NoSuchFieldError("the Unsafe");
            }
        }

        static {
            Unsafe unsafe;
            try {
                unsafe = Unsafe.getUnsafe();
            } catch (SecurityException unused) {
                try {
                    unsafe = (Unsafe) AccessController.doPrivileged(new a());
                } catch (PrivilegedActionException e2) {
                    throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
                }
            }
            try {
                c = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("c"));
                b = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField(AuthSource.BOOKING_ORDER));
                d = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField(AuthSource.SEND_ABUSE));
                e = unsafe.objectFieldOffset(l.class.getDeclaredField(AuthSource.SEND_ABUSE));
                f = unsafe.objectFieldOffset(l.class.getDeclaredField(AuthSource.BOOKING_ORDER));
                a = unsafe;
            } catch (Exception e3) {
                Throwables.throwIfUnchecked(e3);
                throw new RuntimeException(e3);
            }
        }

        public k(a aVar) {
            super(null);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean a(AbstractFuture<?> abstractFuture, e eVar, e eVar2) {
            return a.compareAndSwapObject(abstractFuture, b, eVar, eVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            return a.compareAndSwapObject(abstractFuture, d, obj, obj2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean c(AbstractFuture<?> abstractFuture, l lVar, l lVar2) {
            return a.compareAndSwapObject(abstractFuture, c, lVar, lVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void d(l lVar, l lVar2) {
            a.putObject(lVar, f, lVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void e(l lVar, Thread thread) {
            a.putObject(lVar, e, thread);
        }
    }

    public static final class l {
        public static final l c = new l(false);
        @NullableDecl
        public volatile Thread a;
        @NullableDecl
        public volatile l b;

        public l(boolean z) {
        }

        public l() {
            AbstractFuture.f.e(this, Thread.currentThread());
        }
    }

    static {
        b bVar;
        Throwable th;
        Throwable th2 = null;
        try {
            bVar = new k(null);
            th = null;
        } catch (Throwable th3) {
            bVar = new h(null);
            th2 = th3;
        }
        f = bVar;
        if (th2 != null) {
            Logger logger = e;
            Level level = Level.SEVERE;
            logger.log(level, "UnsafeAtomicHelper is broken!", th);
            logger.log(level, "SafeAtomicHelper is broken!", th2);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0002 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x0002 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.common.util.concurrent.AbstractFuture<?>] */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.google.common.util.concurrent.AbstractFuture] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v7, types: [com.google.common.util.concurrent.AbstractFuture<V>, com.google.common.util.concurrent.AbstractFuture] */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.google.common.util.concurrent.AbstractFuture$b] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void h(com.google.common.util.concurrent.AbstractFuture<?> r5) {
        /*
            r0 = 0
            r1 = r0
        L_0x0002:
            com.google.common.util.concurrent.AbstractFuture$l r2 = r5.c
            com.google.common.util.concurrent.AbstractFuture$b r3 = com.google.common.util.concurrent.AbstractFuture.f
            com.google.common.util.concurrent.AbstractFuture$l r4 = com.google.common.util.concurrent.AbstractFuture.l.c
            boolean r3 = r3.c(r5, r2, r4)
            if (r3 == 0) goto L_0x0002
        L_0x000e:
            if (r2 == 0) goto L_0x001c
            java.lang.Thread r3 = r2.a
            if (r3 == 0) goto L_0x0019
            r2.a = r0
            java.util.concurrent.locks.LockSupport.unpark(r3)
        L_0x0019:
            com.google.common.util.concurrent.AbstractFuture$l r2 = r2.b
            goto L_0x000e
        L_0x001c:
            r5.afterDone()
        L_0x001f:
            com.google.common.util.concurrent.AbstractFuture$e r2 = r5.b
            com.google.common.util.concurrent.AbstractFuture$b r3 = com.google.common.util.concurrent.AbstractFuture.f
            com.google.common.util.concurrent.AbstractFuture$e r4 = com.google.common.util.concurrent.AbstractFuture.e.d
            boolean r3 = r3.a(r5, r2, r4)
            if (r3 == 0) goto L_0x001f
        L_0x002b:
            r5 = r1
            r1 = r2
            if (r1 == 0) goto L_0x0034
            com.google.common.util.concurrent.AbstractFuture$e r2 = r1.c
            r1.c = r5
            goto L_0x002b
        L_0x0034:
            if (r5 == 0) goto L_0x005c
            com.google.common.util.concurrent.AbstractFuture$e r1 = r5.c
            java.lang.Runnable r2 = r5.a
            boolean r3 = r2 instanceof com.google.common.util.concurrent.AbstractFuture.g
            if (r3 == 0) goto L_0x0055
            com.google.common.util.concurrent.AbstractFuture$g r2 = (com.google.common.util.concurrent.AbstractFuture.g) r2
            com.google.common.util.concurrent.AbstractFuture<V> r5 = r2.a
            java.lang.Object r3 = r5.a
            if (r3 != r2) goto L_0x005a
            com.google.common.util.concurrent.ListenableFuture<? extends V> r3 = r2.b
            java.lang.Object r3 = k(r3)
            com.google.common.util.concurrent.AbstractFuture$b r4 = com.google.common.util.concurrent.AbstractFuture.f
            boolean r2 = r4.b(r5, r2, r3)
            if (r2 == 0) goto L_0x005a
            goto L_0x0002
        L_0x0055:
            java.util.concurrent.Executor r5 = r5.b
            i(r2, r5)
        L_0x005a:
            r5 = r1
            goto L_0x0034
        L_0x005c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractFuture.h(com.google.common.util.concurrent.AbstractFuture):void");
    }

    public static void i(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = e;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    public static Object k(ListenableFuture<?> listenableFuture) {
        Throwable tryInternalFastPathGetFailure;
        if (listenableFuture instanceof i) {
            Object obj = ((AbstractFuture) listenableFuture).a;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            if (cVar.a) {
                return cVar.b != null ? new c(false, cVar.b) : c.d;
            }
            return obj;
        } else if ((listenableFuture instanceof InternalFutureFailureAccess) && (tryInternalFastPathGetFailure = InternalFutures.tryInternalFastPathGetFailure((InternalFutureFailureAccess) listenableFuture)) != null) {
            return new d(tryInternalFastPathGetFailure);
        } else {
            boolean isCancelled = listenableFuture.isCancelled();
            if ((!d) && isCancelled) {
                return c.d;
            }
            try {
                Object l2 = l(listenableFuture);
                if (!isCancelled) {
                    return l2 == null ? g : l2;
                }
                return new c(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + listenableFuture));
            } catch (ExecutionException e2) {
                if (!isCancelled) {
                    return new d(e2.getCause());
                }
                return new c(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + listenableFuture, e2));
            } catch (CancellationException e3) {
                if (isCancelled) {
                    return new c(false, e3);
                }
                return new d(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + listenableFuture, e3));
            } catch (Throwable th) {
                return new d(th);
            }
        }
    }

    public static <V> V l(Future<V> future) throws ExecutionException {
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

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable runnable, Executor executor) {
        e eVar;
        Preconditions.checkNotNull(runnable, "Runnable was null.");
        Preconditions.checkNotNull(executor, "Executor was null.");
        if (isDone() || (eVar = this.b) == e.d) {
            i(runnable, executor);
        }
        e eVar2 = new e(runnable, executor);
        do {
            eVar2.c = eVar;
            if (!f.a(this, eVar, eVar2)) {
                eVar = this.b;
            } else {
                return;
            }
        } while (eVar != e.d);
        i(runnable, executor);
    }

    @Beta
    @ForOverride
    public void afterDone() {
    }

    @Override // java.util.concurrent.Future
    @CanIgnoreReturnValue
    public boolean cancel(boolean z) {
        Object obj = this.a;
        if (!(obj == null) && !(obj instanceof g)) {
            return false;
        }
        c cVar = d ? new c(z, new CancellationException("Future.cancel() was called.")) : z ? c.c : c.d;
        boolean z2 = false;
        AbstractFuture<V> abstractFuture = this;
        while (true) {
            if (f.b(abstractFuture, obj, cVar)) {
                if (z) {
                    abstractFuture.interruptTask();
                }
                h(abstractFuture);
                if (!(obj instanceof g)) {
                    return true;
                }
                ListenableFuture<? extends V> listenableFuture = ((g) obj).b;
                if (listenableFuture instanceof i) {
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

    public final void g(StringBuilder sb) {
        String str;
        try {
            Object l2 = l(this);
            sb.append("SUCCESS, result=[");
            if (l2 == this) {
                str = "this future";
            } else {
                str = String.valueOf(l2);
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

    @Override // java.util.concurrent.Future
    @CanIgnoreReturnValue
    public V get(long j2, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long nanos = timeUnit.toNanos(j2);
        if (!Thread.interrupted()) {
            Object obj = this.a;
            if ((obj != null) && (!(obj instanceof g))) {
                return j(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                l lVar = this.c;
                if (lVar != l.c) {
                    l lVar2 = new l();
                    do {
                        b bVar = f;
                        bVar.d(lVar2, lVar);
                        if (bVar.c(this, lVar, lVar2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.a;
                                    if ((obj2 != null) && (!(obj2 instanceof g))) {
                                        return j(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    n(lVar2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            n(lVar2);
                        } else {
                            lVar = this.c;
                        }
                    } while (lVar != l.c);
                }
                return j(this.a);
            }
            while (nanos > 0) {
                Object obj3 = this.a;
                if ((obj3 != null) && (!(obj3 instanceof g))) {
                    return j(obj3);
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
            StringBuilder O = a2.b.a.a.a.O("Waited ", j2, " ");
            O.append(timeUnit.toString().toLowerCase(locale));
            String sb = O.toString();
            if (nanos + 1000 < 0) {
                String c3 = a2.b.a.a.a.c3(sb, " (plus ");
                long j3 = -nanos;
                long convert = timeUnit.convert(j3, TimeUnit.NANOSECONDS);
                long nanos2 = j3 - timeUnit.toNanos(convert);
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
    public boolean isCancelled() {
        return this.a instanceof c;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        Object obj = this.a;
        return (!(obj instanceof g)) & (obj != null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public final V j(Object obj) throws ExecutionException {
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

    public final void m(@NullableDecl Future<?> future) {
        if ((future != null) && isCancelled()) {
            future.cancel(wasInterrupted());
        }
    }

    public final void n(l lVar) {
        lVar.a = null;
        while (true) {
            l lVar2 = this.c;
            if (lVar2 != l.c) {
                l lVar3 = null;
                while (lVar2 != null) {
                    l lVar4 = lVar2.b;
                    if (lVar2.a != null) {
                        lVar3 = lVar2;
                    } else if (lVar3 != null) {
                        lVar3.b = lVar4;
                        if (lVar3.a == null) {
                        }
                    } else if (!f.c(this, lVar2, lVar4)) {
                    }
                    lVar2 = lVar4;
                }
                return;
            }
            return;
        }
    }

    @NullableDecl
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

    @CanIgnoreReturnValue
    public boolean set(@NullableDecl V v) {
        if (v == null) {
            v = (V) g;
        }
        if (!f.b(this, null, v)) {
            return false;
        }
        h(this);
        return true;
    }

    @CanIgnoreReturnValue
    public boolean setException(Throwable th) {
        if (!f.b(this, null, new d((Throwable) Preconditions.checkNotNull(th)))) {
            return false;
        }
        h(this);
        return true;
    }

    @CanIgnoreReturnValue
    public boolean setFuture(ListenableFuture<? extends V> listenableFuture) {
        g gVar;
        d dVar;
        Preconditions.checkNotNull(listenableFuture);
        Object obj = this.a;
        if (obj == null) {
            if (listenableFuture.isDone()) {
                if (!f.b(this, null, k(listenableFuture))) {
                    return false;
                }
                h(this);
                return true;
            }
            gVar = new g(this, listenableFuture);
            if (f.b(this, null, gVar)) {
                try {
                    listenableFuture.addListener(gVar, n.INSTANCE);
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
            g(sb);
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
                g(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // com.google.common.util.concurrent.internal.InternalFutureFailureAccess
    @NullableDecl
    public final Throwable tryInternalFastPathGetFailure() {
        if (!(this instanceof i)) {
            return null;
        }
        Object obj = this.a;
        if (obj instanceof d) {
            return ((d) obj).a;
        }
        return null;
    }

    public final boolean wasInterrupted() {
        Object obj = this.a;
        return (obj instanceof c) && ((c) obj).a;
    }

    @Override // java.util.concurrent.Future
    @CanIgnoreReturnValue
    public V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.a;
            if ((obj2 != null) && (!(obj2 instanceof g))) {
                return j(obj2);
            }
            l lVar = this.c;
            if (lVar != l.c) {
                l lVar2 = new l();
                do {
                    b bVar = f;
                    bVar.d(lVar2, lVar);
                    if (bVar.c(this, lVar, lVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.a;
                            } else {
                                n(lVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof g))));
                        return j(obj);
                    }
                    lVar = this.c;
                } while (lVar != l.c);
            }
            return j(this.a);
        }
        throw new InterruptedException();
    }
}
