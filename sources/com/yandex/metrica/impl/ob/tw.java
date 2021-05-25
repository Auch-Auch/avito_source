package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.text.TextUtils;
public class tw implements tx {
    @Override // com.yandex.metrica.impl.ob.tx
    @NonNull
    public byte[] a(@NonNull to toVar) {
        return !TextUtils.isEmpty(toVar.b) ? dh.c(toVar.b) : new byte[0];
    }
}
