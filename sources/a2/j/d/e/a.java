package a2.j.d.e;

import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
public abstract class a {

    public static final class b extends a {
        public final ConcurrentLinkedQueue<C0069a> a = Queues.newConcurrentLinkedQueue();

        /* renamed from: a2.j.d.e.a$b$a  reason: collision with other inner class name */
        public static final class C0069a {
            public final Object a;
            public final c b;

            public C0069a(Object obj, c cVar, C0068a aVar) {
                this.a = obj;
                this.b = cVar;
            }
        }

        public b(C0068a aVar) {
        }

        @Override // a2.j.d.e.a
        public void a(Object obj, Iterator<c> it) {
            Preconditions.checkNotNull(obj);
            while (it.hasNext()) {
                this.a.add(new C0069a(obj, it.next(), null));
            }
            while (true) {
                C0069a poll = this.a.poll();
                if (poll != null) {
                    c cVar = poll.b;
                    cVar.d.execute(new b(cVar, poll.a));
                } else {
                    return;
                }
            }
        }
    }

    public static final class c extends a {
        public final ThreadLocal<Queue<C0071c>> a = new C0070a(this);
        public final ThreadLocal<Boolean> b = new b(this);

        /* renamed from: a2.j.d.e.a$c$a  reason: collision with other inner class name */
        public class C0070a extends ThreadLocal<Queue<C0071c>> {
            public C0070a(c cVar) {
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // java.lang.ThreadLocal
            public Queue<C0071c> initialValue() {
                return Queues.newArrayDeque();
            }
        }

        public class b extends ThreadLocal<Boolean> {
            public b(c cVar) {
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // java.lang.ThreadLocal
            public /* bridge */ /* synthetic */ Boolean initialValue() {
                return Boolean.FALSE;
            }
        }

        /* renamed from: a2.j.d.e.a$c$c  reason: collision with other inner class name */
        public static final class C0071c {
            public final Object a;
            public final Iterator<c> b;

            public C0071c(Object obj, Iterator it, C0068a aVar) {
                this.a = obj;
                this.b = it;
            }
        }

        public c(C0068a aVar) {
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x0051 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:6:0x0034 A[Catch:{ all -> 0x005c }, LOOP:1: B:6:0x0034->B:8:0x003c, LOOP_START] */
        @Override // a2.j.d.e.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(java.lang.Object r5, java.util.Iterator<a2.j.d.e.c> r6) {
            /*
                r4 = this;
                com.google.common.base.Preconditions.checkNotNull(r5)
                com.google.common.base.Preconditions.checkNotNull(r6)
                java.lang.ThreadLocal<java.util.Queue<a2.j.d.e.a$c$c>> r0 = r4.a
                java.lang.Object r0 = r0.get()
                java.util.Queue r0 = (java.util.Queue) r0
                a2.j.d.e.a$c$c r1 = new a2.j.d.e.a$c$c
                r2 = 0
                r1.<init>(r5, r6, r2)
                r0.offer(r1)
                java.lang.ThreadLocal<java.lang.Boolean> r5 = r4.b
                java.lang.Object r5 = r5.get()
                java.lang.Boolean r5 = (java.lang.Boolean) r5
                boolean r5 = r5.booleanValue()
                if (r5 != 0) goto L_0x0068
                java.lang.ThreadLocal<java.lang.Boolean> r5 = r4.b
                java.lang.Boolean r6 = java.lang.Boolean.TRUE
                r5.set(r6)
            L_0x002c:
                java.lang.Object r5 = r0.poll()     // Catch:{ all -> 0x005c }
                a2.j.d.e.a$c$c r5 = (a2.j.d.e.a.c.C0071c) r5     // Catch:{ all -> 0x005c }
                if (r5 == 0) goto L_0x0051
            L_0x0034:
                java.util.Iterator<a2.j.d.e.c> r6 = r5.b     // Catch:{ all -> 0x005c }
                boolean r6 = r6.hasNext()     // Catch:{ all -> 0x005c }
                if (r6 == 0) goto L_0x002c
                java.util.Iterator<a2.j.d.e.c> r6 = r5.b     // Catch:{ all -> 0x005c }
                java.lang.Object r6 = r6.next()     // Catch:{ all -> 0x005c }
                a2.j.d.e.c r6 = (a2.j.d.e.c) r6     // Catch:{ all -> 0x005c }
                java.lang.Object r1 = r5.a     // Catch:{ all -> 0x005c }
                java.util.concurrent.Executor r2 = r6.d     // Catch:{ all -> 0x005c }
                a2.j.d.e.b r3 = new a2.j.d.e.b     // Catch:{ all -> 0x005c }
                r3.<init>(r6, r1)     // Catch:{ all -> 0x005c }
                r2.execute(r3)     // Catch:{ all -> 0x005c }
                goto L_0x0034
            L_0x0051:
                java.lang.ThreadLocal<java.lang.Boolean> r5 = r4.b
                r5.remove()
                java.lang.ThreadLocal<java.util.Queue<a2.j.d.e.a$c$c>> r5 = r4.a
                r5.remove()
                goto L_0x0068
            L_0x005c:
                r5 = move-exception
                java.lang.ThreadLocal<java.lang.Boolean> r6 = r4.b
                r6.remove()
                java.lang.ThreadLocal<java.util.Queue<a2.j.d.e.a$c$c>> r6 = r4.a
                r6.remove()
                throw r5
            L_0x0068:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: a2.j.d.e.a.c.a(java.lang.Object, java.util.Iterator):void");
        }
    }

    public static a b() {
        return new b(null);
    }

    public abstract void a(Object obj, Iterator<c> it);
}
