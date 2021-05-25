package com.yandex.metrica.impl.ob;

import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
public class rg {
    @NonNull
    private final qv a;
    @NonNull
    private final qg b;
    @NonNull
    private final rm c;
    @NonNull
    private final pn d;
    @NonNull
    private final rh e;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public rg(@android.support.annotation.NonNull com.yandex.metrica.impl.ob.rh r10) {
        /*
            r9 = this;
            com.yandex.metrica.impl.ob.ri r0 = new com.yandex.metrica.impl.ob.ri
            com.yandex.metrica.impl.ob.po r1 = r10.a
            android.content.Context r1 = r1.a
            r0.<init>(r1)
            com.yandex.metrica.impl.ob.rm r1 = new com.yandex.metrica.impl.ob.rm
            com.yandex.metrica.impl.ob.po r2 = r10.a
            android.content.Context r3 = r2.a
            com.yandex.metrica.impl.ob.yb r4 = r10.b
            com.yandex.metrica.impl.ob.ql r5 = r10.c
            com.yandex.metrica.impl.ob.lz r6 = r10.d
            com.yandex.metrica.impl.ob.ly r7 = r10.e
            com.yandex.metrica.impl.ob.acu r8 = r2.b
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8)
            com.yandex.metrica.impl.ob.pn r2 = new com.yandex.metrica.impl.ob.pn
            com.yandex.metrica.impl.ob.ql r3 = r10.c
            com.yandex.metrica.impl.ob.lz r4 = r10.d
            com.yandex.metrica.impl.ob.ly r5 = r10.e
            r2.<init>(r3, r4, r5)
            r9.<init>(r10, r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.rg.<init>(com.yandex.metrica.impl.ob.rh):void");
    }

    public void a() {
        this.a.a();
        this.b.d();
    }

    @Nullable
    public Location b() {
        return this.a.b();
    }

    public void c() {
        this.c.a();
    }

    public void d() {
        this.a.c();
        this.b.a();
    }

    public void e() {
        this.a.d();
        this.b.b();
    }

    private rg(@NonNull rh rhVar, @NonNull ri riVar, @NonNull rm rmVar, @NonNull pn pnVar) {
        this(rhVar, riVar, qw.a(rhVar, rmVar, pnVar, riVar.a()), rmVar, pnVar);
    }

    public void a(@NonNull yb ybVar) {
        this.c.a(ybVar);
    }

    public void a(@Nullable ql qlVar) {
        this.c.a(qlVar);
        this.d.a(qlVar);
        this.a.a(qlVar);
        this.b.a(qlVar);
    }

    private rg(@NonNull rh rhVar, @NonNull ri riVar, @NonNull qw qwVar, @NonNull rm rmVar, @NonNull pn pnVar) {
        this(rhVar, riVar, qwVar, new rj(rhVar.a.a, rhVar.c, rmVar, pnVar), rmVar, pnVar);
    }

    private rg(@NonNull rh rhVar, @NonNull ri riVar, @NonNull qw qwVar, @NonNull rj rjVar, @NonNull rm rmVar, @NonNull pn pnVar) {
        this(rhVar, new qv(qwVar, rjVar), new qg(qh.a(rhVar, rmVar, pnVar, riVar.b(), riVar.c())), rmVar, pnVar);
    }

    @VisibleForTesting
    public rg(@NonNull rh rhVar, @NonNull qv qvVar, @NonNull qg qgVar, @NonNull rm rmVar, @NonNull pn pnVar) {
        this.e = rhVar;
        this.a = qvVar;
        this.b = qgVar;
        this.c = rmVar;
        this.d = pnVar;
    }
}
