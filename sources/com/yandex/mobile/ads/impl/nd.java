package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.yandex.mobile.ads.nativeads.a;
import com.yandex.mobile.ads.nativeads.ag;
public final class nd implements View.OnClickListener {
    @NonNull
    private final oq a;
    @NonNull
    private final a b;
    @NonNull
    private final ag c;
    @Nullable
    private final ou d;
    @Nullable
    private final ay e;

    public nd(@NonNull oq oqVar, @NonNull a aVar, @NonNull ag agVar, @Nullable ou ouVar, @Nullable ay ayVar) {
        this.a = oqVar;
        this.b = aVar;
        this.c = agVar;
        this.d = ouVar;
        this.e = ayVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.d != null && this.a.e()) {
            ay ayVar = this.e;
            if (ayVar != null) {
                ayVar.c();
            }
            this.b.a(view.getContext(), this.d, this.c);
        }
    }
}
