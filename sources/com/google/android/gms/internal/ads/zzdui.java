package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
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
public class zzdui<V> extends zzdwo implements zzdvt<V> {
    private static final boolean GENERATE_CANCELLATION_CAUSES;
    private static final Object NULL = new Object();
    private static final Logger zzhoi = Logger.getLogger(zzdui.class.getName());
    private static final zza zzhoj;
    @NullableDecl
    private volatile zzd listeners;
    @NullableDecl
    private volatile Object value;
    @NullableDecl
    private volatile zzk waiters;

    public static abstract class zza {
        private zza() {
        }

        public abstract void zza(zzk zzk, zzk zzk2);

        public abstract void zza(zzk zzk, Thread thread);

        public abstract boolean zza(zzdui<?> zzdui, zzd zzd, zzd zzd2);

        public abstract boolean zza(zzdui<?> zzdui, zzk zzk, zzk zzk2);

        public abstract boolean zza(zzdui<?> zzdui, Object obj, Object obj2);
    }

    public static final class zzb {
        public static final zzb zzhok = new zzb(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.android.gms.internal.ads.zzdui.zzb.1
            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });
        public final Throwable exception;

        public zzb(Throwable th) {
            this.exception = (Throwable) zzdsv.checkNotNull(th);
        }
    }

    public static final class zzc {
        public static final zzc zzhol;
        public static final zzc zzhom;
        @NullableDecl
        public final Throwable cause;
        public final boolean wasInterrupted;

        static {
            if (zzdui.GENERATE_CANCELLATION_CAUSES) {
                zzhom = null;
                zzhol = null;
                return;
            }
            zzhom = new zzc(false, null);
            zzhol = new zzc(true, null);
        }

        public zzc(boolean z, @NullableDecl Throwable th) {
            this.wasInterrupted = z;
            this.cause = th;
        }
    }

    public static final class zzd {
        public static final zzd zzhon = new zzd(null, null);
        public final Executor executor;
        @NullableDecl
        public zzd next;
        public final Runnable task;

        public zzd(Runnable runnable, Executor executor2) {
            this.task = runnable;
            this.executor = executor2;
        }
    }

    public static final class zze<V> implements Runnable {
        public final zzdvt<? extends V> future;
        public final zzdui<V> zzhoo;

        public zze(zzdui<V> zzdui, zzdvt<? extends V> zzdvt) {
            this.zzhoo = zzdui;
            this.future = zzdvt;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (((zzdui) this.zzhoo).value == this) {
                if (zzdui.zzhoj.zza((zzdui<?>) this.zzhoo, (Object) this, zzdui.getFutureValue(this.future))) {
                    zzdui.zza((zzdui<?>) this.zzhoo);
                }
            }
        }
    }

    public static final class zzf extends zza {
        public final AtomicReferenceFieldUpdater<zzdui, zzd> listenersUpdater;
        public final AtomicReferenceFieldUpdater<zzdui, Object> valueUpdater;
        public final AtomicReferenceFieldUpdater<zzk, zzk> waiterNextUpdater;
        public final AtomicReferenceFieldUpdater<zzk, Thread> waiterThreadUpdater;
        public final AtomicReferenceFieldUpdater<zzdui, zzk> waitersUpdater;

        public zzf(AtomicReferenceFieldUpdater<zzk, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<zzk, zzk> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<zzdui, zzk> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<zzdui, zzd> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<zzdui, Object> atomicReferenceFieldUpdater5) {
            super();
            this.waiterThreadUpdater = atomicReferenceFieldUpdater;
            this.waiterNextUpdater = atomicReferenceFieldUpdater2;
            this.waitersUpdater = atomicReferenceFieldUpdater3;
            this.listenersUpdater = atomicReferenceFieldUpdater4;
            this.valueUpdater = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.android.gms.internal.ads.zzdui.zza
        public final void zza(zzk zzk, Thread thread) {
            this.waiterThreadUpdater.lazySet(zzk, thread);
        }

        @Override // com.google.android.gms.internal.ads.zzdui.zza
        public final void zza(zzk zzk, zzk zzk2) {
            this.waiterNextUpdater.lazySet(zzk, zzk2);
        }

        @Override // com.google.android.gms.internal.ads.zzdui.zza
        public final boolean zza(zzdui<?> zzdui, zzk zzk, zzk zzk2) {
            return this.waitersUpdater.compareAndSet(zzdui, zzk, zzk2);
        }

        @Override // com.google.android.gms.internal.ads.zzdui.zza
        public final boolean zza(zzdui<?> zzdui, zzd zzd, zzd zzd2) {
            return this.listenersUpdater.compareAndSet(zzdui, zzd, zzd2);
        }

        @Override // com.google.android.gms.internal.ads.zzdui.zza
        public final boolean zza(zzdui<?> zzdui, Object obj, Object obj2) {
            return this.valueUpdater.compareAndSet(zzdui, obj, obj2);
        }
    }

    public interface zzg<V> extends zzdvt<V> {
    }

    public static final class zzh extends zza {
        private zzh() {
            super();
        }

        @Override // com.google.android.gms.internal.ads.zzdui.zza
        public final void zza(zzk zzk, Thread thread) {
            zzk.thread = thread;
        }

        @Override // com.google.android.gms.internal.ads.zzdui.zza
        public final void zza(zzk zzk, zzk zzk2) {
            zzk.next = zzk2;
        }

        @Override // com.google.android.gms.internal.ads.zzdui.zza
        public final boolean zza(zzdui<?> zzdui, zzk zzk, zzk zzk2) {
            synchronized (zzdui) {
                if (((zzdui) zzdui).waiters != zzk) {
                    return false;
                }
                ((zzdui) zzdui).waiters = zzk2;
                return true;
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdui.zza
        public final boolean zza(zzdui<?> zzdui, zzd zzd, zzd zzd2) {
            synchronized (zzdui) {
                if (((zzdui) zzdui).listeners != zzd) {
                    return false;
                }
                ((zzdui) zzdui).listeners = zzd2;
                return true;
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdui.zza
        public final boolean zza(zzdui<?> zzdui, Object obj, Object obj2) {
            synchronized (zzdui) {
                if (((zzdui) zzdui).value != obj) {
                    return false;
                }
                ((zzdui) zzdui).value = obj2;
                return true;
            }
        }
    }

    public static final class zzi extends zza {
        public static final Unsafe zzhop;
        public static final long zzhoq;
        public static final long zzhor;
        public static final long zzhos;
        public static final long zzhot;
        public static final long zzhou;

        static {
            Unsafe unsafe;
            try {
                unsafe = Unsafe.getUnsafe();
            } catch (SecurityException unused) {
                try {
                    unsafe = (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.android.gms.internal.ads.zzdui.zzi.1
                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // java.security.PrivilegedExceptionAction
                        public /* synthetic */ Unsafe run() throws Exception {
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
                    });
                } catch (PrivilegedActionException e) {
                    throw new RuntimeException("Could not initialize intrinsics", e.getCause());
                }
            }
            try {
                zzhor = unsafe.objectFieldOffset(zzdui.class.getDeclaredField("waiters"));
                zzhoq = unsafe.objectFieldOffset(zzdui.class.getDeclaredField("listeners"));
                zzhos = unsafe.objectFieldOffset(zzdui.class.getDeclaredField("value"));
                zzhot = unsafe.objectFieldOffset(zzk.class.getDeclaredField("thread"));
                zzhou = unsafe.objectFieldOffset(zzk.class.getDeclaredField("next"));
                zzhop = unsafe;
            } catch (Exception e2) {
                zzdsy.zzh(e2);
                throw new RuntimeException(e2);
            }
        }

        private zzi() {
            super();
        }

        @Override // com.google.android.gms.internal.ads.zzdui.zza
        public final void zza(zzk zzk, Thread thread) {
            zzhop.putObject(zzk, zzhot, thread);
        }

        @Override // com.google.android.gms.internal.ads.zzdui.zza
        public final void zza(zzk zzk, zzk zzk2) {
            zzhop.putObject(zzk, zzhou, zzk2);
        }

        @Override // com.google.android.gms.internal.ads.zzdui.zza
        public final boolean zza(zzdui<?> zzdui, zzk zzk, zzk zzk2) {
            return zzhop.compareAndSwapObject(zzdui, zzhor, zzk, zzk2);
        }

        @Override // com.google.android.gms.internal.ads.zzdui.zza
        public final boolean zza(zzdui<?> zzdui, zzd zzd, zzd zzd2) {
            return zzhop.compareAndSwapObject(zzdui, zzhoq, zzd, zzd2);
        }

        @Override // com.google.android.gms.internal.ads.zzdui.zza
        public final boolean zza(zzdui<?> zzdui, Object obj, Object obj2) {
            return zzhop.compareAndSwapObject(zzdui, zzhos, obj, obj2);
        }
    }

    public static abstract class zzj<V> extends zzdui<V> implements zzg<V> {
        @Override // com.google.android.gms.internal.ads.zzdui, java.util.concurrent.Future
        public final V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return (V) zzdui.super.get(j, timeUnit);
        }
    }

    public static final class zzk {
        public static final zzk zzhov = new zzk(false);
        @NullableDecl
        public volatile zzk next;
        @NullableDecl
        public volatile Thread thread;

        private zzk(boolean z) {
        }

        public final void zzb(zzk zzk) {
            zzdui.zzhoj.zza(this, zzk);
        }

        public zzk() {
            zzdui.zzhoj.zza(this, Thread.currentThread());
        }
    }

    static {
        boolean z;
        Throwable th;
        Throwable th2;
        zza zza2;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z = false;
        }
        GENERATE_CANCELLATION_CAUSES = z;
        try {
            zza2 = new zzi();
            th2 = null;
            th = null;
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            zza2 = new zzh();
        }
        zzhoj = zza2;
        if (th != null) {
            Logger logger = zzhoi;
            Level level = Level.SEVERE;
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "UnsafeAtomicHelper is broken!", th2);
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }

    /* access modifiers changed from: private */
    public static Object getFutureValue(zzdvt<?> zzdvt) {
        Throwable zza2;
        if (zzdvt instanceof zzg) {
            Object obj = ((zzdui) zzdvt).value;
            if (!(obj instanceof zzc)) {
                return obj;
            }
            zzc zzc2 = (zzc) obj;
            if (!zzc2.wasInterrupted) {
                return obj;
            }
            if (zzc2.cause != null) {
                return new zzc(false, zzc2.cause);
            }
            return zzc.zzhom;
        } else if ((zzdvt instanceof zzdwo) && (zza2 = zzdwn.zza((zzdwo) zzdvt)) != null) {
            return new zzb(zza2);
        } else {
            boolean isCancelled = zzdvt.isCancelled();
            if ((!GENERATE_CANCELLATION_CAUSES) && isCancelled) {
                return zzc.zzhom;
            }
            try {
                Object uninterruptibly = getUninterruptibly(zzdvt);
                if (!isCancelled) {
                    return uninterruptibly == null ? NULL : uninterruptibly;
                }
                String valueOf = String.valueOf(zzdvt);
                StringBuilder sb = new StringBuilder(valueOf.length() + 84);
                sb.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
                sb.append(valueOf);
                return new zzc(false, new IllegalArgumentException(sb.toString()));
            } catch (ExecutionException e) {
                if (!isCancelled) {
                    return new zzb(e.getCause());
                }
                String valueOf2 = String.valueOf(zzdvt);
                return new zzc(false, new IllegalArgumentException(a.r2(valueOf2.length() + 84, "get() did not throw CancellationException, despite reporting isCancelled() == true: ", valueOf2), e));
            } catch (CancellationException e2) {
                if (isCancelled) {
                    return new zzc(false, e2);
                }
                String valueOf3 = String.valueOf(zzdvt);
                return new zzb(new IllegalArgumentException(a.r2(valueOf3.length() + 77, "get() threw CancellationException, despite reporting isCancelled() == false: ", valueOf3), e2));
            } catch (Throwable th) {
                return new zzb(th);
            }
        }
    }

    private static <V> V getUninterruptibly(Future<V> future) throws ExecutionException {
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

    private final void zza(zzk zzk2) {
        zzk2.thread = null;
        while (true) {
            zzk zzk3 = this.waiters;
            if (zzk3 != zzk.zzhov) {
                zzk zzk4 = null;
                while (zzk3 != null) {
                    zzk zzk5 = zzk3.next;
                    if (zzk3.thread != null) {
                        zzk4 = zzk3;
                    } else if (zzk4 != null) {
                        zzk4.next = zzk5;
                        if (zzk4.thread == null) {
                        }
                    } else if (zzhoj.zza((zzdui<?>) this, zzk3, zzk5)) {
                    }
                    zzk3 = zzk5;
                }
                return;
            }
            return;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    private static V zzae(Object obj) throws ExecutionException {
        if (obj instanceof zzc) {
            Throwable th = ((zzc) obj).cause;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        } else if (obj instanceof zzb) {
            throw new ExecutionException(((zzb) obj).exception);
        } else if (obj == NULL) {
            return null;
        } else {
            return obj;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvt
    public void addListener(Runnable runnable, Executor executor) {
        zzd zzd2;
        zzdsv.checkNotNull(runnable, "Runnable was null.");
        zzdsv.checkNotNull(executor, "Executor was null.");
        if (isDone() || (zzd2 = this.listeners) == zzd.zzhon) {
            zza(runnable, executor);
        }
        zzd zzd3 = new zzd(runnable, executor);
        do {
            zzd3.next = zzd2;
            if (!zzhoj.zza((zzdui<?>) this, zzd2, zzd3)) {
                zzd2 = this.listeners;
            } else {
                return;
            }
        } while (zzd2 != zzd.zzhon);
        zza(runnable, executor);
    }

    public void afterDone() {
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        zzc zzc2;
        Object obj = this.value;
        if (!(obj == null) && !(obj instanceof zze)) {
            return false;
        }
        if (GENERATE_CANCELLATION_CAUSES) {
            zzc2 = new zzc(z, new CancellationException("Future.cancel() was called."));
        } else if (z) {
            zzc2 = zzc.zzhol;
        } else {
            zzc2 = zzc.zzhom;
        }
        boolean z2 = false;
        zzdui<V> zzdui = this;
        while (true) {
            if (zzhoj.zza((zzdui<?>) zzdui, obj, (Object) zzc2)) {
                if (z) {
                    zzdui.interruptTask();
                }
                zza((zzdui<?>) zzdui);
                if (!(obj instanceof zze)) {
                    return true;
                }
                zzdvt<? extends V> zzdvt = ((zze) obj).future;
                if (zzdvt instanceof zzg) {
                    zzdui = (zzdui) zzdvt;
                    obj = zzdui.value;
                    if (!(obj == null) && !(obj instanceof zze)) {
                        return true;
                    }
                    z2 = true;
                } else {
                    zzdvt.cancel(z);
                    return true;
                }
            } else {
                obj = zzdui.value;
                if (!(obj instanceof zze)) {
                    return z2;
                }
            }
        }
    }

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long nanos = timeUnit.toNanos(j);
        if (!Thread.interrupted()) {
            Object obj = this.value;
            if ((obj != null) && (!(obj instanceof zze))) {
                return (V) zzae(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                zzk zzk2 = this.waiters;
                if (zzk2 != zzk.zzhov) {
                    zzk zzk3 = new zzk();
                    do {
                        zzk3.zzb(zzk2);
                        if (zzhoj.zza((zzdui<?>) this, zzk2, zzk3)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.value;
                                    if ((obj2 != null) && (!(obj2 instanceof zze))) {
                                        return (V) zzae(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    zza(zzk3);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            zza(zzk3);
                        } else {
                            zzk2 = this.waiters;
                        }
                    } while (zzk2 != zzk.zzhov);
                }
                return (V) zzae(this.value);
            }
            while (nanos > 0) {
                Object obj3 = this.value;
                if ((obj3 != null) && (!(obj3 instanceof zze))) {
                    return (V) zzae(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String zzdui = toString();
            String timeUnit2 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = timeUnit2.toLowerCase(locale);
            String lowerCase2 = timeUnit.toString().toLowerCase(locale);
            StringBuilder sb = new StringBuilder(a.q0(lowerCase2, 28));
            sb.append("Waited ");
            sb.append(j);
            sb.append(" ");
            sb.append(lowerCase2);
            String sb2 = sb.toString();
            if (nanos + 1000 < 0) {
                String concat = String.valueOf(sb2).concat(" (plus ");
                long j2 = -nanos;
                long convert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
                long nanos2 = j2 - timeUnit.toNanos(convert);
                int i = (convert > 0 ? 1 : (convert == 0 ? 0 : -1));
                boolean z = i == 0 || nanos2 > 1000;
                if (i > 0) {
                    String valueOf = String.valueOf(concat);
                    StringBuilder sb3 = new StringBuilder(a.q0(lowerCase, valueOf.length() + 21));
                    sb3.append(valueOf);
                    sb3.append(convert);
                    sb3.append(" ");
                    sb3.append(lowerCase);
                    String sb4 = sb3.toString();
                    if (z) {
                        sb4 = String.valueOf(sb4).concat(",");
                    }
                    concat = String.valueOf(sb4).concat(" ");
                }
                if (z) {
                    String valueOf2 = String.valueOf(concat);
                    StringBuilder sb5 = new StringBuilder(valueOf2.length() + 33);
                    sb5.append(valueOf2);
                    sb5.append(nanos2);
                    sb5.append(" nanoseconds ");
                    concat = sb5.toString();
                }
                sb2 = String.valueOf(concat).concat("delay)");
            }
            if (isDone()) {
                throw new TimeoutException(String.valueOf(sb2).concat(" but future completed as timeout expired"));
            }
            throw new TimeoutException(a.s2(a.q0(zzdui, a.q0(sb2, 5)), sb2, " for ", zzdui));
        }
        throw new InterruptedException();
    }

    public void interruptTask() {
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.value instanceof zzc;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        Object obj = this.value;
        return (!(obj instanceof zze)) & (obj != null);
    }

    public final void maybePropagateCancellationTo(@NullableDecl Future<?> future) {
        if ((future != null) && isCancelled()) {
            future.cancel(wasInterrupted());
        }
    }

    @NullableDecl
    public String pendingToString() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        long delay = ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS);
        StringBuilder sb = new StringBuilder(41);
        sb.append("remaining delay=[");
        sb.append(delay);
        sb.append(" ms]");
        return sb.toString();
    }

    public boolean set(@NullableDecl V v) {
        if (v == null) {
            v = (V) NULL;
        }
        if (!zzhoj.zza((zzdui<?>) this, (Object) null, (Object) v)) {
            return false;
        }
        zza((zzdui<?>) this);
        return true;
    }

    public boolean setException(Throwable th) {
        if (!zzhoj.zza((zzdui<?>) this, (Object) null, (Object) new zzb((Throwable) zzdsv.checkNotNull(th)))) {
            return false;
        }
        zza((zzdui<?>) this);
        return true;
    }

    public final boolean setFuture(zzdvt<? extends V> zzdvt) {
        zze zze2;
        zzb zzb2;
        zzdsv.checkNotNull(zzdvt);
        Object obj = this.value;
        if (obj == null) {
            if (zzdvt.isDone()) {
                if (!zzhoj.zza((zzdui<?>) this, (Object) null, getFutureValue(zzdvt))) {
                    return false;
                }
                zza((zzdui<?>) this);
                return true;
            }
            zze2 = new zze(this, zzdvt);
            if (zzhoj.zza((zzdui<?>) this, (Object) null, (Object) zze2)) {
                try {
                    zzdvt.addListener(zze2, zzdva.INSTANCE);
                } catch (Throwable unused) {
                    zzb2 = zzb.zzhok;
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof zzc) {
            zzdvt.cancel(((zzc) obj).wasInterrupted);
        }
        return false;
        zzhoj.zza((zzdui<?>) this, (Object) zze2, (Object) zzb2);
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
            zza(sb);
        } else {
            int length = sb.length();
            sb.append("PENDING");
            Object obj = this.value;
            if (obj instanceof zze) {
                sb.append(", setFuture=[");
                zza(sb, ((zze) obj).future);
                sb.append("]");
            } else {
                try {
                    str = zzdsw.emptyToNull(pendingToString());
                } catch (RuntimeException | StackOverflowError e) {
                    String valueOf = String.valueOf(e.getClass());
                    str = a.r2(valueOf.length() + 38, "Exception thrown from implementation: ", valueOf);
                }
                if (str != null) {
                    a.m1(sb, ", info=[", str, "]");
                }
            }
            if (isDone()) {
                sb.delete(length, sb.length());
                zza(sb);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public final boolean wasInterrupted() {
        Object obj = this.value;
        return (obj instanceof zzc) && ((zzc) obj).wasInterrupted;
    }

    @Override // com.google.android.gms.internal.ads.zzdwo
    @NullableDecl
    public final Throwable zzaxa() {
        if (!(this instanceof zzg)) {
            return null;
        }
        Object obj = this.value;
        if (obj instanceof zzb) {
            return ((zzb) obj).exception;
        }
        return null;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0002 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x0002 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.android.gms.internal.ads.zzdui<?>] */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.google.android.gms.internal.ads.zzdui] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v7, types: [com.google.android.gms.internal.ads.zzdui<V>, com.google.android.gms.internal.ads.zzdui] */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.google.android.gms.internal.ads.zzdui$zza] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void zza(com.google.android.gms.internal.ads.zzdui<?> r5) {
        /*
            r0 = 0
            r1 = r0
        L_0x0002:
            com.google.android.gms.internal.ads.zzdui$zzk r2 = r5.waiters
            com.google.android.gms.internal.ads.zzdui$zza r3 = com.google.android.gms.internal.ads.zzdui.zzhoj
            com.google.android.gms.internal.ads.zzdui$zzk r4 = com.google.android.gms.internal.ads.zzdui.zzk.zzhov
            boolean r3 = r3.zza(r5, r2, r4)
            if (r3 == 0) goto L_0x0002
        L_0x000e:
            if (r2 == 0) goto L_0x001c
            java.lang.Thread r3 = r2.thread
            if (r3 == 0) goto L_0x0019
            r2.thread = r0
            java.util.concurrent.locks.LockSupport.unpark(r3)
        L_0x0019:
            com.google.android.gms.internal.ads.zzdui$zzk r2 = r2.next
            goto L_0x000e
        L_0x001c:
            r5.afterDone()
        L_0x001f:
            com.google.android.gms.internal.ads.zzdui$zzd r2 = r5.listeners
            com.google.android.gms.internal.ads.zzdui$zza r3 = com.google.android.gms.internal.ads.zzdui.zzhoj
            com.google.android.gms.internal.ads.zzdui$zzd r4 = com.google.android.gms.internal.ads.zzdui.zzd.zzhon
            boolean r3 = r3.zza(r5, r2, r4)
            if (r3 == 0) goto L_0x001f
        L_0x002b:
            r5 = r1
            r1 = r2
            if (r1 == 0) goto L_0x0034
            com.google.android.gms.internal.ads.zzdui$zzd r2 = r1.next
            r1.next = r5
            goto L_0x002b
        L_0x0034:
            if (r5 == 0) goto L_0x005c
            com.google.android.gms.internal.ads.zzdui$zzd r1 = r5.next
            java.lang.Runnable r2 = r5.task
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzdui.zze
            if (r3 == 0) goto L_0x0055
            com.google.android.gms.internal.ads.zzdui$zze r2 = (com.google.android.gms.internal.ads.zzdui.zze) r2
            com.google.android.gms.internal.ads.zzdui<V> r5 = r2.zzhoo
            java.lang.Object r3 = r5.value
            if (r3 != r2) goto L_0x005a
            com.google.android.gms.internal.ads.zzdvt<? extends V> r3 = r2.future
            java.lang.Object r3 = getFutureValue(r3)
            com.google.android.gms.internal.ads.zzdui$zza r4 = com.google.android.gms.internal.ads.zzdui.zzhoj
            boolean r2 = r4.zza(r5, r2, r3)
            if (r2 != 0) goto L_0x0002
            goto L_0x005a
        L_0x0055:
            java.util.concurrent.Executor r5 = r5.executor
            zza(r2, r5)
        L_0x005a:
            r5 = r1
            goto L_0x0034
        L_0x005c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdui.zza(com.google.android.gms.internal.ads.zzdui):void");
    }

    private final void zza(StringBuilder sb) {
        try {
            Object uninterruptibly = getUninterruptibly(this);
            sb.append("SUCCESS, result=[");
            zza(sb, uninterruptibly);
            sb.append("]");
        } catch (ExecutionException e) {
            sb.append("FAILURE, cause=[");
            sb.append(e.getCause());
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            sb.append(" thrown from get()]");
        }
    }

    private final void zza(StringBuilder sb, Object obj) {
        if (obj == this) {
            try {
                sb.append("this future");
            } catch (RuntimeException | StackOverflowError e) {
                sb.append("Exception thrown from implementation: ");
                sb.append(e.getClass());
            }
        } else {
            sb.append(obj);
        }
    }

    private static void zza(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Logger logger = zzhoi;
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "executeListener", a.t2(valueOf2.length() + valueOf.length() + 57, "RuntimeException while executing runnable ", valueOf, " with executor ", valueOf2), (Throwable) e);
        }
    }

    @Override // java.util.concurrent.Future
    public V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.value;
            if ((obj2 != null) && (!(obj2 instanceof zze))) {
                return (V) zzae(obj2);
            }
            zzk zzk2 = this.waiters;
            if (zzk2 != zzk.zzhov) {
                zzk zzk3 = new zzk();
                do {
                    zzk3.zzb(zzk2);
                    if (zzhoj.zza((zzdui<?>) this, zzk2, zzk3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.value;
                            } else {
                                zza(zzk3);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof zze))));
                        return (V) zzae(obj);
                    }
                    zzk2 = this.waiters;
                } while (zzk2 != zzk.zzhov);
            }
            return (V) zzae(this.value);
        }
        throw new InterruptedException();
    }
}
