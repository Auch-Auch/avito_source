package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.IReporter;
import com.yandex.metrica.p;
import com.yandex.mobile.ads.impl.ak;
public final class hu implements ak.a {
    @NonNull
    private final gh a = new gh();
    @NonNull
    private final fy b = fy.a();
    @Nullable
    private IReporter c;

    public hu(@NonNull ak akVar) {
        akVar.a(this);
    }

    public final boolean a(@NonNull Context context) {
        fz a3 = this.b.a(context);
        return a3 != null && a3.d();
    }

    public final void a(@Nullable IReporter iReporter) {
        this.c = iReporter;
    }

    @Override // com.yandex.mobile.ads.impl.ak.a
    public final void a(@NonNull Context context, @NonNull fz fzVar) {
        if (this.c != null) {
            this.c.setStatisticsSending(fzVar.d());
        }
        boolean z = a(context) && this.b.b();
        try {
            if (Cif.b(p.class, "slte", context)) {
                p.slte(context, z);
            }
        } catch (Throwable unused) {
        }
    }
}
