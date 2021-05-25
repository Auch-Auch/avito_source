package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.uy;
public abstract class ui implements ty, ur {
    @NonNull
    private final String a;
    private final int b;
    @NonNull
    private final adw<String> c;
    @NonNull
    private final ua d;
    @NonNull
    private abl e = abd.a();

    public ui(int i, @NonNull String str, @NonNull adw<String> adw, @NonNull ua uaVar) {
        this.b = i;
        this.a = str;
        this.c = adw;
        this.d = uaVar;
    }

    @Override // com.yandex.metrica.impl.ob.ty
    @NonNull
    public final uy.a.C0346a a() {
        uy.a.C0346a aVar = new uy.a.C0346a();
        aVar.c = d();
        aVar.b = c().getBytes();
        aVar.e = new uy.a.c();
        aVar.d = new uy.a.b();
        return aVar;
    }

    @NonNull
    public String c() {
        return this.a;
    }

    public int d() {
        return this.b;
    }

    @NonNull
    public ua e() {
        return this.d;
    }

    public boolean f() {
        adu a3 = this.c.a(c());
        if (a3.a()) {
            return true;
        }
        if (!this.e.c()) {
            return false;
        }
        abl abl = this.e;
        StringBuilder L = a.L("Attribute ");
        L.append(c());
        L.append(" of type ");
        L.append(up.a(d()));
        L.append(" is skipped because ");
        L.append(a3.b());
        abl.b(L.toString());
        return false;
    }

    @Override // com.yandex.metrica.impl.ob.ur
    public void a(@NonNull abl abl) {
        this.e = abl;
    }
}
