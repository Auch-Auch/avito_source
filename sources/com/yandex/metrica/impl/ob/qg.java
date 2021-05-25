package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.impl.ob.qm;
import org.json.JSONArray;
public class qg {
    @NonNull
    private final qh a;
    @NonNull
    private final qi b;
    @NonNull
    private final abs c;
    @Nullable
    private ql d;
    @NonNull
    private final p e;
    @NonNull
    private final dn f;
    @NonNull
    private final rt g;
    @NonNull
    private final k h;
    private boolean i;
    private final Runnable j;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public qg(@android.support.annotation.NonNull com.yandex.metrica.impl.ob.qh r4) {
        /*
            r3 = this;
            com.yandex.metrica.impl.ob.rt r0 = new com.yandex.metrica.impl.ob.rt
            com.yandex.metrica.impl.ob.po r1 = r4.a
            android.content.Context r1 = r1.a
            com.yandex.metrica.impl.ob.ql r2 = r4.f
            if (r2 != 0) goto L_0x000c
            r2 = 0
            goto L_0x000e
        L_0x000c:
            com.yandex.metrica.impl.ob.pt r2 = r2.k
        L_0x000e:
            r0.<init>(r1, r2)
            r3.<init>(r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.qg.<init>(com.yandex.metrica.impl.ob.qh):void");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void e() {
        ql qlVar = this.d;
        if (qlVar != null) {
            long j2 = qlVar.h;
            if (j2 > 0) {
                this.a.a.b.a(this.j, j2);
            }
        }
    }

    private void f() {
        this.a.a.b.b(this.j);
    }

    public void b() {
        f();
    }

    public void c() {
        ql qlVar = this.d;
        boolean z = qlVar != null && qlVar.i;
        if (this.i != z) {
            this.i = z;
            if (z) {
                e();
            } else {
                f();
            }
        }
    }

    public void d() {
        final qk qkVar = new qk();
        qkVar.a(this.c.a());
        qkVar.b(this.c.c());
        this.g.b();
        qkVar.a((JSONArray) this.f.d().a());
        this.a.c.a(new zc() { // from class: com.yandex.metrica.impl.ob.qg.2
            @Override // com.yandex.metrica.impl.ob.zc
            public void a(zb[] zbVarArr) {
                qkVar.b(abc.a(zbVarArr));
            }
        });
        qkVar.a(this.e.d());
        qkVar.a(qm.a.a(this.h.c()));
        this.b.a(qkVar);
        this.a.d.a();
        this.a.e.a();
    }

    private qg(@NonNull qh qhVar, @NonNull rt rtVar) {
        this(qhVar, new qi(qhVar.a.a), new abs(), as.a().n(), as.a().o(), dn.a(qhVar.a.a), rtVar, new au(qhVar.a.b, rtVar));
    }

    public void a() {
        c();
    }

    public void a(@Nullable ql qlVar) {
        this.d = qlVar;
        this.g.a(qlVar == null ? null : qlVar.k);
        c();
    }

    public qg(@NonNull qh qhVar, @NonNull qi qiVar, @NonNull abs abs, @NonNull p pVar, @NonNull k kVar, @NonNull dn dnVar, @NonNull rt rtVar, @NonNull au auVar) {
        this.j = new Runnable() { // from class: com.yandex.metrica.impl.ob.qg.1
            @Override // java.lang.Runnable
            public void run() {
                qg.this.d();
                qg.this.e();
            }
        };
        this.a = qhVar;
        this.b = qiVar;
        this.c = abs;
        this.d = qhVar.f;
        this.e = pVar;
        this.h = kVar;
        this.f = dnVar;
        this.g = rtVar;
        dnVar.d().a(auVar);
    }
}
