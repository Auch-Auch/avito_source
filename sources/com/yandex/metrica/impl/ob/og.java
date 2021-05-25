package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.ve;
import com.yandex.metrica.impl.ob.xi;
public class og implements np<xi.a.C0363a, ve.a.C0352a.C0353a.C0354a> {
    @NonNull
    /* renamed from: a */
    public ve.a.C0352a.C0353a.C0354a b(@NonNull xi.a.C0363a aVar) {
        ve.a.C0352a.C0353a.C0354a aVar2 = new ve.a.C0352a.C0353a.C0354a();
        aVar2.b = aVar.a;
        byte[] bArr = aVar.b;
        if (bArr != null) {
            aVar2.c = bArr;
        }
        byte[] bArr2 = aVar.c;
        if (bArr2 != null) {
            aVar2.d = bArr2;
        }
        return aVar2;
    }

    @NonNull
    public xi.a.C0363a a(@NonNull ve.a.C0352a.C0353a.C0354a aVar) {
        int i = aVar.b;
        byte[] bArr = null;
        byte[] bArr2 = dl.a(aVar.c) ? null : aVar.c;
        if (!dl.a(aVar.d)) {
            bArr = aVar.d;
        }
        return new xi.a.C0363a(i, bArr2, bArr);
    }
}
