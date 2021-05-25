package com.yandex.metrica.impl.ob;

import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import java.util.Arrays;
import java.util.List;
public class qv implements aw {
    @NonNull
    private rj a;
    @NonNull
    private qw b;
    @NonNull
    private final List<qy> c;
    @NonNull
    private final List<qn> d;
    @NonNull
    private final List<qn> e;
    @NonNull
    private final List<qn> f;
    @NonNull
    private final List<pz> g;
    @NonNull
    private final au h;
    private boolean i;

    public static class a {
        @NonNull
        public au a(@NonNull act act, @NonNull aw awVar) {
            return new au(act, awVar);
        }
    }

    public qv(@NonNull qw qwVar, @NonNull rj rjVar) {
        this(qwVar, rjVar, new mq(lv.a(qwVar.a.a).c()));
    }

    private void e() {
        for (qy qyVar : this.c) {
            qyVar.a();
        }
        a();
    }

    @Override // com.yandex.metrica.impl.ob.aw
    public void a() {
        if (this.i) {
            for (qy qyVar : this.c) {
                qyVar.d();
            }
        }
    }

    @Nullable
    public Location b() {
        if (this.i) {
            return this.a.a();
        }
        return null;
    }

    public void c() {
        if (this.i) {
            this.h.a();
            for (qy qyVar : this.c) {
                qyVar.b();
            }
        }
    }

    public void d() {
        this.h.b();
        for (qy qyVar : this.c) {
            qyVar.c();
        }
    }

    public void a(@Nullable ql qlVar) {
        this.i = qlVar != null && qlVar.g;
        this.a.a(qlVar);
        py pyVar = null;
        pt ptVar = qlVar == null ? null : qlVar.l;
        pt ptVar2 = qlVar == null ? null : qlVar.m;
        pt ptVar3 = qlVar == null ? null : qlVar.n;
        if (qlVar != null) {
            pyVar = qlVar.o;
        }
        for (qn qnVar : this.d) {
            qnVar.a(ptVar);
        }
        for (qn qnVar2 : this.e) {
            qnVar2.a(ptVar2);
        }
        for (qn qnVar3 : this.f) {
            qnVar3.a(ptVar3);
        }
        for (pz pzVar : this.g) {
            pzVar.a(pyVar);
        }
        e();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @android.support.annotation.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public qv(@android.support.annotation.NonNull com.yandex.metrica.impl.ob.qw r12, @android.support.annotation.NonNull com.yandex.metrica.impl.ob.rj r13, @android.support.annotation.NonNull com.yandex.metrica.impl.ob.mq r14) {
        /*
            r11 = this;
            com.yandex.metrica.impl.ob.ql r0 = r12.d
            r1 = 0
            if (r0 != 0) goto L_0x0007
            r7 = r1
            goto L_0x000a
        L_0x0007:
            com.yandex.metrica.impl.ob.pt r2 = r0.l
            r7 = r2
        L_0x000a:
            if (r0 != 0) goto L_0x000e
            r8 = r1
            goto L_0x0011
        L_0x000e:
            com.yandex.metrica.impl.ob.pt r2 = r0.m
            r8 = r2
        L_0x0011:
            if (r0 != 0) goto L_0x0015
            r9 = r1
            goto L_0x0018
        L_0x0015:
            com.yandex.metrica.impl.ob.pt r2 = r0.n
            r9 = r2
        L_0x0018:
            if (r0 != 0) goto L_0x001b
            goto L_0x001d
        L_0x001b:
            com.yandex.metrica.impl.ob.py r1 = r0.o
        L_0x001d:
            r10 = r1
            r3 = r11
            r4 = r12
            r5 = r13
            r6 = r14
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.qv.<init>(com.yandex.metrica.impl.ob.qw, com.yandex.metrica.impl.ob.rj, com.yandex.metrica.impl.ob.mq):void");
    }

    private qv(@NonNull qw qwVar, @NonNull rj rjVar, @NonNull mq mqVar, @Nullable pt ptVar, @Nullable pt ptVar2, @Nullable pt ptVar3, @Nullable py pyVar) {
        this(qwVar, rjVar, new qc(qwVar, mqVar, ptVar2), new qj(qwVar, mqVar, ptVar), new rf(qwVar, ptVar3), new qb(qwVar, mqVar, rjVar, pyVar), new a());
    }

    @VisibleForTesting
    public qv(@NonNull qw qwVar, @NonNull rj rjVar, @NonNull pl plVar, @NonNull pl plVar2, @NonNull rf rfVar, @NonNull qb qbVar, @NonNull a aVar) {
        this.b = qwVar;
        ql qlVar = qwVar.d;
        if (qlVar != null) {
            this.i = qlVar.g;
        }
        this.a = rjVar;
        this.c = Arrays.asList(plVar.a(rjVar), plVar2.a(rjVar), rfVar.a(rjVar), qbVar.a());
        this.d = plVar2.d();
        this.e = plVar.d();
        this.f = rfVar.a();
        this.g = qbVar.b();
        au a3 = aVar.a(this.b.a.b, this);
        this.h = a3;
        this.a.b().a(a3);
    }
}
