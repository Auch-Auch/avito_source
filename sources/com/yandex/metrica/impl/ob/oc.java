package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.ve;
public class oc implements np<xs, ve.a.i> {
    @NonNull
    /* renamed from: a */
    public ve.a.i b(@NonNull xs xsVar) {
        ve.a.i iVar = new ve.a.i();
        iVar.b = xsVar.a;
        iVar.c = xsVar.b;
        iVar.d = aav.a(xsVar.c);
        iVar.e = xsVar.d;
        iVar.f = xsVar.e;
        return iVar;
    }

    @NonNull
    public xs a(@NonNull ve.a.i iVar) {
        return new xs(iVar.b, iVar.c, aav.a(iVar.d), iVar.e, iVar.f);
    }
}
