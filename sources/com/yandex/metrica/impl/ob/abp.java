package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import java.util.concurrent.TimeUnit;
public class abp {
    private volatile long a;
    private mq b;
    private abt c;

    public static class a {
        public static abp a = new abp();
    }

    public static abp a() {
        return a.a;
    }

    public synchronized long b() {
        return this.a;
    }

    public synchronized void c() {
        this.b.d(false);
        this.b.q();
    }

    public synchronized boolean d() {
        return this.b.c(true);
    }

    private abp() {
    }

    public synchronized void a(@NonNull Context context) {
        a(new mq(lv.a(context).c()), new abs());
    }

    public synchronized void a(long j, @Nullable Long l) {
        this.a = (j - this.c.a()) / 1000;
        boolean z = true;
        if (this.b.c(true)) {
            if (l != null) {
                long abs = Math.abs(j - this.c.a());
                mq mqVar = this.b;
                if (abs <= TimeUnit.SECONDS.toMillis(l.longValue())) {
                    z = false;
                }
                mqVar.d(z);
            } else {
                this.b.d(false);
            }
        }
        this.b.a(this.a);
        this.b.q();
    }

    @VisibleForTesting
    public void a(mq mqVar, abt abt) {
        this.b = mqVar;
        this.a = mqVar.c(0);
        this.c = abt;
    }
}
