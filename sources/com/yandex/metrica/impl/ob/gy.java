package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.yandex.metrica.impl.ob.al;
import com.yandex.metrica.impl.ob.hb;
import com.yandex.metrica.impl.ob.uu;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
public class gy {
    public static final Map<Integer, Integer> a = Collections.unmodifiableMap(new HashMap<Integer, Integer>() { // from class: com.yandex.metrica.impl.ob.gy.1
        {
            put(Integer.valueOf(al.a.EVENT_TYPE_DIAGNOSTIC.a()), 22);
            put(Integer.valueOf(al.a.EVENT_TYPE_DIAGNOSTIC_STATBOX.a()), 23);
            put(Integer.valueOf(al.a.EVENT_TYPE_DIAGNOSTIC_DISABLE_STAT_SENDING.a()), 24);
        }
    });
    @NonNull
    private final aa b;
    @NonNull
    private final gz c;
    @NonNull
    private final hb d;
    @NonNull
    private final adk e;
    @NonNull
    private final adk f;
    @NonNull
    private final abt g;
    @NonNull
    private final fi h;

    public static class a {
        public gy a(@NonNull aa aaVar, @NonNull gz gzVar, @NonNull hb hbVar, @NonNull mo moVar) {
            return new gy(aaVar, gzVar, hbVar, moVar);
        }
    }

    public gy(@NonNull aa aaVar, @NonNull gz gzVar, @NonNull hb hbVar, @NonNull mo moVar) {
        this(aaVar, gzVar, hbVar, new fi(moVar), new adk(1024, "diagnostic event name"), new adk(204800, "diagnostic event value"), new abs());
    }

    public byte[] a() {
        uu.c cVar = new uu.c();
        uu.c.e eVar = new uu.c.e();
        int i = 0;
        cVar.b = new uu.c.e[]{eVar};
        hb.a a3 = this.d.a();
        eVar.b = a3.a;
        uu.c.e.b bVar = new uu.c.e.b();
        eVar.c = bVar;
        bVar.d = 2;
        bVar.b = new uu.c.g();
        uu.c.g gVar = eVar.c.b;
        long j = a3.b;
        gVar.b = j;
        gVar.c = abu.a(j);
        eVar.c.c = this.c.B();
        uu.c.e.a aVar = new uu.c.e.a();
        eVar.d = new uu.c.e.a[]{aVar};
        aVar.b = (long) a3.c;
        aVar.q = (long) this.h.a(this.b.g());
        aVar.c = this.g.b() - a3.b;
        aVar.d = a.get(Integer.valueOf(this.b.g())).intValue();
        if (!TextUtils.isEmpty(this.b.d())) {
            aVar.e = this.f.a(this.b.d());
        }
        if (!TextUtils.isEmpty(this.b.e())) {
            String e2 = this.b.e();
            String a4 = this.e.a(e2);
            if (!TextUtils.isEmpty(a4)) {
                aVar.f = a4.getBytes();
            }
            int length = e2.getBytes().length;
            byte[] bArr = aVar.f;
            if (bArr != null) {
                i = bArr.length;
            }
            aVar.k = length - i;
        }
        return e.a(cVar);
    }

    public gy(@NonNull aa aaVar, @NonNull gz gzVar, @NonNull hb hbVar, @NonNull fi fiVar, @NonNull adk adk, @NonNull adk adk2, @NonNull abt abt) {
        this.b = aaVar;
        this.c = gzVar;
        this.d = hbVar;
        this.h = fiVar;
        this.f = adk;
        this.e = adk2;
        this.g = abt;
    }
}
