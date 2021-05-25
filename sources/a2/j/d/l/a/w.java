package a2.j.d.l.a;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
@GwtIncompatible
public final class w<L> {
    public static final Logger b = Logger.getLogger(w.class.getName());
    public final List<b<L>> a = Collections.synchronizedList(new ArrayList());

    public interface a<L> {
        void a(L l);
    }

    public static final class b<L> implements Runnable {
        public final L a;
        public final Executor b;
        @GuardedBy("this")
        public final Queue<a<L>> c = Queues.newArrayDeque();
        @GuardedBy("this")
        public final Queue<Object> d = Queues.newArrayDeque();
        @GuardedBy("this")
        public boolean e;

        public b(L l, Executor executor) {
            this.a = (L) Preconditions.checkNotNull(l);
            this.b = (Executor) Preconditions.checkNotNull(executor);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:23:0x004f, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0050, code lost:
            r2 = r0;
            r0 = r2;
         */
        @Override // java.lang.Runnable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r9 = this;
            L_0x0000:
                r0 = 1
                r1 = 0
                monitor-enter(r9)     // Catch:{ all -> 0x0056 }
                boolean r2 = r9.e     // Catch:{ all -> 0x004a }
                com.google.common.base.Preconditions.checkState(r2)     // Catch:{ all -> 0x004a }
                java.util.Queue<a2.j.d.l.a.w$a<L>> r2 = r9.c     // Catch:{ all -> 0x004a }
                java.lang.Object r2 = r2.poll()     // Catch:{ all -> 0x004a }
                a2.j.d.l.a.w$a r2 = (a2.j.d.l.a.w.a) r2     // Catch:{ all -> 0x004a }
                java.util.Queue<java.lang.Object> r3 = r9.d     // Catch:{ all -> 0x004a }
                java.lang.Object r3 = r3.poll()     // Catch:{ all -> 0x004a }
                if (r2 != 0) goto L_0x001f
                r9.e = r1     // Catch:{ all -> 0x004a }
                monitor-exit(r9)     // Catch:{ all -> 0x001c }
                return
            L_0x001c:
                r0 = move-exception
                r2 = 0
                goto L_0x004d
            L_0x001f:
                monitor-exit(r9)
                L r4 = r9.a     // Catch:{ RuntimeException -> 0x0026 }
                r2.a(r4)     // Catch:{ RuntimeException -> 0x0026 }
                goto L_0x0000
            L_0x0026:
                r2 = move-exception
                java.util.logging.Logger r4 = a2.j.d.l.a.w.b
                java.util.logging.Level r5 = java.util.logging.Level.SEVERE
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r7 = "Exception while executing callback: "
                r6.append(r7)
                L r7 = r9.a
                r6.append(r7)
                java.lang.String r7 = " "
                r6.append(r7)
                r6.append(r3)
                java.lang.String r3 = r6.toString()
                r4.log(r5, r3, r2)
                goto L_0x0000
            L_0x004a:
                r2 = move-exception
                r0 = r2
                r2 = 1
            L_0x004d:
                monitor-exit(r9)     // Catch:{ all -> 0x0054 }
                throw r0     // Catch:{ all -> 0x004f }
            L_0x004f:
                r0 = move-exception
                r8 = r2
                r2 = r0
                r0 = r8
                goto L_0x0057
            L_0x0054:
                r0 = move-exception
                goto L_0x004d
            L_0x0056:
                r2 = move-exception
            L_0x0057:
                if (r0 == 0) goto L_0x0061
                monitor-enter(r9)
                r9.e = r1     // Catch:{ all -> 0x005e }
                monitor-exit(r9)     // Catch:{ all -> 0x005e }
                goto L_0x0061
            L_0x005e:
                r0 = move-exception
                monitor-exit(r9)     // Catch:{ all -> 0x005e }
                throw r0
            L_0x0061:
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: a2.j.d.l.a.w.b.run():void");
        }
    }

    public void a() {
        boolean z;
        for (int i = 0; i < this.a.size(); i++) {
            b<L> bVar = this.a.get(i);
            synchronized (bVar) {
                z = true;
                if (!bVar.e) {
                    bVar.e = true;
                } else {
                    z = false;
                }
            }
            if (z) {
                try {
                    bVar.b.execute(bVar);
                } catch (RuntimeException e) {
                    synchronized (bVar) {
                        bVar.e = false;
                        Logger logger = b;
                        Level level = Level.SEVERE;
                        StringBuilder L = a2.b.a.a.a.L("Exception while running callbacks for ");
                        L.append((Object) bVar.a);
                        L.append(" on ");
                        L.append(bVar.b);
                        logger.log(level, L.toString(), (Throwable) e);
                        throw e;
                    }
                }
            }
        }
    }

    public void b(a<L> aVar) {
        Preconditions.checkNotNull(aVar, "event");
        Preconditions.checkNotNull(aVar, "label");
        synchronized (this.a) {
            for (b<L> bVar : this.a) {
                synchronized (bVar) {
                    bVar.c.add(aVar);
                    bVar.d.add(aVar);
                }
            }
        }
    }
}
