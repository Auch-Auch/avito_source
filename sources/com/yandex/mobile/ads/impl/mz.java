package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
public final class mz implements mx {
    @NonNull
    private final es a;

    public mz(@NonNull es esVar) {
        this.a = esVar;
    }

    @Override // com.yandex.mobile.ads.impl.mx
    public final void a(@NonNull ou ouVar, @NonNull my myVar) {
        this.a.setClickListener(new nc(ouVar, myVar));
    }
}
