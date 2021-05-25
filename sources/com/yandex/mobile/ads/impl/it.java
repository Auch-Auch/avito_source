package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.yandex.mobile.ads.b;
public abstract class it extends ab<String> implements er {
    @Nullable
    private ja h;

    public it(@NonNull Context context, @NonNull b bVar) {
        super(context, bVar);
    }

    @Override // com.yandex.mobile.ads.impl.ab
    @NonNull
    public final bx<String> a(String str, String str2) {
        return new jm(this.b, this.f, str, str2, this);
    }

    public abstract ja a(@NonNull String str, @NonNull x<String> xVar, @NonNull am amVar);

    public abstract boolean a(@NonNull am amVar);

    public void b(@NonNull x<String> xVar) {
        am b = this.f.b();
        if (b == null) {
            onAdFailedToLoad(v.d);
        } else if (!a(xVar.e(), b)) {
            onAdFailedToLoad(v.c);
        } else {
            String p = xVar.p();
            if (!TextUtils.isEmpty(p)) {
                ja a = a(p, xVar, b);
                this.h = a;
                a.a(p);
                return;
            }
            onAdFailedToLoad(v.e);
        }
    }

    @Override // com.yandex.mobile.ads.impl.er
    public final void b(boolean z) {
    }

    @Override // com.yandex.mobile.ads.impl.ab
    public final void c(@NonNull ds dsVar) {
        a(this.f.c(), dsVar);
    }

    @Override // com.yandex.mobile.ads.impl.ab
    public void d() {
        super.d();
        ja jaVar = this.h;
        if (jaVar != null) {
            jaVar.b();
        }
        this.h = null;
    }

    public final boolean a(@NonNull am amVar, @NonNull am amVar2) {
        return a(amVar) && ju.a(this.b, amVar, amVar2);
    }
}
