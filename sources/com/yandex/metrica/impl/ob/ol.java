package com.yandex.metrica.impl.ob;

import android.os.ParcelUuid;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.yandex.metrica.impl.ob.ve;
import com.yandex.metrica.impl.ob.xi;
public class ol implements np<xi.a.c, ve.a.C0352a.C0353a.c> {
    @NonNull
    /* renamed from: a */
    public ve.a.C0352a.C0353a.c b(@NonNull xi.a.c cVar) {
        ve.a.C0352a.C0353a.c cVar2 = new ve.a.C0352a.C0353a.c();
        cVar2.b = cVar.a.toString();
        ParcelUuid parcelUuid = cVar.b;
        if (parcelUuid != null) {
            cVar2.c = parcelUuid.toString();
        }
        return cVar2;
    }

    @NonNull
    public xi.a.c a(@NonNull ve.a.C0352a.C0353a.c cVar) {
        return new xi.a.c(ParcelUuid.fromString(cVar.b), TextUtils.isEmpty(cVar.c) ? null : ParcelUuid.fromString(cVar.c));
    }
}
