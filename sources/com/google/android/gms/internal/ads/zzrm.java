package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;
public final class zzrm implements Runnable {
    public final /* synthetic */ zzrk zzbta;
    private ValueCallback<String> zzbto = new zzrl(this);
    public final /* synthetic */ zzre zzbtp;
    public final /* synthetic */ WebView zzbtq;
    public final /* synthetic */ boolean zzbtr;

    public zzrm(zzrk zzrk, zzre zzre, WebView webView, boolean z) {
        this.zzbta = zzrk;
        this.zzbtp = zzre;
        this.zzbtq = webView;
        this.zzbtr = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzbtq.getSettings().getJavaScriptEnabled()) {
            try {
                this.zzbtq.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zzbto);
            } catch (Throwable unused) {
                this.zzbto.onReceiveValue("");
            }
        }
    }
}
