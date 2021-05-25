package com.yandex.mobile.ads.impl;

import a2.b.a.a.a;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.HashMap;
import java.util.Map;
public abstract class ac extends WebView {
    @Nullable
    public Map<String, Object> c;
    public Integer d = null;

    public ac(Context context) {
        super(context);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        if (id.a(11)) {
            settings.setAllowContentAccess(false);
            if (id.a(16)) {
                settings.setAllowFileAccessFromFileURLs(false);
                settings.setAllowUniversalAccessFromFileURLs(false);
            }
        }
    }

    @Nullable
    public final Object a(@NonNull String str) {
        Map<String, Object> map = this.c;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public void a_(Context context) {
    }

    @Override // android.webkit.WebView
    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
    public void addJavascriptInterface(Object obj, String str) {
        super.addJavascriptInterface(obj, str);
        if (this.c == null) {
            this.c = new HashMap();
        }
        this.c.put(str, obj);
    }

    public String b() {
        return "";
    }

    public final void b(String str) {
        StringBuilder L = a.L(str);
        L.append(b());
        L.append("<body style='margin:0; padding:0;'>");
        loadDataWithBaseURL("https://yandex.ru", L.toString(), "text/html", "UTF-8", null);
    }

    @TargetApi(11)
    public final void b_() {
        if (id.a(11)) {
            getSettings().setDisplayZoomControls(false);
        }
    }

    public final void e() {
        dt.a((WebView) this);
        getClass().toString();
    }

    public final void f() {
        dt.b(this);
        getClass().toString();
    }

    public void g() {
        eg.a(this);
        Map<String, Object> map = this.c;
        if (map != null) {
            for (String str : map.keySet()) {
                removeJavascriptInterface(str);
            }
            this.c.clear();
        }
        destroy();
        getClass().toString();
    }

    @Override // android.webkit.WebView
    @TargetApi(11)
    public void removeJavascriptInterface(String str) {
        if (id.a(11)) {
            super.removeJavascriptInterface(str);
        }
    }
}
