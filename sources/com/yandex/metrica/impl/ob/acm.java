package com.yandex.metrica.impl.ob;

import android.util.Base64;
public class acm implements acj {
    @Override // com.yandex.metrica.impl.ob.acj
    public aci a(aa aaVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.yandex.metrica.impl.ob.acj
    public byte[] a(byte[] bArr) {
        try {
            return Base64.decode(bArr, 0);
        } catch (Throwable unused) {
            return new byte[0];
        }
    }
}
