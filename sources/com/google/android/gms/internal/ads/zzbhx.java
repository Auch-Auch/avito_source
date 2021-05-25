package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.webkit.ValueCallback;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
@ParametersAreNonnullByDefault
public class zzbhx extends zzbhs implements zzbhy {
    @GuardedBy("this")
    private boolean zzeoa;
    @GuardedBy("this")
    private boolean zzeot;
    private final zzbhv zzepz;

    public zzbhx(Context context, zzbhv zzbhv) {
        super(context);
        zzp.zzkt().zzwg();
        this.zzepz = zzbhv;
        super.setWebViewClient(zzbhv);
    }

    private final synchronized void zzwh() {
        if (!this.zzeot) {
            this.zzeot = true;
            zzp.zzkt().zzwh();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhs, android.webkit.WebView
    public /* bridge */ /* synthetic */ void addJavascriptInterface(Object obj, String str) {
        super.addJavascriptInterface(obj, str);
    }

    @Override // android.webkit.WebView
    public synchronized void destroy() {
        if (!this.zzeoa) {
            this.zzeoa = true;
            this.zzepz.zza(this);
            zzbe(false);
            zzaxy.zzei("Initiating WebView self destruct sequence in 3...");
            zzaxy.zzei("Loading blank page in WebView, 2...");
            try {
                super.loadUrl("about:blank");
            } catch (UnsatisfiedLinkError e) {
                zzp.zzkt().zza(e, "AdWebViewImpl.loadUrlUnsafe");
                zzbbd.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // android.webkit.WebView
    @TargetApi(19)
    public synchronized void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (isDestroyed()) {
            zzbbd.zzfe("#004 The webview is destroyed. Ignoring action.");
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
            }
            return;
        }
        super.evaluateJavascript(str, valueCallback);
    }

    @Override // java.lang.Object
    public void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (!isDestroyed()) {
                    zzbe(true);
                }
                zzwh();
            }
        } finally {
            super.finalize();
        }
    }

    public final synchronized boolean isDestroyed() {
        return this.zzeoa;
    }

    @Override // android.webkit.WebView
    public synchronized void loadData(String str, String str2, String str3) {
        if (!isDestroyed()) {
            super.loadData(str, str2, str3);
        } else {
            zzbbd.zzfe("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // android.webkit.WebView
    public synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!isDestroyed()) {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            zzbbd.zzfe("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhs, android.webkit.WebView
    public synchronized void loadUrl(String str) {
        if (!isDestroyed()) {
            super.loadUrl(str);
        } else {
            zzbbd.zzfe("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // android.webkit.WebView, android.view.View
    @TargetApi(21)
    public void onDraw(Canvas canvas) {
        if (!isDestroyed()) {
            super.onDraw(canvas);
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbfq
    public void onPause() {
        if (!isDestroyed()) {
            super.onPause();
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbfq
    public void onResume() {
        if (!isDestroyed()) {
            super.onResume();
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return !isDestroyed() && super.onTouchEvent(motionEvent);
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
    }

    @Override // android.webkit.WebView
    public void stopLoading() {
        if (!isDestroyed()) {
            super.stopLoading();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhy
    public final synchronized void zza(zzbhu zzbhu) {
        zzaxy.zzei("Blank page loaded, 1...");
        zzabk();
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    @VisibleForTesting
    public synchronized void zzabk() {
        zzaxy.zzei("Destroying WebView!");
        zzwh();
        zzbbi.zzedy.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbhw
            private final zzbhx zzepy;

            {
                this.zzepy = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzepy.zzadb();
            }
        });
    }

    public final /* synthetic */ void zzadb() {
        super.destroy();
    }

    @GuardedBy("this")
    public void zzbe(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzbhs, com.google.android.gms.internal.ads.zzajs, com.google.android.gms.internal.ads.zzakh
    public /* bridge */ /* synthetic */ void zzdc(String str) {
        super.zzdc(str);
    }
}
