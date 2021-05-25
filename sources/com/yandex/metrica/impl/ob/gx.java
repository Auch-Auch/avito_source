package com.yandex.metrica.impl.ob;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.impl.ob.ca;
import com.yandex.metrica.impl.ob.gy;
public class gx extends ce<wi> {
    @NonNull
    private final ha j;
    @NonNull
    private final aa k;
    @NonNull
    private final hb l;
    @NonNull
    private final gy.a m;
    @NonNull
    private final abt n;
    @NonNull
    private aay o;
    @NonNull
    private final String p;
    @NonNull
    private final mo q;
    @Nullable
    private gz r;

    public gx(@NonNull ha haVar, @NonNull aa aaVar, @NonNull hb hbVar, @NonNull mo moVar) {
        this(haVar, aaVar, hbVar, moVar, new gy.a(), new abs(), new aay(), new wi());
    }

    @Override // com.yandex.metrica.impl.ob.ca
    @NonNull
    public ca.a E() {
        return ca.a.DIAGNOSTIC;
    }

    @Override // com.yandex.metrica.impl.ob.ca
    public boolean a() {
        gz d = this.j.d();
        this.r = d;
        if (!(d.g() && !dl.a(this.r.a()))) {
            return false;
        }
        a(this.r.a());
        byte[] a = this.m.a(this.k, this.r, this.l, this.q).a();
        byte[] bArr = null;
        try {
            bArr = this.o.a(a);
        } catch (Throwable unused) {
        }
        if (!dl.a(bArr)) {
            a("Content-Encoding", "gzip");
            a = bArr;
        }
        a(a);
        return true;
    }

    @Override // com.yandex.metrica.impl.ob.ca
    public void d() {
        super.d();
        a(this.n.a());
    }

    @Override // com.yandex.metrica.impl.ob.ca
    @NonNull
    public String n() {
        return this.p;
    }

    @Override // com.yandex.metrica.impl.ob.ca
    public boolean t() {
        return super.t() & (400 != k());
    }

    public gx(@NonNull ha haVar, @NonNull aa aaVar, @NonNull hb hbVar, @NonNull mo moVar, @NonNull gy.a aVar, @NonNull abt abt, @NonNull aay aay, @NonNull wi wiVar) {
        super(new af(), wiVar);
        this.j = haVar;
        this.k = aaVar;
        this.l = hbVar;
        this.q = moVar;
        this.m = aVar;
        this.n = abt;
        this.o = aay;
        this.p = getClass().getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.yandex.metrica.impl.ob.ca
    public void a(@NonNull Uri.Builder builder) {
        ((wi) this.i).a(builder, this.r);
    }
}
