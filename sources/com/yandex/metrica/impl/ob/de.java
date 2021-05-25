package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.common.net.HttpHeaders;
import com.yandex.metrica.impl.ob.ca;
public class de extends ce<wn> {
    private final yc j;
    private boolean k;
    private xv l;
    @NonNull
    private final wf m;

    public de(yc ycVar, wf wfVar) {
        this(ycVar, wfVar, new wn(new wd()));
    }

    @Override // com.yandex.metrica.impl.ob.ca
    @Nullable
    public ca.a E() {
        return ca.a.STARTUP;
    }

    @Override // com.yandex.metrica.impl.ob.ca
    @Nullable
    public xq F() {
        return this.m.f();
    }

    public synchronized boolean G() {
        return this.k;
    }

    @Override // com.yandex.metrica.impl.ob.ca
    public boolean a() {
        if (this.h >= 0) {
            return false;
        }
        b(false);
        a(HttpHeaders.ACCEPT_ENCODING, "encrypted");
        return this.j.b();
    }

    @Override // com.yandex.metrica.impl.ob.ce, com.yandex.metrica.impl.ob.ca
    public boolean b() {
        if (G()) {
            return true;
        }
        if (200 != this.e) {
            return false;
        }
        boolean b = super.b();
        if (b) {
            return b;
        }
        this.l = xv.PARSE;
        return b;
    }

    @Override // com.yandex.metrica.impl.ob.ca
    public void f() {
        if (!x() && y()) {
            if (this.l == null) {
                this.l = xv.UNKNOWN;
            }
            this.j.a(this.l);
        }
    }

    @Override // com.yandex.metrica.impl.ob.ca
    public void g() {
        super.g();
        this.l = xv.NETWORK;
    }

    @Override // com.yandex.metrica.impl.ob.ca
    @NonNull
    public String n() {
        StringBuilder L = a.L("Startup task for component: ");
        L.append(this.j.c().toString());
        return L.toString();
    }

    @Override // com.yandex.metrica.impl.ob.ca
    public boolean o() {
        return true;
    }

    public de(yc ycVar, wf wfVar, @NonNull wn wnVar) {
        super(new dd(ycVar, wfVar), wnVar);
        this.k = false;
        this.j = ycVar;
        this.m = wfVar;
        a(wfVar.a());
    }

    @Override // com.yandex.metrica.impl.ob.ca
    public void a(@NonNull Uri.Builder builder) {
        ((wn) this.i).a(builder, this.m);
    }

    public synchronized void b(boolean z) {
        this.k = z;
    }

    @Override // com.yandex.metrica.impl.ob.ca
    public void a(Throwable th) {
        this.l = xv.NETWORK;
    }
}
