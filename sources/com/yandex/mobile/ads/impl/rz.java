package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
public final class rz {
    private AtomicInteger a;
    private final Map<String, Queue<ry<?>>> b;
    private final Set<ry<?>> c;
    private final PriorityBlockingQueue<ry<?>> d;
    private final PriorityBlockingQueue<ry<?>> e;
    private final rr f;
    private final rv g;
    private final sb h;
    private rw[] i;
    private rs j;
    private List<Object> k;

    public interface a {
        boolean a(ry<?> ryVar);
    }

    private rz(rr rrVar, rv rvVar, int i2, sb sbVar) {
        this.a = new AtomicInteger();
        this.b = new HashMap();
        this.c = new HashSet();
        this.d = new PriorityBlockingQueue<>();
        this.e = new PriorityBlockingQueue<>();
        this.k = new ArrayList();
        this.f = rrVar;
        this.g = rvVar;
        this.i = new rw[i2];
        this.h = sbVar;
    }

    public final void a(a aVar) {
        synchronized (this.c) {
            for (ry<?> ryVar : this.c) {
                if (aVar.a(ryVar)) {
                    ryVar.i();
                }
            }
        }
    }

    public final <T> void b(ry<T> ryVar) {
        synchronized (this.c) {
            this.c.remove(ryVar);
        }
        synchronized (this.k) {
            Iterator<Object> it = this.k.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        if (ryVar.m()) {
            synchronized (this.b) {
                String b2 = ryVar.b();
                Queue<ry<?>> remove = this.b.remove(b2);
                if (remove != null) {
                    if (sd.b) {
                        sd.a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), b2);
                    }
                    this.d.addAll(remove);
                }
            }
        }
    }

    public final <T> ry<T> a(ry<T> ryVar) {
        ryVar.a(this);
        synchronized (this.c) {
            this.c.add(ryVar);
        }
        ryVar.b(this.a.incrementAndGet());
        if (!ryVar.m()) {
            this.e.add(ryVar);
            return ryVar;
        }
        synchronized (this.b) {
            String b2 = ryVar.b();
            if (this.b.containsKey(b2)) {
                Queue<ry<?>> queue = this.b.get(b2);
                if (queue == null) {
                    queue = new LinkedList<>();
                }
                queue.add(ryVar);
                this.b.put(b2, queue);
                if (sd.b) {
                    sd.a("Request for cacheKey=%s is in flight, putting on hold.", b2);
                }
            } else {
                this.b.put(b2, null);
                this.d.add(ryVar);
            }
        }
        return ryVar;
    }

    public rz(rr rrVar, rv rvVar, int i2) {
        this(rrVar, rvVar, i2, new ru(new Handler(Looper.getMainLooper())));
    }

    public final void a() {
        rs rsVar = this.j;
        if (rsVar != null) {
            rsVar.a();
        }
        int i2 = 0;
        while (true) {
            rw[] rwVarArr = this.i;
            if (i2 >= rwVarArr.length) {
                break;
            }
            if (rwVarArr[i2] != null) {
                rwVarArr[i2].a();
            }
            i2++;
        }
        rs rsVar2 = new rs(this.d, this.e, this.f, this.h);
        this.j = rsVar2;
        rsVar2.start();
        for (int i3 = 0; i3 < this.i.length; i3++) {
            rw rwVar = new rw(this.e, this.g, this.f, this.h);
            this.i[i3] = rwVar;
            rwVar.start();
        }
    }
}
