package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.view.View;
public final class na implements mx {
    @NonNull
    private final View a;

    public na(@NonNull View view) {
        this.a = view;
    }

    @Override // com.yandex.mobile.ads.impl.mx
    public final void a(@NonNull ou ouVar, @NonNull my myVar) {
        this.a.setOnClickListener(myVar.a(ouVar));
        this.a.setOnTouchListener(ne.a(this.a.getContext()));
    }
}
