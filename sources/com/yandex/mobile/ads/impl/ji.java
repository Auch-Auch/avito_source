package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.webkit.WebView;
import com.yandex.mobile.ads.AdRequestError;
import java.util.Map;
public final class ji implements er {
    private final fa a;
    private final er b;

    public ji(@NonNull fa faVar, @NonNull er erVar) {
        this.a = faVar;
        this.b = erVar;
    }

    @Override // com.yandex.mobile.ads.impl.er
    public final void a(@Nullable WebView webView, @Nullable Map<String, String> map) {
        this.b.a(webView, map);
    }

    @Override // com.yandex.mobile.ads.impl.er
    public final void b(boolean z) {
        this.a.a(z);
    }

    @Override // com.yandex.mobile.ads.impl.er
    public final void onAdFailedToLoad(@NonNull AdRequestError adRequestError) {
        this.b.onAdFailedToLoad(adRequestError);
    }

    @Override // com.yandex.mobile.ads.impl.er
    public final void onAdLoaded() {
        this.a.a();
    }

    @Override // com.yandex.mobile.ads.impl.er
    public final void a(@NonNull String str) {
        this.a.b(str);
    }
}
