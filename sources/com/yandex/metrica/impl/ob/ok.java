package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.ve;
import com.yandex.metrica.impl.ob.xi;
public class ok implements np<xi.a.b, ve.a.C0352a.C0353a.b> {
    @NonNull
    /* renamed from: a */
    public ve.a.C0352a.C0353a.b b(@NonNull xi.a.b bVar) {
        ve.a.C0352a.C0353a.b bVar2 = new ve.a.C0352a.C0353a.b();
        bVar2.b = bVar.a.toString();
        byte[] bArr = bVar.b;
        if (bArr != null) {
            bVar2.c = bArr;
        }
        byte[] bArr2 = bVar.c;
        if (bArr2 != null) {
            bVar2.d = bArr2;
        }
        return bVar2;
    }

    @NonNull
    public xi.a.b a(@NonNull ve.a.C0352a.C0353a.b bVar) {
        String str = bVar.b;
        byte[] bArr = null;
        byte[] bArr2 = dl.a(bVar.c) ? null : bVar.c;
        if (!dl.a(bVar.d)) {
            bArr = bVar.d;
        }
        return new xi.a.b(str, bArr2, bArr);
    }
}
