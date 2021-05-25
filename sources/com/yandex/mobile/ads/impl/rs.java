package com.yandex.mobile.ads.impl;

import android.os.Process;
import com.yandex.mobile.ads.impl.rr;
import java.util.concurrent.BlockingQueue;
public final class rs extends Thread {
    private static final boolean a = sd.b;
    private final BlockingQueue<ry<?>> b;
    private final BlockingQueue<ry<?>> c;
    private final rr d;
    private final sb e;
    private volatile boolean f = false;

    public rs(BlockingQueue<ry<?>> blockingQueue, BlockingQueue<ry<?>> blockingQueue2, rr rrVar, sb sbVar) {
        this.b = blockingQueue;
        this.c = blockingQueue2;
        this.d = rrVar;
        this.e = sbVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        if (a) {
            sd.a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.d.a();
        while (true) {
            try {
                final ry<?> take = this.b.take();
                if (take.j()) {
                    take.g();
                } else {
                    rr.a a3 = this.d.a(take.b());
                    if (a3 == null) {
                        this.c.put(take);
                    } else {
                        if (a3.e < System.currentTimeMillis()) {
                            take.a(a3);
                            this.c.put(take);
                        } else {
                            sa<?> a4 = take.a(new rx(a3.a, a3.g));
                            if (!(a3.f < System.currentTimeMillis())) {
                                this.e.a(take, a4);
                            } else {
                                take.a(a3);
                                a4.d = true;
                                this.e.a(take, a4, new Runnable() { // from class: com.yandex.mobile.ads.impl.rs.1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        try {
                                            rs.this.c.put(take);
                                        } catch (InterruptedException unused) {
                                        }
                                    }
                                });
                            }
                        }
                    }
                }
            } catch (InterruptedException unused) {
                if (this.f) {
                    return;
                }
            }
        }
    }

    public final void a() {
        this.f = true;
        interrupt();
    }
}
