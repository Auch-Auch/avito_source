package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.webkit.WebView;
import com.yandex.mobile.ads.AdRequestError;
import java.util.Map;
public final class ip implements er {
    @NonNull
    private final er a;

    public ip(@NonNull er erVar) {
        this.a = erVar;
    }

    @Override // com.yandex.mobile.ads.impl.er
    public final void a(@Nullable WebView webView, @Nullable Map<String, String> map) {
    }

    @Override // com.yandex.mobile.ads.impl.er
    public final void a(@NonNull String str) {
    }

    @Override // com.yandex.mobile.ads.impl.er
    public final void b(boolean z) {
    }

    @Override // com.yandex.mobile.ads.impl.er
    public final void onAdFailedToLoad(@NonNull AdRequestError adRequestError) {
        this.a.onAdFailedToLoad(adRequestError);
    }

    @Override // com.yandex.mobile.ads.impl.er
    public final void onAdLoaded() {
        this.a.onAdLoaded();
    }
}
