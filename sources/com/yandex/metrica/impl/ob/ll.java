package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.us;
import java.util.List;
public class ll implements nh<ld, us.c> {
    @NonNull
    private final lk a;
    @NonNull
    private final le b;
    @NonNull
    private final lg c;
    @NonNull
    private lh d;

    public ll() {
        this(new lk(), new le(new lj()), new lg(), new lh());
    }

    @VisibleForTesting
    public ll(@NonNull lk lkVar, @NonNull le leVar, @NonNull lg lgVar, @NonNull lh lhVar) {
        this.b = leVar;
        this.a = lkVar;
        this.c = lgVar;
        this.d = lhVar;
    }

    @NonNull
    /* renamed from: a */
    public us.c b(@NonNull ld ldVar) {
        us.c cVar = new us.c();
        Throwable th = ldVar.b;
        if (th != null) {
            cVar.b = this.a.b(th);
        }
        ky kyVar = ldVar.c;
        if (kyVar != null) {
            cVar.c = this.b.b(kyVar);
        }
        List<StackTraceElement> list = ldVar.d;
        if (list != null) {
            cVar.f = this.d.b(list);
        }
        String str = ldVar.e;
        if (str != null) {
            cVar.d = str;
        }
        cVar.e = this.c.a(ldVar.f).intValue();
        return cVar;
    }

    @NonNull
    public ld a(@NonNull us.c cVar) {
        throw new UnsupportedOperationException();
    }
}
