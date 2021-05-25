package com.yandex.mobile.ads.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebSettings;
import com.yandex.mobile.ads.impl.ah;
import com.yandex.mobile.ads.impl.iw;
public abstract class ev extends ac implements ah.b, eq, iw.a {
    private static boolean a = false;
    @NonNull
    private final iw b = new iw();
    @Nullable
    public er e;
    @NonNull
    private final kc f = new kc();
    @NonNull
    private final ah g = ah.a();
    @NonNull
    private final ic h = new ic();
    private boolean i;
    private boolean j;

    public ev(@NonNull Context context) {
        super(context.getApplicationContext());
        a_(context);
        if (!a) {
            getContext();
            a = true;
        }
    }

    public abstract void a();

    @Override // com.yandex.mobile.ads.impl.eq
    public final void a(@NonNull Context context, @NonNull String str) {
        er erVar = this.e;
        if (erVar != null) {
            erVar.a(str);
        }
    }

    @Override // com.yandex.mobile.ads.impl.ac
    @SuppressLint({"SetJavaScriptEnabled"})
    public void a_(Context context) {
        super.a_(context);
        setBackgroundColor(0);
        setVisibility(4);
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        setScrollBarStyle(0);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
        settings.setMinimumFontSize(1);
        settings.setMinimumLogicalFontSize(1);
        if (id.a(21)) {
            settings.setMixedContentMode(0);
        }
        settings.setMediaPlaybackRequiresUserGesture(false);
        WebSettings settings2 = getSettings();
        fz a3 = fy.a().a(context);
        if (a3 != null && a3.i()) {
            settings2.setUserAgentString(ic.a(context));
        }
        setWebViewClient(new ep(this));
        setWebChromeClient(new eo());
    }

    @Override // com.yandex.mobile.ads.impl.ac
    public String b() {
        return super.b() + "<style type='text/css'> \n  * { \n      -webkit-tap-highlight-color: rgba(0, 0, 0, 0) !important; \n      -webkit-focus-ring-color: rgba(0, 0, 0, 0) !important; \n      outline: none !important; \n    } \n</style> \n" + ew.d;
    }

    @Override // com.yandex.mobile.ads.impl.eq
    public void d() {
        this.f.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.ev.1
            @Override // java.lang.Runnable
            public final void run() {
                ev.this.a();
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.ac
    public void g() {
        this.e = null;
        super.g();
    }

    @Override // com.yandex.mobile.ads.impl.iw.a
    public final boolean h() {
        return this.j;
    }

    @Override // android.webkit.WebView, android.view.View, android.view.ViewGroup
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.j = true;
        this.g.a(this, getContext());
        a(iw.a(this));
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onDetachedFromWindow() {
        this.j = false;
        a(iw.a(this));
        this.g.b(this, getContext());
        super.onDetachedFromWindow();
    }

    @Override // android.webkit.WebView, android.view.View
    public void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        a(iw.a(this));
    }

    @Override // android.webkit.WebView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        a(iw.a(this));
    }

    public void setHtmlWebViewListener(@NonNull er erVar) {
        this.e = erVar;
    }

    @Override // com.yandex.mobile.ads.impl.ah.b
    public final void a(@NonNull Intent intent) {
        a(!"android.intent.action.SCREEN_OFF".equals(intent.getAction()) && iw.a(this) && this.g.a(getContext()));
    }

    private void a(boolean z) {
        if (this.i != z) {
            this.i = z;
            er erVar = this.e;
            if (erVar != null) {
                erVar.b(z);
            }
        }
    }
}
