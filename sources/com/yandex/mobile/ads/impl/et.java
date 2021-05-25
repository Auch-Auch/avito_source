package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.webkit.WebView;
import com.yandex.mobile.ads.AdRequestError;
import java.util.Collections;
import java.util.Map;
public final class et implements er {
    @NonNull
    private final ev a;
    @NonNull
    private final at b;
    @NonNull
    private final ei c = new ei();
    @NonNull
    private final ex d;
    @NonNull
    private final jb e = new jb();
    @Nullable
    private nb f;

    public et(@NonNull es esVar, @NonNull at atVar) {
        this.a = esVar;
        this.b = atVar;
        this.d = new ex(esVar);
    }

    @Override // com.yandex.mobile.ads.impl.er
    public final void a(@Nullable WebView webView, @Nullable Map<String, String> map) {
    }

    public final void a(@NonNull nb nbVar) {
        this.f = nbVar;
    }

    public final void b(@NonNull String str) {
        boolean a3 = jb.a(str);
        je.a();
        je.a(a3).a(this.a, this, this.c, this.b).a(str);
    }

    @Override // com.yandex.mobile.ads.impl.er
    public final void b(boolean z) {
    }

    @Override // com.yandex.mobile.ads.impl.er
    public final void onAdFailedToLoad(@NonNull AdRequestError adRequestError) {
    }

    @Override // com.yandex.mobile.ads.impl.er
    public final void onAdLoaded() {
    }

    public final void a() {
        this.d.a(Collections.emptyMap());
    }

    @Override // com.yandex.mobile.ads.impl.er
    public final void a(@NonNull String str) {
        nb nbVar = this.f;
        if (nbVar != null) {
            nbVar.a(this.a, str);
        }
    }
}
