package com.yandex.metrica.impl.ob;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.IMetricaService;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
public class bn {
    public static final long a = TimeUnit.SECONDS.toMillis(10);
    private final Context b;
    private final act c;
    private boolean d;
    private final List<a> e = new CopyOnWriteArrayList();
    private volatile IMetricaService f = null;
    private final Object g = new Object();
    private final Runnable h = new Runnable() { // from class: com.yandex.metrica.impl.ob.bn.1
        @Override // java.lang.Runnable
        public void run() {
            bn.this.i();
        }
    };
    private final ServiceConnection i = new ServiceConnection() { // from class: com.yandex.metrica.impl.ob.bn.2
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            bn.this.f = IMetricaService.a.a(iBinder);
            bn.this.j();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            bn.this.f = null;
            bn.this.k();
        }
    };

    public interface a {
        void a();

        void b();
    }

    public bn(Context context, act act) {
        this.b = context.getApplicationContext();
        this.c = act;
        this.d = false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void i() {
        if (this.b != null && e()) {
            try {
                this.b.unbindService(this.i);
                this.f = null;
            } catch (Throwable unused) {
            }
        }
        this.f = null;
        k();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void j() {
        for (a aVar : this.e) {
            aVar.a();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void k() {
        for (a aVar : this.e) {
            aVar.b();
        }
    }

    public synchronized void d() {
        this.c.b(this.h);
    }

    public boolean e() {
        return this.f != null;
    }

    public IMetricaService f() {
        return this.f;
    }

    public void g() {
        synchronized (this.g) {
            this.d = true;
        }
        d();
    }

    public void h() {
        this.d = false;
        c();
    }

    public synchronized void b() {
        if (this.f == null) {
            try {
                this.b.bindService(dc.b(this.b), this.i, 1);
            } catch (Throwable unused) {
            }
        }
    }

    public void c() {
        a(this.c);
    }

    public Context a() {
        return this.b;
    }

    @VisibleForTesting
    public void a(@NonNull act act) {
        synchronized (this.g) {
            act.b(this.h);
            if (!this.d) {
                act.a(this.h, a);
            }
        }
    }

    public void a(a aVar) {
        this.e.add(aVar);
    }
}
