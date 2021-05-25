package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import android.util.Base64;
public class ace implements acj {
    @NonNull
    private final acd a;

    public ace() {
        this(new acc());
    }

    @Override // com.yandex.metrica.impl.ob.acj
    @NonNull
    public aci a(@NonNull aa aaVar) {
        String e = aaVar.e();
        String str = null;
        if (!TextUtils.isEmpty(e)) {
            try {
                byte[] a3 = this.a.a(e.getBytes("UTF-8"));
                if (a3 != null) {
                    str = Base64.encodeToString(a3, 0);
                }
            } catch (Throwable unused) {
            }
        }
        return new aci(aaVar.c(str), a());
    }

    public ace(@NonNull acc acc) {
        this(new acd("AES/CBC/PKCS5Padding", acc.a(), acc.b()));
    }

    @VisibleForTesting
    public ace(@NonNull acd acd) {
        this.a = acd;
    }

    @Override // com.yandex.metrica.impl.ob.acj
    @NonNull
    public byte[] a(@Nullable byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (bArr == null || bArr.length <= 0) {
            return bArr2;
        }
        try {
            return this.a.b(Base64.decode(bArr, 0));
        } catch (Throwable unused) {
            return bArr2;
        }
    }

    @NonNull
    public acl a() {
        return acl.AES_VALUE_ENCRYPTION;
    }
}
