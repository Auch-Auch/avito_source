package com.yandex.mobile.ads.impl;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;
public final class rw extends Thread {
    private final BlockingQueue<ry<?>> a;
    private final rv b;
    private final rr c;
    private final sb d;
    private volatile boolean e = false;

    public rw(BlockingQueue<ry<?>> blockingQueue, rv rvVar, rr rrVar, sb sbVar) {
        this.a = blockingQueue;
        this.b = rvVar;
        this.c = rrVar;
        this.d = sbVar;
    }

    public final void a() {
        this.e = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                ry<?> take = this.a.take();
                try {
                    if (take.j()) {
                        take.g();
                    } else {
                        TrafficStats.setThreadStatsTag(take.f());
                        rx a3 = this.b.a(take);
                        if (!a3.d || !take.s()) {
                            sa<?> a4 = take.a(a3);
                            if (take.m() && a4.b != null) {
                                this.c.a(take.b(), a4.b);
                            }
                            take.r();
                            this.d.a(take, a4);
                        } else {
                            take.g();
                        }
                    }
                } catch (sl e2) {
                    e2.a(SystemClock.elapsedRealtime() - elapsedRealtime);
                    this.d.a(take, take.a(e2));
                } catch (Exception e3) {
                    sd.a(e3, "Unhandled exception %s", e3.toString());
                    sl slVar = new sl(e3);
                    slVar.a(SystemClock.elapsedRealtime() - elapsedRealtime);
                    this.d.a(take, slVar);
                }
            } catch (InterruptedException unused) {
                if (this.e) {
                    return;
                }
            }
        }
    }
}
