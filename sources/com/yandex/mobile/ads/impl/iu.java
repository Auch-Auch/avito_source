package com.yandex.mobile.ads.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.google.android.gms.ads.AdError;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
public abstract class iu extends ev implements jp {
    @NonNull
    private final jq a = new jq(this);
    @Nullable
    private Map<String, String> b;
    @NonNull
    public final x f;

    public class a {
        public final WeakReference<Context> a;

        public a(Context context) {
            this.a = new WeakReference<>(context);
        }

        @JavascriptInterface
        public final String getBannerInfo() {
            return "{\"isDelicate\": false}";
        }

        @JavascriptInterface
        public final void onAdRender(int i, String str) {
            iu.this.a.a(i, str);
        }
    }

    public iu(@NonNull Context context, @NonNull x xVar) {
        super(context);
        this.f = xVar;
        a(context);
    }

    @SuppressLint({"AddJavascriptInterface"})
    public abstract void a(@NonNull Context context);

    @Override // com.yandex.mobile.ads.impl.jp
    public final void b(int i, String str) {
        a(i, str);
        super.d();
    }

    @Override // com.yandex.mobile.ads.impl.ev, com.yandex.mobile.ads.impl.eq
    public final void d() {
        if (i()) {
            this.a.a();
        } else {
            super.d();
        }
    }

    @Override // com.yandex.mobile.ads.impl.ev, com.yandex.mobile.ads.impl.ac
    public final void g() {
        this.a.b();
        super.g();
    }

    public final boolean i() {
        return "partner-code".equals(this.f.l());
    }

    @NonNull
    public final Map<String, String> j() {
        Map<String, String> map = this.b;
        return map != null ? map : Collections.emptyMap();
    }

    @Override // android.webkit.WebView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        a("AdPerformActionsJSI");
        super.onConfigurationChanged(configuration);
    }

    @Override // com.yandex.mobile.ads.impl.ev
    public void setHtmlWebViewListener(@NonNull er erVar) {
        super.setHtmlWebViewListener(erVar);
        this.a.a(erVar);
    }

    public void a(int i, String str) {
        if (!TextUtils.isEmpty(str) && !AdError.UNDEFINED_DOMAIN.equals(str)) {
            HashMap hashMap = new HashMap();
            this.b = hashMap;
            hashMap.put("test-tag", str);
        }
    }

    @Override // com.yandex.mobile.ads.impl.ev, com.yandex.mobile.ads.impl.ac
    public String b() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.b());
        sb.append(i() ? ew.c : "");
        return sb.toString();
    }
}
