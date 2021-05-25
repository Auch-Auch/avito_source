package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public abstract class zzdvs<T> extends AtomicReference<Runnable> implements Runnable {
    private static final Runnable zzhpx = new zzdvu();
    private static final Runnable zzhpy = new zzdvu();
    private static final Runnable zzhpz = new zzdvu();

    public final void interruptTask() {
        Runnable runnable = (Runnable) get();
        if ((runnable instanceof Thread) && compareAndSet(runnable, zzhpy)) {
            try {
                ((Thread) runnable).interrupt();
            } finally {
                if (((Runnable) getAndSet(zzhpx)) == zzhpz) {
                    LockSupport.unpark((Thread) runnable);
                }
            }
        }
    }

    public abstract boolean isDone();

    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: com.google.android.gms.internal.ads.zzdvs<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        Thread currentThread = Thread.currentThread();
        if (compareAndSet(null, currentThread)) {
            boolean z = !isDone();
            if (z) {
                try {
                    obj = zzaxi();
                } catch (Throwable th) {
                    if (!compareAndSet(currentThread, zzhpx)) {
                        Runnable runnable = (Runnable) get();
                        boolean z2 = false;
                        int i = 0;
                        while (true) {
                            Runnable runnable2 = zzhpy;
                            if (runnable != runnable2 && runnable != zzhpz) {
                                break;
                            }
                            i++;
                            if (i > 1000) {
                                Runnable runnable3 = zzhpz;
                                if (runnable == runnable3 || compareAndSet(runnable2, runnable3)) {
                                    z2 = Thread.interrupted() || z2;
                                    LockSupport.park(this);
                                }
                            } else {
                                Thread.yield();
                            }
                            runnable = (Runnable) get();
                        }
                        if (z2) {
                            currentThread.interrupt();
                        }
                    }
                    if (z) {
                        zzb(null, th);
                        return;
                    }
                    return;
                }
            } else {
                obj = null;
            }
            if (!compareAndSet(currentThread, zzhpx)) {
                Runnable runnable4 = (Runnable) get();
                boolean z3 = false;
                int i2 = 0;
                while (true) {
                    Runnable runnable5 = zzhpy;
                    if (runnable4 != runnable5 && runnable4 != zzhpz) {
                        break;
                    }
                    i2++;
                    if (i2 > 1000) {
                        Runnable runnable6 = zzhpz;
                        if (runnable4 == runnable6 || compareAndSet(runnable5, runnable6)) {
                            z3 = Thread.interrupted() || z3;
                            LockSupport.park(this);
                        }
                    } else {
                        Thread.yield();
                    }
                    runnable4 = (Runnable) get();
                }
                if (z3) {
                    currentThread.interrupt();
                }
            }
            if (z) {
                zzb(obj, null);
            }
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference, java.lang.Object
    public final String toString() {
        String str;
        Runnable runnable = (Runnable) get();
        if (runnable == zzhpx) {
            str = "running=[DONE]";
        } else if (runnable == zzhpy) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            String name = ((Thread) runnable).getName();
            str = a.s2(a.q0(name, 21), "running=[RUNNING ON ", name, "]");
        } else {
            str = "running=[NOT STARTED YET]";
        }
        String zzaxj = zzaxj();
        return a.s2(a.q0(zzaxj, a.q0(str, 2)), str, ", ", zzaxj);
    }

    public abstract T zzaxi() throws Exception;

    public abstract String zzaxj();

    public abstract void zzb(@NullableDecl T t, @NullableDecl Throwable th);
}
