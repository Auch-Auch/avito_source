package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.IMetricaService;
import com.yandex.metrica.impl.ob.al;
import com.yandex.metrica.impl.ob.bn;
import com.yandex.metrica.impl.ob.t;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
public class ct implements bn.a {
    private final az a;
    private final bn b;
    private final Object c;
    private final act d;
    @NonNull
    private final an e;

    @VisibleForTesting
    public class a extends b {
        private final ku e;
        private final abg f;

        public a(ct ctVar, @NonNull d dVar) {
            this(dVar, new ku(), new abg());
        }

        @Override // com.yandex.metrica.impl.ob.ct.e
        /* renamed from: a */
        public Void call() {
            if (this.f.a("Metrica")) {
                b(this.b);
                return null;
            }
            ct.this.b.c();
            return super.call();
        }

        @Override // com.yandex.metrica.impl.ob.ct.e
        public boolean b() {
            a(this.b);
            return false;
        }

        @VisibleForTesting
        public a(d dVar, @NonNull ku kuVar, @NonNull abg abg) {
            super(dVar);
            this.e = kuVar;
            this.f = abg;
        }

        public void b(@NonNull d dVar) {
            File b = ct.this.e.b(ct.this.b.a());
            if (this.e.a(b)) {
                eu g = dVar.a().g();
                Integer f2 = g.f();
                String g2 = g.g();
                an anVar = ct.this.e;
                PrintWriter printWriter = null;
                try {
                    PrintWriter printWriter2 = new PrintWriter(new BufferedOutputStream(new FileOutputStream(anVar.a(b, f2 + "-" + g2))));
                    try {
                        printWriter2.write(new ln(dVar.a, dVar.a(), dVar.e).j());
                        dl.a((Closeable) printWriter2);
                    } catch (IOException unused) {
                        printWriter = printWriter2;
                        dl.a((Closeable) printWriter);
                    }
                } catch (IOException unused2) {
                    dl.a((Closeable) printWriter);
                }
            }
        }

        @VisibleForTesting
        public void a(@NonNull d dVar) {
            if (dVar.d().o() == 0) {
                Context b = ct.this.a.b();
                Intent b2 = dc.b(b);
                dVar.d().a(al.a.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_INTENT.a());
                b2.putExtras(dVar.d().a(dVar.a().b()));
                try {
                    b.startService(b2);
                } catch (Throwable unused) {
                    b(dVar);
                }
            } else {
                b(dVar);
            }
        }
    }

    @VisibleForTesting
    public class b extends e {
        public final d b;

        @VisibleForTesting
        public b(d dVar) {
            super();
            this.b = dVar;
        }

        @Override // com.yandex.metrica.impl.ob.ct.e
        public void a(@NonNull IMetricaService iMetricaService) throws RemoteException {
            a(iMetricaService, this.b);
        }

        @Override // com.yandex.metrica.impl.ob.ct.e
        public void a(Throwable th) {
        }

        private void a(IMetricaService iMetricaService, d dVar) throws RemoteException {
            ct.this.a.a(iMetricaService, dVar.b(), dVar.b);
        }
    }

    public interface c {
        aa a(aa aaVar);
    }

    public static class d {
        private aa a;
        private co b;
        private boolean c = false;
        private c d;
        @Nullable
        private HashMap<t.a, Integer> e;

        public d(aa aaVar, co coVar) {
            this.a = aaVar;
            this.b = new co(new eu(coVar.g()), new CounterConfiguration(coVar.h()));
        }

        @VisibleForTesting
        public aa d() {
            return this.a;
        }

        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("ReportToSend{mReport=");
            L.append(this.a);
            L.append(", mEnvironment=");
            L.append(this.b);
            L.append(", mCrash=");
            L.append(this.c);
            L.append(", mAction=");
            L.append(this.d);
            L.append(", mTrimmedFields=");
            L.append(this.e);
            L.append('}');
            return L.toString();
        }

        public d a(c cVar) {
            this.d = cVar;
            return this;
        }

        public aa b() {
            c cVar = this.d;
            return cVar != null ? cVar.a(this.a) : this.a;
        }

        public boolean c() {
            return this.c;
        }

        public d a(@NonNull HashMap<t.a, Integer> hashMap) {
            this.e = hashMap;
            return this;
        }

        public d a(boolean z) {
            this.c = z;
            return this;
        }

        public co a() {
            return this.b;
        }
    }

    public abstract class e implements Callable<Void> {
        private e() {
        }

        private void c() {
            synchronized (ct.this.c) {
                if (!ct.this.b.e()) {
                    try {
                        ct.this.c.wait(500, 0);
                    } catch (InterruptedException unused) {
                        ct.this.c.notifyAll();
                    }
                }
            }
        }

        /* renamed from: a */
        public Void call() {
            int i = 0;
            do {
                try {
                    IMetricaService f = ct.this.b.f();
                    if (f != null) {
                        try {
                            a(f);
                            return null;
                        } catch (RemoteException unused) {
                        }
                    }
                    i++;
                } catch (Throwable th) {
                    a(th);
                    return null;
                }
                if (!b() || bt.a.get()) {
                    break;
                }
            } while (i < 20);
            return null;
        }

        public abstract void a(@NonNull IMetricaService iMetricaService) throws RemoteException;

        public void a(Throwable th) {
        }

        public boolean b() {
            ct.this.b.b();
            c();
            return true;
        }
    }

    public ct(az azVar) {
        this(azVar, dr.k().c(), new an());
    }

    @Override // com.yandex.metrica.impl.ob.bn.a
    public void b() {
    }

    public Future<Void> a(d dVar) {
        return this.d.a((Callable) (dVar.c() ? new a(this, dVar) : new b(dVar)));
    }

    public Future<Void> b(@NonNull final eu euVar) {
        return this.d.a(new e() { // from class: com.yandex.metrica.impl.ob.ct.2
            @Override // com.yandex.metrica.impl.ob.ct.e
            public void a(@NonNull IMetricaService iMetricaService) throws RemoteException {
                ct.this.a.b(iMetricaService, euVar);
            }
        });
    }

    public ct(@NonNull az azVar, @NonNull act act, @NonNull an anVar) {
        this.c = new Object();
        this.a = azVar;
        this.d = act;
        this.e = anVar;
        bn a3 = azVar.a();
        this.b = a3;
        a3.a(this);
    }

    public Future<Void> a(@NonNull final eu euVar) {
        return this.d.a(new e() { // from class: com.yandex.metrica.impl.ob.ct.1
            @Override // com.yandex.metrica.impl.ob.ct.e
            public void a(@NonNull IMetricaService iMetricaService) throws RemoteException {
                ct.this.a.a(iMetricaService, euVar);
            }
        });
    }

    @Override // com.yandex.metrica.impl.ob.bn.a
    public void a() {
        synchronized (this.c) {
            this.c.notifyAll();
        }
    }
}
