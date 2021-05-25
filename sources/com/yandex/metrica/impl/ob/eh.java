package com.yandex.metrica.impl.ob;

import android.support.annotation.VisibleForTesting;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
public class eh {
    private final acx a;
    private volatile boolean b = true;
    private final BlockingQueue<a> c = new LinkedBlockingQueue();
    private ConcurrentHashMap<Class, CopyOnWriteArrayList<el<? extends ej>>> d = new ConcurrentHashMap<>();
    private WeakHashMap<Object, CopyOnWriteArrayList<c>> e = new WeakHashMap<>();
    private ConcurrentHashMap<Class, ej> f = new ConcurrentHashMap<>();

    public static class a {
        private final ej a;
        private final el<? extends ej> b;

        public void a() {
            try {
                if (!this.b.b(this.a)) {
                    this.b.a(this.a);
                }
            } catch (Throwable unused) {
            }
        }

        private a(ej ejVar, el<? extends ej> elVar) {
            this.a = ejVar;
            this.b = elVar;
        }
    }

    public static final class b {
        private static final eh a = new eh();
    }

    public static class c {
        public final CopyOnWriteArrayList<el<? extends ej>> a;
        public final el<? extends ej> b;

        public void a() {
            this.a.remove(this.b);
        }

        public void finalize() throws Throwable {
            super.finalize();
            a();
        }

        private c(CopyOnWriteArrayList<el<? extends ej>> copyOnWriteArrayList, el<? extends ej> elVar) {
            this.a = copyOnWriteArrayList;
            this.b = elVar;
        }
    }

    @VisibleForTesting
    public eh() {
        acx a3 = acy.a("YMM-BD", new Runnable() { // from class: com.yandex.metrica.impl.ob.eh.1
            @Override // java.lang.Runnable
            public void run() {
                while (eh.this.b) {
                    try {
                        ((a) eh.this.c.take()).a();
                    } catch (InterruptedException unused) {
                    }
                }
            }
        });
        this.a = a3;
        a3.start();
    }

    public static final eh a() {
        return b.a;
    }

    public synchronized void b(ej ejVar) {
        a(ejVar);
        this.f.put(ejVar.getClass(), ejVar);
    }

    public synchronized void a(ej ejVar) {
        CopyOnWriteArrayList<el<? extends ej>> copyOnWriteArrayList = this.d.get(ejVar.getClass());
        if (copyOnWriteArrayList != null) {
            Iterator<el<? extends ej>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                a(ejVar, it.next());
            }
        }
    }

    @VisibleForTesting
    public void a(ej ejVar, el<? extends ej> elVar) {
        this.c.add(new a(ejVar, elVar));
    }

    public synchronized void a(Class<? extends ej> cls) {
        this.f.remove(cls);
    }

    public synchronized void a(Object obj, Class cls, el<? extends ej> elVar) {
        CopyOnWriteArrayList<el<? extends ej>> copyOnWriteArrayList = this.d.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.d.put(cls, copyOnWriteArrayList);
        }
        copyOnWriteArrayList.add(elVar);
        CopyOnWriteArrayList<c> copyOnWriteArrayList2 = this.e.get(obj);
        if (copyOnWriteArrayList2 == null) {
            copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
            this.e.put(obj, copyOnWriteArrayList2);
        }
        copyOnWriteArrayList2.add(new c(copyOnWriteArrayList, elVar));
        ej ejVar = this.f.get(cls);
        if (ejVar != null) {
            a(ejVar, elVar);
        }
    }

    public synchronized void a(Object obj) {
        CopyOnWriteArrayList<c> remove = this.e.remove(obj);
        if (remove != null) {
            for (c cVar : remove) {
                cVar.a();
            }
        }
    }
}
