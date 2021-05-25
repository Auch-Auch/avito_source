package a2.j.d.l.a;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Logger;
@GwtIncompatible
public final class a0 implements Executor {
    public static final Logger f = Logger.getLogger(a0.class.getName());
    public final Executor a;
    @GuardedBy("queue")
    public final Deque<Runnable> b = new ArrayDeque();
    @GuardedBy("queue")
    public c c = c.IDLE;
    @GuardedBy("queue")
    public long d = 0;
    public final b e = new b(null);

    public class a implements Runnable {
        public final /* synthetic */ Runnable a;

        public a(a0 a0Var, Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.run();
        }
    }

    public final class b implements Runnable {
        public b(a aVar) {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0014, code lost:
            java.lang.Thread.currentThread().interrupt();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0044, code lost:
            r1 = r1 | java.lang.Thread.interrupted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            r3.run();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x004d, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x004e, code lost:
            a2.j.d.l.a.a0.f.log(java.util.logging.Level.SEVERE, "Exception while executing runnable " + r3, (java.lang.Throwable) r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
            if (r1 == false) goto L_?;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a() {
            /*
                r9 = this;
                r0 = 0
                r1 = 0
            L_0x0002:
                a2.j.d.l.a.a0 r2 = a2.j.d.l.a.a0.this     // Catch:{ all -> 0x006a }
                java.util.Deque<java.lang.Runnable> r2 = r2.b     // Catch:{ all -> 0x006a }
                monitor-enter(r2)     // Catch:{ all -> 0x006a }
                if (r0 != 0) goto L_0x0026
                a2.j.d.l.a.a0 r0 = a2.j.d.l.a.a0.this     // Catch:{ all -> 0x0067 }
                a2.j.d.l.a.a0$c r3 = r0.c     // Catch:{ all -> 0x0067 }
                a2.j.d.l.a.a0$c r4 = a2.j.d.l.a.a0.c.RUNNING     // Catch:{ all -> 0x0067 }
                if (r3 != r4) goto L_0x001c
                monitor-exit(r2)     // Catch:{ all -> 0x0067 }
                if (r1 == 0) goto L_0x001b
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
            L_0x001b:
                return
            L_0x001c:
                long r5 = r0.d
                r7 = 1
                long r5 = r5 + r7
                r0.d = r5
                r0.c = r4
                r0 = 1
            L_0x0026:
                a2.j.d.l.a.a0 r3 = a2.j.d.l.a.a0.this
                java.util.Deque<java.lang.Runnable> r3 = r3.b
                java.lang.Object r3 = r3.poll()
                java.lang.Runnable r3 = (java.lang.Runnable) r3
                if (r3 != 0) goto L_0x0043
                a2.j.d.l.a.a0 r0 = a2.j.d.l.a.a0.this
                a2.j.d.l.a.a0$c r3 = a2.j.d.l.a.a0.c.IDLE
                r0.c = r3
                monitor-exit(r2)
                if (r1 == 0) goto L_0x0042
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
            L_0x0042:
                return
            L_0x0043:
                monitor-exit(r2)
                boolean r2 = java.lang.Thread.interrupted()
                r1 = r1 | r2
                r3.run()     // Catch:{ RuntimeException -> 0x004d }
                goto L_0x0002
            L_0x004d:
                r2 = move-exception
                java.util.logging.Logger r4 = a2.j.d.l.a.a0.f
                java.util.logging.Level r5 = java.util.logging.Level.SEVERE
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r7 = "Exception while executing runnable "
                r6.append(r7)
                r6.append(r3)
                java.lang.String r3 = r6.toString()
                r4.log(r5, r3, r2)
                goto L_0x0002
            L_0x0067:
                r0 = move-exception
                monitor-exit(r2)
                throw r0
            L_0x006a:
                r0 = move-exception
                if (r1 == 0) goto L_0x0074
                java.lang.Thread r1 = java.lang.Thread.currentThread()
                r1.interrupt()
            L_0x0074:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: a2.j.d.l.a.a0.b.a():void");
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a();
            } catch (Error e) {
                synchronized (a0.this.b) {
                    a0.this.c = c.IDLE;
                    throw e;
                }
            }
        }
    }

    public enum c {
        IDLE,
        QUEUING,
        QUEUED,
        RUNNING
    }

    public a0(Executor executor) {
        this.a = (Executor) Preconditions.checkNotNull(executor);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        c cVar;
        long j;
        a aVar;
        c cVar2 = c.QUEUING;
        Preconditions.checkNotNull(runnable);
        synchronized (this.b) {
            c cVar3 = this.c;
            if (cVar3 != c.RUNNING) {
                cVar = c.QUEUED;
                if (cVar3 != cVar) {
                    j = this.d;
                    aVar = new a(this, runnable);
                    this.b.add(aVar);
                    this.c = cVar2;
                }
            }
            this.b.add(runnable);
            return;
        }
        boolean z = true;
        try {
            this.a.execute(this.e);
            if (this.c == cVar2) {
                z = false;
            }
            if (!z) {
                synchronized (this.b) {
                    if (this.d == j && this.c == cVar2) {
                        this.c = cVar;
                    }
                }
            }
        } catch (Error | RuntimeException e2) {
            synchronized (this.b) {
                c cVar4 = this.c;
                if ((cVar4 != c.IDLE && cVar4 != cVar2) || !this.b.removeLastOccurrence(aVar)) {
                    z = false;
                }
                if (!(e2 instanceof RejectedExecutionException) || z) {
                    throw e2;
                }
            }
        }
    }
}
