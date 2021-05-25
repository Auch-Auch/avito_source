package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.List;
public final class qu {
    @NonNull
    private final rg a;
    @NonNull
    private final qt b = new qt();

    public qu(@NonNull Context context) {
        this.a = new rg(context);
    }

    @Nullable
    public final Intent a(@NonNull List<pf> list) {
        for (pf pfVar : list) {
            Intent a3 = qt.a(pfVar);
            if (this.a.a(a3)) {
                return a3;
            }
        }
        return null;
    }
}
