package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.webkit.WebView;
import com.yandex.mobile.ads.AdRequestError;
import java.util.Map;
public interface er {
    void a(@Nullable WebView webView, @Nullable Map<String, String> map);

    void a(@NonNull String str);

    void b(boolean z);

    void onAdFailedToLoad(@NonNull AdRequestError adRequestError);

    void onAdLoaded();
}
