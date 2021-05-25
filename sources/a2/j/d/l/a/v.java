package a2.j.d.l.a;

import com.google.common.annotations.GwtCompatible;
import com.google.j2objc.annotations.ReflectionSupport;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true)
@ReflectionSupport(ReflectionSupport.Level.FULL)
public abstract class v<T> extends AtomicReference<Runnable> implements Runnable {
    public static final Runnable a = new b(null);
    public static final Runnable b = new b(null);
    public static final Runnable c = new b(null);

    public static final class b implements Runnable {
        public b(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public abstract void a(@NullableDecl T t, @NullableDecl Throwable th);

    public final void b() {
        Runnable runnable = (Runnable) get();
        if ((runnable instanceof Thread) && compareAndSet(runnable, b)) {
            try {
                ((Thread) runnable).interrupt();
            } finally {
                if (((Runnable) getAndSet(a)) == c) {
                    LockSupport.unpark((Thread) runnable);
                }
            }
        }
    }

    public abstract boolean c();

    public abstract T d() throws Exception;

    public abstract String e();

    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: a2.j.d.l.a.v<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        Thread currentThread = Thread.currentThread();
        if (compareAndSet(null, currentThread)) {
            boolean z = !c();
            if (z) {
                try {
                    obj = d();
                } catch (Throwable th) {
                    if (!compareAndSet(currentThread, a)) {
                        Runnable runnable = (Runnable) get();
                        boolean z2 = false;
                        int i = 0;
                        while (true) {
                            Runnable runnable2 = b;
                            if (runnable != runnable2 && runnable != c) {
                                break;
                            }
                            i++;
                            if (i > 1000) {
                                Runnable runnable3 = c;
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
                        a(null, th);
                        return;
                    }
                    return;
                }
            } else {
                obj = null;
            }
            if (!compareAndSet(currentThread, a)) {
                Runnable runnable4 = (Runnable) get();
                boolean z3 = false;
                int i2 = 0;
                while (true) {
                    Runnable runnable5 = b;
                    if (runnable4 != runnable5 && runnable4 != c) {
                        break;
                    }
                    i2++;
                    if (i2 > 1000) {
                        Runnable runnable6 = c;
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
                a(obj, null);
            }
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference, java.lang.Object
    public final String toString() {
        String str;
        Runnable runnable = (Runnable) get();
        if (runnable == a) {
            str = "running=[DONE]";
        } else if (runnable == b) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            StringBuilder L = a2.b.a.a.a.L("running=[RUNNING ON ");
            L.append(((Thread) runnable).getName());
            L.append("]");
            str = L.toString();
        } else {
            str = "running=[NOT STARTED YET]";
        }
        StringBuilder Q = a2.b.a.a.a.Q(str, ", ");
        Q.append(e());
        return Q.toString();
    }
}
