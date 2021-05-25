package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
public class hy extends hu {
    @NonNull
    private final jf a;

    public hy(@NonNull fe feVar) {
        this(feVar, feVar.z());
    }

    @Override // com.yandex.metrica.impl.ob.hq
    public boolean a(@NonNull aa aaVar) {
        if (TextUtils.isEmpty(aaVar.d())) {
            return false;
        }
        aaVar.a(this.a.a(aaVar.d()));
        return false;
    }

    @VisibleForTesting
    public hy(@NonNull fe feVar, @NonNull jf jfVar) {
        super(feVar);
        this.a = jfVar;
    }
}
