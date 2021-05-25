package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebView;
public final class zzbzq implements zzsq {
    private zzdsk zzfuq;

    @Override // com.google.android.gms.internal.ads.zzsq
    public final View getView() {
        return this.zzfuq;
    }

    @Override // com.google.android.gms.internal.ads.zzsq
    public final WebView getWebView() {
        if (this.zzfuq == null) {
            return null;
        }
        return zzdsk.getWebView();
    }

    @Override // com.google.android.gms.internal.ads.zzsq
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (this.zzfuq != null) {
            zzdsk.onPageStarted(webView, str, bitmap);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsq
    public final void zza(Activity activity, WebView webView) {
        try {
            this.zzfuq = new zzdsk(activity, webView);
        } catch (RuntimeException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(valueOf.length() + 46);
            sb.append(" Failed to initialize the internal ArWebView: ");
            sb.append(valueOf);
            zzbbd.zzfc(sb.toString());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsq
    public final void zzc(String str, String str2) {
        if (this.zzfuq == null) {
            zzbbd.zzfc("ArWebView is not initialized.");
        } else {
            zzdsk.getWebView().loadDataWithBaseURL(str, str2, "text/html", "UTF-8", null);
        }
    }
}
