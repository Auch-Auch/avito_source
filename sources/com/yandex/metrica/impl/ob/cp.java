package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import com.yandex.metrica.f;
import com.yandex.metrica.j;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class cp {
    @NonNull
    private Context a;
    @NonNull
    private eu b;
    @NonNull
    private cs c;
    @NonNull
    private Handler d;
    @NonNull
    private xw e;
    private Map<String, ay> f;
    private final adw<String> g;
    private final List<String> h = Arrays.asList("20799a27-fa80-4b36-b2db-0f8141f24180", "0e5e9c33-f8c3-4568-86c5-2e4f57523f72");

    public cp(@NonNull Context context, @NonNull eu euVar, @NonNull cs csVar, @NonNull Handler handler, @NonNull xw xwVar) {
        HashMap hashMap = new HashMap();
        this.f = hashMap;
        this.g = new ads(new ady(hashMap));
        this.a = context;
        this.b = euVar;
        this.c = csVar;
        this.d = handler;
        this.e = xwVar;
    }

    @NonNull
    public bj a(@NonNull j jVar, boolean z, @NonNull mn mnVar) {
        this.g.a(jVar.apiKey);
        bj bjVar = new bj(this.a, this.b, jVar, this.c, this.e, new cq(this, "20799a27-fa80-4b36-b2db-0f8141f24180"), new cq(this, "0e5e9c33-f8c3-4568-86c5-2e4f57523f72"), mnVar);
        a(bjVar);
        bjVar.a(jVar, z);
        bjVar.a_();
        this.c.a(bjVar);
        this.f.put(jVar.apiKey, bjVar);
        return bjVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.yandex.metrica.impl.ob.ay] */
    @NonNull
    public synchronized ay b(@NonNull f fVar) {
        bk bkVar;
        ay ayVar = this.f.get(fVar.apiKey);
        bkVar = ayVar;
        if (ayVar == 0) {
            if (!this.h.contains(fVar.apiKey)) {
                this.e.c();
            }
            bk bkVar2 = new bk(this.a, this.b, fVar, this.c);
            a(bkVar2);
            bkVar2.a_();
            this.f.put(fVar.apiKey, bkVar2);
            bkVar = bkVar2;
        }
        return bkVar;
    }

    public synchronized void a(@NonNull f fVar) {
        if (this.f.containsKey(fVar.apiKey)) {
            abl a3 = abd.a(fVar.apiKey);
            if (a3.c()) {
                a3.b("Reporter with apiKey=%s already exists.", fVar.apiKey);
            }
        } else {
            b(fVar);
            dl.b(fVar.apiKey);
        }
    }

    private void a(@NonNull o oVar) {
        oVar.a(new bf(this.d, oVar));
        oVar.a(this.e);
    }
}
