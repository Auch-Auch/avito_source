package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.MobileAds;
public final class dc implements db<fz> {
    @NonNull
    private final Context a;
    @NonNull
    private final da b = new da();
    @NonNull
    private final dd c = new dd();
    @NonNull
    private final df d = new df();
    @NonNull
    private final ce<fz> e = new cg();

    public dc(@NonNull Context context) {
        this.a = context.getApplicationContext();
    }

    @Override // com.yandex.mobile.ads.impl.db
    public final boolean a() {
        fz a3 = fy.a().a(this.a);
        if (a3 != null) {
            if (!(System.currentTimeMillis() >= a3.b()) && !(!MobileAds.getLibraryVersion().equals(a3.m()))) {
                if (!(fy.a().e() != a3.e())) {
                    return false;
                }
            }
        }
        return true;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.yandex.mobile.ads.impl.db
    @Nullable
    public final /* synthetic */ fz a(@NonNull rx rxVar) {
        return this.e.b(rxVar);
    }
}
