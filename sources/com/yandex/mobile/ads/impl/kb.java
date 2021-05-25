package com.yandex.mobile.ads.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.webkit.WebSettings;
import com.yandex.mobile.ads.impl.iu;
import java.io.File;
@SuppressLint({"ViewConstructor"})
public class kb extends iu {
    @NonNull
    private final ex a = new ex(this);

    public kb(@NonNull Context context, @NonNull x xVar) {
        super(context, xVar);
    }

    @Override // com.yandex.mobile.ads.impl.iu
    @SuppressLint({"AddJavascriptInterface"})
    public final void a(@NonNull Context context) {
        addJavascriptInterface(new iu.a(context), "AdPerformActionsJSI");
    }

    @Override // com.yandex.mobile.ads.impl.ev, com.yandex.mobile.ads.impl.ac
    public final void a_(Context context) {
        super.a_(context);
        WebSettings settings = getSettings();
        settings.setAppCachePath(new File(getContext().getCacheDir(), "com.yandex.mobile.ads.cache").getAbsolutePath());
        settings.setDatabasePath(getContext().getDatabasePath("com.yandex.mobile.ads.db").getAbsolutePath());
        settings.setAppCacheMaxSize(8388608);
        settings.setAppCacheEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setCacheMode(-1);
    }

    @Override // com.yandex.mobile.ads.impl.ev
    public void a() {
        this.a.a(j());
    }
}
