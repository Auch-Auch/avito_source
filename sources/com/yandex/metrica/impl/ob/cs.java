package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.Base64;
import android.util.Pair;
import com.yandex.metrica.IMetricaService;
import com.yandex.metrica.impl.ac.NativeCrashesHelper;
import com.yandex.metrica.impl.ob.al;
import com.yandex.metrica.impl.ob.ct;
import com.yandex.metrica.impl.ob.uy;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
public class cs implements az {
    private final Context a;
    private bn b;
    private final NativeCrashesHelper c;
    private bj d;
    @NonNull
    private final w e;
    private xx f;
    private final ll g;
    @NonNull
    private final lf h;
    private final ct i;

    public cs(eu euVar, Context context, act act) {
        this(euVar, context, new NativeCrashesHelper(context), new bn(context, act), new ll(), new lf());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private aa b(aa aaVar, co coVar) {
        if (aaVar.g() == al.a.EVENT_TYPE_EXCEPTION_USER.a() || aaVar.g() == al.a.EVENT_TYPE_EXCEPTION_USER_PROTOBUF.a()) {
            aaVar.e(coVar.e());
        }
        return aaVar;
    }

    private void e() {
        bj bjVar = this.d;
        if (bjVar == null || bjVar.f()) {
            this.b.c();
        }
    }

    public void c() {
        this.b.g();
    }

    public void d() {
        this.b.h();
    }

    @VisibleForTesting
    public cs(eu euVar, Context context, @NonNull NativeCrashesHelper nativeCrashesHelper, @NonNull bn bnVar, @NonNull ll llVar, @NonNull lf lfVar) {
        this.b = bnVar;
        this.a = context;
        this.c = nativeCrashesHelper;
        this.e = new w(euVar);
        this.g = llVar;
        this.h = lfVar;
        this.i = new ct(this);
    }

    public void a(@Nullable bj bjVar) {
        this.d = bjVar;
    }

    public void c(String str) {
        this.e.g().b(str);
    }

    @NonNull
    private Bundle c(@NonNull eu euVar) {
        Bundle bundle = new Bundle();
        euVar.b(bundle);
        return bundle;
    }

    public void a(xx xxVar) {
        this.f = xxVar;
        this.e.b(xxVar);
    }

    public Future<Void> b(@NonNull eu euVar) {
        return this.i.b(euVar);
    }

    @NonNull
    private abl c(@NonNull co coVar) {
        return abd.a(coVar.h().e());
    }

    public void a(boolean z, co coVar) {
        this.c.a(z);
    }

    public void b(String str) {
        this.e.g().a(str);
    }

    public void a(@Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3) {
        if (dl.a(bool)) {
            this.e.h().a(bool.booleanValue());
        }
        if (dl.a(bool2)) {
            this.e.h().h(bool2.booleanValue());
        }
        if (dl.a(bool3)) {
            this.e.h().b(bool3.booleanValue());
        }
        a(aa.t(), this.e);
    }

    public void b(o oVar) {
        this.b.c();
    }

    @Override // com.yandex.metrica.impl.ob.az
    public void b(@NonNull IMetricaService iMetricaService, @NonNull eu euVar) throws RemoteException {
        iMetricaService.c(c(euVar));
    }

    public void b(co coVar) {
        a(new ct.d(t.b(), coVar));
    }

    public void b(@Nullable final String str, @NonNull co coVar) {
        a(new ct.d(t.a(str, c(coVar)), coVar).a(new ct.c() { // from class: com.yandex.metrica.impl.ob.cs.3
            @Override // com.yandex.metrica.impl.ob.ct.c
            public aa a(aa aaVar) {
                return aaVar.c(str);
            }
        }));
    }

    public void a(String str, co coVar) {
        a(al.a(al.a.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH, str, c(coVar)), coVar);
    }

    private static void b(IMetricaService iMetricaService, aa aaVar, co coVar) throws RemoteException {
        iMetricaService.a(aaVar.a(coVar.b()));
    }

    @Override // com.yandex.metrica.impl.ob.az
    public Context b() {
        return this.a;
    }

    public void a(aa aaVar, co coVar) {
        a(b(aaVar, coVar), coVar, (Map<String, Object>) null);
    }

    public Future<Void> a(aa aaVar, final co coVar, final Map<String, Object> map) {
        this.b.d();
        ct.d dVar = new ct.d(aaVar, coVar);
        if (!dl.a((Map) map)) {
            dVar.a(new ct.c() { // from class: com.yandex.metrica.impl.ob.cs.1
                @Override // com.yandex.metrica.impl.ob.ct.c
                public aa a(aa aaVar2) {
                    return cs.this.b(aaVar2.c(abc.b(map)), coVar);
                }
            });
        }
        return a(dVar);
    }

    public Future<Void> a(@NonNull eu euVar) {
        return this.i.a(euVar);
    }

    public void a(@NonNull List<String> list, @NonNull ResultReceiver resultReceiver, @Nullable Map<String, String> map) {
        a(al.a(al.a.EVENT_TYPE_STARTUP, abd.a()).a(new ba(list, map, resultReceiver)), this.e);
    }

    public void a(String str) {
        a(al.f(str, abd.a()), this.e);
    }

    public void a(@Nullable vu vuVar) {
        a(al.a(vuVar, abd.a()), this.e);
    }

    public void a(co coVar) {
        a(al.a(coVar.f(), c(coVar)), coVar);
    }

    public void a(List<String> list) {
        this.e.g().a(list);
    }

    public void a(Map<String, String> map) {
        this.e.g().a(map);
    }

    public void a(@NonNull kz kzVar, @NonNull co coVar) {
        a(al.a(e.a(this.h.b(kzVar)), c(coVar)), coVar);
    }

    public void a(@NonNull String str, @NonNull ld ldVar, @NonNull co coVar) {
        a(al.a(str, e.a(this.g.b(ldVar)), c(coVar)), coVar);
    }

    public void a(@NonNull ld ldVar, co coVar) {
        this.b.d();
        t b2 = al.b(ldVar.a, e.a(this.g.b(ldVar)), c(coVar));
        b2.e(coVar.e());
        try {
            a(new ct.d(b2, coVar).a(b2.a()).a(true)).get();
        } catch (InterruptedException | ExecutionException unused) {
        }
    }

    public void a(o oVar) {
        this.b.d();
    }

    @Override // com.yandex.metrica.impl.ob.az
    public void a(IMetricaService iMetricaService, aa aaVar, co coVar) throws RemoteException {
        b(iMetricaService, aaVar, coVar);
        e();
    }

    @Override // com.yandex.metrica.impl.ob.az
    public void a(@NonNull IMetricaService iMetricaService, @NonNull eu euVar) throws RemoteException {
        iMetricaService.b(c(euVar));
    }

    public void a(String str, String str2, co coVar) {
        a(new ct.d(t.a(str, str2), coVar));
    }

    public void a(@NonNull final uy.a aVar, @NonNull co coVar) {
        a(new ct.d(t.c(), coVar).a(new ct.c() { // from class: com.yandex.metrica.impl.ob.cs.2
            @Override // com.yandex.metrica.impl.ob.ct.c
            public aa a(aa aaVar) {
                return aaVar.c(new String(Base64.encode(e.a(aVar), 0)));
            }
        }));
    }

    public void a(@NonNull final cv cvVar, @NonNull co coVar) {
        a(new ct.d(t.a(c(coVar)), coVar).a(new ct.c() { // from class: com.yandex.metrica.impl.ob.cs.4
            @Override // com.yandex.metrica.impl.ob.ct.c
            public aa a(aa aaVar) {
                Pair<byte[], Integer> a3 = cvVar.a();
                return aaVar.c(new String(Base64.encode((byte[]) a3.first, 0))).c(((Integer) a3.second).intValue());
            }
        }));
    }

    private Future<Void> a(ct.d dVar) {
        dVar.a().a(this.f);
        return this.i.a(dVar);
    }

    @Override // com.yandex.metrica.impl.ob.az
    public bn a() {
        return this.b;
    }
}
